package br.com.sekiro.hellodocker.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudacaoDTO {
    private String mensagem;
    private LocalDate data;
}
