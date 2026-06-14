package atividade_2;

public class ClasseTeste {
	private int n1;
	private double n2;
	private String n3;
	
	public ClasseTeste(int n1, double n2, String n3) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
	
	public int getN1() {
		return n1;
	}
	
	public void setN1(int n1) {
		this.n1 = n1;
	}
	
	public double getN2() {
		return n2;
	}
	
	public void setN2(double n2) {
		this.n2 = n2;
	}
	
	public String getN3() {
		return n3;
	}
	
	public void setN3(String n3) {
		this.n3 = n3;
	}
	
	@Override
	public String toString() {
		return String.format("%d,%.1f,%s", n1, n2, n3);
	}
	
	
}
