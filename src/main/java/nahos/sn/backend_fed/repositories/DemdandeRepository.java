package nahos.sn.backend_fed.repositories;

import nahos.sn.backend_fed.entities.Demande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemdandeRepository extends CrudRepository<Demande,Long> {
}
