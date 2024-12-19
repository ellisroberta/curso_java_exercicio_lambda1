package application;

import model.entities.Product;

import java.io.BufferedReader; // Para ler o arquivo linha por linha
import java.io.FileReader; // Para abrir o arquivo
import java.io.IOException; // Para tratar exceções de I/O
import java.util.*; // Para usar List, ArrayList, etc.
import java.util.stream.Collectors; // Para usar operações de stream

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Define a localidade para formato de moeda
        Scanner sc = new Scanner(System.in); // Cria um scanner para entrada do usuário

        // Solicita ao usuário o caminho do arquivo
        System.out.print("Enter full file path: ");
        String path = sc.nextLine(); // Lê o caminho do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Tenta abrir o arquivo para leitura
            List<Product> list = new ArrayList<>(); // Cria uma lista para armazenar os produtos

            String line = br.readLine(); // Lê a primeira linha do arquivo
            while (line != null) { // Enquanto houver linhas no arquivo
                String[] fields = line.split(","); // Divide a linha pelo delimitador vírgula
                // Adiciona um novo produto à lista
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine(); // Lê a próxima linha
            }

            // Calcula o preço médio dos produtos
            double avg = list.stream()
                    .map(p -> p.getPrice()) // A expressão lambda pode ser substituída pela referência de método Product::getPrice
                    .reduce(0.0, (x, y) -> x + y) / list.size(); // A expressão lambda pode ser substituída pela referência de método Double::sum

            // Exibe o preço médio formatado com duas casas decimais
            System.out.println("Average price: " + String.format("%.2f", avg));

            // Comparador para ordenar os nomes dos produtos sem diferenciar maiúsculas de minúsculas
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            // Filtra os produtos com preço inferior à média, obtém os nomes e os ordena em ordem decrescente
            List<String> names = list.stream()
                    .filter(p -> p.getPrice() < avg) // Filtra produtos com preço abaixo da média
                    .map(p -> p.getName()) // A expressão lambda pode ser substituída pela referência de método Product::getName
                    .sorted(comp.reversed()) // Ordena os nomes em ordem decrescente
                    .collect(Collectors.toList()); // Coleta os resultados em uma lista; 'collect(toList())' pode ser substituído por 'toList()'

            // Exibe os nomes dos produtos que estão abaixo do preço médio
            names.forEach(System.out::println);
        } catch (IOException e) { // Trata exceções de I/O
            System.out.println("Error: " + e.getMessage()); // Exibe mensagem de erro
        }
        sc.close(); // Fecha o scanner
    }
}