package screen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
    public Login(){
        super();
        initialize();
    }

    private void initialize()
    {
        this.setTitle("Login - Agenda");
        this.setSize(300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //Componentes do Login
        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(10, 10, 60, 30);
        JTextField loginField = new JTextField();
        loginField.setBounds(80, 10, 150, 30);
        this.add(loginLabel);
        this.add(loginField);
        
        //Componentes da Senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 50, 60, 30);
        JTextField senhaField = new JTextField();
        senhaField.setBounds(80, 50, 150, 30);
        this.add(senhaLabel);
        this.add(senhaField);

        this.setVisible(true);
    }
}
