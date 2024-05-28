package desafio.luizalab.adapters.mapper.wishlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveProductWishlistInputData {
    private String customerId;
    private String productId;
}
