/**
 * Created by fowafolo
 * Date: 16/3/27
 * Time: 15:43
 */
public class XLSModel {

    private String year;
    private String month;
    private String day;
    private String expected;
    private String result;
    private String accurate;

    public XLSModel(){

    }

    public String toString() {
        return String.format("%s - %s - %s", year, month, day);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAccurate() {
        return accurate;
    }

    public void setAccurate(String accurate) {
        this.accurate = accurate;
    }
}
