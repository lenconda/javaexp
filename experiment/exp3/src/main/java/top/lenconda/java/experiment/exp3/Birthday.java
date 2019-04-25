package top.lenconda.java.experiment.exp3;

public class Birthday {

    public StringBuffer birthDay;
    public int year = 0;
    public int month = 0;
    public int day = 0;
    private int[] monthNormalMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] monthLeapMaxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Birthday(String birthdayString) {
        this.birthDay = new StringBuffer(birthdayString);
        this.year = Integer.parseInt(this.birthDay.substring(0, 4));
        this.month = Integer.parseInt(this.birthDay.substring(4, 6));
        this.day = Integer.parseInt(this.birthDay.substring(6, 8));
    }

    private boolean isLeapYear () {
        if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
            return true;
        else
            return false;
    }

    public boolean validate () {
        if (this.day > 0 && this.month < 12 && this.month > 0 && this.year > 0) {
            if (this.isLeapYear())
                return this.day <= this.monthLeapMaxDays[this.month - 1];
            else
                return this.day <= this.monthNormalMaxDays[this.month - 1];
        }
        return false;
    }

    public String getString () {
        return this.year + "年" + this.month + "月" + this.day + "日";
    }

}
