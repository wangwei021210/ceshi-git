package information.entity;

/**
 * 学生类
 * @author:邹顺
 * @date： 2019-05-28-0:21
 */
public class Student {
    private int S_id;
    private String S_account;
    private String S_name;
    private String S_sex;
    private int S_age;
    private String S_qq;
    private String S_img;
    private String S_phone;
    private String S_addr;
    private String S_email;
    private String S_pwd;
    private String S_national;
    private String college;
    private int classes;
    private int math;
    private int english;
    private int cprogram;
    private int C_id;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getCprogram() {
        return cprogram;
    }

    public void setCprogram(int cprogram) {
        this.cprogram = cprogram;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }



    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getS_national() {
        return S_national;
    }

    public void setS_national(String s_national) {
        this.S_national = s_national;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getS_account() {
        return S_account;
    }

    public void setS_account(String s_account) {
        S_account = s_account;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public String getS_sex() {
        return S_sex;
    }

    public void setS_sex(String s_sex) {
        S_sex = s_sex;
    }

    public int getS_age() {
        return S_age;
    }

    public void setS_age(int s_age) {
        S_age = s_age;
    }

    public String getS_qq() {
        return S_qq;
    }

    public void setS_qq(String s_qq) {
        S_qq = s_qq;
    }

    public String getS_img() {
        return S_img;
    }

    public void setS_img(String s_img) {
        S_img = s_img;
    }

    public String getS_phone() {
        return S_phone;
    }

    public void setS_phone(String s_phone) {
        S_phone = s_phone;
    }

    public String getS_addr() {
        return S_addr;
    }

    public void setS_addr(String s_addr) {
        S_addr = s_addr;
    }

    public String getS_email() {
        return S_email;
    }

    public void setS_email(String s_email) {
        S_email = s_email;
    }

    public String getS_pwd() {
        return S_pwd;
    }

    public void setS_pwd(String s_pwd) {
        S_pwd = s_pwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "S_id=" + S_id +
                ", S_account=" + S_account +
                ", S_name='" + S_name + '\'' +
                ", S_sex='" + S_sex + '\'' +
                ", S_age=" + S_age +
                ", S_qq='" + S_qq + '\'' +
                ", S_img='" + S_img + '\'' +
                ", S_phone='" + S_phone + '\'' +
                ", S_addr='" + S_addr + '\'' +
                ", S_email='" + S_email + '\'' +
                ", S_pwd='" + S_pwd + '\'' +
                ", S_national='" + S_national + '\'' +
                ", college='" + college + '\'' +
                ", classes=" + classes +
                ", math=" + math +
                ", english=" + english +
                ", cprogram=" + cprogram +
                ", C_id=" + C_id +
                '}';
    }
}
