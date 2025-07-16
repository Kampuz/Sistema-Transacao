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

    public void criarConta(ArrayList<String> dadosConta) {
        log.info("Iniciando criacao da conta.");
        
        String chave = dadosConta.get(0);
        double saldoInicial = Double.parseDouble(dadosConta.get(1));
        
        log.debug("Dados para criar conta: chave (" + chave + ") & saldo inicial (" + saldoInicial + ")");

        Conta novaConta = new Conta(chave, saldoInicial);
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
            log.warn("Não encontrou conta para atualizar: " + contaAtualizada.getChave());
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
