drop table if exists players;

create table players(
	-- id:主キー
	id serial primary key,
	-- 所属球団
	team varchar(100) not null,
	-- 選手名
	name varchar(100) not null,
	-- 背番号
	number integer,
	-- 投/打
	tandb varchar(10) not null,
	-- メイン守備位置
	position varchar(50) not null,
	-- サブ守備位置
	subposition varchar(50),
	-- 説明、打率など
	detail text
);

