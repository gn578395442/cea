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
        stmt.execute("DROP TABLE IF EXISTS cea_ku");
        //创建USER_INFO表
        stmt.execute("CREATE TABLE cea_ku(id VARCHAR(2) PRIMARY KEY,name VARCHAR(100),ti VARCHAR(100),"
        		+ "a VARCHAR(1),b VARCHAR(1),c VARCHAR(1),d VARCHAR(1),e VARCHAR(1))");
        //新增
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('1','2Mg+O2=2MgO','Mg+O2=MgO','2','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('2','3Fe+2O2=Fe3O4','Fe+O2=Fe3O4','3','2','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('3','2Cu+O2=2CuO','Cu+O2=CuO','2','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('4','4Al+3O2=2Al2O3','Al+O2=Al2O3','4','3','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('5','2H2+O2=2H2O','H2+O2=H2O','2','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('6','4P+5O2=2P2O5','P+O2=P2O5','4','5','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('7','S+O2=SO2','S+O2=SO2','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('8','C+O2=CO2','C+O2=CO2','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('9','2C+O2=2CO','C+O2=CO','2','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('10','2CO+O2=2CO2','CO+O2=CO2','2','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('11','C+CO2=2CO','C+CO2=CO','1','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('12','CO2+H2O=H2CO3','CO2+H2O=H2CO3','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('13','CaO+H2O=Ca(OH)2','CaO+H2O=Ca(OH)2','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('14','Na2O+H2O=2NaOH','Na2O+H2O=NaOH','1','1','2','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('15','SO3+H2O=H2SO4','SO3+H2O=H2SO4','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('16','CuSO4+5H2O=CuSO4·5H2O','CuSO4+5H2O=CuSO4·5H2O','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('17','2H2O=2H2+O2','H2O=H2+O2','2','2','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('18','Cu2(OH)2CO3=2CuO+H2O+CO2','Cu2(OH)2CO3=CuO+H2O+CO2','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('19','2KClO3=2KCl+3O2','KClO3=KCl+O2','2','2','3','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('20','2KMnO4=K2MnO4+MnO2+O2','KMnO4=K2MnO4+MnO2+O2','2','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('21','2H2O2=2H2O+O2','H2O2=H2O+O2','2','2','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('22','CaCO3=CaO+CO2','CaCO3=CaO+CO2','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('23','H2CO3=H2O+CO2','H2CO3=H2O+CO2','1','1','1','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('24','CuSO4·5H2O=CuSO4+5H2O','CuSO4·5H2O=CuSO4+H2O','1','1','5','0','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('25','H2+CuO=Cu+H2O','H2+CuO=Cu+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('26','3H2+Fe2O3=2Fe+3H2O','H2+Fe2O3=Fe+H2O','3','1','2','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('27','4H2+Fe3O4=3Fe+4H2O','H2+Fe3O4=Fe+H2O','4','1','3','4','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('28','C+2CuO=2Cu+CO2','C+CuO=Cu+CO2','1','2','2','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('29','3C+2Fe2O3=4Fe+3CO2','C+Fe2O3=Fe+CO2','3','2','4','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('30','2C+Fe3O4=3Fe+2CO2','C+Fe3O4=Fe+CO2','2','1','3','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('31','Zn+H2SO4=ZnSO4+H2','Zn+H2SO4=ZnSO4+H2','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('32','Fe+H2SO4=FeSO4+H2','Fe+H2SO4=FeSO4+H2','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('33','Mg+H2SO4=MgSO4+H2','Mg+H2SO4=MgSO4+H2','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('34','2Al+3H2SO4=Al2(SO4)3+3H2','Al+H2SO4=Al2(SO4)3+H2','2','3','1','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('35','Zn+2HCl=ZnCl2+H2','Zn+HCl=ZnCl2+H2','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('36','Fe+2HCl=FeCl2+H2','Fe+HCl=FeCl2+H2','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('37','Mg+2HCl=MgCl2+H2','Mg+HCl=MgCl2+H2','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('38','2Al+6HCl=2AlCl3+3H2','Al+HCl=AlCl3+H2','2','6','2','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('39','Fe+CuSO4=FeSO4+Cu','Fe+CuSO4=FeSO4+Cu','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('40','Zn+CuSO4=ZnSO4+Cu','Zn+CuSO4=ZnSO4+Cu','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('41','Cu+Hg(NO32=Cu(NO3)2+Hg','Cu+Hg(NO32=Cu(NO3)2+Hg','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('42','Fe2O3+6HCl=2FeCl3+3H2O','Fe2O3+HCl=FeCl3+H2O','1','6','2','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('43','Fe2O3+3H2SO4=Fe2(SO4)3+3H2O','Fe2O3+H2SO4=Fe2(SO4)3+H2O','1','3','1','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('44','CuO+2HCl=CuCl2+H2O','CuO+HCl=CuCl2+H2O','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('45','CuO+H2SO4=CuSO4+H2O','CuO+H2SO4=CuSO4+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('46','MgO+H2SO4=MgSO4+H2O','MgO+H2SO4=MgSO4+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('47','CaO+2HCl=CaCl2+H2O','CaO+HCl=CaCl2+H2O','1','2','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('48','HCl+NaOH=NaCl+H2O','HCl+NaOH=NaCl+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('49','HCl+KOH=KCl+H2O','HCl+KOH=KCl+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('50','2HCl+Cu(OH)2=CuCl2+2H2O','HCl+Cu(OH)2=CuCl2+H2O','2','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('51','2HCl+Ca(OH)2=CaCl2+2H2O','HCl+Ca(OH)2=CaCl2+H2O','2','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('52','3HCl+Fe(OH)3=FeCl3+3H2O','HCl+Fe(OH)3=FeCl3+H2O','3','1','1','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('53','3HCl+Al(OH)3=AlCl3+3H2O','3HCl+Al(OH)3=AlCl3+3H2O','3','1','1','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('54','H2SO4+2NaOH=Na2SO4+2H2O','H2SO4+NaOH=Na2SO4+H2O','1','2','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('55','H2SO4+2KOH=K2SO4+2H2O','H2SO4+KOH=K2SO4+H2O','1','2','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('56','H2SO4+Cu(OH)2=CuSO4+2H2O','H2SO4+Cu(OH)2=CuSO4+H2O','1','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('57','3H2SO4+2Fe(OH)3=Fe2(SO4)3+6H2O','H2SO4+Fe(OH)3=Fe2(SO4)3+H2O','3','2','1','6','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('58','HNO3+NaOH=NaNO3+H2O','HNO3+NaOH=NaNO3+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('59','CaCO3+2HCl=CaCl2+H2O+CO2','CaCO3+HCl=CaCl2+H2O+CO2','1','2','1','1','1')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('60','Na2CO3+2HCl=2NaCl+H2O+CO2','Na2CO3+HCl=NaCl+H2O+CO2','1','2','2','1','1')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('61','MgCO3+2HCl=MgCl2+H2O+CO2','MgCO3+HCl=MgCl2+H2O+CO2','1','2','1','1','1')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('62','HCl+AgNO3=AgCl+HNO3','HCl+AgNO3=AgCl+HNO3','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('63','Na2CO3+H2SO4=Na2SO4+H2O+CO2','Na2CO3+H2SO4=Na2SO4+H2O+CO2','1','1','1','1','1')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('64','H2SO4+BaCl2=BaSO4+2HCl','H2SO4+BaCl2=BaSO4+2HCl','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('65','2NaOH+CuSO4=Cu(OH)2+Na2SO4','NaOH+CuSO4=Cu(OH)2+Na2SO4','2','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('66','3NaOH+FeCl3=Fe(OH)3+3NaCl','NaOH+FeCl3=Fe(OH)3+NaCl','3','1','1','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('67','2NaOH+MgCl2=Mg(OH)2+2NaCl','NaOH+MgCl2=Mg(OH)2+NaCl','2','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('68','2NaOH+CuCl2=Cu(OH)2+2NaCl','NaOH+CuCl2=Cu(OH)2+NaCl','2','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('69','Ca(OH)2+Na2CO3=CaCO3+2NaOH','Ca(OH)2+Na2CO3=CaCO3+NaOH','1','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('70','NaCl+AgNO3=AgCl+NaNO3','NaCl+AgNO3=AgCl+NaNO3','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('71','Na2SO4+BaCl2=BaSO4+2NaCl','Na2SO4+BaCl2=BaSO4+NaCl','1','1','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('72','CH4+2O2=CO2+2H2O','CH4+O2=CO2+H2O','1','2','1','2','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('73','C2H5OH+3O2=2CO2+3H2O','C2H5OH+O2=CO2+H2O','1','3','2','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('74','CO+CuO=Cu+CO2','CO+CuO=Cu+CO2','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('75','3CO+Fe2O3=2Fe+3CO2','CO+Fe2O3=Fe+CO2','3','1','2','3','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('76','4CO+Fe3O4=3Fe+4CO2','CO+Fe3O4=Fe+CO2','4','1','3','4','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('77','2NaOH+CO2=Na2CO3+H2O','NaOH+CO2=Na2CO3+H2O','2','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('78','2NaOH+SO2=Na2SO3+H2O','NaOH+SO2=Na2SO3+H2O','2','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('79','2NaOH+SO3=Na2SO4+H2O','NaOH+SO3=Na2SO4+H2O','2','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('80','Ca(OH)2+CO2=CaCO3+H2O','Ca(OH)2+CO2=CaCO3+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('81','Ca(OH)2+SO2=CaSO3+H2O','Ca(OH)2+SO2=CaSO3+H2O','1','1','1','1','0')");
        stmt.executeUpdate("INSERT INTO cea_ku VALUES('82','Ca(OH)2+SO2=CaSO3+H2O','Ca(OH)2+SO2=CaSO3+H2O','1','1','1','1','0')");
        //删除
        //stmt.executeUpdate("DELETE FROM cea_ku WHERE id='3'");
        //修改
        //stmt.executeUpdate("UPDATE cea_ku SET id='2' WHERE id='02'");
        //查询
        ResultSet rs = stmt.executeQuery("SELECT * FROM cea_ku");
        //遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("ti") + "," + rs.getString("a")
            + "," + rs.getString("b")+ "," + rs.getString("c")+ "," + rs.getString("d")+ "," + rs.getString("e"));
        }
        //释放资源
        stmt.close();
        //关闭连接
        conn.close();
    }
}
