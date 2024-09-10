import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Exibir opções do menu
            System.out.println("Sistema de Gerenciamento de Contatos");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    // Adicionar novo contato
                    System.out.print("Digite o nome do contato: ");
                    String name = scanner.nextLine();

                    // Validar número de telefone
                    String phoneNumber;
                    while (true) {
                        System.out.print("Digite o número de telefone (máx 11 dígitos): ");
                        phoneNumber = scanner.nextLine();
                        if (phoneNumber.length() <= 11 && phoneNumber.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("Número de telefone inválido. Por favor, insira um número com até 11 dígitos.");
                        }
                    }

                    // Validar e-mail
                    String email;
                    while (true) {
                        System.out.print("Digite o e-mail (deve conter '@'): ");
                        email = scanner.nextLine();
                        if (email.contains("@")) {
                            break;
                        } else {
                            System.out.println("E-mail inválido. Por favor, inclua '@' no e-mail.");
                        }
                    }

                    Contact newContact = new Contact(name, phoneNumber, email);
                    contactList.addContact(newContact);
                    System.out.println("Contato adicionado com sucesso!");
                    break;

                case 2:
                    // Buscar contato
                    System.out.print("Digite o nome ou número de telefone para buscar: ");
                    String searchTerm = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchTerm);

                    if (foundContact != null) {
                        System.out.println("Contato encontrado:");
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    // Remover contato
                    System.out.print("Digite o nome ou número de telefone para remover: ");
                    String removeTerm = scanner.nextLine();

                    boolean removed = contactList.removeContact(removeTerm);

                    if (removed) {
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    // Listar todos os contatos
                    System.out.println("Lista de Contatos:");
                    contactList.listContacts();
                    break;

                case 5:
                    // Sair
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            System.out.println(); // Adiciona uma linha em branco para separação
        } while (option != 5);

        scanner.close(); // Fechar o scanner
    }
}
