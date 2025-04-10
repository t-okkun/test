drop table if exists players cascade;
drop table if exists teams;
drop table if exists positions cascade;
drop table if exists leagues;
drop table if exists subpositions;

--リーグテーブル
create table leagues(
	id serial primary key,
	name varchar(20) not null unique
);

-- 球団テーブル
create table teams(
	id serial primary key,
	name varchar(50) not null unique,
	league_id integer not null references leagues(id)
);

--守備位置テーブル
create table positions(
	id serial primary key,
	name varchar(5) not null unique
);

create table players(
	-- id:主キー
	id serial primary key,
	-- 所属球団
	team_id integer not null references teams(id),
	-- 選手名
	name varchar(100) not null,
	-- 背番号
	number integer,
	-- 投/打
	tandb varchar(10) not null,
	-- メイン守備位置
	position_id integer not null references positions(id),
	-- 説明、打率など
	detail text
);

-- サブ守備位置（多対多対応）
create table subpositions (
	player_id integer not null references players(id) on delete cascade,
	position_id integer not null references positions(id),
	primary key (player_id, position_id)
);