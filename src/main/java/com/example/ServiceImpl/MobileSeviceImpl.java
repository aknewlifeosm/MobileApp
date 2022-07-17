package com.example.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.Repository.MobileRepo;
import com.example.ServiceI.MobileI;
import com.example.model.Mobiles;

@Service
public class MobileSeviceImpl implements MobileI{

	@Autowired
	private MobileRepo repo;

	@Cacheable(cacheNames = "all",key="#brand")	
	public List<Mobiles> getMobiles(String brand, Integer ram, Integer price) {
		
		List<Mobiles> findAll = repo.findAll();
		findAll.forEach(System.out::println);
		List<Mobiles> list = findAll.stream()
				.filter(s->  ( brand.equals(s.getName()) & ram>=s.getRam() & price>=s.getPrice() )   
         ).collect(Collectors.toList());
		
		return list;
	}

	
@CachePut(cacheNames = "all", key="#brand.brand")
public List<Mobiles> getMobiles2(String brand, Integer ram, Integer price) {
		System.out.println();
		List<Mobiles> findAll = repo.findByNameAndRamLessThanEqualAndPriceLessThanEqual
				(brand, ram, price);
		
		return findAll;
	}
	
}
