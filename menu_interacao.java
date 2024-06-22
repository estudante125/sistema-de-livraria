import java.sql.*;
import java.util.Scanner;

public class Menu {
    private static GerenteDeLivraria gerente;

    public static void main(String[] args) {
        try {
            gerente = new GerenteDeLivraria("jdbc:mysql://localhost:3306/livraria", "root", "password");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1- Cadastrar Livro");
                System.out.println("2- Consultar Livro");
                System.out.println("3- Atualizar Livro");
                System.out.println("4- Excluir Livro");
                System.out.println("5- Sair");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        cadastrarLivro(scanner);
                        break;
                    case 2:
                        consultarLivro(scanner);
                        break;
                    case 3:
                        atualizarLivro(scanner);
                        break;
                    case 4:
                        excluirLivro(scanner);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cadastrarLivro(Scanner scanner) throws SQLException {
        System.out.print("Título: ");
        String titulo = scanner.next();
        System.out.print("ID do Autor: ");
        int autorId = scanner.nextInt();
        System.out.print("Preço
}