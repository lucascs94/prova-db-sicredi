package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import utils.LogHelper;
import utils.PropertiesFileReader;

import java.io.PrintStream;
import java.util.Properties;

public class BaseApiTest {
    private Properties runProperties;

    @BeforeEach
    public void configuraTest(TestInfo info) {
        runProperties = PropertiesFileReader.readPropFile("run");

        PrintStream printStream = LogHelper.setLogConfiguration(info);

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(runProperties.getProperty("baseApiUrl"))
                .addFilter(new RequestLoggingFilter(printStream))
                .addFilter(new ResponseLoggingFilter(printStream))
                .build();
    }
}
