/**
 * Author:  Bruna Alves
 * Created: 21/05/2017
 */

CREATE TABLE Coleta(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(50) NOT NULL,
    dat TIMESTAMP NOT NULL
);

insert into Coleta VALUES('Centro', '15-06-2017 10:00:00')