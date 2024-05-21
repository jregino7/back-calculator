package com.calculator.Calculator.models;

public class salida {
    public float resultado;

    public String stado;

    public void setResultado(float resultado){this.resultado=resultado;}

    public void setstado(String stado){this.stado=stado;}

    public float getResultado() {
        return this.resultado;
    }

    public String getStado() {return this.stado;}

    public salida() {
        setResultado(0);
        setstado("pending");


    }

}
