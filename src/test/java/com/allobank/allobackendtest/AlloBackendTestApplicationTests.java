package com.allobank.allobackendtest;

import com.allobank.allobackendtest.controller.CalegController;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.service.CalegService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ComponentScan("com.allobank.allobackendtest")
class AlloBackendTestApplicationTests {

    private MockMvc mockMvc;

    @Mock
    private CalegService calegService;

    @InjectMocks
    private CalegController calegController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(calegController).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void getCalegList_shouldReturnSortedCalegList() throws Exception {
        Caleg caleg = new Caleg();
        caleg.setNama("Cia");
        caleg.setNomorUrut(12);

        when(calegService.getCalegSortedByNomorUrut(anyString())).thenReturn(Collections.singletonList(caleg));

        mockMvc.perform(get("/api/caleg").param("sortBy", "asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nama").value("Cia"))
                .andExpect(jsonPath("$[0].nomorUrut").value(12));
    }

    @Test
    void getCalegList_shouldReturnCalegListByPartaiAndDapil() throws Exception {
        UUID idPartai = UUID.fromString("faea4d21-54ed-42a2-91e4-5e56637d355d");
        UUID idDapil = UUID.fromString("901549ea-aaf6-4e36-a747-2c46a9af8316");
        Caleg caleg = new Caleg();
        caleg.setNama("Cia");
        caleg.setNomorUrut(12);

        when(calegService.getCalegByPartaiAndDapil(any(UUID.class), any(UUID.class))).thenReturn(Collections.singletonList(caleg));

        mockMvc.perform(get("/api/caleg")
                        .param("idPartai", idPartai.toString())
                        .param("idDapil", idDapil.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nama").value("Cia"))
                .andExpect(jsonPath("$[0].nomorUrut").value(12));
    }

    @Test
    void getCalegList_shouldReturnAllCalegList() throws Exception {
        Caleg caleg = new Caleg();
        caleg.setNama("Cia");
        caleg.setNomorUrut(12);

        when(calegService.getAllCaleg()).thenReturn(Collections.singletonList(caleg));

        mockMvc.perform(get("/api/caleg"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nama").value("Cia"))
                .andExpect(jsonPath("$[0].nomorUrut").value(12))
                  .andDo(print());
    }
    
    @Test
void getCalegList_shouldReturnSortedCalegListDescending() throws Exception {
    // Membuat objek Caleg yang akan digunakan dalam respons
    Caleg caleg = new Caleg();
    caleg.setNama("Cia");
    caleg.setNomorUrut(12);

    // Menyiapkan respons yang akan dipanggil oleh mocked CalegService
    when(calegService.getCalegSortedByNomorUrut("desc")).thenReturn(Collections.singletonList(caleg));

    // Melakukan permintaan GET dengan parameter sortBy=desc
    mockMvc.perform(get("/api/caleg").param("sortBy", "desc"))
            .andExpect(status().isOk()) // Harus mendapatkan respons 200 OK
            .andExpect(jsonPath("$[0].nama").value("Cia")) // Memastikan nama pertama adalah "John Doe"
            .andExpect(jsonPath("$[0].nomorUrut").value(12)); // Memastikan nomor urut pertama adalah 1
}
}
