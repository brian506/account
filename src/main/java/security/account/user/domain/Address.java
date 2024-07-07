package security.account.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
public class Address {
    // 맛집 장소에 대한 상세주소

    private String city;
    private String district; //구
    private String road;

    public Address toEntity(){
        return Address.builder()
                .city(city)
                .district(district)
                .road(road)
                .build();
    }
}
