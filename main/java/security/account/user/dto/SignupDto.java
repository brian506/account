package security.account.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import security.account.user.domain.User;

@Getter
//@NoArgsConstructor(force = true)
// final로 생성되어 있는 경우에는 필드를 초기화할 수 없기 때문에 생성자를 만들수 없고 에러 발생
// -> 해결 : (force = true)옵션 이용해서 final 필드를 0,false,null등으로 강제 초기화해서 생성자 생성

public class SignupDto {

    @Email
    @NotBlank(message = "이메일 형식을 준수하세요")
    private String email;

    @NotBlank
    @Size(min = 8, message = "비밀번호는 8자리 이상으로 입력해주세요")
    private String password;

   @NotBlank
   @Size(min = 3,message = "이름은 3자리 이상 입력하셔야 합니다.")
   private String username;

    public User toEntity(){ //엔티티로 변환
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }


}

/**
 * DTO란?
 * 계층간 데이터 전송을 위해 도메인 모델 대신 사용되는 객체 (계층이란 view controller service dao repository)
 *
 * DTO는 순수하게 데이터를 저장하고 데이터에 대한 getter setter 만을 가져야함 ( 비즈니스 로직 X)
 */