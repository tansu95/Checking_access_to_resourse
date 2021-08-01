import java.util.Scanner;

public class Main {
    public static User[] getUsers() {
        User user1 = new User("rob@gmail.com", "Robert", "1234", 17);
        User user2 = new User("mark@hotmail.com", "Mark", "bob", 30);
        User user3 = new User("tima@mail.ru", "Timur", "timka", 31);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Access denied. You are under 18!");
        }
    }

    public static void main(String[] args) throws UserNotFoundException,AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        try{
            User user = getUserByLoginAndPassword(login,password);
            validateUser(user);
            System.out.println("Доступ предоставлен");
        } catch (UserNotFoundException a){
            System.out.println("User does not exist");
        } catch (AccessDeniedException a){
            System.out.println("You are under 18! Access denied");
        }
    }
}