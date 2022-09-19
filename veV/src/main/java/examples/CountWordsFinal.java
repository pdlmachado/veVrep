package examples;
// Exemplo do livro Effective Software Testing 

public class CountWordsFinal {
	public int count (String str) {
		// Conta quantas palavras terminam em r ou s
		if (str == null) {
			return -1;
		}
		int words = 0;
		char last = ' ';
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i)) &&
					(last == 's' || last == 'r')) {
				words++;
			}
			last = str.charAt(i);
		}
		if (last == 'r' || last == 's') {
			words++;
		}
		return words;
	}
}
