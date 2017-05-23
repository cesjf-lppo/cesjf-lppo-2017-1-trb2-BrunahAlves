/**
 * Author:  Bruna Alves
 * Created: 21/05/2017
 */

CREATE TABLE Coleta(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao INTEGER NOT NULL,
    data TIMESTAMP NOT NULL
);


