import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import screen.Login;

public class App extends JFrame {

    public App(){
        super();
        initialize();
        testDatabaseConnection();
    }

    private void initialize()
    {
        this.setTitle("POO Básico");
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setJMenuBar(menu());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private JMenuBar menu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu manutencao = new JMenu("Manutenção");
        JMenu ajuda = new JMenu("Ajuda");
        menuBar.add(manutencao);
        menuBar.add(ajuda);

        JMenuItem agenda = new JMenuItem("Agenda");
        JMenuItem tipoTelefone = new JMenuItem("Tipo de Telefone");
        JMenuItem sair = new JMenuItem("Sair");
        JMenuItem ajudaItem = new JMenuItem("Ajuda");
        JMenuItem sobre = new JMenuItem("Sobre...");
        manutencao.add(agenda);
        manutencao.add(tipoTelefone);
        manutencao.addSeparator();
        manutencao.add(sair);
        ajuda.add(ajudaItem);
        ajuda.addSeparator();
        ajuda.add(sobre);

        sair.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String message = "Deseja realmente sair?";
                    String title = "Sair";
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                
                    if(reply == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
            }
        );

        return menuBar;
    }

        private void testDatabaseConnection() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Conexão estabelecida com sucesso!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //new App();
        new Login();
    }
}
