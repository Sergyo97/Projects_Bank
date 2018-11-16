-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-16 01:30:30.735

-- foreign keys
ALTER TABLE Tipo_idea
    DROP CONSTRAINT Tipo_idea_Idea;

ALTER TABLE Idea
    DROP CONSTRAINT Usuario;

ALTER TABLE Votado
    DROP CONSTRAINT Votado_Idea;

ALTER TABLE Votado
    DROP CONSTRAINT Votado_Usuario;

-- tables
DROP TABLE Idea;

DROP TABLE Tipo_idea;

DROP TABLE Usuario;

DROP TABLE Votado;

-- End of file.

