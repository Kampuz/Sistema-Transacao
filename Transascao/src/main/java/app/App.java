package app;

import controlador.ControladorConta;
import controlador.ControladorTransacao;
import front.Formulario;
import front.Logger;
import java.util.ArrayList;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class App {
    
    private final Formulario formulario = Formulario.getInstance();
    private final ControladorConta controladorConta = ControladorConta.getInstance();
    private final ControladorTransacao controladorTransacao = ControladorTransacao.getInstance();
    private final Logger log = Logger.getInstance();
    
    private boolean continuar;

    public App() {
        this.continuar = true;
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
                default -> log.error("Opcao Invalida.");
            }
        } while (this.isContinuar());
    }
    
    public void criarConta() {
        formulario.imprimirCriacaoConta();
        String novaChave = formulario.pedirChaveCriacao();
        double saldo = formulario.pedirValorSaldo();
        controladorConta.criarConta(novaChave, saldo);
    }
    
    public void listarContas() {
        controladorConta.listarContas();
    }
    
    public void realizarTransacao() {
        formulario.imprimirTransacao();
        String chaveUsuario = formulario.pedirChaveTransacao();
        String chaveRecebedor = formulario.pedirChaveTransacao();
        double valor = formulario.pedirValorTransacao();
        controladorTransacao.realizarTransacao(chaveUsuario, chaveRecebedor, valor);
    }
    
    public void listarTransacoes() {
        controladorTransacao.listarTransacoes();
    }
    
    public void sair() {
        log.info("Saindo...");
        this.setContinuar(false);
    }

    public boolean isContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }    
}
