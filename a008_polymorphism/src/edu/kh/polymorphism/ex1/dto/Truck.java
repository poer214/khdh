package edu.kh.polymorphism.ex1.dto;

public class Truck extends Car{
	
	private double weight;		// 적재량
	
	public Truck() {
		super();
	}
	public Truck(int wheel, int seat, String fuel, double weight) {
		super(wheel,seat,fuel);
		this.weight = weight;

		
		
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String toString() {
		return super.toString() + "/" + weight;
	}
	
	public void loading() {
		System.out.println("물건을 많이 실을 수 있다.");
	}
	

}
