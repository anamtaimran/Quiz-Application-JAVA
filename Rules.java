package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {

        this.name = name;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to OOP QUIZ");
        heading.setBounds(50, 20, 700, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Arial", Font.PLAIN, 18));

        rules.setText(
                "<html>"
                + "1. You are trained to be a programmer and not a story teller.<br><br>"
                + "2. All questions are compulsory.<br><br>"
                + "3. Crying is allowed but quietly.<br><br>"
                + "4. Be wise and answer carefully.<br><br>"
                + "5. Brace yourself, this quiz is challenging.<br><br>"
                + "6. Good Luck!<br><br>"
                + "</html>");

        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 40);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 40);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == start) {

            setVisible(false);
            new Quiz(name);

        } else {

            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
