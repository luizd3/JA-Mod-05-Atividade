## Atividade do módulo 5 do curso de Java Avançado da Mentorama

Desenvolva uma API de venda de Produtos com suporte aos seguintes endpoints:

- Listar produtos com seus respectivos valores.
- Dar entrada em produtos.
  - Deve conter o id do produto e a quantidade em cada requisição.
- Vender produtos.
  - O endpoint de venda de produtos deve passar uma lista de itens onde cada item deve possuir os seguintes atributos:
    - Código do produto
    - Quantidade
    - Desconto
  - O endpoint deve retornar o valor total final da venda considerando as quantidades, os descontos e a aplicação das regras de negócio.

- Os produtos vendidos devem estar pré-cadastrados no sistema e devem possuir os seguintes atributos:
  - ID (único)
  - Nome
  - Valor
  - Desconto máximo permitido
  - Quantidade em estoque

- As seguintes regras de negócio devem ser aplicadas:
  - Ao tentar dar um desconto maior do que o permitido para o produto, deve ser considerado o desconto máximo.
  - Ao tentar realizar uma venda de uma quantidade maior do que a disponível em estoque, deve ser vendido apenas a quantidade de produtos disponíveis.

- Todas as regras de negócio devem ser validadas através de testes unitários.
- Os endpoints devem ser testados utilizando testes de integração.

- Plus: utilizar TDD.
  - Escrever primeiro o teste, que vai falhar no início.
  - Logo em seguida, escrever um teste funcional apenas para passar este teste.
  - Depois, realizar a refatoração.
