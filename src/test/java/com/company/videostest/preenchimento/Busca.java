package com.company.videostest.preenchimento;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rose
 */
public class Busca {

    private final WebDriver driver;

    public Busca(WebDriver driver) {
        this.driver = driver;
    }

    public Busca preencheConteudo() {
        driver.findElement(By.id("as-input-061")).sendKeys("baleada");
        return this;
    }

    public void selecionaOpcao() {
        driver.findElement(By.id("mn-content")).click();
    }

    public void enter() {
        driver.findElement(By.id("as-input-061")).sendKeys(Keys.ENTER);
    }
}
