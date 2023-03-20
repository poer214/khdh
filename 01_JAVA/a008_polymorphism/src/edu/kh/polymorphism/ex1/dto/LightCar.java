package edu.kh.polymorphism.ex1.dto;

public class LightCar extends Car{
	
	private double discountOffer;

	public LightCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LightCar(int wheel, int seat, String fuel, double discountOffer) {
		super(wheel, seat, fuel);
		this.discountOffer = discountOffer; 
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}

	@Override
	public String toString() {
		return super.toString() + " / 할인율 : "+discountOffer*100 + "";
	}
	
	public void print() {
		System.out.println("고속도로, 주차장, 세금 혜택을 받을 수 있다.");
	}
	
	
}
