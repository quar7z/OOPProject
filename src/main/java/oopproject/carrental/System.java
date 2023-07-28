package oopproject.carrental;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Seredilla

public  class System extends JFrame  implements ActionListener{
        private final JLabel title, fortuner, accord, civic, hiace, vios, wigo,fortunertext,accordtext,civictext,hiacetext,viostext,wigotext;
        private final JLabel fortunerprice, accordprice, civicprice,hiaceprice,viosprice,wigoprice;
        private final JPanel bgshadow,titlebgclr,titlebgclrshadow, carrentpanel, bookreservpanl, caravailpanel, carrepairpanel, superpanel,bookreservnum,bookreservpanel,namepanel, bookingpanel, savepdf;
        private final JPanel fortunerpanel,accordpanel,civicpanel,hiacepanel,viospanel,wigopanel;
        private final JTextArea fortunerinfo,accordinfo,civicinfo,hiaceinfo,viosinfo,wigoinfo;
        public static JTextArea infotext, infotext1,area,area1,area2,area3,area4,area5,area6,area7,area8,area9,area10,area11,area12,statusavailability,accordstatusavailability, wigoavailability, civicavailability, hiaceavailability, viosavailability;
        private final JButton home,contin,submit,fortunerreturnbtn,go,accordreturnbtn,wigoreturnbtn,civicreturnbtn,hiacereturnbtn,viosreturnbtn, cancelbutton,savebutton;
        private final JButton clonefortunerbtn,cloneaccordbtn, clonecivicbtn, clonehiacebtn, cloneviosbtn, clonewigobtn;
        private final String greeting="Welcome!",txtr="        We at Cars Inc. offers cars that is cheap to rent but the cars we offer are known and high quality brand of cars. We also assure that the cars are well maintaned."; 
        private final String txtr1="        We are on the car renting business for 30 years, many people trusted us and purchased our services. We can assure you, our customer that you won't be disappointed on the services we offer.";
        private final JComboBox pickupfield,dropofffield,Datefield,Mnth,Yr,dropDate,dropMonth,dropyear,pickuptime,dropofftime,pickmin,dropmin,paymentmethod;
        private final JTextArea pickuplocationarea,dropofffieldloc,datefieldloc,pickuptimeloc,chooseyourcar,pickminloc,dropminloc,nametextarea,phonenumbertextarea,emailtextarea,bookreservinput;
        
