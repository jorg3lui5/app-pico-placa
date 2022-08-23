package pico.placa.service;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pico.placa.dto.VerificaCirculacionRequestDTO;
import pico.placa.dto.VerificaCirculacionResponseDTO;
import pico.placa.entity.AutoEntity;
import pico.placa.entity.HorarioNoCirculaEntity;
import pico.placa.ex.BadRequestException;
import pico.placa.repository.AutoRepository;
import pico.placa.repository.HorarioNoCirculaRepository;
import pico.placa.util.Validaciones;

@Service
public class PlacaNoCirculaService {

  
    private static final String USUARIO_TEMPORAL = "USR_TMP";


    @Autowired
    private Validaciones validaciones;
    
    @Autowired
    private AutoRepository autoRepository;
    
    @Autowired
    private HorarioNoCirculaRepository horarioNoCirculaRepository;
    
    @Autowired
    private AutoService autoService;


    /*
     * Verifica si un auto con una placa específica puede o no circular en la fecha y hora recibida como parámetro
     */
    public VerificaCirculacionResponseDTO verificarCirculacion(VerificaCirculacionRequestDTO request) {
    	
    	//valida los datos del request
    	validarDatosCirculacionRequest(request);
        
    	//verifica si el auto se encuentra registrado en la base de datos. Si no está registrado dará un error.
    	Optional<AutoEntity> autoEntityOptional = autoRepository.findByPlacaAndVigenciaIsTrue(request.getPlaca());
        if (!autoEntityOptional.isPresent()) {
            throw new BadRequestException("El auto con placa " + request.getPlaca() + " no se encuentra registrado");
        }
        
        AutoEntity autoEntity = autoEntityOptional.get();
        
        //obtiene el ultimo digito de la placa
        int ultimoDigitoPlaca = Integer.valueOf(request.getPlaca().substring(request.getPlaca().length()-1));
        
        Calendar fechaHoraIngresada = Calendar.getInstance();
        fechaHoraIngresada.setTime(request.getFechaHora());
    	
        //obtiene el dia de la semana según la fecha y hora recibida como parámetro
    	int diaSemana = recuperarDiaSemana(fechaHoraIngresada);
    	
    	//recupera los horarios en los cuales no puede circular el autoi en el caso de que coincida el último digito de la placa y el día extraido de la fecha recibida como parámetro. 
        List<HorarioNoCirculaEntity> lstHorarioNoCirculaEntity= horarioNoCirculaRepository.recuperarHorariosPorUltimoDigitoPlacaAndDia(ultimoDigitoPlaca, diaSemana);

        //si el vehículo no tiene restricciones vehiculares en el dia de la semana indicado, entonces puede circular
        if (lstHorarioNoCirculaEntity.isEmpty()) {
        	return generarRespuestaCirculacionVehicular(autoEntity, true, "El vehículo es libre de circular");
        }
   	
        //en el caso de que tenga restricciones de circulacion en el dia de la semana indicado, entonces filtra los horarios de restriccion que coincidan con la hora recibida como parámetro.
        //si la lista es vacía (no tiene restricciones en la hora recibida como parámetro), entonces es libre de circular, caso contrario no puede circular.
    	lstHorarioNoCirculaEntity= lstHorarioNoCirculaEntity.stream().filter(horarioNoCirculaEntity-> {
    		return esHoraRestringida(fechaHoraIngresada, horarioNoCirculaEntity);
    	}).collect(Collectors.toList());
    	
    	if(lstHorarioNoCirculaEntity.isEmpty()) {
        	return generarRespuestaCirculacionVehicular(autoEntity, true, "El vehículo es libre de circular");
    	}
    	
    	return generarRespuestaCirculacionVehicular(autoEntity, false, "El vehículo con placa "+request.getPlaca()+" no puede circular de "+lstHorarioNoCirculaEntity.get(0).getHoraInicio() +" a "+lstHorarioNoCirculaEntity.get(0).getHoraFin());
     
    }
    
    private void validarDatosCirculacionRequest(VerificaCirculacionRequestDTO request) {
        if (request == null) {
            throw new BadRequestException();
        }       

        if (request.getFechaHora() == null) {
            throw new BadRequestException("Falta ingresar la fecha");
        }
                
        if (request.getPlaca() == null || request.getPlaca().trim().isEmpty()) {
            throw new BadRequestException("Falta ingresar la placa del auto");
        }
        
        validaciones.validarFechaMayorAFechaActual(request.getFechaHora());

        validaciones.validarPlaca(request.getPlaca());

    }
    
    private int recuperarDiaSemana(Calendar calendar) {
    	return calendar.get(calendar.DAY_OF_WEEK)==1?7:calendar.get(calendar.DAY_OF_WEEK)-1;
    }
    
    //verifica si la hora recibida como parámetro coincide con un horario restringido.
    private boolean esHoraRestringida(Calendar fechaHoraIngresada, HorarioNoCirculaEntity horarioNoCirculaEntity) {
    	LocalTime horaIngresada = LocalTime.ofInstant(fechaHoraIngresada.toInstant(), fechaHoraIngresada.getTimeZone().toZoneId());

    	LocalTime horaInicioRestriccion = LocalTime.parse(horarioNoCirculaEntity.getHoraInicio());
    	LocalTime horaFinRestriccion = LocalTime.parse(horarioNoCirculaEntity.getHoraFin());
		return !(horaIngresada.isBefore(horaInicioRestriccion) || horaIngresada.isAfter(horaFinRestriccion));
    	
    }
    
    private VerificaCirculacionResponseDTO generarRespuestaCirculacionVehicular(AutoEntity autoEntity, boolean permiteCircular, String mensaje) {
    	VerificaCirculacionResponseDTO verificaCirculacionResponseDTO= new VerificaCirculacionResponseDTO();
    	verificaCirculacionResponseDTO.setAutoResponseDTO(autoService.convertirAutoEntityToAutoResponseDTO(autoEntity));
    	verificaCirculacionResponseDTO.setPermiteCircular(permiteCircular);
    	verificaCirculacionResponseDTO.setMensaje(mensaje);
		return verificaCirculacionResponseDTO;
    	
    }
}
