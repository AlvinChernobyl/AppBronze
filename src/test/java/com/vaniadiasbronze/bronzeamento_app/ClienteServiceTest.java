package com.vaniadiasbronze.bronzeamento_app;

import com.vaniadiasbronze.bronzeamento_app.model.Cliente;
import com.vaniadiasbronze.bronzeamento_app.repository.ClienteRepository;
import com.vaniadiasbronze.bronzeamento_app.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.salvarCliente(cliente);

        assertNotNull(result);
        assertEquals("Maria", result.getNome());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testBuscarClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.buscarClientePorId(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(clienteRepository, times(1)).findById(1L);
    }
}
