package app;

import controlador.ControladorConta;
import controlador.ControladorTransacao;
import front.Formulario;
import front.Logger;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class App {
    
    private final Formulario formulario;
    private final ControladorConta controladorConta;
    private final ControladorTransacao controladorTransacao;
    private final Logger log = Logger.getInstance();
    
    private boolean continuar;

    public App() {
        this.controladorConta = new ControladorConta();
        this.controladorTransacao = new ControladorTransacao(controladorConta);
        this.formulario = new Formulario(controladorConta);
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
