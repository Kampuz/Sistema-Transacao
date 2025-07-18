package controlador;

import catalogo.CatalogoConta;
import front.Logger;
import modelo.Conta;

public class ControladorConta {

    private final CatalogoConta catalogo;
    private static final Logger log = Logger.getInstance();

    public ControladorConta() {
        log.debug("Inicializando Controlador Conta");
        this.catalogo = new CatalogoConta();
    }

    public void criarConta(String chave, double saldo) {
        log.info("Iniciando criacao da conta.");

        log.debug("Dados para criar conta: chave (" + chave + ") & saldo inicial (" + saldo + ")");

        Conta novaConta = new Conta(chave, saldo);
        boolean ok = catalogo.adicionar(novaConta);

        if (ok) {
            log.info("Conta criada com sucesso: " + novaConta);
            System.out.println("Conta criada com sucesso!");
        } else {
            log.error("Falha ao adicionar nova conta: " + novaConta);
            System.out.println("Erro ao criar conta.");
        }
    }

    public void listarContas() {
        catalogo.listar();
    }

    public Conta buscarConta(String chave) {
        log.debug("Buscando conta contendo a chave: " + chave);

        Conta conta = catalogo.buscarPorChave(chave);

        if (conta != null) {
            log.debug("Conta encontrada: " + conta);
        } else {
            log.warn("Conta não encontrada");
        }
        return conta;
    }
}
