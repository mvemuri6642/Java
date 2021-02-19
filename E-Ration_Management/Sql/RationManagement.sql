create table eRation(ID int  not null auto_increment, name varchar(20),email varchar(40),password varchar(30),contact int,division int,status varchar(3),type varchar(10),
primary key(ID));


insert into eRation(id,name,email,password,type)values(1123,"shankar","s@gmail.com","shankar","Admin");
select * from eRation;
update eRation set email='s', password='m' where name='t';

insert into eRation(name,email,password,contact,division,status,type)values("ram","r@gmail.com","r",123,1,"N","officer");


