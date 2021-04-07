package home.sabapathy.guestbook.service;

import home.sabapathy.guestbook.controller.dto.CommentDto;
import home.sabapathy.guestbook.entity.Comment;
import home.sabapathy.guestbook.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuestBookServiceTest {
    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private GuestBookService guestBookService;

    @Test
    public void getComments() {
        when(commentRepository.findAll()).thenReturn(new ArrayList<Comment>());
        guestBookService.getComments();
        verify(commentRepository).findAll();
    }

    @Test
    public void addComment() {
        when(commentRepository.save(any(Comment.class))).thenReturn(new Comment());
        guestBookService.addComment(new Comment());
        verify(commentRepository).save(any(Comment.class));

    }
}
