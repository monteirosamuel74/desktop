package screen;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import data.Pessoa;
import utils.SistemaAgenda;
import utils.PessoaTableModel;
import screen.ConsultaAgenda;

public class ManutencaoAgenda extends JDialog {

    // Labels
    JLabel labelFiltro = new JLabel();

    // TextField
    JTextField textFieldFiltro = new JTextField();

    // Table
    PessoaTableModel tableModel = new PessoaTableModel();
    JTable tabela = new JTable(tableModel);
    JScrollPane scrollTable = new JScrollPane(tabela);

    // Buttons
    JButton buttonInserir = new JButton();
    JButton buttonAlterar = new JButton();
    JButton buttonExcluir = new JButton();

    public AlteraAgenda() {
        super();
        initialize();
    }

    public void ManutAlteraAgenda() {

        try {
            // Limpa a tabela
            tableModel.setPessoas(new ArrayList<>());

            // Aplicar filtro
            String filtro = textFieldFiltro.getText().toLowerCase();

            // Formato de data brasileiro
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Pessoa> pessoasFiltradas = SistemaAgenda.getAgendaUsuarioLogado().getPessoas().stream()
                    .filter(pessoa -> filtro.isEmpty() ||
                            pessoa.getNome().toLowerCase().contains(filtro) ||
                            pessoa.getTelefonesFormatados().toLowerCase().contains(filtro) ||
                            pessoa.getEmailsFormatados().toLowerCase().contains(filtro) ||
                            sdf.format(pessoa.getDataNascimento()).contains(filtro))
                    .collect(Collectors.toList());

            tableModel.setPessoas(pessoasFiltradas);
        } catch (Exception exc) {
            System.out.printf(exc.getMessage());
        }
    }

    public void excluir(Pessoa pessoa) {
        screen.ConsultaAgenda.excluir(pessoa);
    }

    public void Alterar(Pessoa pessoa) {
        ManutencaoAgenda();
    }

    private void initialize() {
        this.setTitle("Consulta da Agenda");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);

        // Buttons
        buttonInserir.setSize(100, 50);
        buttonInserir.setLocation(20, 410);
        buttonInserir.setText("Inserir");
        buttonInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        buttonAlterar.setSize(100, 50);
        buttonAlterar.setLocation(140, 410);
        buttonAlterar.setText("Alterar");
        buttonAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se existe um registro selecionado
                if (tabela.getSelectedRow() != -1) {
                    // Pega o objeto Pessoa da linha selecionada da tabela
                    Pessoa pessoa = tableModel.getPessoaAt(tabela.getSelectedRow());
                    // Passa o objeto Pessoa como parâmetro para o construtor da classe
                    // ManutencaoAgenda
                    // new ManutencaoAgenda(pessoa);
                    
                }
            }
        });

        buttonExcluir.setSize(100, 50);
        buttonExcluir.setLocation(260, 410);
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new ActionListener() {
            
                    }
                }
            }
        });

        // Labels
        labelFiltro.setSize(40, 20);
        labelFiltro.setLocation(20, 20);
        labelFiltro.setText("Filtro:");

        // TextField
        textFieldFiltro.setSize(400, 20);
        textFieldFiltro.setLocation(60, 20);
        textFieldFiltro.addKeyListener(new KeyListener() {

    public void keyPressed(KeyEvent keyEvent) {
        // Verifica se a tecla (ENTER) foi pressionada
        if (keyEvent.getKeyCode() == 10) {
        }
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

});
