create table geohash
(
    id        int auto_increment
        primary key,
    userID    int  null,
    geoString text null,
    constraint geohash_user_id_fk
        foreign key (userID) references user (id)
);

INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (2, 22, 'wtw3x2');
INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (3, 27, 'wtw3x2');
INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (4, 26, 'wtw3x2');
INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (5, 25, 'wtw3x2');
INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (6, 23, 'wtw3x2');
INSERT INTO share_your_feelings.geohash (id, userID, geoString) VALUES (7, 24, 'wtw3x2');