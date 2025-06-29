package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaixaRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("fixed_amount")
    private boolean fixedAmout;

    @JsonProperty("store_id")
    private Long storeId;

    @JsonProperty("external_store_id")
    private String externalStoreId;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("category")
    private Integer category;

}
