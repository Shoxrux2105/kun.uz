package dasturlash.uz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileDTO {

    @NotBlank(message = "Ism bo'sh bo'lmasligi kerak")
    private String name;

    @NotBlank(message = "Familiya bo'sh bo'lmasligi kerak")
    private String surname;

    @Email(message = "Email formati noto'g'ri")
    private String email;

    @Size(min = 9, message = "Telefon raqami kamida 9 ta belgidan iborat bo'lishi kerak")
    private String phone;

    @NotBlank(message = "Parol bo'sh bo'lmasligi kerak")
    @Size(min = 8, message = "Parol kamida 8 ta belgidan iborat bo'lishi kerak")
    private String password;
}
