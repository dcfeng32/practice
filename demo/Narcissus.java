import java.util.Scanner;

public class one {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		System.out.println("请输入100~1000内的整数：");
		String s = t.nextLine();

		for (int i = 100; i < 1000; i++) {
			if (i == (i / 100) * (i / 100) * (i / 100) + ((i % 100) / 10) * ((i % 100) / 10) * ((i % 100) / 10)
					+ ((i % 100) % 10) * ((i % 100) % 10) * ((i % 100) % 10)) {
				System.out.println(i);
			}
		}
	}
}
