create table eRation(ID int  not null auto_increment, name varchar(20),email varchar(40),password varchar(30),contact int,division int,status varchar(3),type varchar(10),
primary key(ID));


insert into eRation(id,name,email,password,type)values(1123,"shankar","s@gmail.com","shankar","Admin");
select * from eRation;
describe account;
update eRation set email='s', password='m' where name='t';

insert into eRation(name,email,password,contact,division,status,type)values("ram","r@gmail.com","r",123,1,"N","officer");
alter table account modify aadhaar BIGINT;


create table account(id int not null auto_increment,name char(20), aadhaar int(12), contact int(10), door_no varchar(15),village varchar(15), mandal varchar(15),division int,status int,primary key(id));
select * from account;
alter table account modify column status varchar(5);

insert into account values(15,'shankar',2300,76599,'1-132','tanuku','godavari',2,'n');
