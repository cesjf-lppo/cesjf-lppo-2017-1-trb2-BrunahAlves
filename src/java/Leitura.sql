/**
 * Author:  Bruna Alves
 * Created: 21/05/2017
 */


CREATE TABLE Leitura(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    coleta INTEGER NOT NULL,
    local VARCHAR(50) NOT NULL,
    leitura REAL NOT NULL,
    unidade VARCHAR(50) NOT NULL,
    atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);