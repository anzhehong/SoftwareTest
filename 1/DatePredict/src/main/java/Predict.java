/**
 * Created by caopeng on 16/3/19.
 */
public class Predict {
    public String predictTheNextDay(int year, int month, int day){
        int[] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int nextYear=year, nextMonth=month, nextDay=day+1;

        if((year%4==0 && year%100 !=0) || year%400 ==0)
        {
            dayOfMonth[1] =29;
        }
        if(month>12 || day>dayOfMonth[month-1] || day <= 0 || year < 0 )
        {
            return "false";
        }else {
            if(day==dayOfMonth[month-1])
            {
                nextDay = 1;
                nextMonth = month+1;
                if (month==12)
                {
                    nextYear += 1;
                    nextMonth = 1;
                }
            }
        }
        return nextYear+" "+nextMonth+" "+nextDay;
    }
}
