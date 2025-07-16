/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front;

import catalogo.CatalogoConta;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Autenticador {
    private static Autenticador instance;
    private static final Logger log = Logger.getInstance();
    private final CatalogoConta catalogoConta = CatalogoConta.getInstance();
    
    private Autenticador() {
        log.debug("Autenticador inicializado");
    }

    public static Autenticador getInstance() {
        if (instance == null) {
            instance = new Autenticador();
        }
        return instance;
    }
    
    public boolean valorInvalido(double valor) {        
        if (valor < 0.0) {
            log.error("Valor Invalido: valor negativo.");
            return true;
        } else {
            log.debug("Valor Valido.");
            return false;
        }
    }
    
    public boolean chaveInvalida(String chave) {
        if (chave.isBlank()) {
            log.error("Chave Invalida: chave vazia ou composta somente por espacos.");
            return true;
        } else {
            log.debug("Chave Valida.");
            return false;
        }
    }
    
    public boolean chaveUtilizada(String chave) {
        if (catalogoConta.buscarPorChave(chave) != null) {
            log.warn("Chave esta sendo utilizada.");
            return true;
        } else { 
            log.warn("Chave nao esta sendo utilizada.");
            return false;
        }
    }
}
