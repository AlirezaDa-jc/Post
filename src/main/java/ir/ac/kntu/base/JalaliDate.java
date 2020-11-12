/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.base;


public class JalaliDate implements Comparable<JalaliDate> {

    private int d, m, y;

    public JalaliDate(String date) {
        int D, M, Y;
        String[] split = date.split("-");
        D = Integer.parseInt(split[2]);
        M = Integer.parseInt(split[1]);
        Y = Integer.parseInt(split[0]);
        setDate(D, M, Y);
    }

    public JalaliDate(int D, int M, int Y) {
        setDate(D, M, Y);
    }

    public int getDay() {
        return d;
    }

    public int getMonth() {
        return m;
    }

    public int getYear() {
        return y;
    }

    public void setDay(int d) {
        if (m <= 6) {
            if (d > 31) {
                d = 31;
            }
        } else if (m < 12 || isLeapYear()) {
            if (d > 30) {
                d = 30;
            }
        } else {
            if (d > 29) {
                d = 29;
            }
        }
        this.d = d;
    }

    private boolean isLeapYear() {
        return y % 4 == 3;
    }

    public void setMonth(int m) {
        if (m > 12) {
            m = 12;
        } else if (m < 1) {
            m = 1;
        }
        this.m = m;
    }

    public void setYear(int y) {
        if (y < 1300) {
            y = 1300;
        } else if (y > 1400) {
            y = 1400;
        }
        this.y = y;
    }

    private void setDate(int D, int M, int Y) {
        setDay(D);
        setMonth(M);
        setYear(Y);
    }

    @Override
    public String toString() {
        String month = String.format("%02d", m);
        String day= String.format("%02d", d);
        String year= String.format("%04d", y);
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(JalaliDate other) {
        if(this.y!=other.y) {
            return this.y - other.y;
        }
        if(m!=other.m) {
            return this.m - other.m;
        }
        return d-other.d;
    }

}



