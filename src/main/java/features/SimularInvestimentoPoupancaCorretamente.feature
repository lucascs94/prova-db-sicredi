# language: pt
Funcionalidade: Simular investimento na poupança

  Cenario: Simular corretamente um investimento na poupança
    Dado que acesso a página do simulador de investimento
    E informo os valores nos campos do simulador
    |valorAplicar|valorInvestir|tempoInvestimento|
    |5000        |5000         |12               |
    Quando seleciono a opção Simular
    Entao a simulação é realizada
    E o valor de 662.00 reais é exibido