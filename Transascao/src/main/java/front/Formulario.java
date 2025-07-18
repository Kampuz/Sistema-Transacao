/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front;

import controlador.ControladorConta;
import java.util.Scanner;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Formulario {
    private final Scanner scanner = new Scanner(System.in);
    private final Autenticador autenticador;
    private static final Logger log = Logger.getInstance();

    public Formulario(ControladorConta controladorConta) {
        log.debug("Formulario inicializado");
        autenticador = new Autenticador(controladorConta);
    }
    
    public String pedirChaveTransacao() {
        String chave;
        log.debug("Formulario: pedindo chave transacao.");
        
        do {
            System.out.println("Digite a chave: ");
            chave = scanner.nextLine();
        } while(autenticador.chaveInvalida(chave) || !autenticador.chaveUtilizada(chave));
        return chave;
    }
    
    public String pedirChaveCriacao() {
        String chave;
        log.debug("Formulario: pedindo chave criacao conta");
        
        do {
            System.out.println("Digite a chave: ");
            chave = scanner.nextLine();
        } while(autenticador.chaveInvalida(chave) || autenticador.chaveUtilizada(chave));
        return chave;
    }
    
    public double pedirValorTransacao() {
        double valor;
        log.debug("Formulario: pedindo valor da transacao.");
        
        do {
            System.out.println("Digite o valor: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next(); // descarta entrada inválida
            }
            valor = scanner.nextDouble();
        } while (autenticador.valorInvalido(valor));
        scanner.nextLine();
        
        return valor;
    }
    
    public double pedirValorSaldo() {
        double valor;
        log.debug("Formulario: pedindo valor do saldo.");
        
        do {
            System.out.println("Digite o valor: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next(); // descarta entrada inválida
            }
            valor = scanner.nextDouble();
        } while (autenticador.valorInvalido(valor));
        scanner.nextLine();
        
        return valor;
    }
    
    public int imprimirMenu() {
        int opcao;
        
        log.debug("Mostrando Inteface: menu");
        System.out.println("Aperte [ENTER] para Continuar.");
        scanner.nextLine();
        System.out.println("\n==== MENU ====");
        System.out.println("1. Criar conta");
        System.out.println("2. Listar contas");
        System.out.println("3. Realizar transacao");
        System.out.println("4. Listar transacoes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
        opcao = Integer.parseInt(scanner.nextLine());
        
        return opcao;
    }
    
    public void imprimirTransacao() {
        log.debug("Mostrando Interface: transacao.");
        System.out.println("\n==== TRANSACAO ====");
    }
    
    public void imprimirCriacaoConta() {
        log.debug("Mostrando Interface: criacao conta.");
        System.out.println("\n==== NOVA CONTA ====");
    }
}
