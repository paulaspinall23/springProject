package com.example.springproject.controller;

import com.example.springproject.dto.CDDTO;
import com.example.springproject.model.CD;
import com.example.springproject.services.CDService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class CDControllerTest {

    @Autowired
    private CDController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void helloHomeTest() {
        assertThat(controller.home()).isEqualTo("Hello, Home!");
    }

    @Test
    public void testGetAllCDs() {
        final List<CDDTO> cds = controller.getAllCDs();
        assertThat(cds).isNotNull().hasSize(7);

    }
}
