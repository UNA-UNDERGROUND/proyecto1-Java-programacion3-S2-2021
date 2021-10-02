package com.una.proyecto1.view.componentes;

public class ItemComboBox<T> {
    ItemComboBox(T objeto) {
        this.objeto = objeto;
    }

    public T getValor() {
        return objeto;
    }

    @Override
    public String toString() {
        return objeto.toString();
    }

    private T objeto;
}
