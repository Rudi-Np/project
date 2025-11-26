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
}