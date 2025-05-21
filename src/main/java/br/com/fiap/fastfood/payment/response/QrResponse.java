package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrResponse {

    private String image;

    @JsonAlias("template_document")
    private String templateDocument;

    @JsonAlias("template_image")
    private String templateImage;
}
