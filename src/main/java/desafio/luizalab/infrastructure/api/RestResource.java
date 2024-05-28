package desafio.luizalab.infrastructure.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@CrossOrigin(exposedHeaders = {"X-Total-Count"})
public class RestResource {

    protected URI getLocation(UUID id) {
        return getLocation(id.toString());
    }

    protected URI getLocation(long id) {
        return getLocation(String.valueOf(id));
    }

    protected URI getLocation(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    protected ResponseEntity<Void> created(URI uri) {
        return ResponseEntity.created(uri).build();
    }

}
