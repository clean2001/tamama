-- 사용자 생성
CREATE USER 'welcome'@'localhost' IDENTIFIED BY 'pw1234';

-- 모든 데이터베이스에 대해 모든 권한 부여 (원한다면 제한 가능)
GRANT ALL PRIVILEGES ON *.* TO 'welcome'@'localhost' WITH GRANT OPTION;

-- 권한 적용
FLUSH PRIVILEGES;


-- 스키마 생성
create database tamama;