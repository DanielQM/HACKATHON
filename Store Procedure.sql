

create procedure agregarColegios
@Nombre varchar (40)

AS
begin
insert into colegios values(@nombre) 
end
go
exec agregarColegios @Nombre = 'Mixto' 