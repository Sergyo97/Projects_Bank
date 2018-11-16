-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-16 01:35:20.761

-- tables
-- Table: Idea
CREATE TABLE Idea (
    Id int  NOT NULL,
    Descripcion varchar  NOT NULL,
    Estado varchar  NOT NULL,
    Fecha date  NOT NULL,
    Votos int  NOT NULL,
    Titulo varchar  NOT NULL,
    Tipo int  NOT NULL,
    Usuario varchar  NOT NULL,
    Tipo_idea int  NOT NULL,
    CONSTRAINT Idea_pk PRIMARY KEY (Id)
);

-- Table: Tipo_idea
CREATE TABLE Tipo_idea (
    Id int  NOT NULL,
    Tipo varchar  NOT NULL,
    CONSTRAINT Tipo_idea_pk PRIMARY KEY (Id)
);

-- Table: Usuario
CREATE TABLE Usuario (
    Correo varchar  NOT NULL,
    Nombre varchar  NOT NULL,
    Clave varchar  NOT NULL,
    Activo boolean  NOT NULL,
    Tipo varchar  NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (Correo)
);

-- Table: Votado
CREATE TABLE Votado (
    Usuario_Correo varchar  NOT NULL,
    Idea_Id int  NOT NULL,
    CONSTRAINT Votado_pk PRIMARY KEY (Usuario_Correo,Idea_Id)
);

-- foreign keys
-- Reference: Idea_Tipo_idea (table: Idea)
ALTER TABLE Idea ADD CONSTRAINT Idea_Tipo_idea
    FOREIGN KEY (Tipo_idea)
    REFERENCES Tipo_idea (Id)
;

-- Reference: Usuario (table: Idea)
ALTER TABLE Idea ADD CONSTRAINT Usuario
    FOREIGN KEY (Usuario)
    REFERENCES Usuario (Correo)
;

-- Reference: Votado_Idea (table: Votado)
ALTER TABLE Votado ADD CONSTRAINT Votado_Idea
    FOREIGN KEY (Idea_Id)
    REFERENCES Idea (Id)
;

-- Reference: Votado_Usuario (table: Votado)
ALTER TABLE Votado ADD CONSTRAINT Votado_Usuario
    FOREIGN KEY (Usuario_Correo)
    REFERENCES Usuario (Correo)
;

-- End of file.

