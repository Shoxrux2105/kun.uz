package dasturlash.uz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegionDTO {

    @NotNull(message = "Tartib raqami kiritilishi kerak")
    @PositiveOrZero(message = "Tartib raqami manfiy bo'lmasligi kerak")
    private Integer orderNumber;

    @NotBlank(message = "O'zbekcha nom kiritilishi kerak")
    @Size(max = 100, message = "O'zbekcha nom 100 ta belgidan oshmasligi kerak")
    private String nameUz;

    @NotBlank(message = "Ruscha nom kiritilishi kerak")
    @Size(max = 100, message = "Ruscha nom 100 ta belgidan oshmasligi kerak")
    private String nameRu;

    @NotBlank(message = "Inglizcha nom kiritilishi kerak")
    @Size(max = 100, message = "Inglizcha nom 100 ta belgidan oshmasligi kerak")
    private String nameEn;
}
