package com.company.videostest.recupsenha.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Email;
import com.company.videostest.template.EmailInvalido;
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
public class RecupSenhaEmailInvalid {

    private WebDriver driver;
    private EmailInvalido templateEmailInvalido;
    private Email email;

    @Before
    public void inicia() {
        driver = new FirefoxDriver();
        templateEmailInvalido = new EmailInvalido();
        templateEmailInvalido.loadTemplateEmailInvalido();
        email = new Email(driver);
        email.acessar();
    }

    @Test
    public void emailInvalido() throws InterruptedException {
        Usuario emailUsuario = templateEmailInvalido.getUsuario(EmailInvalido.INVALIDO);
        email.recuperar();
        Thread.sleep(4000);
        email.preencheEmail(emailUsuario).enviar();
        Thread.sleep(4000);
        assertEquals("Please insert a valid email",
                driver.findElement(By.className("alert-error")).getText());

    }

    @After
    public void encerre() {
        driver.quit();
    }
}
