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
        //����һ��Panel��������Label��ǩ��ű���ͼƬ
        private JPanel 
            contentPanel = new JPanel();
        private JLabel
            label,
            label2;

        //���ð�ť���
        private JButton 
            login = new JButton("��¼"),
            registered = new JButton("ע��"),
            forgetPassword = new JButton("��������");

        //�����ı������
        private JTextField 
            admin = new JTextField(),
            password = new JTextField();
       
        //���ø�ѡ�����
        private JCheckBox 
            rememberAdmin = new JCheckBox("��ס�˺�"),
            rememberPassword = new JCheckBox("��ס����");
        public static  int pd = 0;
        public static String ak1, ak2,ak3,ak4;
        public static void  run(final JFrame f, final int width, final int height){
            SwingUtilities.invokeLater(new Runnable(){

                public void run(){


                    //������ͼ��
                    //f.setIconImage(new ImageIcon("e:/JavaWS/52b1443632f42/QQ.png").getImage());
                    //����
                    //f.setTitle(f.getClass().getSimpleName());
                    f.setTitle("ѧ��ѡ��ϵͳ");
                    //�����˳���Ϊ
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //���ô��ڴ�С���ɱ�
                    f.setResizable(false);
                    //���ô��ڴ򿪾���
                    f.setLocationRelativeTo(null);
                    //���ڴ�С
                    f.setSize(width, height);
                    //չʾ����
                    f.setVisible(true);
                }
            });
        }
        
     
            
         
        public huitu(){

            //��ʼ�������
            admin.setText("�˺�/����/�ֻ���");
            password.setText("����");
            //ʵ����ͼƬ
            Icon image1 = new ImageIcon("66.jpg");
            Icon image2 = new ImageIcon("d://Ӣ��ʱ��/11.png");

        
         
            label=new JLabel(image1);
            label2 = new JLabel(image2);
            //���ñ�ǩ��С��λ��
            label.setBounds(0, 0,500,350);
            label2.setBounds(0, 0, 501, 350);
            //��LayeredPane��ײ������������ͼƬ�ı�ǩ������label2��label�Ϸ�  
            this.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
            this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            //�������������Ϊ͸�������ܹ����������LayeredPane�ϵı�����
            ((JPanel)this.getContentPane()).setOpaque(false);

            /*
             * ��������contentPanel������
             * ���ַ�ʽΪ���ɲ��֡�
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
             * �������λ��
             */
            admin.setBounds(95, 130, 300, 25);
            password.setBounds(95, 154, 300, 25);
            rememberAdmin.setBounds(95, 180, 100, 14);
            rememberPassword.setBounds(195, 180, 100, 14);
            registered.setBounds(95, 225, 90, 20);
            forgetPassword.setBounds(205, 225, 90, 20);
            login.setBounds(315, 225, 90, 20);



            /*
             * ���͸����
             */
            admin.setOpaque(false);
            password.setOpaque(false);
            contentPanel.setOpaque(false);
            rememberAdmin.setOpaque(false);
            rememberPassword.setOpaque(false);
            getContentPane().add(contentPanel);

            /*
             * ����߿���ɫ
             */
           textSet(admin);
           textSet(password);
            //rememberAdmin.setBorder(new LineBorder(null, Color.OPAQUE));

            /*
             * �����¼�
             */
            admin.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    int c = e.getButton();
                    ak4 =  password.getText();
                  //  password.setText("");
                    if(c == MouseEvent.BUTTON1 && admin.getText().equals("�˺�/����/�ֻ���") &&e.getClickCount()==1) {
                        admin.setText(null);
                      //  password.setText("����");
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
                    if(c == MouseEvent.BUTTON1 && password.getText().equals("����") &&e.getClickCount()==1) {
                        password.setText(null);
                        admin.setText(""+ak3);
                        
                        //admin.setText("�˺�/����/�ֻ���");
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
                    	 JOptionPane.showMessageDialog(null,"�û�������Ϊ��");           
                     }
                     else if(ak2.isEmpty()) {
                    	 JOptionPane.showMessageDialog(null,"���벻��Ϊ��");           
                     }
                     else if(!(ak1.isEmpty()&&ak2.isEmpty())){
                     JOptionPane.showMessageDialog(null,"ע��ɹ��� �����û����ǣ�"+ak1+"�����ǣ�"+ ak2);
                     admin.setText("�˺�/����/�ֻ���");
                     password.setText("����");
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
                            JOptionPane.showMessageDialog(null, "��¼�ɹ���");
                            admin .setText("");
                            password .setText("");
                            judge=0;                           
                            break;
                          }
                    	}  
                    	inTwo.close();
                        inOne.close();
                    	if(judge==1) {
                             JOptionPane.showMessageDialog(null,"��½ʧ�ܣ�����˺������Ƿ���ȷ����ע����¼",null,JOptionPane.ERROR_MESSAGE, null);
                             admin .setText("");
                             password .setText("");
                          }
                    	 if(judge==0){
                    	//�ڴ˴�new���µĴ���
                    	 EventQueue.invokeLater(new Runnable() {
                             public void run() {
                                 try{
                                     zcj frame=new zcj();     // ����һ������
                                     frame.setVisible(true);                                    // �øô���ʵ���ɼ�
                                 }catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             }
                         });
                    		 dispose(); 
                    		 return; 
                    	 }
                    	}catch(IOException event){
                    		JOptionPane.showMessageDialog(null,"ϵͳ����"+event,null,JOptionPane.ERROR_MESSAGE, null);
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
                   // JOptionPane.showMessageDialog(null,"��ȥ��̨�����޸�����");
                }
            });
        }
        
        /*
         * JTextField�ı������÷���.
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