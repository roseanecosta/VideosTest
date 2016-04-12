package com.company.videostest.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.company.videostest.model.Usuario;

/**
 *
 * @author Rose
 */
public class UsuarioInvalido {

    public static String INVALIDO = "invalido";

    public void loadTemplateUsuarioInvalido() {
        Fixture.of(Usuario.class).addTemplate(INVALIDO, new Rule() {
            {
                /* gera os dados aleatoriamente combinando os seguintes valores
                 para inserção nos inputs a cada nova execução de teste 
                 */
                add("email", random("qasmb01@gmail.com", "teste@live.com", "", "rose@teste.com"));
                add("senha", random("12345", "qasmb01124", ""));
            }
        });
    }

    public Usuario getUsuario(String template) {
        return Fixture.from(Usuario.class).gimme(template);
    }

}
