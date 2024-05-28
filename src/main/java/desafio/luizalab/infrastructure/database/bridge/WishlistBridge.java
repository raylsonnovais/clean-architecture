package desafio.luizalab.infrastructure.database.bridge;

import desafio.luizalab.adapters.repository.mongo.adapter.WishlistRepositoryAdapter;
import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import desafio.luizalab.adapters.repository.mongo.model.adapter.WishlistModelAdapter;
import desafio.luizalab.infrastructure.database.springdata.WishlistMongoRepository;

import java.util.List;
import java.util.Set;

public class WishlistBridge extends WishlistRepositoryAdapter {
    private final WishlistMongoRepository repository;
    public WishlistBridge(WishlistMongoRepository repository, WishlistModelAdapter modelAdapter) {
        super(modelAdapter);
        this.repository = repository;
    }

    @Override
    protected WishlistModel saveBridge(WishlistModel wishlistModel) {
        return repository.save(wishlistModel);
    }

    @Override
    protected WishlistModel findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    protected void removeBridge(WishlistModel wishlistModel, String productId){
        wishlistModel.getProductIds().remove(productId);
        saveBridge(wishlistModel);
    }

    @Override
    public Set<String> allWishlistBridge(String customerId) {
        return repository.findProductIdsByCustomerId(customerId);
    }

    @Override
    public List<WishlistModel> findListByCustomerId(String customerId) {
        return repository.findListByCustomerId(customerId);
    }

}
