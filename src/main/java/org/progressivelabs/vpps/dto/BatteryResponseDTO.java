package org.progressivelabs.vpps.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatteryResponseDTO<T> {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private List<String> names;
    private Integer totalCapacity;
    private Double averageCapacity;

    public BatteryResponseDTO(String message) {
        this.message = message;
    }

    public BatteryResponseDTO(List<String> names, int totalCapacity, Double averageCapacity) {
        this.names = names;
        this.totalCapacity = totalCapacity;
        this.averageCapacity = averageCapacity;
    }
}
