/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front;

import controlador.ControladorConta;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Autenticador {

    private static final Logger log = Logger.getInstance();
    private final ControladorConta controladorConta;

    public Autenticador(ControladorConta controladorConta) {
        log.debug("Autenticador inicializado");
        this.controladorConta = controladorConta;
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
        if (controladorConta.buscarConta(chave) != null) {
            log.warn("Chave esta sendo utilizada.");
            return true;
        } else {
            log.warn("Chave nao esta sendo utilizada.");
            return false;
        }
    }
}
