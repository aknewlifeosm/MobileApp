package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServiceImpl.MobileSeviceImpl;
import com.example.model.Mobiles;

@RestController
public class MobileController {

	@Autowired
	private MobileSeviceImpl impl;
	
	@GetMapping("/getMobiles")
	public ResponseEntity<List<Mobiles> > getMobiles(
	@RequestParam(value="brand",defaultValue="realme",required=false) String brand,		
	@RequestParam(value="ram",defaultValue="100",required=false)Integer ram,		
	@RequestParam(value="price",defaultValue="100000",required=false)Integer price		
	){
		List<Mobiles> mobiles = this.impl.getMobiles(brand, ram, price);
		return new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getMobiles2")
	public ResponseEntity<List<Mobiles> > getMobiles2(
	@RequestParam(value="brand",defaultValue="realme",required=false) String brand,		
	@RequestParam(value="ram",defaultValue="100",required=false)Integer ram,		
	@RequestParam(value="price",defaultValue="100000",required=false)Integer price		
	){
		List<Mobiles> mobiles = this.impl.getMobiles2(brand, ram, price);
		return new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.ACCEPTED);
	}
	
	
	
}
