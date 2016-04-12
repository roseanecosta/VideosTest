package com.company.videostest.buscaconteudo.test;

import com.company.videostest.model.Usuario;
import com.company.videostest.preenchimento.Busca;
import com.company.videostest.preenchimento.Login;
import com.company.videostest.template.UsuarioValido;
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
public class BuscaConteudo {

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

    @Test
    public void buscaValida() throws InterruptedException {
        Thread.sleep(5000);
        busca.selecionaOpcao();
        Thread.sleep(4000);
        busca.preencheConteudo().enter();
        Thread.sleep(1000);
        assertEquals("baleada", driver.findElement(By.className("search-query-value")).getText());

    }

    @After
    public void encerre() {
        driver.quit();
    }
}
