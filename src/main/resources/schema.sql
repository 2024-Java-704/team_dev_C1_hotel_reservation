-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS inns;
DROP TABLE IF EXISTS plans;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS photos;

--会員テーブル
CREATE TABLE users 
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL,
   address VARCHAR (200) NOT NULL,
   tel VARCHAR (11) NOT NULL,
   email VARCHAR (100) UNIQUE NOT NULL,
   zip_code VARCHAR (7) NOT NULL,
	password VARCHAR (32) NOT NULL
);

--宿テーブル
CREATE TABLE inns
(
   id SERIAL PRIMARY KEY  NOT NULL,
   category_id INTEGER NOT NULL,
   name VARCHAR (100) NOT NULL,
   address VARCHAR (200) NOT NULL,
   prefecture_id INTEGER NOT NULL
);

--宿プランテーブル
CREATE TABLE plans
(
   id SERIAL PRIMARY KEY NOT NULL,
   inn_id INTEGER NOT NULL,
   content VARCHAR (200) NOT NULL,
   price INTEGER NOT NULL,
   room_num INTEGER NOT NULL
);

--予約テーブル
CREATE TABLE books
(
   id SERIAL PRIMARY KEY NOT NULL,
   payment_id INTEGER NOT NULL,
   user_id INTEGER NOT NULL,
   plan_id INTEGER NOT NULL,
   booking_date DATE NOT NULL,
   in_date DATE NOT NULL,
   out_date DATE NOT NULL
);

--写真テーブル
CREATE TABLE photos
(
   id SERIAL PRIMARY KEY NOT NULL,
   inn_id INTEGER NOT NULL,
   photo_url TEXT NOT NULL
);

--口コミテーブル
CREATE TABLE reviews
(
   id SERIAL PRIMARY KEY NOT NULL,
   content TEXT,
   rank_id INTEGER NOT NULL,
   inn_id INTEGER NOT NULL
);