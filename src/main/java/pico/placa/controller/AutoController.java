package pico.placa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pico.placa.dto.AutoRequestDTO;
import pico.placa.dto.ResponseDTO;
import pico.placa.enumeration.EstadoRespuestaEnum;
import pico.placa.service.AutoService;

@RestController
@RequestMapping("/auto")
@Tag(name = "Auto", description = "APIs para autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping("")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody @Valid AutoRequestDTO request) {
    	String mensaje= autoService.registrar(request);
        return new ResponseEntity<>(new ResponseDTO(EstadoRespuestaEnum.OK.getCodigo(),mensaje), HttpStatus.OK);
    }
}
