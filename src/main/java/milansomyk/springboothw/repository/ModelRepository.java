package milansomyk.springboothw.repository;

import milansomyk.springboothw.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByName(String name);
}
