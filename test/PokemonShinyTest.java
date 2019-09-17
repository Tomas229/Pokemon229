import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PokemonShiny class
 * @author Tomas229
 * @since 0.1
 */
public class PokemonShinyTest {
    private PokemonShiny pokemonShiny;
    private  int expectedTID;
    private  int expectedSID;
    private List<Long> expectedPID;

    @BeforeEach
    public void setUp(){
        setPokemonShiny();
        setExpectedPID();

    }

    public PokemonShiny getPokemonShiny() {
        return pokemonShiny;
    }

    public void setPokemonShiny() {
        expectedTID = 24294;
        expectedSID = 38834;
        this.pokemonShiny = new PokemonShiny();
        this.pokemonShiny.setTrainer(getExpectedTID(),getExpectedSID());
        this.pokemonShiny.setPokemon(2814471828L, 2L ,3L);

    }

    public List<Long> getExpectedPID(){
        return expectedPID;
    }

    public void setExpectedPID(){
        expectedPID = new ArrayList<Long>();

        expectedPID.add(2814471828L);
        expectedPID.add(2L);
        expectedPID.add(3L);
    }


    public int getExpectedTID(){
        return expectedTID;
    }

    public int getExpectedSID(){
        return  expectedSID;
    }

    @Test
    public void constructorTest(){
        PokemonShiny pokemonTest = new PokemonShiny();

        assertEquals(0, pokemonTest.getTID());

        assertEquals(0, pokemonTest.getSID());

        assertEquals(new ArrayList<>(),pokemonTest.getPID());
    }

    @Test
    public void setTrainerTest(){
        assertEquals(getExpectedTID(),getPokemonShiny().getTID());
        assertEquals(24294, getPokemonShiny().getTID());

        assertEquals(getExpectedSID(), getPokemonShiny().getSID());
        assertEquals(38834, getPokemonShiny().getSID());

    }

    @Test
    public void setPokemonTest(){
        assertEquals(expectedPID, getPokemonShiny().getPID());
    }

    @Test

    public void calculateTest(){
        assertTrue(getPokemonShiny().calculate());
        getPokemonShiny().results();
    }


}
