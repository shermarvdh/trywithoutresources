package ui.fx;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import data.Repo;
import domain.Player;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ShowPlayersController {
    private List<Player> players = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea ta_allPlayers;

    @FXML
    void initialize() {
        assert ta_allPlayers != null : "fx:id=\"ta_allPlayers\" was not injected: check your FXML file 'Untitled'.";
        players = Repo.getPlayerRepo().getPlayers();
    }

    @FXML
    void addPlayersToTextArea(){
        for(Player player : players){
            ta_allPlayers.setText(player.toString());
        }
    }
}
