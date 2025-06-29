package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {

    @JsonAlias
    @JsonProperty
    private int total;

    private int offset;

    @JsonAlias("limit")
    @JsonProperty("limit")
    private int limit;
}
