package corona.financiero.nmda.admision.controller;



import pico.placa.controller.PlacaNoCirculaController;
import pico.placa.service.AutoService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlacaNoCirculaController.class)
class AutoControllerTest {

    @MockBean
    private AutoService autoService;

    @Autowired
    private MockMvc mockMvc;

}
