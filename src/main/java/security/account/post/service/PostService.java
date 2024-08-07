package security.account.post.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.account.exception.ResourceNotFoundException;
import security.account.post.domain.Place;
import security.account.post.domain.Post;
import security.account.post.dto.PostRequestDto;
import security.account.post.repository.PostRepository;
import security.account.user.domain.User;
import security.account.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Transactional(readOnly = false)
    public Long createPost(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // user는 따로 입력 받아야 하므로 userRepository에서 불러온다
        // signupdto로 user엔티티 생성,조회

        Post post  = postRequestDto.toEntity();
        // post 엔티티 생성
        post.setUser(user);
        //post 엔티티에 user 설정

        post.setRate(postRequestDto.getRate());
        post.setScore(postRequestDto.getScore());

        return postRepository.save(post).getId();
    }


    public List<Post> findPostsByPlace(Place place) {
        return postRepository.findByPlace(place);
    }

    public Optional<Post> findPostsByPlaceName(String placeName){
        return postRepository.findByPlaceName(placeName);
    }
}
