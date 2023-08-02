package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "features")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FeaturesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "indoor")
    private boolean indoor;

    @Column(name = "heating")
    private boolean heating;

    @Column(name = "ac")
    private boolean ac;

    @OneToOne(targetEntity = FieldEntity.class)
    @JoinColumn(name = "id_field")
    @JsonManagedReference
    private FieldEntity idField;

}
