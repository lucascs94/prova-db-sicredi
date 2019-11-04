# language: pt
Funcionalidade: Simular investimento na poupança

  Cenario: Simular um investimento na poupança com valores inferiores aos permitidos
    Dado que acesso a página do simulador de investimento
    Quando informo incorretamente os valores nos campos do simulador
      |valorAplicar|valorInvestir|tempoInvestimento|
      |1000        |1000         |12               |
    Entao são exibidas as mensagens de erro sobre os campos de valor