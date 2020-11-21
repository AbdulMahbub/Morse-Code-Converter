import java.util.*;

public class morseCode {
    public static void main(String[] args) {

        System.out.println("Please enter a phrase: ");
        Scanner input= new Scanner(System.in);
        String secret=input.nextLine();

        System.out.println("Morse Code:");
        System.out.println(codeMake(secret));


        String[] morseKey= {"-----",".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.",".-", "-...", "-.-.",
                "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        char[] englo= new char[36];
        for(int i=0;i<36;i++)
        {
            if(i<10)
            {
                englo[i]=(char)(i+'0');
                continue;
            }

            else
            {
                englo[i]= (char)(i+55);
            }

        }


        System.out.println("Please enter a morse code: ");
        input= new Scanner(System.in);
        String code=input.nextLine();

        System.out.println("Hidden message is:");
        System.out.println(codeBreak(code,morseKey,englo));
    }

    // Method for code to string
    public static String codeBreak(String code, String[] morse, char[] symbols)
    {
        String ans="";
        String temp="";     // str1.equals(str2)
        String code2="";

        // Loop to handle the whitespace
        for(int i=0;i<code.length();i++)
        {
            if(code.charAt(i)==' ' && code.charAt(i+1)==' ')
            {
                code2+="*";
                i+=2;
                continue;
            }

            code2+=code.charAt(i);
        }

        // Loop to go thru morse code and get the letters
        for(int i=0;i<code2.length();i++)
        {
            if(code2.charAt(i)==' ')
            {
                for(int x=0;x< morse.length;x++)
                {
                    if(temp.equals(morse[x]))
                    {
                        ans+=symbols[x];
                        temp="";
                        break;
                    }
                }
                continue;

            }

            if(code2.charAt(i)=='*')
            {
                for(int x=0;x< morse.length;x++)
                {
                    if(temp.equals(morse[x]))
                    {
                        ans+=symbols[x];
                        ans+=" ";
                        temp="";
                        break;
                    }
                }
                continue;

            }

            temp+=code2.charAt(i);

            if(i==code2.length()-1)
            {
                for(int x=0;x< morse.length;x++)
                {
                    if(temp.equals(morse[x]))
                    {
                        ans+=symbols[x];
                        temp="";
                        break;
                    }
                }
            }
        }

        return ans;
    }

    // Method for string to code
    public static String codeMake(String secret)
    {
        String ans="";
        int i=0;

        while(i<secret.length())
        {

            switch(secret.charAt(i))
            {
                case 'a':
                    ans+=".- ";
                    break;
                case 'b':
                    ans+="-... ";
                    break;
                case 'c':
                    ans+="-.-. ";
                    break;
                case 'd':
                    ans+="-.. ";
                    break;
                case 'e':
                    ans+=". ";
                    break;
                case 'f':
                    ans+="..-. ";
                    break;
                case 'g':
                    ans+="--. ";
                    break;
                case 'h':
                    ans+=".... ";
                    break;
                case 'i':
                    ans+=".. ";
                    break;
                case 'j':
                    ans+=".--- ";
                    break;
                case 'k':
                    ans+="-.- ";
                    break;
                case 'l':
                    ans+=".-.. ";
                    break;
                case 'm':
                    ans+="-- ";
                    break;
                case 'n':
                    ans+="-. ";
                    break;
                case 'o':
                    ans+="--- ";
                    break;
                case 'p':
                    ans+=".--. ";
                    break;
                case 'q':
                    ans+="--.- ";
                    break;
                case 'r':
                    ans+=".-. ";
                    break;
                case 's':
                    ans+="... ";
                    break;
                case 't':
                    ans+="- ";
                    break;
                case 'u':
                    ans+="..- ";
                    break;
                case 'v':
                    ans+="...- ";
                    break;
                case 'w':
                    ans+=".-- ";
                    break;
                case 'x':
                    ans+="-..- ";
                    break;
                case 'y':
                    ans+="-.-- ";
                    break;
                case 'z':
                    ans+="--.. ";
                    break;
                case '0':
                    ans+="----- ";
                    break;
                case '1':
                    ans+=".---- ";
                    break;
                case '2':
                    ans+="..--- ";
                    break;
                case '3':
                    ans+="...-- ";
                    break;
                case '4':
                    ans+="....- ";
                    break;
                case '5':
                    ans+="..... ";
                    break;
                case '6':
                    ans+="-.... ";
                    break;
                case '7':
                    ans+="--... ";
                    break;
                case '8':
                    ans+="---.. ";
                    break;
                case '9':
                    ans+="----. ";
                    break;
                default:
                    ans+="  ";
            }

            i++;
        }

        String temp="";

        //Eliminate whitespace at the end
        for(int j=0;j<ans.length()-1;j++)
            temp+=ans.charAt(j);

        ans=temp;
        return ans;
    }
}
