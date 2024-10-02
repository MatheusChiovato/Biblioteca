import DAO.LivroDAO;
import Livros.Livros;

public class Main {
    public static void main(String[] args) throws Exception {
        
        LivroDAO livroDAO = new LivroDAO();
        Livros l = livroDAO.buscarLivroPorID(2);

        if (l!=null) {
            System.out.println("Livro Encontrado: ");
            System.out.println("ID: #"+ l.getID());
            System.out.println("Nome: "+ l.getNome());
            System.out.println("Autor: "+ l.getAutor());
        } else{
            System.out.println("Livro NÃO Encontrado!!");
        }

    }
}
