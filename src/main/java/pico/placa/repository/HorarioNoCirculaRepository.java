package pico.placa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pico.placa.entity.HorarioNoCirculaEntity;

@Repository
public interface HorarioNoCirculaRepository extends JpaRepository<HorarioNoCirculaEntity, Long> {
    
	@Query("SELECT pnc.horarioNoCirculaEntity FROM PlacaNoCirculaEntity pnc WHERE pnc.ultimoDigitoPlaca = :ultimoDigitoPlaca AND pnc.horarioNoCirculaEntity.dia = :dia "
			+ " AND pnc.vigencia is true AND pnc.horarioNoCirculaEntity.vigencia is true")
    List<HorarioNoCirculaEntity> recuperarHorariosPorUltimoDigitoPlacaAndDia(Integer ultimoDigitoPlaca, Integer dia);
}
