package rekurencja2;

import javax.swing.JOptionPane;

  
  public class Anagrams {
	  
      private static StringBuffer sb = new StringBuffer();;

	public static void main(String[] args) {
    	  String word = "";
          word = JOptionPane.showInputDialog("Podaj s³owo do utworzenia anagramów: ", word);
          printAnagrams("", word);
          
          String message = sb.toString();
          JOptionPane.showMessageDialog (null, message, "Wykryte anagramy", JOptionPane.INFORMATION_MESSAGE);
      }
  
      public static void printAnagrams(String prefix, String word) {
    	  
    	  if(word.length() <= 1) {
              System.out.println(prefix + word);
              sb.append(prefix + word + "\n");
          } else {
              for(int i = 0; i < word.length(); i++) {
                  String cur = word.substring(i, i + 1);
                  String before = word.substring(0, i); // letters before cur
                  String after = word.substring(i + 1); // letters after cur
                  printAnagrams(prefix + cur, before + after);
              }
          }
      }
  }
