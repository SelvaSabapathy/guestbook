package home.sabapathy.guestbook.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto {
    private String name;
    private String comment;
}
