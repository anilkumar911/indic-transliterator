//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Transliterate {
	static final int HIN_UNICODE_START = 0x0900;
	static final int KAN_UNICODE_START = 0x0C80;
	static final int TAM_UNICODE_START = 0x0B80;
	static final int BEN_UNICODE_START = 0x0980;

	static HashMap<String, Integer> map;

	static boolean isLanguage(char c, int LangFirstUnicode) {
		int numSymbolsInLanguage = 0x097F - 0x0900;
		return (c >= LangFirstUnicode && c <= (LangFirstUnicode+(numSymbolsInLanguage)));
	}

	public static String transliterate(String text, int fromLanguage, int toLanguage) {
		String word = "";
		for (char c : text.toCharArray()) {
			if (isLanguage(c, fromLanguage)) {
				int in = (int) c;
				in = in - fromLanguage + toLanguage;
				c = (char) in;
			}
			word += "" + c;
		}
		return word;
	}

	public static String transliterateKannadaToHindi(String text) {
		return transliterate(text, KAN_UNICODE_START, HIN_UNICODE_START);
	}

	public static void main(String[] args) throws IOException {
		map = new HashMap<>();
		map.put("HIN", HIN_UNICODE_START);
		map.put("KAN", KAN_UNICODE_START);
		map.put("BEN", BEN_UNICODE_START);

		int fromLanguage = map.get(args[0]);
		int toLanguage = map.get(args[1]);
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String transliteratedString = transliterate(scanner.nextLine(), fromLanguage, toLanguage);
			System.out.println(transliteratedString);
		}
	}
}
