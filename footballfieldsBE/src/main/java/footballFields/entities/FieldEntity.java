package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "field")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FieldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(targetEntity = FieldsEntity.class)
    @JoinColumn(name = "idField")
    @JsonManagedReference
    private FieldsEntity idFields;

//    @OneToOne(mappedBy = "idField")
//    @PrimaryKeyJoinColumn
//    private FeaturesEntity features;

    @OneToMany(mappedBy = "idField")
    @JsonManagedReference
    private List<BookingEntity> bookings = new ArrayList<>();
}
