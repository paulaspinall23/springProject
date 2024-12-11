CREATE TABLE ARTIST
(
    id VARCHAR PRIMARY KEY,
    artist_Name VARCHAR NOT NULL UNIQUE,
    music_brainz_id VARCHAR
);

CREATE TABLE CD
(
    id     VARCHAR PRIMARY KEY,
    name   VARCHAR NOT NULL,
    artist_id VARCHAR,
    CONSTRAINT FK_ArtistCD FOREIGN KEY (artist_id)
    REFERENCES ARTIST(id)
);

INSERT INTO ARTIST (music_brainz_id, artist_Name, id)
VALUES ('614e3804-7d34-41ba-857f-811bad7c2b7a', 'Dire Straits', RANDOM_UUID()),
       ('0c502791-4ee9-4c5f-9696-0602b721ff3b', 'E.L.O', RANDOM_UUID()),
       ('bd13909f-1c29-4c27-a874-d4aaf27c5b1a', 'Fleetwood Mac', RANDOM_UUID()),
       ('83d91898-7763-47d7-b03b-b92132375c47', 'Pink Floyd', RANDOM_UUID()),
       ('b10bbbfc-cf9e-42e0-be17-e2c3e1d2600d', 'The Beatles', RANDOM_UUID());


INSERT INTO CD (id, name, artist_id)
VALUES ( RANDOM_UUID(), 'Brothers In Arms', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits')),
       ( RANDOM_UUID(), 'Money for Nothing', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits')),
       ( RANDOM_UUID(), 'The Very Best Of Electric Light Orchestra', (SELECT ID FROM ARTIST WHERE artist_Name = 'E.L.O')),
       ( RANDOM_UUID(), 'Rumours', (SELECT ID FROM ARTIST WHERE artist_Name = 'Fleetwood Mac')),
       ( RANDOM_UUID(), 'The Dark Side of the Moon', (SELECT ID FROM ARTIST WHERE artist_Name = 'Pink Floyd')),
       ( RANDOM_UUID(), '1', (SELECT ID FROM ARTIST WHERE artist_Name = 'The Beatles')),
       ( RANDOM_UUID(), 'Love Over Gold', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits'));






