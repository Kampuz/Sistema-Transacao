/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Conta {

    private final String chave;
    private double saldo;

    public Conta(String chave, double saldo) {
        this.chave = chave;
        this.saldo = saldo;
    }

    public boolean debitar(double valor) {
        if (valor > this.getSaldo()) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getChave() {
        return chave;
    }

    @Override
    public String toString() {
        return "Conta #" + chave + " | Saldo: R$ " + saldo;
    }
}
