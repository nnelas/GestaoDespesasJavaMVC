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
import pt.ulusofona.es.g5.data.Categoria;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet-test.xml")
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestCategoriaController {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testListaCategoriasVazia() throws Exception {

        List<Categoria> expectedListaCategoria = new ArrayList<Categoria>();

        mvc.perform(get("/categoria").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("categoria"))
                .andExpect(model().attribute("categorias", expectedListaCategoria));
    }

    @Test
    public void testInsereCategoria() throws Exception {

        // dados do formulário
        String categoria = "Teste";

        String expectedMessage = "Sucesso! A categoria " + categoria + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário
        mvc.perform(post("/categoria").principal(new UserPrincipal("admin"))
                .param("categoria", categoria))
                .andExpect(status().isOk())
                .andExpect(view().name("adminCatResult"))
                .andExpect(model().attribute("message", expectedMessage));


        // categoria que vai ser inserida na BD
        Categoria expectedCategoria = new Categoria();
        expectedCategoria.setId(1);
        expectedCategoria.setCategoria(categoria);

        List<Categoria> expectedListaCategoria = new ArrayList<Categoria>();
        expectedListaCategoria.add(expectedCategoria);

        // Obtém lista de categorias
        mvc.perform(get("/categoria").principal(new UserPrincipal("admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("categoria"))
                .andExpect(model().attribute("categorias", expectedListaCategoria));
    }

    @Test
    public void testEditaCategoria() throws Exception {

        // dados do formulário
        Long id = 1L;
        String categoria = "Teste";

        String expectedMessage = "Sucesso! A categoria " + categoria + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário
        mvc.perform(post("/categoria").principal(new UserPrincipal("admin"))
                .param("categoria", categoria))
                .andExpect(status().isOk())
                .andExpect(view().name("adminCatResult"))
                .andExpect(model().attribute("message", expectedMessage));

        // edita despesa inserida
        mvc.perform(get("/categoriaEdit/1").principal(new UserPrincipal("admin"))
                .param("id", id.toString()))
                .andExpect(status().isOk())
                .andExpect(view().name("categoria"));

        // dados do formulário editado
        String categoria2 = "Teste2";

        String expectedMessage2 = "Sucesso! A categoria " + categoria2 + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário editado
        mvc.perform(post("/categoria").principal(new UserPrincipal("admin"))
                .param("id", id.toString())
                .param("categoria", categoria2))
                .andExpect(status().isOk())
                .andExpect(view().name("adminCatResult"))
                .andExpect(model().attribute("message", expectedMessage2));

        // dados da despesa editada que vai ser inserido na BD
        Categoria expectedCategoria2 = new Categoria();
        expectedCategoria2.setId(1L);
        expectedCategoria2.setCategoria(categoria2);

        List<Categoria> expectedListaCategoria = new ArrayList<Categoria>();
        expectedListaCategoria.add(expectedCategoria2);

        // Obtém lista de despesas
        mvc.perform(get("/categoria").principal(new UserPrincipal("admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("categoria"))
                .andExpect(model().attribute("categorias", expectedListaCategoria));
    }

    @Test
    public void testApagaCategoria() throws Exception {

        // dados do formulário
        String categoria = "Teste";

        String expectedMessage = "Sucesso! A categoria " + categoria + " foi gravada na BD e foi-lhe atribuído o ID 1";
        String expectedMessage2 = "Sucesso! A categoria " + categoria + " foi eliminada";

        // POST do formulário
        mvc.perform(post("/categoria").principal(new UserPrincipal("admin"))
                .param("categoria", categoria))
                .andExpect(status().isOk())
                .andExpect(view().name("adminCatResult"))
                .andExpect(model().attribute("message", expectedMessage));

        // Apaga categoria
        mvc.perform(post("/categoriaDelete/1").principal(new UserPrincipal("admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("adminCatResult"))
                .andExpect(model().attribute("message", expectedMessage2));
    }


}
