package desafio.luizalab.core.repository;

import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import desafio.luizalab.core.entity.Wishlist;

import java.util.List;
import java.util.Set;

public interface WishlistRepository {
    void addProduct(String customerId, String productId);

    void removeProduct(String customerId, String productId);

    Wishlist getWishlist(String customerId);

    List<WishlistModel> findListByCustomerId(String customerId);

    Set<String> allProductsWishlist(String customerId);

    boolean isProductInWishlist(String customerId, String productId);

    Wishlist saveWishList(Wishlist wishlist);
}
