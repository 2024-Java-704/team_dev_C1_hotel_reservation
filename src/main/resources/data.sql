--会員テーブル
INSERT INTO users (name, birthday, zip_code, address, tel, email, password, registration) VALUES ('田中太郎', '2000-04-02', '1638001', '東京都新宿区西新宿2-8-1 ','0353211111', 'tanaka@aaa.com', 'testtanaka', '2024-06-05');
INSERT INTO users (name, birthday, zip_code, address, tel, email, password, registration) VALUES ('鈴木一郎', '2001-06-20', '2318588', '神奈川県横浜市中区日本大通1 ','08098765432', 'suzuki@aaa.com', 'testsuzuki', '2024-06-06');

--宿テーブル
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (0,'東急ステイ渋沢（道玄坂上）', '1500045', '東京都西多摩郡奥多摩町日原８４８－１', '0334771091', 0);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'やすら樹の宿 ねねんぼう', '1500045', '東京都西多摩郡奥多摩町日原８４８－１', '0487680122', 0);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'こやま旅館', '3490111', '埼玉県蓮田市東１－１－１８', '0428858755', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (1,'東京ディズニーシー・ホテルミラコスタ', '2798519', '千葉県浦安市舞浜１－１３', '0473052222', 2);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'満点の星', '2500405', '神奈川県足柄下郡箱根町大平台３８６', '08096516406', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'ホテルサンシャイン宇都宮', '3210953', '栃木県宇都宮市東宿郷２－３－３', '0286330123', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'民宿休み石', '3780113', '群馬県利根郡川場村生品２５１５－１', '0278522350', 5);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'民宿とみもと館', '3780408', '群馬県利根郡片品村花咲１４６２', '0278583274', 5);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'ホテルルートインGrand秩父', '3680023', '埼玉県秩父市大宮４６２８－２', '05052115831', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'民宿ぬまた', '2992216', '千葉県南房総市久枝４９６', '0470572158', 2);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'ホテルマイステイズ横浜', '2310055', '神奈川県横浜市中区末吉町４－８１', '0452521311', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'パイオランドホテル', '3300802', '埼玉県さいたま市大宮区宮町１丁目３５番２', '0486480010', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'東京ビジネスホテル', '1600022', '東京都新宿区新宿6-3-2', '0333564605', 0);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'民宿 しんこう苑', '3212345', '栃木県日光市木和田島２１１２－７', '0288260817', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'レイクサイド日光', '3211661', '栃木県日光市中宮祠官有無番地', '05036124456', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'伊香保温泉 雨情の湯　森秋旅館', '3770102', '群馬県渋川市伊香保町伊香保６０', '0279722601', 5);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (0,'北茨城ロハス 磯原シーサイドホテル', '3191541', '茨城県北茨城市磯原町磯原二ツ島２５５０', '0293420213', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'割烹旅館 湯の花壮', '3292921', '栃木県那須塩原市塩原323', '0287322824', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'月居温泉滝見の湯白木壮', '3193512', '茨城県久慈郡大子町小生瀬２８７９－４', '0295760373', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (0,'ホテルベルクラシック東京', '1700005', '東京都豊島区南大塚３－３３－６', '0359501200', 0);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (6,'グルメと天然温泉の宿 ペンションSHIOSAI', '2590201', '神奈川県足柄下郡真鶴町真鶴１０４６', '0465683211', 1);

--宿プランテーブル
INSERT INTO plans(inn_id,name,price) VALUES (1,'【朝食付】',31800);
INSERT INTO plans(inn_id,name,price) VALUES (2,'【素泊まり】',11550);
INSERT INTO plans(inn_id,name,price) VALUES (3,'【朝食付】',4900);
INSERT INTO plans(inn_id,name,price) VALUES (4,'【素泊まり】',352000);
INSERT INTO plans(inn_id,name,price) VALUES (6,'【朝食付】ゆっくりステイ♪レイトアウト（12時チェックアウト）プラン',12900);
INSERT INTO plans(inn_id,name,price) VALUES (6,'【素泊まり】連泊プラン',8900);
INSERT INTO plans(inn_id,name,price) VALUES (5,'【朝食付】',11600);
INSERT INTO plans(inn_id,name,price) VALUES (7,'【素泊まり】',14600);
INSERT INTO plans(inn_id,name,price) VALUES (8,'【朝食付】',7600);
INSERT INTO plans(inn_id,name,price) VALUES (9,'【素泊まり】',15200);
INSERT INTO plans(inn_id,name,price) VALUES(10,'【朝食付】',10000);
INSERT INTO plans(inn_id,name,price) VALUES (11,'【素泊まり】',15480);
INSERT INTO plans(inn_id,name,price) VALUES (12,'【朝食付】',8400);
INSERT INTO plans(inn_id,name,price) VALUES (13,'【素泊まり】',7900);
INSERT INTO plans(inn_id,name,price) VALUES (14,'【朝食付】',6250);
INSERT INTO plans(inn_id,name,price) VALUES (15,'【素泊まり】',9000);
INSERT INTO plans(inn_id,name,price) VALUES (16,'【朝食付】',19800);
INSERT INTO plans(inn_id,name,price) VALUES (17,'【素泊まり】',17000);
INSERT INTO plans(inn_id,name,price) VALUES (18,'【朝食付】',10000);
INSERT INTO plans(inn_id,name,price) VALUES (19,'【素泊まり】','99000');
INSERT INTO plans(inn_id,name,price) VALUES (20,'【朝食付】',23300);
INSERT INTO plans(inn_id,name,price) VALUES (21,'【素泊まり】',21960);

--管理者テーブル
INSERT INTO administratores(name, password) VALUES ('admin', 'himitu');

--支払方法テーブル
INSERT INTO payment(name) VALUES ('現金');
INSERT INTO payment(name) VALUES ('クレジットカード');