package security.account.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import security.account.post.domain.Place;
import security.account.post.domain.Post;
import security.account.post.domain.Rate;
import security.account.post.domain.Address;

import java.time.LocalDateTime;


@Getter
 public class PostRequestDto {

    private Long userId;

    private Place place;

    @NotBlank(message = "가게 이름 정보는 필수 입니다")
    private String placeName;

    private Address address;

    @Size(max = 150)
    private String comment;


    private Rate rate;

    private int score;


    public Post toEntity(){
        return Post.builder()
                .place(place)
                .placeName(placeName)
                .address(address)
                .comment(comment)
                .rate(rate)
                .score(score)
                .build();
    }
}
