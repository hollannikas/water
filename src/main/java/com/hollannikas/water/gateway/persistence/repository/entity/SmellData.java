package com.hollannikas.water.gateway.persistence.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hollannikas.water.annotations.DataEntity;

import java.io.Serializable;


 // https://rajapinnat.ymparisto.fi/api/vesla/2.0/odata/$metadata#Haju

@DataEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmellData implements Serializable {
        @JsonProperty("value")
        private SmellEntity[] smellEntities;

        public SmellEntity[] getSmellEntities() {
                return smellEntities;
        }
}



