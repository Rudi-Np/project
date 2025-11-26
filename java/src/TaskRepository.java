import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository{

 private final File file;   
 private final Map<Integer, Task> tasks = new HashMap<>(); 

 public TaskRepository(String filePath) {
        this.file = new File(filePath);
        load();
    }

public void addTask(Task task){
        tasks.put(task.getId(),task);
         save();

}
public void updateTask(Task task){
       tasks.put(task.getId(),task);
       save();
}
public void deleteTask(int id) {
        tasks.remove(id);
        save();
    }
public Task getTaskByid(int id){
         return tasks.get(id); 
}
public List<Task> listAll(){
         return new ArrayList<>(tasks.values());

}
private void load(){
     if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String json = br.readLine();
            if (json == null || json.isEmpty()) return;

            json = json.substring(1, json.length() - 1); 
            if (json.trim().isEmpty()) return;

            String[] items = json.split("\\},\\{");

            for (String item : items) {
                item = item.replace("{", "").replace("}", "");
                String[] parts = item.split(",");

                int id = 0;
                String title = "";
                String description = "";
                Status status = Status.NEW;

                for (String part : parts) {
                    String[] kv = part.split(":");
                    String key = kv[0].replace("\"", "").trim();
                    String value = kv[1].replace("\"", "").trim();

                    switch (key) {
                        case "id": id = Integer.parseInt(value); break;
                        case "title": title = value; break;
                        case "description": description = value; break;
                        case "status": status = Status.valueOf(value); break;
                    }
                }

                tasks.put(id, new Task(id, title, description, status));
            }
        } catch (Exception ignored) {}

}
private void save(){
    try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.print("[");

            boolean first = true;
            for (Task t : tasks.values()) {
                if (!first) pw.print(",");
                first = false;

                pw.print("{");
                pw.print("\"id\":" + t.getId() + ",");
                pw.print("\"title\":\"" + t.getTitle() + "\",");
                pw.print("\"description\":\"" + t.getDescription() + "\",");
                pw.print("\"status\":\"" + t.getStatus().name() + "\"");
                pw.print("}");
            }

            pw.print("]");
        } catch (Exception ignored) {}
    }
    
}
