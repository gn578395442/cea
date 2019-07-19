package cea;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.Random;

@SuppressWarnings("serial")
public  class jiemian3 extends JFrame implements ActionListener, ItemListener
{
	static jiemian3 s;
	/*添加控件*/
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("请将下面给出的化学方程式配平",JLabel.CENTER);
	JLabel label2 = new JLabel("",JLabel.CENTER);
	JLabel label3 = new JLabel("请将配平后的系数分别输入对应框中",JLabel.CENTER);
	JButton bt1 = new JButton("开始答题");
    JButton bt2 = new JButton("提交");
	JTextField tf1 = new JTextField(1);
	JTextField tf2= new JTextField(1);
	JTextField tf3 = new JTextField(1);
	JTextField tf4 = new JTextField(1);
	JTextField tf5 = new JTextField(1);
	JTextArea ta = new JTextArea(5,20);
	JScrollPane scrollPane = new JScrollPane();
	JTable table;
	
	 //数据库连接URL
    //private static final String JDBC_URL = "jdbc:h2:E:/Test/h2/bin/test";
	 String JDBC_URL = "jdbc:h2:~/test";
    //连接数据库时使用的用户名
     String USER = "sa";
    //连接数据库时使用的密码
     String PASSWORD = "";
    //连接H2数据库时使用的驱动类。org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
     String DRIVER_CLASS="org.h2.Driver";
     //全局定义
   	int max=82,min=1;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ResultSet rs1;
    String ti1,name1;
    int a1,b1,c1,d1,e1;

public jiemian3()
{
	super("化学方程式大冒险");
	this.setResizable(false);
	this.setSize(400,800);
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
	tf1.addActionListener(this);
	tf2.setBounds(120,180,30,20);
	jpl.add(tf2);
	tf2.addActionListener(this);
	tf3.setBounds(170,180,30,20);
	jpl.add(tf3);
	tf3.addActionListener(this);
	tf4.setBounds(220,180,30,20);
	jpl.add(tf4);
	tf4.addActionListener(this);
	tf5.setBounds(270,180,30,20);
	jpl.add(tf5);
	tf5.addActionListener(this);
	ta.setBounds(70,260, 250, 200);
	ta.setBackground(Color.GRAY );
	jpl.add(ta);
	bt1.setBounds(80,220,90,20);
	bt1.addActionListener(this);
	jpl.add(bt1);
	bt2.setBounds(240,220,90,20);
	bt2.addActionListener(this);	
	jpl.add(bt2);
	//回车触发按钮
	bt1.registerKeyboardAction(bt1.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_FOCUSED);
	bt1.registerKeyboardAction(bt1.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),JComponent.WHEN_FOCUSED);
	bt2.registerKeyboardAction(bt2.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_FOCUSED);
	bt2.registerKeyboardAction(bt2.getActionForKeyStroke(
			 KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
			 KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),JComponent.WHEN_FOCUSED);
}	

