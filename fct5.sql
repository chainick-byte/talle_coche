-- creo secuencias para mis claves primarias equivalente a comando auto_increment de mysql 

create sequence seq_propietario
start with 
1 increment by 1
maxvalue 10000;
-- creo secuencias para mis claves primarias equivalente a comando auto_increment de mysql 

create sequence seq_propietario
start with 
1 increment by 1
maxvalue 10000;
/
create sequence seq_consulta
start with 
1 increment by 1
maxvalue 10000;
/
create sequence seq_factura
start with 
1 increment by 1
maxvalue 10000;
/
create sequence seq_fac_operacion
start with 
1 increment by 1
maxvalue 10000;
/
create sequence seq_operacion
start with 
1 increment by 1
maxvalue 10000;
/
CREATE TYPE t_propietario AS OBJECT(
id_propietario NUMBER,
nombre VARCHAR(60),
primer_apellido VARCHAR(60),
segundo_apellido VARCHAR(60),
dni VARCHAR(11),
telefono NUMBER(11)
);
/
CREATE TYPE t_consulta AS OBJECT(
id_auto NUMBER,
propietario REF t_propietario,
matricula VARCHAR(10),
modelo VARCHAR(60),
anno NUMBER(4),
estado VARCHAR(1)
);
/
CREATE TYPE t_factura AS OBJECT(
id_factura NUMBER,
fecha_emision DATE,
auto_id ref t_consulta);
/
CREATE TYPE t_operacion AS OBJECT(
id_operacion NUMBER,
nombre_operacion VARCHAR(256),
precio decimal(4,2)
);
/
CREATE TYPE t_factura_opercaion AS OBJECT(
id_factura_operacion NUMBER,
factura ref t_factura,
operacion ref t_operacion,
cantidad NUMBER(3)
);
/ 
create table propietario of t_propietario;
/
create table consulta of t_consulta;
/
create table factura of t_factura;
/
create table operacion of t_operacion;
/
create table factura_operacion of t_factura_opercaion;

--
-- PROPIETARIO
--
--guarda()

insert into propietario values(seq_propietario.nextval, 'igor','Repyakh', 'Repyakh', '123456A', 666444333);
/
insert into propietario values(seq_propietario.nextval,'Maria','Lopez','Gomez','2345678A',222333444);
/
insert into propietario values(seq_propietario.nextval,'Jorge','Garcia','Garcia','3344553A',333444555);

-- Select del propietario 
    -- dametodo()
    select *from propietario p order by p.id_propietario desc;
    --damepropietarioportelefono()
    select * from propietario p where p.telefono = 222333444;
    -- damepropietarioporid();
    select *from propietario p where p.id_propietario=3;
    -- damepropietariopordni()
    select * from  propietario p where p.dni='123456A';
    -- dameIdpropietarioRegistrado()
    select p.id_propietario from propietario p where p.dni='2345678A' and p.telefono=222333444;
    -- actualizar()
    update propietario p set p.nombre='Igor',p.primer_apellido='RRepyakh', p.segundo_apellido='RRepyakh',p.dni='123456AA',p.telefono=666555444 where p.id_propietario=1;
    --eliminar
    delete from propietario p where p.id_propietario=43;

--
-- CONSULTA
--

--guardar()
insert into consulta c values(seq_consulta.nextval,(select ref(p)from propietario p where p.id_propietario=1),'aa111a','seat leon', 1999,'n');
insert into consulta c values(seq_consulta.nextval,(select ref(p)from propietario p where p.id_propietario=2),'aa111a','seat leon', 1999,'n');
insert into consulta c values(seq_consulta.nextval,(select ref(p)from propietario p where p.id_propietario=3),'aa111a','seat leon', 1999,'n');
-- eliminar()
delete from consulta c where c.id_auto=3;
-- dameporIDpropietario()
select c.id_auto,c.propietario.id_propietario, c.matricula,c.modelo,c.anno,c.estado from consulta c where c.propietario.id_propietario=1;
--dametodo()
select c.id_auto,c.propietario.id_propietario, c.matricula,c.modelo,c.anno,c.estado from consulta c;
--actualizarEstado()
update consulta c set estado='y' where c.id_auto=1;
-- actualizar()
update consulta c set   c.matricula='aa1111a',  c.modelo='opel corsa', c.anno=2020,c.estado='n' where c.id_auto=21;





