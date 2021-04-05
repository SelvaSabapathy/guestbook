package home.sabapathy.guestbook.controller;

import home.sabapathy.guestbook.controller.dto.CommentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guestbook")
public class GuestBookController {

    @GetMapping
    public List<CommentDto> getEntries() {
        return null;
    }
}
