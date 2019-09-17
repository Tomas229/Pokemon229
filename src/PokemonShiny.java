import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class will  calculate if  a set of pokemon are shiny or not
 * depending on the TID and SID of a trainer and the PID of the pokemon
 *
 * @author Tomas229
 * @since 0.1
 */
public class PokemonShiny {
    private int TID;
    private int SID;
    private List<Long> PID = new ArrayList<>();
    private List<Integer> shinies = new ArrayList<>();


    public PokemonShiny() {
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public List<Long> getPID() {
        return PID;
    }

    public void setPokemon(Long ... pid) {
        this.PID.clear();
        this.PID.addAll(Arrays.asList(pid).subList(0, pid.length));
    }

    public void setTrainer(int tid , int sid){
        this.setTID(tid);
        this.setSID(sid);
    }

    public boolean calculate() {
        for(int i = 0; i <this.getPID().size(); i++){

            String pid = "00000000000000000000000000000000".substring(Long.toBinaryString(this.getPID().get(i)).length()) + Long.toBinaryString(this.getPID().get(i));
            String s1 = pid.substring(0,16);
            String s2 = pid.substring(16,32);

            int p1 = Integer.parseInt(s1, 2);
            int p2 = Integer.parseInt(s2, 2);
            int S = this.getSID()^this.getTID()^p1^p2;

            if (S < 8){
                shinies.add(i);
            }
        }
        if (shinies.size()>0){
            return true;
        }
        return false;
    }

    public void results(){
        for(int i=0;i<this.shinies.size();i++){
            System.out.println(this.shinies.get(i));
        }
    }
}
