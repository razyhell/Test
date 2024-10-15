import java.util.Arrays;
import java.util.Scanner;
class Test2 {
    public int getIndex(String a) {
        int in = a.indexOf('+');
        if (in == (-1)) {
            in = a.indexOf('-');
            if (in == (-1)) {
                in = a.indexOf('/');
                if (in == (-1)) {
                    in = a.indexOf('*');
                }
            }
        }
        return in;
    }
    public boolean checkRome (String a) {
        boolean result = false;
        switch (a) {
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                result = true;
                break;
        }
        return result;
    }
    public boolean checkArabic (String a) {
        boolean result = false;
        switch(a) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                result = true;
                break;
            default:
                break;
        }
        return result;
    }
    public int calc (String a, String b, char z) {
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int result = 0;
        switch (z) {
            case '+':
                result = aa + bb;
                break;
            case '-':
                result = aa - bb;
                break;
            case '/':
                result = aa / bb;
                break;
            case '*':
                result = aa * bb;
                break;
        }
        return result;
    }
    public int calcRome (String a, String b, char z, String[]nums2) {
        int aa = 0;
        int bb = 0;
        int result = 0;
        for(int i = 0; i<nums2.length; i++) {
            if (a.equals(nums2[i])) {
                aa=i+1;
                break;
            }
        }
        for(int i = 0; i<nums2.length; i++) {
            if(b.equals(nums2[i])) {
                bb=i+1;
                break;
            }
        }
        switch (z) {
            case '+':
                result = aa + bb;
                break;
            case '-':
                result = aa - bb;
                break;
            case '/':
                result = aa / bb;
                break;
            case '*':
                result = aa * bb;
                break;
        }
        return result;
    }
}
public class Test {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your expression");
            String a = sc.nextLine();
            String[] nums2 = {"I", "II", "III", "IV",
                    "V", "VI", "VII", "VIII", "IX",
                    "X", "XI", "XII", "XIII", "XIV", "XV",
                    "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",};
            String[] nums3 = Arrays.copyOf(nums2, 10);
            String[] nums4 = {"I", "V", "X", "L", "C", "D", "M"};
            String[] nums5 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            Test2 object = new Test2();
            String first;
            try {
                first = a.substring(0, object.getIndex(a));
            } catch (RuntimeException e) {
                throw new NumberFormatException("Can't solve operation");
            }
            String second = a.substring(object.getIndex(a) + 1);
            char znak = a.charAt(object.getIndex(a));
            if(object.checkArabic(first)) {
                if (object.checkRome(second)) {
                    throw new NumberFormatException("Two numeral systems at once");
                }
                else if(object.checkArabic(second)) {
                    System.out.println(object.calc(first,second,znak));
                } else {
                    for(String num:nums4) {
                        if(second.contains(num)) {
                            throw new NumberFormatException("Not allowed by size (1-10)");
                        }
                    }
                    for(String num:nums5) {
                        if(second.contains(num)) {
                            throw new NumberFormatException("Not allowed by size (1-10)");
                        }
                    }
                    throw new RuntimeException("Something is wrong with second number's format");
                }
            }
            else if(object.checkRome(first)) {
                if(object.checkArabic(second)) {
                    throw new NumberFormatException("Two numeral systems at once");
                }
                else if(object.checkRome(second)) {
                    int result = object.calcRome(first,second,znak,nums2);
                    if(result<1) {
                        throw new NumberFormatException("Result is <1");
                    } else {
                        System.out.println(nums2[result-1]);
                    }
                } else {
                    for(String num:nums4) {
                        if(second.contains(num)) {
                            throw new NumberFormatException("Not allowed by size (1-10)");
                        }
                    }
                    for(String num:nums5) {
                        if(second.contains(num)) {
                            throw new NumberFormatException("Not allowed by size (1-10)");
                        }
                    }
                    throw new RuntimeException("Something is wrong with second number's format");
                }
            }
            else {
                for(String num:nums4) {
                    if(first.contains(num)) {
                        throw new NumberFormatException("Not allowed by size (1-10)");
                    }
                }
                for(String num:nums5) {
                    if(first.contains(num)) {
                        throw new NumberFormatException("Not allowed by size (1-10)");
                    }
                }
                throw new RuntimeException("Wrong format");
            }
        } while(true);
    }
}
