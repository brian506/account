package security.account.post.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    // 맛집에 따른 여러 정보들과 같이 embedded
    // 단점에 관해 문자열로 입력
    // 150자 제한

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;


    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}
