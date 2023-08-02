package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private String time;

    @ManyToOne(targetEntity = FieldEntity.class)
    @JoinColumn(name = "id_field")
    @JsonBackReference
    private FieldEntity idField;

    @ManyToOne(targetEntity = AssociateEntity.class)
    @JoinColumn(name = "id_associate")
    @JsonBackReference
    private AssociateEntity idAssociate;

}
