package com.springboot.tutorial.logic;


public class Calculation {
	
	private int cartonUnitProduct1;
	private int product1CartonPrice;
	private int cartonUnitProduct2;
	private int product2CartonPrice;


	public float getTotalAmountForProduct(int product1Unit,float productPrice,int unitOfCarton, String flag) {
		System.out.println("start calculation....................");
		float pricepro1 = 0;
		setAllDefaultValue();
//		if(flag.equals("unit")) {
		if(true) {
			float pro1PriceForUnit = (float) (productPrice* 1.3* 1/unitOfCarton);

			int countOfCartonPro1 = product1Unit / unitOfCarton;
			
			float countOfmisUnitPro1 = product1Unit % unitOfCarton;			

			//for product1
			if(countOfCartonPro1>3) {
				pricepro1+=countOfCartonPro1*productPrice;
				pricepro1+=countOfmisUnitPro1*pro1PriceForUnit;
				pricepro1 = (float) (pricepro1*0.9);
			}else {
				pricepro1+=countOfCartonPro1*productPrice;
				pricepro1+=countOfmisUnitPro1*pro1PriceForUnit;
			}		
		}	
		
		return pricepro1;
		
	}
	
	public void setAllDefaultValue() {
		setCartonUnitProduct1(20);
		setProduct1CartonPrice(175);
		setCartonUnitProduct2(5);
		setProduct2CartonPrice(825);
	}

	public int getCartonUnitProduct1() {
		return cartonUnitProduct1;
	}

	public void setCartonUnitProduct1(int cartonUnitProduct1) {
		this.cartonUnitProduct1 = cartonUnitProduct1;
	}

	public int getProduct1CartonPrice() {
		return product1CartonPrice;
	}

	public void setProduct1CartonPrice(int product1CartonPrice) {
		this.product1CartonPrice = product1CartonPrice;
	}

	public int getCartonUnitProduct2() {
		return cartonUnitProduct2;
	}

	public void setCartonUnitProduct2(int cartonUnitProduct2) {
		this.cartonUnitProduct2 = cartonUnitProduct2;
	}

	public int getProduct2CartonPrice() {
		return product2CartonPrice;
	}

	public void setProduct2CartonPrice(int product2CartonPrice) {
		this.product2CartonPrice = product2CartonPrice;
	}

}
