package model.entities;

public class Product {

    private String name; // Nome do produto
    private Double price; // Preço do produto

    // Construtor da classe Product
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Métodos getters e setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    // Método toString para representar o produto como string
    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price); // Formata o preço com duas casas decimais
    }
}