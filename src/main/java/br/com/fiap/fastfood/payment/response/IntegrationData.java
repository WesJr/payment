package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntegrationData {

    @JsonProperty("application_id")
    @JsonAlias({"applicationId"})
    private String applicationId;

    @JsonProperty("platform_id")
    @JsonAlias({"platformId"})
    private String platformId;

    @JsonProperty("integrator_id")
    @JsonAlias({"integratorId"})
    private String integratorId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_detail")
    @JsonAlias({"status_detail"})
    private String statusDetail;

    @JsonProperty("created_date")
    @JsonAlias({"created_date"})
    private String createdDate;

    @JsonProperty("last_updated_date")
    @JsonAlias({"last_updated_date"})
    private String lastUpdatedDate;

    @JsonProperty("sponsor")
    @JsonAlias("sponsor")
    private Sponsor sponsor;

}
