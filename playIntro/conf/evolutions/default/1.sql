# --- !Ups

create table articulo (
  codigo 						number(10,0) not null,
  nombre	                    varchar(30) not null,
  constraint pk_articulo   primary key (codigo))
;



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists articulo;

SET REFERENTIAL_INTEGRITY TRUE;