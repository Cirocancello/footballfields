package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fields")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FieldsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column(name = "open")
    private String open;

    @Column(name = "close")
    private String close;

//    @OneToMany(mappedBy = "idFields")
//    @JsonIgnore
//    private List<AssociateEntity> members = new ArrayList<>();

    @OneToMany(mappedBy = "idFields")
    @JsonIgnore
    private List<FieldEntity> fields;


}

