CREATE TABLE ARTIST
(
    id VARCHAR PRIMARY KEY,
    artist_Name VARCHAR NOT NULL UNIQUE
);

CREATE TABLE CD
(
    id     VARCHAR PRIMARY KEY,
    name   VARCHAR NOT NULL,
    artist_id VARCHAR,
    CONSTRAINT FK_ArtistCD FOREIGN KEY (artist_id)
    REFERENCES ARTIST(id)
);

INSERT INTO ARTIST (id, artist_Name)
VALUES (RANDOM_UUID(), 'Dire Straits'),
       (RANDOM_UUID(), 'E.L.O'),
       (RANDOM_UUID(), 'Fleetwood Mac'),
       (RANDOM_UUID(), 'Pink Floyd'),
       (RANDOM_UUID(), 'The Beatles');


INSERT INTO CD (id, name, artist_id)
VALUES ( RANDOM_UUID(), 'Brothers In Arms', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits')),
       ( RANDOM_UUID(), 'Money for Nothing', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits')),
       ( RANDOM_UUID(), 'The Very Best Of Electric Light Orchestra', (SELECT ID FROM ARTIST WHERE artist_Name = 'E.L.O')),
       ( RANDOM_UUID(), 'Rumours', (SELECT ID FROM ARTIST WHERE artist_Name = 'Fleetwood Mac')),
       ( RANDOM_UUID(), 'The Dark Side of the Moon', (SELECT ID FROM ARTIST WHERE artist_Name = 'Pink Floyd')),
       ( RANDOM_UUID(), '1', (SELECT ID FROM ARTIST WHERE artist_Name = 'The Beatles')),
       ( RANDOM_UUID(), 'Love Over Gold', (SELECT ID FROM ARTIST WHERE artist_Name = 'Dire Straits'));






