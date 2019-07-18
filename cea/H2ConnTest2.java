package cea;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
 
/**
 *Java通过JDBC方式连接H2数据库
 */
public class H2ConnTest2 {
    //数据库连接URL
    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
	private static final String JDBC_URL = "jdbc:h2:~/test";
    //连接数据库时使用的用户名
    private static final String USER = "sa";
    //连接数据库时使用的密码
    private static final String PASSWORD = "";
    //连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
    private static final String DRIVER_CLASS="org.h2.Driver";
    
    public static void main(String[] args) throws Exception {
        // 加载H2数据库驱动
        Class.forName(DRIVER_CLASS);
        // 根据连接URL，用户名，密码获取数据库连接
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        //如果存在USER_INFO表就先删除USER_INFO表
        //stmt.execute("DROP TABLE IF EXISTS cea_ku");
        //创建USER_INFO表
        //stmt.execute("CREATE TABLE cea_ku(id VARCHAR(36) PRIMARY KEY,name VARCHAR(100))");
        //新增
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('11','C+CO2=2CO')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('12','CO2+H2O=H2CO3')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('13','CaO+H2O=Ca(OH)2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('14','Na2O+H2O=2NaOH')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('15','SO3+H2O=H2SO4')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('16','CuSO4+5H2O=CuSO4·5H2O')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('17','2H2O=2H2+O2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('18','Cu2(OH)2CO3=2CuO+H2O+CO2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('19','2KClO3MnO22KCl+3O2')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('20','2KMnO4=K2MnO4+MnO2+O2')");
        //删除
        //stmt.executeUpdate("DELETE FROM cea_ku WHERE id='3'");
        //修改
        //stmt.executeUpdate("UPDATE cea_ku SET id='2' WHERE id='02'");
        //查询
        ResultSet rs = stmt.executeQuery("SELECT * FROM cea_ku");
        //遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("id") + "," + rs.getString("name"));
        }
        //释放资源
        stmt.close();
        //关闭连接
        conn.close();
    }
}
