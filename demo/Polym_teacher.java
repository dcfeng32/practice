package Polym;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//具体（父）类Teacher
class Teacher {
    public void teach() {
    }
}
//新建子类，继承父类
class JavaTeacher extends Teacher {
    public void teach() {
        System.out.println("老师讲java");
    }
}
//新建子类继承父类
class PHPTeacher extends Teacher {
    public void teach() {
        System.out.println("老师讲PHP");
    }
}
//新建子类
class leader{
    public void cheakTeacher(Teacher s){
        System.out.println("考核开始");
        s.teach();
        System.out.println("领导打分");
    }
}

public class dff {
    public static void main(String[] args) {
        leader leader = new leader();

        JavaTeacher jf = new JavaTeacher();
        leader.cheakTeacher(jf);
        System.out.println("-----------------");

        PHPTeacher t = new PHPTeacher();
        leader.cheakTeacher(t);

    }

}
