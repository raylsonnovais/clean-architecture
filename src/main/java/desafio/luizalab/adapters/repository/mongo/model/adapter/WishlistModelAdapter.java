package desafio.luizalab.adapters.repository.mongo.model.adapter;

import desafio.luizalab.adapters.repository.ModelAdapter;
import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import desafio.luizalab.core.entity.Wishlist;

import java.util.UUID;

public class WishlistModelAdapter implements ModelAdapter<Wishlist, WishlistModel> {
    @Override
    public WishlistModel toModel(Wishlist entity) {
        WishlistModel model = new WishlistModel();

        model.setId(entity.getId() != null ? entity.getId() : UUID.randomUUID());
        model.setCustomerId(entity.getCustomerId());
        model.setProductIds(entity.getProductIds());

        return model;
    }

    @Override
    public Wishlist toEntity(WishlistModel model) {
        return Wishlist.builder()
                .id(model.getId())
                .customerId(model.getCustomerId())
                .productIds(model.getProductIds())
                .build();

    }
}
