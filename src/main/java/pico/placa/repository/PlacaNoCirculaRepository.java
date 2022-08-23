package pico.placa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pico.placa.entity.PlacaNoCirculaEntity;

@Repository
public interface PlacaNoCirculaRepository extends JpaRepository<PlacaNoCirculaEntity, Long> {

	
}
