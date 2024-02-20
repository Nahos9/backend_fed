package nahos.sn.backend_fed.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demande_id;
    private String nom;
    private String prenom;
    private String description;
    private String poste;
    private String objetDemande;
    private Double montant;
    private  Integer quantite;
    private String commentaire;
    @Enumerated(EnumType.STRING)
    private TypeStatut statut;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyy-MM-dd")
    private LocalDate dateDemande;
    @ManyToOne
    private Utilisateur utilisateur;


}
