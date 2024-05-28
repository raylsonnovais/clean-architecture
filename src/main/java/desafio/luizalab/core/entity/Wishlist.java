package desafio.luizalab.core.entity;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlist {
    private UUID id;
    private String customerId;
    private Set<String> productIds;

    public Wishlist(String customerId) {
        this.customerId = customerId;
    }
}
