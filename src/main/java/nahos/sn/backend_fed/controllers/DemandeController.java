package nahos.sn.backend_fed.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nahos.sn.backend_fed.dtos.DemandeRequest;
import nahos.sn.backend_fed.dtos.DemandeTdo;
import nahos.sn.backend_fed.entities.Demande;
import nahos.sn.backend_fed.entities.Utilisateur;
import nahos.sn.backend_fed.repositories.DemdandeRepository;
import nahos.sn.backend_fed.services.DemandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/demande")
@Slf4j
public class DemandeController {

    private DemandeService demandeService;
    private DemdandeRepository demdandeRepository;
    @PostMapping("/create")
    public ResponseEntity<DemandeTdo> createDemande(@RequestBody DemandeRequest demandeRequest)
    {
        DemandeTdo demande = demandeService.createdemande(demandeRequest);
        if (demande == null){ return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(demande);
    }
}
