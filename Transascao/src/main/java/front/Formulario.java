/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Formulario {

    private static Formulario instance;
    private final Scanner scanner = new Scanner(System.in);
    private static final Autenticador autenticador = Autenticador.getInstance(); 
    private static final Logger log = Logger.getInstance();

    private Formulario() {
        log.debug("Formulario inicializado");
    }
    
    public static Formulario getInstance() {
        if (instance == null) {
            instance = new Formulario();
        }
        return instance;
    }

    public ArrayList<String> imprimirTransacao() {
        String chaveOrigem, chaveDestino;
        double valor;
        ArrayList<String> dadosTransacao = new ArrayList<>();
        log.info("Mostrando Inteface: transacao");
        
        do {
            System.out.println("Digite sua chave: ");
            chaveOrigem = scanner.nextLine();
        } while (autenticador.chaveInvalida(chaveOrigem) || !autenticador.chaveUtilizada(chaveOrigem));

        do {
            System.out.println("Digite a outra chave: ");
            chaveDestino = scanner.nextLine();
        } while (autenticador.chaveInvalida(chaveDestino) || !autenticador.chaveUtilizada(chaveDestino));

        do {
            System.out.print("Digite o valor desejado: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next(); // descarta entrada inválida
            }
            valor = scanner.nextDouble();
        } while (autenticador.valorInvalido(valor));

        scanner.nextLine();

        dadosTransacao.add(chaveOrigem);
        dadosTransacao.add(chaveDestino);
        dadosTransacao.add("" + valor);

        return dadosTransacao;
    }

    public ArrayList<String> imprimirConta() {
        
        ArrayList<String> dadosConta = new ArrayList<>();
        String chave;
        double saldo;
        
        log.info("Mostrando Inteface: criacao conta");
        
        do {
            System.out.print("Digite a chave da nova conta: ");
            chave = scanner.nextLine();
        } while (autenticador.chaveUtilizada(chave) || autenticador.chaveInvalida(chave));

        do {
            System.out.print("Digite o saldo inicial: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next(); // descarta entrada inválida
            }
            saldo = scanner.nextDouble();
        } while (autenticador.valorInvalido(saldo));

        dadosConta.add(chave);
        dadosConta.add("" + saldo);
        return dadosConta;
    }
    
    public int imprimirMenu() {
        int opcao;
        
        log.info("Mostrando Inteface: menu");
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
}
