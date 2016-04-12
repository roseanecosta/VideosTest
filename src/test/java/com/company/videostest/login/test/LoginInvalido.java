package com.company.videostest.login.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Login;
import com.company.videostest.template.UsuarioInvalido;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Rose
 */
public class LoginInvalido {

    private WebDriver driver;
    private UsuarioInvalido templateUsuarioInvalido;
    private Login login;

    @Before
    public void inicia() {
        driver = new FirefoxDriver();
        templateUsuarioInvalido = new UsuarioInvalido();
        templateUsuarioInvalido.loadTemplateUsuarioInvalido();
        login = new Login(driver);
        login.acessar();

    }

    @Test
    public void loginInvalido() {
        Usuario usuario = templateUsuarioInvalido.getUsuario(UsuarioInvalido.INVALIDO);
        login.preencherLogin(usuario).logar();
        assertEquals("Incorrect email or password. Learn more", driver.findElement(By.id("password_incorrect")).getText());

    }

    @After
    public void encerre() {
        driver.quit();
    }

}
