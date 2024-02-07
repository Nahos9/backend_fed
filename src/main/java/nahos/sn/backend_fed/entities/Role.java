package nahos.sn.backend_fed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nahos.sn.backend_fed.enums.TypeRole;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Enumerated(EnumType.STRING)
    private TypeRole libelle;
}
