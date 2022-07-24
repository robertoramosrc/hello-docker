package br.com.sekiro.hellodocker.api.v1.hello;

import br.com.sekiro.hellodocker.api.v1.HelloRest;
import br.com.sekiro.hellodocker.business.HelloService;
import br.com.sekiro.hellodocker.config.ModelMappingConfig;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static br.com.sekiro.hellodocker.mock.HelloMock.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = HelloRest.class)
@ExtendWith(SpringExtension.class)
@Import(ModelMappingConfig.class)
@ActiveProfiles("test") //alternativa ao -D... como parametro na inicialização da VM
public class HelloRestTest {

    public static final ResultMatcher HTTP_STATUS_OK = MockMvcResultMatchers.status()
            .is(200);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void deveRetornarSaudacao() throws Exception {
        dadoQueRetorneASaudacao();

        mockMvc
                .perform(MockMvcRequestBuilders.get("/hello/v1/saudacoes"))
                .andExpect(HTTP_STATUS_OK)
                .andExpect(jsonPath("mensagem").value(CoreMatchers.is(HELLO_DOCKER_WORLD)))
                .andExpect(jsonPath("data").value(CoreMatchers.is(DATA_SAUDACAO.toString())))
                .andDo(MockMvcResultHandlers.print());

    }

    private void dadoQueRetorneASaudacao() {
        Mockito
                .doReturn(buildSaudacao())
                .when(helloService).buscarSaudacao();
    }
}
