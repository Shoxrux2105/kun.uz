
package dasturlash.uz.entity;

import dasturlash.uz.enums.ArticleStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "shared_count")
    private Integer sharedCount = 0;

    // Hozircha AttachEntity mavjud bo'lmagani uchun uning UUID sini saqlaymiz.
    @Column(name = "image_id")
    private UUID imageId;

    // Bitta Article bitta Region ga tegishli bo'ladi.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    // Maqolani yozgan moderator.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id")
    private ProfileEntity moderator;

    // Maqolani chop etgan publisher.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private ProfileEntity publisher;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ArticleStatusEnum status = ArticleStatusEnum.NOT_PUBLISHED;

    // Maqolani o'qish uchun ketadigan vaqt (daqiqada).
    @Column(name = "read_time")
    private Integer readTime;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "published_date")
    private LocalDateTime publishedDate;

    @Column(name = "visible")
    private Boolean visible = true;

    @Column(name = "view_count")
    private Integer viewCount = 0;

    // Bitta maqolaga bir nechta Category biriktirilishi mumkin.
    @ManyToMany
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categoryList = new HashSet<>();

    // Bitta maqola bir nechta Section da ko'rinishi mumkin.
    @ManyToMany
    @JoinTable(
            name = "article_section",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private Set<SectionEntity> sectionList = new HashSet<>();
}
