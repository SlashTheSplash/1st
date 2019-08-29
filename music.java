import java.io.*;
import java.util.*;
import javax.swing.*;

public class music 
{
	 public static void main(String[] args)throws IOException
	 {
	       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	       Node root=new Node("PlayList");
	       int ch=0;
	       do{
	           System.out.println("Enter your choice\n1.Add artist\t2.Add song\t3.Print Playlist\t4.Exit");
	           ch=Integer.parseInt(br.readLine());
	           if(ch==4)
	               break;
	           switch(ch){
	               case 1:
	                   System.out.println("Enter artist name");
	                   String artist_name=br.readLine();
	                   addArtist(root, artist_name);
	                   break;
	               case 2:
	                   System.out.println("Enter artist name");
	                   artist_name=br.readLine();
	                   System.out.println("Enter song");
	                   String song=br.readLine();
	                   addSong(root, artist_name, song);
	                   break;
	               case 3:
	                   print(root);
	                   break;
	           }
	       }
	       while(true);
	   }
	
	 
	   public static void addArtist(Node root, String artist_name)
	   {
	       root.al.add(new Node(artist_name));
	   }
	   
	   
	   public static void addSong(Node root, String artist_name, String song)
	   {
	       ArrayList<Node> al=root.al;
	       Iterator it=al.iterator();
	       int flag=0;
	       while(it.hasNext()){
	           Node n=(Node)it.next();
	           if(n.label.compareTo(artist_name)==0){
	               flag=1;
	               n.al.add(new Node(song));
	               break;
	           }
	       }
	       if(flag==0)
	           System.out.println("No such artist");
	   }
	   
	   
	   public static void print(Node root)
	   {
	       System.out.println(root.label+":   ");
	       ArrayList<Node> al=root.al;
	       Iterator it=al.iterator();
	       while(it.hasNext())
	       {
	           Node n=(Node)it.next();
	           System.out.println("   "+n.label+":   ");
	           Iterator it1=n.al.iterator();
	           while(it1.hasNext())
	           {
	               Node n1=(Node)it1.next();
	               System.out.println("      "+n1.label);
	           }
	       }
	   }
}



	class Node
	{
	   String label;
	   ArrayList<Node> al;
	   public Node(String l)
	   {
	       label=l;
	       al=new ArrayList<>();
	   }
	}
