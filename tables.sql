-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-08 03:32:22.287

-- tables
-- Table: Idea
CREATE TABLE Idea (
    Id int  NOT NULL,
    Nombre_Iniciativa varchar(100)  NOT NULL,
    Estado varchar(10)  NOT NULL,
    T_Idea_Id int  NOT NULL,
    Usuario_Carne int  NOT NULL,
    Votos int  NOT NULL,
    Fecha_Creacion date  NOT NULL,
    CONSTRAINT Idea_pk PRIMARY KEY (Id)
);

-- Table: T_Idea
CREATE TABLE T_Idea (
    Id int  NOT NULL,
    Tipo varchar(30)  NOT NULL,
    CONSTRAINT T_Idea_pk PRIMARY KEY (Id)
);

-- Table: Tipo_Usuario
CREATE TABLE Tipo_Usuario (
    Id int  NOT NULL,
    Descripcion varchar(50)  NOT NULL,
    CONSTRAINT Tipo_Usuario_pk PRIMARY KEY (Id)
);

-- Table: Usuario
CREATE TABLE Usuario (
    Carne int  NOT NULL,
    Nombre varchar(100)  NOT NULL,
    Correo varchar(150)  NOT NULL,
    Tipo_Usuario_Id int  NOT NULL,
    Activo boolean  NOT NULL,
    CONSTRAINT Correo_UK UNIQUE (Correo) INITIALLY IMMEDIATE,
    CONSTRAINT Usuario_pk PRIMARY KEY (Carne)
);

-- foreign keys
-- Reference: Idea_T_Idea (table: Idea)
ALTER TABLE Idea ADD CONSTRAINT Idea_T_Idea
    FOREIGN KEY (T_Idea_Id)
    REFERENCES T_Idea (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Idea_Usuario (table: Idea)
ALTER TABLE Idea ADD CONSTRAINT Idea_Usuario
    FOREIGN KEY (Usuario_Carne)
    REFERENCES Usuario (Carne)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Usuario_T_Tipo (table: Usuario)
ALTER TABLE Usuario ADD CONSTRAINT Usuario_T_Tipo
    FOREIGN KEY (Tipo_Usuario_Id)
    REFERENCES Tipo_Usuario (Id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

