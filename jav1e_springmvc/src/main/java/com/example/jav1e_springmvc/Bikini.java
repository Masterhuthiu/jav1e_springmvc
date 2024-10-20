package com.example.jav1e_springmvc;
import org.springframework.stereotype.Component;



@Component
public class Bikini implements Outfit{

	@Override
	public void wear() {
		System.out.println("Mặc bikini");
		
	}

}
