package information.entity;

/**
 * 管理员类
 * @author:邹顺
 * @data： 2019-05-28-0:21
 */
public class User {
    private  int id;
    private String account;
    private String pwd;
    private String email;
    private String img;
    private String phone;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
