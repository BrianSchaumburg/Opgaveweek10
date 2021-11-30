package domain;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Deelnemer {
    private LocalTime[] passTime;
    private String naam;

    public Deelnemer(String naam) {
        if(naam.isBlank())
            throw new IllegalArgumentException();
        this.naam = naam;
    }
    public void setControlepunts(int punten)
    {if(punten < 1)
        throw new IllegalArgumentException();
        passTime = new LocalTime[punten];

    }
    public int getAantalControlePunts(){
        return passTime.length;
    }
    public void addTime(int hour , int minutes, int seconds)
    {
        LocalTime localTime=LocalTime.of(hour,minutes,seconds);
        for (int i = 0; i < passTime.length; i++) {
            if(passTime[i]!=null)
            {
                passTime[i] = localTime;
                break;
            }
        }
    }
    public boolean finished()
    {
        return Arrays.stream(passTime).anyMatch(i->i!=null)? false: true;
    }
    public int lastCheckpoint()
    {int index = 0;
       for(int i =0; i< passTime.length; i++)
       {
           if(passTime[i]==null)
           {
               index = i;
               break;
           }
       }
       return index;
    }
    public int wandeltijd(String result)
    {int hours = 0, minutes = 0;

            for (int i = 1; i < passTime.length; i++) {
                if (passTime[i].getHour() > passTime[i - 1].getHour())
                    hours += passTime[i].getHour() - passTime[i - 2].getHour();
                if (passTime[i].getMinute() > passTime[i - 1].getMinute())
                    minutes += passTime[i].getMinute() - passTime[i - 2].getMinute();

            }
        if(result.equals("minutes")) {
            hours = hours * 60;
            minutes += hours;
            return minutes;
        }
        else if(result.equals("hours"))
            return hours;
        else throw new IllegalStateException();

    }
}
