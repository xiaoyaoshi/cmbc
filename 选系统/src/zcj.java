import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * ��Ҫʵ�ֹ��ܣ�ʵ��һ��ѧ��ѡ�ε�ͼ�ν���
 */
public class zcj extends JFrame {

    // �������
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfName,tfNum,allInfo;
    private JRadioButton rb1,rb2;
    private JCheckBox cb1,cb2,cb3;
    private JComboBox t1,t2,t3;
    public zcj(){
        setTitle("ѡ��ing......");                           // ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // ���ùر�ʱ�Ƴ�JVM
        setSize(500,400);                                   // ���ô��ڴ�С
        setLocationRelativeTo(null);                        // ���ô������
        contentPane=new JPanel();                           // �������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));      // ���ò���
        setContentPane(contentPane);
        JPanel panel=new JPanel(new GridLayout(5, 1,5,10));  // 5��1�еı�񲼾�
        panel.setBorder(new TitledBorder(null,"",TitledBorder.LEADING ,TitledBorder.TOP,null,null));
        contentPane.add(panel,BorderLayout.CENTER);          // ��panel��ӱ߿�
        // ��һ��
        JPanel panel_1=new JPanel();
        panel.add(panel_1);
        JLabel label=new JLabel("רҵ");
        panel_1.add(label);
        tfName=new JTextField();
        panel_1.add(tfName);
        tfName.setColumns(10);
        JLabel label_2=new JLabel("�꼶");
        panel_1.add(label_2);
        tfNum=new JTextField();
        tfNum.setColumns(10);
        panel_1.add(tfNum);
        rb1=new JRadioButton("��");
        panel_1.add(rb1);
        rb1.setSelected(true);                               // ���õ�ѡ��ť�У�Ĭ��ѡ�еİ�ť
        rb2=new JRadioButton("Ů");
        panel_1.add(rb2);
        ButtonGroup bts=new ButtonGroup();                   // ��ѡ��ť��Ҫ���뵽ͬһ��ButonGroup�в�����Ч
        bts.add(rb1);
        bts.add(rb2);
        // �ڶ���
        JPanel panel_2=new JPanel();
        panel.add(panel_2);
        cb1=new JCheckBox("�ߵ���ѧ");
        panel_2.add(cb1);
        t1=new JComboBox();
        t1.setModel(new DefaultComboBoxModel(new String[]{"����ʦ","����ʦ","����ʦ"}));
        panel_2.add(t1);
        // ������
        JPanel panel_3=new JPanel();
        panel.add(panel_3);
        cb2=new JCheckBox("���Դ���");
        panel_3.add(cb2);
        t2=new JComboBox();
        t2.setModel(new DefaultComboBoxModel(new String[]{"����ʦ","����ʦ"}));
        panel_3.add(t2);
        //������
        JPanel panel_4=new JPanel();
        panel.add(panel_4);
        cb3=new JCheckBox("����ϵͳ");
        panel_4.add(cb3);
        t3=new JComboBox();
        t3.setModel(new DefaultComboBoxModel(new String[]{"����ʦ","����ʦ"}));
        panel_4.add(t3);
        // ������
        JPanel panel_5=new JPanel();
        panel.add(panel_5);
        JButton jbOk=new JButton("ȷ��");
        panel_5.add(jbOk);
        JButton jbRest=new JButton("����");
        panel_5.add(jbRest);
        // ���ѡ����Ϣ
        JPanel panelSouth=new JPanel();
        contentPane.add(panelSouth,BorderLayout.SOUTH);
        JLabel labe=new JLabel("ѡ����Ϣ");
        labe.setHorizontalAlignment(SwingConstants.LEFT);
        panelSouth.add(labe);
        allInfo=new JTextField();
        allInfo.setColumns(30);
        panelSouth.add(allInfo);
        //��ӱ���
        JPanel panelNorth=new JPanel();
        contentPane.add(panelNorth,BorderLayout.NORTH);
        JLabel labelTitle=new JLabel("ѧ��ѡ��ϵͳ");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("����", Font.BOLD, 20));
        panelNorth.add(labelTitle);

        // ��ȷ����ť����¼��������
        jbOk.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder info=new StringBuilder();
                String name=tfName.getText();
                String num=tfNum.getText();
                String sex;
                if(rb1.isSelected()){
                    sex="��";
                }else {
                    sex="Ů";
                }
                info.append(name+num+sex);
                if(cb1.isSelected()){
                    String c=cb1.getText();
                    String t=t1.getSelectedItem().toString();
                    info.append(":"+c+t);
                }
                if(cb2.isSelected()){
                    String c=cb2.getText();
                    String t=t2.getSelectedItem().toString();
                    info.append(","+c+t);
                }
                if(cb3.isSelected()){
                    String c=cb3.getText();
                    String t=t3.getSelectedItem().toString();
                    info.append(","+c+t);
                }
                allInfo.setText(info.toString());                     // ��ѧ����Ϣ��ѡ����Ϣ�ŵ��ı�����  
                JOptionPane.showMessageDialog(null,"ѡ�γɹ�");        
            }
        });

        // �����ť�����¼��������
        jbRest.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {

                tfName.setText("");
                tfNum.setText("");
                rb1.setSelected(true);
                cb1.setSelected(false);
                t1.setSelectedIndex(0);
                cb2.setSelected(false);
                t2.setSelectedIndex(0);
                allInfo.setText("");
            }
        });
    }

}