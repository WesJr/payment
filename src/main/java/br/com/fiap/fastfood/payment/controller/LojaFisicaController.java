package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import br.com.fiap.fastfood.payment.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loja")
public class LojaFisicaController {

    @Autowired
    LojaService service;

    @PostMapping("users/{user_id}/stores")
    public LojaResponse criarLoja(@PathVariable("user_id") String userId, @RequestBody LojaRequest lojaRequest) {
        return service.criarLoja(userId, lojaRequest);
    }

    @GetMapping("users/{user_id}/store/search")
    public LojaResponsePaginada buscarLojas(@PathVariable("user_id") String userId) {
        return service.buscarLojas(userId);
    }
}
