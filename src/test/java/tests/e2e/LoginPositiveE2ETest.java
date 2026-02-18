package tests.e2e;

import framework.pages.expandtesting.LoginPage;
import framework.pages.expandtesting.SecureAreaPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPositiveE2ETest extends BaseTest {
    private SecureAreaPage secure;

    @BeforeEach
    void login() {
        secure = pages.login()
                .open()
                .setUsername("practice")
                .setPassword("SuperSecretPassword!")
                .submitExpectSuccess();
    }
    @Test
    void user_can_login_and_see_secure_area() {
        assertThat(secure.isLoaded()).isTrue();
        assertThat(secure.flashMessage()).contains("You logged into a secure area");
    }

    @Test
    void user_can_logout_and_see_login_area() {
        LoginPage login = secure.logout();
        assertThat(login.isLoaded()).isTrue();
    }
}
