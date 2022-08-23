package pico.placa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pico.placa.dto.VerificaCirculacionRequestDTO;
import pico.placa.dto.VerificaCirculacionResponseDTO;
import pico.placa.service.PlacaNoCirculaService;

@RestController
@RequestMapping("/placa-no-circula")
@Tag(name = "Placas no circula", description = "API de placas no circula")
public class PlacaNoCirculaController {

    @Autowired
    private PlacaNoCirculaService placaNoCirculaService;

    @PostMapping("verificarCirculacion")
    public ResponseEntity<VerificaCirculacionResponseDTO> verificarCirculacion(@RequestBody VerificaCirculacionRequestDTO verificaCirculacionRequestDTO) {
        return new ResponseEntity<>(placaNoCirculaService.verificarCirculacion(verificaCirculacionRequestDTO), HttpStatus.OK);
    }
}
