package com.MPR.X.Manager;

import com.X.MPR.Domain.Actor;
import com.X.MPR.Service.ActorManager;

import org.junit.Test;



import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;

public class ActorManagerTest {
	
    private ActorManager actorManager;
    private static final String actorName = "Adam Mostkowiak ";
    private static final LocalDate actorDateOfBirth = LocalDate.of(1945, 9, 1);
    private static final String actorBiographhy = "Bio";

    public ActorManagerTest() throws SQLException, ClassNotFoundException
    {
        actorManager = new ActorManager();
    }

    @Test
    public void itCorrectlyCreatesNewActor() throws SQLException, ClassNotFoundException
    {
        Actor actor = new Actor();
        actor.setName(actorName);
        actor.setDateOfBirth(actorDateOfBirth);
        actor.setBiography(actorBiographhy);
        actorManager.create(actor);

        Actor lastActor = actorManager.getLast();

        assertEquals(actorName, lastActor.getName());
        assertEquals(actorDateOfBirth, lastActor.getDateOfBirth());
        assertEquals(actorBiographhy, lastActor.getBiography());
    }

    @Test
    public void itCorrectlyReturnsAllActors() throws SQLException, ClassNotFoundException
    {
        List<Actor> actors = actorManager.getActors();
        assertNotNull(actors);
    }

}
