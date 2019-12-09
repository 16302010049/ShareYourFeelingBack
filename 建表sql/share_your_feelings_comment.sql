create table comment
(
    id       int auto_increment
        primary key,
    blogId   int      null,
    content  text     null,
    time     datetime null,
    authorID int      null,
    constraint comment_blog_id_fk
        foreign key (blogId) references blog (id),
    constraint comment_user_id_fk
        foreign key (authorID) references user (id)
);

INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (2, 17, 'haha', '2019-12-03 22:49:48', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (3, 17, 'hh', '2019-12-04 09:40:16', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (4, 17, 'hehe', '2019-12-04 09:42:17', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (6, 17, 'mk', '2019-12-04 10:14:23', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (8, 17, '我说', '2019-12-04 10:20:37', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (10, 19, 'pp', '2019-12-04 10:23:09', 23);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (11, 19, 'pp', '2019-12-04 11:40:18', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (13, 19, 'pp', '2019-12-04 11:42:19', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (15, 17, 'nm', '2019-12-04 12:37:18', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (16, 17, 'gg', '2019-12-04 12:37:56', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (23, 19, '测试', '2019-12-04 12:39:48', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (24, 19, 'UI', '2019-12-04 12:39:54', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (25, 19, 'fff', '2019-12-04 12:45:17', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (26, 19, 'ff', '2019-12-04 12:45:25', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (27, 18, 'ff', '2019-12-04 12:45:34', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (28, 18, 'ppp', '2019-12-04 15:50:31', 22);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (30, 17, 'dd', '2019-12-04 20:16:05', 23);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (31, 23, 'pp', '2019-12-05 09:22:24', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (32, 24, 'op', '2019-12-05 09:24:44', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (35, 21, 'what', '2019-12-05 19:01:57', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (37, 21, 'w', '2019-12-06 19:22:50', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (38, 21, 'ww', '2019-12-06 19:22:51', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (39, 21, 'ww', '2019-12-06 19:22:52', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (40, 21, 'ww', '2019-12-06 19:22:55', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (41, 21, 'www', '2019-12-06 19:23:00', 27);
INSERT INTO share_your_feelings.comment (id, blogId, content, time, authorID) VALUES (45, 21, 'eee', '2019-12-09 21:42:38', 26);