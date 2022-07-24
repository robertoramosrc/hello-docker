package br.com.sekiro.hellodocker.api.v1;

import br.com.sekiro.hellodocker.api.SaudacaoDTO;
import br.com.sekiro.hellodocker.business.HelloService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = HelloRest.HELLO_PATH)
@AllArgsConstructor
public class HelloRest {
    public static final String HELLO_PATH = "/hello/v1/saudacoes";

    private final HelloService helloService;
    private final ModelMapper mapper;

    @ApiOperation(value = "Say Hello")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping
    public ResponseEntity<SaudacaoDTO> home() {
        return ResponseEntity
                .ok(mapper.map(helloService.buscarSaudacao(), SaudacaoDTO.class));
    }

}
