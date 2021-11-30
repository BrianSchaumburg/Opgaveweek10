package domain;

public class Controlepunt {
    private double breedteGraad, lengteGraad;
    private String naam;
    private boolean ehbo;
    public Controlepunt(String naam, double breedteGraad, double lengteGraad, boolean uitslag) {
        setNaam(naam);
        setBreedteGraad(breedteGraad);
        setLengteGraad(lengteGraad);
        this.ehbo = uitslag;
    }

    private void setNaam(String naam) {
        if(naam == null || naam.trim().isEmpty())
            throw new IllegalArgumentException();
        this.naam = naam;
    }
    private void setBreedteGraad(double breedteGraad)
    {
        if(breedteGraad<=50 || breedteGraad>=51)
            throw new IllegalArgumentException();
        this.breedteGraad = breedteGraad;
    }
    private void setLengteGraad(double lengteGraad)
    {
        if(lengteGraad<=4 || lengteGraad>=5)
            throw new IllegalArgumentException();
    }

    public double getBreedtegraad() {
        return breedteGraad;
    }

    public double getLengtegraad() {
        return lengteGraad;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isHeeftEHBOPost() {
        return ehbo;
    }


}
