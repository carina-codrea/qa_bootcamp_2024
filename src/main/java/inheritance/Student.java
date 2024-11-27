package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{

    private double [] grades;

    private void takeExam(){
        System.out.println("The student attends the exam");
    }
}
