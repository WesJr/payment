package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeRange {

    @JsonProperty("open")
    @JsonAlias("open")
    private String open;

    @JsonProperty("close")
    @JsonAlias("close")
    private String close;
}
