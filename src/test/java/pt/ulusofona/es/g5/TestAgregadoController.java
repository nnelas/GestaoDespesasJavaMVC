package pt.ulusofona.es.g5;

import com.sun.security.auth.UserPrincipal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pt.ulusofona.es.g5.data.Agregado;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet-test.xml")
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestAgregadoController {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testListaAgregadosVazia() throws Exception {

        List<Agregado> expectedListaAgregado = new ArrayList<Agregado>();

        mvc.perform(get("/agregado").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("agregado"))
                .andExpect(model().attribute("agregados", expectedListaAgregado));
    }

    @Test
    public void testInsereAgregado() throws Exception {

        // dados do formulário
        String agregado1 = "user1";
        String agregado2 = "user2";

        String expectedMessage = "Sucesso! O utilizador " + agregado2 + " foi adicionado ao seu agregado familiar, foi gravado na BD e foi-lhe atribuído o ID 1";

        // POST do formulário
        mvc.perform(post("/agregado").principal(new UserPrincipal("user1"))
                .param("agregado2", agregado2))
                .andExpect(status().isOk())
                .andExpect(view().name("agregadoResult"))
                .andExpect(model().attribute("message", expectedMessage));


        // dados do utilizador que vai ser inserido na BD
        Agregado expectedAgregado = new Agregado();
        expectedAgregado.setId(1);
        expectedAgregado.setAgregado1(agregado1);
        expectedAgregado.setAgregado2(agregado2);

        List<Agregado> expectedListaAgregado = new ArrayList<Agregado>();
        expectedListaAgregado.add(expectedAgregado);

        // Obtém lista de utilizadores que fazem parte do agregado
        mvc.perform(get("/agregado").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("agregado"))
                .andExpect(model().attribute("agregados", expectedListaAgregado));
    }

    @Test
    public void testApagaAgregado() throws Exception {

        // dados do formulário
        String agregado1 = "user1";
        String agregado2 = "user2";

        String expectedMessage = "Sucesso! O utilizador " + agregado2 + " foi adicionado ao seu agregado familiar, foi gravado na BD e foi-lhe atribuído o ID 1";
        String expectedMessage2 = "Sucesso! O utilizador " + agregado2 + " foi eliminado do seu agregado familiar";

        // POST do formulário
        mvc.perform(post("/agregado").principal(new UserPrincipal("user1"))
                .param("agregado2", agregado2))
                .andExpect(status().isOk())
                .andExpect(view().name("agregadoResult"))
                .andExpect(model().attribute("message", expectedMessage));


        // dados do utilizador que vai ser inserido na BD
        Agregado expectedAgregado = new Agregado();
        expectedAgregado.setId(1);
        expectedAgregado.setAgregado1(agregado1);
        expectedAgregado.setAgregado2(agregado2);

        // elimina utilizadores que fazem parte do agregado
        mvc.perform(post("/agregadoDelete/1").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("agregadoResult"))
                .andExpect(model().attribute("message", expectedMessage2));
    }


}
