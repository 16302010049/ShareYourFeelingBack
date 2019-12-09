create table blog
(
    id         int auto_increment
        primary key,
    content    text     null,
    commentNum int      null,
    tranNum    int      null,
    zanNum     int      null,
    date       datetime null,
    imageList  json     null,
    authorID   int      null,
    constraint blog_user_id_fk
        foreign key (authorID) references user (id)
);

INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (17, '测试', 8, 2, 2, '2019-12-03 21:11:46', '["http://localhost:8080/img/889f94ba-abc7-45c7-8417-2ba71519a8dd.jpg", "http://localhost:8080/img/14a9c68f-c0b8-484b-afeb-2885bd311e57.jpg", "http://localhost:8080/img/bea4d4cf-fa1c-4e17-91e5-a769ce414658.jpg", "http://localhost:8080/img/dfb59720-92fd-47cc-b1b1-d05cbacfb84a.jpg", "http://localhost:8080/img/7c0f6475-d439-480b-a041-2cf9046db891.jpg", "http://localhost:8080/img/a8f193e2-3bc2-40bc-82ba-0ea7cf8b01f9.jpg", "http://localhost:8080/img/ad0a8237-ade8-4f26-bd6f-7cae1cfce559.jpg"]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (18, 'test', 2, 0, 1, '2019-12-04 09:30:29', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (19, '栽种', 7, 0, 2, '2019-12-04 10:22:12', '[]', 23);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (20, '加法', 0, 0, 0, '2019-12-04 20:56:08', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (21, 'MEMEME', 7, 1, 1, '2019-12-04 20:56:40', '["http://localhost:8080/img/c6c8c853-8814-446e-85cb-e9191306afaa.jpg"]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (23, 'oooo', 1, 2, 1, '2019-12-04 20:58:33', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (24, 'PIPO', 1, 2, 1, '2019-12-04 21:00:33', '[]', 24);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (35, 'gg', 0, 0, 0, '2019-12-05 22:57:49', '["http://localhost:8080/img/96db0132-cad0-4f5c-b8b7-fd047698bd2a.jpg"]', 26);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (36, 'pppp', 0, 0, 0, '2019-12-06 09:11:11', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (37, 'test2', 0, 0, 0, '2019-12-06 09:15:48', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (39, 'ts4', 0, 0, 0, '2019-12-06 09:16:08', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (40, 'ts5', 0, 0, 1, '2019-12-06 09:16:12', '[]', 22);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (42, '噗噗噗', 0, 0, 1, '2019-12-08 00:37:08', '[]', 24);
INSERT INTO share_your_feelings.blog (id, content, commentNum, tranNum, zanNum, date, imageList, authorID) VALUES (63, '转发自Tonk:MEMEME', 0, 0, 0, '2019-12-09 21:42:33', '["http://localhost:8080/img/c6c8c853-8814-446e-85cb-e9191306afaa.jpg"]', 26);