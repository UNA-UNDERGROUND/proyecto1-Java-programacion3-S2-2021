package com.una.proyecto1.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.una.proyecto1.model.logica.cliente.Cliente;
import com.una.proyecto1.model.logica.prestamo.Mensualidad;
import com.una.proyecto1.model.logica.prestamo.Prestamo;
import com.una.proyecto1.model.logica.ubicacion.Canton;
import com.una.proyecto1.model.logica.ubicacion.Distrito;
import com.una.proyecto1.model.logica.ubicacion.Provincia;
import com.una.proyecto1.model.logica.ubicacion.Provincias;
import com.una.proyecto1.model.mapa.CodigoProvincia;
import com.una.proyecto1.model.mapa.Mapa;
import com.una.proyecto1.model.util.Listener;
import com.una.proyecto1.model.util.xml.XMLparser;

public class ControladorPrestamo {

    private ControladorPrestamo() {
        mapa = new Mapa();
        provincias = XMLparser.unmarshall(new Provincias(), "data/provincias.xml", true);
    }

    // -- Informacion Provincias --

    public List<Provincia> getProvincias() {
        return provincias.getProvincias();
    }

    public List<Canton> getCantones(Integer idProvincia) {
        return provincias.getCantones(idProvincia);
    }

    public List<Distrito> getDistritos(Integer idProvincia, Integer idCanton) {
        return provincias.getDistritos(idProvincia, idCanton);
    }

    // -- Mapa --

    public String getProvinciaActual() {
        return CodigoProvincia.values()[provinciaSelec].getNombre();
    }

    public int getCodigoProvincia() {
        return provinciaSelec;
    }

