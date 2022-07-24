package br.com.sekiro.hellodocker.business;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Saudacao {
    private String mensagem;
    private LocalDate data;
}
