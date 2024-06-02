import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

	public static void main(String[] args) throws Exception {
		String string = br.readLine();
		int index = Integer.parseInt(br.readLine());
		bw.write(string.charAt(index - 1));
		bw.flush();
	}
}
