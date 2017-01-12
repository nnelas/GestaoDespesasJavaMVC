package pt.ulusofona.es.g5;

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

        mvc.perform(get("/list"))
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
        mvc.perform(post("/form")
                .param("utilizador", utilizador)
                .param("categoria", categoria)
                .param("data", data)
                .param("descricao", descricao)
                .param("valor", valor.toString())
                .param("localizacao", localizacao))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("message", expectedMessage));


        // dados do utilizador que vai ser inserido na BD
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

        // Obtém lista de utilizadores
        mvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attribute("despesas", expectedListaDespesas));

        // Obtém dados do utilizador inserido
        mvc.perform(get("/info/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("info"))
                .andExpect(model().attribute("despesa", expectedDespesa));
    }


}
