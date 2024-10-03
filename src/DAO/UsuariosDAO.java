package DAO;

import Connection.Conexao;
import Entidades.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuariosDAO {
    
    public void cadastrarUsuario(Usuarios usuario) {
        String sql = "INSERT INTO Usuarios (nome_usuarios, cpf_usuarios) VALUES(?, ?)";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());

            ps.execute();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