      public System(){
        setSize(1600, 930);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Car Rental System");
        setResizable(false);
  
       //start// JFrame Panels
       title = new JLabel();
       title.setBounds(69,25,150,100);
       ImageIcon titleimg  = new ImageIcon(new ImageIcon("images/carinc.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
       title.setIcon(titleimg);

       bgshadow = new JPanel();
       bgshadow.setBounds(72,27,150,100);
       bgshadow.setBackground(Color.black);

       titlebgclr = new JPanel();
       titlebgclr.setBounds(8, 10, 1570, 130);
       titlebgclr.setBackground(new Color(24,70,53));
       titlebgclr.setOpaque(true);

       titlebgclrshadow = new JPanel();
       titlebgclrshadow.setBounds(12, 14, 1570, 130);
       titlebgclrshadow.setBackground(Color.BLACK);
       titlebgclrshadow.setOpaque(true);
       
                       JLabel titleslogan = new JLabel("Your go-to Car Rental Business");
                       titleslogan.setBounds(240,70,500,100);
                       titleslogan.setFont(new Font("Arial", Font.ITALIC,25));
                       titleslogan.setForeground(Color.WHITE);
                       add(titleslogan);
                       
       home = new JButton("Home");
       home.setBounds(1400,50,120,50);
       home.setFont(new Font("Arial", Font.BOLD, 25));
       home.setBackground(new Color(223,204,166));
       home.setForeground(Color.BLACK);
       home.setBorderPainted(false);
       home.setFocusPainted(false);
       home.addActionListener(this);
       add(home);                
       
       add(titleslogan);                 
       add(titlebgclrshadow);
       add(title);
       add(bgshadow);
       add(titlebgclr);
       add(titlebgclrshadow);
  
       infotext = new JTextArea(txtr);
       infotext.setBounds(420, 150, 1000, 100);
       infotext.setBackground(Color.lightGray);
       infotext.setFont(new Font("Arial", Font.BOLD, 25));
       infotext.setForeground(Color.black);
       infotext.setLineWrap(true);
       infotext.setWrapStyleWord(true);
       infotext.setVisible(false);
       add(infotext);
       
       infotext1 = new JTextArea(txtr1);
       infotext1.setBounds(420, 280, 1000, 450);
       infotext1.setBackground(Color.lightGray);
       infotext1.setFont(new Font("Arial", Font.BOLD, 25));
       infotext1.setForeground(Color.black);
       infotext1.setLineWrap(true);
       infotext1.setWrapStyleWord(true);
       infotext1.setVisible(false);
       add(infotext1);
       
       //end// JFrame Panels
       
       //start// JFrame switching panels

       caravailpanel= new JPanel();
       caravailpanel.setBounds(0,0,1600,1280);
       caravailpanel.setBackground(Color.lightGray);
       caravailpanel.setLayout(null);
       caravailpanel.setVisible(false);
       add(caravailpanel);
       
       bookreservnum = new JPanel();
       bookreservnum.setBounds(10,600,320,150);
       bookreservnum.setBackground(Color.lightGray);
       bookreservnum.setLayout(null);
       bookreservnum.setVisible(true);
       add(bookreservnum);
       
                            JLabel bookreservnumtitle = new JLabel("Your Booking");
                           bookreservnumtitle.setBounds(10,17,200,25);
                           bookreservnumtitle.setFont(new Font("Arial", Font.BOLD, 20));
                           bookreservnumtitle.setForeground(Color.white);
                           bookreservnum.add(bookreservnumtitle);
                           
                           JLabel bookreservref = new JLabel("Booking No:");
                           bookreservref.setBounds(10,70,200,20);
                           bookreservref.setFont(new Font("Arial", Font.BOLD, 15));
                           bookreservref.setForeground(Color.black);
                           bookreservnum.add(bookreservref);
                           
                           /////////////////////////////////////////////////////////////////////////////
                           
                           go = new JButton("Go");
                           go.setBounds(260,98,52,25);
                           go.setFont(new Font("Arial", Font.BOLD, 12));
                           go.setBackground(Color.lightGray);
                           go.setForeground(Color.black);
                           go.setBorderPainted(false);
                           go.addActionListener(this);
                           go.setFocusPainted(false);
                           bookreservnum.add(go);
                           
                           /////////////////////////////////////////////////////////////////////////////
                           
                           bookreservinput = new JTextArea();
                           bookreservinput.setBounds(10,98,240,25);
                           bookreservinput.setFont(new Font("Arial", Font.PLAIN, 18));
                           bookreservinput.setBackground(Color.lightGray);
                           bookreservinput.setForeground(Color.black);
                            bookreservinput.setLineWrap(true);
                       bookreservinput.setWrapStyleWord(true);
                           bookreservnum.add(bookreservinput);
                           
                           /////////////////////////////////////////////////////////////////////////////
                           
                           
                           JPanel bookreservnumpanel = new JPanel();
                           bookreservnumpanel.setBounds(0,5,340,50);
                           bookreservnumpanel.setBackground(new Color(24,70,53));
                           bookreservnum.add(bookreservnumpanel);
                           
                           JPanel bookreservnumpanelshadow = new JPanel();
                           bookreservnumpanelshadow.setBounds(0,50,340,500);
                           bookreservnumpanelshadow.setBackground(Color.white);
                           bookreservnum.add(bookreservnumpanelshadow);
     
       
       bookreservpanl = new JPanel();
       bookreservpanl.setBounds(10,150,320,400);
       bookreservpanl.setBackground(Color.lightGray);
       bookreservpanl.setLayout(null);
       bookreservpanl.setVisible(true);
       add(bookreservpanl);
  
                           JLabel bookreservtitle = new JLabel("Book Your Car"); //title for book reservation
                           bookreservtitle.setBounds(10,17,200,25);
                           bookreservtitle.setFont(new Font("Arial", Font.BOLD, 20));
                           bookreservtitle.setForeground(Color.white);
                           bookreservpanl.add(bookreservtitle);
                           
                           JLabel pickuploc = new JLabel("Pick-up Location:"); //shadow for the title
                           pickuploc.setBounds(10,70,130,20);
                           pickuploc.setFont(new Font("Arial", Font.BOLD, 15));
                           pickuploc.setForeground(Color.black);
                           bookreservpanl.add(pickuploc);
                           
                           JLabel dropoffloc = new JLabel("Drop-off Location:");
                           dropoffloc.setBounds(10,115,130,20);
                           dropoffloc.setFont(new Font("Arial", Font.BOLD, 15));
                           dropoffloc.setForeground(Color.black);
                           bookreservpanl.add(dropoffloc);
                           
                           JLabel pickdate = new JLabel("Pick-up Date:");
                           pickdate.setBounds(10,160,130,20);
                           pickdate.setFont(new Font("Arial", Font.BOLD, 15));
                           pickdate.setForeground(Color.black);
                           bookreservpanl.add(pickdate);
                           
                           JLabel dropdate = new JLabel("Drop-off Date:");
                           dropdate.setBounds(9,205,130,20);
                           dropdate.setFont(new Font("Arial", Font.BOLD, 15));
                           dropdate.setForeground(Color.black);
                           bookreservpanl.add(dropdate);
                           
                           JLabel timepick = new JLabel("Pick-up Time:");
                           timepick.setBounds(9,250,130,20);
                           timepick.setFont(new Font("Arial", Font.BOLD, 15));
                           timepick.setForeground(Color.black);
                           bookreservpanl.add(timepick);
                           
                           JLabel timedrop = new JLabel("Drop-off Time:");
                           timedrop.setBounds(9,295,130,20);
                           timedrop.setFont(new Font("Arial", Font.BOLD, 15));
                           timedrop.setForeground(Color.black);
                           bookreservpanl.add(timedrop);
                           
                           JLabel divison = new JLabel(":");
                           divison.setBounds(167,295,130,20);
                           divison.setFont(new Font("Arial", Font.BOLD, 25));
                           divison.setForeground(Color.black);
                           bookreservpanl.add(divison);
                           
                           JLabel divison2 = new JLabel(":");
                           divison2.setBounds(167,250,130,20);
                           divison2.setFont(new Font("Arial", Font.BOLD, 25));
                           divison2.setForeground(Color.black);
                           bookreservpanl.add(divison2);
                           
                           ///////////////////////////////////////////////////////////////////
                           
                           String[] pickuparray ={"Alaminos", "Bay", "Biñan", "Cabuyao", "Calamba", "Calauan", "Cavinti", "Famy", "Kalayaan", "LIliw","Los Baños","Luisiana","Lumban","Mabitac","Magdalena",
                               "Majayjay","Nagcarlan","Paete","Pagsanjan","Pakil","Pangil","Pila","Rizal","San Pablo","San Pedro","Santa Cruz","Santa Maria","Santa Rosa","Siniloan","Victoria"};
                           pickupfield = new JComboBox(pickuparray);
                           pickupfield.setBounds(145,70,130,25);
                           pickupfield.setFont(new Font("Arial", Font.PLAIN, 18));
                           pickupfield.setForeground(Color.BLACK);
                           pickupfield.setBackground(Color.lightGray);
                           pickupfield.addActionListener(this);
                           bookreservpanl.add(pickupfield);
                           
                           String[] dropoffarray ={"Alaminos", "Bay", "Biñan", "Cabuyao", "Calamba", "Calauan", "Cavinti", "Famy", "Kalayaan", "LIliw","Los Baños","Luisiana","Lumban","Mabitac","Magdalena",
                               "Majayjay","Nagcarlan","Paete","Pagsanjan","Pakil","Pangil","Pila","Rizal","San Pablo","San Pedro","Santa Cruz","Santa Maria","Santa Rosa","Siniloan","Victoria"};
                            dropofffield = new JComboBox(dropoffarray);
                           dropofffield.setBounds(145,115,130,26);
                           dropofffield.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropofffield.setForeground(Color.BLACK);
                           dropofffield.setBackground(Color.lightGray);
                           dropofffield.addActionListener(this);
                           bookreservpanl.add(dropofffield);
                           
                           String[] pickupDate ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
                               "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
                           Datefield = new JComboBox(pickupDate);
                           Datefield.setBounds(115,160,50,26);
                           Datefield.setFont(new Font("Arial", Font.PLAIN, 18));
                           Datefield.setForeground(Color.BLACK);
                           Datefield.setBackground(Color.lightGray);
                           Datefield.addActionListener(this);
                           bookreservpanl.add(Datefield);
                           
                           String[] pickupMonth ={"Jan","Feb","Mar","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
                            Mnth = new JComboBox(pickupMonth);
                           Mnth.setBounds(170,160,60,26);
                           Mnth.setFont(new Font("Arial", Font.PLAIN, 18));
                           Mnth.setForeground(Color.BLACK);
                           Mnth.setBackground(Color.lightGray);
                           Mnth.addActionListener(this);
                           bookreservpanl.add(Mnth);
                           
                           String[] pickupyear ={"2023", "2024"};
                            Yr = new JComboBox(pickupyear);
                           Yr.setBounds(235,160,70,26);
                           Yr.setFont(new Font("Arial", Font.PLAIN, 18));
                           Yr.setForeground(Color.BLACK);
                           Yr.setBackground(Color.lightGray);
                           Yr.addActionListener(this);
                           bookreservpanl.add(Yr);
                           
                           String[] dropoffDate ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
                               "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
                            dropDate = new JComboBox(dropoffDate);
                           dropDate.setBounds(115,205,50,26);
                           dropDate.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropDate.setForeground(Color.BLACK);
                           dropDate.setBackground(Color.lightGray);
                           dropDate.addActionListener(this);
                           bookreservpanl.add(dropDate);
                           
                           String[] dropoffMonth ={"Jan","Feb","Mar","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
                            dropMonth = new JComboBox(dropoffMonth);
                           dropMonth.setBounds(170,205,60,26);
                           dropMonth.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropMonth.setForeground(Color.BLACK);
                           dropMonth.setBackground(Color.lightGray);
                           dropMonth.addActionListener(this);
                           bookreservpanl.add(dropMonth);
                           
                           String[] dropoffyear ={"2023","2024"};
                            dropyear = new JComboBox(dropoffyear);
                           dropyear.setBounds(235,205,70,26);
                           dropyear.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropyear.setForeground(Color.BLACK);
                           dropyear.setBackground(Color.lightGray);
                           dropyear.addActionListener(this);
                           bookreservpanl.add(dropyear);
                           
                           String[] pickhour ={"00","01","02","03","04","05","06","07","08","09","10","11","12",
                               "13","14","15","16","17","18","19","20","21","22","23","24"};
                            pickuptime = new JComboBox(pickhour);
                           pickuptime.setBounds(115,250,50,26);
                           pickuptime.setFont(new Font("Arial", Font.PLAIN, 18));
                           pickuptime.setForeground(Color.BLACK);
                           pickuptime.setBackground(Color.lightGray);
                           pickuptime.addActionListener(this);
                           bookreservpanl.add(pickuptime);
                           
                           String[] drophour ={"00","01","02","03","04","05","06","07","08","09","10","11","12",
                               "13","14","15","16","17","18","19","20","21","22","23","24"};
                            dropofftime = new JComboBox(drophour);
                           dropofftime.setBounds(115,295,50,26);
                           dropofftime.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropofftime.setForeground(Color.BLACK);
                           dropofftime.setBackground(Color.lightGray);
                           dropofftime.addActionListener(this);
                           bookreservpanl.add(dropofftime);
                           
                           String[] pickminutes ={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
                               "31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","57","58","59"};
                            pickmin = new JComboBox(pickminutes);
                           pickmin.setBounds(180,250,50,26);
                           pickmin.setFont(new Font("Arial", Font.PLAIN, 18));
                           pickmin.setForeground(Color.BLACK);
                           pickmin.setBackground(Color.lightGray);
                           pickmin.addActionListener(this);
                           bookreservpanl.add(pickmin);
                           
                           String[] dropminutes ={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
                               "31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","57","58","59"};
                            dropmin = new JComboBox(dropminutes);
                           dropmin.setBounds(180,295,50,26);
                           dropmin.setFont(new Font("Arial", Font.PLAIN, 18));
                           dropmin.setForeground(Color.BLACK);
                           dropmin.setBackground(Color.lightGray);
                           dropmin.addActionListener(this);
                           bookreservpanl.add(dropmin);
                         
                           ///////////////////////////////////////////////////////////////////
                           
                           contin = new JButton("Continue");
                           contin.setBounds(175,360,120,26);
                           contin.setFont(new Font("Arial", Font.BOLD, 15));
                           contin.setForeground(Color.black);
                           contin.setBackground(Color.lightGray);
                           contin.addActionListener(this);
                           contin.setBorderPainted(false);
                           contin.setFocusPainted(false);
                           bookreservpanl.add(contin);
                           
                           ///////////////////////////////////////////////////////////////////
                           
                           JPanel booktitle = new JPanel();
                           booktitle.setBounds(0,5,340,50);
                           booktitle.setBackground(new Color(24,70,53));
                           bookreservpanl.add(booktitle);
                           
                           JPanel bookcontent = new JPanel();
                           bookcontent.setBounds(0,50,340,500);
                           bookcontent.setBackground(Color.white);
                           bookreservpanl.add(bookcontent);
                           
       bookreservpanel = new JPanel();
       bookreservpanel.setBounds(10,160,330,400);
       bookreservpanel.setBackground(Color.white);
       bookreservpanel.setLayout(null);
       bookreservpanel.setVisible(false);
       add(bookreservpanel);
  
                           JLabel bookreservttle = new JLabel("Your Booking"); //title for book reservation
                           bookreservttle.setBounds(10,15,200,25);
                           bookreservttle.setFont(new Font("Arial", Font.BOLD, 25));
                           bookreservttle.setForeground(Color.white);
                           bookreservpanel.add(bookreservttle);
       
                           JLabel pickuplocation = new JLabel("Pick-up Location:"); //shadow for the title
                           pickuplocation.setBounds(10,70,130,20);
                           pickuplocation.setFont(new Font("Arial", Font.BOLD, 15));
                           pickuplocation.setForeground(Color.black);
                           bookreservpanel.add(pickuplocation);
                           
                           JLabel dropofflocation = new JLabel("Drop-off Location:");
                           dropofflocation.setBounds(10,115,130,20);
                           dropofflocation.setFont(new Font("Arial", Font.BOLD, 15));
                           dropofflocation.setForeground(Color.black);
                           bookreservpanel.add(dropofflocation);
                           
                           JLabel pickdte = new JLabel("Pick-up Date:");
                           pickdte.setBounds(10,160,130,20);
                           pickdte.setFont(new Font("Arial", Font.BOLD, 15));
                           pickdte.setForeground(Color.black);
                           bookreservpanel.add(pickdte);
                           
                           JLabel dropdte = new JLabel("Drop-off Date:");
                           dropdte.setBounds(9,205,130,20);
                           dropdte.setFont(new Font("Arial", Font.BOLD, 15));
                           dropdte.setForeground(Color.black);
                           bookreservpanel.add(dropdte);
                           
                           JLabel timepickup = new JLabel("Pick-up Time:");
                           timepickup.setBounds(9,250,130,20);
                           timepickup.setFont(new Font("Arial", Font.BOLD, 15));
                           timepickup.setForeground(Color.black);
                           bookreservpanel.add(timepickup);
                           
                           JLabel timedropoff = new JLabel("Drop-off Time:");
                           timedropoff.setBounds(9,295,130,20);
                           timedropoff.setFont(new Font("Arial", Font.BOLD, 15));
                           timedropoff.setForeground(Color.black);
                           bookreservpanel.add(timedropoff);
   
                           JLabel yourcar = new JLabel("Your Car of Choice:");
                           yourcar.setBounds(9,340,150,20);
                           yourcar.setFont(new Font("Arial", Font.BOLD, 15));
                           yourcar.setForeground(Color.black);
                           bookreservpanel.add(yourcar);
                           
                            //////////////////////////////////////////////////////////////////////////////
                          pickuplocationarea = new JTextArea();
                           pickuplocationarea.setBounds(155,70,130,25);
                           pickuplocationarea.setFont(new Font("Arial", Font.BOLD, 19));
                           pickuplocationarea.setForeground(Color.black);
                           pickuplocationarea.setEditable(false);
                           bookreservpanel.add(pickuplocationarea);
                           
                           dropofffieldloc = new JTextArea();
                           dropofffieldloc.setBounds(155,113,130,25);
                           dropofffieldloc.setFont(new Font("Arial", Font.BOLD, 19));
                           dropofffieldloc.setForeground(Color.black);
                           dropofffieldloc.setEditable(false);
                           bookreservpanel.add(dropofffieldloc);
                           
                           datefieldloc = new JTextArea();
                           datefieldloc.setBounds(155,156,130,25);
                           datefieldloc.setFont(new Font("Arial", Font.BOLD, 19));
                           datefieldloc.setForeground(Color.black);
                           datefieldloc.setEditable(false);
                           bookreservpanel.add(datefieldloc);
                                              
                           pickuptimeloc = new JTextArea();
                           pickuptimeloc.setBounds(155,199,130,25);
                           pickuptimeloc.setFont(new Font("Arial", Font.BOLD, 19));
                           pickuptimeloc.setForeground(Color.black);
                           pickuptimeloc.setEditable(false);
                           bookreservpanel.add(pickuptimeloc);
                           
                            chooseyourcar = new JTextArea();
                           chooseyourcar.setBounds(155,340,150,25);
                           chooseyourcar.setFont(new Font("Arial", Font.BOLD, 19));
                           chooseyourcar.setBackground(Color.lightGray);
                           chooseyourcar.setForeground(Color.black);
                           chooseyourcar.setEditable(false);
                           bookreservpanel.add(chooseyourcar);
                           
                           pickminloc = new JTextArea();
                           pickminloc.setBounds(155,248,130,25);
                           pickminloc.setFont(new Font("Arial", Font.BOLD, 19));
                           pickminloc.setForeground(Color.black);
                           pickminloc.setEditable(false);
                           bookreservpanel.add(pickminloc);
                           
                           dropminloc = new JTextArea();
                           dropminloc.setBounds(155,294,130,25);
                           dropminloc.setFont(new Font("Arial", Font.BOLD, 19));
                           dropminloc.setForeground(Color.black);
                           dropminloc.setEditable(false);
                           bookreservpanel.add(dropminloc);
                            //////////////////////////////////////////////////////////////////////////////
                            JPanel bookcontitle = new JPanel();
                           bookcontitle.setBounds(0,0,600,50);
                           bookcontitle.setBackground(new Color(24,70,53)); //mint green color
                           bookreservpanel.add(bookcontitle);
                           
                           JPanel bookcontitleshadow = new JPanel();
                           bookcontitleshadow.setBounds(0,50,600,500);
                           bookcontitleshadow.setBackground(Color.white);
                           bookreservpanel.add(bookcontitleshadow);
                           
       namepanel = new JPanel();
       namepanel.setBounds(10,580,330,280);
       namepanel.setBackground(Color.WHITE);
       namepanel.setLayout(null);
       namepanel.setVisible(false);
       add(namepanel);
  
                           JLabel nametitle = new JLabel("Your Information"); //title for details
                           nametitle.setBounds(10,15,250,25);
                           nametitle.setFont(new Font("Arial", Font.BOLD, 25));
                           nametitle.setForeground(Color.white);
                           namepanel.add(nametitle);
       
                           JLabel fullname = new JLabel("Full Name:"); //shadow for the title
                           fullname.setBounds(10,70,130,20);
                           fullname.setFont(new Font("Arial", Font.BOLD, 15));
                           fullname.setForeground(Color.black);
                           namepanel.add(fullname);
                           
                           JLabel email = new JLabel("Email:");
                           email.setBounds(10,115,135,20);
                           email.setFont(new Font("Arial", Font.BOLD, 15));
                           email.setForeground(Color.black);
                           namepanel.add(email);
                           
                           JLabel phonenum = new JLabel("Phone #:");
                           phonenum.setBounds(10,160,130,20);
                           phonenum.setFont(new Font("Arial", Font.BOLD, 15));
                           phonenum.setForeground(Color.black);
                           namepanel.add(phonenum);
                           
                            JLabel payment = new JLabel("Payment:");
                           payment.setBounds(10,205,130,20);
                           payment.setFont(new Font("Arial", Font.BOLD, 15));
                           payment.setForeground(Color.black);
                           namepanel.add(payment);
                           
                           
                            //////////////////////////////////////////////////////////////////////////////
                            
                          nametextarea = new JTextArea();
                           nametextarea.setBounds(90,71,200,20);
                           nametextarea.setFont(new Font("Arial", Font.PLAIN, 17));
                           nametextarea.setForeground(Color.black);
                           nametextarea.setBackground(Color.lightGray);
                           nametextarea.setEditable(true);
                           namepanel.add(nametextarea);
                           
                           emailtextarea = new JTextArea();
                           emailtextarea.setBounds(90,114,200,20);
                           emailtextarea.setFont(new Font("Arial", Font.PLAIN, 17));
                           emailtextarea.setForeground(Color.black);
                           emailtextarea.setBackground(Color.lightGray);
                           emailtextarea.setEditable(true);
                           namepanel.add(emailtextarea);
                           
                           phonenumbertextarea = new JTextArea();
                           phonenumbertextarea.setBounds(90,157,200,20);
                           phonenumbertextarea.setFont(new Font("Arial", Font.PLAIN, 17));
                           phonenumbertextarea.setForeground(Color.black);
                           phonenumbertextarea.setBackground(Color.lightGray);
                           phonenumbertextarea.setEditable(true);
                           namepanel.add(phonenumbertextarea);
                           
                           
                           String[] pyment = {"Credit Card","Cash"};
                           paymentmethod = new JComboBox(pyment);
                           paymentmethod.setBounds(90,205,200,20);
                           paymentmethod.setFont(new Font("Arial", Font.PLAIN, 17));
                           paymentmethod.setForeground(Color.black);
                           paymentmethod.setBackground(Color.lightGray);
                           namepanel.add(paymentmethod);
                           
                           
                           ///////////////////////////////////////////////////////////////////////////////
                            submit = new JButton("Submit");
                           submit.setBounds(185,245,120,25);
                           submit.setFont(new Font("Arial", Font.BOLD, 15));
                           submit.setForeground(Color.black);
                           submit.setBackground(Color.lightGray);
                           submit.addActionListener(this);
                           submit.setBorderPainted(false);
                           submit.setFocusPainted(false);
                           namepanel.add(submit);
                            //////////////////////////////////////////////////////////////////////////////
                            JPanel nameclrpanel = new JPanel();
                           nameclrpanel.setBounds(0,0,600,50);
                           nameclrpanel.setBackground(new Color(24,70,53)); //mint green color
                           namepanel.add(nameclrpanel);
                           
                           JPanel nameclrpanelshadow = new JPanel();
                           nameclrpanelshadow.setBounds(0,50,340,500);
                           nameclrpanelshadow.setBackground(Color.white);
                           namepanel.add(nameclrpanelshadow);
                           //////////////////////////////////////////////////////////////////////////////
                           
       
       carrentpanel = new JPanel();
       carrentpanel.setBounds(339,150,1235,705);
       carrentpanel.setBackground(Color.lightGray);
       carrentpanel.setLayout(null);
       carrentpanel.setVisible(true);
       add(carrentpanel);
                        
                        //start// images of car
                       fortuner = new JLabel();
                       fortuner.setBounds(15,-50,500,295);
                       ImageIcon imgfortuner = new ImageIcon(new ImageIcon("images/fortuner.png").getImage().getScaledInstance(300, 177, Image.SCALE_DEFAULT));
                       fortuner.setIcon(imgfortuner);
                       carrentpanel.add(fortuner);

                       accord  = new JLabel();
                       accord.setBounds(635, -108, 500, 400);
                       ImageIcon imgaccord  = new ImageIcon(new ImageIcon("images/accord.png").getImage().getScaledInstance(300, 169, Image.SCALE_DEFAULT));
                       accord.setIcon(imgaccord);
                       carrentpanel.add(accord);

                       hiace  = new JLabel();
                       hiace.setBounds(635, 135, 500, 400);
                       ImageIcon imghiace  = new ImageIcon(new ImageIcon("images/hiace.jpg").getImage().getScaledInstance(300, 180, Image.SCALE_DEFAULT));
                       hiace.setIcon(imghiace);
                        carrentpanel.add(hiace);


                       wigo  = new JLabel();
                       wigo.setBounds(15, 135, 500, 400);
                       ImageIcon imgwigo  = new ImageIcon(new ImageIcon("images/wigo.jpg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
                       wigo.setIcon(imgwigo);
                       carrentpanel.add(wigo);

                       vios  = new JLabel();
                       vios.setBounds(635, 380, 500, 400);
                       ImageIcon imgvios  = new ImageIcon(new ImageIcon("images/vios.jpg").getImage().getScaledInstance(300, 169, Image.SCALE_DEFAULT));
                       vios.setIcon(imgvios);
                       carrentpanel.add(vios);

                       civic  = new JLabel();
                       civic.setBounds(15, 380, 500, 400);
                       ImageIcon imgcivic  = new ImageIcon(new ImageIcon("images/civic.jpeg").getImage().getScaledInstance(300, 169, Image.SCALE_DEFAULT));
                       civic.setIcon(imgcivic);
                       carrentpanel.add(civic);

                       //end// images of car
                       ////////////////////////////CLONING///////////////////////////////////////////////////////
                       clonefortunerbtn = new JButton("Select");
                       clonefortunerbtn.setBounds(465, 185, 150,35);
                       clonefortunerbtn.setFont(new Font("Arial", Font.BOLD, 18));
                       clonefortunerbtn.setForeground(Color.black);
                       clonefortunerbtn.setBackground(Color.white);
                       clonefortunerbtn.addActionListener(this);
                       clonefortunerbtn.hide();
                       clonefortunerbtn.setBorderPainted(false);
                       clonefortunerbtn.setFocusPainted(false);
                       carrentpanel.add(clonefortunerbtn);
                       
                       cloneaccordbtn = new JButton("Select");
                       cloneaccordbtn.setBounds(1075, 185, 150,35);
                       cloneaccordbtn.setFont(new Font("Arial", Font.BOLD, 18));
                       cloneaccordbtn.setForeground(Color.black);
                       cloneaccordbtn.setBackground(Color.white);
                       cloneaccordbtn.addActionListener(this);
                       cloneaccordbtn.hide();
                       cloneaccordbtn.setBorderPainted(false);
                       cloneaccordbtn.setFocusPainted(false);
                       carrentpanel.add(cloneaccordbtn);
                       
                       clonecivicbtn = new JButton("Select");
                       clonecivicbtn.setBounds(465, 670, 150,35);
                       clonecivicbtn.setFont(new Font("Arial", Font.BOLD, 18));
                       clonecivicbtn.setForeground(Color.black);
                       clonecivicbtn.setBackground(Color.white);
                       clonecivicbtn.addActionListener(this);
                       clonecivicbtn.hide();
                       clonecivicbtn.setBorderPainted(false);
                       clonecivicbtn.setFocusPainted(false);
                       carrentpanel.add(clonecivicbtn);
                       
                       cloneviosbtn = new JButton("Select");
                       cloneviosbtn.setBounds(1075, 670, 150,35);
                       cloneviosbtn.setFont(new Font("Arial", Font.BOLD, 18));
                       cloneviosbtn.setForeground(Color.black);
                       cloneviosbtn.setBackground(Color.white);
                       cloneviosbtn.addActionListener(this);
                       cloneviosbtn.hide();
                       cloneviosbtn.setBorderPainted(false);
                       cloneviosbtn.setFocusPainted(false);
                       carrentpanel.add(cloneviosbtn);
                       
                       clonewigobtn = new JButton("Select");
                       clonewigobtn.setBounds(465, 430, 150,35);
                       clonewigobtn.setFont(new Font("Arial", Font.BOLD, 18));
                       clonewigobtn.setForeground(Color.black);
                       clonewigobtn.setBackground(Color.white);
                       clonewigobtn.addActionListener(this);
                       clonewigobtn.hide();
                       clonewigobtn.setBorderPainted(false);
                       clonewigobtn.setFocusPainted(false);
                       carrentpanel.add(clonewigobtn);
                       
                       clonehiacebtn = new JButton("Select");
                       clonehiacebtn.setBounds(1075, 430, 150,35);
                       clonehiacebtn.setFont(new Font("Arial", Font.BOLD, 18));
                       clonehiacebtn.setForeground(Color.black);
                       clonehiacebtn.setBackground(Color.white);
                       clonehiacebtn.addActionListener(this);
                       clonehiacebtn.hide();
                       clonehiacebtn.setBorderPainted(false);
                       clonehiacebtn.setFocusPainted(false);
                       carrentpanel.add(clonehiacebtn);

                       //end// Car Button

                       //start// car title

                       fortunertext = new JLabel("Toyota Fortuner");
                       fortunertext.setBounds(335,-20,200,100);
                       fortunertext.setFont(new Font("Arial", Font.BOLD,25));
                       fortunertext.setForeground(Color.BLACK);
                       carrentpanel.add(fortunertext);

                       accordtext = new JLabel("Honda Accord");
                       accordtext.setBounds(955,-20,200,100);
                       accordtext.setFont(new Font("Arial", Font.BOLD,25));
                       accordtext.setForeground(Color.BLACK);
                       carrentpanel.add(accordtext);

                       civictext = new JLabel("Honda Civic");
                       civictext.setBounds(335,465,200,100);
                       civictext.setFont(new Font("Arial", Font.BOLD,25));
                       civictext.setForeground(Color.BLACK);
                       carrentpanel.add(civictext);

                       viostext = new JLabel("Toyota Vios");
                       viostext.setBounds(955,465,200,100);
                       viostext.setFont(new Font("Arial", Font.BOLD,25));
                       viostext.setForeground(Color.BLACK);
                       carrentpanel.add(viostext);

                       wigotext = new JLabel("Toyota Wigo");
                       wigotext.setBounds(335,225,200,50);
                       wigotext.setFont(new Font("Arial", Font.BOLD,25));
                       wigotext.setForeground(Color.BLACK);
                       carrentpanel.add(wigotext);

                       hiacetext = new JLabel("Toyota Hiace");
                       hiacetext.setBounds(955,215,200,100);
                       hiacetext.setFont(new Font("Arial", Font.BOLD,25));
                       hiacetext.setForeground(Color.BLACK);
                       carrentpanel.add(hiacetext);
                       
                       ///////////////////////////////////////////////////////////////
                       
                       fortunerprice = new JLabel("₱1,699/8hrs");
                       fortunerprice.setBounds(480,150,400,100);
                       fortunerprice.setFont(new Font("Arial", Font.BOLD, 20));
                       fortunerprice.setForeground(Color.BLACK);
                       carrentpanel.add(fortunerprice);
                       
                       accordprice = new JLabel("₱1,699/8hrs");
                       accordprice.setBounds(1105, 150, 400,100);
                       accordprice.setFont(new Font("Arial", Font.BOLD, 20));
                       accordprice.setForeground(Color.BLACK);
                       carrentpanel.add(accordprice);
                       
                       civicprice = new JLabel("₱1,699/8hrs");
                       civicprice.setBounds(480, 635, 400,100);
                       civicprice.setFont(new Font("Arial", Font.BOLD, 20));
                       civicprice.setForeground(Color.BLACK);
                       carrentpanel.add(civicprice);
                       
                       viosprice = new JLabel("₱1,699/8hrs");
                       viosprice.setBounds(1105,635, 400,100);
                       viosprice.setFont(new Font("Arial", Font.BOLD, 20));
                       viosprice.setForeground(Color.BLACK);
                       carrentpanel.add(viosprice);
                       
                       wigoprice = new JLabel("₱1,699/8hrs");
                       wigoprice.setBounds(480, 395, 400,100);
                       wigoprice.setFont(new Font("Arial", Font.BOLD, 20));
                       wigoprice.setForeground(Color.BLACK);
                       carrentpanel.add(wigoprice);
                       
                       hiaceprice = new JLabel("₱1,699/8hrs");
                       hiaceprice.setBounds(1105, 395, 400,100);
                       hiaceprice.setFont(new Font("Arial", Font.BOLD, 20));
                       hiaceprice.setForeground(Color.BLACK);
                       carrentpanel.add(hiaceprice);
                       //end// car title


                       //start// car description
                       fortunerinfo = new JTextArea("A mid-size SUV manufactured by the Japanese automaker Toyota since 2004. Built on the Hilux pickup truck platform, "
                               + "it features two/three rows of seats and is available in either rear-wheel drive or four-wheel drive configuration.");
                       fortunerinfo.setBounds(335,50,250,130);
                       fortunerinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       fortunerinfo.setForeground(Color.BLACK);
                       fortunerinfo.setBackground(Color.lightGray);
                       fortunerinfo.setLineWrap(true);
                       fortunerinfo.setWrapStyleWord(true);
                       fortunerinfo.setEditable(false);
                       carrentpanel.add(fortunerinfo);

                       accordinfo = new JTextArea("The Honda Accord is a stylish and efficient commuter, dependable family car and power-hungry sport sedan all wrapped into one.");
                       accordinfo.setBounds(955,50,250,100);
                       accordinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       accordinfo.setForeground(Color.BLACK);
                       accordinfo.setBackground(Color.lightGray);
                       accordinfo.setLineWrap(true);
                       accordinfo.setWrapStyleWord(true);
                       accordinfo.setEditable(false);
                       carrentpanel.add(accordinfo);

                       viosinfo = new JTextArea("The Toyota Vios is a subcompact sedan with 5-seater and comfortable seats that will make sure you won't feel numbness.");
                       viosinfo.setBounds(955,530,250,80);
                       viosinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       viosinfo.setForeground(Color.BLACK);
                        viosinfo.setBackground(Color.lightGray);
                       viosinfo.setLineWrap(true);
                       viosinfo.setWrapStyleWord(true);      
                       viosinfo.setEditable(false);
                       carrentpanel.add(viosinfo);

                       wigoinfo = new JTextArea("The Toyota Wigo is an entry-level hatchback made by Toyota Motor Philippines for urban-dwelling young professionals or those looking for their first car. "
                               + "The Toyota Wigo exudes fun and excitement from any angle.");
                       wigoinfo.setBounds(335,270,250,120);
                       wigoinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       wigoinfo.setForeground(Color.BLACK);
                       wigoinfo.setBackground(Color.lightGray);
                       wigoinfo.setLineWrap(true);
                       wigoinfo.setWrapStyleWord(true);
                       wigoinfo.setEditable(false);
                       carrentpanel.add(wigoinfo);

                       civicinfo = new JTextArea("The honda civic initially gained a reputation for being fuel-efficient, reliable and environmentally friendly. Good for everyday uses.");
                       civicinfo.setBounds(335,530,250,80);
                       civicinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       civicinfo.setForeground(Color.BLACK);
                       civicinfo.setLineWrap(true);
                       civicinfo.setWrapStyleWord(true);
                       civicinfo.setBackground(Color.lightGray);
                       civicinfo.setEditable(false);
                       carrentpanel.add(civicinfo);

                       hiaceinfo = new JTextArea("The Toyota Hiace is a van designed to handle light to medium commercial needs. Since it was introduced in 1967, there have been many iterations if the vehicle, including a minibus, panel van, and MPV.");
                       hiaceinfo.setBounds(955,285,250,120);
                       hiaceinfo.setFont(new Font("Arial", Font.PLAIN,15));
                       hiaceinfo.setForeground(Color.BLACK);
                       hiaceinfo.setLineWrap(true);
                       hiaceinfo.setWrapStyleWord(true);
                       hiaceinfo.setBackground(Color.lightGray);
                       hiaceinfo.setEditable(false);
                       carrentpanel.add(hiaceinfo); 
                       

        fortunerpanel = new JPanel();
        fortunerpanel.setBounds(450,145,1000,600);
        fortunerpanel.setBackground(Color.lightGray);
        fortunerpanel.setLayout(null);
        fortunerpanel.hide();
        add(fortunerpanel);
                         
                                       JLabel fortunerimg = new JLabel();
                                       fortunerimg.setBounds(30,50,650,420);
                                       ImageIcon fortunerIMG  = new ImageIcon(new ImageIcon("images/fortuner.png").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       fortunerimg.setIcon(fortunerIMG);
                                       fortunerpanel.add(fortunerimg);                        
                                       
                                       JLabel fortunertitle = new JLabel("Toyota Fortuner");
                                       fortunertitle.setBounds(640,80,500,100);
                                       fortunertitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       fortunertitle.setForeground(Color.black);
                                       fortunerpanel.add(fortunertitle);
                                       
                                       fortunerreturnbtn = new JButton();
                                       fortunerreturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon rtnbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       fortunerreturnbtn.setBackground(Color.white);
                                       fortunerreturnbtn.setBorderPainted(false);
                                       fortunerreturnbtn.addActionListener(this);
                                       fortunerreturnbtn.setFocusPainted(false);
                                       fortunerreturnbtn.setIcon(rtnbtn);
                                       fortunerpanel.add(fortunerreturnbtn);
                                       
                                       JLabel fortunerstatus = new JLabel("Status:");
                                       fortunerstatus.setBounds(640,500,500,100);
                                       fortunerstatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       fortunerstatus.setForeground(Color.black);
                                       fortunerpanel.add(fortunerstatus);
                                       
                                       statusavailability = new JTextArea("Available");
                                       statusavailability.setBounds(740,535,500,100);
                                       statusavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       statusavailability.setForeground(Color.GREEN);
                                       statusavailability.setEditable(false);
                                       fortunerpanel.add(statusavailability);
                                       
                                       JLabel fortunerdescrip = new JLabel("Seating Capacity: 7");
                                       fortunerdescrip.setBounds(640,150,500,100);
                                       fortunerdescrip.setFont(new Font("Arial", Font.PLAIN, 18));
                                       fortunerdescrip.setForeground(Color.black);
                                       fortunerpanel.add(fortunerdescrip);
                                       
                                       JLabel fortunerdescrip1 = new JLabel("Transmission Type: Automatic");
                                       fortunerdescrip1.setBounds(640,180,500,100);
                                       fortunerdescrip1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       fortunerdescrip1.setForeground(Color.black);
                                       fortunerpanel.add(fortunerdescrip1);
                                       
                                       JLabel fortunerdescrip2 = new JLabel("Fuel Consumption: 8.0 km per Liter");
                                       fortunerdescrip2.setBounds(640,210,500,100);
                                       fortunerdescrip2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       fortunerdescrip2.setForeground(Color.black);
                                       fortunerpanel.add(fortunerdescrip2);
                                       
                                       JLabel fortunerdescrip3 = new JLabel("Features:");
                                       fortunerdescrip3.setBounds(640,260,500,100);
                                       fortunerdescrip3.setFont(new Font("Arial", Font.BOLD, 18));
                                       fortunerdescrip3.setForeground(Color.black);
                                       fortunerpanel.add(fortunerdescrip3);
                                       
                                       JTextArea fortunerdescrip4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag");
                                       fortunerdescrip4.setBounds(640,330,200,100);
                                       fortunerdescrip4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       fortunerdescrip4.setForeground(Color.black);
                                       fortunerdescrip4.setLineWrap(true);
                                        fortunerdescrip4.setWrapStyleWord(true);
                                       fortunerpanel.add(fortunerdescrip4);
                                       
                                       

                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel fortunertitlebg = new JPanel();
                                       fortunertitlebg.setBounds(0,10,1230,60);
                                       fortunertitlebg.setBackground(new Color(24,70,53));
                                       fortunerpanel.add(fortunertitlebg);
                                       
                                       JPanel fortunertitleblackbg = new JPanel();
                                       fortunertitleblackbg.setBounds(0,15,1230,680);
                                       fortunertitleblackbg.setBackground(Color.white);
                                       fortunerpanel.add(fortunertitleblackbg);
                                       
        accordpanel = new JPanel();
        accordpanel.setBounds(450,145,1000,600);
        accordpanel.setBackground(Color.lightGray);
        accordpanel.setLayout(null);
        accordpanel.hide();
        add(accordpanel);
                         
                                       JLabel accordimg = new JLabel();
                                       accordimg.setBounds(30,50,650,420);
                                       ImageIcon accordIMG  = new ImageIcon(new ImageIcon("images/accord.png").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       accordimg.setIcon(accordIMG);
                                       accordpanel.add(accordimg);                        
                                       
                                       JLabel accordtitle = new JLabel("Honda Accord");
                                       accordtitle.setBounds(640,80,500,100);
                                       accordtitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       accordtitle.setForeground(Color.black);
                                       accordpanel.add(accordtitle);
                                       
                                       accordreturnbtn = new JButton();
                                       accordreturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon accordrtnbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       accordreturnbtn.setBackground(Color.white);
                                       accordreturnbtn.setBorderPainted(false);
                                       accordreturnbtn.addActionListener(this);
                                       accordreturnbtn.setFocusPainted(false);
                                       accordreturnbtn.setIcon(accordrtnbtn);
                                       accordpanel.add(accordreturnbtn);
                                       
                                       JLabel accordstatus = new JLabel("Status:");
                                       accordstatus.setBounds(640,500,500,100);
                                       accordstatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       accordstatus.setForeground(Color.black);
                                       accordpanel.add(accordstatus);
                                       
                                       accordstatusavailability = new JTextArea("Available");
                                       accordstatusavailability.setBounds(740,535,500,100);
                                       accordstatusavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       accordstatusavailability.setForeground(Color.GREEN);
                                       accordstatusavailability.setEditable(false);
                                       accordpanel.add(accordstatusavailability);
                                       
                                       JLabel accorddescrip = new JLabel("Seating Capacity: 5");
                                       accorddescrip.setBounds(640,150,500,100);
                                       accorddescrip.setFont(new Font("Arial", Font.PLAIN, 18));
                                       accorddescrip.setForeground(Color.black);
                                       accordpanel.add(accorddescrip);
                                       
                                       JLabel accorddescrip1 = new JLabel("Transmission Type: Automatic");
                                       accorddescrip1.setBounds(640,180,500,100);
                                       accorddescrip1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       accorddescrip1.setForeground(Color.black);
                                       accordpanel.add(accorddescrip1);
                                       
                                       JLabel accorddescrip2 = new JLabel("Fuel Consumption: 18.54 km per Liter");
                                       accorddescrip2.setBounds(640,210,500,100);
                                       accorddescrip2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       accorddescrip2.setForeground(Color.black);
                                       accordpanel.add(accorddescrip2);
                                       
                                       JLabel accorddescrip3 = new JLabel("Features:");
                                       accorddescrip3.setBounds(640,260,500,100);
                                       accorddescrip3.setFont(new Font("Arial", Font.BOLD, 18));
                                       accorddescrip3.setForeground(Color.black);
                                       accordpanel.add(accorddescrip3);
                                       
                                       JTextArea accorddescrip4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag, Automatic Climate Control");
                                       accorddescrip4.setBounds(640,330,200,130);
                                       accorddescrip4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       accorddescrip4.setForeground(Color.black);
                                       accorddescrip4.setLineWrap(true);
                                        accorddescrip4.setWrapStyleWord(true);
                                       accordpanel.add(accorddescrip4);
                                       
                                       

                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel accordtitlebg = new JPanel();
                                       accordtitlebg.setBounds(0,10,1230,60);
                                       accordtitlebg.setBackground(new Color(24,70,53));
                                       accordpanel.add(accordtitlebg);
                                       
                                       JPanel accordtitlebgclr = new JPanel();
                                       accordtitlebgclr.setBounds(0,15,1230,680);
                                       accordtitlebgclr.setBackground(Color.white);
                                       accordpanel.add(accordtitlebgclr);
       
        wigopanel = new JPanel();
        wigopanel.setBounds(450,145,1000,600);
        wigopanel.setBackground(Color.lightGray);
        wigopanel.setLayout(null);
        wigopanel.hide();
        add(wigopanel);
                         
                                       JLabel wigoimg = new JLabel();
                                       wigoimg.setBounds(30,50,650,420);
                                       ImageIcon wigoIMG  = new ImageIcon(new ImageIcon("images/wigo.jpg").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       wigoimg.setIcon(wigoIMG);
                                       wigopanel.add(wigoimg);                        
                                       
                                       JLabel wigotitle = new JLabel("Toyota Wigo");
                                       wigotitle.setBounds(640,80,500,100);
                                       wigotitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       wigotitle.setForeground(Color.black);
                                       wigopanel.add(wigotitle);
                                       
                                       wigoreturnbtn = new JButton();
                                       wigoreturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon wigortnbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       wigoreturnbtn.setBackground(Color.white);
                                       wigoreturnbtn.setBorderPainted(false);
                                       wigoreturnbtn.addActionListener(this);
                                       wigoreturnbtn.setFocusPainted(false);
                                       wigoreturnbtn.setIcon(wigortnbtn);
                                       wigopanel.add(wigoreturnbtn);
                                       
                                       JLabel wigostatus = new JLabel("Status:");
                                       wigostatus.setBounds(640,500,500,100);
                                       wigostatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       wigostatus.setForeground(Color.black);
                                       wigopanel.add(wigostatus);
                                       
                                        wigoavailability = new JTextArea("Available");
                                       wigoavailability.setBounds(740,535,500,100);
                                       wigoavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       wigoavailability.setForeground(Color.GREEN);
                                       wigoavailability.setEditable(false);
                                       wigopanel.add(wigoavailability);
                                       
                                       JLabel wigodescrip = new JLabel("Seating Capacity: 5");
                                       wigodescrip.setBounds(640,150,500,100);
                                       wigodescrip.setFont(new Font("Arial", Font.PLAIN, 18));
                                       wigodescrip.setForeground(Color.black);
                                       wigopanel.add(wigodescrip);
                                       
                                       JLabel wigodescrip1 = new JLabel("Transmission Type: Manual / CVT");
                                       wigodescrip1.setBounds(640,180,500,100);
                                       wigodescrip1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       wigodescrip1.setForeground(Color.black);
                                       wigopanel.add(wigodescrip1);
                                       
                                       JLabel wigodescript2 = new JLabel("Fuel Consumption: 20 km per Liter");
                                       wigodescript2.setBounds(640,210,500,100);
                                       wigodescript2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       wigodescript2.setForeground(Color.black);
                                       wigopanel.add(wigodescript2);
                                       
                                       JLabel wigodescript3 = new JLabel("Features:");
                                       wigodescript3.setBounds(640,260,500,100);
                                       wigodescript3.setFont(new Font("Arial", Font.BOLD, 18));
                                       wigodescript3.setForeground(Color.black);
                                       wigopanel.add(wigodescript3);
                                       
                                       JTextArea wigodescript4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag");
                                       wigodescript4.setBounds(640,330,200,100);
                                       wigodescript4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       wigodescript4.setForeground(Color.black);
                                       wigodescript4.setLineWrap(true);
                                        wigodescript4.setWrapStyleWord(true);
                                       wigopanel.add(wigodescript4);
                                       
                                       

                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel wigotitlebg = new JPanel();
                                       wigotitlebg.setBounds(0,10,1230,60);
                                       wigotitlebg.setBackground(new Color(24,70,53));
                                       wigopanel.add(wigotitlebg);
                                       
                                       JPanel wigotitlebgclr = new JPanel();
                                       wigotitlebgclr.setBounds(0,15,1230,680);
                                       wigotitlebgclr.setBackground(Color.white);
                                       wigopanel.add(wigotitlebgclr);
                                       
        civicpanel = new JPanel();
        civicpanel.setBounds(450,145,1000,600);
        civicpanel.setBackground(Color.lightGray);
        civicpanel.setLayout(null);
        civicpanel.hide();
        add(civicpanel);
                         
                                       JLabel civicimage = new JLabel();
                                       civicimage.setBounds(30,50,650,420);
                                       ImageIcon civicimg  = new ImageIcon(new ImageIcon("images/civic.jpeg").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       civicimage.setIcon(civicimg);
                                       civicpanel.add(civicimage);                        
                                       
                                       JLabel civictitle = new JLabel("Honda Civic");
                                       civictitle.setBounds(640,80,500,100);
                                       civictitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       civictitle.setForeground(Color.black);
                                       civicpanel.add(civictitle);
                                       
                                       civicreturnbtn = new JButton();
                                       civicreturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon civicrbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       civicreturnbtn.setBackground(Color.white);
                                       civicreturnbtn.setBorderPainted(false);
                                       civicreturnbtn.addActionListener(this);
                                       civicreturnbtn.setFocusPainted(false);
                                       civicreturnbtn.setIcon(civicrbtn);
                                       civicpanel.add(civicreturnbtn);
                                       
                                       JLabel civicstatus = new JLabel("Status:");
                                       civicstatus.setBounds(640,500,500,100);
                                       civicstatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       civicstatus.setForeground(Color.black);
                                       civicpanel.add(civicstatus);
                                       
                                        civicavailability = new JTextArea("Available");
                                       civicavailability.setBounds(740,535,500,100);
                                       civicavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       civicavailability.setForeground(Color.GREEN);
                                       civicavailability.setEditable(false);
                                       civicpanel.add(civicavailability);
                                       
                                       JLabel civicdescript = new JLabel("Seating Capacity: 5");
                                       civicdescript.setBounds(640,150,500,100);
                                       civicdescript.setFont(new Font("Arial", Font.PLAIN, 18));
                                       civicdescript.setForeground(Color.black);
                                       civicpanel.add(civicdescript);
                                       
                                       JLabel civicdescript1 = new JLabel("Transmission Type: CVT");
                                       civicdescript1.setBounds(640,180,500,100);
                                       civicdescript1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       civicdescript1.setForeground(Color.black);
                                       civicpanel.add(civicdescript1);
                                       
                                       JLabel civicdescript2 = new JLabel("Fuel Consumption: 21.43 km per Liter");
                                       civicdescript2.setBounds(640,210,500,100);
                                       civicdescript2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       civicdescript2.setForeground(Color.black);
                                       civicpanel.add(civicdescript2);
                                       
                                       JLabel civicdescript3 = new JLabel("Features:");
                                       civicdescript3.setBounds(640,260,500,100);
                                       civicdescript3.setFont(new Font("Arial", Font.BOLD, 18));
                                       civicdescript3.setForeground(Color.black);
                                       civicpanel.add(civicdescript3);
                                       
                                       JTextArea civicdescript4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag");
                                       civicdescript4.setBounds(640,330,200,100);
                                       civicdescript4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       civicdescript4.setForeground(Color.black);
                                       civicdescript4.setLineWrap(true);
                                        civicdescript4.setWrapStyleWord(true);
                                       civicpanel.add(civicdescript4);
                                       
                                       

                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel civicpaneltitlebg = new JPanel();
                                       civicpaneltitlebg.setBounds(0,10,1230,60);
                                       civicpaneltitlebg.setBackground(new Color(24,70,53));
                                       civicpanel.add(civicpaneltitlebg);
                                       
                                       JPanel civicpaneltitlebgclr = new JPanel();
                                       civicpaneltitlebgclr.setBounds(0,15,1230,680);
                                       civicpaneltitlebgclr.setBackground(Color.white);
                                       civicpanel.add(civicpaneltitlebgclr);
                                       
      viospanel = new JPanel();
        viospanel.setBounds(450,145,1000,600);
        viospanel.setBackground(Color.lightGray);
        viospanel.setLayout(null);
        viospanel.hide();
        add(viospanel);
                         
                                       JLabel viosimage = new JLabel();
                                       viosimage.setBounds(30,50,650,420);
                                       ImageIcon viosimg  = new ImageIcon(new ImageIcon("images/vios.jpg").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       viosimage.setIcon(viosimg);
                                       viospanel.add(viosimage);                        
                                       
                                       JLabel viostitle = new JLabel("Toyota Vios");
                                       viostitle.setBounds(640,80,500,100);
                                       viostitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       viostitle.setForeground(Color.black);
                                       viospanel.add(viostitle);
                                       
                                       viosreturnbtn = new JButton();
                                       viosreturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon viosrtnbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       viosreturnbtn.setBackground(Color.white);
                                       viosreturnbtn.setBorderPainted(false);
                                       viosreturnbtn.addActionListener(this);
                                       viosreturnbtn.setFocusPainted(false);
                                       viosreturnbtn.setIcon(viosrtnbtn);
                                       viospanel.add(viosreturnbtn);
                                       
                                       JLabel viosstatus = new JLabel("Status:");
                                       viosstatus.setBounds(640,500,500,100);
                                       viosstatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       viosstatus.setForeground(Color.black);
                                       viospanel.add(viosstatus);
                                       
                                        viosavailability = new JTextArea("Available");
                                       viosavailability.setBounds(740,535,500,100);
                                       viosavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       viosavailability.setForeground(Color.GREEN);
                                       viosavailability.setEditable(false);
                                       viospanel.add(viosavailability);
                                       
                                       JLabel viosdescript = new JLabel("Seating Capacity: 5");
                                       viosdescript.setBounds(640,150,500,100);
                                       viosdescript.setFont(new Font("Arial", Font.PLAIN, 18));
                                       viosdescript.setForeground(Color.black);
                                       viospanel.add(viosdescript);
                                       
                                       JLabel viosdescript1 = new JLabel("Transmission Type: Manual / CVT");
                                       viosdescript1.setBounds(640,180,500,100);
                                       viosdescript1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       viosdescript1.setForeground(Color.black);
                                       viospanel.add(viosdescript1);
                                       
                                       JLabel viosdescript2 = new JLabel("Fuel Consumption: 24 km per Liter");
                                       viosdescript2.setBounds(640,210,500,100);
                                       viosdescript2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       viosdescript2.setForeground(Color.black);
                                       viospanel.add(viosdescript2);
                                       
                                       JLabel viosdescript3 = new JLabel("Features:");
                                       viosdescript3.setBounds(640,260,500,100);
                                       viosdescript3.setFont(new Font("Arial", Font.BOLD, 18));
                                       viosdescript3.setForeground(Color.black);
                                       viospanel.add(viosdescript3);
                                       
                                       JTextArea viosdescript4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag");
                                       viosdescript4.setBounds(640,330,200,100);
                                       viosdescript4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       viosdescript4.setForeground(Color.black);
                                       viosdescript4.setLineWrap(true);
                                        viosdescript4.setWrapStyleWord(true);
                                       viospanel.add(viosdescript4);
                                       
                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel viospaneltitlebg = new JPanel();
                                       viospaneltitlebg.setBounds(0,10,1230,60);
                                       viospaneltitlebg.setBackground(new Color(24,70,53));
                                       viospanel.add(viospaneltitlebg);
                                       
                                       JPanel viospaneltitlebgclr = new JPanel();
                                       viospaneltitlebgclr.setBounds(0,15,1230,680);
                                       viospaneltitlebgclr.setBackground(Color.white);
                                       viospanel.add(viospaneltitlebgclr);

        hiacepanel = new JPanel();
        hiacepanel.setBounds(450,145,1000,600);
        hiacepanel.setBackground(Color.lightGray);
        hiacepanel.setLayout(null);
        hiacepanel.hide();
        add(hiacepanel);
                         
                                       JLabel hiaceimage = new JLabel();
                                       hiaceimage.setBounds(30,50,650,420);
                                       ImageIcon hiaceimg  = new ImageIcon(new ImageIcon("images/hiace.jpg").getImage().getScaledInstance(550, 320, Image.SCALE_DEFAULT));
                                       hiaceimage.setIcon(hiaceimg);
                                       hiacepanel.add(hiaceimage);                        
                                       
                                       JLabel hiacetitle = new JLabel("Toyota Hiace");
                                       hiacetitle.setBounds(640,80,500,100);
                                       hiacetitle.setFont(new Font("Arial", Font.BOLD, 41));
                                       hiacetitle.setForeground(Color.black);
                                       hiacepanel.add(hiacetitle);
                                       
                                       hiacereturnbtn = new JButton();
                                       hiacereturnbtn.setBounds(930, 530,50,50);
                                       ImageIcon hiacertnbtn  = new ImageIcon(new ImageIcon("images/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                       hiacereturnbtn.setBackground(Color.white);
                                       hiacereturnbtn.setBorderPainted(false);
                                       hiacereturnbtn.addActionListener(this);
                                       hiacereturnbtn.setFocusPainted(false);
                                       hiacereturnbtn.setIcon(hiacertnbtn);
                                       hiacepanel.add(hiacereturnbtn);
                                       
                                       JLabel hiacestatus = new JLabel("Status:");
                                       hiacestatus.setBounds(640,500,500,100);
                                       hiacestatus.setFont(new Font("Arial", Font.BOLD, 25));
                                       hiacestatus.setForeground(Color.black);
                                       hiacepanel.add(hiacestatus);
                                       
                                        hiaceavailability = new JTextArea("Available");
                                       hiaceavailability.setBounds(740,535,500,100);
                                       hiaceavailability.setFont(new Font("Arial", Font.BOLD, 25));
                                       hiaceavailability.setForeground(Color.GREEN);
                                       hiaceavailability.setEditable(false);
                                       hiacepanel.add(hiaceavailability);
                                       
                                       JLabel hiacedescript = new JLabel("Seating Capacity: 15");
                                       hiacedescript.setBounds(640,150,500,100);
                                       hiacedescript.setFont(new Font("Arial", Font.PLAIN, 18));
                                       hiacedescript.setForeground(Color.black);
                                       hiacepanel.add(hiacedescript);
                                       
                                       JLabel hiacedescript1 = new JLabel("Transmission Type: Manual / Automatic");
                                       hiacedescript1.setBounds(640,180,500,100);
                                       hiacedescript1.setFont(new Font("Arial", Font.PLAIN, 18));
                                       hiacedescript1.setForeground(Color.black);
                                       hiacepanel.add(hiacedescript1);
                                       
                                       JLabel hiacedescript2 = new JLabel("Fuel Consumption: 12.5 km per Liter");
                                       hiacedescript2.setBounds(640,210,500,100);
                                       hiacedescript2.setFont(new Font("Arial", Font.PLAIN, 18));
                                       hiacedescript2.setForeground(Color.black);
                                       hiacepanel.add(hiacedescript2);
                                       
                                       JLabel hiacedescript3 = new JLabel("Features:");
                                       hiacedescript3.setBounds(640,260,500,100);
                                       hiacedescript3.setFont(new Font("Arial", Font.BOLD, 18));
                                       hiacedescript3.setForeground(Color.black);
                                       hiacepanel.add(hiacedescript3);
                                       
                                       JTextArea hiacedescript4 = new JTextArea("Air Conditioner, Anti Lock Braking System, Driver Airbag, Power Steering, Passenger Airbag, Crash Sensor, Engine Immobilizer");
                                       hiacedescript4.setBounds(640,330,200,130);
                                       hiacedescript4.setFont(new Font("Arial", Font.PLAIN, 18));
                                       hiacedescript4.setForeground(Color.black);
                                       hiacedescript4.setLineWrap(true);
                                        hiacedescript4.setWrapStyleWord(true);
                                       hiacepanel.add(hiacedescript4);
                                       
                                       /////////////////////////////////////////////////////////////////////////////////////
                                       
                                       JPanel hiacepaneltitlebg = new JPanel();
                                       hiacepaneltitlebg.setBounds(0,10,1230,60);
                                       hiacepaneltitlebg.setBackground(new Color(24,70,53));
                                       hiacepanel.add(hiacepaneltitlebg);
                                       
                                       JPanel hiacepaneltitlebgclr = new JPanel();
                                       hiacepaneltitlebgclr.setBounds(0,15,1230,680);
                                       hiacepaneltitlebgclr.setBackground(Color.white);
                                       hiacepanel.add(hiacepaneltitlebgclr);
                                       
       carrepairpanel = new JPanel();
       carrepairpanel.setBounds(0,0,1600,1280);
       carrepairpanel.setBackground(Color.lightGray);
       carrepairpanel.setLayout(null);
       carrepairpanel.setVisible(false);
       add(carrepairpanel);
       
       bookingpanel = new JPanel();
        bookingpanel.setBounds(290,155,1000,650);
        bookingpanel.setBackground(Color.white);
        bookingpanel.setLayout(null);
        bookingpanel.hide();
        add(bookingpanel);

                           JLabel bookingitle = new JLabel("Your Booking #: "); //title for details
                           bookingitle.setBounds(65,14,330,40);
                           bookingitle.setFont(new Font("Arial", Font.BOLD, 28));
                           bookingitle.setForeground(Color.white);
                           bookingpanel.add(bookingitle);
                           
                                       area10 = new JTextArea("");
                                       area10.setBounds(280,18,200,30);
                                       area10.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area10.setForeground(Color.white);
                                       area10.setBackground(new Color(24,70,53));
                                       area10.setLineWrap(true);
                                       area10.setEditable(false);
                                        area10.setWrapStyleWord(true);
                                       bookingpanel.add(area10);
                             
                          JLabel pickupname = new JLabel("Pick-Up Location"); //title for details
                           pickupname.setBounds(65,90,250,25);
                           pickupname.setFont(new Font("Arial", Font.BOLD, 23));
                           pickupname.setForeground(Color.white);
                           bookingpanel.add(pickupname);
                           
                                       area = new JTextArea("");
                                       area.setBounds(65,130,200,30);
                                       area.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area.setForeground(Color.black);
                                       area.setLineWrap(true);
                                       area.setEditable(false);
                                        area.setWrapStyleWord(true);
                                       bookingpanel.add(area);
                                       
                           JLabel dropoffpname = new JLabel("Drop-Off Location"); //title for details
                           dropoffpname.setBounds(65,190,250,25);
                           dropoffpname.setFont(new Font("Arial", Font.BOLD, 23));
                           dropoffpname.setForeground(Color.white);
                           bookingpanel.add(dropoffpname);
                           
                                     area1 = new JTextArea("");
                                       area1.setBounds(65,230,200,30);
                                       area1.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area1.setForeground(Color.black);
                                       area1.setLineWrap(true);
                                       area1.setEditable(false);
                                        area1.setWrapStyleWord(true);
                                       bookingpanel.add(area1);
                             
                            JLabel pickuplocname = new JLabel("Pick-Up Date"); //title for details
                           pickuplocname.setBounds(65,290,250,25);
                           pickuplocname.setFont(new Font("Arial", Font.BOLD, 23));
                           pickuplocname.setForeground(Color.white);
                           bookingpanel.add(pickuplocname);
                           
                                       area2 = new JTextArea("");
                                       area2.setBounds(65,330,200,30);
                                       area2.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area2.setForeground(Color.black);
                                       area2.setLineWrap(true);
                                       area2.setEditable(false);
                                        area2.setWrapStyleWord(true);
                                       bookingpanel.add(area2);                
                                       
                           JLabel dropoffnameloc = new JLabel("Drop-Off Date"); //title for details
                           dropoffnameloc.setBounds(65,390,250,25);
                           dropoffnameloc.setFont(new Font("Arial", Font.BOLD, 23));
                           dropoffnameloc.setForeground(Color.white);
                           bookingpanel.add(dropoffnameloc);
                           
                                       area3 = new JTextArea("");
                                       area3.setBounds(65,430,200,30);
                                       area3.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area3.setForeground(Color.black);
                                       area3.setLineWrap(true);
                                       area3.setEditable(false);
                                        area3.setWrapStyleWord(true);
                                       bookingpanel.add(area3);     
                                       
                            JLabel pickuptimee = new JLabel("Pick-up Time"); //title for details
                           pickuptimee.setBounds(65,490,250,25);
                           pickuptimee.setFont(new Font("Arial", Font.BOLD, 23));
                           pickuptimee.setForeground(Color.white);
                           bookingpanel.add(pickuptimee);
                           
                                       area4 = new JTextArea("");
                                       area4.setBounds(65,530,200,30);
                                       area4.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area4.setForeground(Color.black);
                                       area4.setLineWrap(true);
                                       area4.setEditable(false);
                                        area4.setWrapStyleWord(true);
                                       bookingpanel.add(area4);      
                          JLabel dropofftimee = new JLabel("Drop-Off Time"); //title for details
                           dropofftimee.setBounds(385,90,250,25);
                           dropofftimee.setFont(new Font("Arial", Font.BOLD, 23));
                           dropofftimee.setForeground(Color.white);
                           bookingpanel.add(dropofftimee);
                                        area5 = new JTextArea("");
                                       area5.setBounds(380,130,200,30);
                                       area5.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area5.setForeground(Color.black);
                                       area5.setLineWrap(true);
                                       area5.setEditable(false);
                                        area5.setWrapStyleWord(true);
                                       bookingpanel.add(area5);   
                           JLabel nameofbooking = new JLabel("Name"); //title for details
                           nameofbooking.setBounds(705,90,250,25);
                           nameofbooking.setFont(new Font("Arial", Font.BOLD, 23));
                           nameofbooking.setForeground(Color.white);
                           bookingpanel.add(nameofbooking);
                           
                                       area6 = new JTextArea("");
                                       area6.setBounds(705,130,200,30);
                                       area6.setFont(new Font("Arial", Font.PLAIN, 23));
                                       area6.setForeground(Color.black);;
                                       area6.setLineWrap(true);
                                       area6.setEditable(false);
                                        area6.setWrapStyleWord(true);
                                       bookingpanel.add(area6);   
                                       
                           JLabel phoneofbooking = new JLabel("Phone Number"); //title for details
                           phoneofbooking.setBounds(705,190,250,25);
                           phoneofbooking.setFont(new Font("Arial", Font.BOLD, 23));
                           phoneofbooking.setForeground(Color.white);
                           bookingpanel.add(phoneofbooking);
                           
                                       area7 = new JTextArea("");
                                       area7.setBounds(705,230,200,30);
                                       area7.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area7.setForeground(Color.black);
                                       area7.setLineWrap(true);
                                       area7.setEditable(false);
                                        area7.setWrapStyleWord(true);
                                       bookingpanel.add(area7);        
                                       
                            JLabel emailofchoosing = new JLabel("Email Address"); //title for details
                           emailofchoosing.setBounds(705,290,300,25);
                           emailofchoosing.setFont(new Font("Arial", Font.BOLD, 20));
                           emailofchoosing.setForeground(Color.white);
                           bookingpanel.add(emailofchoosing);
                           
                                        area8 = new JTextArea("");
                                       area8.setBounds(705,330,250,30);
                                       area8.setFont(new Font("Arial", Font.PLAIN, 23));
                                       area8.setForeground(Color.black);
                                       area8.setLineWrap(true);
                                       area8.setEditable(false);
                                        area8.setWrapStyleWord(true);
                                       bookingpanel.add(area8); 
                                       
                               JLabel carofchoosing = new JLabel("Car to Rent"); //title for details
                           carofchoosing.setBounds(705,390,250,25);
                           carofchoosing.setFont(new Font("Arial", Font.BOLD, 23));
                           carofchoosing.setForeground(Color.white);
                           bookingpanel.add(carofchoosing);
                           
                                        area9 = new JTextArea("");
                                       area9.setBounds(705,430,200,30);
                                       area9.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area9.setLineWrap(true);
                                       area9.setEditable(false);
                                        area9.setWrapStyleWord(true);
                                       bookingpanel.add(area9); 
                                       
                                       
                           JLabel paymenttext = new JLabel("Payment Method"); //title for details
                           paymenttext.setBounds(705,490,250,25);
                           paymenttext.setFont(new Font("Arial", Font.BOLD, 23));
                           paymenttext.setForeground(Color.white);
                           bookingpanel.add(paymenttext);
                           
                                        area12 = new JTextArea("");
                                       area12.setBounds(705,530,200,30);
                                       area12.setFont(new Font("Arial", Font.PLAIN, 28));
                                       area12.setLineWrap(true);
                                       area12.setEditable(false);
                                        area12.setWrapStyleWord(true);
                                       bookingpanel.add(area12); 
                                       
                           cancelbutton = new JButton("Go Back");
                           cancelbutton.setBounds(830, 600, 150,35);
                           cancelbutton.setFont(new Font("Arial", Font.BOLD, 18));
                           cancelbutton.setForeground(Color.black);
                           cancelbutton.setBackground(Color.lightGray);
                           cancelbutton.addActionListener(this);
                           cancelbutton.setBorderPainted(false);
                           cancelbutton.setFocusPainted(false);
                            bookingpanel.add(cancelbutton);                                  
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            JPanel areabg = new JPanel();
                            areabg.setBounds(60,87,205,35);
                            areabg.setBackground(new Color(24,70,53));
                            areabg.setLayout(null);
                            bookingpanel.add(areabg);
                            
                             JPanel areabg1 = new JPanel();
                            areabg1.setBounds(60,187,205,35);
                            areabg1.setBackground(new Color(24,70,53));
                            areabg1.setLayout(null);
                            bookingpanel.add(areabg1);                           
 
                              JPanel areabg2 = new JPanel();
                            areabg2.setBounds(60,287,205,35);
                            areabg2.setBackground(new Color(24,70,53));
                            areabg2.setLayout(null);
                            bookingpanel.add(areabg2); 
                            
                             JPanel areabg3 = new JPanel();
                            areabg3.setBounds(60,387,205,35);
                            areabg3.setBackground(new Color(24,70,53));
                            areabg3.setLayout(null);
                            bookingpanel.add(areabg3);  
                            
                             JPanel areabg4 = new JPanel();
                            areabg4.setBounds(60,487,205,35);
                            areabg4.setBackground(new Color(24,70,53));
                            areabg4.setLayout(null);
                            bookingpanel.add(areabg4);  
                            
                             JPanel areabg5 = new JPanel();
                            areabg5.setBounds(380,87,205,35);
                            areabg5.setBackground(new Color(24,70,53));
                            areabg5.setLayout(null);
                            bookingpanel.add(areabg5);  
                            
                             JPanel areabg6 = new JPanel();
                            areabg6.setBounds(700,187,205,35);
                            areabg6.setBackground(new Color(24,70,53));
                            areabg6.setLayout(null);
                            bookingpanel.add(areabg6);  
                            
                             JPanel areabg7 = new JPanel();
                            areabg7.setBounds(700,287,205,35);
                            areabg7.setBackground(new Color(24,70,53));
                            areabg7.setLayout(null);
                            bookingpanel.add(areabg7);
                            
                             JPanel areabg8 = new JPanel();
                            areabg8.setBounds(700,387,205,35);
                            areabg8.setBackground(new Color(24,70,53));
                            areabg8.setLayout(null);
                            bookingpanel.add(areabg8);  
                            
                             JPanel areabg9 = new JPanel();
                            areabg9.setBounds(700,487,205,35);
                            areabg9.setBackground(new Color(24,70,53));
                            areabg9.setLayout(null);
                            bookingpanel.add(areabg9);  
                            
                            JPanel areabg10 = new JPanel();
                            areabg10.setBounds(700,87,205,35);
                            areabg10.setBackground(new Color(24,70,53));
                            areabg10.setLayout(null);
                            bookingpanel.add(areabg10);  
         ////////////////////////////////////////////////////////////////////////////////////////                   
                            JPanel greenbg = new JPanel();
                            greenbg.setBounds(0,0,1000,60);
                            greenbg.setBackground(new Color(24,70,53));
                            greenbg.setLayout(null);
                            bookingpanel.add(greenbg);
                            
        savepdf = new JPanel();
        savepdf.setBounds(290,155,1000,650);
        savepdf.setBackground(Color.white);
        savepdf.setLayout(null);
        savepdf.hide();
        add(savepdf);
                        
                            JLabel bookingnum = new JLabel("Your Booking #: "); //title for details
                           bookingnum.setBounds(65,14,330,40);
                           bookingnum.setFont(new Font("Arial", Font.BOLD, 28));
                           bookingnum.setForeground(Color.white);
                           savepdf.add(bookingnum);
                           
                            JLabel warning = new JLabel("Please Save your Booking Number & Rental Invoice."); //title for details
                           warning.setBounds(160,200,6000,40);
                           warning.setFont(new Font("Arial", Font.BOLD, 28));
                           warning.setForeground(Color.black);
                           savepdf.add(warning);
                           
                           area11 = new JTextArea("");
                           area11.setBounds(280,18,200,30);
                           area11.setFont(new Font("Arial", Font.PLAIN, 28));
                           area11.setForeground(Color.white);
                           area11.setBackground(new Color(24,70,53));
                           area11.setLineWrap(true);
                           area11.setEditable(false);
                            area11.setWrapStyleWord(true);
                           savepdf.add(area11);
                           
                           
                           savebutton = new JButton("Save Your Rental Invoice");
                           savebutton.setBounds(380, 600, 250,35);
                           savebutton.setFont(new Font("Arial", Font.BOLD, 18));
                           savebutton.setForeground(Color.black);
                           savebutton.setBackground(Color.lightGray);
                           savebutton.addActionListener(this);
                           savebutton.setBorderPainted(false);
                           savebutton.setFocusPainted(false);
                            savepdf.add(savebutton);                               
 //////////////////////////////////////////////////////////////////////////////////////////////////                          
                           
                            JPanel greenbgsavepdf = new JPanel();
                            greenbgsavepdf.setBounds(0,0,1000,60);
                            greenbgsavepdf.setBackground(new Color(24,70,53));
                            greenbgsavepdf.setLayout(null);
                            savepdf.add(greenbgsavepdf);
                            
       superpanel = new JPanel();
       superpanel.setBounds(0,0,1600,1280);
       superpanel.setBackground(Color.lightGray);
       superpanel.setVisible(true);
       superpanel.setLayout(null);
       superpanel.add(savepdf);
       superpanel.add(bookingpanel);
       superpanel.add(fortunerpanel);
       superpanel.add(accordpanel);
       superpanel.add(wigopanel);
       superpanel.add(viospanel);
       superpanel.add(hiacepanel);
       superpanel.add(civicpanel);
       superpanel.add(namepanel);
       superpanel.add(caravailpanel);
       superpanel.add(bookreservpanl);
       superpanel.add(carrepairpanel);
       superpanel.add(carrentpanel);
        add(superpanel);
       
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){  
             JComboBox[] arraycombobox = new JComboBox[]{pickupfield,dropofffield,Datefield,Mnth,Yr,dropMonth,dropyear,dropDate,pickuptime,dropofftime,pickmin,dropmin};
            for(JComboBox clrarea : arraycombobox){
                    clrarea.setSelectedItem(null);           
                }
            break;
       }
        while(true){
            bookreservinput.setText("");
            break;
        }
        while(true){
            paymentmethod.setSelectedItem(null);
            break;
        }
      }
     
    @Override
    public void actionPerformed(ActionEvent e) {
            JButton[] arrayclonebutton = new JButton[]{clonefortunerbtn,cloneaccordbtn,clonecivicbtn,clonewigobtn,cloneviosbtn,clonehiacebtn};
                JComboBox[] arraycombobox = new JComboBox[]{pickupfield,dropofffield,Datefield,Mnth,Yr,dropMonth,dropyear,dropDate,pickuptime,dropofftime,pickmin,dropmin};
                JTextArea[] arrayfield = new JTextArea[]{pickuplocationarea,dropofffieldloc,datefieldloc,pickuptimeloc,pickminloc,dropminloc,chooseyourcar};          
                JLabel[] price = new JLabel[]{fortunerprice,wigoprice,civicprice,viosprice,hiaceprice,accordprice};
          JPanel[] carpanels = new JPanel[]{fortunerpanel,accordpanel,civicpanel,wigopanel,hiacepanel,viospanel};
          
          if(e.getSource() == contin){             
            for(JComboBox array : arraycombobox){    
                if(array.getSelectedItem() == null){         
            JOptionPane.showMessageDialog(null, "Fill all Fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
            }
                for(JLabel carprice : price){
                    carprice.hide();
                }
                for(JButton clonebtnarray : arrayclonebutton){
                    clonebtnarray.show();
                }
                bookreservpanl.hide();
                bookreservnum.hide();
                bookreservpanel.show();
                namepanel.show();
                
                //////////////////////////////////////////////////////////////////////////
                String pickuplocation = pickupfield.getSelectedItem().toString();
                String dropofflocation = dropofffield.getSelectedItem().toString();
                String datefieldlocation = Datefield.getSelectedItem().toString();
                String mnthlocation = Mnth.getSelectedItem().toString();
                String datelocation = Yr.getSelectedItem().toString();
                String dropmnthlocation = dropMonth.getSelectedItem().toString();
                String dropyearlocation = dropyear.getSelectedItem().toString();
                String dropdatelocation = dropDate.getSelectedItem().toString();
                String pickuptimelocation = pickuptime.getSelectedItem().toString();
                String dropofftimelocation= dropofftime.getSelectedItem().toString();
                 String pickminlocation = pickmin.getSelectedItem().toString();
                 String dropminlocation = dropmin.getSelectedItem().toString();
                pickuplocationarea.setText(" "+pickuplocation);
                dropofffieldloc.setText(" "+dropofflocation);
                datefieldloc.setText(datefieldlocation+" " + mnthlocation + " "+datelocation);
               pickuptimeloc.setText(" "+dropdatelocation + " "+ dropmnthlocation + " "+ dropyearlocation);
               pickminloc.setText(" "+pickuptimelocation + " : "+pickminlocation);
               dropminloc.setText(" "+dropofftimelocation+" : "+dropminlocation);      
                                  

            }
            if(e.getSource() == cancelbutton){
                bookingpanel.hide();
                titlebgclr.show();
                titlebgclrshadow.show();
                carrentpanel.show();
                bookreservnum.show();
                bookreservpanl.show();
                contin.setEnabled(true);
                namepanel.hide();   
                bookreservpanel.hide();
                fortunerpanel.hide();
                bookreservinput.setText("");
                for(JButton fakebtn : arrayclonebutton){
                    fakebtn.hide();
                }
               for(JLabel carpice : price){
                    carpice.show();
                }
            }

            if(e.getSource() == home){
              
                titlebgclr.show();
                titlebgclrshadow.show();
                carrentpanel.show();
                bookreservnum.show();
                bookreservpanl.show();
                contin.setEnabled(true);
                namepanel.hide();   
                bookreservpanel.hide();
                fortunerpanel.hide();
                bookingpanel.hide();
                savepdf.hide();
                //////////////////////////////////////////////////////////
                paymentmethod.setSelectedItem(null);
                bookreservinput.setText("");
                for(JLabel carpice : price){
                    carpice.show();
                }
                for(JTextArea clrfield : arrayfield){
                    clrfield.setText("");
                }
                for(JComboBox clrarea : arraycombobox){
                    clrarea.setSelectedItem(null);           
                }
                for(JButton fakebtn : arrayclonebutton){
                    fakebtn.hide();
                }
                for(JPanel clrpanels : carpanels){
                    clrpanels.hide();
                }
            }
            
            if(e.getSource() == go){           
                String input = bookreservinput.getText();
                double y = 10;
                 if(input.trim().length() == 10){
                     try{
                     y = Double.parseDouble(bookreservinput.getText()); 
                 } catch(NumberFormatException c){
                     JOptionPane.showMessageDialog(null, "Please input 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                     }      
                } else{
                      JOptionPane.showMessageDialog(null, "Booking Referrence # is 10 characters long, please check your number and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                 } 
                                    String url = "jdbc:mysql://localhost:3306/carrentalsystem";
                                    String user = "root";
                                    String pass = "rootAdmin";
                                    PreparedStatement pst;
                                    Double doublenum = Double.valueOf(bookreservinput.getText());
                                    String numref = bookreservinput.getText();
                                    area10.setText(numref);      
                                    boolean status = false;
                                    try {
                                     Class.forName("com.mysql.jdbc.Driver");
                                     Connection con = DriverManager.getConnection(url, user,pass );     
                                     Statement stm = con.createStatement();
                                     pst = con.prepareStatement("Select *  from carbookings where bookingID ='"+doublenum+"'");
                                     ResultSet myResults = pst.executeQuery();
                                     myResults.next();            
                                     Double ID = myResults.getDouble("bookingID");      
                                         if(doublenum.compareTo(ID) == 0){
                                           String outpickup = myResults.getString("pickuplocation");
                                          String outdropoff = myResults.getString("dropofflocation");
                                           String outpickupdate = myResults.getString("pickpdate");
                                           String outdropoffdate = myResults.getString("dropoffdate");
                                             String outpickuptime = myResults.getString("pickuptime");
                                             String outdropofftime = myResults.getString("dropofftime");
                                             String  outname = myResults.getString("nameofbooker");
                                             String  outphone = myResults.getString("phoneofbooker");
                                             String outemail = myResults.getString("emailofbooker");
                                             String chosencar = myResults.getString("carofbooker");
                                             String paymntmthd = myResults.getString("payment");
                                             area.setText(outpickup);
                                             area1.setText(outdropoff);
                                             area2.setText(outpickupdate);
                                             area3.setText(outdropoffdate);
                                             area4.setText(outpickuptime);
                                             area5.setText(outdropofftime);
                                             area6.setText(outname);
                                             area7.setText(outphone);
                                             area8.setText(outemail);
                                             area9.setText(chosencar);
                                             area12.setText(paymntmthd);
                                     } else{
                                             JOptionPane.showMessageDialog(null, "No Booking # is in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                                             return;
                                         }
                                    }
                                        catch(Exception ex)
                                         {
                                     JOptionPane.showMessageDialog(null, "No Booking # is in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                                     return;
                                     }             
                     bookreservpanl.hide();
                     bookreservpanel.hide();
                     bookreservnum.hide();
                      carrentpanel.hide();
                      bookingpanel.show();
                      
            }     
           
                    if(e.getSource() == submit){
                        
                        JTextArea[] detailsarray = new JTextArea[]{nametextarea, phonenumbertextarea, emailtextarea};
                        String number = phonenumbertextarea.getText();
                        String chosencar = chooseyourcar.getText().trim();
                       double x = 11;
                        
                       for(JTextArea dtsarray : detailsarray){

                            String details = dtsarray.getText();

                            if(details.trim().length() <= 0 ){
                                 JOptionPane.showMessageDialog(null, "Please fill-in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                              return;
                            }
                            else if(number.trim().length() != 11){
                                 JOptionPane.showMessageDialog(null, "Phone # must be 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                             return;
                            }else{  
                                     try {
                                      x = Double.parseDouble(phonenumbertextarea.getText());
                                    }
                                     catch (NumberFormatException b){
                                        JOptionPane.showMessageDialog(null, "Please Input Number.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    }
                            if(paymentmethod.getSelectedItem() == null){
                              JOptionPane.showMessageDialog(null, "Please Select Payment Method.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if(chosencar.equals("")){
                                JOptionPane.showMessageDialog(null, "Please Select a Car.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                        }else{
                              JPanel[] arraypanel = new JPanel[]{fortunerpanel,accordpanel,wigopanel,viospanel,civicpanel,hiacepanel};
                              for(JPanel panels : arraypanel){
                                  panels.hide();
                                  bookreservpanel.hide();
                                  namepanel.hide();     
                                  carrentpanel.hide();
                              }
                            }                                                       
                     }
                       ///////////////////////////////////////////////////////////////////////////////////   
                                     String url = "jdbc:mysql://localhost:3306/carrentalsystem";
                                     String user = "root";
                                     String pass = "rootAdmin";
                                     PreparedStatement pst;  
                                     area11.setText("");
                                     long numberrandom = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
                                     String numID = String.valueOf(numberrandom);
                                     area11.setText(numID);
                                     String pickuptext = pickuplocationarea.getText(); //TEXT AREA
                                     String dropofftext = dropofffieldloc.getText();
                                     String update = datefieldloc.getText();
                                     String dropdate = pickuptimeloc.getText();
                                     String timepick = pickminloc.getText();
                                     String timedrop = dropminloc.getText();
                                     String nameofbook = nametextarea.getText();
                                     String phoneofbook = phonenumbertextarea.getText();
                                     String emailaddofbook = emailtextarea.getText(); //TEXT AREA
                                     String carofchosen = chooseyourcar.getText();    
                                     String payment = String.valueOf(paymentmethod.getSelectedItem());
                                     try
                                     {
                                     Class.forName("com.mysql.jdbc.Driver");
                                     Connection con = DriverManager.getConnection(url, user,pass );     
                                     Statement stm = con.createStatement();
                                     pst = con.prepareStatement("select * from carbookings where carofbooker = ?");
                                     pst.setString(1, carofchosen);
                                     ResultSet set = pst.executeQuery();                                  
                                      while(set.next()){
                                         String str1 = set.getString("carofbooker");                                  
                                          if(str1.equals(carofchosen)){
                                                JOptionPane.showMessageDialog(null, "The Car you chose has been booked already", "Error", JOptionPane.ERROR_MESSAGE);       
                                                while(true){
                                                    carrentpanel.show();
                                                    namepanel.show();
                                                    bookreservpanel.show();
                                                    break;
                                                }             
                                          }
                                          while(true){  
                                             String str2 = "Toyota Fortuner";
                                              String str3 = "Honda Accord";
                                            String str4 = "Toyota Wigo";
                                            String str5 = "Toyota Hiace";
                                            String str6 = "Honda Civic";
                                            String str7 = "Toyota Vios";
                                          if(str2.equals(carofchosen)){
                                              statusavailability.setText("Unavailable");
                                              statusavailability.setForeground(Color.red);
                                          }
                                          else{
                                              statusavailability.setText("Available");
                                              statusavailability.setForeground(Color.green);
                                          }
                                          /////////////////////////////////////////////////////////////
                                          if(str3.equals(carofchosen)){
                                              accordstatusavailability.setText("Unavailable");
                                              accordstatusavailability.setForeground(Color.red);
                                          }
                                          else{
                                              accordstatusavailability.setText("Available");
                                              accordstatusavailability.setForeground(Color.green);
                                            }
                                            //////////////////////////////////////////////////////////////
                                            if(str4.equals(carofchosen)){
                                              wigoavailability.setText("Unavailable");
                                              wigoavailability.setForeground(Color.red);
                                          }
                                            else{
                                              wigoavailability.setText("Available");
                                              wigoavailability.setForeground(Color.green);
                                             }
                                            //////////////////////////////////////////////////////////////
                                            if(str5.equals(carofchosen)){
                                              hiaceavailability.setText("Unavailable");
                                              hiaceavailability.setForeground(Color.red);
                                            }
                                            else{
                                              hiaceavailability.setText("Available");
                                              hiaceavailability.setForeground(Color.green);
                                          }
                                            ///////////////////////////////////////////////////////////
                                             if(str6.equals(carofchosen)){
                                              civicavailability.setText("Unavailable");
                                              civicavailability.setForeground(Color.red);
                                            }
                                            else{
                                              civicavailability.setText("Available");
                                              civicavailability.setForeground(Color.green);
                                          }
                                            ///////////////////////////////////////////////////////////
                                             if(str7.equals(carofchosen)){
                                              viosavailability.setText("Unavailable");
                                              viosavailability.setForeground(Color.red);
                                            }
                                            else{
                                              viosavailability.setText("Available");
                                              viosavailability.setForeground(Color.green);
                                          }  
                                             return;
                                          }  
                                      }
                                     }
                                     catch(Exception ex){
                                        JOptionPane.showMessageDialog(null, "Error Connecting to Data", "Error", JOptionPane.ERROR_MESSAGE);
                                     }

                                    try {
                                     Class.forName("com.mysql.jdbc.Driver");
                                     Connection con = DriverManager.getConnection(url, user,pass );     
                                     Statement stm = con.createStatement();
                                     pst = con.prepareStatement("insert into carbookings (bookingID, pickuplocation, dropofflocation, pickpdate, dropoffdate, pickuptime, dropofftime, nameofbooker, phoneofbooker, emailofbooker, carofbooker, payment) values ("+numberrandom+",'"+pickuptext+"','"+
                                             dropofftext+"','"+update+"','"+dropdate+"','"+timepick+"','"+timedrop+"','"+nameofbook+"','"+phoneofbook+"','"+emailaddofbook+"','"+carofchosen+"','"+payment+"')");
                                     pst.executeUpdate();
                                     JOptionPane.showMessageDialog(null, "Successfully Booked your Request.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                     con.close();
                                        }
                                        catch(Exception ex)
                                         {
                                     JOptionPane.showMessageDialog(null, "Error Connecting to Data", "Error", JOptionPane.ERROR_MESSAGE);
                                     }
                                        for(JLabel prc : price){
                                            prc.show();
                                        }
                                        for(JButton clonebtn : arrayclonebutton){
                                            clonebtn.hide();
                                        }
                                        for(JComboBox arraycombo : arraycombobox){
                                            arraycombo.setSelectedItem(null);
                                        }  
                                        savepdf.show();
                                   }
            if(e.getSource() == savebutton){
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String numID = area11.getText();
                String name = nametextarea.getText();
                String chosencar = chooseyourcar.getText();               
                String ploc = pickuplocationarea.getText();
                String drploc = dropofffieldloc.getText();
                String drpffdt = datefieldloc.getText();
                String pckdt = pickuptimeloc.getText();
                String pcktm = pickminloc.getText();
                String drptm = dropminloc.getText();
                String phn = phonenumbertextarea.getText();
                String ml = emailtextarea.getText();
                String pymntmethd = String.valueOf(paymentmethod.getSelectedItem());
                try {
                    PdfWriter pdfwrite=null;
                    String path=(name+" Rental Invoice.pdf");
                    pdfwrite = new PdfWriter(path);
                    PdfDocument pdfDocument = new PdfDocument(pdfwrite);
                    pdfDocument.setDefaultPageSize(PageSize.A4);
                    Document document = new Document(pdfDocument);
                    float threecol = 198f;
                    float twocol = 285f;
                    float twocol150 = twocol+150f;
                    float twocolumnWidth[] = {twocol150,twocol};
                    float threeColumnWidth[] = {threecol,threecol,100f};
                    float fullwidth[] ={threecol*3};
                    Paragraph space = new Paragraph("\n");
                    Paragraph twospace = new Paragraph("""
                                                       
                                                       
                                                       """);  
                    Table table = new Table(twocolumnWidth);
                    table.addCell(new Cell().add("Rental Invoice").setBold().setFontSize(25f).setBorder(Border.NO_BORDER));
                    Table nestedtabe = new Table(new float[]{twocol/2, twocol/2});
                    nestedtabe.addCell(new Cell().add("Booking Number:").setBold().setBorder(Border.NO_BORDER));
                    nestedtabe.addCell(new Cell().add(numID).setBorder(Border.NO_BORDER));
                    nestedtabe.addCell(new Cell().add("Invoice Date:").setBold().setBorder(Border.NO_BORDER));
                     nestedtabe.addCell(new Cell().add(timeStamp).setBorder(Border.NO_BORDER));
                       table.addCell(nestedtabe.setBorder(Border.NO_BORDER));
                       
                     Border brd = new SolidBorder(com.itextpdf.kernel.color.Color.GRAY, 2f);
                     Table divider = new Table(fullwidth);
                     divider.setBorder(brd);
                    document.add(table);
                    document.add(space);
                    document.add(divider);
                     
                    Table twoColumn1 = new Table(twocolumnWidth);
                    twoColumn1.addCell(new Cell().add("Rentee Information").setBold().setFontSize(16f).setBorder(Border.NO_BORDER));    
                     twoColumn1.addCell(new Cell().add("Renter Information").setBold().setFontSize(16f).setBorder(Border.NO_BORDER));
                      document.add(space);
                    document.add(twoColumn1.setMarginBottom(9f));
                    
                   Table twoColumn5 = new Table(twocolumnWidth);
                    twoColumn5.addCell(new Cell().add("Name").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));       
                    twoColumn5.addCell(new Cell().add("Name of Company").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));    
                    twoColumn5.addCell(new Cell().add(name).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    twoColumn5.addCell(new Cell().add("Cars Inc.").setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(twoColumn5.setMarginBottom(4f));
                    
                   Table twoColumn6 = new Table(twocolumnWidth);
                    twoColumn6.addCell(new Cell().add("Phone").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));       
                    twoColumn6.addCell(new Cell().add("Company Phone").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));    
                    twoColumn6.addCell(new Cell().add(phn).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    twoColumn6.addCell(new Cell().add("09458124652").setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(twoColumn6.setMarginBottom(4f));
                    
                     Table twoColumn7 = new Table(twocolumnWidth);
                    twoColumn7.addCell(new Cell().add("Email").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));       
                    twoColumn7.addCell(new Cell().add("Company Email").setBold().setFontSize(12f).setBorder(Border.NO_BORDER));    
                    twoColumn7.addCell(new Cell().add(ml).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    twoColumn7.addCell(new Cell().add("carsinc@gmail.com").setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(twoColumn7.setMarginBottom(15f));
                    
                     float oneColumnWidth[] = {twocol150};
                                        
                    Table twoColumn = new Table(twocolumnWidth);
                    twoColumn.addCell(new Cell().add("Renting Information").setBold().setFontSize(16f).setBorder(Border.NO_BORDER));       
                    document.add(twoColumn.setMarginBottom(9));
                    
                    Table twoColumn2 = new Table(twocolumnWidth);
                    twoColumn2.addCell(new Cell().add("Pick-Up Location").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    twoColumn2.addCell(new Cell().add("Drop-Off Location").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    twoColumn2.addCell(new Cell().add(ploc).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    twoColumn2.addCell(new Cell().add(drploc).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    document.add(twoColumn2.setMarginBottom(4f));
                    
                    Table threeColumn3 = new Table(twocolumnWidth);
                    threeColumn3.addCell(new Cell().add("Pick-up Date").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    threeColumn3.addCell(new Cell().add("Drop-Off Date").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    threeColumn3.addCell(new Cell().add(drpffdt).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    threeColumn3.addCell(new Cell().add(pckdt).setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(threeColumn3.setMarginBottom(4f));
                    
                    Table twoColumn4 = new Table(twocolumnWidth);
                    twoColumn4.addCell(new Cell().add("Pick-Up Time").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    twoColumn4.addCell(new Cell().add("Time of Drop-off").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));       
                    twoColumn4.addCell(new Cell().add(pcktm).setFontSize(9f).setBorder(Border.NO_BORDER));       
                    twoColumn4.addCell(new Cell().add(drptm).setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(twoColumn4.setMarginBottom(4f));
                    
                    Table onecolumn1 = new Table(oneColumnWidth);
                    onecolumn1.addCell(new Cell().add("Car to Rent").setBold().setFontSize(10f).setBorder(Border.NO_BORDER));
                    onecolumn1.addCell(new Cell().add(chosencar).setFontSize(9f).setBorder(Border.NO_BORDER)); 
                    document.add(onecolumn1.setMarginBottom(4f));
                    
                    Table tabledivider2 = new Table(fullwidth);
                    Border brd2 = new DashedBorder(com.itextpdf.kernel.color.Color.GRAY, 0.5f);
                     document.add(tabledivider2.setBorder(brd2));
                     document.add(space);
                    
                     Table threecolTable = new Table(threeColumnWidth);
                     threecolTable.setBackgroundColor(com.itextpdf.kernel.color.Color.BLACK, 0.7f);
                    threecolTable.addCell(new Cell().add("Name of Car").setBold().setFontSize(10f).setFontColor(com.itextpdf.kernel.color.Color.WHITE).setBorder(Border.NO_BORDER));       
                    threecolTable.addCell(new Cell().add("Type of Payment").setBold().setFontSize(10f).setFontColor(com.itextpdf.kernel.color.Color.WHITE).setBorder(Border.NO_BORDER));       
                    threecolTable.addCell(new Cell().add("Price per Hour").setBold().setFontSize(10f).setFontColor(com.itextpdf.kernel.color.Color.WHITE).setBorder(Border.NO_BORDER));       
                    document.add(threecolTable.setMarginBottom(5f));
                     
                    Table threecolTable1 = new Table(threeColumnWidth);
                    threecolTable1.addCell(new Cell().add(chosencar).setFontSize(10f).setBorder(Border.NO_BORDER));       
                    threecolTable1.addCell(new Cell().add(pymntmethd).setFontSize(10f).setBorder(Border.NO_BORDER));       
                    threecolTable1.addCell(new Cell().add("₱230").setFontSize(10f).setBorder(Border.NO_BORDER));       
                    document.add(threecolTable1.setMarginBottom(70f));
                    
                    Table tabledivider4 = new Table(fullwidth);
                    Border brd4 = new SolidBorder(com.itextpdf.kernel.color.Color.GRAY, 0.5f);
                    document.add(tabledivider4.setMarginBottom(5f).setBorder(brd4));
                    
                    Table tabledivider3 = new Table(fullwidth);
                    Border brd3 = new DashedBorder(com.itextpdf.kernel.color.Color.GRAY, 0.5f);
                    document.add(tabledivider3.setBorder(brd2));

                    document.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(System.class.getName()).log(Level.SEVERE, null, ex);
                }             
                    savepdf.hide();
                    titlebgclr.show();
                    titlebgclrshadow.show();
                    carrentpanel.show();
                    bookreservnum.show();
                    bookreservpanl.show();
                    contin.setEnabled(true);
                    namepanel.hide();
                    bookreservpanel.hide();         
                    fortunerpanel.hide();
                    bookingpanel.hide()  ;
            }        
    
                                     
            if(e.getSource() == fortunerreturnbtn){ 
                carrentpanel.show();
                bookreservpanel.show();
                fortunerpanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }
             if(e.getSource() == accordreturnbtn){   
                carrentpanel.show();
                bookreservpanel.show();
                accordpanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }
              if(e.getSource() == wigoreturnbtn){   
                carrentpanel.show();
                bookreservpanel.show();
                wigopanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }
               if(e.getSource() == viosreturnbtn){   
                carrentpanel.show();
                bookreservpanel.show();
                viospanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }
                if(e.getSource() == hiacereturnbtn){   
                carrentpanel.show();
                bookreservpanel.show();
                hiacepanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }
               if(e.getSource() == civicreturnbtn){   
                carrentpanel.show();
                bookreservpanel.show();
                civicpanel.hide();    
                chooseyourcar.setText("");
                for(JButton fakearray : arrayclonebutton){
                    fakearray.show();
                }
            }     
               
            if(e.getSource() == clonefortunerbtn){
                     chooseyourcar.setText("Toyota Fortuner");
                      carrentpanel.hide();
                     fortunerpanel.show();
            }
            if(e.getSource() == cloneaccordbtn){
                chooseyourcar.setText(" Toyota Accord");
                carrentpanel.hide();
                accordpanel.show();
            }
            if(e.getSource() == clonecivicbtn){
                chooseyourcar.setText("   Honda Civic");
                carrentpanel.hide();
                civicpanel.show();
            }
            if(e.getSource() == clonewigobtn){
                chooseyourcar.setText("  Toyota Wigo");
                carrentpanel.hide();
                 wigopanel.show();
            }
            if(e.getSource() == clonehiacebtn){
                chooseyourcar.setText("  Toyota Hiace");
                carrentpanel.hide();
                hiacepanel.show();
            }
            if(e.getSource() == cloneviosbtn){
                chooseyourcar.setText("  Toyota Vios");
                carrentpanel.hide();
                viospanel.show();
            }
        }
}
