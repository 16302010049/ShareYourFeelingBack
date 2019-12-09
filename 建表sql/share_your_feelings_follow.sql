create table follow
(
    id         int auto_increment
        primary key,
    followerID int      null,
    followID   int      null,
    time       datetime null,
    constraint follow_user_id_fk
        foreign key (followID) references user (id),
    constraint follow_user_id_fk_2
        foreign key (followerID) references user (id)
);

INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (15, 27, 22, '2019-12-05 19:01:30');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (16, 27, 23, '2019-12-05 19:01:32');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (17, 27, 24, '2019-12-05 19:01:33');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (22, 26, 27, '2019-12-05 19:11:21');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (27, 27, 25, '2019-12-07 22:36:40');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (28, 24, 23, '2019-12-08 00:36:19');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (31, 22, 24, '2019-12-08 22:53:23');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (33, 24, 27, '2019-12-09 20:57:56');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (34, 24, 25, '2019-12-09 20:58:40');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (35, 24, 26, '2019-12-09 20:58:55');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (36, 26, 22, '2019-12-09 21:42:12');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (37, 26, 23, '2019-12-09 21:42:16');
INSERT INTO share_your_feelings.follow (id, followerID, followID, time) VALUES (38, 26, 26, '2019-12-09 21:42:46');