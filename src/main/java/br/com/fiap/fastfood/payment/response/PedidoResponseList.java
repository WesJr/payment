package br.com.fiap.fastfood.payment.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoResponseList {

    List<PedidoResponse> pedidos;
}
