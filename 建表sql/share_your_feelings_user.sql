create table user
(
    id            int auto_increment
        primary key,
    name          text null,
    mailbox       text null,
    sex           text null,
    pass          text null,
    birthday      text null,
    signature     text null,
    imageurl      text null,
    tags          json null,
    blogNum       int  null,
    guanNum       int  null,
    fansNum       int  null,
    backgroundUrl text null
);

INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (22, 'Tonk', 'test@test.com', 'male', '123456As@', 'Tue Dec 17 2019 00:00:00 GMT+0800 (中国标准时间)', 'Fuck', 'http://localhost:8080/img/290e3f54-4c9d-43ef-8f11-c6687a786536.jpg', '[]', 9, 1, 2, 'http://localhost:8080/img/a657725c-88ec-45e3-a5da-c4640d4dbc68.jpg');
INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (23, 'fff', 'ui@op.lo', 'male', '123456As@', 'Wed Dec 18 2019 00:00:00 GMT+0800 (中国标准时间)', 'fff', 'http://localhost:8080/img/137570d8-f045-460d-a2ec-96ff5e31f80f.jpg', '[]', 1, 0, 3, '""');
INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (24, 'Jack', '123@456.co', 'male', '123456As@', 'Wed Dec 18 2019 00:00:00 GMT+0800 (中国标准时间)', 'Keep ', 'http://localhost:8080/img/bf46408c-c861-478e-ac8e-e6b178400db2.jpg', '[]', 2, 4, 2, 'http://localhost:8080/img/39b4a1c3-0742-48dc-930d-02e45c8a030a.jpg');
INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (25, 'Marry', 'marry@qq.com', 'female', '123456As@', 'Tue Dec 31 2019 00:00:00 GMT+0800 (中国标准时间)', 'Never', 'http://localhost:8080/img/2ec88fc8-b6ea-4e3e-a2c7-28f017c67fa2.jpg', '["活动"]', 0, 0, 2, '');
INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (26, 'Honny', 'Honny@qq.co', 'female', '456789As@', 'Thu Dec 12 2019 00:00:00 GMT+0800 (中国标准时间)', 'testkzp', 'http://localhost:8080/img/a3439672-42be-48b2-8322-bef3b0d9e8bd.jpg', '["ddd", "pp", "ppp"]', 2, 4, 2, 'http://localhost:8080/img/b04dd1fa-36fb-4019-8971-fcf361181364.jpg');
INSERT INTO share_your_feelings.user (id, name, mailbox, sex, pass, birthday, signature, imageurl, tags, blogNum, guanNum, fansNum, backgroundUrl) VALUES (27, 'Root', 'root@root.com', 'female', '123456As@', 'Wed Dec 18 2019 00:00:00 GMT+0800 (中国标准时间)', 'ROOP', 'http://localhost:8080/img/15e7b0cf-959a-4c9a-987b-0a1a7110ffbb.jpg', '[]', 0, 4, 2, 'http://localhost:8080/img/0adbee56-51eb-4eec-836c-db6f2db4c2bc.jpg');