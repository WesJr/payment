package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoRequest {

    @JsonProperty("sku_number")
    @JsonAlias({"sku_number"})
    private String skuNumber;

    @JsonProperty("category")
    private String category;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("unit_price")
    @JsonAlias({"unit_price"})
    private BigDecimal unitPrice;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unit_measure")
    @JsonAlias({"unit_measure"})
    private String unitMeasure;

    @JsonProperty("total_amount")
    @JsonAlias({"total_amount"})
    private BigDecimal totalAmount;

}
