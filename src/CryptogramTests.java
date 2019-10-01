
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class CryptogramTests {

	@Test
	void test() {
		ByteArrayInputStream in = new ByteArrayInputStream("hint".getBytes());
		System.setIn(in);
		String[] args = null;	
		Cryptograms.main(args);
	}
	
	@Test
	void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("freq".getBytes());
		System.setIn(in);
		String[] args = null;	
		Cryptograms.main(args);
	}
	
	@Test
	void test3() {
		ByteArrayInputStream in = new ByteArrayInputStream("replace a by b".getBytes());
		System.setIn(in);
		String[] args = null;	
		Cryptograms.main(args);
	}
	
	@Test
	void test4() {
		ByteArrayInputStream in = new ByteArrayInputStream("a = b".getBytes());
		System.setIn(in);
		String[] args = null;	
		Cryptograms.main(args);
	}
	
	@Test
	void test_check_valid() {
		String quote = Cryptograms.getquote();
		String[] command = quote.toUpperCase().trim().split(" ");
		Cryptograms.check_valid(command[1], command[3]);
		Cryptograms.check_valid("asdf", "s");
		Cryptograms.check_valid(".", "s");
		Cryptograms.help();
		
	}
	
	@Test
	void test_encryption() {
		String quote = Cryptograms.getquote();
		HashMap<Character, Character> cryptogram = new HashMap<Character, Character>();
		Cryptograms.encryption(cryptogram, quote);
	}
	
	@Test
	void test_decryption() {
		String quote = Cryptograms.getquote();
		HashMap<Character, Character> cryptogram = new HashMap<Character, Character>();
		String encrypted_quotes = Cryptograms.encryption(cryptogram, quote);
		Cryptograms.decryption(encrypted_quotes, cryptogram, quote);
	}
	
	@Test
	void test_hint() {
		String quote = Cryptograms.getquote();
		HashMap<Character, Character> cryptogram = new HashMap<Character, Character>();
		String encrypted_quotes = Cryptograms.encryption(cryptogram, quote);
		ArrayList<Character> guess_str = new ArrayList<Character>();
		for(int i = 0; i < encrypted_quotes.length(); i++) {
			if(Pattern.matches("\\p{Punct}", Character.toString(encrypted_quotes.charAt(i)))) {
				guess_str.add(i, encrypted_quotes.charAt(i));
			}else {
				guess_str.add(i, ' ');
			}
		}
		Cryptograms.hint(cryptogram, encrypted_quotes, guess_str, quote);
	}
	
	@Test
	void test_print_freq() {
		String quote = Cryptograms.getquote();
		HashMap<Character, Character> cryptogram = new HashMap<Character, Character>();
		String encrypted_quotes = Cryptograms.encryption(cryptogram, quote);
		Cryptograms.print_freq(encrypted_quotes);
	}

}
