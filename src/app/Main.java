package interpreter;
import java.util.Scanner;
public class Main 
{

    public static void main(String[] args) 
    {
        Lexicon lex = new Lexicon();
        
        System.out.println(encodeInput(lex));
        System.out.println(decodeInput());
    }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
    public static String decode(String word) 
    {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    String output=word;
    for(char v: vowels)
    {
        if(word.contains("ent") && word.charAt(word.indexOf("ent")-1)== v)
        {
            output=output.replaceFirst("ent","");
        }
        if(word.contains("ingy"))
        {
            output=output.replace("ingy","");
        }
    }
    return output;
  }

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
    public static String decodeMessage(String message) 
    {
        String output="";
        int x=0;
        for(int i=0; i<message.length()-1;i++)
        {
            if(message.charAt(i)==' ')
            {
                output+=decode(message.substring(x,i));
                x=i;
            }
            
        }
        output+=decode(message.substring(x));
        return output;
    }

  /**
   * This method uses the decode(String) and a Scanner to decode a word specified
   * by the user.
   */
    public static String decodeInput() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter stuff in Lexicon:");
        String stuff = input.nextLine();
        return decodeMessage(stuff);
    }
    public static String encodeInput(Lexicon lex)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter stuff in English:");
        String stuff = input.nextLine();
        return lex.translate(stuff);
    }
    
}