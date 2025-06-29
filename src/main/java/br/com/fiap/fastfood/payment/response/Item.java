package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Item {

    @JsonProperty("title")
    private String title;

    @JsonProperty("unit_price")
    @JsonAlias({"unit_price"})
    private String unitPrice;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unit_measure")
    @JsonAlias({"unit_measure"})
    private String unitMeasure;

    @JsonProperty("external_code")
    @JsonAlias({"external_code"})
    private String externalCode;

    @JsonProperty("external_categories")
    @JsonAlias("external_categories")
    private List<ExternalCategory> externalCategories;
}
