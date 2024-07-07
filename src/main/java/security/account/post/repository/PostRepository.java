package security.account.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.account.post.domain.Place;
import security.account.post.domain.Post;


import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

  List<Post> findByPlace(Place place);

  Optional<Post> findByPlaceName(String placeName);


}
