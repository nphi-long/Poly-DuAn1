create database PRO1041_QLCT

USE PRO1041_QLCT
GO 

---Tao bang nguoi dung
IF Object_ID('NGUOIDUNG') is not null 
	drop table NGUOIDUNG 
GO 
create table NGUOIDUNG
(
	tennguoidung	nvarchar(50) not null,
	sotien			int		 null,
	constraint PK_NGUOIDUNG primary key (tennguoidung)
)

---Tao bang nguon tien 
IF Object_ID('NGUONTIEN') is not null 
	drop table NGUONTIEN 
GO 
create table NGUONTIEN
(
	tennguon	nvarchar(50) not null,
	loai		nvarchar(50) null,
	trangthai	nvarchar(50) null,
	constraint PK_NGUONTIEN primary key (tennguon)
)

---Tao bang luc hu 
IF Object_ID('LUCHU') is not null 
	drop table LUCHU 
GO 
create table LUCHU
(
	tenhu	nvarchar(50) not null,
	sotien	int null,
	constraint PK_LUCHU primary key (tenhu)
)

---Tao bang thu chi 
IF Object_ID('THUCHI') is not null 
	drop table THUCHI 
GO 
create table THUCHI
(
	id				int identity(1,1) not null,
	ten				nvarchar(50) null,
	sotien			int	null,
	ngay			date null,
	tennguon		nvarchar(50) null,
	ghichu			nvarchar(200) null,
	tenhu			nvarchar(50) null,
	tennguoidung	nvarchar(50) null,
	constraint PK_THUCHI primary key (id),
	constraint FK_NGUONTIEN_THUCHI foreign key (tennguon) references NGUONTIEN,
	constraint FK_NGUOIDUNG_THUCHI foreign key (tennguoidung) references NGUOIDUNG,
	constraint FK_LUCHU_THUCHI foreign key (tenhu) references LUCHU
)

---Them du lieu bang nguoi dung
DELETE FROM NGUOIDUNG
INSERT INTO NGUOIDUNG VALUES ('Nguyen Phi Long', 50000000)

---Them du lieu bang nguon tien
DELETE FROM NGUONTIEN
INSERT INTO NGUONTIEN VALUES ('Luong','Thu','')
INSERT INTO NGUONTIEN VALUES ('Du an','Thu','')
INSERT INTO NGUONTIEN VALUES ('An uong','Chi','')
INSERT INTO NGUONTIEN VALUES ('Hoc hanh','Chi','')

---Them du lieu vao bang hu
DELETE FROM LUCHU
INSERT INTO LUCHU VALUES ('Tat ca', 50000000)
INSERT INTO LUCHU VALUES ('Thiet yeu', 10000000)
INSERT INTO LUCHU VALUES ('Giao duc', 1000000)
INSERT INTO LUCHU VALUES ('Tiet kiem', 10000000)
INSERT INTO LUCHU VALUES ('Huong thu', 10000000)
INSERT INTO LUCHU VALUES ('Dau tu', 5000000)
INSERT INTO LUCHU VALUES ('Thien tam', 5000000)

---Them du lieu bang thu chi
DELETE FROM THUCHI
INSERT INTO THUCHI VALUES ('Luong chinh', 10000000, '12/09/2019', 'Luong', 'Tien Luong lam tai cong ty FPT', 'Tat ca','Nguyen Phi Long')
INSERT INTO THUCHI VALUES ('Luong lam them',6000000, '11/05/2018', 'Luong', 'Tien Luong lam them du an FPOLY', 'Tat ca', 'Nguyen Phi Long')
INSERT INTO THUCHI VALUES ('Tien hoc', 1200000, '05/06/2017', 'Hoc hanh', 'Dong tien hoc tieng anh', 'Giao duc', 'Nguyen Phi Long')
INSERT INTO THUCHI VALUES ('Mua do an', 600000, '09/25/2017', 'An uong', 'Mua 1 thung mi tom', 'Thiet yeu', 'Nguyen Phi Long')


select * from THUCHI
select * from LUCHU
select * from NGUOIDUNG
select * from NGUONTIEN where trangthai = ''
select sum(sotien)
from THUCHI join NGUONTIEN on THUCHI.tennguon = NGUONTIEN.tennguon
where loai= 'thu'

select * from NGUONTIEN  join THUCHI on NGUONTIEN.tennguon = THUCHI.tennguon join LUCHU on THUCHI.tenhu = LUCHU.tenhu where loai = 'chi'
