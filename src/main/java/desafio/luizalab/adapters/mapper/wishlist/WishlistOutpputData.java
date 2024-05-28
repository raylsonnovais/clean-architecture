package desafio.luizalab.adapters.mapper.wishlist;

import desafio.luizalab.adapters.mapper.OutputMapper;
import desafio.luizalab.core.entity.Wishlist;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class WishlistOutpputData implements OutputMapper<Wishlist, WishlistOutpputData> {

    private UUID id;
    private String customerId;
    private Set<String> productIds;

    @Override
    public WishlistOutpputData fromEntity(Wishlist entity) {

        id = entity.getId();
        customerId = entity.getCustomerId();
        productIds = entity.getProductIds();

        return this;
    }
}
