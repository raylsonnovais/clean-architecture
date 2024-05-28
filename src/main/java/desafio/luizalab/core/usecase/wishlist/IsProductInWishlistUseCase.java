package desafio.luizalab.core.usecase.wishlist;

import desafio.luizalab.core.repository.WishlistRepository;

public class IsProductInWishlistUseCase {

    private final WishlistRepository wishlistRepository;

    public IsProductInWishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public boolean isProductInWishlist(String customerId, String productId) {
        return wishlistRepository.isProductInWishlist(customerId, productId);
    }
}
