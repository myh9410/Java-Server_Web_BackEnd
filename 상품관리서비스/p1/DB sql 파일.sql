CREATE TABLE if not exists `product` (
	`prod_no` int primary key auto_increment,
    `prod_name` varchar(200),
    `prod_price` int,
    `prod_desc` varchar(2000)
);