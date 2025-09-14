// Pedido.java

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um pedido feito por um cliente. [cite: 12]
 * A classe Pedido é composta por objetos da classe Item,
 * o que significa que os Itens pertencem a um Pedido específico. [cite: 48]
 */
public class Pedido {
    private int numero;
    private String nomeCliente;
    // Relação de Composição: Pedido "possui" uma lista de Itens. [cite: 14]
    private List<Item> itens;

    /**
     * Construtor para criar um novo Pedido.
     * @param numero O número de identificação sequencial do pedido. [cite: 22]
     * @param nomeCliente O nome do cliente que fez o pedido. [cite: 21]
     */
    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>(); // Inicializa a lista de itens.
    }

    /**
     * Adiciona um item à lista de itens do pedido. [cite: 23]
     * @param item O objeto Item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    /**
     * Calcula o valor total do pedido somando os preços de todos os itens. [cite: 40]
     * @return O valor total do pedido.
     */
    public double getValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    // --- Getters ---
    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<Item> getItens() {
        return itens;
    }
}
