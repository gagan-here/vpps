package org.progressivelabs.vpps.controller;


import jakarta.validation.Valid;
import org.progressivelabs.vpps.dto.BatteryDTO;
import org.progressivelabs.vpps.dto.BatteryResponseDTO;
import org.progressivelabs.vpps.service.BatteryService;
import org.progressivelabs.vpps.utils.APIConstant;
import org.progressivelabs.vpps.utils.UrlConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(UrlConstant.API_VERSION + APIConstant.BATTERY_API)
@Validated
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping
    public ResponseEntity<BatteryResponseDTO<String>> addBatteries(@RequestBody @Valid List<BatteryDTO> batteries) {
        return batteryService.addBatteries(batteries);
    }

    @GetMapping
    public ResponseEntity<BatteryResponseDTO> findAllByPostCodeRange(@RequestParam int from, @RequestParam int to) {
        BatteryResponseDTO batteries = batteryService.findAllByPostCodeRange(from, to);
        return new ResponseEntity<>(batteries, HttpStatus.OK);
    }
}
