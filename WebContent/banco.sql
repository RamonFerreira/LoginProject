create database javashop;
show tables;

  create table tb_login(
  id int primary key  auto_increment,
  username varchar(80),
  usermail varchar(80), 
  password varchar(41), 
  keySecurity varchar(41),
  registrationdate date, 
  updatedate date);
  
  
 create table tb_user(
id  int primary key auto_increment,
firstname         varchar(150)not null,
lastname          varchar(150)not null,
usermail          varchar(150)not null,
telphone               varchar(15),
celphone               varchar(15),
birthdate              date,
typeUser        enum('A','U'),
id_login_fk     int unique not null,
foreign key (id_login_fk) references tb_login(id),
registrationdate date, 
updatedate date);
  
insert into tb_user values(null,'thiagoramon','ferreirapint','thiagramon_@hotmail.com',null,null,sysdate(),'A',1,sysdate(),sysdate());

  select * from tb_login;
  select * from tb_user;
 SELECT COUNT(1) FRoM tb_login where usermail='thiagoramon_@hotmail.com'