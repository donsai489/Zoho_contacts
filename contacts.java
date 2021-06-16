package zoho.intern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
   
/**
 *
 * @author saiiyer23
 */
class mainscreen
{
    protected void menu()
    {
         System.out.println("--------- Contacts Menu ----------");
         System.out.println(" 1. Contacts ");
         System.out.println(" 2. Logs ");
         System.out.println(" 3. Exit ");

    }
    
    
}

class logs
{
    public static ArrayList<String> logarray=new ArrayList<String>();
    
    public static void log(String a)
    {
        
        logarray.add(a);
    }
    public static void displog()
    {
        System.out.println("_-_-_- Logs -_-_-_");
        for(int i=0;i<logarray.size();i++)
        {
            System.out.println(logarray.get(i));
        }
        
    }
}

class contacts
{
    
    public static void add_contact(ArrayList<ArrayList<String>> mainarray)
    {
        System.out.println("--------- Add Contacts ----------");
        System.out.println(" 1. Add Name ");
        System.out.println(" 2. Add Phone No. ");
        System.out.println(" 3. Add email. ");
        System.out.println(" 4. Exit back to menu ");
        Scanner sc=new Scanner(System.in);
        char choice;
        ArrayList<String> details= new ArrayList<String>();
        
        do
        {
            choice=sc.next().charAt(0);
            switch(choice)
            {
                case '1':
                    System.out.println("Enter the name - ");
                    Scanner ns=new Scanner(System.in);
                    String name;
                    name=ns.nextLine();
                   
                    details.add(0,name);
                    System.out.println(details);
                    break;
                case '2':
                    System.out.println("Enter the number - ");
                    Scanner nn=new Scanner(System.in);
                    String phone=nn.nextLine();
                    details.add(1,phone);
                    System.out.println(details);
                    break;
                case '3':
                    System.out.println("Enter the email - ");
                    Scanner ne=new Scanner(System.in);
                    String email=ne.nextLine();
                    details.add(2,email);
                    System.out.println(details);
                    break;
                default:
                    break;
                 
            }
        }while(choice!='4');
        mainarray.add(0,details);
        System.out.println(mainarray);
        System.out.println("\n\n Contact Saved");
    }
    
    public static void detail(ArrayList<String> array)
            
    {
        System.out.println("Name -"+array.get(0));
        System.out.println("Number -"+array.get(1));
        System.out.println("Email -"+array.get(2));
    }
    
    public static void disp(ArrayList<ArrayList<String>> mainarray)
    {
        System.out.println(" _-_-_-_- Contacts -_-_-_-_");
        System.out.println("Total Contacts - "+mainarray.size());
        System.out.println("Search by");
        System.out.println("1. Name ");
        System.out.println("2. Number ");
        System.out.println("3. Email ");
        Scanner sc=new Scanner(System.in);
        char choice=sc.next().charAt(0);
        switch(choice)
        {
            case '1':
                System.out.println(" Enter the name - ");
                Scanner nn1=new Scanner(System.in);
                String name=nn1.nextLine();
                for(int i=0;i<mainarray.size();i++)
                {
                    if(mainarray.get(i).get(0).contains(name)==true)
                    {
                        detail(mainarray.get(i));
                        System.out.println("Call this contact - Y or N");
                        char call=nn1.next().charAt(0);
                        if(call=='y')
                        {
                            logs.log(mainarray.get(i).get(0));
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("Not Found ! Going back to menu ... ");
                    }
                }
                break;
            case '2':
                System.out.println(" Enter the number - ");
                Scanner nn2=new Scanner(System.in);
                String num=nn2.nextLine();
                for(int i=0;i<mainarray.size();i++)
                {
                    if(mainarray.get(i).get(1).contains(num)==true)
                    {
                        detail(mainarray.get(i));
                        System.out.println("Call this contact - Y or N");
                        char call=nn2.next().charAt(0);
                        if(call=='y')
                        {
                            logs.log(mainarray.get(i).get(0));
                        }
                        break;
                        
                    }
                    else
                    {
                        System.out.println("Not Found ! Going back to menu ... ");
                    }
                }
                break;
            case '3':
                System.out.println(" Enter the email - ");
                Scanner ne1=new Scanner(System.in);
                String email=ne1.nextLine();
                for(int i=0;i<mainarray.size();i++)
                {
                    if(mainarray.get(i).get(2).contains(email)==true)
                    {
                        detail(mainarray.get(i));
                        System.out.println("Call this contact - Y or N");
                        char call=ne1.next().charAt(0);
                        if(call=='y')
                        {
                            logs.log(mainarray.get(i).get(0));
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("Not Found ! Going back to menu ... ");
                    }
                }
                break;
            default:
                break;
                
        }
        
    }
    
    public static void del_contact(ArrayList<ArrayList<String>> mainarray)
    {
        System.out.println(" Enter name to Search ");
        Scanner sc=new Scanner(System.in);
        String s_name=sc.nextLine();
        for(int i=0;i<mainarray.size();i++)
        {
            
            {
                if(mainarray.get(i).get(0).contains(s_name)==true)
                {
                    detail(mainarray.get(i));
                    System.out.println("Is required number found - Y or N");
                    char yn=sc.next().charAt(0);
                    if(yn=='y')
                    {
                        mainarray.remove(i);
                        break;
                    }
                    
                    
                        
                    
                }
                      
            }
        }
        
    }
}
public class contactss extends mainscreen {
    
    public static void main(String[] args)
    {
        mainscreen m=new mainscreen();
        
        Scanner s=new Scanner(System.in);
        char choice;
        ArrayList<ArrayList<String>> mainarray=new ArrayList<ArrayList<String>>();
        do
        {
            m.menu();
            choice=s.next().charAt(0);
            switch(choice)
            {
                case '1':
                
                    char choice1;
                    do
                    {
                        System.out.println("\n\n\n ------- Contacts -------");
                        System.out.println(" 1. Add contact ");
                        System.out.println(" 2. Show all contacts ");
                        System.out.println(" 3. Search Contact ");
                        System.out.println(" 4. Delete Contact ");
                        System.out.println(" 5. Exit");
                        choice1=s.next().charAt(0);
                        switch(choice1)
                        {
                            case '1':
                                contacts.add_contact(mainarray);
                                break;
                            case '2':
                                for(int i=0;i<mainarray.size();i++)
                                {
                                    System.out.println("\n"+ mainarray.get(i));
                                }
                                break;
                            case '3':
                                contacts.disp(mainarray);
                                break;
                            case '4':
                                contacts.del_contact(mainarray);
                                break;
                            case '5':
                                break;
                        }
                    }while(choice1!='5');
                    break;
                case '2':
                    System.out.println(" - - - - LOGS - - - - ");
                    System.out.println(" 1. View Logs ");
                    System.out.println(" 2. Exit ");
                    System.out.println("Enter your Choice - ");
                    char choice2=s.next().charAt(0);
                    if(choice2=='1')
                    {
                        logs.displog();
                    }
                    else    
                    {
                        break;
                    }
                    break;
                
                
                default:
                    break;
            
            }
        }while(choice!='3');
        
        
        
    }
    
}
