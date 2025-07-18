/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import catalogo.CatalogoTransacao;
import java.util.ArrayList;
import front.Logger;
import modelo.Conta;
import modelo.Transacao;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class ControladorTransacao {
    
    private static ControladorTransacao instance;
    private final ControladorConta controladorConta = ControladorConta.getInstance();
    private final CatalogoTransacao catalogoTransacao = CatalogoTransacao.getInstance();
    private static final Logger log = Logger.getInstance();

    private ControladorTransacao() {
        log.debug("Inicializando Controlado Transacao");
    }
    
    public static ControladorTransacao getInstance() {
        if (instance == null) {
            instance = new ControladorTransacao();
        }
        return instance;
    }
    
    public boolean realizarTransacao(String chaveOrigem, String chaveDestino, double valor){
        log.info("Iniciando transacao com os seguintes dados: " + chaveOrigem + "; " + chaveDestino + "; " + valor + ";");
        
        Conta contaOrigem = controladorConta.buscarConta(chaveOrigem);
        Conta contaDestino = controladorConta.buscarConta(chaveDestino);
       
        log.debug("conta1: " + contaOrigem);
        log.debug("conta2: " + contaDestino);
       
        boolean foiDebitado = contaOrigem.debitar(valor);
       
        if (foiDebitado) {
            log.debug("valor (" + valor + ") debidato com sucesso da conta: " + contaOrigem);
            
            contaDestino.creditar(valor);
            log.debug("valor (" + valor + ") creditado com sucesso na conta: " + contaDestino);
       
            atualizarContas(contaOrigem, contaDestino);
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
        catalogoTransacao.adicionar(transacao);
    }
    
    private void atualizarContas(Conta conta1, Conta conta2) {
        controladorConta.atualizarConta(conta1);
        controladorConta.atualizarConta(conta2);
        log.info(String.format(
            "Saldos atualizados: conta %s: %.2f; conta %s: %.2f",
            conta1.getChave(), conta1.getSaldo(),
            conta2.getChave(), conta2.getSaldo()
        ));
    }   
    
    public void listarTransacoes() {
        log.info("Listando todas as transações");
        catalogoTransacao.listar();
    }
}
