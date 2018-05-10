package br.edu.ifrs.canoas.lds.webapp.web.page;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

@PageUrl("http://localhost:{port}/usuario/perfil")
public class ProfilePage extends FluentPage {

    public void isAt() {
        assertThat(window().title()).isEqualTo("IFRS");
    }

}