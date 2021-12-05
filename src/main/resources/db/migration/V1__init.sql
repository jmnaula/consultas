CREATE TABLE IF NOT EXISTS paciente(
    id serial,
    nombres varchar (45) not null,
    edad VARCHAR(45) NOT NULL,
    talla varchar(45) not null,
    peso VARCHAR(45) NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS consultamedica(
    id serial,
    sintomas varchar (45) not null,
    antecedentes_medicos VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS tratamiento(
    id serial,
    medicina varchar (45) not null,
    controles VARCHAR(45) NOT NULL,
    reposo varchar(45) not null,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS medico(
    id serial,
    nombres varchar (45) not null,
    especialidad VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
    );