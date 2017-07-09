package inheritancePlus;

/**
 * Created by shuxford on 06/05/2016.
 */

public class SalariedPlusOnCallEmployeeDriver {
    public static void main(String[] args) {
        double[] thisWeeksSchedule = {0.0, 0.0, 0.0, 4.0, 0.0, 0.0, 0.0, 2.0}; //0th index not used Monday is 1 etc.

        SalariedPlusOnCallEmployee salCallIn =
                new SalariedPlusOnCallEmployee("John", "Callin", "555-55-5555", 2000.00, thisWeeksSchedule);

        salCallIn.addWorkRecord(4.1, 100.0, 3);
        salCallIn.addWorkRecord(2.0, 200.0, 7);

        System.out.println(salCallIn);

        if (salCallIn.checkWorkRecords())
            System.out.println("earnings: " + salCallIn.earnings());
        else
            System.out.println("E R R O R - Schedule violation");
    }

}

