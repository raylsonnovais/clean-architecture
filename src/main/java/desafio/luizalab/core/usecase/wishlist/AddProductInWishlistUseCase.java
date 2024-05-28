package desafio.luizalab.core.usecase.wishlist;

import desafio.luizalab.core.repository.WishlistRepository;

public class AddProductInWishlistUseCase {
    private final WishlistRepository wishlistRepository;

    public AddProductInWishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void execute(String customerId, String productId) {
        wishlistRepository.addProduct(customerId,productId);
    }
}
