package com.company.videostest.preenchimento;

import com.company.videostest.model.Usuario;
import com.company.videostest.util.Pagina;
import static com.company.videostest.util.Pagina.BASE_URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rose
 */
public class Email extends Pagina {

    public Email(WebDriver driver) {
        super(driver);
    }

    @Override
    public Pagina acessar() {
        driver.get(BASE_URL + "auth/login");
        return this;

    }

    public Email preencheEmail(Usuario emailUsuario) {
        driver.findElement(By.name("email")).sendKeys(emailUsuario.getEmail());
        return this;

    }

    public void recuperar() {
        driver.findElement(By.id("forgot-pwd-link")).click();
    }

    public void enviar() {
        driver.findElement(By.className("btn")).submit();
    }
}
