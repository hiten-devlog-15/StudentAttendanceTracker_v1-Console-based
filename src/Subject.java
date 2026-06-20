import java.util.Locale;

public class Subject {
    private String name;

    Subject(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }


}
