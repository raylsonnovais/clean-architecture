package desafio.luizalab.core.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WishlistTest {

    private Wishlist wishlist;
    private UUID id;
    private String customerId;
    private Set<String> productIds;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        customerId = "customer1";
        productIds = new HashSet<>();
        productIds.add("1");
        productIds.add("2");

        wishlist = Wishlist.builder()
                .id(id)
                .customerId(customerId)
                .productIds(productIds)
                .build();
    }

    @Test
    void testNoArgsConstructor() {
        Wishlist wishlist = new Wishlist();
        assertNull(wishlist.getId());
        assertNull(wishlist.getCustomerId());
        assertNull(wishlist.getProductIds());
    }

    @Test
    void testAllArgsConstructor() {
        Wishlist wishlist = new Wishlist(id, customerId, productIds);
        assertEquals(id, wishlist.getId());
        assertEquals(customerId, wishlist.getCustomerId());
        assertEquals(productIds, wishlist.getProductIds());
    }

    @Test
    void testBuilder() {
        assertNotNull(wishlist);
        assertEquals(id, wishlist.getId());
        assertEquals(customerId, wishlist.getCustomerId());
        assertEquals(productIds, wishlist.getProductIds());
    }

    @Test
    void testGettersAndSetters() {
        Wishlist wishlist = new Wishlist();
        wishlist.setId(id);
        wishlist.setCustomerId(customerId);
        wishlist.setProductIds(productIds);

        assertEquals(id, wishlist.getId());
        assertEquals(customerId, wishlist.getCustomerId());
        assertEquals(productIds, wishlist.getProductIds());
    }

    @Test
    void testCustomerIdConstructor() {
        Wishlist wishlist = new Wishlist(customerId);
        assertNotNull(wishlist);
        assertEquals(customerId, wishlist.getCustomerId());
        assertNull(wishlist.getId());
        assertNull(wishlist.getProductIds());
    }
}

