package footballFields.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {
    private Long id;
    private String userName;
    private String password;
    private enum ruolo {ADMIN, USER};

}
