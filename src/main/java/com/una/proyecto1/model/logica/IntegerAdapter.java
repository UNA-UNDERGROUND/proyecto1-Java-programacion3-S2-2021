package com.una.proyecto1.model.logica;
import javax.xml.bind.annotation.adapters.XmlAdapter;

    
public class IntegerAdapter extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    @Override
    public String marshal(Integer i) throws Exception {
        return i.toString();
    }
}
    

