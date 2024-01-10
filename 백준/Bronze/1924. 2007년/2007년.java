import static java.lang.System.in;
import static java.lang.System.out;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");

        int x = Integer.parseInt(read[0]);
        int y = Integer.parseInt(read[1]);

        LocalDate localDate = LocalDate.of(2007, x, y);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (dayOfWeek == MONDAY) {
            bw.write("MON");
        } else if (dayOfWeek == TUESDAY) {
            bw.write("TUE");
        } else if (dayOfWeek == WEDNESDAY) {
            bw.write("WED");
        } else if (dayOfWeek == THURSDAY) {
            bw.write("THU");
        } else if (dayOfWeek == FRIDAY) {
            bw.write("FRI");
        } else if (dayOfWeek == SATURDAY) {
            bw.write("SAT");
        } else if (dayOfWeek == SUNDAY) {
            bw.write("SUN");
        }
        bw.flush();
    }
}
