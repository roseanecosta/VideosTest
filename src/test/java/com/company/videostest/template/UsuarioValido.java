package com.company.videostest.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.company.videostest.model.Usuario;

/**
 *
 * @author Rose
 */
public class UsuarioValido {

    public static String VALIDO = "valido";

    public void loadTemplateUsuarioValido() {
        Fixture.of(Usuario.class).addTemplate(VALIDO, new Rule() {
            {
                add("email", "qasmb01@gmail.com");
                add("senha", "qasmb01123");
            }
        });
    }

    public Usuario getUsuario(String template) {
        return Fixture.from(Usuario.class).gimme(template);
    }

}
