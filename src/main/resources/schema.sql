-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS inns;
DROP TABLE IF EXISTS plans;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS prefectures;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS availabiliteis;
DROP TABLE IF EXISTS histories;
DROP TABLE IF EXISTS administratores;
DROP TABLE IF EXISTS payment;

--会員テーブル
CREATE TABLE users 
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL,
   birthday DATE NOT NULL,
   address VARCHAR (200) NOT NULL,
   tel VARCHAR (11) NOT NULL,
   email VARCHAR (100) UNIQUE NOT NULL,
   zip_code VARCHAR (7) NOT NULL,
   password VARCHAR (32) NOT NULL,
   registration DATE NOT NULL
);

--宿テーブル
CREATE TABLE inns
(
   id SERIAL PRIMARY KEY  NOT NULL,
   category_id INTEGER NOT NULL,
   name VARCHAR (100) NOT NULL,
   zip_code VARCHAR (7) NOT NULL,
   address VARCHAR (200) NOT NULL,
   prefecture_id INTEGER NOT NULL,
   tel VARCHAR (11) NOT NULL
);

--都県ID
CREATE TABLE prefectures
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL
);

--種別ID
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL
);

--空室状況ID
CREATE TABLE availabiliteis
(
   id SERIAL PRIMARY KEY NOT NULL,
   inn_id INTEGER NOT NULL,
   num INTEGER NOT NULL
);

--プランテーブル
CREATE TABLE plans
(
   id SERIAL PRIMARY KEY NOT NULL,
   inn_id INTEGER NOT NULL,
   name VARCHAR (200) NOT NULL,
   price INTEGER NOT NULL,
   availability_id INTEGER NOT NULL
);

--予約テーブル
CREATE TABLE books
(
   id SERIAL PRIMARY KEY NOT NULL,
   payment_id INTEGER NOT NULL,
   user_id INTEGER NOT NULL,
   inn_id INTEGER NOT NULL,
   plan_id INTEGER NOT NULL,
   adult_num INTEGER NOT NULL,
   child_num INTEGER NOT NULL,
   booking_date DATE NOT NULL,
   in_date DATE NOT NULL,
   out_date DATE NOT NULL
);

--履歴テーブル
CREATE TABLE histories
(
   id SERIAL PRIMARY KEY NOT NULL,
   user_id INTEGER NOT NULL,
   inn_id INTEGER NOT NULL
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

--管理者テーブル
CREATE TABLE administratores
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL,
   password VARCHAR (32) NOT NULL
);

--支払方法テーブル
CREATE TABLE payment
(
   id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR (20) NOT NULL
);