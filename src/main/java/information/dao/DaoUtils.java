package information.dao;


import information.entity.Course;
import information.entity.Student;
import information.entity.Teacher;
import information.entity.User;
import information.util.Base;
import information.util.JDBCUtils;
import org.apache.commons.collections4.map.HashedMap;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ：方法
 *
 * @author:邹顺
 * @data： 2019-06-01-10:08
 */
public class DaoUtils {
    private Connection conn = null;
    private PreparedStatement pr = null;
    private ResultSet re = null;
    Base base = new Base();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    //查询密码
    public boolean selectUser(String password) {
        boolean bl = false;
        String sql = "select * from user where pwd = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, password);
        if (map.size() != 0) {
            bl = true;
        }
        return bl;
    }


    //查询学生密码
    public boolean selectStduent(String password) {
        boolean bl = false;
        String sql = "select * from student where S_pwd = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, password);
        if (map.size() != 0) {
            bl = true;
        }
        return bl;
    }

    //修改管理员信息
    public boolean updateUser(User user) {
        boolean bl = false;
        String sql = "Update USER set  name = ?, sex = ?,img = ?, phone = ?, email = ? where account = ? ";
        int i = jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getImg(), user.getPhone(), user.getEmail(), user.getAccount());
        if (i > 0) {
            bl = true;
        }
        return bl;
    }

    //注册
    public boolean register(int S_account, String S_pwd) {
        boolean bl = false;
        boolean a = new DaoUtils().selectDemo(S_account);
        if (a) {
            String sql = "INSERT into student(S_id,S_pwd) values(?,?)";
            try {
                conn = base.getConnection();
                pr = conn.prepareStatement(sql);
                pr.setInt(1, S_account);
                pr.setString(2, S_pwd);
                int i = pr.executeUpdate();
                if (i > 0) {
                    bl = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                base.CloseAll(conn, pr, null);
            }
        }
        return bl;
    }

    //修改密码
    public boolean updatepwd(String oldpassword, String password) {
        boolean bl = false;
        boolean b2 = new DaoUtils().selectUser(oldpassword);
        if (b2) {
            String sql = "update  user set pwd = ? where pwd = '" + oldpassword + "'";
            int i = jdbcTemplate.update(sql, password);
            if (i > 0) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean updateSpwd(String oldpassword, String password) {
        boolean bl = false;
        boolean b2 = new DaoUtils().selectStduent(oldpassword);
        if (b2) {
            String sql = "update  Student set S_pwd = ? where S_pwd = '" + oldpassword + "'";
            int i = jdbcTemplate.update(sql, password);
            if (i > 0) {
                bl = true;
            }
        }
        return bl;
    }

    //修改学生信息
    public boolean UpdateStudent(Student student) {
        boolean success = false;
        String sql = "Uppdate Student set  S_name = ?, S_sex = ?, S_age = ?, S_qq = ?, S_img = ?, S_phone = ?, " +
                "S_addr = ?, S_email = ? where S_account = ?";
        int i = jdbcTemplate.update(sql, student.getS_name(), student.getS_sex(), student.getS_age()
                , student.getS_qq(), student.getS_img(), student.getS_phone()
                , student.getS_phone(), student.getS_addr()
                , student.getS_email(), student.getS_account());
        if (i > 0) {
            success = true;

        }
        return success;
    }

    /* 登录*/
    public User login(User user) {
        String sql = "select * from user where account = ? and pwd = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user1 = jdbcTemplate.queryForObject(sql, rowMapper, user.getAccount(), user.getPwd());
        System.out.println(user1);
        return user1;
    }

    //学生登陆
    public Student login(Student student) {
        Student student1 = null;
        String sql = "select * from student where S_account = ? and S_pwd = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        student1 = jdbcTemplate.queryForObject(sql, rowMapper, student.getS_account(), student.getS_pwd());
        return student1;
    }


    //添加图片
    public boolean Updateimg(String account, String img) {
        boolean bl = false;
        String sql = "update user set img = ? where account = '" + account + "'";
        int i = jdbcTemplate.update(sql, img);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }


    //添加学生图片
    public boolean UpdateSimg(String account, String img) {
        boolean bl = false;
        String sql = "update student set img = ? where S_account = '" + account + "'";
        int i = jdbcTemplate.update(sql, img);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }


    //删除学生信息
    public boolean deletStudent(int S_id) {
        boolean bl = false;
        String sql = "delete from Student where S_id=?";
        int i = jdbcTemplate.update(sql, S_id);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }

    //删除老师信息
    public boolean deletTeacher(String T_id) {
        boolean bl = false;
        String sql = "delete from Teacher where T_id=?";
        int i = jdbcTemplate.update(sql, T_id);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }

    //删除选修课
    public boolean deleteCourse(int C_id) {
        boolean bl = false;
        String sql = "delete from Course where C_id = ?";
        int i = jdbcTemplate.update(sql, C_id);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }

    //添加选修课程
    public boolean addCid(int C_id, String S_a) {
        boolean bl = false;
        String sql = "update student set C_id = ? where S_account = ? ";
        int i = jdbcTemplate.update(sql, C_id, S_a);
        if (i > 0) {
            bl = true;
        }
        return bl;
    }


    //老师信息条数
    public Integer getPages(Teacher teacher) {
        String sql = "select count(*) as num from teacher where 1=1";
        if (teacher != null) {
            if (teacher.getT_account() != null && !"".equals(teacher.getT_account())) {
                sql += " and T_account = '" + teacher.getT_account() + "'";
            }
            if (teacher.getT_name() != null && !"".equals(teacher.getT_name())) {
                sql += " and T_name like '%" + teacher.getT_name() + "%'";
            }
        }
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;

    }

    //获得学生数
    public Integer getPages(Student student) {
        String sql = "select count(*) as num from student where 1=1";
        if (student != null) {
            if (student.getS_account() != null && !"".equals(student.getS_account())) {
                sql += " and S_account = '" + student.getS_account() + "'";
            }
            if (student.getS_name() != null && !"".equals(student.getS_name())) {
                sql += " and S_name like '%" + student.getS_name() + "%'";
            }
            if (student.getS_national() != null && !"".equals(student.getS_national())) {
                sql += " and S_national = '" + student.getS_national() + "'";
            }
            if (student.getClasses() != 0) {
                sql += " and classes = " + student.getClasses();
            }
            if (student.getCollege() != null && !"".equals(student.getCollege())) {
                sql += " and college = '" + student.getCollege() + "'";
            }
            if (student.getS_sex() != null && !"".equals(student.getS_sex())) {
                sql += " and S_sex = '" + student.getS_sex() + "'";
            }
        }
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;

    }

    //学生成绩条数
    public Integer getPage(Student student) {
        String sql = "select count(*) as num from student where 1=1";
        if (student != null) {
            if (student.getS_account() != null && !"".equals(student.getS_account())) {
                sql += " and student.S_account = '" + student.getS_account() + "'";
            }
            if (student.getS_name() != null && !"".equals(student.getS_name())) {
                sql += " and student.S_name like'%" + student.getS_name() + "%'";
            }
            if (student.getClasses() != 0) {
                sql += " and student.classes = " + student.getClasses();
            }
        }
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    //选修课信息条数
    public Integer getCoursepage(String courseName, String T_name) {
        Integer i = 0;
        String sql = "SELECT count(*) as num  from Course,teacher where course.T_id = teacher.T_id ";
        if (courseName != null) {
            sql += "and course.name like '%" + courseName + "%'";
        }
        if (T_name != null) {
            sql += "and teacher.T_name like '%" + T_name + "%'";
        }
//        try {
//          conn = base.getConnection();
//          pr= conn.prepareStatement(sql);
//          re = pr.executeQuery();
//          if(re.next()){
//              i = re.getInt("num");
//          }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            base.CloseAll(conn,pr,re);
//        }
        i = jdbcTemplate.queryForObject(sql, Integer.class);
        return i;
    }

    //查询学生信息
    public boolean selectDemo(int S_account) {
        boolean bl = false;
        String sql = "selec * from  student where S_account = '" + S_account + "'";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            re = pr.executeQuery();
            if (re.next()) {
                bl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }

        return bl;

    }

    //获得学院的条数
    public int getNational() {
        int i = 0;
        String sql = "SELECT COUNT(*) as a FROM student\n" +
                "where S_id in (\n" +
                "\tselect min(S_id) from student\n" +
                "\twhere 1 = 1 \n" +
                "\tgroup by \n" +
                "\tS_national\n" +
                ");";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            re = pr.executeQuery();

            if (re.next()) {
                i = re.getInt("a");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }

    public int getClasss() {
        int i = 0;
        String sql = "SELECT COUNT(*) as b FROM student\n" +
                "where S_id in (\n" +
                "\tselect min(S_id) from student\n" +
                "\twhere 1 = 1 \n" +
                "\tgroup by \n" +
                "\tclasses\n" +
                ");";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            re = pr.executeQuery();

            if (re.next()) {
                i = re.getInt("b");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }

    public int getStudent() {
        int i = 0;
        String sql = "SELECT COUNT(*) as c FROM student";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            re = pr.executeQuery();

            if (re.next()) {
                i = re.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }

    public int getTeacher() {
        int i = 0;
        String sql = "SELECT COUNT(*) as d FROM teacher";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            re = pr.executeQuery();
            if (re.next()) {
                i = re.getInt("d");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }

    //获得老师Id
    public int getT_id(String name) {
        int i = 0;
        String sql = "select T_id from Teacher where T_name = ?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, name);
            re = pr.executeQuery();
            if (re.next()) {
                i = re.getInt("T_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //查询学生信息
    public List Selecteacher(Teacher teacher, int page, int pagesize) {
        List list = new ArrayList();
        String sql = "select * from teacher where 1=1 ";
        if (teacher != null) {
            if (teacher.getT_account() != null && !"".equals(teacher.getT_account())) {
                sql += " and T_account = '" + teacher.getT_account() + "'";
            }
            if (teacher.getT_name() != null && !"".equals(teacher.getT_name())) {
                sql += " and T_name like '%" + teacher.getT_name() + "%'";
            }
        }
        sql += " limit ?,?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, (page - 1) * pagesize);
            pr.setInt(2, pagesize);
            re = pr.executeQuery();
            while (re.next()) {
                Map<String, String> result = new HashMap<String, String>();
                result.put("T_id", re.getInt("T_id") + "");
                result.put("T_account", re.getString("T_account"));
                result.put("T_name", re.getString("T_name"));
                result.put("T_email", re.getString("T_email"));
                result.put("T_phone", re.getString("T_phone"));
                result.put("age", re.getInt("age") + "");
                result.put("img", re.getString("img"));
                result.put("sex", re.getString("sex"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return list;
    }

    //查询老师信息
    public List Selecstudent(Student student, int page, int pagesize) {
        List list = new ArrayList();
        String sql = "Select *from student where 1=1 ";
        if (student != null) {
            if (student.getS_account() != null && !"".equals(student.getS_account())) {
                sql += " and S_account = '" + student.getS_account() + "'";
            }
            if (student.getS_name() != null && !"".equals(student.getS_name())) {
                sql += " and S_name like '%" + student.getS_name() + "%'";
            }
            if (student.getS_national() != null && !"".equals(student.getS_national())) {
                sql += " and S_national = '" + student.getS_national() + "'";
            }
            if (student.getClasses() != 0) {
                sql += " and classes = " + student.getClasses();
            }
            if (student.getCollege() != null && !"".equals(student.getCollege())) {
                sql += " and college = '" + student.getCollege() + "'";
            }
            if (student.getS_sex() != null && !"".equals(student.getS_sex())) {
                sql += " and S_sex = '" + student.getS_sex() + "'";
            }
        }
        sql += " limit ?,?";

        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, (page - 1) * pagesize);
            pr.setInt(2, pagesize);
            re = pr.executeQuery();
            while (re.next()) {
                Map<String, String> result = new HashMap<String, String>();
                result.put("S_id", re.getInt("S_id") + "");
                result.put("S_account", re.getInt("S_account") + "");
                result.put("S_name", re.getString("S_name"));
                result.put("S_email", re.getString("S_email"));
                result.put("S_phone", re.getString("S_phone"));
                result.put("S_national", re.getString("S_national"));
                result.put("S_age", re.getInt("S_age") + "");
                result.put("S_qq", re.getString("S_qq"));
                result.put("sex", re.getString("S_sex"));
                result.put("S_img", re.getString("S_img"));
                result.put("S_addr", re.getString("S_addr"));
                result.put("college", re.getString("college"));
                result.put("classes", re.getInt("classes") + "班");
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }


        return list;

    }

    //查询学生成绩
    public List selectGrade(Student student, int page, int pagesize) {
        List list1 = new ArrayList();
        String sql = "select student.S_id,student.S_account,student.S_name," +
                "student.S_national,student.classes,student.math," +
                "student.english,student.cprogram " +
                "from Student where 1 = 1 ";
        if (student != null) {
            if (student.getS_account() != null && !"".equals(student.getS_account())) {
                sql += " and student.S_account = '" + student.getS_account() + "'";
            }
            if (student.getS_national() != null && !"".equals(student.getS_national())) {
                sql += " and student.S_national = '" + student.getS_national() + "'";
            }
            if (student.getS_name() != null && !"".equals(student.getS_name())) {
                sql += " and student.S_name ='" + student.getS_name() + "'";
            }
            if (student.getClasses() != 0) {
                sql += " and student.classes = " + student.getClasses();
            }
        }
        sql += " limit ?,?";


        try {
            Connection conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, (page - 1) * pagesize);
            pr.setInt(2, pagesize);
            re = pr.executeQuery();
            while (re.next()) {
                Map<String, String> result = new HashedMap<String, String>();
                result.put("S_id", re.getInt("S_id") + "");
                result.put("S_account", re.getString("S_account"));
                result.put("S_name", re.getString("S_name"));
                result.put("national", re.getString("S_national"));
                result.put("classes", re.getInt("classes") + "");
                result.put("math", re.getInt("math") + "");
                result.put("english", re.getInt("english") + "");
                result.put("cprogram", re.getInt("cprogram") + "");
                list1.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return list1;
    }

    //添加学生成绩
    public boolean addgrade(Student student) {
        boolean bl = false;
        String sql = "Insert into student(S_account,S_name,S_national,classes,math,english,cprogram) values" +
                "(?,?,?,?,?,?,?)";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, student.getS_account());
            pr.setString(2, student.getS_name());
            pr.setString(3, student.getS_national());
            pr.setInt(4, student.getClasses());
            pr.setInt(5, student.getMath());
            pr.setInt(6, student.getEnglish());
            pr.setInt(7, student.getCprogram());
            int i = pr.executeUpdate();
            if (i > 0) {
                bl = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr);
        }
        return bl;
    }


    //查询选修课的信息
    public List getCourse(String coursem, String name, int page, int pagesize) {
        List list = new ArrayList();
        String sql = "SELECT Course.C_id,Course.name,teacher.T_name," +
                "Course.time ,Course.classroom,Course.maxstudent,Course.max from Course,teacher " +
                "where course.T_id = teacher.T_id ";

        if (coursem != null) {
            sql += "and course.name like '%" + coursem + "%'";
        }
        if (name != null) {
            sql += "and teacher.T_name like '%" + name + "%'";
        }
        sql += "limit ?,?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, (page - 1) * pagesize);
            pr.setInt(2, pagesize);
            re = pr.executeQuery();
            while (re.next()) {
                Map<String, String> result = new HashMap<String, String>();
                result.put("C_id", re.getInt("C_id") + "");
                result.put("name", re.getString("name"));
                result.put("T_name", re.getString("T_name"));
                result.put("time", re.getString("time"));
                result.put("classroom", re.getString("classroom"));
                result.put("maxstudent", re.getInt("maxstudent") + "");
                result.put("max", re.getInt("max") + "");
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return list;
    }


    //添加学生
    public boolean addstudent(Student student) {
        boolean bl = false;
        String sql = "insert into student(S_account,S_name,S_pwd,S_age,S_sex,S_addr,S_qq," +
                "S_email,S_national,S_phone,S_img,college,classes) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, student.getS_account());
            pr.setString(2, student.getS_name());
            pr.setString(3, student.getS_pwd());
            pr.setInt(4, student.getS_age());
            pr.setString(5, student.getS_sex());
            pr.setString(6, student.getS_addr());
            pr.setString(7, student.getS_qq());
            pr.setString(8, student.getS_email());
            pr.setString(9, student.getS_national());
            pr.setString(10, student.getS_phone());
            pr.setString(11, student.getS_img());
            pr.setString(12, student.getCollege());
            pr.setInt(13, student.getClasses());
            int i = pr.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return bl;
    }

    //添加老师
    public boolean addteacher(Teacher teacher) {
        boolean bl = false;
        String sql = "insert into teacher(T_account,T_name,T_pwd,T_phone,img," +
                "sex,age)values(?,?,?,?,?,?,?) ";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, teacher.getT_account());
            pr.setString(2, teacher.getT_name());
            pr.setString(3, teacher.getT_pwd());
            pr.setString(4, teacher.getT_phone());
            pr.setString(5, teacher.getImg());
            pr.setString(6, teacher.getSex());
            pr.setInt(7, teacher.getAge());
            int i = pr.executeUpdate();
            if (i > 0) {
                bl = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;

    }

    //添加选修课
    public boolean addCourse(Course course) {
        Boolean bl = false;
        String sql = "Insert int course(name,T_id,time,maxstudent,classroom) values(?,?,?,?,?)";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setString(1, course.getName());
            pr.setInt(2, course.getT_id());
            pr.setString(3, course.getTime());
            pr.setInt(4, course.getMaxstudent());
            pr.setString(5, course.getClassroom());
            int i = pr.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    //获得选修课的最大人数
    public int getMax(int C_id) {
        int i = 0;
        String sql = "select max from  Course where C_id = ?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, C_id);
            re = pr.executeQuery();
            if (re.next()) {
                i = re.getInt("max");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }

    //
    public int getMaxstudent(int C_id) {
        int i = 0;
        String sql = "select maxstudent from  Course where C_id = ?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, C_id);
            re = pr.executeQuery();
            if (re.next()) {
                i = re.getInt("maxstudent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }
        return i;
    }


    //选修课人数
    public boolean addMaxstduent(int id) {
        boolean bl = false;
        String sql = "update  course set maxstudent = maxstudent + 1  WHERE C_id  =  ?";
        try {
            conn = base.getConnection();
            pr = conn.prepareStatement(sql);
            pr.setInt(1, id);
            int i = pr.executeUpdate();
            if (i > 0) {
                bl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            base.CloseAll(conn, pr, re);
        }

        return bl;
    }

}
