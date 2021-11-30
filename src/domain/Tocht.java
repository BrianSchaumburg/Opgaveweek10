package domain;

import javax.sound.midi.ControllerEventListener;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Tocht {

    private LocalDate datum ;
    ArrayList<Deelnemer> deelnemers = new ArrayList<Deelnemer>();
    Controlepunt[] controlepunts;

    public Tocht(LocalDate datum, int controlepunten) {
       setDate(datum);
       checkPoints(controlepunten);

    }
    public Tocht(LocalDate datum)
    {
        checkPoints(15);
        setDate(datum);
    }
    private void setDate(LocalDate datum)
    {
        if(!datum.isAfter(LocalDate.now()))
        throw new IllegalArgumentException();
        this.datum = datum;
        datum.atTime(21,00)  ;



    }

    private void checkPoints(int points) {
        if(points<1)
            throw new IllegalArgumentException();
       this.controlepunts = new Controlepunt[points];
    }
    public int addControlPoint(Controlepunt punt)
    {
        if (punt == null) {


            throw new IllegalArgumentException();
        }
            int index = 0;

        for(int i = 0 ; i< controlepunts.length; i++ )
        {
            if(controlepunts[i]==null)
            {
                controlepunts[i] = punt;
                index = i;
                break;
            }
        }
        //check ehbo
        if(index!=0 && index != 1)
        {if(controlepunts[index-2].isHeeftEHBOPost() == false && punt.isHeeftEHBOPost() == false)
        {
            if(!controlepunts[index-1].isHeeftEHBOPost())
            {throw new IllegalStateException("De ehbo regeling klopt niet");

            }
        }

        }
        //check voor controlepunt
        if (!Arrays.stream(controlepunts).anyMatch(punt::equals)) {
            throw new IllegalStateException("Het object zit niet in de lijst");
        }
        return index;
    }
    public void addDeelnemer(Deelnemer deelnemer)
    {
        if (deelnemer == null) {
            throw new IllegalArgumentException();
        }

        deelnemers.add(deelnemer);
        deelnemer.setControlepunts(controlepunts.length);
    }
    //todo methode voltooid
    public int hoeveelVoltooid()
    {
        for(int i = 0; i< deelnemers.size(); i++ )
        {

        }
        return 0;
    }
}

