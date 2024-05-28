package desafio.luizalab.core.service;

import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.usecase.wishlist.*;

import java.util.Set;

public class WishlistService {

    private final AddProductInWishlistUseCase addProductInWishlistUseCase;
    private final FindAllProductsByWishlistUseCase findAllProductsByWishlistUseCase;
    private final IsProductInWishlistUseCase isProductInWishlistUseCase;
    private final RemoveProductInWishlistUseCase removeProductInWishlistUseCase;
    private final SaveWishListUseCase saveWishListUseCase;


    public WishlistService(AddProductInWishlistUseCase addProductInWishlistUseCase, FindAllProductsByWishlistUseCase findAllProductsByWishlistUseCase, IsProductInWishlistUseCase isProductInWishlistUseCase, RemoveProductInWishlistUseCase removeProductInWishlistUseCase, SaveWishListUseCase saveWishListUseCase) {
        this.addProductInWishlistUseCase = addProductInWishlistUseCase;
        this.findAllProductsByWishlistUseCase = findAllProductsByWishlistUseCase;
        this.isProductInWishlistUseCase = isProductInWishlistUseCase;
        this.removeProductInWishlistUseCase = removeProductInWishlistUseCase;
        this.saveWishListUseCase = saveWishListUseCase;
    }

    public Set<String> findAllProductsByWishlist(String customerId){
        return findAllProductsByWishlistUseCase.execute(customerId);
    }

    public void addProduct(String customerId, String productId){
        addProductInWishlistUseCase.execute(customerId, productId);
    }

    public void removeProduct(String customerId, String productId){
        removeProductInWishlistUseCase.execute(customerId, productId);
    }

    public boolean isProductInWishlist(String customerId, String productId){
        return isProductInWishlistUseCase.isProductInWishlist(customerId, productId);
    }

    public Wishlist saveWishlist(Wishlist wishlist){
        return saveWishListUseCase.execute(wishlist);
    }
}
