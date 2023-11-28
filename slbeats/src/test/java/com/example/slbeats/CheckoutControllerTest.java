package com.example.slbeats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.slbeats.DAO.ICheckout;
import com.example.slbeats.controller.CheckoutController;
import com.example.slbeats.model.Checkout;

@SpringBootTest
public class CheckoutControllerTest {
	
	    @Mock
	    private ICheckout checkoutDao;

	    @InjectMocks
	    private CheckoutController checkoutController;

	    @Test
	    void testListaCheckout() {
	        // Mock de dados de checkout
	        Checkout checkout1 = new Checkout(1L, "Nome1", "email1@example.com", "Cidade1", "Endereco1", "Estado1", "12345", "NomeCartao1", "1234-5678-9012-3456", "12", "2023", "123");
	        Checkout checkout2 = new Checkout(2L, "Nome2", "email2@example.com", "Cidade2", "Endereco2", "Estado2", "54321", "NomeCartao2", "5678-9012-3456-7890", "09", "2024", "456");
	        List<Checkout> checkouts = new ArrayList<>();
	        checkouts.add(checkout1);
	        checkouts.add(checkout2);

	        // Configuração do comportamento do mock
	        when(checkoutDao.findAll()).thenReturn(checkouts);

	        // Execução do teste
	        List<Checkout> resultado = checkoutController.listaCheckout();

	        // Verificações
	        assertEquals(2, resultado.size());
	        assertEquals(checkout1, resultado.get(0));
	        assertEquals(checkout2, resultado.get(1));
	    }
	    
	    @Test
	    void testCriarCheckout() {
	        // Dados de entrada para o teste
	        Checkout checkoutParaCriar = new Checkout(null, "NovoCliente", "novocliente@example.com", "CidadeNova", "EnderecoNovo", "NovoEstado", "54321", "NovoNomeCartao", "9876-5432-1098-7654", "11", "2024", "789");

	        // Configuração do comportamento do mock
	        when(checkoutDao.save(any(Checkout.class))).thenAnswer(invocation -> {
	            Checkout checkoutSalvo = invocation.getArgument(0);
	            checkoutSalvo.setId(1L); // Simulando a atribuição de um ID pelo banco de dados
	            return checkoutSalvo;
	        });

	        // Execução do teste
	        Checkout checkoutCriado = checkoutController.criarCheckout(checkoutParaCriar);

	        // Verificações
	        assertNotNull(checkoutCriado.getId()); // Verifica se o ID foi atribuído
	        assertEquals("NovoCliente", checkoutCriado.getNomeCompleto());
	        assertEquals("novocliente@example.com", checkoutCriado.getEmail());
	        assertEquals("CidadeNova", checkoutCriado.getCidade());
	        assertEquals("EnderecoNovo", checkoutCriado.getEndereco());
	        assertEquals("NovoEstado", checkoutCriado.getEstado());
	        assertEquals("54321", checkoutCriado.getCep());
	        assertEquals("NovoNomeCartao", checkoutCriado.getNomeCartao());
	        assertEquals("9876-5432-1098-7654", checkoutCriado.getNumeroCartao());
	        assertEquals("11", checkoutCriado.getMesVencimento());
	        assertEquals("2024", checkoutCriado.getAnoVencimento());
	        assertEquals("789", checkoutCriado.getCvv());
	    }
	

}
