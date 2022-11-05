package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class PlayerDA {
    // Index Accessors
    PrimaryIndex<Integer, Player> id;
    SecondaryIndex<Integer, Integer, Player> teamID;

    public PlayerDA(EntityStore store) throws DatabaseException {

        // Primary key for Team class
        id = store.getPrimaryIndex(Integer.class, Player.class);
        teamID = store.getSecondaryIndex(id, Integer.class, "team");
    }
    public EntityCursor<Player> cursor(){
        return this.id.entities();
    }

    public List<Player> get(){
        return this.id.map().values().stream().toList();
    }

    public Player get(Integer id){
        return this.id.get(id);
    }

    public List<Player> getByTeamID(Integer teamID){
        EntityJoin<Integer, Player> join = new EntityJoin<>(this.id);
        join.addCondition(this.teamID, teamID);
        try (ForwardCursor<Player> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public Player save(Player player){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        player.setId(id);
        return this.id.put(player);
    }


    public Player update(Player player){
        return this.id.put(player);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }
}
