import java.util.Scanner;

public class UserInterface {
    int option;

    public UserInterface() {
        this.option = 0;
    }

    void chooseOption() {
        System.out.println("\n---------------------BIBLIOTECA VIRTUAL---------------------\n");

        System.out.println("1. Listar livros.");
        System.out.println("2. Adicionar livro para acervo.");
        System.out.println("3. Navegar histórico de ações.");
        System.out.println("4. Ver recomendações de livros.");
        System.out.println("5. Sair");

        System.out.print("Escolha sua opção: ");

        Scanner scanner = new Scanner(System.in);

        this.option = Integer.parseInt(scanner.nextLine());

        System.out.print("\n");
    }

    int chooseIndexBook(String message) {
        System.out.print(message + " ");

        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    void printInvalidOption() {
        System.out.println("Opção inválida!");
    }

    String askContinuousLoop() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Desejar continuar (S/N): ");

        return scanner.nextLine();
    }

    int getOption() {
        return this.option;
    }

}