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

    private Conta pagador;
    private Conta recebedor;
    private double valor;
    private LocalDateTime horario;

    public Transacao(Conta pagador, Conta recebedor, double valor) {
        this.pagador = pagador;
        this.recebedor = recebedor;
        this.valor = valor;
        this.horario = LocalDateTime.now();
    }

    public Conta getPagador() {
        return pagador;
    }

    public void setPagador(Conta pagador) {
        this.pagador = pagador;
    }

    public Conta getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Conta recebedor) {
        this.recebedor = recebedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Contas: " + pagador + " & " + recebedor + " | Valor: R$ " + valor + " | Horario: " + horario;
    }
}
