/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorConta;
import controlador.ControladorTransacao;
import front.Formulario;
import java.util.ArrayList;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class App {
    
    private final Formulario formulario = Formulario.getInstance();
    private final ControladorConta controladorConta = ControladorConta.getInstance();
    private final ControladorTransacao controladorTransacao = ControladorTransacao.getInstance();
    
    private boolean sair;

    public App() {
        this.sair = false;
    }

    public void executar() {
        int opcao;
        do {
            opcao = formulario.imprimirMenu();
            
            switch(opcao) {
                case 1 -> this.criarConta();
                case 2 -> this.listarContas();
                case 3 -> this.realizarTransacao();
                case 4 -> this.listarTransacoes();
                case 0 -> this.sair();
                default -> System.out.println("Opcao Invalida!");
            }
        } while (!this.isSair());
    }
    
    public void criarConta() {
        ArrayList<String> dadosConta = formulario.imprimirConta();
        controladorConta.criarConta(dadosConta);
    }
    
    public void listarContas() {
        controladorConta.listarContas();
    }
    
    public void realizarTransacao() {
        ArrayList<String> dadosTransacao = formulario.imprimirTransacao();
        controladorTransacao.realizarTransacao(dadosTransacao);
    }
    
    public void listarTransacoes() {
        controladorTransacao.listarTransacoes();
    }
    
    public void sair() {
        System.out.println("Encerrando...");
        this.setSair(true);
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }    
}
