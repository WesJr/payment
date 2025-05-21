package br.com.fiap.fastfood.payment.resources;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaixaRequest {

    private String name;

    @JsonAlias("fixed_amount")
    private boolean fixedAmout;

    @JsonAlias("store_id")
    private Long storeId;

    @JsonAlias("external_store_id")
    private String externalStoreId;

    @JsonAlias("external_id")
    private String externalId;

    private Integer category;

}
