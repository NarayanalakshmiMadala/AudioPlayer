import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
class AudioPlayer
{
    public static void main(String[] args)
    {
    	start();
    }
    public static void start() 
    {
        System.out.println("======================================================================");
    	System.out.println("\t\t\tAudio Player");
    	System.out.println("======================================================================");
    	Scanner sc=new Scanner(System.in);
        System.out.println("P -> Play");
        System.out.println("K -> Pause");
        System.out.println("R -> Reset");
        System.out.println("Q -> Quit");
        System.out.println("--------------------------------------------------------------------");
        try {
            Thread.sleep(3000); 
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        System.out.println("\t\tMain Menu");
        System.out.println("1.Vikram Movie Rolex Music");
        System.out.println("2.Seetha Ramam Interval BGM");
        System.out.println("3.Karthikeya2 Flute Music");
        System.out.println("4.Soul Of Doctor Music");
        System.out.println("5.Nadan Pattu Music");
        System.out.println("6.Exit");

        System.out.print("\nEnter your choice : ");
        char choice=sc.next().charAt(0);
        String filePath;
        switch(choice)
        {
            case '1' -> 
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\t\tVikram Movie Rolex Music");
                filePath="Vikram.wav";
                playMusic(filePath);
            }
            case '2' -> 
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\t\tSeethaRamam Interval BGM");
                filePath="SeethaRamamIntervalBGM.wav";
                playMusic(filePath);
            }
            case '3' -> 
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\t\tKarthikeya2 Music");
                filePath="Karthikeya 2.wav";
                playMusic(filePath);
            }
            case '4' -> 
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\t\tSoul Of Doctor Music");
                filePath="SoulOfDoctor.wav";
                playMusic(filePath);
            }
            case '5' -> 
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\t\tNadan Pattu Beat Music");
                filePath="Nadan Pattu .wav";
                playMusic(filePath);
            }
            case '6'->
            {
                System.out.println("======================================================================");
                System.out.println("Thanks for using AudioPlayer");
                System.out.println("Have a Good Day");
                System.out.println("======================================================================");
                System.exit(0);  
            }
            default->
            {
                System.out.println("Invalid Choice...\nPlease Enter a Valid Choice....");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Exception Occured in Sleep Method..."+e.getLocalizedMessage());
                }
                start();
            }
        }
        listenOneMoreTime();
        sc.close();
    }
    public static void playMusic(String filePath)
    {
        Scanner sc=new Scanner(System.in);
        //String filePath="C:/Users/lokes/OneDrive/Desktop/Java Programs/Vikram.wav";
        try 
        {
            File file=new File(filePath);
            AudioInputStream audio=AudioSystem.getAudioInputStream(file);

            Clip clip=AudioSystem.getClip();
            clip.open(audio);

            char responceFromUser;
            System.out.println("--------------------------------------------------------------------");
            System.out.println("P=play , K=Pause , Q=Quit , R=Reset");
            System.out.print("Enter Your Choice : ");
            responceFromUser=sc.next().charAt(0);
            
            while(true)
            {
                switch(responceFromUser)
                {
                    case 'p'->clip.start();    
                    case 'P'->clip.start();
                    case 'k'->clip.stop();
                    case 'K'->clip.stop();
                    case 'R'->clip.setMicrosecondPosition(0);
                    case 'r'->clip.setMicrosecondPosition(0);
                    case 'Q'->{
                    	clip.close();
                    	listenOneMoreTime();
                    }
                    case 'q'->{
                    	clip.close();
                    	listenOneMoreTime();
                    }
                    default->System.out.println("Invalid Input....");              
                }
                System.out.println("P=play , K=Pause , Q=Quit , R=Reset");
                System.out.print("Enter Your Choice : ");
                responceFromUser=sc.next().charAt(0);
            }

        } catch (IOException e ) 
        {
            System.out.println("Exception Occured File Opening the File....");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
        catch(LineUnavailableException e)
        {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
    public static void listenOneMoreTime()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Do you Want to Listen Another Song (Y or N): ");
            char ch=sc.next().charAt(0);
            if(ch=='y'||ch=='Y')
            {
                start();
            }
            else if(ch=='n'|| ch=='N')
            {
                System.out.println("======================================================================");
                System.out.println("Thanks for using AudioPlayer");
                System.out.println("Have a Good Day");
                System.out.println("======================================================================");
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid Choice\nPlease Enter a Valid Choice (Y or N )");
                System.out.println("--------------------------------------------------------------------");
                continue;
            }
            sc.close();
        } 
    }
}