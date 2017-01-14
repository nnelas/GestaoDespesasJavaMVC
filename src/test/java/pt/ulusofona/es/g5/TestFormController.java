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
import pt.ulusofona.es.g5.data.Despesa;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet-test.xml")
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestFormController {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testListaDespesasVazia() throws Exception {

        List<Despesa> expectedListaDespesas = new ArrayList<Despesa>();

        mvc.perform(get("/list").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attribute("despesas", expectedListaDespesas));
    }

    @Test
    public void testInsereDespesa() throws Exception {

        // dados do formulário
        String utilizador = "user1";
        String categoria = "Transportes";
        String data = "2017-01-11";
        String descricao = "Passe RL Jan17";
        Float valor = 36.75f;
        String localizacao = "";

        String expectedMessage = "Sucesso! A despesa de " + categoria + " no dia " + data + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário
        mvc.perform(post("/form").principal(new UserPrincipal("user1"))
                .param("categoria", categoria)
                .param("data", data)
                .param("descricao", descricao)
                .param("valor", valor.toString())
                .param("localizacao", localizacao))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage));


        // dados da despesa que vai ser inserido na BD
        Despesa expectedDespesa = new Despesa();
        expectedDespesa.setId(1);
        expectedDespesa.setUtilizador(utilizador);
        expectedDespesa.setCategoria(categoria);
        expectedDespesa.setData(data);
        expectedDespesa.setDescricao(descricao);
        expectedDespesa.setValor(valor);
        expectedDespesa.setLocalizacao(localizacao);

        List<Despesa> expectedListaDespesas = new ArrayList<Despesa>();
        expectedListaDespesas.add(expectedDespesa);

        // Obtém lista de despesas
        mvc.perform(get("/list").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attribute("despesas", expectedListaDespesas));

        // Obtém dados da despesa inserida
        mvc.perform(get("/info/1").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("info"))
                .andExpect(model().attribute("despesa", expectedDespesa));
    }

    @Test
    public void testEditaDespesa() throws Exception {

        // dados do formulário
        Long id = 1L;
        String utilizador = "user1";
        String categoria = "Transportes";
        String data = "2017-01-11";
        String descricao = "Passe RL Jan17";
        Float valor = 36.75f;
        String localizacao = "";

        String expectedMessage = "Sucesso! A despesa de " + categoria + " no dia " + data + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário
        mvc.perform(post("/form").principal(new UserPrincipal("user1"))
                .param("categoria", categoria)
                .param("data", data)
                .param("descricao", descricao)
                .param("valor", valor.toString())
                .param("localizacao", localizacao))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage));

        // edita despesa inserida
        mvc.perform(get("/edit/1").principal(new UserPrincipal("user1"))
                .param("id", id.toString()))
                .andExpect(status().isOk())
                .andExpect(view().name("form"));

        // dados da despesa editada
        String categoria2 = "Renda";
        String descricao2 = "Renda Alentejo Jan17";
        Float valor2 = 396.75f;

        String expectedMessage2 = "Sucesso! A despesa de " + categoria2 + " no dia " + data + " foi gravada na BD e foi-lhe atribuído o ID 1";

        // POST do formulário editado
        mvc.perform(post("/form").principal(new UserPrincipal("user1"))
                .param("id", id.toString())
                .param("categoria", categoria2)
                .param("data", data)
                .param("descricao", descricao2)
                .param("valor", valor2.toString())
                .param("localizacao", localizacao))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage2));


        // dados da despesa editada que vai ser inserido na BD
        Despesa expectedDespesa2 = new Despesa();
        expectedDespesa2.setId(1L);
        expectedDespesa2.setUtilizador(utilizador);
        expectedDespesa2.setCategoria(categoria2);
        expectedDespesa2.setData(data);
        expectedDespesa2.setDescricao(descricao2);
        expectedDespesa2.setValor(valor2);
        expectedDespesa2.setLocalizacao(localizacao);

        List<Despesa> expectedListaDespesas = new ArrayList<Despesa>();
        expectedListaDespesas.add(expectedDespesa2);

        // Obtém lista de despesas
        mvc.perform(get("/list").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attribute("despesas", expectedListaDespesas));

        // Obtém dados da despesa editada inserida
        mvc.perform(get("/info/1").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("info"))
                .andExpect(model().attribute("despesa", expectedDespesa2));
    }

    @Test
    public void testApagaDespesa() throws Exception {

        // dados do formulário
        String utilizador = "user1";
        String categoria = "Transportes";
        String data = "2017-01-11";
        String descricao = "Passe RL Jan17";
        Float valor = 36.75f;
        String localizacao = "";

        String expectedMessage = "Sucesso! A despesa de " + categoria + " no dia " + data + " foi gravada na BD e foi-lhe atribuído o ID 1";
        String expectedMessage2 = "Sucesso! A despesa de " + categoria + " no dia " + data + " foi eliminada";

        // POST do formulário
        mvc.perform(post("/form").principal(new UserPrincipal("user1"))
                .param("categoria", categoria)
                .param("data", data)
                .param("descricao", descricao)
                .param("valor", valor.toString())
                .param("localizacao", localizacao))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage));

        // elimina despesa inserido
        mvc.perform(post("/delete/1").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage2));
    }
}
