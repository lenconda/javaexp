package top.lenconda.java.experiment;

public class Convert {

    private String[] numberChars =
            new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private String[] integerMagnitudes = new String[]{"元", "拾", "佰", "千", "万", "亿"};
    private String[] decimalMagnitudes = new String[]{"角", "分", "毫", "厘"};

    private String input = "";
    private String integerResult = "";
    private String decimalResult = "";

    public Convert (String input) {
        this.input = input;
    }

    public String getChineseAmount() {
        ConvertUtil util = new ConvertUtil(input);
        String integerPart = util.getIntegerPart();
        String decimalPart = util.getDecimalPart();
        if (integerPart != "0") {
            boolean flag = false;
            for (int i = 0; i < integerPart.length(); i++) {
                if (integerPart.charAt(i) != '0') {
                    if (flag) {
                        this.integerResult += "零";
                        flag = false;
                    }
                    this.integerResult +=
                            (numberChars[integerPart.charAt(i) - '0']
                                    + integerMagnitudes[integerPart.length() - i - 1]);
                } else
                    flag = true;
            }
        }
        if (decimalPart != "0") {
            for (int j = 0; j < decimalPart.length(); j++) {
                this.decimalResult += (numberChars[decimalPart.charAt(j) - '0'] + decimalMagnitudes[j]);
            }
        }
        return this.integerResult + this.decimalResult;
    }

}
