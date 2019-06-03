    import javax.swing.JFrame;
    import javax.swing.SwingUtilities;

    import javax.swing.*;
    import javax.swing.border.MatteBorder;
    import javax.swing.event.CaretEvent;
    import javax.swing.event.CaretListener;

    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
  
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.EventQueue;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    //import java.io.Writer;
     
    import javax.swing.JButton;
    //import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    //import javax.swing.JPasswordField;
import javax.swing.JTextField;
    
    public class huitu extends JFrame{
    	
        private static final long serialVersionUID = 1L;
        //设置一个Panel容器面板和Label标签存放背景图片
        private JPanel 
            contentPanel = new JPanel();
        private JLabel
            label,
            label2;

        //设置按钮组件
        private JButton 
            login = new JButton("登录"),
            registered = new JButton("注册"),
            forgetPassword = new JButton("忘记密码");

        //设置文本框组件
        private JTextField 
            admin = new JTextField(),
            password = new JTextField();
       
        //设置复选框组件
        private JCheckBox 
            rememberAdmin = new JCheckBox("记住账号"),
            rememberPassword = new JCheckBox("记住密码");
        public static  int pd = 0;
        public static String ak1, ak2,ak3,ak4;
        public static void  run(final JFrame f, final int width, final int height){
            SwingUtilities.invokeLater(new Runnable(){

                public void run(){


                    //标题栏图标
                    //f.setIconImage(new ImageIcon("e:/JavaWS/52b1443632f42/QQ.png").getImage());
                    //标题
                    //f.setTitle(f.getClass().getSimpleName());
                    f.setTitle("学生选课系统");
                    //窗口退出行为
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //设置窗口大小不可变
                    f.setResizable(false);
                    //设置窗口打开居中
                    f.setLocationRelativeTo(null);
                    //窗口大小
                    f.setSize(width, height);
                    //展示窗口
                    f.setVisible(true);
                }
            });
        }
        
     
            
         
        public huitu(){

            //初始化各组件
            admin.setText("账号/邮箱/手机号");
            password.setText("密码");
            //实例化图片
            Icon image1 = new ImageIcon("66.jpg");
            Icon image2 = new ImageIcon("d://英雄时刻/11.png");

        
         
            label=new JLabel(image1);
            label2 = new JLabel(image2);
            //设置标签大小与位置
            label.setBounds(0, 0,500,350);
            label2.setBounds(0, 0, 501, 350);
            //在LayeredPane最底层上添加两个带图片的标签，并且label2在label上方  
            this.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
            this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            //将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
            ((JPanel)this.getContentPane()).setOpaque(false);

            /*
             * 添加组件到contentPanel容器中
             * 布局方式为自由布局。
             */
            contentPanel.setLayout(null);
            add(admin);
            add(password);
            add(login);
            add(rememberAdmin);
            add(rememberPassword);
            add(registered);
            add(forgetPassword);

            /*
             * 组件绝对位置
             */
            admin.setBounds(95, 130, 300, 25);
            password.setBounds(95, 154, 300, 25);
            rememberAdmin.setBounds(95, 180, 100, 14);
            rememberPassword.setBounds(195, 180, 100, 14);
            registered.setBounds(95, 225, 90, 20);
            forgetPassword.setBounds(205, 225, 90, 20);
            login.setBounds(315, 225, 90, 20);



            /*
             * 组件透明化
             */
            admin.setOpaque(false);
            password.setOpaque(false);
            contentPanel.setOpaque(false);
            rememberAdmin.setOpaque(false);
            rememberPassword.setOpaque(false);
            getContentPane().add(contentPanel);

            /*
             * 组件边框颜色
             */
           textSet(admin);
           textSet(password);
            //rememberAdmin.setBorder(new LineBorder(null, Color.OPAQUE));

            /*
             * 监听事件
             */
            admin.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    int c = e.getButton();
                    ak4 =  password.getText();
                  //  password.setText("");
                    if(c == MouseEvent.BUTTON1 && admin.getText().equals("账号/邮箱/手机号") &&e.getClickCount()==1) {
                        admin.setText(null);
                      //  password.setText("密码");
                        password.setText(""+ak4);
                    }
                }
            });

            admin.addCaretListener(new CaretListener(){
                public void caretUpdate(CaretEvent e){

                }
            });

            password.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    int c = e.getButton();
                    ak3 =  admin .getText();
                   // admin.setText("");
                    if(c == MouseEvent.BUTTON1 && password.getText().equals("密码") &&e.getClickCount()==1) {
                        password.setText(null);
                        admin.setText(""+ak3);
                        
                        //admin.setText("账号/邮箱/手机号");
                    }
                }
            });
            registered.addActionListener(new ActionListener(){
            
     			public void actionPerformed(ActionEvent e) {
                     pd = 1;
                     ak1 =  admin .getText();
                     ak2 = password .getText();
                     String fileName = "users.dat";
                     try {
                         FileWriter writer = new FileWriter(fileName,true);
                         BufferedWriter outWriter=new BufferedWriter(writer);
                         outWriter.write("ID:"+ak1+"&&"+"Password:"+ak2);
                         outWriter.newLine();
                         outWriter.close();
                         writer.close();
                     } catch (IOException e1) {
                         e1.printStackTrace();
                     }
                     admin.setText("");
                     password.setText("");
                     if(ak1.isEmpty()) {
                    	 JOptionPane.showMessageDialog(null,"用户名不能为空");           
                     }
                     else if(ak2.isEmpty()) {
                    	 JOptionPane.showMessageDialog(null,"密码不能为空");           
                     }
                     else if(!(ak1.isEmpty()&&ak2.isEmpty())){
                     JOptionPane.showMessageDialog(null,"注册成功！ 您的用户名是："+ak1+"密码是："+ ak2);
                     admin.setText("账号/邮箱/手机号");
                     password.setText("密码");
                     }
                 }
             });
            login.addActionListener(new ActionListener() {
              
    			public void actionPerformed(ActionEvent e) {
                	
                    if(pd==1||pd==0) {
                    	File fileName=new File("users.dat");
                    	try{
                    	FileReader inOne=new FileReader(fileName);
                    	BufferedReader inTwo=new BufferedReader(inOne);
                    	String s=null;
                    	int judge=1;
                    	while((s=inTwo.readLine())!=null)
                    	{
                    	  StringBuilder stringBuilder = new StringBuilder();
    						stringBuilder.append("ID:");
    						stringBuilder.append(admin.getText());
    						stringBuilder.append("&&");
    						stringBuilder.append("Password:");
    						stringBuilder.append(password.getText());
    					String ak=stringBuilder.toString();
                    	  
                    	  
                          if(s.equals(ak)) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            admin .setText("");
                            password .setText("");
                            judge=0;                           
                            break;
                          }
                    	}  
                    	inTwo.close();
                        inOne.close();
                    	if(judge==1) {
                             JOptionPane.showMessageDialog(null,"登陆失败！检查账号密码是否正确或请注册后登录",null,JOptionPane.ERROR_MESSAGE, null);
                             admin .setText("");
                             password .setText("");
                          }
                    	 if(judge==0){
                    	//在此处new出新的窗口
                    	 EventQueue.invokeLater(new Runnable() {
                             public void run() {
                                 try{
                                     zcj frame=new zcj();     // 创建一个窗口
                                     frame.setVisible(true);                                    // 让该窗口实例可见
                                 }catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             }
                         });
                    		 dispose(); 
                    		 return; 
                    	 }
                    	}catch(IOException event){
                    		JOptionPane.showMessageDialog(null,"系统错误"+event,null,JOptionPane.ERROR_MESSAGE, null);
                    	}
                    }
                }
     
            });
            forgetPassword.addActionListener(new ActionListener() {
            
    			public void actionPerformed(ActionEvent e) {
                    pd = 1;
                  
                    String fileName = "users.dat";
                    try {
                        FileWriter writer = new FileWriter(fileName,true);
                        BufferedWriter outWriter=new BufferedWriter(writer);
                        outWriter.write("ID:"+ak1+"&&"+"Password:"+ak2);
                        outWriter.newLine();
                        outWriter.close();
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    new wjma(); 
                    dispose(); 
           		    return; 
                   // JOptionPane.showMessageDialog(null,"请去后台重新修改密码");
                }
            });
        }
        
        /*
         * JTextField文本框设置方法.
         */
        public void textSet(JTextField field) {  
            field.setBackground(new Color(255, 255, 255));  
            field.setPreferredSize(new Dimension(150, 28));  
            MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,192));  
            field.setBorder(border);  
        }
  
        public static void main(String[] args){ 
      
          
            run(new huitu(),500,350);
          
        }

    }