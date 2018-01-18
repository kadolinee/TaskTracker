package com.codexsoft.tasktracking.service.impl;

import com.codexsoft.tasktracking.dao.CommentDao;
import com.codexsoft.tasktracking.entity.Comment;
import com.codexsoft.tasktracking.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends CrudServiceImpl<Comment, Long> implements CommentService {

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        super(commentDao);
    }
}
