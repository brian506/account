package security.account.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import security.account.post.domain.Place;
import security.account.post.domain.Post;


import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

  List<Post> findByPlace(Place place);

  Optional<Post> findByPlaceName(String placeName);

  @Query("SELECT s FROM Post s WHERE s.address.city = :city AND s.address.district = :district AND s.address.road = :road")
  List<Post> findByAddress(@Param("city") String city,@Param("district") String district,@Param("road") String road);
  // 주소 정보를 기반으로 가게 이름을 조회, JPA메서드 쿼리는 메서드 이름을 기반으로 자동으로 쿼리를 생성
}
