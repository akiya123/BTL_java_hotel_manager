SET SQL_SAFE_UPDATES = 0;

use userdb;
create table user (
	id INT auto_increment primary key, 
    username varchar(30),
    password varchar(30),
    email varchar(30),
    phoneNumber varchar(30)
);
drop table user;

select * from user;

DELETE from user where id = 1;
delete from user;

SELECT setval('users_id_seq', 1, false);



create table room (
	id INT auto_increment primary key, 
    roomName varchar(30),
    roomType varchar(30),
    checkOutDate varchar(30),
    price INT,
    status varchar(30)
);
drop table room;

select * from room;
delete from room;

insert into room
values 	(1, "Phòng thường 1", "Phòng đơn", null, 300000, "Available"),
		(2, "Phòng thường 2", "Phòng đơn", null, 300000, "Available"),
		(3, "Phòng thường 3", "Phòng đơn", null, 300000, "Available"),
		(4, "Phòng thường 4", "Phòng đơn", null, 300000, "Available"),
        (5, "Phòng thường 5", "Phòng đơn", null, 300000, "Available"),
		(6, "Phòng thường 6", "Phòng đôi", null, 500000, "Available"),
        (7, "Phòng thường 7", "Phòng đôi", null, 500000, "Available"),
		(8, "Phòng thường 8", "Phòng đôi", null, 500000, "Available"),
        (9, "Phòng thường 10", "Phòng đôi", null, 500000, "Available"),
		(10, "Phòng thường 11", "Phòng đôi", null, 500000, "Available"),
        (11, "Phòng VIP 1", "Phòng đơn", null, 700000, "Available"),
		(12, "Phòng VIP 2", "Phòng đơn", null, 700000, "Available"),
        (13, "Phòng VIP 3", "Phòng đơn", null, 700000, "Available"),
		(14, "Phòng VIP 4", "Phòng đơn", null, 700000, "Available"),
        (15, "Phòng VIP 5", "Phòng đơn", null, 700000, "Available"),
		(16, "Phòng VIP 6", "Phòng đôi", null, 1000000, "Available"),
        (17, "Phòng VIP 7", "Phòng đôi", null, 1000000, "Available"),
		(18, "Phòng VIP 8", "Phòng đôi", null, 1000000, "Available"),
        (19, "Phòng VIP 9", "Phòng đôi", null, 1000000, "Available"),
		(20, "Phòng VIP 10", "Phòng đôi", null, 1000000, "Available");


