package assignments.library;

import assignments.library.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String name;
    private int year;
    private Author author;
    private double price;

}
