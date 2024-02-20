package nahos.sn.backend_fed.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import nahos.sn.backend_fed.entities.TypeStatut;
import nahos.sn.backend_fed.entities.Utilisateur;

import java.time.LocalDate;
import java.util.Date;

@Data
public class DemandeTdo {
    private Long demande_id;
    private String nom;
    private String prenom;
    private String description;
    private String poste;
    private String objetDemande;
    private Double montant;
    private  Integer quantite;
    private LocalDate datedemande;
    //private Utilisateur utilisateur;
}
