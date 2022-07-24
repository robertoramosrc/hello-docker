package br.com.sekiro.hellodocker.mock;

import br.com.sekiro.hellodocker.business.Saudacao;

import java.time.LocalDate;

public class HelloMock {

    public static final String HELLO_DOCKER_WORLD = "Hello docker world!";
    public static final LocalDate DATA_SAUDACAO = LocalDate.of(2022, 7, 23);

    public static Saudacao buildSaudacao(){
        return Saudacao.builder()
                .mensagem(HELLO_DOCKER_WORLD)
                .data(DATA_SAUDACAO)
                .build();
    }
}
