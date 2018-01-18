package com.codexsoft.tasktracking.dao.impl;

import com.codexsoft.tasktracking.dao.CommentDao;
import com.codexsoft.tasktracking.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends CrudDaoImpl<Comment, Long> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }

    @Override
    Long getKey(Comment entity) {
        return entity.getId();
    }

}
