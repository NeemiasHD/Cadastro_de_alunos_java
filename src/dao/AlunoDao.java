package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import model.Curso;
import model.Aluno;

public class AlunoDao {
    List<Aluno> aluno = new ArrayList<>();
    String Nome;
    Aluno novoaluno;
    String Email;
    String Curso;
    String alunos;

    public AlunoDao() {

    }

    public void add(String Nome, String Email,String Curso) {
        this.Nome = Nome;
        this.Curso = Curso;
        this.Email = Email;
        novoaluno = new Aluno(Nome,Email,Curso);
        aluno.add(novoaluno);
    }

    public void excluir() {
        aluno.remove(aluno.size() - 1);
    }

    public String getAutores() {
        String autores = "";
        for (int i = 0; i < aluno.size(); i++) {
            autores += aluno.get(i).getCurso() + "\n";

        }
        return autores + "";
    }

    public String getNome() {
        String nome = "";
        for (int i = 0; i < aluno.size(); i++) {
            nome += aluno.get(i).getNome() + "\n";

        }
        return nome + "";
    }

    public String getEmail() {
        String Email = "";
        for (int i = 0; i < aluno.size(); i++) {
            Email += aluno.get(i).getEmail() + "\n";

        }
        return Email + "";
    }

    public String getCodigo() {
        String codigos = "";
        int nCodigo = 0;
        for (int i = aluno.size() - 1; i >= 0; i--) {
            nCodigo++;
            codigos += nCodigo + "\n";
        }
        return codigos + "";

    }

    @Override
    public String toString() {
        alunos = "";
        for (int i = 0; i < aluno.size(); i++) {
            alunos += aluno.get(i) + "\n";

        }
        return alunos + "";

    }

}
