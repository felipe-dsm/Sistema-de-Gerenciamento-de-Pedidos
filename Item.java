// Item.java

/**
 * Representa um item individual que pode ser adicionado a um pedido. [cite: 13]
 * Cada item possui um nome e um preço.
 */
public class Item {
    private String nome;
    private double preco;

    /**
     * Construtor para criar um novo Item.
     * @param nome O nome do item (ex: "Pizza Calabresa").
     * @param preco O preço do item.
     */
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // --- Getters ---
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
