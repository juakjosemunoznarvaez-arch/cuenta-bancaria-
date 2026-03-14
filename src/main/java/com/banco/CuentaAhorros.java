package com.banco;

public class CuentaAhorros extends Cuenta {

    private boolean activa;

    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        activa = saldo >= 10000;
    }
    
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        }
    }

    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        }
    }
    
    public void extractoMensual() {

        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }

        super.extractoMensual();
        activa = saldo >= 10000;
    }
    
    public void imprimir() {

        super.imprimir();

        System.out.println("Cuenta activa: " + activa);
        System.out.println("Total transacciones: " + (numeroConsignaciones + numeroRetiros));
    }
}