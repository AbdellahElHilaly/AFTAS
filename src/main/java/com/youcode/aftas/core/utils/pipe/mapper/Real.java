package com.youcode.aftas.core.utils.pipe.mapper;

public class Real{

    public Double value;

    public String dirham(){
        return toDirham(value) + " DH";
    }

    public String real(){
        return value + " R";
    }

    private Double toDirham(Double value) {
        return value / 20;
    }

    public Double toReal(Double value) {
        return value * 20;
    }
    
}
