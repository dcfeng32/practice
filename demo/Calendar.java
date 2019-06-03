import java.time.Month;
import java.time.Year;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args){
     /* int d = getMonthDays(2019,9);
        System.out.println(d);
        int s = getYearDays(2019,3,1);
        System.out.println(s);
        int Q = getWeek(2019,3);
        System.out.println(Q);*/
        Scanner W = new Scanner(System.in);
        System.out.println("请输入年月份，格式为：----：--");
        String line = W.nextLine();
        String[] split = line.split(":");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);

        System.out.println("一\t二\t三\t四\t五\t六\t七");
        getWeek(year, month);
    }

    public static void getWeek(int year, int month) {
        //int days;
        int count = 0;
        int week = getWeek1(year, month, 1);
        for (int i = 1; i < week; i++) {
            System.out.print(" \t");
            count++;
        }
        for (int i = 1; i <= getMonthDays(year, month); i++) {
            System.out.print(i + "\t");
            count++;
            if (count == 7) {
                System.out.println("");
                count = 0;
            }
        }
        //return count;
    }

    public static int getWeek1(int year,int month,int day){
        int week;
        int yearDays = getYearDays(year,month,day);
        week = (year-1+(year-1)/4-(year-1)/100+(year-1)/400+yearDays)%7;

        return week;
    }

    public static int getYearDays(int year,int month,int day){
        int result = 0;
        for (int i = 1; i < month; i++) {
            result += getMonthDays(year,i);
        }
        result += day;
        return result;
    }

    //这个方法是计算月的天数
    public  static int getMonthDays(int year,int month){
        int result;
        switch(month){
            case 4:
            case 6:
            case 9:
            case 11:
                result = 30;
                break;
            case 2:
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    result = 29;
                } else {
                    result = 28;
                }
                break;
            default :
                result = 31;
                break;
        }
        return result;
    }
}
