package desafio.luizalab.infrastructure.factory;

import desafio.luizalab.adapters.repository.mongo.model.adapter.WishlistModelAdapter;
import desafio.luizalab.core.repository.WishlistRepository;
import desafio.luizalab.core.service.WishlistService;
import desafio.luizalab.core.usecase.wishlist.*;
import desafio.luizalab.infrastructure.database.bridge.WishlistBridge;
import desafio.luizalab.infrastructure.database.springdata.WishlistMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WishlistServiceFactory {

    private final WishlistMongoRepository wishlistMongoRepositoryImpl;

    @Autowired
    public WishlistServiceFactory(WishlistMongoRepository wishlistMongoRepositoryImpl) {
        this.wishlistMongoRepositoryImpl = wishlistMongoRepositoryImpl;
    }

    @Bean
    @Autowired
    public WishlistService createWishlistService(WishlistRepository wishlistRepository){
        AddProductInWishlistUseCase addProductInWishlistUseCase = new AddProductInWishlistUseCase(wishlistRepository);
        FindAllProductsByWishlistUseCase findAllProductsByWishlistUseCase = new FindAllProductsByWishlistUseCase(wishlistRepository);
        IsProductInWishlistUseCase isProductInWishlistUseCase = new IsProductInWishlistUseCase(wishlistRepository);
        RemoveProductInWishlistUseCase removeProductInWishlistUseCase = new RemoveProductInWishlistUseCase(wishlistRepository);
        SaveWishListUseCase saveWishListUseCase = new SaveWishListUseCase(wishlistRepository);

        return new WishlistService(addProductInWishlistUseCase, findAllProductsByWishlistUseCase, isProductInWishlistUseCase, removeProductInWishlistUseCase, saveWishListUseCase);
    }

    @Bean
    public WishlistRepository createWishlistRepository() {
        WishlistModelAdapter modelAdapter = new WishlistModelAdapter();
        WishlistBridge repository = new WishlistBridge(wishlistMongoRepositoryImpl, modelAdapter);

        return repository;
    }


}
