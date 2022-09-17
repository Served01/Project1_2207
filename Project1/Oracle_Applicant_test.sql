create table Applicant(   --table 한번만 생성

    DB_number number(8), --number = int (8자리) PK
    DB_name varchar2(12) not null, --varchar2 = 이름
    DB_gender char(1) not null, -- 성별
    DB_academy varchar2(8) not null, -- 학력
    DB_address varchar2(8) not null, -- 주소
    DB_career number(1) not null, -- 경력 점수
    DB_license number(1) not null, -- 자격증 점수
    DB_assay number(2) not null, -- 자기소개서 점수
    DB_attitude number(2) null, -- 태도 점수
    DB_special number(2) null, -- 전문지식 점수
    DB_solve number(2) null, -- 문제해결능력 점수
    
constraint DB_number primary key(DB_number)   --식별자 identifier -> unique 중복 데이터 미허용
);

insert into Applicant values(22070001, '박성민',	'M', '학사',	'인천', 5, 4, 13, null, null, null);
insert into Applicant values(22070002, '최민호',	'M', '석사',	'서울', 4, 3, 14, null, null, null);
insert into Applicant values(22070003, '김민혜',	'F', '고졸',	'수원', 2, 3, 17, null, null, null);
insert into Applicant values(22070004, '이한영',	'M', '석사',	'서울', 1, 3, 16, null, null, null);
insert into Applicant values(22070005, '정성환',	'M', '학사',	'김포', 5, 5, 15, null, null, null);

select * from Applicant; -- 조회

commit;