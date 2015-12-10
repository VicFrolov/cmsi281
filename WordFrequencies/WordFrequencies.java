import java.util.HashMap;

public class WordFrequencies {
	HashMap map;
	HashSet set;

	public WordFrequencies() {

	}

	public static String[] clearHyphensAndSetDelimeters(String s) {
		return s.replaceAll("-", "").replaceAll("[^A-Za-z0-9]", " ").split(" ");
	}


	public static void main(String[] args) {


		String lol = "They're coming for y-ou!! ?Man I hope not!!.      l   l       @#1";
		String[] cleanString = clearHyphensAndSetDelimeters(lol);

		for  (String si : cleanString) {
			System.out.print("length : " + si.length() + " String: ");
			System.out.println(si);
		}
	}
}