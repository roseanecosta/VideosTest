package com.company.videostest.login.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Login;
import com.company.videostest.template.UsuarioValido;
import static junit.framework.TestCase.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Rose
 */
public class LoginValido {

    private WebDriver driver;
    private UsuarioValido templateUsuario;
    private Login login;

    @Before
    public void inicia() {
        driver = new FirefoxDriver();
        templateUsuario = new UsuarioValido();
        templateUsuario.loadTemplateUsuarioValido();
        login = new Login(driver);
        login.acessar();

    }

    @Test
    public void loginValido() throws InterruptedException {
        Usuario usuario = templateUsuario.getUsuario(UsuarioValido.VALIDO);
        login.preencherLogin(usuario).logar();
        Thread.sleep(5000);
        assertEquals("Dashboard", driver.findElement(By.id("mn-dashboard")).getText());

    }
}
