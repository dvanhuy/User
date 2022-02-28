create database ConnectJava
go
use ConnectJava
go
-- Tao bang user
create table NguoiDung(
	ID int primary key,
	ten nvarchar(45),
	sdt varchar(45),
	tenTK varchar(45),
	matkhau varchar(45),
	gioiThieu nvarchar(100),
	vaiTro nvarchar(45),
	soThich nvarchar(45)
)
go
insert into NguoiDung 
values	(1,N'Nguyễn A',0905123456,'abc',12345,N'huy',N'Admin',N'Xem phim'),
		(2,N'Lê B',0905123457,'abc',12345,N'fgf',N'User',N'Xem phim'),
		(3,N'Trần C',0905123458,'abc',12345,N'ha',N'User',N'Nghe nhạc'),
		(4,N'Đinh D',0905123459,'abc',12345,N'huy',N'User',N'Nghe nhạc'),
		(5,N'Trần D',0945465459,'tyu',12845,N'huy',N'Admin',N'Nghe nhạc')

go
use ConnectJava 
select top 1 id 
from NguoiDung
order by id desc