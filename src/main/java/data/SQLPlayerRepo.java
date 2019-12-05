package data;

import data.util.ConnectDB;
import domain.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLPlayerRepo implements PlayerRepo{
    private static final String GET_PLAYERS = "select * from player";
    private static final String INSERT_PLAYERS = "insert into player(name, password) values(?, ?)";

    @Override
    public List<Player> getPlayers() {
        try(Connection c = ConnectDB.getConnection();
            PreparedStatement ps = c.prepareStatement(GET_PLAYERS);
            ResultSet rs = ps.executeQuery()){
            List<Player> p = new ArrayList<>();

            while(rs.next()){
                p.add(resultsetProducts(rs));
            }
            return p;
        } catch (SQLException e){
            throw new IllegalArgumentException("No player were found");
        }
    }

    @Override
    public void addPlayers(Player p) {
        try(Connection c = ConnectDB.getConnection();
            PreparedStatement ps = c.prepareStatement(INSERT_PLAYERS, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, p.getName());
            ps.setString(2, p.getPassword());
            ps.executeUpdate();

            try (ResultSet autoId = ps.getGeneratedKeys()){
                autoId.next();
                p.setId(autoId.getInt(1));
            }

        } catch (SQLException e){
            throw new IllegalArgumentException("Player could not be inserted");
        }
    }

    private Player resultsetProducts(ResultSet rs) throws SQLException {
        return new Player(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
    }
}