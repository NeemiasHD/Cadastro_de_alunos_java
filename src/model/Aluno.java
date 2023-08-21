package model;

import javax.swing.JTextField;

public class Aluno {
    private String Nome, Email;
    private String Curso;

    public Aluno(String Nome,String Email, String Curso) {
        this.Nome = Nome;
        this.Email = Email;
        this.Curso = Curso;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String titulo) {
        this.Nome = titulo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    @Override
    public String toString() {
        return "Nome: " + Nome + " Curso: " + Curso;
    }

}
