package desafio.luizalab.core.service;

import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.usecase.wishlist.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WishlistServiceTest {

    @Mock
    private AddProductInWishlistUseCase addProductInWishlistUseCase;

    @Mock
    private FindAllProductsByWishlistUseCase findAllProductsByWishlistUseCase;

    @Mock
    private IsProductInWishlistUseCase isProductInWishlistUseCase;

    @Mock
    private RemoveProductInWishlistUseCase removeProductInWishlistUseCase;

    @Mock
    private SaveWishListUseCase saveWishListUseCase;

    @InjectMocks
    private WishlistService wishlistService;

    private String customerId;
    private String productId;
    private Wishlist wishlist;

    @BeforeEach
    void setUp() {
        customerId = "customer1";
        productId = "product1";
        Set<String> productIds = new HashSet<>();
        productIds.add(productId);
        wishlist = Wishlist.builder()
                .id(UUID.randomUUID())
                .customerId(customerId)
                .productIds(productIds)
                .build();
    }

    @Test
    void testFindAllProductsByWishlist() {
        Set<String> expectedProducts = new HashSet<>();
        expectedProducts.add(productId);

        when(findAllProductsByWishlistUseCase.execute(customerId)).thenReturn(expectedProducts);

        Set<String> actualProducts = wishlistService.findAllProductsByWishlist(customerId);
        assertEquals(expectedProducts, actualProducts);

        verify(findAllProductsByWishlistUseCase).execute(customerId);
    }

    @Test
    void testAddProduct() {
        doNothing().when(addProductInWishlistUseCase).execute(customerId, productId);

        wishlistService.addProduct(customerId, productId);

        verify(addProductInWishlistUseCase).execute(customerId, productId);
    }

    @Test
    void testRemoveProduct() {
        doNothing().when(removeProductInWishlistUseCase).execute(customerId, productId);

        wishlistService.removeProduct(customerId, productId);

        verify(removeProductInWishlistUseCase).execute(customerId, productId);
    }

    @Test
    void testIsProductInWishlist() {
        when(isProductInWishlistUseCase.isProductInWishlist(customerId, productId)).thenReturn(true);

        boolean result = wishlistService.isProductInWishlist(customerId, productId);
        assertTrue(result);

        verify(isProductInWishlistUseCase).isProductInWishlist(customerId, productId);
    }

    @Test
    void testSaveWishlist() {
        when(saveWishListUseCase.execute(wishlist)).thenReturn(wishlist);

        Wishlist savedWishlist = wishlistService.saveWishlist(wishlist);
        assertEquals(wishlist, savedWishlist);

        verify(saveWishListUseCase).execute(wishlist);
    }
}
