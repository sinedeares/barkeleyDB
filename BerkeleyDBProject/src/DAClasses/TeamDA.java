package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import entities.Team;

import java.util.List;
import java.util.Map;

public class TeamDA {
    // Index Accessors
    PrimaryIndex<Integer, Team> id;

    public TeamDA(EntityStore store) throws DatabaseException {

        // Primary key for Customer class
        id = store.getPrimaryIndex(Integer.class, Team.class);
    }

    public List<Team> get(){
        return this.id.map().values().stream().toList();
    }

    public static Team save(Team team){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        team.setId(id);
        return this.id.put(team);
    }

}
