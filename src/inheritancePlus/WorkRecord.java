package inheritancePlus;

/**
 * Created by shuxford on 06/05/2016.
 */
public class WorkRecord {
    private double hours;
    private int dayCode; //Monday = 1 through Sunday = 7
    private double agreedHourlyRate;

    public WorkRecord(double initHours, double initAgreedHourlyRate, int initDayCode){
        if (initHours > 0.0 && initHours <= 8.0)
            hours = initHours;

        if (initDayCode >= 1 && initDayCode <= 7)
            dayCode = initDayCode;

        if (initAgreedHourlyRate >= 0.0 && initAgreedHourlyRate <= 300)
            agreedHourlyRate = initAgreedHourlyRate;
    }

    public double getHours(){
        return hours;
    }

    public double getAgreedHourlyRate(){
        return agreedHourlyRate;
    }

    public int getDayCode(){
        return dayCode;
    }

    public String toString(){
        String retVal;

        retVal = "hours: " + hours + ", agreed rate " +
                agreedHourlyRate + ", day code: " + dayCode;

        return retVal;
    }

}
