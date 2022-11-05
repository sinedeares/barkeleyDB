package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

    @Entity
    public class Team {
        @PrimaryKey(sequence = "team_pk")
        private int id;
        private String team_name;
        private int table_position;
        private String headcoach;
        private String stadion;

        public Team() {
        }

        public Team(int id, String team_name, int table_position, String headcoach, String stadion) {
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

        public String getTeam_name() {
            return team_name;
        }

        public void setTeam_name(String mail) {
            this.team_name = team_name;
        }

        public int getTable_position() {
            return table_position;
        }

        public void setTable_position(int table_position) {
            this.table_position = table_position;
        }

        public String getHeadcoach() {
            return headcoach;
        }

        public void setHeadcoach(String firstName) {
            this.headcoach = headcoach;
        }

        public String getStadion() {
            return stadion;
        }

        public void setStadion(String lastName) {
            this.stadion = stadion;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "id=" + id +
                    ", team_name='" + team_name + '\'' +
                    ", table_position='" + table_position + '\'' +
                    ", headcoach='" + headcoach + '\'' +
                    ", stadion='" + stadion + '\'' +
                    '}';
        }

    }
