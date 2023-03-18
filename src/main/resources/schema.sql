create table if not exists brands (
  id identity,
  name varchar(50) not null,
  brandNames varchar(50) not null,
  price int not null,
  yearOfCreation int not null
);