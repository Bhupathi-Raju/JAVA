import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zemoso on 12/7/17.
 */

public class KycForm {
    private SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
    private Calendar anniversary = Calendar.getInstance();
    private Calendar beginningOfRange;
    private Calendar endOfRange;

    /**
     * This method sets the Anniversary Date and the beginning of the range and end of the range.
     * @param signUp  signUp gives the signUp date of the customer
     * @param current current gives the current date the customer is in
     */
    private void setAnniversary(Calendar signUp, Calendar current) {
        anniversary.set(Calendar.DATE, signUp.get(Calendar.DATE));
        anniversary.set(Calendar.MONTH, signUp.get(Calendar.MONTH));
        anniversary.set(Calendar.YEAR, current.get(Calendar.YEAR));
        beginningOfRange = (Calendar) anniversary.clone();
        endOfRange = (Calendar) anniversary.clone();
        beginningOfRange.add(Calendar.DATE, -30);
        endOfRange.add(Calendar.DATE, +30);
    }

    /**
     * This method sets the beginning of the range.
     *
     * @param yearValue  The yearValue takes the value of how many years u want to move back/front.
     * @param monthValue The monthValue takes the value of how many months u want to move back/front.
     * @return this method returns the beginning of the range
     */
    private Calendar setRangeBeginning(int yearValue, int monthValue) {
        Calendar beginningOfRange1;
        beginningOfRange1 = (Calendar) beginningOfRange.clone();
        beginningOfRange1.add(Calendar.YEAR, +yearValue);
        beginningOfRange1.add(Calendar.DATE, +monthValue);
        return beginningOfRange1;
    }

    /**
     * @param yearValue The yearValue takes the value of how many years u want to move back/front.
     * @param mothValue The monthValue takes the value of how many months u want to move back/front.
     * @return returns the ending of the range
     */
    private Calendar setRangeEnding(int yearValue, int mothValue) {
        Calendar endOfRange1 = (Calendar) endOfRange.clone();
        endOfRange1.add(Calendar.YEAR, +yearValue);
        endOfRange1.add(Calendar.DATE, +mothValue);
        return endOfRange1;
    }

    /**
     * This method prints out the range of dates the customer can fill on the form
     *
     * @param signUpDate  This takes string mentioning the signUp date of the customer.
     * @param currentDate This takes string mentioning the current date the customer is in.
     * @throws ParseException throws an exception when date is entered wrong or in wrong format.
     */
    public String getRange(String signUpDate, String currentDate) throws ParseException {
        Calendar signUp = Calendar.getInstance();
        Calendar current = Calendar.getInstance();
        signUp.setTime(form.parse(signUpDate));
        current.setTime(form.parse(currentDate));
        if (signUp.after(current)) {
           return "No range";
            //System.exit(0);
        }
        setAnniversary(signUp, current);
        if (current.after(beginningOfRange) && current.before(endOfRange))
        {
            return form.format(beginningOfRange.getTime()) + " " + form.format(current.getTime());
        }
        else if (current.after(endOfRange))
        {
            Calendar beginningOfRangeOfNextYear = setRangeBeginning(+1, -30);
            if (current.after(beginningOfRangeOfNextYear))
               return form.format(setRangeBeginning(+1, 0).getTime()) +
                " " + form.format(setRangeEnding(+1, +30).getTime());
            else {
                return form.format(beginningOfRange.getTime()) + " " + form.format(endOfRange.getTime());
            }
        }
        else if(current.before(beginningOfRange))
        {
            Calendar beginningOfRangeMinusThirty = setRangeBeginning(+0, -30);
            if (current.after(beginningOfRangeMinusThirty))
                return form.format(beginningOfRange.getTime()) + " " +
                        form.format(setRangeEnding(+0, +30).getTime());
            else {
                Calendar previousYearRangeBeginning = setRangeBeginning(-1, 0);
                Calendar previousYearRangeEnding = setRangeEnding(-1, 0);
                if (previousYearRangeBeginning.before(signUp)) {
                    return "No range";
                }
                return form.format(previousYearRangeBeginning.getTime()) + " " +
                        form.format(previousYearRangeEnding.getTime());
            }
        }
        else
                return form.format(current.getTime())+" "+
                     form.format(current.getTime());

    }
}
