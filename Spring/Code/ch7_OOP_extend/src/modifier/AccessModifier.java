package modifier;

public class AccessModifier {
    public static void main(String[] args) {
        Time t = new Time(12, 35, 30);
        System.out.println(t);
        //t.hour = 13; // 다른 클래스 이므로 해당 필드에 접근 할 수 없다.
        t.setHour(t.getHour()+1);
        System.out.println(t);
    }
}

class Time {
    private int hour, minute, second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            return;
        }
        this.hour=hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            return;
        }
        this.minute=minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            return;
        }
        this.second=second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
