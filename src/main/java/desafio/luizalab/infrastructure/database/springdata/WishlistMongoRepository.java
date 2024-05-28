package desafio.luizalab.infrastructure.database.springdata;

import desafio.luizalab.adapters.repository.mongo.model.WishlistModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface WishlistMongoRepository extends MongoRepository<WishlistModel, UUID> {

    @Query("{ 'customerId' : ?0 }")
    List<WishlistModel> findListByCustomerId(String customerId);

    WishlistModel findByCustomerId(String customerId);
    Set<String> findProductIdsByCustomerId(String customerId);
}
