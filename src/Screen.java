import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{

    private final Calculator calculator = new Calculator();

    public Screen() {

        setTitle("Calculadora Básica");
        setSize(420,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(35,35 ,35));

        // Display
        JTextField display = new JTextField();
        display.setBounds(30,30,340,60);
        display.setFont(new Font("Arial", Font.PLAIN, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(20,20,20));
        display.setForeground(Color.WHITE);
        add(display);

        // Configuração botões
        int width = 70;
        int height = 60;
        int spacing= 15;

        int xInitial = 30;
        int yInitial = 120;

        Font fontNum = new Font("Arial", Font.BOLD, 20);
        // Numeros

        String[] num = {
                "7","8","9",
                "4","5","6",
                "1","2","3",
                "0"
        };

        int colunm = 0;
        int line = 0;

        for (int i = 0; i <num.length; i++){

            JButton btn = new JButton(num[i]);

            int x = xInitial + (colunm * (width + spacing));
            int y = yInitial + (line * (height + spacing));

            btn.setBounds(x, y, width, height);
            btn.setFont(fontNum);
            btn.setBackground(new Color(60,60,60));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);

            btn.addActionListener(e -> {
                calculator.addNumber(e.getActionCommand());
                display.setText(calculator.getDisplayValue());
            });

            add(btn);

            colunm++;
            if (colunm == 3){
                colunm = 0;
                line++;
            }
        }

        // Botão Operação
        String[] ope = {"+","-","x", "/" };

        int xOpe = 30 + 3 * (width + spacing);

        for (int i = 0; i< ope.length; i++){

            JButton btn = new JButton(ope[i]);

            int y = yInitial + (i * (height + spacing));

            btn.setBounds(xOpe, y, width, height);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            btn.setBackground(new Color(255,140,0));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);

            btn.addActionListener(e -> {
                calculator.setOperator(e.getActionCommand());
            });
            add(btn);
        }

        //result botão

        JButton btnResult = new JButton("=");
        btnResult.setBounds(30, 120 + 4 * (height + spacing), width * 3 + spacing * 2, height);
        btnResult.setFont(new Font("Arial", Font.BOLD, 22));
        btnResult.setBackground(new Color(0,180,0));
        btnResult.setForeground(Color.WHITE);
        btnResult.setFocusPainted(false);

        btnResult.addActionListener(e -> {
            calculator.calculate();
            display.setText(calculator.getDisplayValue());
        });

        add(btnResult);

        setVisible(true);


    }
}