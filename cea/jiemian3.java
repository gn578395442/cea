package cea;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.Random;

public  class jiemian3 extends JFrame implements ActionListener, ItemListener
{
	static jiemian3 s;
	/*添加学生信息控件*/
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("请将下面给出的化学方程式配平",JLabel.CENTER);
	JLabel label2 = new JLabel("",JLabel.CENTER);
	JLabel label3 = new JLabel("请将配平后的系数分别输入对应框中",JLabel.CENTER);
	JButton bt1 = new JButton("确定");
    JButton bt2 = new JButton("清除");
	JTextField tf1 = new JTextField();
	JTextField tf2= new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextArea ta = new JTextArea(5,20);
	JScrollPane scrollPane = new JScrollPane();
	JTable table;

public jiemian3()
{
	super("化学方程式大冒险");
	this.setResizable(false);
	this.setSize(500,800);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(jpl);
	jpl.setLayout(null);	
	/*插入面板*/
	label1.setBounds(80,20,220,20);
	jpl.add(label1);
	label2.setBounds(70,80,300,50);
	jpl.add(label2);
	label3.setBounds(60,140,250,20);
	jpl.add(label3);
	tf1.setBounds(70,180,30,20);
	jpl.add(tf1);
	tf2.setBounds(120,180,30,20);
	jpl.add(tf2);
	tf3.setBounds(170,180,30,20);
	jpl.add(tf3);
	tf4.setBounds(220,180,30,20);
	jpl.add(tf4);
	tf5.setBounds(270,180,30,20);
	jpl.add(tf5);
	ta.setBounds(70,260, 250, 200);
	ta.setBackground(Color.GRAY );
	jpl.add(ta);
	bt1.setBounds(80,220,90,20);
	bt1.addActionListener(this);
	jpl.add(bt1);
	bt2.setBounds(240,220,90,20);
	bt2.addActionListener(this);	
	jpl.add(bt2);
}	
	
@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1){
			 //数据库连接URL
		    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
			 String JDBC_URL = "jdbc:h2:~/test";
		    //连接数据库时使用的用户名
		     String USER = "sa";
		    //连接数据库时使用的密码
		     String PASSWORD = "";
		    //连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
		     String DRIVER_CLASS="org.h2.Driver";
		     
				Vector columnVector = new Vector();
				Vector dataVector = new Vector();
			try
		    {
				// 加载H2数据库驱动
		        Class.forName(DRIVER_CLASS);
		    }
		    catch (ClassNotFoundException ce)
		    {
			    JOptionPane.showMessageDialog(s,ce.getMessage());
		    }
			try{
				// 根据连接URL，用户名，密码获取数据库连接
		        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		        Statement stmt = conn.createStatement();
		   	 int max=82;
		     int min=1;
		     Random random = new Random();
		     int t = random.nextInt(max-min+1) + min;
		     //查询
		        ResultSet rs = stmt.executeQuery("SELECT * FROM cea_ku where id = '"+t+"' ");
		        while (rs.next()) {
		            System.out.println(rs.getString("id") + "," + rs.getString("name"));
		            StringBuffer sb = new StringBuffer();
		    		int index = 0;
		    		String str_value = rs.getString("name");
		    		char[] chars = str_value.toCharArray();// 从前往后
		    		
		    		  for (int i = 1; i < chars.length; i++) {  
		    	          
		    			  if(chars[i]>='0' && chars[i]<='9'){  //if当前字符是数字
		    	                //if(前一个字符是 右括号 或者 前一个字符是字母)  
		    	                if(chars[i-1]==')'   
		    	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
		    	                        || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
		    	                    	sb.append(str_value.substring(index,i));  
		    	                            	sb.append("<sub>"+chars[i]+"</sub>");  
		    	                            	index = i+1; 
		    						}
		    	            } //~ if-else 判断当前字符的类型  
		    	        } //~ for(i++)  
		    		  sb.append(str_value.substring(index, chars.length));
		    			label2.setText("<HTML>"+sb.toString()+"</HTML>");
		        }
		       
				rs.close();
				conn.close();  //关闭连接
			
			}catch(Exception exp){
				exp.printStackTrace();  //输出出错信息
			}
		}
		else
		{
			label2.setText("");
		}	
		}
		


@Override
public void itemStateChanged(ItemEvent arg1) {

}

@SuppressWarnings("unused")
public static void main(String[] args)
{
	jiemian3 s = new jiemian3();
}
}
