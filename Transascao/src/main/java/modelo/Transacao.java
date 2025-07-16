    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Transacao {
    private Conta conta1;
    private Conta conta2;
    private double valor;
    private LocalDateTime data;

    public Transacao(Conta conta1, Conta conta2, double valor) {
        this.conta1 = conta1;
        this.conta2 = conta2;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Conta getConta1() {
        return conta1;
    }

    public void setConta1(Conta conta1) {
        this.conta1 = conta1;
    }

    public Conta getConta2() {
        return conta2;
    }

    public void setConta2(Conta conta2) {
        this.conta2 = conta2;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Contas: " + conta1 + " & " + conta2 + " | Valor: R$ " + valor + " | Horario: " + data;
    }
}
