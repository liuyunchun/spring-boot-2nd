package com.yunchun.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "weather_api")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPI {

    @Id
    @JsonProperty("stationId")
    @Column(name = "station_id_")
    private Double stationId;

    @JsonProperty("lat")
    @Column(name = "lat_")
    private Double lat;

    @JsonProperty("lon")
    @Column(name = "lon_")
    private String lon;

    @JsonProperty("locationName")
    @Column(name = "location_name_")
    private String locationName;

    @JsonProperty("obsTime")
    @Column(name = "obs_time_")
    private LocalDateTime obsTime;
}
