import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TaskRepository tr = new TaskRepository("tasks.json");
        TaskServices ts = new TaskServices(tr);

        Scanner inputx = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. List");
            System.out.println("5. Mark Done");
            System.out.println("6. Search");
            System.out.println("7. Sort by Status");
            System.out.println("0. Exit");

            int choice = inputx.nextInt();
            inputx.nextLine();

            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = inputx.nextInt(); 
                    inputx.nextLine();

                    System.out.print("Title: ");
                    String title = inputx.nextLine();

                    System.out.print("Description: ");
                    String desc = inputx.nextLine();

                    tr.addTask(new Task(id, title, desc, Status.NEW));
                    break;

                case 2:
                    System.out.print("ID: ");
                    int uid = inputx.nextInt();
                    inputx.nextLine();

                    Task t = tr.getTaskByid(uid);

                    if (t != null) {
                        System.out.print("New Title: ");
                        t.setTitle(inputx.nextLine());

                        System.out.print("New Description: ");
                        t.setDescription(inputx.nextLine());

                        tr.updateTask(t);
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 3:
                    System.out.print("Delete ID: ");
                    int did = inputx.nextInt();
                    inputx.nextLine();
                    tr.deleteTask(did);
                    break;

                case 4:
                    for (Task task : tr.listAll())
                        System.out.println(task.getId() + " " + task.getTitle() + " " + task.getStatus());
                    break;

                case 5:
                    System.out.print("ID: ");
                    int mid = inputx.nextInt();
                    inputx.nextLine();
                    ts.doneMark(mid);
                    break;

                case 6:
                    System.out.print("Search text: ");
                    for (Task s : ts.search(inputx.nextLine()))
                        System.out.println(s.getId() + " " + s.getTitle());
                    break;

                case 7:
                    for (Task m : ts.sortByStatus())
                        System.out.println(m.getId() + " " + m.getStatus());
                    break;
            }
        }
    }
}
