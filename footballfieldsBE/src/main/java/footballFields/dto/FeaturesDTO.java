package footballFields.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FeaturesDTO {
    private Long id;
    private boolean indoor;
    private boolean heating;
    private boolean ac;
}
