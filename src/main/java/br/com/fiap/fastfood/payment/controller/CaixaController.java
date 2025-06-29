package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import br.com.fiap.fastfood.payment.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    CaixaService service;

    @PostMapping("/")
    public CaixaResponse criarCaixa(@RequestBody CaixaRequest request) {
        return service.createCaixa(request);
    }

    @GetMapping("/{caixa-id}")
    @ResponseBody
    public CaixaResponse getCaixa(@PathVariable("caixa-id") String id) {
        return service.getCaixaById(id);
    }
}
