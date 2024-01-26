package com.hollannikas.water.gateway.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hollannikas.water.annotations.DomainEntity;

import java.io.Serializable;


 // https://rajapinnat.ymparisto.fi/api/vesla/2.0/odata/$metadata#Haju

@DomainEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmellDataJsonDTO implements Serializable {
        @JsonProperty("value")
        private SmellJsonDTO[] smellEntities;

        public SmellJsonDTO[] getSmellEntities() {
                return smellEntities;
        }
}



