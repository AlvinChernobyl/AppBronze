package com.vaniadiasbronze.bronzeamento_app;

import com.vaniadiasbronze.bronzeamento_app.model.Cliente;
import com.vaniadiasbronze.bronzeamento_app.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ClienteServiceIntegrationTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    void testSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");
        cliente.setTelefone("123456789");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));

        Cliente savedCliente = clienteService.salvarCliente(cliente);

        assertNotNull(savedCliente);
        assertEquals("João", savedCliente.getNome());
    }
}
