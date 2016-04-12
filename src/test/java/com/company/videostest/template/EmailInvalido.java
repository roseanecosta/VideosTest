package com.company.videostest.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.company.videostest.model.Usuario;

/**
 *
 * @author Rose
 */
public class EmailInvalido {

    public static String INVALIDO = "invalido";

    public void loadTemplateEmailInvalido() {
        Fixture.of(Usuario.class).addTemplate(INVALIDO, new Rule() {
            {
                 /* gera os dados aleatoriamente com 16 letras
                    para inserção nos inputs a cada nova execução de teste 
                 */
                add("email", regex("(\\w{16})"));

            }
        });
    }

    public Usuario getUsuario(String template) {
        return Fixture.from(Usuario.class).gimme(template);
    }

}
