#include "stdio.h"

void Predict  (int year, int month, int day) {
	int dayOfMonth [12] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int nextYear = year, nextMonth = month, nextDay = day+1;

	if((year%4==0 && year%100 !=0) || year%400 ==0)
    {
        dayOfMonth[1] =29;
    }

    if(month>12 || day>dayOfMonth[month-1])
    {
        printf("Something Wrong of Your Input!\n");
    }else {

    	if(day==dayOfMonth[month-1])
    	{
        	nextDay = 1;
       	 	nextMonth = month+1;
  	  	}
  	  	if(month==12)
   	 	{
   	 		nextYear += 1;
   	 		nextMonth = 1;
   	 	}
  		printf("%d年%d月%d日\n", nextYear, nextMonth, nextDay);
    }
}

