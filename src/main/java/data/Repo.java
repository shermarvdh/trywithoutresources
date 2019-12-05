package data;

public class Repo {
    private static final PlayerRepo PLAYER_REPO = new SQLPlayerRepo();

    public Repo() {
    }

    public static PlayerRepo getPlayerRepo() {
        return PLAYER_REPO;
    }
}
