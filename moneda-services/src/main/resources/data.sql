 insert into tbl_moneda (id, nombre) values (1,'PEN');
 insert into tbl_moneda (id, nombre) values (2,'COP');
 insert into tbl_moneda (id, nombre) values (3,'USD');
 insert into tbl_moneda (id, nombre) values (4,'EUR');

insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (1,3,1,3.5);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (2,4,1,4.1);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (3,3,2,2400);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (4,4,2,3000);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (5,1,3,1/3.5);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (6,1,4,1/4.1);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (7,2,3,1/2400);
insert into tbl_tipo_cambio (id, moneda_origen_id, moneda_destino_id, cambio) values (8,2,4,1/3000);