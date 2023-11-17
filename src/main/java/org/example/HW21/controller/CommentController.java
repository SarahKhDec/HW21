package org.example.HW21.controller;

import org.example.HW21.dto.comment.CreateCommentDto;
import org.example.HW21.entity.Comments;
import org.example.HW21.mappers.CommentMapper;
import org.example.HW21.service.impl.CommentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comment")
public class CommentController {

    private final CommentServiceImpl commentService;
    private final CommentMapper commentMapper;


    @PostMapping("/create")
    @PreAuthorize("hasRole('Customer')")
    public ResponseEntity<String> create(@Valid @RequestBody CreateCommentDto createCommentDto) {
        Comments comments = commentMapper.commentDtoToComment(createCommentDto);
        commentService.create(comments);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
