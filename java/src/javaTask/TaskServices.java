package javaTask;
import java.util.*;
import java.util.stream.Collectors;

public class TaskServices {

      private TaskRepository repository;


    public TaskServices(TaskRepository repository){
       
        this.repository=repository;
    }

public void doneMark(int id){
     Task td=repository.getTaskByid(id);
     if(td!=null){
        td.setstatus(Status.DONE);
        repository.updateTask(td);
     }  
         
}
public List<Task> search(String text) {
        String s = text.toLowerCase();
        return repository.listAll().stream()
                .filter(t -> t.getTitle().toLowerCase().contains(s)
                        || t.getDescription().toLowerCase().contains(s))
                .collect(Collectors.toList());
    }
     


   public List<Task> sortByStatus() {
    return repository.listAll().stream()
            .sorted((task1, task2) -> {
                return task1.getStatus().ordinal() - task2.getStatus().ordinal();
            })
            .collect(Collectors.toList());
}
}