package desafio.luizalab.core.usecase.wishlist;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.luizalab.core.repository.WishlistRepository;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindAllProductsByWishlistUseCase {

    private final WishlistRepository wishlistRepository;

    public FindAllProductsByWishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Set<String> execute(String customerId) {
        LinkedHashSet<String> jsonSet = (LinkedHashSet<String>) wishlistRepository.allProductsWishlist(customerId);
        if (jsonSet.isEmpty()) {
            return new HashSet<>();
        }

        String json = jsonSet.iterator().next();
        Set<String> productIdsSet = new HashSet<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);
            JsonNode productIdsNode = rootNode.get("productIds");
            if (productIdsNode != null && productIdsNode.isArray()) {
                for (JsonNode idNode : productIdsNode) {
                    productIdsSet.add(idNode.asText());
                }
            }
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return productIdsSet;
    }
}
