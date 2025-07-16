package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaixaResponse {

    @JsonProperty("id")
    @JsonAlias("id")
    private Long id;

    @JsonProperty("qr")
    @JsonAlias("qr")
    private QrResponse qr;

    @JsonProperty("status")
    @JsonAlias("status")
    private String status;

    @JsonProperty("date_created")
    @JsonAlias("date_created")
    private String dateCreated;

    @JsonProperty("date_last_updated")
    @JsonAlias("date_last_updated")
    private String dateLastUpdated;

    @JsonProperty("uuid")
    @JsonAlias("uuid")
    private String uuid;

    @JsonProperty("user_id")
    @JsonAlias("user_id")
    private long userId;

    @JsonProperty("name")
    @JsonAlias("name")
    private String name;

    @JsonProperty("fixed_amount")
    @JsonAlias("fixed_amount")
    private boolean fixedAmount;

    @JsonProperty("category")
    @JsonAlias("category")
    private int category;

    @JsonProperty("store_id")
    @JsonAlias("store_id")
    private String storeId;

    @JsonProperty("external_store_id")
    @JsonAlias("external_store_id")
    private String externalStoreId;

    @JsonProperty("external_id")
    @JsonAlias("external_id")
    private String externalId;

    @JsonProperty("site")
    @JsonAlias("site")
    private String site;

    @JsonProperty("qr_code")
    @JsonAlias("qr_code")
    private String qrCode;
}
