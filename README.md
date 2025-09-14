# Sistema de Gerenciamento de Pedidos 

## Descrição
Este projeto implementa um sistema simples para gerenciar pedidos em um restaurante.  
O programa permite registrar novos pedidos, remover pedidos existentes e listar todos os pedidos ativos de forma organizada.  

A interação com o usuário é realizada via **console**, utilizando a classe `Scanner`.

---

## Estrutura do Projeto
O projeto foi desenvolvido em **Java** utilizando os conceitos de **Orientação a Objetos**.

- **Item.java**  
  Representa um item individual do pedido, contendo nome e preço.  

- **Pedido.java**  
  Representa um pedido realizado por um cliente.  
  Contém número sequencial, nome do cliente e a lista de itens associados (relação de **composição**).  

- **Restaurante.java**  
  Classe principal do sistema.  
  Responsável por gerenciar a lista de pedidos e fornecer o menu interativo.  

---

## Funcionalidades
1. **Registrar Pedido**
   - Solicita o nome do cliente.
   - Gera automaticamente um número sequencial.
   - Permite adicionar um ou mais itens (nome e preço).
   - Armazena o pedido e exibe uma **nota de confirmação** com o resumo.  

2. **Remover Pedido**
   - Solicita o número do pedido a ser removido.
   - Caso exista, remove da lista; caso contrário, exibe mensagem de erro.  

3. **Listar Pedidos**
   - Exibe todos os pedidos registrados em ordem crescente.
   - Mostra número do pedido, cliente, lista de itens e valor total.  

4. **Sair**
   - Encerra a execução do programa.  

---

## ▶️ Como Executar
1. Compile os arquivos Java:
   ```bash
   javac Item.java Pedido.java Restaurante.java
   ```
2. Execute o programa
   ```bash
   java Restaurante
   ```
