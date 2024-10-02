package DAO;

import java.sql.PreparedStatement;
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

}
