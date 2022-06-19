create TABLE IF NOT EXISTS water_bets_users (
  user_id bigint auto_increment,
  user_email varchar(255) NOT NULL,
  user_full_name varchar(132) NOT NULL
);

create TABLE IF NOT EXISTS water_bets (
  water_bet_id bigint auto_increment,
  group_id Int,
  offerers_users_id Int,
  receivers_users_id Int,
  bet varchar(255),
  offerers_droplets_on_the_line Int,
  recipient_droplets_on_the_line Int,
  acceptance_status varchar(32),
  bet_status varchar(32),
  offered_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  accept_by_expiration_date_time TIMESTAMP,
  offerers_pick varchar(32) NULL,
  receivers_pick varchar(32) NULL,
  decided_winner varchar(32) NULL,
  closed_date_time TIMESTAMP NULL
);

create TABLE IF NOT EXISTS groups (
  group_id bigint auto_increment,
  group_name varchar(64) NOT NULL,
  password_to_join varchar(32) NULL,
  max_droplet_bet int
);


insert into water_bets_users (
    user_email,
    user_full_name
) values
(
    'bradenborman00@gmail.com',
    'Braden Borman'
);

insert into groups (
    group_name,
    password_to_join
) values
(
    'Not Arizona State',
    'ross'
);

insert into water_bets (
    group_id,
    offerers_users_id,
    receivers_users_id,
    bet,
    offerers_droplets_on_the_line,
    recipient_droplets_on_the_line,
    acceptance_status,
    bet_status,
    offered_date_time,
    accept_by_expiration_date_time,
    offerers_pick,
    receivers_pick,
    decided_winner,
    closed_date_time
) values
(
    1,
    12,
    1,
    'Josh will outscore Meyer in fantasy this week',
    5,
    5,
    'ACCEPTED',
    'CLOSED',
    '2022-06-10 15:36:38',
    '2022-06-12 15:36:38',
    'RECIPIENT',
    'RECIPIENT',
    'RECIPIENT',
    '2022-06-14 13:00:00'
),
(
    1,
    1,
    12,
    'Kenny Pickett will start week 6 or earlier',
    50,
    50,
    'DECLINED',
    'CLOSED',
    '2022-05-25 15:36:38',
    '2022-05-28 15:36:38',
    null,
    null,
    null,
    '2022-06-01 13:00:00'
),(
    1,
    1,
    22,
    'Texans will not win more than 4.5 games this year',
    150,
    20,
    'NOT_ACKNOWLEDGED',
    'OPEN',
    '2011-05-16 15:36:38',
    '2011-05-16 15:36:38',
    null,
    null,
    null,
    null
),(
    1,
    2,
    1,
    'Pujols will hit a homerun this weekend',
    10,
    10,
    'ACCEPTED',
    'OPEN',
    '2011-05-16 15:36:38',
    '2011-05-16 15:36:38',
    null,
    null,
    null,
    null
);
