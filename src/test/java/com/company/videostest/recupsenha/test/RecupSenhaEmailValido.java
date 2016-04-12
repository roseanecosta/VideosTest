package com.company.videostest.recupsenha.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Email;
import com.company.videostest.template.EmailValido;
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
public class RecupSenhaEmailValido {

    private WebDriver driver;
    private EmailValido templateEmailValido;
    private Email email;

    @Before
    public void inicia() {
        driver = new FirefoxDriver();
        templateEmailValido = new EmailValido();
        templateEmailValido.loadTemplateEmailValido();
        email = new Email(driver);
        email.acessar();
    }

    @Test
    public void emailInvalido() throws InterruptedException {
        Usuario emailUsuario = templateEmailValido.getUsuario(EmailValido.VALIDO);
        email.recuperar();
        Thread.sleep(4000);
        email.preencheEmail(emailUsuario).enviar();
        Thread.sleep(4000);
        assertEquals("Almost! We have sended an email with instructions for your new password.",
                driver.findElement(By.className("alert-info")).getText());
        Thread.sleep(500);

    }

    @After
    public void encerre() {
        driver.quit();
    }

}
