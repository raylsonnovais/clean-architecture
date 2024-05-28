package desafio.luizalab.adapters.repository.mongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document("wishlist")
public class WishlistModel {

    @Id
    private UUID id;
    private String customerId;
    private Set<String> productIds;

    public WishlistModel() {
        this.id = UUID.randomUUID();
    }

}
