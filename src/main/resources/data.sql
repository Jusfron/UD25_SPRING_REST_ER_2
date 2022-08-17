
DROP table IF EXISTS empleados;
DROP table IF EXISTS departamentos;

create table departamentos(
    id int auto_increment,
    nombre varchar(100),
    presupuesto int,
	PRIMARY KEY (id)
);

create table empleados(
    id int auto_increment,
    nombre varchar(100),
    apellidos varchar(250),
    departamento int,
	PRIMARY KEY (id),
	CONSTRAINT departamento_fk FOREIGN KEY (departamento) REFERENCES departamentos (id)
);

insert into departamentos (nombre,presupuesto)values('Finanzas',220000);
insert into departamentos (nombre,presupuesto)values('Marketing',170000);
insert into empleados (nombre,apellidos,departamento)values('Gaizka','Carmona',1);
insert into empleados (nombre,apellidos,departamento)values('Anton','Rosa',2);
insert into empleados (nombre,apellidos,departamento)values('Juan Fernando','Villar',2);
insert into empleados (nombre,apellidos,departamento)values('Gaspar','Portillo',1);