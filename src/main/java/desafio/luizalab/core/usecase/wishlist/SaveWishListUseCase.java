package desafio.luizalab.core.usecase.wishlist;

import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.repository.WishlistRepository;

public class SaveWishListUseCase {
    private final WishlistRepository wishlistRepository;

    public SaveWishListUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist execute(Wishlist wishlist){
        return wishlistRepository.saveWishList(wishlist);
    }
}
