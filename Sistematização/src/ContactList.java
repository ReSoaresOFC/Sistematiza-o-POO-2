
public class ContactList {
    private Node head;

    public ContactList() {
        this.head = null;
    }

    // Método para adicionar contato
    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contato adicionado com sucesso!");
    }

    // Método para buscar contato por nome ou telefone
    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(nameOrPhone) || 
                current.contact.getPhoneNumber().equals(nameOrPhone)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    // Método para remover contato por nome ou telefone
    public boolean removeContact(String nameOrPhone) {
        if (head == null) {
            return false;
        }

        if (head.contact.getName().equalsIgnoreCase(nameOrPhone) || 
            head.contact.getPhoneNumber().equals(nameOrPhone)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.contact.getName().equalsIgnoreCase(nameOrPhone) || 
                current.next.contact.getPhoneNumber().equals(nameOrPhone)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Método para listar todos os contatos
    public void listContacts() {
        if (head == null) {
            System.out.println("Nenhum contato disponível.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
}