package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CaixaResponse {

    @JsonAlias("id")
    private Long id;

    @JsonAlias("qr")
    private QrResponse qr;

    @JsonAlias("status")
    private String status;

    @JsonAlias("date_created")
    private LocalDateTime dateCreated;

    @JsonAlias("date_last_updated")
    private LocalDateTime dateLastUpdated;

    @JsonAlias("uuid")
    private String uuid;

    @JsonAlias("user_id")
    private long userId;

    @JsonAlias("name")
    private String name;

    @JsonAlias("fixed_amount")
    private boolean fixedAmount;

    @JsonAlias("category")
    private int category;

    @JsonAlias("store_id")
    private String storeId;

    @JsonAlias("external_store_id")
    private String externalStoreId;

    @JsonAlias("external_id")
    private String externalId;

    @JsonAlias("site")
    private String site;

    @JsonAlias("qr_code")
    private String qrCode;
}
