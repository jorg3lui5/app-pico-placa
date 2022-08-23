package pico.placa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pico.placa.dto.AutoRequestDTO;
import pico.placa.dto.AutoResponseDTO;
import pico.placa.entity.AutoEntity;
import pico.placa.ex.BadRequestException;
import pico.placa.repository.AutoRepository;
import pico.placa.util.Validaciones;

@Service
public class AutoService {

	@Autowired
    private Validaciones validaciones;
	
    @Autowired
    private AutoRepository autoRepository;

    private static final String USUARIO_TEMPORAL = "USR_TMP";

    /*
     * Registra un nuevo auto.
     * request: AutoRequestDTO - datos del auto a registrar
     */
    public String registrar(AutoRequestDTO request) {

    	//valida que los datos del auto sean válidos
        validarDatosAuto(request);

        //verifica si el auto ya está registrado
        Optional<AutoEntity> byId = autoRepository.findByPlacaAndVigenciaIsTrue(request.getPlaca());
        if (byId.isPresent()) {
            throw new BadRequestException("Ya se encuentra registrado un auto con la placa  " + request.getPlaca());
        }

        //construye el auto segun la entidad para guardarlo
        AutoEntity autoEntity = convertirAutoRequestDTOToAutoEntity(request);
        autoRepository.save(autoEntity);
        
        return "Auto registrado correctamente";
    }
    
    
    //valida que los datos del auto sean válidos
    private void validarDatosAuto(AutoRequestDTO request) {
        if (request == null) {
            throw new BadRequestException();
        }

        if (request.getColor() == null || request.getColor().trim().isEmpty()) {
            throw new BadRequestException("Falta ingresar el color del auto");
        }
        
        if (request.getModelo() == null || request.getModelo().trim().isEmpty()) {
            throw new BadRequestException("Falta ingresar el modelo del auto");
        }
        
        if (request.getChasis() == null || request.getChasis().trim().isEmpty()) {
            throw new BadRequestException("Falta ingresar el chasis del auto");
        }
        
        if (request.getPlaca() == null || request.getPlaca().trim().isEmpty()) {
            throw new BadRequestException("Falta ingresar la placa del auto");
        }
        
        validaciones.validarPlaca(request.getPlaca());

    }
    
    //transforma el bojeto request del auto a un objeto entity, el cual se guardará en la base de datos
    public AutoEntity convertirAutoRequestDTOToAutoEntity(AutoRequestDTO request) {
    	AutoEntity autoEntity = new AutoEntity();
    	autoEntity.setPlaca(request.getPlaca());
    	autoEntity.setColor(request.getColor());
    	autoEntity.setChasis(request.getChasis());
    	autoEntity.setModelo(request.getModelo());
    	autoEntity.setOtraInformacion(request.getOtraInformacion());
    	
    	autoEntity.setFechaCreacion(LocalDateTime.now());
    	autoEntity.setUsuarioCreacion(USUARIO_TEMPORAL);
    	autoEntity.setVigencia(Boolean.TRUE);

    	return autoEntity;
    }
    
    //convierte una entidad auto a un response
    public AutoResponseDTO convertirAutoEntityToAutoResponseDTO(AutoEntity entity) {
    	AutoResponseDTO autoResponse = new AutoResponseDTO();
    	autoResponse.setId(entity.getId());
    	autoResponse.setPlaca(entity.getPlaca());
    	autoResponse.setColor(entity.getColor());
    	autoResponse.setChasis(entity.getChasis());
    	autoResponse.setModelo(entity.getModelo());
    	autoResponse.setOtraInformacion(entity.getOtraInformacion());

    	return autoResponse;
    }
    
}
