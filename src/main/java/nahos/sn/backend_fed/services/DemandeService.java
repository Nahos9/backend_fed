package nahos.sn.backend_fed.services;

import lombok.AllArgsConstructor;
import nahos.sn.backend_fed.dtos.DemandeRequest;
import nahos.sn.backend_fed.dtos.DemandeTdo;
import nahos.sn.backend_fed.entities.Demande;
import nahos.sn.backend_fed.entities.TypeStatut;
import nahos.sn.backend_fed.entities.Utilisateur;
import nahos.sn.backend_fed.repositories.DemdandeRepository;
import nahos.sn.backend_fed.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DemandeService {
    private DemdandeRepository demdandeRepository;
    private UtilisateurRepository utilisateurRepository;
    public DemandeTdo createdemande(DemandeRequest demandeRequest){

        Optional<Utilisateur> user = this.utilisateurRepository.findById(demandeRequest.getUser_id());
        Demande demande = new Demande();
        demande.setObjetDemande(demandeRequest.getObjetDemande());
        demande.setDateDemande(demandeRequest.getDateDemande());
        demande.setMontant(demandeRequest.getMontant());
        demande.setNom(demandeRequest.getNom());
        demande.setPrenom(demandeRequest.getPrenom());
        demande.setDescription(demandeRequest.getDescription());
        demande.setPoste(demandeRequest.getPoste());
        demande.setQuantite(demandeRequest.getQuantite());
        if(user.isPresent()){
            demande.setUtilisateur(user.get());
        }
        demande.setStatut(TypeStatut.ENCOURS);
        Demande demandeSave =demdandeRepository.save(demande);
        DemandeTdo dem = new DemandeTdo();
        dem.setDatedemande(demandeSave.getDateDemande());
      return dem;

    }
}
