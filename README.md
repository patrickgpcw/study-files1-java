# Processamento de arquivos CSV em Java

Pequeno projeto de linha de comando criado para praticar **leitura e escrita de arquivos**, coleções e manipulação de dados em Java.

O programa lê um arquivo CSV contendo nome, preço e quantidade de produtos. Em seguida, calcula o valor total de cada item e gera um novo arquivo `summary.csv` dentro de uma pasta `out`.

## Como funciona

Ao iniciar o programa, o usuário informa o caminho do arquivo CSV de origem. Cada linha do arquivo deve seguir este formato:

```text
nome,preço,quantidade
```

Para cada produto, o valor total é calculado da seguinte forma:

```text
total = preço × quantidade
```

O programa cria uma pasta `out` no mesmo diretório do arquivo de entrada e grava nela o arquivo `summary.csv`, contendo o nome e o valor total de cada produto.

## Conceitos utilizados

- Leitura de arquivos com `BufferedReader` e `FileReader`;
- Escrita de arquivos com `BufferedWriter` e `FileWriter`;
- Gerenciamento automático de recursos com *try-with-resources*;
- Criação de diretórios com a classe `File`;
- Separação de dados com o método `split()`;
- Uso de `List` e `ArrayList`;
- Encapsulamento e criação de objetos;
- Tratamento de exceções com `try/catch`;
- Formatação de valores numéricos.

## Estrutura do projeto

```text
study-files1-java/
├── pom.xml
├── files/
│   ├── summary.csv
│   └── out/
│       └── summary.csv
└── src/main/java/com/patrick/
    ├── Main.java
    └── entities/
        └── Product.java
```

- `Main.java`: recebe o caminho do arquivo, lê os produtos e gera o arquivo de saída;
- `Product.java`: representa um produto e calcula seu valor total;
- `files/summary.csv`: exemplo de arquivo de entrada;
- `files/out/summary.csv`: exemplo de arquivo gerado.

## Requisitos

- Java 21;
- Apache Maven.

## Como executar

Na raiz do projeto, compile com:

```bash
mvn compile
```

Em seguida, execute a classe principal:

```bash
java -cp target/classes com.patrick.Main
```

Quando solicitado, informe o caminho do arquivo de entrada. Por exemplo:

```text
files/summary.csv
```

Também é possível abrir o projeto em uma IDE e executar a classe `com.patrick.Main`.

## Exemplo

Arquivo de entrada:

```csv
TV LED,1290.99,1
Video Game Chair,350.50,3
Iphone X,900.00,2
Samsung Galaxy 9,850.00,2
```

Arquivo gerado em `files/out/summary.csv`:

```csv
TV LED,1290.99
Video Game Chair,1051.50
Iphone X,1800.00
Samsung Galaxy 9,1700.00
```

## Objetivo

Este projeto tem finalidade educacional. Seu objetivo é demonstrar como ler dados estruturados de um arquivo, transformá-los em objetos, realizar cálculos e gravar os resultados em um novo arquivo usando os recursos de entrada e saída do Java.
