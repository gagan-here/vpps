package org.progressivelabs.vpps.service.impl;

import org.progressivelabs.vpps.dto.BatteryDTO;
import org.progressivelabs.vpps.dto.BatteryResponseDTO;
import org.progressivelabs.vpps.entity.Battery;
import org.progressivelabs.vpps.exceptionHandler.customException.BatteryNotFoundException;
import org.progressivelabs.vpps.exceptionHandler.customException.EmptyListException;
import org.progressivelabs.vpps.mapper.BatteryMapper;
import org.progressivelabs.vpps.repository.BatteryRepository;
import org.progressivelabs.vpps.service.BatteryService;
import org.progressivelabs.vpps.utils.SuccessMessage;
import org.progressivelabs.vpps.utils.ValidationMessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private final BatteryRepository batteryRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    @Override
    public ResponseEntity<BatteryResponseDTO<String>> addBatteries(List<BatteryDTO> batteries) {
        if (batteries.isEmpty()) {
            throw new EmptyListException(ValidationMessageConstant.EMPTY_LIST_ERROR_MESSAGE);
        }
        List<Battery> batteryList = BatteryMapper.INSTANCE.toEntities(batteries);
        batteryRepository.saveAll(batteryList);
        BatteryResponseDTO<String> response = new BatteryResponseDTO<>(
                SuccessMessage.BATTERY_ADDED);
        return ResponseEntity.ok(response);
    }

    @Override
    public BatteryResponseDTO findAllByPostCodeRange(int from, int to) {
        List<Battery> batteries = batteryRepository.findByPostCodeBetween(from, to);

        if (batteries.isEmpty()) {
            throw new BatteryNotFoundException("Batteries in the specified range doesn't exist");
        }

        List<BatteryDTO> batteryDTOs = BatteryMapper
                .INSTANCE.toDTOs(batteries).stream()
                .sorted(Comparator.comparing(BatteryDTO::getName))
                .toList();

        double avgCapacity = batteryDTOs.stream().map(BatteryDTO::getWattCapacity).mapToDouble(Double::valueOf)
                .average().orElse(0.0D);
        int totalCapacity = batteryDTOs.stream().map(BatteryDTO::getWattCapacity).mapToInt(Integer::valueOf).sum();
        List<String> names = batteryDTOs.stream().map(BatteryDTO::getName).collect(Collectors.toList());

        return new BatteryResponseDTO<>(names, totalCapacity, avgCapacity);
    }
}
