package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import br.com.fiap.fastfood.payment.service.CaixaService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/caixa")
public class CaixaController {

    private final CaixaService service;

    public CaixaController(CaixaService service) {
        this.service = service;
    }

    @PostMapping("/")
    public CaixaResponse criarCaixa(@RequestBody CaixaRequest request) {
        return service.createCaixa(request);
    }

    @GetMapping("/{caixa-id}")
    public CaixaResponse getCaixa(@PathVariable("caixa-id") String id) {
        return service.getCaixaById(id);
    }
}
