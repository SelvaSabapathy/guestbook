package home.sabapathy.guestbook.controller;

import home.sabapathy.guestbook.controller.dto.CommentDto;
import home.sabapathy.guestbook.entity.Comment;
import home.sabapathy.guestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guestbook")
public class GuestBookController {
    @Autowired
    private GuestbookService guestbookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getEntries() {
        List<Comment> comments = guestbookService.getComments();
        return comments.stream().map(c -> new CommentDto(c.getName(), c.getComment())).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addEntry(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setComment(commentDto.getComment());
        Comment savedComment = guestbookService.addComment(comment);
        return new CommentDto(savedComment.getName(), savedComment.getComment());
    }
}
