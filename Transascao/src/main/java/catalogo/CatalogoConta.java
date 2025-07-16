/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo;

import java.util.ArrayList;
import front.Logger;
import modelo.Conta;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class CatalogoConta {

    private static CatalogoConta instance;
    private final ArrayList<Conta> contas = new ArrayList<>();
    private static final Logger log = Logger.getInstance();

    private CatalogoConta() {
        log.debug("Inicializando Catalogo Conta");
    }

    public static CatalogoConta getInstance(){
        if (instance == null) {
            instance = new CatalogoConta();
        }
        return instance;
    }

    public boolean adicionar(Conta conta) {
        
        if (this.buscarPorChave(conta.getChave()) != null) {
            log.error("conta já existe" + conta);
            return false;
        }
        
        boolean ok = contas.add(conta);
        if (ok) {
            log.debug("Conta adicionada: " + conta);
        } else {
            log.warn("Falha ao adicionar conta: " + conta);
        }
        return ok;
    }

    public boolean remover(Conta conta) {
        boolean ok = contas.remove(conta);
        
        if (ok) {
            log.debug("Conta removida: " + conta);
        } else {
            log.warn("Falha ao remover conta: " + conta);
        }
        return ok;
    }
    
    public boolean atualizarConta(Conta contaAtualizada) {
        for (Conta conta : contas) {
            if (conta.getChave().equals(contaAtualizada.getChave())) {
                conta.setSaldo(contaAtualizada.getSaldo());
                return true;
            }
        }
        return false;
    }

    public void listar() {
        log.info("Listando todas as contas (" + contas.size() + ')');
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
    
    public Conta buscarPorChave(String chave) {
        for (Conta conta : contas) {
            if (conta.getChave().equals(chave)) {
                log.debug("conta encontrada: " + conta);
                return conta;
            }
        }
        log.warn("Conta nao encontrada: " + chave);
        return null;
    }
}
