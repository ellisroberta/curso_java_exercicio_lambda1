# Exercício de Leitura de Produtos

## Descrição do Exercício:
Fazer um programa para ler um conjunto de produtos a partir de um
arquivo em formato .csv (suponha que exista pelo menos um produto).
Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
nomes, em ordem decrescente, dos produtos que possuem preço
inferior ao preço médio.

**Formato do Arquivo:**
O arquivo de entrada deve ter o seguinte formato:
`Nome_do_Produto,Preço`
Cada linha representa um produto, onde o nome do produto e seu preço estão separados por uma vírgula.

*Exemplo de Arquivo de Entrada (`in.txt`):*

```
Tv,900.00
Mouse,50.00
Tablet,350.50
HD Case,80.90
Computer,850.00
Monitor,290.00
```

**Execução do Programa:**
Ao executar o programa, ele solicitará que o usuário insira o caminho completo para o arquivo de entrada.
O programa processará os dados e exibirá o preço médio dos produtos e os nomes dos produtos que estão abaixo do preço médio.

*Exemplo de Saída:*

```
Enter full file path: in.txt
Average price: 420.23
Tablet
Mouse
Monitor
HD Case
```

## Estrutura do Código
O código é dividido em duas classes principais: `Product` e `Program`.

- **Classe `Product`**
Esta classe representa um produto, contendo um nome e um preço.
Ela possui um construtor que recebe o nome e o preço do produto, além de um método `ToString` que retorna o nome do produto.

- **Classe `Program`**
  Esta classe contém o método `main`, que é o ponto de entrada do programa.
Nela, é feita a leitura do arquivo, o cálculo do preço médio e a exibição dos produtos abaixo do preço médio.

## Como Executar o Programa
1. Certifique-se de que o arquivo `.csv` está no formato correto.
2. Compile o programa.
3. Execute o programa e forneça o caminho completo para o arquivo `.csv` quando solicitado.
4. O programa exibirá o preço médio e os nomes dos produtos com preço inferior à média.

## Observações
* O programa assume que o arquivo existe e que está no formato correto.
* O preço é tratado como um número decimal e está formatado para exibição com duas casas decimais.
* Os nomes dos produtos são exibidos em ordem decrescente.

## Melhorias Propostas

### Substituição por Referência de Método:
- Os comentários agora mencionam claramente que as expressões lambda, que obtêm preços e nomes, podem ser substituídas por
referências de método. Isso é uma prática comum em Java 8 e posterior, onde métodos existentes são referenciados diretamente,
tornando o código mais conciso e legível.
### Exemplo de Substituição:
- Para o método `map`, a expressão `p -> p.getPrice()` poderia ser substituída por `Product::getPrice`;
- Para `map(p -> p.getName())`, poderia ser `Product::getName`.