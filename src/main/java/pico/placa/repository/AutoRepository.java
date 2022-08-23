package pico.placa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pico.placa.entity.AutoEntity;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Long> {
    
	Optional<AutoEntity> findByPlacaAndVigenciaIsTrue(String placa);
}
