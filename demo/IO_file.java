package file;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        //file对象 不是真实的文件，是堆内存中。创建出来的一个对象空间
        //路径是看创建的对象，是否能与硬盘中的一个真实文件产生对应的映射关系
        //即使文件不存在，程序不会报错，可以执行
        //系统硬盘上的文件名不区分大小写，内存中file的对象，变量名字区分大小写
        File file = new File("E://test//Test.txt");
        //文件本身的属性,调用方法可以直接得到
        System.out.println(file.canRead());//文件是否可读
        System.out.println(file.canExecute());//文件是否可执行
        System.out.println(file.canWrite());//文件是否可写
        file.isFile();//判断当前的file是否是一个文件
    }
}
