package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;

    JButton next, submit;

    public static int timer = 15;
    public static int count = 0;
    public static int score = 0;

    String name;
    Timer time;

    Quiz(String name) {

        this.name = name;

        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Questions

        questions[0][0] = "Which component is used to compile Java?";
        questions[0][1] = "JRE";
        questions[0][2] = "JIT";
        questions[0][3] = "JDK";
        questions[0][4] = "JVM";

        questions[1][0] = "Which is not a Java feature?";
        questions[1][1] = "Object Oriented";
        questions[1][2] = "Use of pointers";
        questions[1][3] = "Portable";
        questions[1][4] = "Dynamic";

        questions[2][0] = "Which cannot be variable name?";
        questions[2][1] = "Identifier";
        questions[2][2] = "Keyword";
        questions[2][3] = "Variable";
        questions[2][4] = "Class";

        questions[3][0] = "Extension of Java source file?";
        questions[3][1] = ".txt";
        questions[3][2] = ".java";
        questions[3][3] = ".class";
        questions[3][4] = ".js";

        questions[4][0] = "Java Path Variable?";
        questions[4][1] = "JAVA_HOME";
        questions[4][2] = "JAVA";
        questions[4][3] = "JDK";
        questions[4][4] = "PATH";

        answers[0][1] = "JDK";
        answers[1][1] = "Use of pointers";
        answers[2][1] = "Keyword";
        answers[3][1] = ".java";
        answers[4][1] = "JAVA_HOME";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 630, 200, 40);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        time = new Timer(1000, e -> {

            timer--;
            repaint();

            if (timer <= 0) {

                timer = 15;
                recordAnswer();

                if (count == 4) {
                    time.stop();
                    calculateScore();
                    setVisible(false);
                    new Score(name, score);
                } else {
                    count++;
                    start(count);
                }
            }
        });

        time.start();
        setVisible(true);
    }

    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        g.drawString("Time Left: " + timer, 1100, 500);
    }

    public void start(int count) {

        qno.setText((count + 1) + ".");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);

        groupoptions.clearSelection();
    }

    void recordAnswer() {

        if (opt1.isSelected())
            useranswers[count][0] = opt1.getText();
        else if (opt2.isSelected())
            useranswers[count][0] = opt2.getText();
        else if (opt3.isSelected())
            useranswers[count][0] = opt3.getText();
        else if (opt4.isSelected())
            useranswers[count][0] = opt4.getText();
    }

    void calculateScore() {

        for (int i = 0; i <= 4; i++) {

            if (useranswers[i][0] != null &&
                    useranswers[i][0].equals(answers[i][1])) {
                score++;
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {

            recordAnswer();

            count++;

            if (count == 4) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            start(count);

        } else {

            recordAnswer();
            calculateScore();

            setVisible(false);
            new Score(name, score);
        }
    }
}
