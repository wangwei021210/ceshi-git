package information.entity;

/**
 * @author:邹顺
 * @data： 2019-06-04-20:54
 */
public class Course {
    private  int C_id;
    private  String  name;
    private  int  T_id;
    private  String time;
    private  int maxstudent;
    private String classroom;
    private int max;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getMaxstudent() {
        return maxstudent;
    }

    public void setMaxstudent(int maxstudent) {
        this.maxstudent = maxstudent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "C_id=" + C_id +
                ", name='" + name + '\'' +
                ", T_id=" + T_id +
                ", time='" + time + '\'' +
                ", maxstudent=" + maxstudent +
                ", classroom='" + classroom + '\'' +
                ", max=" + max +
                '}';
    }
}
