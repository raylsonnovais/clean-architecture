package desafio.luizalab.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI createOpenApi() {
        Contact contact = new Contact()
                .email("raylson11@gmail.com")
                .name("Raylson Pereira de Novais Silva");

        Info info = new Info()
                .title("Luiza Labs Api")
                .contact(contact)
                .version("1.0")
                .description("Api para gerenciamento de wislist");

        return new OpenAPI().info(info);
    }
}
