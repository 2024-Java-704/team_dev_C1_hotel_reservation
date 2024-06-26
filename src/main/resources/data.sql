--会員テーブル
INSERT INTO users (name, birthday, zip_code, address, tel, email, password, registration) VALUES ('田中太郎', '2000-04-02', '1638001', '東京都新宿区西新宿2-8-1 ','0353211111', 'tanaka@aaa.com', 'testtanaka', '2024-06-05');
INSERT INTO users (name, birthday, zip_code, address, tel, email, password, registration) VALUES ('鈴木一郎', '2001-06-20', '2318588', '神奈川県横浜市中区日本大通1 ','08098765432', 'suzuki@aaa.com', 'testsuzuki', '2024-06-06');

--宿テーブル
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (1,'東急ステイ渋沢（道玄坂上）', '1500045', '東京都渋谷区神泉町８－１４', '0334771091', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'やすら樹の宿 ねねんぼう', '1500045', '東京都西多摩郡奥多摩町日原８４８－１', '0487680122', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'こやま旅館', '3490111', '埼玉県蓮田市東１－１－１８', '0428858755', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (2,'東京ディズニーシー・ホテルミラコスタ', '2798519', '千葉県浦安市舞浜１－１３', '0473052222', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'満点の星', '2500405', '神奈川県足柄下郡箱根町大平台３８６', '08096516406', 2);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'ホテルサンシャイン宇都宮', '3210953', '栃木県宇都宮市東宿郷２－３－３', '0286330123', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'民宿休み石', '3780113', '群馬県利根郡川場村生品２５１５－１', '0278522350', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'民宿とみもと館', '3780408', '群馬県利根郡片品村花咲１４６２', '0278583274', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'ホテルルートインGrand秩父', '3680023', '埼玉県秩父市大宮４６２８－２', '05052115831', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'民宿ぬまた', '2992216', '千葉県南房総市久枝４９６', '0470572158', 3);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'ホテルマイステイズ横浜', '2310055', '神奈川県横浜市中区末吉町４－８１', '0452521311', 2);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'パイオランドホテル', '3300802', '埼玉県さいたま市大宮区宮町１丁目３５番２', '0486480010', 4);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (3,'東京ビジネスホテル', '1600022', '東京都新宿区新宿６－３－２', '0333564605', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'民宿 しんこう苑', '3212345', '栃木県日光市木和田島２１１２－７', '0288260817', 7);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (5,'レイクサイド日光', '3211661', '栃木県日光市中宮祠官有無番地', '05036124456', 7);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'伊香保温泉 雨情の湯　森秋旅館', '3770102', '群馬県渋川市伊香保町伊香保６０', '0279722601', 6);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (1,'北茨城ロハス 磯原シーサイドホテル', '3191541', '茨城県北茨城市磯原町磯原二ツ島２５５０', '0293420213', 5);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'割烹旅館 湯の花壮', '3292921', '栃木県那須塩原市塩原３２３', '0287322824', 7);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (4,'月居温泉滝見の湯白木壮', '3193512', '茨城県久慈郡大子町小生瀬２８７９－４', '0295760373', 5);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (1,'ホテルベルクラシック東京', '1700005', '東京都豊島区南大塚３－３３－６', '0359501200', 1);
INSERT INTO inns (category_id, name, zip_code, address, tel, prefecture_id) VALUES  (6,'グルメと天然温泉の宿 ペンションSHIOSAI', '2590201', '神奈川県足柄下郡真鶴町真鶴１０４６', '0465683211', 2);

