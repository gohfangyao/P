import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;  

public class EditBook extends JFrame implements ActionListener{  
	
	JLabel l1;
    JLabel l2;  
    JLabel l3;  
    JLabel l4; 
    JLabel l5; 
    JTextField Text1;
    JTextField Text2;
    JButton b1;  
    JButton b2;
    
    int cnt=0;
    ArrayList bklist = new ArrayList();
    public String displayText() {
    String fileContent = "<HTML>";

    	try {
      		 File file = new File("C:/Users/User/Desktop/Book.txt");
      		  Scanner scan = new Scanner(file);
      		  
      		  
      		  String nextLine = "";
      		  System.out.println(fileContent+"abc");
      		  while(scan.hasNextLine()) {
      			
      		  nextLine = scan.nextLine();
      		  bklist.add(nextLine);
      		  cnt++;
      			
      		  fileContent = fileContent.concat((nextLine)+ "<br>");
      		  System.out.println(fileContent);
      		  }
      		  
      		  fileContent = fileContent.concat("</Html>");
      		  fileContent = fileContent.concat(Text1.getText()+ "<HTML>");
      		  System.out.println(fileContent);

      } 
      catch(Exception e1)
      {
      System.out.println("try catch error");
      }
    	return fileContent;
        
    }
    EditBook()
    {   
    
    	String fileContent = "<HTML>";

    	l1=new JLabel("Edit Book"); 
    	l1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        l1.setBounds(200,30,400,35); 
        l2=new JLabel("Books you have: "); 
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setBounds(100,100,300,50); 
        l3 = new JLabel(displayText());
        l3.setFont(new Font("Arial", Font.PLAIN, 20)); 
        l3.setBounds(100,0,500,500);
    	l4=new JLabel("I want to edit book number:");  
    	l4.setFont(new Font("Arial", Font.PLAIN, 20)); 
        l4.setBounds(100,340,500,20); 
        JPanel panel = new JPanel();
        Text1=new JTextField();  
        Text1.setBounds(100,375,300,30);  
        panel.add(Text1);
    	l5=new JLabel("New Title:");  
    	l5.setFont(new Font("Arial", Font.PLAIN, 19)); 
        l5.setBounds(100,415,500,20); 
        JPanel panel1 = new JPanel();
        Text2=new JTextField();  
        Text2.setBounds(100,450,300,30);  
        panel1.add(Text2);

        b1=new JButton("Edit");  
        b1.setBounds(100,510,300,30); 
        b2=new JButton("Back to Menu");  
        b2.setBounds(100,560,300,30);
    
        b1.addActionListener(this); 
        b2.addActionListener(this); 
       
        add(l1);add(l2);add(l3);add(l4);add(l5);add(Text1);add(Text2);add(b1);add(b2);
        setSize(570,740);  
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  
  
    
	public void actionPerformed(ActionEvent e)
	{  
		if (e.getSource() == b2) {
			this.dispose();
			MainMenu c = new MainMenu();
			c.setVisible(true);
		}
        
		String s="200";
        int i= Integer.parseInt(Text1.getText())-1;
		bklist.set(i, Text2.getText());
        String fileContent = "";
        /* For Loop for iterating ArrayList */
        System.out.println("For Loop");
        for (int counter = 0; counter < bklist.size(); counter++) { 

  		fileContent = fileContent.concat(bklist.get(counter)+ "\n");
        System.out.println(bklist.get(counter)); 	
  		
        }   		
try {
	FileWriter writer = new FileWriter("C:/Users/User/Desktop/Book.txt");
	  writer.write(fileContent);
	  writer.close();
	  
} 
catch(Exception e1)
{
System.out.println("edit try catch error"+ e1);

}

	   }
	   
    public static void main(String[] args) {  
        new EditBook(); 

    }
}



    
   
