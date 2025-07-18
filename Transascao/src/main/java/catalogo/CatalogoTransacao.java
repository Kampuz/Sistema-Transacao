/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

import java.util.ArrayList;
import front.Logger;
import modelo.Transacao;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class CatalogoTransacao {

    private static CatalogoTransacao instance;
    private final ArrayList<Transacao> transacoes = new ArrayList<>();
    private static final Logger log = Logger.getInstance();

    public CatalogoTransacao() {
        log.debug("Inicializando Catalogo Transacao");
    }
    
    public static CatalogoTransacao getInstance() {
        if(instance == null) {
            instance = new CatalogoTransacao();
        }
        return instance;
    }

    public boolean adicionar(Transacao transacao) {
        boolean ok = transacoes.add(transacao);
        if (ok) {
            log.info("Transacao adicionada: " + transacao);
        } else {
            log.warn("Falha ao adicionar transação: " + transacao);
        }
        return ok;
    }

    public boolean remover(Transacao transacao) {
        boolean ok = transacoes.remove(transacao);
        if (ok) {
            log.info("Transação removida: " + transacao);
        } else {
            log.warn("Falha ao remover transação: " + transacao);
        }
        return ok;
    }

    public void listar() {
        log.info("Listando todas as transacoes (" + transacoes.size() + ')');
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }
    
    public void listarPorChave(int chave) {
        log.info("Listar transacoes envolvendo a conta com a chave = " + chave + ')');
        for (Transacao transacao : buscarPorChave(chave)) {
                System.out.println(transacao);
        }
    }
    
    public ArrayList<Transacao> buscarPorChave(int chave) {
        ArrayList<Transacao> resultado = new ArrayList<>();
        
        for (Transacao transacao : transacoes) {
            if (transacao.getPagador().getChave().equals(chave) || transacao.getRecebedor().getChave().equals(chave)) {
                resultado.add(transacao);
                log.debug("encontrou: " + transacao);
            }
        }
        
        if (resultado.isEmpty()) {
            log.warn("Nenhuma transação encontrada para chave=" + chave);
        }
        return resultado;
    }
}
