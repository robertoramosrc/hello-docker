package br.com.sekiro.hellodocker.service;

import br.com.sekiro.hellodocker.business.HelloService;
import br.com.sekiro.hellodocker.business.Saudacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.sekiro.hellodocker.mock.HelloMock.buildSaudacao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloServiceTest {

    private HelloService helloService;

    @BeforeEach
    public void setup() {
        helloService = new HelloService();
    }

    @Test
    public void deveBuscarSaudadcao() {
        Saudacao saudacao = helloService.buscarSaudacao();

        assertNotNull(saudacao);
        assertEquals(buildSaudacao().getMensagem(), saudacao.getMensagem());
    }

}
