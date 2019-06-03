package jiujiu;

public class TestFunctions {
	// 设计一个方法，实现数组互换
	public int[] changArrayElements(int[] array) {
		// 数组内部元素对应互换
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			// 数组下表
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		TestFunctions functions = new TestFunctions();
		// 定义一个数组
		int[] x = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// 利用functions对象调用方法执行操作
		int[] result = functions.changArrayElements(x);
		// 查看结果
		for (int v : result) {
			System.out.print(v + "\t");
		}
	}

}