public  void chuti() {
		Vector columnVector = new Vector();
		Vector dataVector = new Vector();
		try{// 加载H2数据库驱动
	        Class.forName(DRIVER_CLASS);
	    }
	    catch (ClassNotFoundException ce){
		    JOptionPane.showMessageDialog(s,ce.getMessage());
	    }
		
		try{// 根据连接URL，用户名，密码获取数据库连接
		    conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		    stmt = conn.createStatement();
		  Random random = new Random();
		  int t = random.nextInt(max-min+1) + min;
		  //查询
		    rs = stmt.executeQuery("SELECT * FROM cea_ku where id = '"+t+"' ");
		    //rs信息转出
		     if (rs.next()) {
					String id1 = rs.getString("id");
		 		ti1 = rs.getString("ti");
		 		name1 = rs.getString("name");
					a1 = rs.getInt("a");
					b1 = rs.getInt("b");
					c1 = rs.getInt("c");
					d1 = rs.getInt("d");
					e1 = rs.getInt("e");
		         System.out.println(rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("ti") + "," + rs.getInt("a")
		         + "," + rs.getInt("b")+ "," + rs.getInt("c")+ "," + rs.getInt("d")+ "," + rs.getInt("e"));
		         //化学方程式的下标转化
		         StringBuffer sb = new StringBuffer();
		 		int index = 0;
		 		char[] chars = ti1.toCharArray();// 从前往后
		 		
		 		  for (int i = 1; i < chars.length; i++) {  
		 			  if(chars[i]>='0' && chars[i]<='9'){  //if当前字符是数字
		 	                //if(前一个字符是 右括号 或者 前一个字符是字母)  
		 	                if(chars[i-1]==')'   
		 	                        || (chars[i-1]>='A' && chars[i-1]<='Z')  
		 	                        || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
		 	                    	sb.append(ti1.substring(index,i));  
		 	                            	sb.append("<sub>"+chars[i]+"</sub>");  
		 	                            	index = i+1; 
		 						}
		 	            } //~ if-else 判断当前字符的类型
		 	        } //~ for(i++)  
		 		  sb.append(ti1.substring(index, chars.length));//补全
		 			label2.setText("<HTML>"+sb.toString()+"</HTML>");
		     }
		    
				rs.close();
				conn.close();  //关闭连接
		}catch(Exception exp){
			exp.printStackTrace();  //输出出错信息
		}
}

public void panduan() {
	if(rs == null){//检查rs是否为空
		JOptionPane.showMessageDialog(s,"你还没有出题呦");
      }else {//防止一题连续提交
    	  if (rs == rs1){
				JOptionPane.showMessageDialog(s,"这一题你刚刚做过了呦！");
				}else {
					char[] chars = name1.toCharArray();// 从前往后
					StringBuffer sb = new StringBuffer();
					int index = 0;
					  for (int i = 1; i < chars.length; i++) {  
					      if(chars[i]>='0' && chars[i]<='9'){  //if当前字符是数字
					            //if(前一个字符是 右括号 或者 前一个字符是字母)  
					            if(chars[i-1]==')'   
					                    || (chars[i-1]>='A' && chars[i-1]<='Z')  
					                    || (chars[i-1]>='a' && chars[i-1]<='z')  ){  
					                	sb.append(name1.substring(index,i));  
					                        	sb.append("<sub>"+chars[i]+"</sub>");  
					                        	index = i+1; 
									}
					        } //~ if-else 判断当前字符的类型
					    } //~ for(i++)  
					  sb.append(name1.substring(index, chars.length));//补全
						label2.setText("<HTML>"+sb.toString()+"</HTML>");
						//判断对错
						 int a2 =Integer.parseInt(tf1.getText());
						 int b2 =Integer.parseInt(tf2.getText());
						 int c2 =Integer.parseInt(tf3.getText());
						 int d2 =Integer.parseInt(tf4.getText());
						 int e2 =Integer.parseInt(tf5.getText());
						if(a1 ==a2 && b1 ==b2  && c1 ==c2 && d1 ==d2  && e1 ==e2  ){ 
							ta.setText("恭喜你答对了");
						 }else {ta.setText("啊哦，答错了哦");}}rs1=rs;}
}
@Override
public void actionPerformed(ActionEvent e0) {
		// TODO Auto-generated method stub
			//bt1:出题
			if(e0.getSource()==bt1){
			chuti();
			tf1.requestFocus();
			tf1.selectAll();
		}
			
		//bt2：对答案
		if(e0.getSource()==bt2){
			panduan();
			bt1.requestFocus();
		}
		//焦点切换
		if (e0.getSource() == tf1) {
			tf2.requestFocus();
			tf2.selectAll();}
			else if (e0.getSource() == tf2) {
			tf3.requestFocus();
			tf3.selectAll();}
			else if (e0.getSource() == tf3) {
			tf4.requestFocus();
			tf4.selectAll();}
			else if (e0.getSource() == tf4) {
			tf5.requestFocus();
			tf5.selectAll();}
			else if (e0.getSource() == tf5) {
			bt2.requestFocus();}
}


@SuppressWarnings("unused")
public static void main(String[] args)
{
	jiemian3 s = new jiemian3();
}

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO 自动生成的方法存根
	
}
}
