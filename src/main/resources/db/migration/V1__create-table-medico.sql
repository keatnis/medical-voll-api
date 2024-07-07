create table medico (
    id  int not null auto_increment,
    nombre varchar(250) not null,
    email varchar(100) not null unique,
    documento varchar(100) not null unique,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    distrito varchar(100) not null,
    ciudad varchar(100) not null,
    numero varchar(15),
    complemento varchar(100),

    primary key(id)

);
