--基本データ
insert into leagues (name) values ('セ・リーグ'), ('パ・リーグ');
insert into teams (name, league_id) values ('読売ジャイアンツ', 1),('阪神タイガース',1),('横浜DeNAベイスターズ',1),
('広島東洋カープ',1),('東京ヤクルトスワローズ',1),('中日ドラゴンズ',1),('福岡ソフトバンクホークス',2),('日本ハムファイターズ',2),
('千葉ロッテマリーンズ',2),('東北楽天ゴールデンイーグルス',2),('オリックス・バファローズ',2),('埼玉西武ライオンズ',2);
insert into positions (name) values ('投手'), ('捕手'), ('一塁手'),('二塁手'),('三塁手'),('遊撃手'),('左翼手'),('中堅手'),('右翼手');

--1件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(1,'甲斐　拓也',10,'右投げ/右打ち',2,'ホークスからFAでジャイアンツに移籍。セ・リーグで甲斐キャノンを見られるか。');

--2件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(2,'伊藤　将司',27,'左投げ/左打ち',1,'昨年先発から中継ぎに転向。新変化球を携え準備は万端か。');

--3件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(3,'牧　秀悟',2,'右投げ/右打ち',4,'一発だけでなく、安定したミート力もある日本球界を代表する選手の一人。ムードーメーカーでチームをけん引する。');

--4件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(4,'矢野　雅哉',4,'右投げ/左打ち',6,'広い守備範囲に正確性の高い強肩を活かし昨年度ゴールデングラブ賞を受賞。トレードマークはパンチパーマ。');

--5件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(5,'村上　宗隆',55,'右投げ/左打ち',5,'令和の三冠王。昨年は本塁打王と打点王の二冠。今年は渡米も見据えた活躍を期待したい。');
--サブポジ
insert into subpositions (player_id, position_id)
select p.id, pos.id
from players p, positions pos
where p.name = '村上　宗隆'
  and p.number = 55
  and pos.id = 3;
--6件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(6,'細川　成也',55,'右投げ/右打ち',9,'昨年ベストナインにも選ばれた現役ドラフトの星。今年は打撃タイトルも狙えるか。');
--サブポジ
insert into subpositions (player_id, position_id)
select p.id, pos.id
from players p, positions pos
where p.name = '細川　成也'
  and p.number = 55
  and pos.id = 7;


--7件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(7,'周東　佑京',23,'右投げ/左打ち',8,'走塁のスペシャリスト。昨年は走塁だけでなく守備や打撃でも活躍の場が増え、盗塁王、ベストナイン、ゴールデングラブ賞を受賞した。');

--8件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(8,'万波　中正',66,'右投げ/右打ち',9,'昨年は20本に届かなかったが18本塁打を打ちパンチ力は顕在。11補殺を記録した強肩は抑止力にもなり、2年連続のゴールデングラブ賞も受賞。');
--9件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(9,'ネフタリ　ソト',99,'右投げ/右打ち',3,'21本塁打88打点をマークする強打者助っ人。独特な応援歌は選手の実績もあいまって敵チームを威圧する。');
--10件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(10,'宗山　塁',1,'右投げ/右打ち',6,'大学生ながら侍ジャパンシリーズのメンバーに選出された期待の即戦力ルーキー。ケガさえしなければ新人王筆頭候補か。');
--11件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(11,'宮城　大弥',18,'左投げ/左打ち',1,'2年連続開幕投手を務めるオリックスのエース。ゆったりしたフォームと緩急を使い分けるピッチングで打者を翻弄する。');
--12件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(12,'古賀　悠斗',22,'右投げ/右打ち',2,'強肩とスローイングに定評のある捕手。後は打撃でもチームに貢献できれば。');
--13件目
insert into players(team_id, name, number,tandb,position_id,detail)
values
(2,'村上　頌樹',41,'右投げ/左打ち',1,'完投も任せられるスタミナを持ち、抜群のコントロールと得意の真ッスラで今年も多くの打者を打ち取るだろう。');
--14
insert into players(team_id, name, number,tandb,position_id,detail)
values
(8,'上川畑　大悟',4,'右投げ/右打ち',4,'ミスの少ない安定した守備と小技でチームに貢献。今年は打撃でも貢献したいところ。');