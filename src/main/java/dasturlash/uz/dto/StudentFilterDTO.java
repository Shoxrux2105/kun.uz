package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentFilterDTO {
    private String name;
    private String surname;
    private Integer age;
    private LocalDate birthdateFrom;
    private LocalDate birthdateTo;
}
