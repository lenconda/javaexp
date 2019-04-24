package top.lenconda.java.experiment;

class ConvertUtil {

    public ConvertUtil (String input) {
        if (this.validateAmount(input)) {
            this.amount = this.trimAmount(input);
            this.isPureInteger = !this.isDotExist(input);
            if (this.getIntegerPart().length() > 8 || this.getDecimalPart().length() > 4)
                throw new Error("Amount out of range");
        }
        else
            throw new Error("Not a valid amount");
    }

    private String amount = "0";
    private boolean isPureInteger = false;

    private boolean validateAmount (String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) < '0' || input.charAt(i) > '9') && input.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    private String trimAmount (String amount) {
        return amount.replaceAll("^(0+)|(0+)$", "");
    }

    private boolean isDotEnd () {
        return this.amount.charAt(this.amount.length() - 1) == '.';
    }

    private boolean isDotStart () {
        return this.amount.charAt(0) == '.';
    }

    private boolean isDotExist (String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.')
                return true;
        }
        return false;
    }

    public String getIntegerPart () {
        if (this.isDotStart())
            return "0";
        else if (this.isPureInteger)
            return this.amount;
        else
            return this.amount.split("\\.")[0];
    }

    public String getDecimalPart () {
        if (this.isDotEnd() || this.isPureInteger)
            return "0";
        else
            return this.amount.split("\\.")[1];
    }

}
