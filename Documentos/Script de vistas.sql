
create view vistaColegio
as
select * from colegio
go

create view vistaniños
as
select idniño,dirección,horabuscar,horadejar,Colegios.nombre as colegio from niños
inner join Colegios on colegios.idcolegio =niños.Colegios_idColegio

go

create view vistaApoderado
as
select idapoderados,nombre,dni,telefono,niños.niños.nombre as niño from  Apoderados
inner join niños on niños.idniños = apoderados.niñis_idniños

go
create view vistaContratos
as
select idContrato,Apoderados.Nombre as apoderado ,Tiempocon,modalidad,cantidadniño,precio from Contratos 
inner join apoderados on apoderados.idapoderado =contratos.apoderados_idapoderado
go

create view vistaRecorrido
as
select * from recorridos
go

create view vistaChoferes
as
select  idChofer,nombre,dni,licenciCondu,Buses.NumMatricula from Choferes
inner join buses on  buses.idbus =buses_idbus
go

create view vistaBuses
as
select  * from buses

go
create view vistaAsistentes
as
select  idAsistente,nombre,dni,Buses.NumMatricula from Asistentes
inner join buses on  buses.idbus =buses_idbus
go

