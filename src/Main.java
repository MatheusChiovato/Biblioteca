import DAO.*;
import Entidades.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        Usuarios u = new Usuarios("Maria Silva", "12345678900");

        usuariosDAO.cadastrarUsuario(u);
        

    }
}
