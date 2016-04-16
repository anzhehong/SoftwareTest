package com.calculator;

/**
 * Created by fowafolo
 * Date: 16/4/16
 * Time: 15:55
 */
public class Calculate {

    static public double basicMonthFee = 25.0;
    static public double everyMinuteFee = 0.15;
    static public double overdueFineRate = 0.05;

    /**
     * 计算折扣率
     *
     * @param bill
     * @return
     */
    static private Bill setActualRate(Bill bill) {
        int totalNotPaid = bill.getTotalNotPaid();
        double minute = bill.getMinute();
        if (minute > 0 && minute <= 60) {
            if (totalNotPaid <= 1) {
                bill.setDiscountRate(0.01);
            }
        } else if (minute > 60 && minute <= 120) {
            if (totalNotPaid <= 2) {
                bill.setDiscountRate(0.015);
            }
        } else if (minute > 120 && minute <= 180) {
            if (totalNotPaid <= 3) {
                bill.setDiscountRate(0.02);
            }
        } else if (minute > 180 && minute <= 300) {
            if (totalNotPaid <= 3) {
                bill.setDiscountRate(0.025);
            }
        } else if (minute > 300) {
            if (totalNotPaid <= 6) {
                bill.setDiscountRate(0.03);
            }
        }
        return bill;
    }

    static public Bill getAmount(Bill bill) {
        bill = Calculate.setActualRate(bill);
        bill.setActualAmount(basicMonthFee + everyMinuteFee*bill.getDiscountRate() + overdueFineRate*bill.getHistoryAmount());
        return bill;
    }

}
