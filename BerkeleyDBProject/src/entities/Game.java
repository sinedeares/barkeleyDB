package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey(sequence = "game_pk")
    private int id;
    private String result;
    private int spectators_number;
    private String date;
    private String time;
    private String referee;

    public Game() {
    }

    public Game(int id, String result, int spectators_number,
                String date, String time, String referee) {
        this.id = id;
        this.team_name = team_name;
        this.table_position = table_position;
        this.headcoach = headcoach;
        this.stadion = stadion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getSpectators_number() {
        return spectators_number;
    }

    public void setSpectators_number(int spectators_number) {
        this.spectators_number = spectators_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", spectators_number='" + spectators_number + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", referee='" + referee + '\'' +
                '}';
    }

}