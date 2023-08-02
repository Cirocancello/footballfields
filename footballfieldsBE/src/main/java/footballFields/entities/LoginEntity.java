package footballFields.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import utils.Ruolo;

@Entity
@Table(name = "login")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "ruolo")
    private Ruolo ruolo;

    @ManyToOne(targetEntity = AssociateEntity.class)
    @JoinColumn(name = "id_associate")
    @JsonManagedReference
    private AssociateEntity idAssociate;




}
