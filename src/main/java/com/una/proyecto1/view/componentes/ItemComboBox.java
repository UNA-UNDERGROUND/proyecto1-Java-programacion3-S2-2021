package com.una.proyecto1.view.componentes;

public class ItemComboBox<T> {
    public ItemComboBox(T objeto) {
        this.objeto = objeto;
    }

    public T getValor() {
        return objeto;
    }

    @Override
    public String toString() {
        return objeto.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other != null) {
            try {
                ItemComboBox<T> obj = this.getClass().cast(other);
                return objeto.equals(obj.objeto);
            } catch (ClassCastException e) {
                return objeto.equals(other);
            }
        }
        return false;
    }

    private T objeto;
}
