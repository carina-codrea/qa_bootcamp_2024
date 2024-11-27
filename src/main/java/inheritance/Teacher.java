package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person{
    private String job;

    public void teachCourse(){
        System.out.println("Teaching at " + this.job);
    }
}
