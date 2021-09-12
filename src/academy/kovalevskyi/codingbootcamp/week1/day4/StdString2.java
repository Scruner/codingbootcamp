package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {

    public StdString2(char[] base) {
        super(base);
    }

    public StdString2() {
        super();
    }

    public StdString2(StdString2 that) {
        super(that);
    }

    public StdString2 toAsciiLowerCase() {
        char[] chArr = toCharArray().clone();
        for (int i = 0; i < toCharArray().length; i++) {
            chArr[i] = StringUtils.toAsciiLowercase(chArr[i]);
        }
        return new StdString2(chArr);
    }

    public StdString2 toAsciiUpperCase() {
        char[] chArr = toCharArray().clone();
        for (int i = 0; i < toCharArray().length; i++) {
            chArr[i] = StringUtils.toAsciiUppercase(chArr[i]);
        }
        return new StdString2(chArr);
    }

    public StdString2 subString(int from, int to) {
        char[] chArr = toCharArray().clone();
        if (from > to) {
            throw new IllegalArgumentException();
        }
        char[] chArrRsl = new char[to - from];
        int counter = 0;
        for (int i = from; i < to; i++) {
            chArrRsl[counter++] = chArr[i];
        }
        return new StdString2(chArrRsl);
    }

    public StdString2 concat(StdString2... that) {

        StdString1 stdStr1 = this;
        for (int i = 0; i < that.length; i++) {
            if (that[i].length() != 0) {
                stdStr1 = stdStr1.append(that[i]);
            }
        }
        return new StdString2(stdStr1.toCharArray());
    }
   /* if (that.length == 0) {
      return this;
    }
    char[] chArr = toCharArray().clone();
    int summLength = chArr.length;
    for (int i = 0; i < that.length; i++) {
      summLength = summLength + that[i].toCharArray().length;
    }
    char[] chArrRsl = new char[summLength];
    for (int i = 0; i < chArr.length; i++) {
      chArrRsl[i] = chArr[i];
    }
    int counter = chArr.length;
      for (int i = 0; i < that.length; i++) {
        for (int j = 0; j < that[i].toCharArray().length; j++) {
          chArrRsl[counter++] = that[i].toCharArray()[j];
        }
      }
      return new StdString2(chArrRsl);
  }*/

    public StdString2[] split(char separator) {
        int count = 1;
        for (int i = 0; i < length(); i++) {
            if (toCharArray()[i] == separator) {
                for (int j = i + 1; j < length(); j++) {
                    if (toCharArray()[j] != separator) {
                        count++;
                        break;
                    }
                }
            }
        }
        StdString2[] arrRls = new StdString2[count];
        StdString2 stdStr2 = this;
        for (int i = 0; i < count; i++) {
            arrRls[i] = stdStr2.subStrStartToFirstChar(separator);
            stdStr2 = stdStr2.subStrFirstCharToEnd(separator);
        }
        return arrRls;
    }

    public StdString2 subStrFirstCharToEnd(char ch) {
        return this.subString(this.indexOf(ch) + 1, this.length());
    }

    public StdString2 subStrStartToFirstChar(char ch) {
        int indexFrom = 0;
        int indexTo = this.indexOf(ch) == -1 ? this.length() : this.indexOf(ch);
        return this.subString(indexFrom, indexTo);
    }

    public StdString2 trim() {
        char[] chArr = toCharArray().clone();
        int counter = 0;
        for (int i = 0; i < toCharArray().length; i++) {
            if (chArr[i] == ' ') {
                counter++;
            } else {
                break;
            }
        }
        int counter2 = 0;
        for (int i = toCharArray().length - 1; i > 0; i--) {
            if (chArr[i] == ' ') {
                counter2++;
            } else {
                break;
            }
        }
        char[] arrRsl = new char[chArr.length - (counter + counter2)];
        System.arraycopy(chArr, counter, arrRsl, 0, arrRsl.length);
        return new StdString2(arrRsl);
    }

    public StdString2 removeCharacter(char toRemove) {
        char[] chArr = toCharArray().clone();
        int counter = 0;
        for (int i = 0; i < toCharArray().length; i++) {
            if (chArr[i] == toRemove) {
                counter++;
            }
        }
        char[] arrRsl = new char[chArr.length - counter];
        int counter2 = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] != toRemove) {
                arrRsl[counter2++] = chArr[i];
            }
        }
        return new StdString2(arrRsl);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(args[i]);
        }
    }
}

