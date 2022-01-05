package com.yunchun.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@Table(name = "weather_api")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPI {

    @JsonIgnore
    private Boolean success;
    private Map<String, String> result;


}
