package Entidades;

public class Livros {
    
    private int idLivro;
    private String nomeLivro;
    private String autor;
    private double valorDiario;
    private boolean alugado;
    private int quantidade;

    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public int getID() {
        return idLivro;
    }
    public void setID(int iD) {
        idLivro = iD;
    }


    public String getNome() {
        return nomeLivro;
    }
    public void setNome(String nomeLivro) {
        this.nomeLivro = nomeLivro;
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


