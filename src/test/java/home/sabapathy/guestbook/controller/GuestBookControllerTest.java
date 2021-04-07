package home.sabapathy.guestbook.controller;

import home.sabapathy.guestbook.controller.dto.CommentDto;
import home.sabapathy.guestbook.entity.Comment;
import home.sabapathy.guestbook.service.GuestBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuestBookControllerTest {

    @Mock
    private GuestBookService guestBookService;

    @InjectMocks
    private GuestBookController guestBookController;

    @Test
    public void getComments() {
        when(guestBookService.getComments()).thenReturn(new ArrayList<Comment>());
        guestBookController.getComments();
        verify(guestBookService).getComments();
    }

    @Test
    public void addComment() {
        when(guestBookService.addComment(any(Comment.class))).thenReturn(new Comment());
        guestBookController.addComment(new CommentDto());
        verify(guestBookService).addComment(any(Comment.class));
    }
}
