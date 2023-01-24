package vTiger.practice;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider="Orgname")
	public void  addToCart(String phone,int price,String model) {
		System.out.println(phone+" "+price+" "+model+" ");
		
	}
	
	
	@org.testng.annotations.DataProvider(name="Orgname")
	public Object[][] getData(){
		Object[][]data=new Object[2][3];
		data[0][0]="samsung";
		data[0][1]=1200;
		data[0][2]="A80";
		
		
		data[1][0]="iphone";
		data[1][1]=1500;
		data[1][2]="s13";
		return data;
	}

}

		

