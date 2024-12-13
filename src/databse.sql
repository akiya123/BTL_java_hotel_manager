SET SQL_SAFE_UPDATES = 0;

use userdb;
create table user (
	userId INT auto_increment primary key, 
    username varchar(30),
    password varchar(30),
    email varchar(30),
    phoneNumber varchar(30),
    role varchar(30)
);
drop table user;
select * from user;

DELETE from user where id = 1;
DELETE FROM user; -- Xóa toàn bộ dữ liệu
ALTER TABLE user AUTO_INCREMENT = 1; -- Reset giá trị AUTO_INCREMENT về 1

insert into user
values	(00, "admin", "1", "admin@gmail.com", "0123456789", "admin");

create table room (
	id INT auto_increment primary key, 
    roomName varchar(30),
    roomType varchar(30),
    checkInDate varchar(30),
    checkOutDate varchar(30),
    price INT,
    status varchar(30),
    userId int
);
drop table room;

select * from room;
delete from room;

insert into room
values 	(1, "Phòng thường 1", "Phòng đơn", null, null, 300000, "Available", null),
		(2, "Phòng thường 2", "Phòng đơn", null, null, 300000, "Available", null),
		(3, "Phòng thường 3", "Phòng đơn", null, null, 300000, "Available", null),
		(4, "Phòng thường 4", "Phòng đơn", null, null, 300000, "Available", null),
        (5, "Phòng thường 5", "Phòng đơn", null, null, 300000, "Available", null),
		(6, "Phòng thường 6", "Phòng đôi", null, null, 500000, "Available", null),
        (7, "Phòng thường 7", "Phòng đôi", null, null, 500000, "Available", null),
		(8, "Phòng thường 8", "Phòng đôi", null, null, 500000, "Available", null),
        (9, "Phòng thường 10", "Phòng đôi", null, null, 500000, "Available", null),
		(10, "Phòng thường 11", "Phòng đôi", null, null, 500000, "Available", null),
        (11, "Phòng VIP 1", "Phòng đơn", null, null, 700000, "Available", null),
		(12, "Phòng VIP 2", "Phòng đơn", null, null, 700000, "Available", null),
        (13, "Phòng VIP 3", "Phòng đơn", null, null, 700000, "Available", null),
		(14, "Phòng VIP 4", "Phòng đơn", null, null, 700000, "Available", null),
        (15, "Phòng VIP 5", "Phòng đơn", null, null, 700000, "Available", null),
		(16, "Phòng VIP 6", "Phòng đôi", null, null, 1000000, "Available", null),
        (17, "Phòng VIP 7", "Phòng đôi", null, null, 1000000, "Available", null),
		(18, "Phòng VIP 8", "Phòng đôi", null, null, 1000000, "Available", null),
        (19, "Phòng VIP 9", "Phòng đôi", null, null, 1000000, "Available", null),
		(20, "Phòng VIP 10", "Phòng đôi", null, null, 1000000, "Available", null);


