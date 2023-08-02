package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "associate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AssociateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @Column(name = "mobile")
    private String mobile;

    @ManyToOne(targetEntity = FieldsEntity.class)
    @JoinColumn(name = "id_fields")
    @JsonManagedReference
    private FieldsEntity idFields;

    @OneToMany(mappedBy = "idAssociate")
   @JsonManagedReference
    private List<BookingEntity> bookings = new ArrayList<>();


}
