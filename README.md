# prova-db-sicredi

# Análise 
Com base na história:
Com o propósito de Simular um Investimento na Poupança
como um Associado,
eu gostaria de preencher o formulário de simulação
e ver a tabela de resultado com Mês e Valor.

Foram definidos os seguintes testes de aceitação:
1. Realizar simulação corretamente
Dado que informo corretamente os valores nos campos do simulador
Quando seleciono a opção Simular
Então a simulação é realizada
E os valores simulados são exibidos corretamente

2. Realizar simulação utilizando valores inferiores ao mínimo permitido
Dado que informo valores inferiores ao mínimo nos campos do simulador
Quando seleciono a opção Simular
Então são exibidas mensagens informando o valor mínimo aceito pelos campos

Além dos testes de aceitação serão executados também testes de serviço para validar os seguintes aspectos:
1. Verificar o estado de execução do serviço do simulador (health check) - este teste realiza uma chamada simples para veriricar a disponibilidade do serviço 

2. Validar o contrato do serviço do simulador - verifica se as definições acordadas para este serviço não foram violadas durante o desenvolvimento da funcionalidade

Planejamento da execução:
•	Executar primeiro os testes de serviço, na ordem em que foram descritos
•	Executar os testes de aceitação

Justificativas:
Por serem mais rápidos e menos suscetíveis a falsos positivos, os testes de serviço devem ser executados primeiro. São ideais para uma validação inicial, visto que ao encontrar um problema em algum dos serviços que provém recursos à alguma das funcionalidades do sistema, podemos cancelar a execução dos testes de sistema ou, ao menos, remover os testes das funcionalidades relacionadas ao serviço; visto que o problema seria encontrado também nestes testes, só que através de execuções mais longas e mais suscetíveis a falhas não causadas por defeitos (flaky tests).

Após a execução com sucesso dos testes de serviço são executados os testes de aceitação. Estes, para garantir que os critérios de aceitação definidos previamente foram implementados, assegurando uma maior adequação do sistema as necessidades dos usuários finais.

# Instruções para execução dos testes automatizados
O ambiente para execução dos testes deve conter:
• Uma IDE de preferencia do avaliador (que seja compatível com o plugin do cucumber)
• JDK 1.8 em sua versão mais recente
• O plugin do maven
• O plugin do cucumber instalado na IDE utilizada
• Navegador google chrome na versão 76
• Navegador Mozilla Firefox na versão 68

Os testes devem ser executados localmente de dentro da IDE utilizada pelo avaliador. Os testes estão contidos na pasta ‘avaliacao-sicredi\src\test\java’

Para seleção do navegador a ser utilizado, deve-se acessar o arquivo ‘configuration/run.properties’ e alterar o parâmetro “driverType” selecionando as opções ‘chrome’ ou ‘firefox’.

Os relatórios de teste são gerados na pasta ‘avaliacao-sicredi\reports’. Os testes de api geram um arquivo .txt para cada teste executado, já os testes de UI geram um relatório html contendo todos os testes marcados para aquela execução e um novo relatório é gerado a cada execução iniciada.
