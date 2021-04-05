package home.sabapathy.guestbook.controller;

import home.sabapathy.guestbook.controller.dto.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestbook")
public class GuestBookController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getEntries() {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addEntry(@RequestBody CommentDto commentDto) {
        return null;
    }
}
