package week_9_demo.reflection;

import java.io.*;
import java.util.Scanner;

public class HangManGame implements Serializable {
    static final long serialVersionUID = 101L;
    transient int wordsPerSession=0; //Record the number of words played after a load

    private char[] theWord;
    private boolean[] found;
    private String[] words={"forty","nine","undefeated","playing","the","arsenal","way"};
    private int pos=0;
    static private int livesPerWord=5;
    public boolean setNewWord(){
        if(pos<words.length) {
            theWord = words[pos++].toCharArray();
            found = new boolean[theWord.length];
            return true;
        }
        return false;
    }

    public boolean playWord(){
        Scanner scanner=new Scanner(System.in);
        boolean won=false;
        System.out.println(" Silly hangman game to demonstrate week_9_demo.serialisation");
        System.out.println(" you have "+livesPerWord+" lives");
        System.out.println(" your word has "+found.length);
        int livesUsed=0;
        while(!won && livesUsed<=livesPerWord){
            System.out.print("Lives left = "+(livesPerWord-livesUsed)+" WORD: ");
            for(int i=0;i<found.length;i++){
                if(found[i])
                    System.out.print(theWord[i]);
                else
                    System.out.print("_");
            }
            System.out.println("\n Guess a letter : ");
            String str=scanner.nextLine();
            char ch=str.charAt(0);
            int foundCount=0;
            boolean foundAny=false;
            for(int i=0;i<found.length;i++){
                if(theWord[i]==ch){
                    found[i]=true;
                    foundAny=true;
                }
                if(found[i]==true)
                    foundCount++;
            }
            if(!foundAny)//Lose a life
                livesUsed++;
            if(foundCount==theWord.length)
                won=true;
        }
        if(won) {
            System.out.println(" you won");
        }
        else
            System.out.println(" you lost");
        System.out.println(" the word was : ");
        for(int i=0;i<found.length;i++)
            System.out.print(theWord[i]);
        wordsPerSession++;
        return won;
    }

    public static String saveFilename = "hangman.ser";
    public static void saveGame(HangManGame h) throws Exception{
        FileOutputStream fos = new FileOutputStream(saveFilename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(h);
        out.close();
    }
    public static HangManGame loadGame() throws Exception{
        FileInputStream fis = new FileInputStream(saveFilename);
        ObjectInputStream in = new ObjectInputStream(fis);
        HangManGame hm =(HangManGame)in.readObject();
        in.close();
        return hm;
    }
    public static void main(String[] args) {
//Play hangman!
        HangManGame hm= new HangManGame();
        boolean quit=false;
        Scanner s= new Scanner(System.in);
        while(!quit){
            System.out.println(" WELCOME TO HANGMAN");
            System.out.println(" Try load game (l), save game (s), quit (q) or play game (p)");
            String str=s.nextLine();
            char ch=str.toLowerCase().charAt(0);
            if(ch=='l'){
                try {
                    hm = loadGame();
//                    System.out.println(" post load lives per game = "+livesPerWord);
                } catch (Exception e) {
                    System.out.println(" Unable to load game, exception = "+e+" continuing to menu");
                }
                System.out.println(" Position = "+hm.pos+" words played in session = "+hm.wordsPerSession);
                continue;
            }
            else if(ch=='s') {
                System.out.println(" Position = "+hm.pos+" words played in session = "+hm.wordsPerSession);
                try {
//                    livesPerWord=3;
//                    System.out.println(" Pre save, lives per game = "+livesPerWord);
                    saveGame(hm);
                } catch (Exception e) {
                    System.out.println(" Unable to save game, exception = "+e+" continuing to menu");
                }
                continue;
            }
            else if(ch=='q')
                quit=true;
            else
                quit=!hm.setNewWord();
            if(!quit)
                hm.playWord();
        }
        System.out.println(" BYEEEEEEEEE");

    }


}
