import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        while(true) {
            String s = br.readLine();
            if(s.equals("end")) {
                break;
            }
            boolean isGood = false;

            boolean isVowel = false;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(vowel.contains(c)) {
                    isVowel = true;
                }
            }
            if(isVowel) {
                boolean isConsecutive = false;
                for(int i = 2; i < s.length(); i++) {
                    if(vowel.contains(s.charAt(i))&&vowel.contains(s.charAt(i-1))&&vowel.contains(s.charAt(i-2))) {
                        isConsecutive = true;
                    }
                    if(!vowel.contains(s.charAt(i))&&!vowel.contains(s.charAt(i-1))&&!vowel.contains(s.charAt(i-2))) {
                        isConsecutive = true;
                    }
                }
                if(!isConsecutive) {
                    boolean isSame = false;
                    for(int i = 1; i < s.length(); i++) {
                        if(s.charAt(i)==s.charAt(i-1)) {
                            if(s.charAt(i)!='e' && s.charAt(i)!='o') {
                                isSame = true;
                            }
                        }
                    }
                    if(!isSame) {
                        isGood = true;
                    }
                }
            }
            if(isGood) {
                sb.append('<').append(s).append("> is acceptable.").append('\n');
            } else {
                sb.append('<').append(s).append("> is not acceptable.").append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
