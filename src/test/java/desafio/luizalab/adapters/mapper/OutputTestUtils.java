package desafio.luizalab.adapters.mapper;

import desafio.luizalab.core.entity.Wishlist;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class OutputTestUtils {

    public static Wishlist buildWishlist() {
        UUID id = UUID.randomUUID();
        String customerId = "5";
        Set<String> productsIds = new HashSet<>();
        productsIds.add("3");
        productsIds.add("4");

        return new Wishlist(id, customerId, productsIds);

    }
}
