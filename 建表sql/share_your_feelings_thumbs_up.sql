create table thumbs_up
(
    id     int auto_increment
        primary key,
    blogID int null,
    userID int null,
    constraint thumbs_up_blog_id_fk
        foreign key (blogID) references blog (id),
    constraint thumbs_up_user_id_fk
        foreign key (userID) references user (id)
);

INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (7, 19, 22);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (8, 18, 22);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (9, 17, 22);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (10, 19, 23);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (13, 23, 27);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (14, 17, 27);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (19, 24, 26);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (24, 42, 24);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (29, 40, 22);
INSERT INTO share_your_feelings.thumbs_up (id, blogID, userID) VALUES (34, 21, 26);