package footballFields.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FieldsDTO {
    private Long id;
    private String name;
    private String open;
    private String close;
}
