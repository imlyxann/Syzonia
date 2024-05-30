package fr.syzonia.core.price;

import java.time.LocalDateTime;

public class PriceUtils {

	public int Price(int price) {
		if(getTime().contains("-12-")) {
			if(price >= 100 && price < 200) {
				 int result = price - price * 10 / 100;
				 return result;
			}
			if(price >= 200 && price < 300) {
				 int result = price - price * 25 / 100;
				 return result;
			}
			if(price >= 300 && price < 400) {
				 int result = price - price * 35 / 100;
				 return result;
			}
			if(price >= 400) {
				 int result = price - price * 50 / 100;
				 return result;
			}
		}
		
		return price;
	}
	
	public String getPromo(int Price) {
		if(getTime().contains("-12-")) {
			if(Price >= 100 && Price < 200) {
				return "§c-10%";
			}
			if(Price >= 200 && Price < 300) {
				return "§c-25%";
			}
			if(Price >= 300 && Price < 400) {
				return "§c-35%";
			}
			if(Price >= 400) {
				return "§c-50%"; 
			}
		}
		
		return "";
	}
	
	
	public String getTime() {
		return LocalDateTime.now().toString();
	}
	
}
