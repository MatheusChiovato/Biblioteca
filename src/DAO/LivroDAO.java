package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.Conexao;
import Livros.Livros;

// Classe (Data Access Object) responsável por fazer a comunicação entre o codigo Java e o Banco de Dados
public class LivroDAO {


    //Metodo para realizar cadastros de livros no banco de dados    
    public void cadastrarLivro(Livros livro){

        String sql = "INSERT INTO LIVROS (NOME, AUTOR) VALUES(?, ?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, livro.getNome());
            ps.setString(2, livro.getAutor());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    // Método para buscar um livro pelo ID
    public Livros buscarLivroPorID(int id){
        String sql = "SELECT * FROM LIVROS WHERE ID = ?";
        Livros livro = null;

        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                livro = new Livros();
                livro.setID(rs.getInt("ID"));
                livro.setNome(rs.getString("NOME"));
                livro.setAutor(rs.getString("AUTOR"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return livro;

    }





}