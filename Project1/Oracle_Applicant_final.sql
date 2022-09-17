select * from tab;

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

select * from Applicant; -- 조회

insert into Applicant values(22070001, '박성민',	'M', '학사',	'인천', 3, 4, 13, 9, 8, 9);
insert into Applicant values(22070002, '최민호',	'M', '석사',	'서울', 4, 3, 14, 6, 7, 6);
insert into Applicant values(22070003, '김민혜',	'F', '고졸',	'수원', 2, 3, 13, 4, 7, 9);
insert into Applicant values(22070004, '이한영',	'M', '석사',	'서울', 1, 3, 16, 5, 6, 8);
insert into Applicant values(22070005, '정성환',	'M', '학사',	'김포', 3, 2, 15, 8, 7, 7);
insert into Applicant values(22070006, '김호형',	'M', '학사',	'울산', 3, 2, 13, 4, 8, 7);
insert into Applicant values(22070007, '배혜정',	'F', '학사',	'세종', 4, 3, 14, 8, 7, 8);
insert into Applicant values(22070008, '조원동',	'M', '석사',	'서울', 5, 5, 18, 9, 7, 6);
insert into Applicant values(22070009, '김경철',	'M', '학사',	'양주', 4, 5, 16, 6, 6, 7);
insert into Applicant values(22070010, '박우민',	'M', '고졸',	'일산', 2, 2, 15, 8, 5, 4);
insert into Applicant values(22070011, '최철환',	'M', '학사',	'서울', 2, 3, 17, 5, 5, 9);
insert into Applicant values(22070012, '이소영',	'F', '학사',	'서울', 2, 4, 16, 8, 7, 8);
insert into Applicant values(22070013, '성대훈',	'M', '학사',	'서울', 2, 2, 14, 4, 7, 8);
insert into Applicant values(22070014, '김영미',	'F', '학사',	'대전', 4, 3, 11, 6, 5, 6);
insert into Applicant values(22070015, '김철민',	'M', '학사',	'부산', 3, 2, 13, 4, 5, 7);
insert into Applicant values(22070016, '우병환',	'M', '석사',	'서울', 2, 4, 11, 7, 4, 7);
insert into Applicant values(22070017, '김샛별',	'F', '학사',	'파주', 3, 3, 14, 6, 6, 9);
insert into Applicant values(22070018, '이종석',	'M', '고졸',	'인천', 4, 2, 15, 9, 4, 9);
insert into Applicant values(22070019, '박성수',	'M', '학사',	'수원', 2, 5, 16, 8, 8, 9);
insert into Applicant values(22070020, '이수정',	'F', '학사',	'서울', 1, 5, 19, 7, 8, 4);
insert into Applicant values(22070021, '김기영',	'M', '학사',	'서울', 3, 3, 12, 4, 6, 6);
insert into Applicant values(22070022, '김정훈',	'M', '학사',	'대전', 4, 2, 11, 5, 5, 8);
insert into Applicant values(22070023, '오혜원',	'F', '석사',	'인천', 3, 3, 13, 4, 9, 6);
insert into Applicant values(22070024, '박호석',	'M', '학사',	'성남', 4, 4, 12, 9, 8, 8);
insert into Applicant values(22070025, '강성호',	'M', '학사',	'수원', 4, 4, 16, 7, 9, 9);
insert into Applicant values(22070026, '추성호',	'M', '학사',	'서울', 4, 2, 13, 5, 6, 7);
insert into Applicant values(22070027, '신용철',	'M', '학사',	'원주', 4, 2, 13, 5, 4, 8);
insert into Applicant values(22070028, '김기훈',	'M', '학사',	'인천', 1, 3, 19, 9, 8, 8);
insert into Applicant values(22070029, '최성환',	'M', '학사',	'서울', 1, 5, 20, 6, 6, 7);
insert into Applicant values(22070030, '김종훈',	'M', '고졸',	'서울', 2, 2, 17, 5, 5, 9);
insert into Applicant values(22070031, '정민지',	'F', '학사',	'평택', 3, 3, 16, 7, 5, 9);
insert into Applicant values(22070032, '김성락',	'M', '고졸',	'안산', 4, 4, 15, 7, 7, 7);
insert into Applicant values(22070033, '임명훈',	'M', '석사',	'서울', 2, 5, 14, 6, 8, 9);
insert into Applicant values(22070034, '조병환',	'M', '고졸',	'안양', 3, 2, 13, 8, 4, 7);
insert into Applicant values(22070035, '박병필',	'M', '학사',	'서울', 4, 2, 12, 6, 5, 8);
insert into Applicant values(22070036, '김민기',	'M', '학사',	'인천', 3, 5, 20, 8, 8, 8);
insert into Applicant values(22070037, '이용석',	'M', '고졸',	'안산', 3, 3, 19, 8, 7, 7);
insert into Applicant values(22070038, '박원영',	'M', '학사',	'서울', 4, 3, 11, 9, 6, 9);
insert into Applicant values(22070039, '구정문',	'M', '학사',	'수원', 3, 3, 17, 8, 6, 8);
insert into Applicant values(22070040, '이기용',	'M', '학사',	'서울', 2, 3, 15, 7, 8, 9);
insert into Applicant values(22070041, '하성진',	'M', '석사',	'여주', 3, 2, 17, 7, 5, 9);
insert into Applicant values(22070042, '김상진',	'M', '고졸',	'이천', 4, 4, 15, 8, 7, 7);
insert into Applicant values(22070043, '조민아',	'F', '학사',	'용인', 2, 2, 12, 4, 8, 8);
insert into Applicant values(22070044, '최성배',	'M', '학사',	'오산', 1, 4, 18, 6, 5, 6);
insert into Applicant values(22070045, '박민정',	'F', '학사',	'서울', 4, 3, 14, 4, 6, 4);
insert into Applicant values(22070046, '이성학',	'M', '고졸',	'대전', 2, 2, 11, 5, 5, 7);
insert into Applicant values(22070047, '최민우',	'M', '학사',	'안양', 4, 3, 12, 6, 7, 6);
insert into Applicant values(22070048, '강성문',	'M', '학사',	'인천', 3, 2, 17, 5, 6, 5);
insert into Applicant values(22070049, '안용근',	'M', '학사',	'일산', 1, 4, 15, 4, 9, 7);
insert into Applicant values(22070050, '박정환',	'M', '고졸',	'서울', 2, 3, 14, 5, 8, 5);
