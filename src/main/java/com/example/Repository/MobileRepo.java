package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Mobiles;

public interface MobileRepo extends JpaRepository<Mobiles, Integer> {
    List<Mobiles> findByNameAndRamLessThanEqualAndPriceLessThanEqual
    (String name,Integer ram,Integer price);
}
