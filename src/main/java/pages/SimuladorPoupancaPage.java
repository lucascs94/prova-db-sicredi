package pages;

import setup.TestRule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class SimuladorPoupancaPage extends BasePage {
    @FindBy(id = "valorAplicar")
    private WebElement valorAplicar;

    @FindBy(id = "valorInvestir")
    private WebElement valorInvestir;

    @FindBy(id = "tempo")
    private WebElement tempo;

    @FindBy(className = "btnSimular")
    private WebElement simular;

    @FindBy(className = "blocoResultadoSimulacao")
    private WebElement blocoSimulacao;

    @FindBy(className = "valor")
    private WebElement valorSimulacao;

    @FindBy(id = "valorAplicar-error")
    private WebElement valorAplicarError;

    @FindBy(id = "valorInvestir-error")
    private WebElement valorInvestirError;

    public SimuladorPoupancaPage() {
        PageFactory.initElements(driver, this);
    }

    public void acessaPaginaSimulador() {
        driver.navigate().to(TestRule.getRunProperties().getProperty("baseWebUrl"));
        esperaElemento(valorAplicar);
    }

    public void preencheValorAplicar(String valor) {
        preencheCampo(valorAplicar, valor);
    }

    public void preencheValorinvestir(String valor) {
        preencheCampo(valorInvestir, valor);
    }

    public void preencheTempoIvestimento(String valor) {
        preencheCampo(tempo, valor);
    }

    public void clicaSimular() {
        pressionaBotao(simular);
    }

    public boolean verificaExibicaoResultado() {
        return validaExibicaoElemento(blocoSimulacao);
    }

    public boolean validaResultadoSimulacao(double resultado){
        esperaElemento(valorSimulacao);
        String s = valorSimulacao.getText();
        String[] ss = s.split(" ");
        return Double.parseDouble(ss[ss.length - 1]) == resultado;
    }

    public boolean verificaExibicaoValorAplicarError(){
        return validaExibicaoElemento(valorAplicarError);
    }

    public boolean verificaExibicaoValorInvestirError(){
        return validaExibicaoElemento(valorInvestirError);
    }
}
