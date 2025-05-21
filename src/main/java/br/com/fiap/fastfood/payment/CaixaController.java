package br.com.fiap.fastfood.payment;

import br.com.fiap.fastfood.payment.resources.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import br.com.fiap.fastfood.payment.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    CaixaService service;

    @PostMapping("/")
    public CaixaResponse criarCaixa(@RequestBody CaixaRequest request) {
        return service.createCaixa(request);
    }
}
