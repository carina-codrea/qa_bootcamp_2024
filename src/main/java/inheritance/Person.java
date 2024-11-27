package inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;

    public void eat(){
        System.out.println("The person is eats healthy everyday");
    }
}
