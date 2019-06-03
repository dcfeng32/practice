package recursion;

import java.io.File;

public class DelTxt {
    //设计一个方法删除文件夹
    //参数 file
    public void deleteFile(File file) {
        //判断文件夹是否为空，找别人做事
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (File f : files) {
                this.deleteFile(f);
            }
        }
        //删除文件（file是个文件或file是个空文件夹）
        file.delete();
    }
    public static void main(String[] args) {
        DelTxt del = new DelTxt();
        File file = new File("E:\\test");
        del.deleteFile(file);
    }
}
