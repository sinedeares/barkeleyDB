package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Player {
    @PrimaryKey(sequence = "player_pk")
    private int id;

    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Team.class, name = "team")
    private int teamId;

    private String player_name;
    private String player_surname;
    private String nationality;
    private int football_number;
    private String field_position;
    private String specialization;
    private int age;
    private int height;
    private int weight;
    private int price;




    public Player() {
    }

    public Player(int id, int teamID, String player_name, String player_surname, String nationality,
                  int football_number, String field_position, String specialization, int age, int height,
                  int weight, int price) {
        this.id = id;
        this.teamID = teamID;
        this.player_name = player_name;
        this.player_surname = player_surname;
        this.nationality = nationality;
        this.football_number = football_number;
        this.field_position = field_position;
        this.specialization = specialization;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamID;
    }

    public void setTeamId(int teamID) {
        this.teamID = teamID;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_surname() {
        return player_surname;
    }

    public void setPlayer_surname(String player_surname) {
        this.player_surname = player_surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getFootball_number() {
        return football_number;
    }

    public void setFootball_number(int football_number) {
        this.football_number = football_number;
    }

    public String getField_position() {
        return field_position;
    }

    public void setField_position(String field_position) {
        this.field_position = field_position;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", teamID='" + teamID + '\'' +
                ", player_name='" + player_name + '\'' +
                ", player_surname='" + player_surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", football_number='" + football_number + '\'' +
                ", field_position='" + field_position + '\'' +
                ", specialization='" + specialization + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}

