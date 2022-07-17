package com.example.ServiceI;

import java.util.List;

import com.example.model.Mobiles;

public interface MobileI {

	public List<Mobiles> getMobiles(String brand,Integer ram, Integer price );
}
