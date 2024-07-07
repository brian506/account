package security.account.post.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import security.account.post.domain.Comment;
import security.account.post.domain.Place;
import security.account.post.domain.Post;
import security.account.post.domain.Rate;
import security.account.user.domain.Address;

import java.util.List;

@Getter
 public class PostRequestDto {

    private Long userId;

    private Place place;

    private String placeName;

    private Address address;

    @Size(max = 150)
    private List<Comment> comments;

    private Rate rate;

    private int score;



    public Post toEntity(){
        return Post.builder()
                .place(place)
                .placeName(placeName)
                .address(address)
                .comment(comments)
                .rate(rate)
                .score(score)
                .build();
    }
}
