package pico.placa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import pico.placa.ex.BadRequestException;

@Component
public class Validaciones {    
    
    public void validarPlaca(String placa) {
        
        if(placa.length()!=7) {
            throw new BadRequestException("La placa no es válida. Debe tener 7 caracteres");
        }
        
        try {
        	Integer.valueOf(placa.substring(placa.length()-1));

        }
        catch (Exception e) {
        	throw new BadRequestException("La placa no es válida. Debe terminar en un número");
		}
    }
    
    public void validarFechaMayorAFechaActual(Date fechaHora) {
        
    	Calendar fechaHoraIngresada = Calendar.getInstance();
        fechaHoraIngresada.setTime(fechaHora);
        
        Calendar fechaActual =Calendar.getInstance();
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);
        
    	if(fechaHoraIngresada.before(fechaActual)) {
    		throw new BadRequestException("La fecha y hora ingresada no debe ser anterior a la fecha y hora actual");
    	}
    }
}
