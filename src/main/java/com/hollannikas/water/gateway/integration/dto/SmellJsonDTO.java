package com.hollannikas.water.gateway.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hollannikas.water.annotations.DomainEntity;

import java.io.Serializable;

// https://rajapinnat.ymparisto.fi/api/vesla/2.0/odata/$metadata#Haju
@DomainEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmellJsonDTO implements Serializable {

    @JsonProperty("Haju_Id")
    private int hajuId;
    @JsonProperty("SeliteEng")
    private String seliteEng;

    public int getHajuId() {
        return hajuId;
    }

    public String getSeliteEng() {
        return seliteEng;
    }

}
