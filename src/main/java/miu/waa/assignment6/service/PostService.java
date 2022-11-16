package miu.waa.assignment6.service;

import miu.waa.assignment6.domain.dto.CommentDto;
import miu.waa.assignment6.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    void save(PostDto postDto);

    void deleteById(long id);

    void addComment(long postId, CommentDto commentDto);

    List<CommentDto> getComments(long id);

    List<PostDto> findByTitleMatch(String title);
}
