package api.simuladorpoupanca;

import base.BaseApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class VerificarDisponibilidadeSimuladorPoupanca extends BaseApiTest {

    @DisplayName("Verificar a disponibilidade do serviço do simulador da poupança")
    @Test
    public void validaContratoSimulador() {
        when()
                .get()
                .then()
                .statusCode(200);

    }
}
