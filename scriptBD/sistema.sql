create database sistema
 go

use sistema 
go

create table periodo (
	idPeriodo varchar (50) primary key
)
go

create table semestre (
	idSemestre int primary key
)
go

insert into semestre values(1),(2),(3),(4),(5),(6)
go

create table grupo (
	idGrupo varchar (50) primary key
)
go

create table departamento(
	idDepartamento varchar (50) primary key
)
go

create table rol (
	idRol varchar (30) primary key
)
go

create table concepto (
	idConcepto varchar (50) primary key
)
go

create table alumno (
	matricula varchar (50) primary key,
	nombre varchar (50),
	aPaterno varchar (50),
	aMaterno varchar (50),
	semestre int foreign key references semestre (idSemestre)
	on update cascade
	on delete cascade,
	grupo varchar (50) foreign key references grupo (idGrupo)
	on update cascade
	on delete cascade,
)
go

create table alumnoPeriodo (
	idAlumnoPeriodo int identity (1,1) primary key,
	idPeriodo varchar (50) foreign key references periodo (idPeriodo)
	on update cascade
	on delete cascade,
	matriculaAlumno varchar (50) foreign key references alumno (matricula)
	on update cascade
	on delete cascade,
	semestre int ,
	grupo varchar (50),
	estatus_entrega1 varchar (50) default ('No entregado'),
	estatus_entrega2 varchar (50) default ('No entregado'),
	estatus_entrega3 varchar (50) default ('No entregado')
	)
go

create table usuario (
	idUsuario int identity (1,1) primary key,
	nombre varchar (50),
	apellidos varchar (50),
	usuario varchar (50),
	clave varchar (50),
	departamento varchar (50) foreign key references departamento (idDepartamento)
	on update cascade
	on delete cascade,
	rol varchar (30) foreign key references rol (idRol)
	on update cascade
	on delete cascade
)
go

create table comprobante(
	idComprobante int identity (1,1) primary key,
	matriculaAlumno varchar (50) foreign key references alumno (matricula)
	on update cascade
	on delete cascade,
	idPeriodo varchar (50) foreign key references periodo (idPeriodo)
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION,
	usuarioRecibe varchar (50),
	departamentoRecibe varchar(50) foreign key references departamento(idDepartamento)
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION,
	fechaRecibido varchar (50),
	conceptos varchar (500),
	comprobante VARBINARY (MAX)
)
go

insert into departamento values 
('Area de Recursos Administrativos'), 
('Servicios Escolares'), 
('Centro Evaluador y de Capacitación')
go

insert into rol values 
('Admin'),('Colaborador')
go

insert into usuario values 
('Nombre', 'Apellidos', 'ARA', '123', 'Area de Recursos Administrativos', 'Admin'),
('Nombre', 'Apellidos', 'SES', '123', 'Servicios Escolares', 'Admin'),
('Nombre', 'Apellidos', 'CEC', '123', 'Centro Evaluador y de Capacitación', 'Admin')
go

CREATE VIEW VistaAlumnoPeriodo AS
SELECT ap.idPeriodo,ap.matriculaAlumno, a.nombre, a.aPaterno, a.aMaterno,
ap.semestre, ap.grupo, ap.estatus_entrega1, ap.estatus_entrega2,ap.estatus_entrega3
FROM alumnoPeriodo ap
JOIN alumno a ON ap.matriculaAlumno = a.matricula;
go
