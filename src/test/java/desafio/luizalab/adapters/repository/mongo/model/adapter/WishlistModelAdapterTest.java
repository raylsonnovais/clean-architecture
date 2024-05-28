package desafio.luizalab.adapters.repository.mongo.model.adapter;

import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import desafio.luizalab.core.entity.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WishlistModelAdapterTest {

    private WishlistModelAdapter adapter;
    private Wishlist wishlist;
    private WishlistModel wishlistModel;

    @BeforeEach
    void setUp() {
        adapter = new WishlistModelAdapter();

        Set<String> productIds = new HashSet<>();
        productIds.add("1");
        productIds.add("2");

        wishlist = Wishlist.builder()
                .id(UUID.randomUUID())
                .customerId("customer1")
                .productIds(productIds)
                .build();

        wishlistModel = new WishlistModel();
        wishlistModel.setId(wishlist.getId());
        wishlistModel.setCustomerId(wishlist.getCustomerId());
        wishlistModel.setProductIds(wishlist.getProductIds());
    }

    @Test
    void toModel_ShouldConvertEntityToModel() {
        WishlistModel model = adapter.toModel(wishlist);

        assertNotNull(model);
        assertEquals(wishlist.getId(), model.getId());
        assertEquals(wishlist.getCustomerId(), model.getCustomerId());
        assertEquals(wishlist.getProductIds(), model.getProductIds());
    }

    @Test
    void toEntity_ShouldConvertModelToEntity() {
        Wishlist entity = adapter.toEntity(wishlistModel);

        assertNotNull(entity);
        assertEquals(wishlistModel.getId(), entity.getId());
        assertEquals(wishlistModel.getCustomerId(), entity.getCustomerId());
        assertEquals(wishlistModel.getProductIds(), entity.getProductIds());
    }

    @Test
    void toModel_ShouldGenerateUUIDWhenIdIsNull() {
        wishlist.setId(null);
        WishlistModel model = adapter.toModel(wishlist);

        assertNotNull(model);
        assertNotNull(model.getId());
        assertEquals(wishlist.getCustomerId(), model.getCustomerId());
        assertEquals(wishlist.getProductIds(), model.getProductIds());
    }
}

