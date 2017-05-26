package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetaDAO {

    private final PreparedStatement opNovaColeta;
    private final PreparedStatement opListarColeta;

    public ColetaDAO() throws Exception {

        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO Coleta(descricao, dat) VALUES(?,?)");
        opListarColeta = conexao.prepareStatement("SELECT * FROM Coleta GROUP BY coleta");

    }

    public void cria(Coleta novaColeta) throws Exception {
        try {
            opNovaColeta.clearParameters();
            opNovaColeta.setString(1, novaColeta.getDescricao());
            opNovaColeta.setDate(2, (Date) novaColeta.getData());
            opNovaColeta.executeUpdate();
            System.out.println("teste" + novaColeta.getData());
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir nova Coleta!", ex);
        }
    }

    public List<Coleta> listByColeta() throws Exception {
        try {
            List<Coleta> pedidos = new ArrayList<>();

            ResultSet resultado = opListarColeta.executeQuery();

            while (resultado.next()) {
                Coleta novaColeta = new Coleta();

                novaColeta.setId(resultado.getLong("id"));
                novaColeta.setDescricao(resultado.getString("descricao"));
                //Adicionar o setData
                //Coleta.add(novaColeta);
            }

            return pedidos;

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os pedidos no banco!", ex);
        }
    
    }
}
