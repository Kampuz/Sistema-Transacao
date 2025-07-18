package controlador;

import catalogo.CatalogoConta;
import java.util.ArrayList;
import front.Logger;
import modelo.Conta;

public class ControladorConta {
    
    private static ControladorConta instance;
    private final CatalogoConta catalogoConta = CatalogoConta.getInstance();
    private static final Logger log = Logger.getInstance();

    private ControladorConta() {
        log.debug("Inicializando Controlador Conta");
    }
    
    public static ControladorConta getInstance() {
        if (instance == null) {
            instance = new ControladorConta();
        }
        return instance;
    }

    public void criarConta(String chave, double saldo) {
        log.info("Iniciando criacao da conta.");
        
        log.debug("Dados para criar conta: chave (" + chave + ") & saldo inicial (" + saldo + ")");

        Conta novaConta = new Conta(chave, saldo);
        boolean ok = catalogoConta.adicionar(novaConta);
        
        if (ok) {
            log.info("Conta criada com sucesso: " + novaConta);
            System.out.println("Conta criada com sucesso!");
        } else {
            log.error("Falha ao adicionar nova conta: " + novaConta);
            System.out.println("Erro ao criar conta.");
        }
    }
    
    public void atualizarConta(Conta contaAtualizada) {
        log.debug("Atualizando conta: " + contaAtualizada);
        boolean ok = catalogoConta.atualizarConta(contaAtualizada);
        if (ok) {
            log.info("Conta atualizada: " + contaAtualizada);
        } else {
            log.warn("Nao encontrou conta para atualizar: " + contaAtualizada.getChave());
        }
    }

    public void listarContas() {
        catalogoConta.listar();
    }
    
    public Conta buscarConta(String chave) {
        log.debug("Buscando conta contendo a chave: " + chave);
        
        Conta conta = catalogoConta.buscarPorChave(chave);
        
        if (conta != null) {
            log.info("Conta encontrada: " + conta);
        } else {
            log.warn("Conta não encontrada");
        }
        return conta;
    }
}
