package model;

import java.util.ArrayList;


public class CurrencyConverter
{
    public ArrayList<Currency> database = new ArrayList<Currency>();

    public CurrencyConverter()
    {
        database.add(new Currency("Yen",124.20));
        database.add(new Currency("US-Dollar",1.19));
    }

    public String getSign(int i)
    {
        return database.get(i).getName();
    }

    public double euroTo(String name, double euro)
    {
        double value = 1.0;

        for (Currency c: database)
        {
            if(c.getName().equals(name))
                value = c.getCurrency();
        }
        return euro * value;
    }

}
