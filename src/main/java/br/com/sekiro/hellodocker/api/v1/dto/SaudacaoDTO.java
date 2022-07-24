package br.com.sekiro.hellodocker.api.v1.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SaudacaoDTO {
    private String mensagem;
    private LocalDate data;
}
