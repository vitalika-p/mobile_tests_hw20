package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.EnvironmentHelper.bsLogin;
import static helpers.EnvironmentHelper.bsPassword;
import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + bsLogin + ":" + bsPassword + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
            .auth().basic(bsLogin, bsPassword)
            .get(url)
            .then()
            .log().body()
            .statusCode(200)
            .extract().path("automation_session.video_url");
    }
}