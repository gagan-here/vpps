package org.progressivelabs.vpps.repository;

import org.progressivelabs.vpps.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {

    @Query("SELECT b FROM Battery b WHERE b.postcode BETWEEN :from AND :to")
    List<Battery> findByPostCodeBetween(Integer from, Integer to);

}
