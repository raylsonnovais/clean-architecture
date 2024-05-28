package desafio.luizalab.core.usecase.wishlist;

import desafio.luizalab.core.repository.WishlistRepository;

public class RemoveProductInWishlistUseCase {

    private final WishlistRepository wishlistRepository;

    public RemoveProductInWishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void execute(String customerId, String productId) {
        wishlistRepository.removeProduct(customerId,productId);
    }
}
