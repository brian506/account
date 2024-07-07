package security.account.post.domain;

import jakarta.persistence.*;
import lombok.*;
import security.account.timeDomain.BaseTimeEntity;
import security.account.user.domain.Address;
import security.account.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // post 주인
    private User user;
    //xToOne은 모두 무조건 (fetch = FetchType.LAZY)요걸 입력해야 한다!!
    // 값이 다 딸려나오기 때문에 어려움을 겪을 수 있다

    @Enumerated(EnumType.STRING) // enumtype도 같이 입력
    private Place place;

    private String placeName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comment;

    @Enumerated(EnumType.STRING)
    private Rate rate;

    private int score;

    public void setScore(int score) {

        if (rate != null && !rate.ScoreRange(score)) {
            throw new IllegalArgumentException("평점을 다시 확인해주세요.범위 안에 있어야 합니다.");
        }
        this.score = score;
    }

    private LocalDateTime createdDate; // 작성일

    private LocalDateTime modifiedDate; // 수정일

    public void setUser(User user) {
        this.user = user;
    }

    public void setRate(Rate rate) {this.rate = rate;}
}
