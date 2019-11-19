package information.entity;

/**
 * @author:邹顺
 * @data： 2019-06-04-20:54
 */
public class Teacher {
    private int T_id;
    private  String T_account;
    private String T_name;
    private  String T_pwd;
    private String T_phone;
    private String img;
    private String sex;
    private int age;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getT_phone() {
        return T_phone;
    }

    public void setT_phone(String T_phone) {
        this.T_phone = T_phone;
    }

    private  String T_email;

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    public String getT_account() {
        return T_account;
    }

    public void setT_account(String t_account) {
        T_account = t_account;
    }

    public String getT_name() {
        return T_name;
    }

    public void setT_name(String t_name) {
        T_name = t_name;
    }

    public String getT_pwd() {
        return T_pwd;
    }

    public void setT_pwd(String t_pwd) {
        T_pwd = t_pwd;
    }

    public String getT_email() {
        return T_email;
    }

    public void setT_email(String t_email) {
        T_email = t_email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "T_id=" + T_id +
                ", T_account=" + T_account +
                ", T_name='" + T_name + '\'' +
                ", T_pwd='" + T_pwd + '\'' +
                ", T_phone='" + T_phone + '\'' +
                ", img='" + img + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", T_email='" + T_email + '\'' +
                '}';
    }
}
