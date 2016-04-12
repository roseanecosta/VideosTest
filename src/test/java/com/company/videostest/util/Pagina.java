package com.company.videostest.util;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Rose
 */
public abstract class Pagina {

    protected final WebDriver driver;
    public final static String BASE_URL = "http://198.101.153.219:8088/";

    public Pagina(WebDriver driver) {
        this.driver = driver;
    }

    public abstract Pagina acessar();

    public void desconectar() {
        driver.get(BASE_URL);
    }

}
