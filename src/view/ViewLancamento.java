package view;

import javax.swing.*;

import dao.AlunoDao;
import model.Curso;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLancamento extends JFrame implements ActionListener {

    private JTextField tfcabecalho, tfNome, tfEmail;
    private JTextArea taSaidaCodigo, taSaidaNome, taSaidaEmail, taSaidaCurso;

    private JLabel jlCurso, jlNome, jlEmail, jlSaidaCodigo, jlSaidaNome, jlSaidaEmail, jlSaidaCurso;
    private JPanel jp2painel, jpinputs, jpbotoes, jpbotoesEsquerda, jpsaida;
    private JComboBox comboBox = new JComboBox<>();
    private Curso curso = new Curso();
    private AlunoDao alunoDao = new AlunoDao();
    private JButton jbsalvar, jbexcluir;

    public ViewLancamento() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setTitle("Escola 1.0");

        tfcabecalho = new JTextField("Cadastro de Aluno");
        tfcabecalho.setHorizontalAlignment(JTextField.CENTER);
        tfcabecalho.setEditable(false);
        this.setLayout(new BorderLayout());

        jlCurso = new JLabel("Curso");

        jlNome = new JLabel("Nome");
        jlEmail = new JLabel("Email");
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);

        jbsalvar = new JButton("salvar");
        jbexcluir = new JButton("excluir");

        jpbotoes = new JPanel(new FlowLayout());
        jpbotoes.add(jbsalvar);
        jpbotoes.add(jbexcluir);
        jpbotoesEsquerda = new JPanel(new BorderLayout());
        jpbotoesEsquerda.add(jpbotoes, BorderLayout.WEST);

        jpinputs = new JPanel(new GridLayout(2, 3));
        jpinputs.add(jlNome);
        jpinputs.add(jlEmail);
        jpinputs.add(jlCurso);

        jpinputs.add(tfNome);
        jpinputs.add(tfEmail);
        jpinputs.add(comboBox);

        for (int i = 0; i < Curso.Cursos.size(); i++) {
            comboBox.addItem(Curso.Cursos.get(i));

        }

        jp2painel = new JPanel(new GridLayout(2, 1));
        jp2painel.add(jpinputs);
        jp2painel.add(jpbotoesEsquerda);

        Font fonte = new Font("Arial", Font.BOLD, 80);

        jlSaidaCodigo = new JLabel("codigo");
        taSaidaCodigo = new JTextArea();
        taSaidaCodigo.setEditable(false);

        jlSaidaNome = new JLabel("Nome");
        taSaidaNome = new JTextArea();
        taSaidaNome.setEditable(false);

        jlSaidaEmail = new JLabel("Email");
        taSaidaEmail = new JTextArea();
        taSaidaEmail.setEditable(false);

        jlSaidaCurso = new JLabel("Curso");
        taSaidaCurso = new JTextArea();
        taSaidaCurso.setEditable(false);
        taSaidaCurso.setPreferredSize(new Dimension(300, 70));

        jpsaida = new JPanel(new GridLayout(2, 4));

        jpsaida.add(jlSaidaCodigo);
        jpsaida.add(jlSaidaNome);
        jpsaida.add(jlSaidaEmail);
        jpsaida.add(jlSaidaCurso);
        jpsaida.add(taSaidaCodigo);
        jpsaida.add(taSaidaNome);
        jpsaida.add(taSaidaEmail);
        jpsaida.add(taSaidaCurso);

        this.add(tfcabecalho, BorderLayout.NORTH);
        this.add(jp2painel, BorderLayout.CENTER);
        this.add(jpsaida, BorderLayout.SOUTH);

        this.setVisible(true);

        jbsalvar.addActionListener(this);
        jbexcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbsalvar) {

            alunoDao.add(tfNome.getText(), tfEmail.getText(), Curso.Cursos.get(comboBox.getSelectedIndex()));
            taSaidaCodigo.setText(alunoDao.getCodigo());
            taSaidaNome.setText(alunoDao.getNome());
            taSaidaEmail.setText(alunoDao.getEmail());
            taSaidaCurso.setText(alunoDao.getAutores());

        } else if (e.getSource() == jbexcluir) {

            alunoDao.excluir();
            taSaidaCodigo.setText(alunoDao.getCodigo());
            taSaidaNome.setText(alunoDao.getNome());
            taSaidaEmail.setText(alunoDao.getEmail());
            taSaidaCurso.setText(alunoDao.getAutores());

        }

    }

}
