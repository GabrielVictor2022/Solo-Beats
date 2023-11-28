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

import com.example.slbeats.DAO.IUsuario;
import com.example.slbeats.controller.UsuarioController;
import com.example.slbeats.model.Usuario;

@SpringBootTest
public class UsuarioControllerTest {
	
	@Mock
    private IUsuario usuarioDao;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void testListaUsuario() {
        // Mock de dados de usuário
        Usuario usuario1 = new Usuario(1L, "Usuario1", "usuario1@example.com", "senha1");
        Usuario usuario2 = new Usuario(2L, "Usuario2", "usuario2@example.com", "senha2");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // Configuração do comportamento do mock
        when(usuarioDao.findAll()).thenReturn(usuarios);

        // Execução do teste
        List<Usuario> resultado = usuarioController.listaUsuario();

        // Verificações
        assertEquals(2, resultado.size());
        assertEquals(usuario1, resultado.get(0));
        assertEquals(usuario2, resultado.get(1));
    }
    
    @Test
    void testCriarUsuario() {
        // Dados de entrada para o teste
        Usuario usuarioParaCriar = new Usuario(null, "NovoUsuario", "novousuario@example.com", "novasenha");

        // Configuração do comportamento do mock
        when(usuarioDao.save(any(Usuario.class))).thenAnswer(invocation -> {
            Usuario usuarioSalvo = invocation.getArgument(0);
            usuarioSalvo.setId(1L); // Simulando a atribuição de um ID pelo banco de dados
            return usuarioSalvo;
        });

        // Execução do teste
        Usuario usuarioCriado = usuarioController.criarUsuario(usuarioParaCriar);

        // Verificações
        assertNotNull(usuarioCriado.getId()); // Verifica se o ID foi atribuído
        assertEquals("NovoUsuario", usuarioCriado.getNome());
        assertEquals("novousuario@example.com", usuarioCriado.getEmail());
        assertEquals("novasenha", usuarioCriado.getSenha());
    }
    
    

}
