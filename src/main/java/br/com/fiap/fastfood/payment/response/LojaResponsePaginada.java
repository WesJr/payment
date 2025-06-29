package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LojaResponsePaginada {

    @JsonAlias("paging")
    @JsonProperty("paging")
    private Paging paging;

    @JsonProperty("results")
    @JsonAlias("results")
    private List<LojaResponse> results;
}
