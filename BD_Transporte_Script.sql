/* DROP DATABASE BD_Transporte */

CREATE DATABASE BD_Transporte
GO
USE BD_Transporte
GO

CREATE TABLE BOLETO (
    COD_BOL int  NOT NULL IDENTITY(1,1),
    FEC_BOL date  NOT NULL,
    NUM_ASIE varchar(2)  NOT NULL,
    PASAJERO_COD_PASJ int  NOT NULL,
    RUTAS_COD_RUTA int  NOT NULL,
    BUS_COD_BUS int  NOT NULL,
    CONSTRAINT BOLETO_pk PRIMARY KEY  (COD_BOL)
);
GO

-- Table: BUS
CREATE TABLE BUS (
    COD_BUS int  NOT NULL IDENTITY(1,1),
    PLACA_BUS varchar(20)  NOT NULL,
    NASIENTO varchar(2)  NOT NULL,
    CONSTRAINT BUS_pk PRIMARY KEY  (COD_BUS)
);
GO

-- Table: PASAJERO
CREATE TABLE PASAJERO (
    COD_PASJ int  NOT NULL IDENTITY(1,1),
    DNI_PASJ varchar(8)  NOT NULL,
    FECNAC_PASJ date  NOT NULL,
    NOM_PASJ varchar(200)  NOT NULL,
    CONSTRAINT PASAJERO_pk PRIMARY KEY  (COD_PASJ)
);
GO

-- Table: RUTAS
CREATE TABLE RUTAS (
    COD_RUTA int  NOT NULL IDENTITY(1,1),
    ORI_RUTA varchar(200)  NOT NULL,
    DES_RUTA varchar(200)  NOT NULL,
    COS_RUTA varchar(2)  NOT NULL,
    CONSTRAINT RUTAS_pk PRIMARY KEY  (COD_RUTA)
);
GO

-- Table: SUCURSALES
CREATE TABLE SUCURSALES (
    COD_SUC int  NOT NULL IDENTITY(1,1),
    NOM_SUC varchar(200)  NOT NULL,
    CONSTRAINT SUCURSALES_pk PRIMARY KEY  (COD_SUC)
);
GO

-- foreign keys
-- Reference: BOLETO_BUS (table: BOLETO)
ALTER TABLE BOLETO ADD CONSTRAINT BOLETO_BUS
    FOREIGN KEY (BUS_COD_BUS)
    REFERENCES BUS (COD_BUS);
GO

-- Reference: BOLETO_PASAJERO (table: BOLETO)
ALTER TABLE BOLETO ADD CONSTRAINT BOLETO_PASAJERO
    FOREIGN KEY (PASAJERO_COD_PASJ)
    REFERENCES PASAJERO (COD_PASJ);
GO

-- Reference: BOLETO_RUTAS (table: BOLETO)
ALTER TABLE BOLETO ADD CONSTRAINT BOLETO_RUTAS
    FOREIGN KEY (RUTAS_COD_RUTA)
    REFERENCES RUTAS (COD_RUTA);
GO


INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES('DANIEL QUISPE','76806031','01/31/2000');
INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES('KARLA PEÑA','75852369','04/05/2000');
INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES('ARMANDO CASAS','12536965','06/08/1999');
INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES('PEPITO PEREZ','12365485','02/03/1997');
INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES('GABRIELA RODRIGUEZ','75856965','04/05/1999');

INSERT INTO SUCURSALES(NOM_SUC) VALUES('LIMA');
INSERT INTO SUCURSALES(NOM_SUC) VALUES('CAÑETE');
INSERT INTO SUCURSALES(NOM_SUC) VALUES('CHINCHA');
INSERT INTO SUCURSALES(NOM_SUC) VALUES('PISCO');
INSERT INTO SUCURSALES(NOM_SUC) VALUES('ICA');

--end file