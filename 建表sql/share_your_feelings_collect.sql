create table collect
(
    id     int auto_increment
        primary key,
    userID int      null,
    blogID int      null,
    time   datetime null,
    constraint collect_blog_id_fk
        foreign key (blogID) references blog (id),
    constraint collect_user_id_fk
        foreign key (userID) references user (id)
);

INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (26, 22, 18, '2019-12-04 17:37:16');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (33, 22, 17, '2019-12-04 19:32:49');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (35, 23, 19, '2019-12-04 20:18:12');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (36, 23, 18, '2019-12-04 20:18:14');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (39, 27, 21, '2019-12-05 09:23:44');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (41, 27, 17, '2019-12-05 10:12:27');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (44, 27, 23, '2019-12-05 10:59:23');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (45, 27, 24, '2019-12-05 10:59:24');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (46, 25, 24, '2019-12-05 18:33:55');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (53, 22, 36, '2019-12-08 22:53:08');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (58, 24, 42, '2019-12-09 18:02:34');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (59, 24, 40, '2019-12-09 18:02:41');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (60, 24, 39, '2019-12-09 18:02:44');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (79, 26, 42, '2019-12-09 21:41:48');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (80, 26, 40, '2019-12-09 21:41:50');
INSERT INTO share_your_feelings.collect (id, userID, blogID, time) VALUES (82, 26, 24, '2019-12-09 21:42:50');