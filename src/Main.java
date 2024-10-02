import DAO.LivroDAO;
import Livros.Livros;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Livros l = new Livros();

        l.setNome("O Senhor dos Anéis");
        l.setAutor("J.R.R. Tolkien");

        new LivroDAO().cadastrarLivro(l);

    }
}
