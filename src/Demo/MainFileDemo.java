package Demo;

import java.io.File;

public class MainFileDemo {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User user = new User("Tiến", "7968", "tiEn99@gmail.com");
        User user1 = new User("Nam", "7968", "tiEn99@gmail.com");
        User user2 = new User("Trung", "7968", "tiEn99@gmail.com");
        User user3 = new User("Hoàng", "7968", "tiEn99@gmail.com");
        userManager.add(user);
        userManager.add(user1);
        userManager.add(user2);
        userManager.add(user3);

        System.out.println("Danh sách các User:");
        userManager.showListUsers();
        userManager.delete("Tiến");

        System.out.println("\nDanh sách User sau khí Delete:");
        userManager.showListUsers();

        User newUser = new User("Hoàng", "6869", "HoAng96@gmail.com");
        userManager.update("Tiến", newUser);

        System.out.println("\nDanh sách User sau khi Update:");
        userManager.showListUsers();
    }
}
