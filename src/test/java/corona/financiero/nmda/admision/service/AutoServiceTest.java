package corona.financiero.nmda.admision.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.test.util.ReflectionTestUtils;

import pico.placa.dto.*;
import pico.placa.entity.*;
import pico.placa.ex.BadRequestException;
import pico.placa.repository.*;
import pico.placa.service.AutoService;
import pico.placa.util.Validaciones;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutoServiceTest {
    @Mock
    private AutoRepository autoRepository;


    @InjectMocks
    private AutoService autoService;

    @Mock
    private Validaciones validaciones;

}
