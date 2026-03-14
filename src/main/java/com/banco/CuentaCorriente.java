package com.banco;

public class CuentaCorriente extends Cuenta {

    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
    }

    
    public void retirar(float cantidad) {

        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
        }

        numeroRetiros++;
    }

    
    public void consignar(float cantidad) {

        if (sobregiro > 0) {

            if (cantidad > sobregiro) {
                saldo = cantidad - sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
            }

        } else {
            saldo += cantidad;
        }

        numeroConsignaciones++;
    }

    
    public void imprimir() {
        super.imprimir();
        System.out.println("Sobregiro: " + sobregiro);
    }
}