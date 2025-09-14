// Restaurante.java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que gerencia o sistema de pedidos do restaurante. 
 * Contém a lógica para o menu interativo e o controle dos pedidos.
 */
public class Restaurante {
    // Estrutura de dados para armazenar a lista de pedidos. [cite: 49]
    private List<Pedido> pedidos;
    private int proximoNumeroPedido;
    private Scanner scanner;

    public Restaurante() {
        this.pedidos = new ArrayList<>();
        this.proximoNumeroPedido = 1; // Pedidos começam em 1. [cite: 22]
        this.scanner = new Scanner(System.in); // Interação via console. [cite: 52]
    }

    /**
     * Inicia a execução do sistema, exibindo o menu principal em loop.
     */
    public void iniciar() {
        boolean executando = true;
        // O menu continua rodando até que a opção de sair seja escolhida. [cite: 50]
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Estrutura switch-case para tratar as opções do menu. [cite: 50]
            switch (opcao) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    removerPedido();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    executando = false; // Encerra a execução. [cite: 41]
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Exibe o menu principal de opções para o usuário. [cite: 16]
     */
    private void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento de Pedidos ---");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Lógica para registrar um novo pedido. [cite: 17]
     */
    private void registrarPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine(); // Solicita o nome do cliente. [cite: 21]

        Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);

        boolean adicionandoItens = true;
        while (adicionandoItens) {
            System.out.print("Digite o nome do item: ");
            String nomeItem = scanner.nextLine(); // Solicita nome do item. [cite: 24]
            System.out.print("Digite o preço do item: R$ ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            novoPedido.adicionarItem(new Item(nomeItem, precoItem)); // Adiciona um ou mais itens. [cite: 23]

            System.out.print("Deseja adicionar outro item? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                adicionandoItens = false;
            }
        }

        pedidos.add(novoPedido); // Armazena o pedido completo. [cite: 25]
        proximoNumeroPedido++; // Incrementa para o próximo pedido. [cite: 22]

        System.out.println("\nPedido registrado com sucesso!");
        exibirNotaConfirmacao(novoPedido); // Exibe o resumo do pedido. [cite: 26]
    }

    /**
     * Lógica para remover um pedido existente. [cite: 27]
     */
    private void removerPedido() {
        System.out.print("Digite o número do pedido que deseja remover: "); // Solicita o número do pedido. [cite: 29]
        int numeroParaRemover = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        // Usar Iterator para remover de forma segura durante a iteração
        Iterator<Pedido> iterador = pedidos.iterator();
        while(iterador.hasNext()){
            Pedido pedido = iterador.next();
            if(pedido.getNumero() == numeroParaRemover){
                iterador.remove(); // Remove o pedido da lista se encontrado. [cite: 30]
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Pedido " + numeroParaRemover + " removido com sucesso.");
        } else {
            // Exibe mensagem de erro se o pedido não existe. [cite: 31]
            System.out.println("Erro: Pedido com número " + numeroParaRemover + " não encontrado.");
        }
    }

    /**
     * Lista todos os pedidos registrados de forma ordenada. [cite: 32, 33]
     */
    private void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado no momento.");
            return;
        }

        System.out.println("\n--- Lista de Todos os Pedidos ---");
        // A exibição é naturalmente ordenada pois os pedidos são adicionados sequencialmente. [cite: 34]
        for (Pedido pedido : pedidos) {
            System.out.println("\n----------------------------------------");
            System.out.println("Número do Pedido: " + pedido.getNumero()); // Mostra o número do pedido. [cite: 37]
            System.out.println("Nome do Cliente: " + pedido.getNomeCliente()); // Mostra o nome do cliente. [cite: 38]
            System.out.println("Itens:"); // Mostra a lista de itens. [cite: 39]
            for (Item item : pedido.getItens()) {
                System.out.printf("- %s: R$ %.2f\n", item.getNome(), item.getPreco());
            }
            // Mostra o valor total, calculado dinamicamente. [cite: 40]
            System.out.printf("Valor Total: R$ %.2f\n", pedido.getValorTotal());
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Exibe um resumo formatado do pedido recém-criado. [cite: 59]
     * @param pedido O pedido a ser exibido.
     */
    private void exibirNotaConfirmacao(Pedido pedido) {
        // Modelo de saída sugerido no documento. [cite: 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86]
        System.out.println("\n========================================");
        System.out.println("      Restaurante Sabor Digital       ");
        System.out.println("========================================");
        System.out.println("Pedido N° " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("----------------------------------------");
        System.out.println("Itens:");
        for (Item item : pedido.getItens()) {
            System.out.printf("- %s R$ %.2f\n", item.getNome(), item.getPreco());
        }
        System.out.println("----------------------------------------");
        System.out.printf("Total: R$ %.2f\n", pedido.getValorTotal());
        System.out.println("========================================");
        System.out.println("      Obrigado pela preferência! :)     ");
        System.out.println("========================================\n");
    }

    /**
     * Ponto de entrada do programa.
     */
    public static void main(String[] args) {
        Restaurante sistema = new Restaurante();
        sistema.iniciar();
    }
}
