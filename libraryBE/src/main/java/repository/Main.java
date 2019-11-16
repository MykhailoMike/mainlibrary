package repository;

public class Main {

    public static void main(String[] args) {
        if (AbstractRepository.getConnection() != null) {
            System.out.println("Connection is successful");
        } else {
            System.out.println("There is a mistake!");
        }

    }

}
