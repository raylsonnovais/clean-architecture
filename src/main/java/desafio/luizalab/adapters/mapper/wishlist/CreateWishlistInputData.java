package desafio.luizalab.adapters.mapper.wishlist;

import desafio.luizalab.adapters.mapper.InputMapper;
import desafio.luizalab.core.entity.Wishlist;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateWishlistInputData implements InputMapper<Wishlist> {

    private String customerId;
    private Set<String> productIds;

    @Override
    public Wishlist toEntity(){
        return Wishlist.builder()
                .customerId(customerId).
                productIds(productIds)
                .build();
    }
}
