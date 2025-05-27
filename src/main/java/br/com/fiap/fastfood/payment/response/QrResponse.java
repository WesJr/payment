package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrResponse {

    @JsonProperty("image")
    @JsonAlias("image")
    private String image;

    @JsonProperty("template_document")
    @JsonAlias("template_document")
    private String templateDocument;

    @JsonProperty("template_image")
    @JsonAlias("template_image")
    private String templateImage;
}
