package pico.placa.test.controller;



import pico.placa.controller.AutoController;
import pico.placa.controller.PlacaNoCirculaController;
import pico.placa.dto.AutoRequestDTO;
import pico.placa.service.AutoService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.http.MediaType;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AutoController.class)
class AutoControllerTest {

    @MockBean
    private AutoService autoService;

    @Autowired
    private MockMvc mockMvc;
    
//    @Test
//    void registrar_Status200() throws Exception {
//        var request = new AutoRequestDTO();
//
//        request.setColor("Rojo");
//        request.setChasis("11111");
//        request.setPlaca("ABC1234");
//        request.setModelo("Modelo1");
//        request.setOtraInformacion("Viejo");
//        
//
//        doNothing().when(autoService).registrar(request);
//
//        var requestJson = dtoToString(request);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/no_recomendados/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//    
//    private <T> String dtoToString(T dto) {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        try {
//            return ow.writeValueAsString(dto);
//        } catch (JsonProcessingException e) {
//        }
//        return null;
//    }

}
