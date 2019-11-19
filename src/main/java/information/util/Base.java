package information.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author:邹顺
 * @data： 2019-06-01-10:08
 */
public class Base {
    private static String url;
    private static String root;
    private static String password;
    private static String driver;


    static {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader =Base.class.getClassLoader();

            //返回文件所在的路径
//            URL res = classLoader.getResource("src/main/jdbc.properties");

            //加载文件

            // properties.load(new FileInputStream(res.getPath()));
            ResourceBundle rb = ResourceBundle.getBundle("jdbc");
//

            url =rb.getString("url");
            root = rb.getString("user");
            password =rb.getString("password");
            driver = rb.getString("driver");


            Class.forName("com.mysql.jdbc.Driver");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 连接数据库
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,root,password);
    }

    public void CloseAll(Connection conn, PreparedStatement pr, ResultSet re){
        try {
            if(re!=null) {
                re.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(pr!=null) {
                pr.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void CloseAll(Connection conn,PreparedStatement pr){
        CloseAll(conn,pr,null);

    }







}












