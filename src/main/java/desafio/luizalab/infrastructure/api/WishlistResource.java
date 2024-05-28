package desafio.luizalab.infrastructure.api;

import desafio.luizalab.adapters.mapper.wishlist.AddProductWishlistInputData;
import desafio.luizalab.adapters.mapper.wishlist.CreateWishlistInputData;
import desafio.luizalab.adapters.mapper.wishlist.RemoveProductWishlistInputData;
import desafio.luizalab.adapters.mapper.wishlist.WishlistOutpputData;
import desafio.luizalab.core.entity.Wishlist;
import desafio.luizalab.core.service.WishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Wishlist", description = "Wishlist crud")
@RestController
@RequestMapping("/v1/wishlist")
public class WishlistResource extends RestResource {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistResource(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @Operation(summary = "Criar wishlist")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registro Criado", content = {
                    @Content(schema = @Schema(implementation = WishlistOutpputData.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody CreateWishlistInputData createWishlistInputData){
         Wishlist wl = wishlistService.saveWishlist(createWishlistInputData.toEntity());
        return created(getLocation(wl.getId()));
    }

    @PostMapping("add")
    @Operation(summary = "Adicionar produto wishlist")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> addProduct(@RequestBody AddProductWishlistInputData addProductWishlistInputData){
        wishlistService.addProduct(addProductWishlistInputData.getCustomerId(), addProductWishlistInputData.getProductId());
        return created(getLocation(addProductWishlistInputData.getCustomerId()));
    }

    @PostMapping("remove")
    public ResponseEntity<Void> addProduct(@RequestBody RemoveProductWishlistInputData removeProductWishlistInputData){
        wishlistService.removeProduct(removeProductWishlistInputData.getCustomerId(), removeProductWishlistInputData.getProductId());
        return created(getLocation(removeProductWishlistInputData.getCustomerId()));
    }

    @GetMapping("/{customerId}/{productId}")
    public ResponseEntity<Boolean> isProductInWishList(@PathVariable String customerId, @PathVariable String productId){
        return ResponseEntity
                .ok(wishlistService.isProductInWishlist(customerId, productId));
    }
}