--宿プランテーブル
INSERT INTO plans(inn_id,name,price) VALUES (1,'【素泊まり】',28800);
INSERT INTO plans(inn_id,name,price) VALUES (1,'【朝食付】',31800);
INSERT INTO plans(inn_id,name,price) VALUES (2,'【素泊まり】',11550);
INSERT INTO plans(inn_id,name,price) VALUES (2,'【朝食付】',13550);
INSERT INTO plans(inn_id,name,price) VALUES (3,'【素泊まり】',3900);
INSERT INTO plans(inn_id,name,price) VALUES (3,'【朝食付】',4900);
INSERT INTO plans(inn_id,name,price) VALUES (4,'【素泊まり】',352000);
INSERT INTO plans(inn_id,name,price) VALUES (4,'【朝食付】',382000);
INSERT INTO plans(inn_id,name,price) VALUES (5,'【素泊まり】',9600);
INSERT INTO plans(inn_id,name,price) VALUES (5,'【朝食付】',11600);
INSERT INTO plans(inn_id,name,price) VALUES (6,'【素泊まり】',8900);
INSERT INTO plans(inn_id,name,price) VALUES (6,'【朝食付】',12900);
INSERT INTO plans(inn_id,name,price) VALUES (7,'【素泊まり】',14600);
INSERT INTO plans(inn_id,name,price) VALUES (7,'【朝食付】',17600);
INSERT INTO plans(inn_id,name,price) VALUES (8,'【素泊まり】',5600);
INSERT INTO plans(inn_id,name,price) VALUES (8,'【朝食付】',7600);
INSERT INTO plans(inn_id,name,price) VALUES (9,'【素泊まり】',15200);
INSERT INTO plans(inn_id,name,price) VALUES (9,'【朝食付】',17200);
INSERT INTO plans(inn_id,name,price) VALUES(10,'【素泊まり】',8000);
INSERT INTO plans(inn_id,name,price) VALUES(10,'【朝食付】',10000);
INSERT INTO plans(inn_id,name,price) VALUES (11,'【素泊まり】',15480);
INSERT INTO plans(inn_id,name,price) VALUES (11,'【朝食付】',17480);
INSERT INTO plans(inn_id,name,price) VALUES (12,'【素泊まり】',6400);
INSERT INTO plans(inn_id,name,price) VALUES (12,'【朝食付】',8400);
INSERT INTO plans(inn_id,name,price) VALUES (13,'【素泊まり】',7900);
INSERT INTO plans(inn_id,name,price) VALUES (13,'【朝食付】',9900);
INSERT INTO plans(inn_id,name,price) VALUES (14,'【朝食付】',6250);
INSERT INTO plans(inn_id,name,price) VALUES (15,'【素泊まり】',9000);
INSERT INTO plans(inn_id,name,price) VALUES (15,'【朝食付】',11000);
INSERT INTO plans(inn_id,name,price) VALUES (16,'【素泊まり】',16800);
INSERT INTO plans(inn_id,name,price) VALUES (16,'【朝食付】',19800);
INSERT INTO plans(inn_id,name,price) VALUES (17,'【素泊まり】',17000);
INSERT INTO plans(inn_id,name,price) VALUES (17,'【朝食付】',19000);
INSERT INTO plans(inn_id,name,price) VALUES (18,'【素泊まり】',8000);
INSERT INTO plans(inn_id,name,price) VALUES (18,'【朝食付】',10000);
INSERT INTO plans(inn_id,name,price) VALUES (19,'【素泊まり】',99000);
INSERT INTO plans(inn_id,name,price) VALUES (19,'【朝食付】',101000);
INSERT INTO plans(inn_id,name,price) VALUES (20,'【素泊まり】',20300);
INSERT INTO plans(inn_id,name,price) VALUES (20,'【朝食付】',23300);
INSERT INTO plans(inn_id,name,price) VALUES (21,'【素泊まり】',21960);
INSERT INTO plans(inn_id,name,price) VALUES (21,'【朝食付】',24960);

