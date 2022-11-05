import com.sleepycat.persist.EntityCursor;
import config.Database;
import entities.Team;
import entities.Player;
import DAClasses.TeamDA;
import DAClasses.PlayerDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app {
    private static final Random random = new Random();

    public static void Lab3(){
        System.out.println("Lab 3 Starting");
        Database.setup();
        PlayerDA playerDA = new PlayerDA(Database.getStore());
        TeamDA teamDA = new TeamDA(Database.getStore());

        Team team = new Team();
        team.setId(0);

        TeamDA.save(team);

        Player one = new Player(
                0,
                team.getId(),
                "Ngolo",
                "Kante",
                "France",
                6,
                "midfielder",
                "center",
                30,
                168,
                66,
                45
        );

        Player two = new Player(
                0,
                team.getId(),
                "Ben",
                "Chilwell",
                "England",
                4,
                "defender",
                "left",
                25,
                177,
                70,
                50
        );

        Player three = new Player(
                0,
                team.getId(),
                "Pierre",
                "Aubameyang",
                "Gabon",
                11,
                "Forward",
                "center",
                32,
                178,
                66,
                30
        );

        playerDA.save(one);
        playerDA.save(two);
        playerDA.save(three);

        List<Player> players = playerDA.get();
        System.out.println("Players: ");
        System.out.println(players);

        System.out.println("Player with id = 2: ");
        System.out.println(playerDA.get(2));


        System.out.println("Player for team with id = 1: ");
        System.out.println(playerDA.getByTeamID(1));

        System.out.println(playerDA.delete(2));
        System.out.println(playerDA.update(one));

        System.out.println("Player after deleting and updating: ");
        System.out.println(playerDA.get());
    }

    public static void Lab4() {

        Database.setup();
        PlayerDA playerDA = new PlayerDA(Database.getStore());
        TeamDA teamDA = new TeamDA(Database.getStore());

        Team team = new Team();
        TeamDA.save(team);
        team = new Team();
        TeamDA.save(team);

        System.out.println("Teams: ");
        System.out.println(teamDA.get());

        for (int i = 0; i < 4; i++){
            Player player = new Player(
                    0,
                    1,
                    "Pierre",
                    "Aubameyang",
                    "Gabon",
                    11,
                    "Forward",
                    "center",
                    32,
                    178,
                    66,
                    30
            );
            playerDA.save(player);
        }

        int target = 5;

        try (EntityCursor<Player> entityCursor = playerDA.cursor()) {
            for (Player player: entityCursor){
                if (player.getId() == target)
                {
                    System.out.println("Found player with target id: ");
                    System.out.println(player);
                }
            }
        }

        target = 2;

        System.out.println("Players before updating: ");
        System.out.println(playerDA.get(target));

        try (EntityCursor<Players> entityCursor = playerDA.cursor()) {
            for (Players player: entityCursor){
                if (player.getId() == 2)
                {
                    entityCursor.update(player);
                }
            }
        }

        System.out.println("Players after updating: ");
        System.out.println(playerDA.get(target));
    }

        public static void main(String[] args) {
            Lab3();
            Lab4();
    }
}
