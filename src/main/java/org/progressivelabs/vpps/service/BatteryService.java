package org.progressivelabs.vpps.service;

import org.progressivelabs.vpps.dto.BatteryDTO;
import org.progressivelabs.vpps.dto.BatteryResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BatteryService {

    ResponseEntity<BatteryResponseDTO<String>> addBatteries(List<BatteryDTO> batteries);

    BatteryResponseDTO findAllByPostCodeRange(int from, int to);
}