    public void setCodigoProvincia(int provinciaSelec) {
        this.provinciaSelec = provinciaSelec;
        if (provinciaListener != null) {
            provinciaListener.notificar();
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    // -- Cliente --

    public boolean agregarCliente(Integer id, String nombre, String provincia, Canton canton, Distrito distrito) {
        if (recuperarCliente(id) == null) {
            clientes.add(new Cliente(id, nombre, provincia, canton, distrito));
            return true;
        }
        return false;

    }

    public Cliente recuperarCliente(Integer id) {
        for (Cliente actual : clientes) {
            if (actual.getId().equals(id)) {
                return actual;
            }
        }
        return null;
    }

    public boolean agregarPrestamo(Integer id, double monto, int plazo, double tasa) {
        if (recuperarCliente(id) != null) {
            prestamos.add(new Prestamo(id, monto, plazo, tasa));
            return true;
        }
        return false;

    }

    public List<Prestamo> recuperarPrestamos(Integer idCliente) {
        List<Prestamo> resultado = new ArrayList<>();
        for (Prestamo actual : prestamos) {
            if (actual.getIdCliente().equals(idCliente)) {
                resultado.add(actual);
            }
        }
        return resultado;
    }

    public Prestamo recuperarPrestamo(Integer idCliente, int numero) {
        List<Prestamo> resultado = recuperarPrestamos(idCliente);
        if (resultado.size() > numero) {
            return resultado.get(numero);
        }
        return null;
    }

    public boolean agregarMensualidad(Integer idCliente, int numero, double saldo) {
        return agregarMensualidad(idCliente, numero, saldo, new Date());
    }

    public boolean agregarMensualidad(Integer idCliente, int numero, double saldo, Date fecha) {
        Prestamo prestamo = recuperarPrestamo(idCliente, numero);
        // nota: no se toman en cuenta cuotas con menor saldo al establecido
        if (prestamo != null) {
            prestamo.agregarMensualidad(saldo, fecha);
            return true;
        }
        return false;
    }

    public List<Mensualidad> recuperarMensualidades(Integer idCliente, int numero) {
        List<Prestamo> resultado = recuperarPrestamos(idCliente);
        if (resultado.size() > numero) {
            return resultado.get(numero).getMensualidades();
        }
        return new ArrayList<>();
    }

    private PdfDocument generarDocumentoPDF(String ubicacion) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(ubicacion);
        PdfWriter writer = new PdfWriter(fos);
        return new PdfDocument(writer);
    }

    public boolean generarReporteClientes(String ubicacion) {
        try {
            PdfDocument pdf = generarDocumentoPDF(ubicacion);

            Document document = new Document(pdf);

            // Id, Nombre, Provincia, canton, distrito
            float[] longitudColumnas = { 150F, 150f, 150F, 150F, 150F };
            Table tablaClientes = new Table(longitudColumnas);

            // titulo
            tablaClientes.addCell(new Cell().add(new Paragraph("ID")));
            tablaClientes.addCell(new Cell().add(new Paragraph("Nombre")));
            tablaClientes.addCell(new Cell().add(new Paragraph("Provincia")));
            tablaClientes.addCell(new Cell().add(new Paragraph("Cantón")));
            tablaClientes.addCell(new Cell().add(new Paragraph("Distrito")));

            // datos de la tabla
            for (Cliente cliente : clientes) {
                tablaClientes.addCell(new Cell().add(new Paragraph(cliente.getId().toString())));
                tablaClientes.addCell(new Cell().add(new Paragraph(cliente.getNombre())));
                tablaClientes.addCell(new Cell().add(new Paragraph(cliente.getProvincia())));
                tablaClientes.addCell(new Cell().add(new Paragraph(cliente.getCanton().getNombre())));
                tablaClientes.addCell(new Cell().add(new Paragraph(cliente.getDistrito().getNombre())));
            }

            document.add(new Paragraph("Listado de clientes"));
            document.add(tablaClientes);
            document.close();
            return true;
        } catch (Exception e) {
            // TODO generar mensaje aca
            return false;
        }

    }

    public boolean generarReportePrestamos(String ubicacion, Integer idCliente) {

        try {
            PdfDocument pdf = generarDocumentoPDF(ubicacion);

            Document document = new Document(pdf);

            float[] longitudColumnas = { 150F, 150f, 150F, 150F };
            Table tablaPrestamos = new Table(longitudColumnas);

            // Titulo

            tablaPrestamos.addCell(new Cell().add(new Paragraph("ID")));
            tablaPrestamos.addCell(new Cell().add(new Paragraph("Monto")));
            tablaPrestamos.addCell(new Cell().add(new Paragraph("Plazo")));
            tablaPrestamos.addCell(new Cell().add(new Paragraph("Tasa")));

            // datos de tabla
            for (Prestamo prestamo : prestamos) {
                tablaPrestamos.addCell(new Cell().add(new Paragraph(prestamo.getIdCliente().toString())));
                tablaPrestamos.addCell(new Cell().add(new Paragraph(Double.valueOf(prestamo.getMonto()).toString())));
                tablaPrestamos.addCell(new Cell().add(new Paragraph(Integer.valueOf(prestamo.getPlazo()).toString())));
                tablaPrestamos.addCell(new Cell().add(new Paragraph(Double.valueOf(prestamo.getTasa()).toString())));

            }

            document.add(new Paragraph("Listado de clientes"));
            document.add(tablaPrestamos);
            document.close();
            return true;
        } catch (Exception e) {
            // TODO generar mensaje aca
            return false;
        }

    }

    public boolean generarReportePagos(String ubicacion, Integer idCliente, Integer numeroPago) {
        // TODO: por implementar
        Prestamo prestamo = recuperarPrestamo(idCliente, numeroPago);
        if (prestamo != null) {
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

                PdfDocument pdf = generarDocumentoPDF(ubicacion);

                Document document = new Document(pdf);
                // numero, saldo, tasa, cuota, fecha
                float[] longitudColumnas = { 150F, 150f, 150F, 150F, 150F };
                Table tablaPagos = new Table(longitudColumnas);

                tablaPagos.addCell(new Cell().add(new Paragraph("Numero")));
                tablaPagos.addCell(new Cell().add(new Paragraph("Saldo")));
                tablaPagos.addCell(new Cell().add(new Paragraph("Tasa")));
                tablaPagos.addCell(new Cell().add(new Paragraph("Cuota")));
                tablaPagos.addCell(new Cell().add(new Paragraph("Fecha")));

                for (Mensualidad mensualidad : prestamo.getMensualidades()) {
                    tablaPagos.addCell(
                            new Cell().add(new Paragraph(Integer.valueOf(mensualidad.getNumero()).toString())));
                    tablaPagos
                            .addCell(new Cell().add(new Paragraph(Double.valueOf(mensualidad.getSaldo()).toString())));
                    tablaPagos
                            .addCell(new Cell().add(new Paragraph(Double.valueOf(mensualidad.getTasa()).toString())));
                    tablaPagos
                            .addCell(new Cell().add(new Paragraph(Double.valueOf(mensualidad.getCuota()).toString())));
                    tablaPagos.addCell(new Cell().add(new Paragraph(formatoFecha.format(mensualidad.getFecha()))));
                }

                document.add(new Paragraph("Listado de pagos del cliente :" + idCliente.toString()));
                document.add(new Paragraph("Prestamo #"+ numeroPago.toString()));
                document.add(tablaPagos);
                document.close();
                return true;

            } catch (Exception e) {
                // TODO: mostrar mensaje de advertencia
                return false;
            }

        }
        return false;
    }

    private Mapa mapa;
    private int provinciaSelec = 0;
    List<Cliente> clientes = new ArrayList<>();
    Provincias provincias;
    List<Prestamo> prestamos = new ArrayList<>();

    // -- implementacion patrones --

    public void setProvinciaListener(Listener l) {
        this.provinciaListener = l;
    }

    private Listener provinciaListener = null;

    private static ControladorPrestamo instancia = null;

    public static ControladorPrestamo getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrestamo();
        }
        return instancia;
    }
}
