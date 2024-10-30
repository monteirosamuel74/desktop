package screen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MinhaTela extends JFrame {

    public MinhaTela() {
        super();
        iniciarTela();
    }

    public void iniciarTela() {
        this.setTitle("Minha Tela - Atividade Dsktp");
        this.setSize(300, 280);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JTextField textoField = new JTextField();
        textoField.setBounds(10, 50, 260, 30);
        textoField.setText("Digite algo aqui...");
        this.add(textoField);

        JButton botao = new JButton();
        botao.setBounds(80, 130, 120, 30);
        botao.setText("Me aperte");
        this.add(botao);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MinhaTela();
    }

}
