package com.giti.coronatracker;

public class CoronaDetail
{
    private String Message;

    private Countries[] Countries;

    private Global Global;

    private String Date;

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public Countries[] getCountries ()
    {
        return Countries;
    }

    public void setCountries (Countries[] Countries)
    {
        this.Countries = Countries;
    }

    public Global getGlobal ()
    {
        return Global;
    }

    public void setGlobal (Global Global)
    {
        this.Global = Global;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Message = "+Message+", Countries = "+Countries+", Global = "+Global+", Date = "+Date+"]";
    }
}