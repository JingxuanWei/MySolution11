package inheritancePlus;

import java.util.ArrayList;

/**
 * Created by shuxford on 06/05/2016.
 */
public class SalariedPlusOnCallEmployee extends SalariedEmployee {
    private ArrayList<WorkRecord> workRecords;
    private double [] schedule;

    //constructor
    public SalariedPlusOnCallEmployee(String initFirst, String initLast,
                                      String initSsn, double initSalary,
                                      double[] initSchedule){
        super(initFirst, initLast, initSsn, initSalary);

        workRecords = new ArrayList<WorkRecord>(10);
        schedule = initSchedule;
    }


    public void addWorkRecord(double addHours, double addAgreedHourlyRate, int addDayCode){
        WorkRecord newRecord = new WorkRecord(addHours, addAgreedHourlyRate, addDayCode);
        workRecords.add(newRecord);
    }

    //other methods
    @Override
    public double earnings(){
        double totalEarnings = 0;
        double totalCallInEarnings = 0;

        for (WorkRecord rec : workRecords){
            totalCallInEarnings += rec.getHours() * rec.getAgreedHourlyRate();
        }

        totalEarnings = super.earnings() + totalCallInEarnings ;

        return totalEarnings;
    }

    public boolean checkWorkRecords(){
        boolean ok = true;
        double dailyTotal = 0;

        for (int day = 1; day < schedule.length; day++){
            dailyTotal = 0.0;
            for (WorkRecord rec : workRecords){
                if (rec.getDayCode() == day)
                    dailyTotal += rec.getHours();
            }

            if (dailyTotal > schedule[day]) {
                ok = false;
                System.out.println("E R R O R - " + getFirstName() + " " + getLastName() + " exceeded allowed call in hours on day code " + day);
            }
        }

        return ok;
    }

    public String scheduleToString(){
        String retVal = "";

        for (int day = 1; day <= 7; day++)
            retVal += "day " + day + ": " + schedule[day] + " hrs  ";

        return retVal;
    }

    @Override
    public String toString(){
        String retVal = "";

        retVal = "call in plus " + super.toString() + "\n" + workRecords + "\n" + scheduleToString();

        return retVal;
    }
}