--空室状況テーブル
INSERT INTO availabiliteis(inn_id, num) VALUES (1, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (2, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (3, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (4, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (5, 2);
INSERT INTO availabiliteis(inn_id, num) VALUES (6, 2);
INSERT INTO availabiliteis(inn_id, num) VALUES (7, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (8, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (9, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (10, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (11, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (12, 1);
INSERT INTO availabiliteis(inn_id, num) VALUES (13, 2);
INSERT INTO availabiliteis(inn_id, num) VALUES (14, 0);
INSERT INTO availabiliteis(inn_id, num) VALUES (15, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (16, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (17, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (18, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (19, 2);
INSERT INTO availabiliteis(inn_id, num) VALUES (20, 0);
INSERT INTO availabiliteis(inn_id, num) VALUES (21, 1);
INSERT INTO availabiliteis(inn_id, num) VALUES (22, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (23, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (24, 1);
INSERT INTO availabiliteis(inn_id, num) VALUES (25, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (26, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (27, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (28, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (29, 1);
INSERT INTO availabiliteis(inn_id, num) VALUES (30, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (31, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (32, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (33, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (34, 2);
INSERT INTO availabiliteis(inn_id, num) VALUES (35, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (36, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (37, 5);
INSERT INTO availabiliteis(inn_id, num) VALUES (38, 0);
INSERT INTO availabiliteis(inn_id, num) VALUES (39, 0);
INSERT INTO availabiliteis(inn_id, num) VALUES (40, 3);
INSERT INTO availabiliteis(inn_id, num) VALUES (41, 4);
INSERT INTO availabiliteis(inn_id, num) VALUES (42, 4);

--都県テーブル
INSERT INTO prefectures(name) VALUES ('東京都');
INSERT INTO prefectures(name) VALUES ('神奈川県');
INSERT INTO prefectures(name) VALUES ('千葉県');
INSERT INTO prefectures(name) VALUES ('埼玉県');
INSERT INTO prefectures(name) VALUES ('茨城県');
INSERT INTO prefectures(name) VALUES ('群馬県');
INSERT INTO prefectures(name) VALUES ('栃木県');

--種別テーブル
INSERT INTO categories(name) VALUES ('シティホテル');
INSERT INTO categories(name) VALUES ('リゾートホテル');
INSERT INTO categories(name) VALUES ('ビジネスホテル');
INSERT INTO categories(name) VALUES ('旅館');
INSERT INTO categories(name) VALUES ('民宿');
INSERT INTO categories(name) VALUES ('ペンション');

--管理者テーブル
INSERT INTO administratores(name, password) VALUES ('admin', 'himitu');

--支払方法テーブル
INSERT INTO payment(name) VALUES ('現金');
INSERT INTO payment(name) VALUES ('クレジットカード');

--口コミテーブル
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('良かった！', 4, 1);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('枕が気持ちいい', 4, 1);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('雨漏りしてた', 2, 2);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('ごはんがおいしかった', 3, 2);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('ベッドがふかふかだった', 5, 4);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('温泉が気持ちよかった', 4, 3);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('パークから近くて便利', 3, 4);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('虫が多い', 2, 3);
INSERT INTO reviews(content, rank_id, inn_id) VALUES ('近くにコンビニが無くて不便だった', 2, 4);

--写真テーブル
INSERT INTO photos(inn_id,photo_url) VALUES (1,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y329696/Y329696560.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (1,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y329696/Y329696518.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (1,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y329696/Y329696514.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (2,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y320728/Y320728046.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (2,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y320728/Y320728031.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (2,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y320728/Y320728053.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (3,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y352029/Y352029001.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (3,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y352029/Y352029007.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (3,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y352029/Y352029002.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (4,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y370886/Y370886012.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (4,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y370886/Y370886117.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (4,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y370886/Y370886030.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (5,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y376340/Y376340008.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (5,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y376340/Y376340005.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (5,'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEju7U8esONERDN_s7GbaKtQbHoaZ9ogxlzbcSf9I8_JbyCrXUM9BvvFFg-1LwbMZHM2x-5pBYWxlhTSqPa_9eLwZeWY2ZzHhVg_iQqb0PRsSxP-WxElIjlm1BT1jy0fCRtHAckDbyCjdd-u/s1600/no_image_logo.png');
INSERT INTO photos(inn_id,photo_url) VALUES (6,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y373893/Y373893009.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (6,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y373893/Y373893010.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (6,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y373893/Y373893013.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (7,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y353066/Y353066055.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (7,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y353066/Y353066011.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (7,'https://cdn.jalan.jp/jalan/images/pict4L/Y6/Y353066/Y353066032.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (8,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y323420/Y323420040.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (8,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y323420/Y323420099.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (8,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y323420/Y323420087.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (9,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y376075/Y376075054.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (9,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y376075/Y376075046.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (9,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y376075/Y376075036.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (10,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y390838/Y390838022.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (10,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y390838/Y390838004.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (10,'https://cdn.jalan.jp/jalan/images/pict4L/Y8/Y390838/Y390838013.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (11,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y375000/Y375000298.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (11,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y375000/Y375000292.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (11,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y375000/Y375000347.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (12,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y370784/Y370784001.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (12,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y370784/Y370784008.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (12,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y370784/Y370784005.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (13,'https://cdn.jalan.jp/jalan/images/pict4L/Y2/Y321582/Y321582191.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (13,'https://cdn.jalan.jp/jalan/images/pict4L/Y2/Y321582/Y321582017.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (13,'https://cdn.jalan.jp/jalan/images/pict4L/Y2/Y321582/Y321582015.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (14,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y310689/Y310689087.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (14,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y310689/Y310689083.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (14,'https://cdn.jalan.jp/jalan/images/pict4L/Y9/Y310689/Y310689075.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (15,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y324205/Y324205027.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (15,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y324205/Y324205522.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (15,'https://cdn.jalan.jp/jalan/images/pict4L/Y5/Y324205/Y324205528.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (16,'https://cdn.jalan.jp/jalan/images/pict4L/Y7/Y310507/Y310507843.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (16,'https://cdn.jalan.jp/jalan/images/pict4L/Y7/Y310507/Y310507840.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (16,'https://cdn.jalan.jp/jalan/images/pict4L/Y7/Y310507/Y310507642.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (17,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y302051/Y302051Ad5.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (17,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y302051/Y302051As8.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (17,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y302051/Y302051Ag1.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (18,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y377764/Y377764043.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (18,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y377764/Y377764006.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (18,'https://cdn.jalan.jp/jalan/images/pict4L/Y4/Y377764/Y377764018.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (19,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y399850/Y399850667.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (19,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y399850/Y399850767.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (19,'https://cdn.jalan.jp/jalan/images/pict4L/Y0/Y399850/Y399850528.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (20,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y314433/Y314433AK3.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (20,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y314433/Y314433A93.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (20,'https://cdn.jalan.jp/jalan/images/pict4L/Y3/Y314433/Y314433A00.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (21,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y319181/Y319181340.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (21,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y319181/Y319181288.jpg');
INSERT INTO photos(inn_id,photo_url) VALUES (21,'https://cdn.jalan.jp/jalan/images/pict4L/Y1/Y319181/Y319181278.jpg');

--温泉テーブル
INSERT INTO hot_springs(inn_id) VALUES (16);
INSERT INTO hot_springs(inn_id) VALUES (17);
INSERT INTO hot_springs(inn_id) VALUES (18);
INSERT INTO hot_springs(inn_id) VALUES (19);
INSERT INTO hot_springs(inn_id) VALUES (21);

--ハイクラステーブル
INSERT INTO high_classes(inn_id) VALUES (4);
INSERT INTO high_classes(inn_id) VALUES (16);
INSERT INTO high_classes(inn_id) VALUES (19);
INSERT INTO high_classes(inn_id) VALUES (20);
INSERT INTO high_classes(inn_id) VALUES (21);

--最寄りテーブル
INSERT INTO walks(inn_id) VALUES (4);
INSERT INTO walks(inn_id) VALUES (9);
INSERT INTO walks(inn_id) VALUES (12);
INSERT INTO walks(inn_id) VALUES (16);
INSERT INTO walks(inn_id) VALUES (20);