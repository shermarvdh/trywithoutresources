package ui;

import data.Repo;
import domain.Player;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        new Program().makePlayer();
    }

    private void getPlayer(){
        List<Player> players = new ArrayList<>();
        players = Repo.getPlayerRepo().getPlayers();

        for ( Player player : players) {
            System.out.println(player);
        }
    }

    private void makePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a user");
        String user = sc.nextLine();

        System.out.println("Input a password");
        String password = sc.nextLine();

        password = BCrypt.hashpw(password, BCrypt.gensalt());
        Player p = new Player(user, password);
        Repo.getPlayerRepo().addPlayers(p);
    }
}
