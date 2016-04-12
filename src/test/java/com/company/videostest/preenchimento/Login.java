package com.company.videostest.preenchimento;

import com.company.videostest.model.Usuario;
import com.company.videostest.util.Pagina;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rose
 */
public class Login extends Pagina {

    public Login(WebDriver driver) {
        super(driver);
    }

    @Override
    public Pagina acessar() {
        driver.get(BASE_URL + "auth/login");
        return this;

    }

    public Login preencherLogin(Usuario usuario) {
        driver.findElement(By.id("inputEmail")).sendKeys(usuario.getEmail());
        driver.findElement(By.id("inputPassword")).sendKeys(usuario.getSenha());
        return this;

    }

    public void logar() {
        driver.findElement(By.id("login")).submit();
    }

}
