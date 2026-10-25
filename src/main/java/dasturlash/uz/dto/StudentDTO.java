package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class StudentDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private LocalDate birthdate;
}
