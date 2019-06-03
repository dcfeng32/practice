package test;

interface GH {
	public double getAcre(double r);
	public double getC(double r);
	public static final double pi = 3.14;
}

class circle implements GH {
	double r;
	public circle(double r) {
		this.r = r;
	}

	public double getAcre(double r) {
		return GH.pi * r * r;
	}

	public double getC(double r) {
		return GH.pi * 2 * r;
	}
}

public class one {
	public static void main(String[] args) {
		circle t = new circle(2.5);
		double s = t.getAcre(t.r);
		System.out.println(s);
	}
}