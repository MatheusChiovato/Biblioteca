package Entidades;

public class Livros {
    
    private int ID;
    private String nome;
    private String autor;
    private double valorDiario;
    private boolean alugado;

    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }


    public double getValorDiario() {
        return valorDiario;
    }
    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }


    public boolean isAlugado() {
        return alugado;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

}


