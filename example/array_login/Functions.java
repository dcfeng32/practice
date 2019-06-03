package array.secret;

public class Functions {
    //1.需要一个小数据库，存储用户的真实密码和账户
    private String[][] userBox = {{"郑重托", "123456"}, {"渡一", "222222"},
            {"Java", "8888"}};
    public String login(String user, String password) {
        //4.进行校验
        String result = "用户名或者密码错误";
        for (int i = 0; i < userBox.length; i++) {
            if(userBox[i][0].equals(user)){
                if(userBox[0][i].equals(password)){
                    result = "登录成功";
                }
                break;
            }
        }
        return result;
    }
}
