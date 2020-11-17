package awtStudy;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName:边界布局
 * @Description:
 * @Author: 汪满青
 * @Date: 2020-11-07 22:45
 */
public class LogonForm extends JFrame {
    /***
     * @Title:
     * @Author: 汪满青
     * @Description:
     * @Date: 2020/11/7-23:42
     * @Param: []
     * @return:
     **/
    public LogonForm() {
        // 设置颜色
        this.setBackground(Color.pink);
        // 设置尺寸大小
        this.setSize(1000, 800);
        // 设置标题
        this.setTitle("Email注册");
        // 设置移动窗体的大小
        this.setResizable(true);
        // 设置窗体居中
        this.setLocationRelativeTo(null);
        //设置图标
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("bg.jpg"));
        // 设置标题栏的图标为face.gif
        this.setIconImage(imageIcon.getImage());

        // 先设置一个大的panel
        JPanel larpJPanel = new JPanel();
        // 将这个larpJPanel设置为边界布局
        larpJPanel.setLayout(new BorderLayout());
//		自定义布局
//		larpJPanel.setLayout(null);
        // 将larJpanel放在JFrame中
        this.getContentPane().add(larpJPanel);

        // 在设置一个panel 网格布局
        JPanel btnJPanel = new JPanel();
        btnJPanel.setLayout(new FlowLayout());

        // 设置四个按钮
        JButton btnAdress = new JButton("邮件地址");
        JButton btnPwd = new JButton("密码");
        JButton btnPwd2 = new JButton("确认密码");
        JButton btnNumber = new JButton("手机号码");

        // 进行添加
        btnJPanel.add(btnAdress);
        btnAdress.setPreferredSize(new Dimension(250, 80));
        btnJPanel.add(btnPwd);
        btnJPanel.add(btnPwd2);
        btnJPanel.add(btnNumber);

        // 将网格布局btnJPanel放在larpJPanel的左边
        larpJPanel.add(btnJPanel, BorderLayout.WEST);
        btnJPanel.setPreferredSize(new Dimension(150, 80));

        // 在设置一个panel 网格布局
        JPanel txtjpanel = new JPanel();
        txtjpanel.setLayout(new FlowLayout());

        // 设置四个文本框
        JTextField txtAdress = new JTextField("nih",100);
        JTextField txtPwd = new JTextField(100);
        JTextField txtPwd2 = new JTextField(100);
        JTextField txtNumber = new JTextField(100);

        // 进行添加
        txtjpanel.add(txtAdress);
        txtjpanel.add(txtPwd);
        txtjpanel.add(txtPwd2);
        txtjpanel.add(txtNumber);

        // 将网格布局txtJPanel放在larpJPanel的右边
        larpJPanel.add(txtjpanel, BorderLayout.EAST);
        txtjpanel.setPreferredSize(new Dimension(150, 150));

        // 最后设置一个注册登录的panel
        JPanel okjJPanel = new JPanel();
        okjJPanel.setLayout(new GridLayout());

        // 设置一个注册登录按钮
        JButton btnOk = new JButton("立即注册");
        // 添加
        okjJPanel.add(btnOk);
        // 放在larpJPanel的下边
        larpJPanel.add(okjJPanel, BorderLayout.SOUTH);
        okjJPanel.setPreferredSize(new Dimension(100, 100));

    }


    public static void main(String[] args) {
        LogonForm logonForm = new LogonForm();
        logonForm.setVisible(true);
    }
}

