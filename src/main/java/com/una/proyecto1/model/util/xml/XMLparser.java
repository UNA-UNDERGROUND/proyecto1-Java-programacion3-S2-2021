package com.una.proyecto1.model.util.xml;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLparser {
    public static <T> void marshall(Object obj, String rutaArchivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, new FileOutputStream(rutaArchivo));
        } catch (Exception ex) {
            ex.printStackTrace();
            // System.err.println(ex.getLocalizedMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(T ref, String rutaArchivo, Boolean interno) {
        try {
            JAXBContext context = JAXBContext.newInstance(ref.getClass());
            Unmarshaller unmarshallerObj = context.createUnmarshaller();
            BufferedInputStream stream;
            if (interno) {
                stream = new BufferedInputStream(ClassLoader.getSystemResource(rutaArchivo).openStream());
            } else {
                stream = new BufferedInputStream(new FileInputStream(rutaArchivo));
            }
            return (T) unmarshallerObj.unmarshal(stream);
        } catch (FileNotFoundException ex) {
            System.err.println("[WARN] Archivo no encontrado, omitiendo.");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("[WARN] Archivo incorrecto, omitiendo.");
        }
        return ref;
    }
}
