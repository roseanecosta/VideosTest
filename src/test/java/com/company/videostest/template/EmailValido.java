package com.company.videostest.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.company.videostest.model.Usuario;

/**
 *
 * @author Rose
 */
public class EmailValido {

    public static String VALIDO = "valido";

    public void loadTemplateEmailValido() {
        Fixture.of(Usuario.class).addTemplate(VALIDO, new Rule() {
            {
                add("email", "qasmb01@gmail.com");
            }
        });
    }

    public Usuario getUsuario(String template) {
        return Fixture.from(Usuario.class).gimme(template);
    }

}
