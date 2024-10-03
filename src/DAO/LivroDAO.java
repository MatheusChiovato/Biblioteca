package DAO;

import Connection.Conexao;
import Entidades.Livros;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe (Data Access Object) responsável por fazer a comunicação entre o codigo Java e o Banco de Dados
public class LivroDAO {


    //Metodo para realizar cadastros de livros no banco de dados    
    public void cadastrarLivro(Livros livro){

        String sql = "INSERT INTO LIVROS (NOME, AUTOR, valor_diario, alugado) VALUES(?, ?, ?, ?)";

        PreparedStatement ps = null;
        if (verificarLivro(livro.getNome())) {
            System.out.println("Este livro ja foi cadastrado!!");
            return;
        }
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, livro.getNome());
            ps.setString(2, livro.getAutor());
            ps.setDouble(3, livro.getValorDiario());
            ps.setBoolean(4, livro.isAlugado());


            ps.execute();
            ps.close();

        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }

        if (livro.getNome() == null || livro.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode estar vazio.");
        }
        
    }


    // Método pra verificar se o livro a ser cadastrado ja existe
    public boolean verificarLivro(String nome){
        String sql = "SELECT COUNT(*) FROM LIVROS WHERE NOME = ?";
        boolean existe = false;

        try (PreparedStatement ps =  Conexao.getConexao().prepareStatement(sql)){
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count>0) {
                    existe = true;                    
                }
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return existe;
    }



    // Método para buscar um livro pelo Nome
    public Livros buscarLivroPorNome(String nome){
        String sql = "SELECT * FROM LIVROS WHERE NOME = ?";
        Livros livro = null;

        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                livro = new Livros();
                livro.setID(rs.getInt("ID"));
                livro.setNome(rs.getString("NOME"));
                livro.setAutor(rs.getString("AUTOR"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
        return livro;

    }
    // Método para buscar um livro pelo Autor
    public Livros buscarLivroPorAutor(String autor){
        String sql = "SELECT * FROM LIVROS WHERE AUTOR = ?";
        Livros livro = null;

        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, autor);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                livro = new Livros();
                livro.setID(rs.getInt("ID"));
                livro.setNome(rs.getString("NOME"));
                livro.setAutor(rs.getString("AUTOR"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
        return livro;

    }

    public Livros excluirLivroPorID(int id){
        String sql = "DELETE FROM LIVROS WHERE ID = ?";
        Livros livro = null;
        
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)){
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro excluído com sucesso!");                
            } else {
                System.out.println("Nenhum livro encontrado com o ID fornecido!");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
        return livro;
    }

    public void alugarLivro(int id){
        String sql = "UPDATE LIVROS SET alugado = ? Where ID = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)){
            ps.setBoolean(1, true);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro alugado!");
            } else{
                System.out.println("Livro não encontrado!");
            }
            
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void devolverLivro(int id){
        String sql = "UPDATE LIVROS SET alugado = ? Where ID = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)){
            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro devolvido!");
            } else{
                System.out.println("Livro não encontrado!");
            }
            
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }



    }








}