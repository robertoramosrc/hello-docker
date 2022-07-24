package br.com.sekiro.hellodocker.business;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HelloService {

    public Saudacao buscarSaudacao() {
        return Saudacao.builder()
                .mensagem("Hello world!")
                .data(LocalDate.now())
                .build();
    }

}
