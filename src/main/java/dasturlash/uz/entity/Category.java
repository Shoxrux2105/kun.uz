package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "name_uz", nullable = false)
    private String nameUz;

    @Column(name = "name_ru", nullable = false)
    private String nameRu;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(nullable = false)
    private Boolean visible = true;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
        if (visible == null) {
            visible = true;
        }
    }
}
