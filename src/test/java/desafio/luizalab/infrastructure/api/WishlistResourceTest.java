package desafio.luizalab.infrastructure.api;

import desafio.luizalab.adapters.mapper.wishlist.AddProductWishlistInputData;
import desafio.luizalab.adapters.mapper.wishlist.CreateWishlistInputData;
import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.service.WishlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WishlistResource.class)
class WishlistResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishlistService wishlistService;

    private Wishlist wishlist;

    @BeforeEach
    void setUp() {
        wishlist = Wishlist.builder()
                .id(UUID.randomUUID())
                .customerId("customer1")
                .build();
    }

    @Test
    void testCreateWishlist() throws Exception {
        CreateWishlistInputData inputData = new CreateWishlistInputData();
        inputData.setCustomerId("customer1");

        when(wishlistService.saveWishlist(any(Wishlist.class))).thenReturn(wishlist);

        mockMvc.perform(post("/v1/wishlist")
                        .contentType("application/json")
                        .content("{ \"customerId\": \"customer1\" }"))
                .andExpect(status().isCreated());
    }

    @Test
    void testAddProduct() throws Exception {
        AddProductWishlistInputData inputData = new AddProductWishlistInputData();
        inputData.setCustomerId("customer1");
        inputData.setProductId("product1");

        doNothing().when(wishlistService).addProduct(eq("customer1"), eq("product1"));

        mockMvc.perform(post("/v1/wishlist/add")
                        .contentType("application/json")
                        .content("{ \"customerId\": \"customer1\", \"productId\": \"product1\" }"))
                .andExpect(status().isCreated());
    }
}
