create table message
(
    id          int auto_increment
        primary key,
    userIDSmall int  null,
    userIDBig   int  null,
    content     json null,
    constraint Message_user_id_fk
        foreign key (userIDSmall) references user (id),
    constraint Message_user_id_fk_2
        foreign key (userIDBig) references user (id)
);

INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (7, 24, 27, '[{"userID": 27, "content": "pp"}, {"userID": 27, "content": "pp"}, {"userID": 27, "content": "pp"}, {"userID": 24, "content": "pnmb"}]');
INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (8, 26, 27, '[{"userID": 27, "content": "pp"}, {"userID": 27, "content": "ll"}]');
INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (9, 25, 27, '[{"userID": 27, "content": "msmm"}]');
INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (10, 22, 27, '[{"userID": 27, "content": "jfkljfle"}, {"userID": 27, "content": "jfkljfle"}, {"userID": 27, "content": "ll"}, {"userID": 27, "content": "pp"}, {"userID": 27, "content": "pp"}, {"userID": 27, "content": "pp"}]');
INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (11, 23, 27, '[{"userID": 27, "content": "ll"}]');
INSERT INTO share_your_feelings.message (id, userIDSmall, userIDBig, content) VALUES (12, 24, 26, '[{"userID": 24, "content": "kkk"}, {"userID": 24, "content": "kkkllook"}, {"userID": 24, "content": "kkkllook"}, {"userID": 24, "content": "kkkllook"}, {"userID": 24, "content": "lll"}, {"userID": 24, "content": "pp4"}, {"userID": 26, "content": "lpfke"}]');