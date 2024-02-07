package nahos.sn.backend_fed.repositories;

import nahos.sn.backend_fed.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String email);
}
