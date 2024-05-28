package desafio.luizalab.adapters.mapper.wishlist;


import desafio.luizalab.adapters.mapper.OutputTestUtils;
import desafio.luizalab.core.entity.Wishlist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOutputDataTest {

    @Test
    void shouldConvertFromEntity() {
        Wishlist wishlist = OutputTestUtils.buildWishlist();
        WishlistOutpputData wishlistOutpputData = new WishlistOutpputData().fromEntity(wishlist);

        assertEquals(wishlist.getId(), wishlistOutpputData.getId());
        assertEquals(wishlist.getCustomerId(), wishlistOutpputData.getCustomerId());
    }
}
