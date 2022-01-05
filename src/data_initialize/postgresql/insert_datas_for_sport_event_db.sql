drop table event_info;
drop table event_day;
drop table place;
drop table event_participants;
drop table team;
drop table team_member;

create table event_info
(
  event_id int PRIMARY KEY,
  name varchar(128),
  url varchar(128)
);

create table event_day
(
  event_id int,
  event_date_time timestamp,
  place_id int
);

create table place
(
  place_id int PRIMARY KEY,
  name varchar(128),
  longitude float,
  latitude float
);

create table event_participants
(
  event_id integer PRIMARY KEY,
  team_id int NOT NULL
);

create table team
(
  team_id int NOT NULL PRIMARY KEY,
  name varchar(128)
);

create table team_member
(
  team varchar(128) NOT NULL,
  member varchar(32)
);

insert into event_info (event_id, name, url) values (1,'B.LEAGUE 2021-2022', 'https://nagoya-dolphins.jp/lp/game_20220122_20220123/');
insert into event_info (event_id, name, url) values (2,'春の高校バレー', 'https://www.haruko-volley.com');
insert into event_info (event_id, name, url) values (3,'第40回全国都道府県対抗女子駅伝競走大会', 'https://www.jaaf.or.jp/competition/detail/1593/');

insert into event_day (event_id, event_date_time, place_id) values (1, '2022-1-8 15:05:00', 1);
insert into event_day (event_id, event_date_time, place_id) values (2, '2022-1-5 9:00:00', 2);
insert into event_day (event_id, event_date_time, place_id) values (2, '2022-1-6 9:00:00', 2);
insert into event_day (event_id, event_date_time, place_id) values (2, '2022-1-7 9:00:00', 2);
insert into event_day (event_id, event_date_time, place_id) values (2, '2022-1-8 9:00:00', 2);
insert into event_day (event_id, event_date_time, place_id) values (2, '2022-1-9 9:00:00', 2);
insert into event_day (event_id, event_date_time, place_id) values (3, '2022-1-16 12:30:00', 3);

insert into place (place_id, name, longitude, latitude) values (1, 'ドルフィンアリーナ', 35.18323, 136.90268);
insert into place (place_id, name, longitude, latitude) values (2, '東京体育館', 35.67989, 139.71241);
insert into place (place_id, name, longitude, latitude) values (3, 'たけびしスタジアム京都', 34.99366, 135.71395);
