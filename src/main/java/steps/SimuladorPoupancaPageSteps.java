package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import pages.SimuladorPoupancaPage;
import utils.ReportHelper;

import java.util.List;
import java.util.Map;

public class SimuladorPoupancaPageSteps {
    private SimuladorPoupancaPage simuladorPoupancaPage;

    public SimuladorPoupancaPageSteps() {
        simuladorPoupancaPage = new SimuladorPoupancaPage();
    }

    @Dado("que acesso a página do simulador de investimento")
    public void acessaPaginaSimulador() {
        ReportHelper.logMensagemInfo("Acessando a página do simulador de investimento na poupança.");
        simuladorPoupancaPage.acessaPaginaSimulador();
        ReportHelper.logMensagemSucessoPrint("Acesso ao simulador realizado com sucesso.");
    }

    @Quando("informo incorretamente os valores nos campos do simulador")
    @E("informo os valores nos campos do simulador")
    public void preencheCamposSimulador(DataTable data) {
        List<Map<String, String>> dados = data.asMaps(String.class, String.class);
        ReportHelper.logMensagemInfo("Preencher valor a aplicar.");
        simuladorPoupancaPage.preencheValorAplicar(dados.get(0).get("valorAplicar"));
        ReportHelper.logMensagemSucessoPrint("Valor a aplicar preenchido com sucesso.");
        ReportHelper.logMensagemInfo("Preencher valor a investir.");
        simuladorPoupancaPage.preencheValorinvestir(dados.get(0).get("valorInvestir"));
        ReportHelper.logMensagemSucessoPrint("Valor a investir preenchido com sucesso.");
        ReportHelper.logMensagemInfo("Preencher tempo de investimento.");
        simuladorPoupancaPage.preencheTempoIvestimento(dados.get(0).get("tempoInvestimento"));
        ReportHelper.logMensagemSucessoPrint("Tempo de investimento preenchido com sucesso.");
    }

    @Quando("seleciono a opção Simular")
    public void clicaSimular() {
        ReportHelper.logMensagemInfo("Pressionar o botão 'Simular'.");
        simuladorPoupancaPage.clicaSimular();
        ReportHelper.logMensagemSucessoPrint("Botão 'Simular' pressionado com sucesso.");
    }

    @Entao("a simulação é realizada")
    public void validaExibicaoResultado() {
        ReportHelper.logMensagemInfo("Validar exibição do resultado da simulação.");
        boolean isDisplayed = simuladorPoupancaPage.verificaExibicaoResultado();
        if (isDisplayed) {
            ReportHelper.logMensagemSucessoPrint("Resultado Exibido corretamente.");
        } else {
            ReportHelper.logMensagemFalhaPrint("Resultado da simulação não foi exibido!");
        }
        Assertions.assertTrue(isDisplayed);
    }

    @E("o valor de {double} reais é exibido")
    public void validaResultadoSimulacao(double resultado) {
        ReportHelper.logMensagemInfo("Validar resultado calculado na simulação.");
        boolean isValid = simuladorPoupancaPage.validaResultadoSimulacao(resultado);
        if (isValid) {
            ReportHelper.logMensagemSucessoPrint("Resultado calculado corretamente.");
        } else {
            ReportHelper.logMensagemFalhaPrint("Resultado da simulação foi calculado incorretamente!");
        }
        Assertions.assertTrue(isValid);
    }

    @Entao("são exibidas as mensagens de erro sobre os campos de valor")
    public void validaExibicaoMensagensValorInferior(){
        boolean isDisplayed = (simuladorPoupancaPage.verificaExibicaoValorAplicarError() && simuladorPoupancaPage.verificaExibicaoValorInvestirError());
        if (isDisplayed) {
            ReportHelper.logMensagemSucessoPrint("Mensagens de erro exibidas corretamente.");
        } else {
            ReportHelper.logMensagemFalhaPrint("Mensagens de erro não foram exibidas!");
        }
        Assertions.assertTrue(isDisplayed);
    }
}
