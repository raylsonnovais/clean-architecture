package desafio.luizalab.adapters.repository.mongo.adapter;

import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import desafio.luizalab.adapters.repository.mongo.model.adapter.WishlistModelAdapter;
import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.exception.CustomerIdDuplicate;
import desafio.luizalab.core.exception.WishlistEmptyException;
import desafio.luizalab.core.exception.WishlistFullException;
import desafio.luizalab.core.repository.WishlistRepository;

import java.util.List;
import java.util.Set;

public abstract class WishlistRepositoryAdapter implements WishlistRepository {

    private final WishlistModelAdapter modelAdapter;
    private static final int MAX_PRODUCTS = 20;

    public WishlistRepositoryAdapter(WishlistModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
    }

    @Override
    public void addProduct(String customerId, String productId) {
        if(isWishlistFull(customerId)){
            throw new WishlistFullException("A lista de desejos está cheia. Limite máximo de " + MAX_PRODUCTS + " produtos atingido.");
        }
        WishlistModel wishlistmodel = findByCustomerId(customerId);
        wishlistmodel.getProductIds().add(productId);
        saveBridge(wishlistmodel);
    }

    @Override
    public void removeProduct(String customerId, String productId) {
        WishlistModel wishlistmodel = findByCustomerId(customerId);
        removeBridge(wishlistmodel, productId);
    }

    @Override
    public Wishlist getWishlist(String customerId) {
        return modelAdapter.toEntity(findByCustomerId(customerId));
    }

    @Override
    public Set<String> allProductsWishlist(String customerId) {
        return allWishlistBridge(customerId);
    }

    @Override
    public boolean isProductInWishlist(String customerId, String productId) {
        WishlistModel wishlistModel = findByCustomerId(customerId);
        if (wishlistModel != null) {
            return wishlistModel.getProductIds().contains(productId);
        }
        return false;
    }

    @Override
    public Wishlist saveWishList(Wishlist wishlist){
        validate(wishlist);
        WishlistModel model = modelAdapter.toModel(wishlist);
        return modelAdapter.toEntity(saveBridge(model));
    }

    private boolean isWishlistFull(String customerId) {
        WishlistModel wishlistModel = findByCustomerId(customerId);
        return wishlistModel.getProductIds().size() >= MAX_PRODUCTS;
    }


    private boolean isWishlistFull(Wishlist wishlist) {
        return wishlist.getProductIds().size() >= MAX_PRODUCTS;
    }

    private boolean isCustomerDuplicate(String customerId){
        List<WishlistModel> wishlistModel = findListByCustomerId(customerId);
        if(wishlistModel.stream().anyMatch(item -> item.getCustomerId().equals(customerId))){
            return true;
        }
        return false;
    }

    private void validate(Wishlist wishlist) {
        if (isCustomerDuplicate(wishlist.getCustomerId())) {
            throw new CustomerIdDuplicate("Não é permitido cadastro duplicado");
        }
        if(isWishlistFull(wishlist)){
            throw new WishlistFullException("A lista de desejos está cheia. Limite máximo de " + MAX_PRODUCTS + " produtos atingido.");
        }
        if (wishlist.getProductIds().isEmpty()) {
            throw new WishlistEmptyException("Lista de Produtos vazia");
        }
    }

    protected WishlistModel saveBridge(WishlistModel wishlistModel) {
        return wishlistModel;
    }

    protected abstract WishlistModel findByCustomerId(String customerId);

    protected abstract void removeBridge(WishlistModel wishlistModel, String productId);

    public abstract Set<String> allWishlistBridge(String customerId);

    public abstract List<WishlistModel> findListByCustomerId (String customerId);
}
