package api.simuladorpoupanca;

import base.BaseApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ValidarContratoSimuladorPoupanca extends BaseApiTest {

    @DisplayName("Validar contrato do serviço do simulador da poupança")
    @Test
    public void validaContratoSimulador() {
        when()
                .get()
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("SimuladorGetSchema.json"));

    }
}
