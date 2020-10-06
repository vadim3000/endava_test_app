import java.util.ArrayList;
import java.util.Calendar;

public class Application {
    public ArrayList<User> users;

    public Application() {
        this.users = new ArrayList<User>();
    }

    public static void main(String[] args) {
        Application application = new Application();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -10);
        application.users.add(new User("Piter", "White", "piter@email.test", 33, User.STATUS_NEW, calendar));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, -1);
        calendar2.add(Calendar.HOUR, -3);
        application.users.add(new User("John", "Smith", "john@email.test", 35, User.STATUS_NEW, calendar2));

        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.DATE, -1);
        calendar3.add(Calendar.HOUR, -1);
        application.users.add(new User("Juan", "Garcia", "juan@email.test", 29, User.STATUS_NEW, calendar3));

        Calendar calendar4 = Calendar.getInstance();
        calendar4.add(Calendar.DATE, -25);
        application.users.add(new User("Chuck", "Brown", "chuck@email.test", 34, User.STATUS_INACTIVE, calendar4));

        Calendar calendar5 = Calendar.getInstance();
        calendar5.add(Calendar.MONTH, -1);
        calendar5.add(Calendar.DATE, -1);
        application.users.add(new User("Johan", "Muller", "johan@email.test", 30, User.STATUS_INACTIVE, calendar5));

        /* Only John Smith and Juan Garcia will be activated */
        application.activateNewUsers();

        /* Only Johan Muller will be deactivated */
        application.deactivateOldInactiveUsers();

        application.users.forEach(System.out::println);
    }

    public void activateNewUsers() {
        this.users.forEach((User user) -> {
            Calendar dayAgo = Calendar.getInstance();
            dayAgo.add(Calendar.HOUR, -24);
            if (user.getStatus().equals(User.STATUS_NEW) & user.getCreatedAt().before(dayAgo)) {
                user.setStatus(User.STATUS_ACTIVE);
            }
        });
    }

    public void deactivateOldInactiveUsers() {
        this.users.forEach((User user) -> {
            Calendar monthAgo = Calendar.getInstance();
            monthAgo.add(Calendar.MONTH, -1);
            if (user.getStatus().equals(User.STATUS_INACTIVE) & user.getCreatedAt().before(monthAgo)) {
                user.setStatus(User.STATUS_BLOCKED);
            }
        });
    }
}
