package oopproject.carrental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;


//Seredilla
public class System extends JFrame {
        private final JLabel title, titleshadow, tabtitle;
        private final JPanel logobg, bgshadow,titlebgclr,carrentshadow, bookreservshadow, caravailshadow, carrepairshadow, currentpane, cararentpane, bookreservpane, caravailpane, carrepairpane;
        private final JButton carrents, bookreserv, caravail, carrepair;
        private final JTabbedPane pane; 
  
       System(){
        setSize(1280, 720);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        setTitle("Car Rental System");
        setResizable(false);
        
       title = new JLabel("Car Rental");
       title.setBounds(50,25,200,100);
       title.setFont(new Font("Times", Font.BOLD, 40));
       title.setForeground(Color.BLACK);
       
       titleshadow = new JLabel("Car Rental");
       titleshadow.setBounds(52,26,200,100);
       titleshadow.setFont(new Font("Times", Font.BOLD, 40));
       titleshadow.setForeground(Color.white);
       
       logobg = new JPanel();
       logobg.setBounds(25,25,250,100);
       logobg.setBackground(Color.gray);
      
       bgshadow = new JPanel();
       bgshadow.setBounds(30,30,250,100);
       bgshadow.setBackground(Color.black);
       
       titlebgclr = new JPanel();
       titlebgclr.setBounds(0, 0, 300, 2000);
       titlebgclr.setBackground(Color.darkGray);
       titlebgclr.setOpaque(true);
       
       carrentshadow = new JPanel();
       carrentshadow.setBounds(45, 200, 220, 50);
       carrentshadow.setBackground(Color.black);
       
       bookreservshadow = new JPanel();
       bookreservshadow.setBounds(45, 285, 220, 50);
       bookreservshadow.setBackground(Color.black);
       
       caravailshadow = new JPanel();
       caravailshadow.setBounds(45, 370, 220, 50);
       caravailshadow.setBackground(Color.black);

       carrepairshadow = new JPanel();
       carrepairshadow.setBounds(45, 450, 220, 50);
       carrepairshadow.setBackground(Color.BLACK);
       
       carrents = new JButton("Rent-a-Car");
       carrents.setBounds(40,195,220,50);
       carrents.setFont(new Font("Arial", Font.BOLD, 25));
       carrents.setForeground(Color.black);
       carrents.setBackground(Color.gray);
       carrents.addActionListener(new ButtonHandler());

       
       bookreserv = new JButton("Booking");
       bookreserv.setBounds(40, 280, 220, 50);
       bookreserv.setFont(new Font("Arial", Font.BOLD, 25));
       bookreserv.setForeground(Color.black);
       bookreserv.setBackground(Color.gray);
       bookreserv.addActionListener(new ButtonHandler1());
       
       caravail = new JButton("Car Availability");
       caravail.setBounds(40,365,220,50);
       caravail.setFont(new Font("Arial", Font.BOLD, 25));
       caravail.setForeground(Color.black);
       caravail.setBackground(Color.gray);
       caravail.addActionListener(new ButtonHandler2());
       
       carrepair = new JButton("Car Repair");
       carrepair.setBounds(40, 445, 220, 50);
       carrepair.setFont(new Font("Arial", Font.BOLD, 25));
       carrepair.setForeground(Color.black);
       carrepair.setBackground(Color.gray);
       carrepair.addActionListener(new ButtonHandler3());
       
       tabtitle = new JLabel("Welcome!");
       tabtitle.setFont(new Font("Arial", Font.BOLD, 25));
       
       currentpane = new JPanel();
       currentpane.setBackground(Color.LIGHT_GRAY);
       currentpane.add(tabtitle);
       cararentpane = new JPanel();
       cararentpane.setBackground(Color.LIGHT_GRAY);
       bookreservpane = new JPanel();
       bookreservpane.setBackground(Color.LIGHT_GRAY);
       caravailpane = new JPanel();
       caravailpane.setBackground(Color.LIGHT_GRAY);
       carrepairpane = new JPanel();
       carrepairpane.setBackground(Color.LIGHT_GRAY);
       
       pane = new JTabbedPane();
       pane.setBounds(295,0,1105,1280);
       pane.addTab("Tab 1", currentpane);
       pane.addTab("Tab 2", cararentpane);
       pane.addTab("Tab 3", bookreservpane);
       pane.addTab("Tab 4", caravailpane);
       pane.addTab("Tab 5", carrepairpane);
       
       
       
       add(title);
       add(titleshadow);
       add(logobg);
       add(bgshadow);
       add(carrents);
       add(carrentshadow);
       add(bookreserv);
       add(bookreservshadow);
       add(caravail);
       add(caravailshadow);
       add(carrepair);
       add(carrepairshadow);
       add(titlebgclr);
       add(pane);

       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pane.setSelectedIndex(1);
        }
    }
    class ButtonHandler1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pane.setSelectedIndex(2);
        }
    }
    class ButtonHandler2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pane.setSelectedIndex(3);
        }
    }
    class ButtonHandler3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            pane.setSelectedIndex(4);
        }
    }
}