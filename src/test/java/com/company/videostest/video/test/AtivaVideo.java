package com.company.videostest.video.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Busca;
import com.company.videostest.preenchimento.Login;
import com.company.videostest.template.UsuarioValido;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Rose
 */
public class AtivaVideo {

    private WebDriver driver;
    private UsuarioValido templateUsuario;
    private Login login;
    private Busca busca;

    @Before
    public void inicia() {
        driver = new FirefoxDriver();
        templateUsuario = new UsuarioValido();
        templateUsuario.loadTemplateUsuarioValido();
        busca = new Busca(driver);
        login = new Login(driver);
        login.acessar();
        Usuario usuario = templateUsuario.getUsuario(UsuarioValido.VALIDO);
        login.preencherLogin(usuario).logar();

    }

    public void buscaVideo() throws InterruptedException {
        Thread.sleep(5000);
        busca.selecionaOpcao();
        Thread.sleep(4000);
        busca.preencheConteudo().enter();
        Thread.sleep(1000);
    }

    @Test
    public void ativaVideo() throws InterruptedException {
        buscaVideo();
        driver.findElement(By.id("check-all")).click();
        driver.findElement(By.id("bash-action")).click();
        driver.findElement(By.xpath("//select/option[@value='activate']")).click();
        driver.findElement(By.id("bash-action")).sendKeys(Keys.ENTER);
        assertEquals("Video -", driver.findElement(By.className("icon-14-video-green")).getText());
    }

    @After
    public void encerre() {
        driver.quit();
    }

}
