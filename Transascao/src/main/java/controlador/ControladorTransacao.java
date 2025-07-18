/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import catalogo.CatalogoTransacao;
import front.Logger;
import modelo.Conta;
import modelo.Transacao;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class ControladorTransacao {
    
    private final ControladorConta controladorConta;
    private final CatalogoTransacao catalogo;
    private static final Logger log = Logger.getInstance();

    public ControladorTransacao(ControladorConta controladorConta) {
        log.debug("Inicializando Controlado Transacao");
        this.controladorConta = controladorConta;
        this.catalogo = new CatalogoTransacao();
    }
    
    public boolean realizarTransacao(String chaveOrigem, String chaveDestino, double valor){
        log.info("Iniciando transacao com os seguintes dados: " + chaveOrigem + "; " + chaveDestino + "; " + valor + ";");
        
        Conta contaOrigem = controladorConta.buscarConta(chaveOrigem);
        Conta contaDestino = controladorConta.buscarConta(chaveDestino);
       
        log.info("conta1: " + contaOrigem);
        log.info("conta2: " + contaDestino);
       
        boolean foiDebitado = contaOrigem.debitar(valor);
       
        if (foiDebitado) {
            log.debug("valor (" + valor + ") debidato com sucesso da conta: " + contaOrigem);
            
            contaDestino.creditar(valor);
            log.debug("valor (" + valor + ") creditado com sucesso na conta: " + contaDestino);
       
            log.info(String.format(
            "Saldos atualizados: conta %s: %.2f; conta %s: %.2f",
            contaOrigem.getChave(), contaOrigem.getSaldo(),
            contaDestino.getChave(), contaDestino.getSaldo()
        ));
            registrarTransacao(contaOrigem, contaDestino, valor);
            
            return true;
        } else {
            log.error("Falha ao debitar (" + valor + ") da conta: " + contaOrigem);
            log.info("Saldo total da conta: " + contaOrigem.getSaldo());
            return false;
        }
    }
    
    private void registrarTransacao(Conta conta1, Conta conta2, double valor) {
        Transacao transacao = new Transacao(conta1, conta2, valor);
        catalogo.adicionar(transacao);
    }

    public void listarTransacoes() {
        log.info("Listando todas as transações");
        catalogo.listar();
    }
}
