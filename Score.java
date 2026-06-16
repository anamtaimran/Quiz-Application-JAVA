package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {

        setBounds(400, 150, 750, 550);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Thank You " + name + " !");
        heading.setBounds(180, 50, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your Score : " + score);
        lblscore.setBounds(250, 180, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(lblscore);

        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(280, 300, 150, 40);
        playAgain.addActionListener(this);
        add(playAgain);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 5);
    }
}
