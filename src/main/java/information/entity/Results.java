package information.entity;

/**
 * @author:邹顺
 * @data： 2019-06-04-20:54
 */
public class Results {
    private int S_id;
    private int C_id;
    private int grade;

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Results{" +
                "S_id=" + S_id +
                ", C_id=" + C_id +
                ", grade=" + grade +
                '}';
    }
}
