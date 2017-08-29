package pt.ulusofona.es.g5;

import com.sun.security.auth.UserPrincipal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet-test.xml")
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestFileUploadController {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldSaveUploadedFile() throws Exception {

        String csv = "2017-01-11,Upload,123";

        // emula um ficheiro que está a ser uploaded cujo conteúdo é "2017-01-11,Upload,123" e o nome é "test.csv"
        MockMultipartFile multipartFile =
                new MockMultipartFile("file", "test.csv", "text/csv",
                        csv.getBytes("utf-8"));

        String expectedMessage = "Sucesso. O ficheiro test.csv foi guardado com sucesso!";

        this.mvc.perform(fileUpload("/upload")
                .file(multipartFile).principal(new UserPrincipal("user1"))
                .param("name", "teste"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", expectedMessage));

        // dados da despesa esperada
        Despesa expectedDespesa = new Despesa();
        expectedDespesa.setId(1);
        expectedDespesa.setUtilizador("user1");
        expectedDespesa.setCategoria("Indefinida");
        expectedDespesa.setData("2017-01-11");
        expectedDespesa.setDescricao("Upload");
        expectedDespesa.setValor(123f);
        expectedDespesa.setLocalizacao("");

        List<Despesa> expectedListaDespesas = new ArrayList<Despesa>();
        expectedListaDespesas.add(expectedDespesa);

        // agora devia-se fazer um pedido GET a alguma funcionalidade que permitisse
        // perceber se o ficheiro tinha sido bem processado...
        mvc.perform(get("/list").principal(new UserPrincipal("user1")))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attribute("despesas", expectedListaDespesas));
    }
}
