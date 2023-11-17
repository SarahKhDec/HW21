package org.example.HW21.mappers;

import org.example.HW21.dto.comment.CreateCommentDto;
import org.example.HW21.entity.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comments commentDtoToComment(CreateCommentDto createCommentDto);
}
