
public class Task {
private int id;
private String title;
private String description;
private Status status;


public Task(int id, String title, String description,Status status){
    this.id=id;
    this.title=title;
    this.description=description;
    this.status=status;
}

public  int getId(){
   return id;
}

public String getTitle(){
    return title;
}
public String getDescription(){
    return description;
}

public Status getStatus(){
    return status;
}

public void setTitle(String Title){
    this.title=Title;
}
public void setDescription(String Description){
    this.description=Description;
}
public void setstatus(Status status){
    this.status=status;
}
}
