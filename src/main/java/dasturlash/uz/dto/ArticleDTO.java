package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ArticleDTO {
    private String title;
    private String description;
    private String content;
    private UUID imegeId;
    private Integer regionId;
    private List<Integer> categoryList;
    private List<Integer> sectionList;

}
