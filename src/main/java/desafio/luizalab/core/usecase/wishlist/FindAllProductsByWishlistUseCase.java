package desafio.luizalab.core.usecase.wishlist;

import desafio.luizalab.core.repository.WishlistRepository;

import java.util.Set;

public class FindAllProductsByWishlistUseCase {

    private final WishlistRepository wishlistRepository;

    public FindAllProductsByWishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Set<String> execute(String customerId){
        return wishlistRepository.allProductsWishlist(customerId);
    }
}
