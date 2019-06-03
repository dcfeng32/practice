package fe;

import java.io.File;

public class NewTextFile {

    public void showFile(File file){
        File[] files = file.listFiles();
        //判断文件夹是否非空
        if(files != null && files.length != 0) {
            for (File f : files) {
                //显示文件，调用showFile方法
                this.showFile(f);
            }
        }
        //输出文件的路径
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args) {
        NewTextFile newTextFile = new NewTextFile();
        File file = new File("E://screencap");
        newTextFile.showFile(file);
    }

}
