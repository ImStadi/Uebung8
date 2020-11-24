package model;

public class Currency
{
    double currency;
    String name;

    public String getName(){return name;}

    public double getCurrency(){return currency;}

    public Currency(String name, double currency)
    {
        this.name =name;
        this.currency = currency;
    }
}
