import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
class Rail extends JFrame{
	JButton b1,b2,b4,ex;
	JLabel l1,l2;
	ImageIcon img;
	Rail(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Railway Reservation System");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(10,10,400,30);
		add(l1);
		b1= new JButton("Passenger");
		b1.setBounds(100,70,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Passenger p = new Passenger(name);
				p.setBounds(400,60,360,250);
				p.setVisible(true);	
			}
		});
		b2= new JButton("Employee");
		b2.setBounds(100,110,120,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Id id = new Id(name);
		        id.setBounds(400,200,400,400);
				id.setVisible(true);	
			}
		});
		b4= new JButton("Train");
		b4.setBounds(100,150,120,30);
		add(b4);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Trains t = new Trains(name);
				t.setSize(850,600);
				t.setVisible(true);
			}
		});
		ex= new JButton("LogOut");
		ex.setBounds(300,50,80,30);
		add(ex);
		ex.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Login l = new Login(name);
				l.setBounds(400,200,400,300);
				l.setVisible(true);	
			}
		});
}}
class Employee extends JFrame{
	JLabel l1;
	JButton b1,b2,b3;
	ImageIcon img;
	Employee(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Employee Access");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(30,10,300,30);
		add(l1);
		b1= new JButton("Ticket Clerk");
		b1.setBounds(100,70,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				TicketClerk tc = new TicketClerk(name);
				tc.setBounds(400,60,360,250);
				tc.setVisible(true);
			}
		});
		b2= new JButton("RailwayDatabase");
		b2.setBounds(100,110,120,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				RailwayDatabase r = new RailwayDatabase(name);
				r.setBounds(10,10,400,300);
				r.setVisible(true);
			}
		});
		b3 = new JButton("LogOut");
		b3.setBounds(10,50,80,20);
		add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Id id = new Id(name);
		        id.setBounds(400,200,400,400);
				id.setVisible(true);	
			}
		});
	}
}
class Passenger extends JFrame{
	JLabel l1;
	JButton b1,b2,b3,b6;
	ImageIcon img;
	Passenger(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Passenger E-service");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(30,10,300,30);
		add(l1);
		b1= new JButton("Reserve Seat");
		b1.setBounds(100,70,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Seat l = new Seat(name);
				l.setBounds(400,50,500,500);
				l.setVisible(true);	
			}
		});
		b2= new JButton("View Ticket");
		b2.setBounds(100,110,120,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Ticket t = new Ticket(name);
				t.setBounds(400,50,900,600);
				t.setVisible(true);	
			}
		});
		b6= new JButton("Payment");
		b6.setBounds(100,150,120,30);
		add(b6);
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Payment p = new Payment(name);
				p.setBounds(400,200,400,300);
				p.setVisible(true);	
			}
		});
		b3 = new JButton("<--Back");
		b3.setBounds(10,50,80,20);
		add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Rail r = new Rail(name);
				r.setBounds(400,200,400,350);
				r.setVisible(true);	
			}
		});
	}
}
class Ticket extends JFrame{
    JTextField t1;
    JButton b1,b2;
    JTable table;
    JPanel p1;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
	List<Integer> matchingRows;
	DefaultTableModel model;
	JScrollPane sp;
	ImageIcon img;
    Ticket(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Reserved Seats List");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(230,10,200,40);
		add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10,40,80,25);
        add(b1);
       b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Passenger p = new Passenger(name);
				p.setBounds(400,60,360,250);
				p.setVisible(true);	
			}
		}); 
        p1 = new JPanel();
        p1.setBounds(10,80,800,300);
        add(p1);
        try {		
            BufferedReader reader = new BufferedReader(new FileReader("reserveticket.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
				String acc = line.substring(line.length() - name.length());
				if (acc.equals(name)){
                String[] row = line.split(",");
                data.add(row);}
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] columnNames={"Train ID","PNR ","Name","Age","Gender","Berth"};
        model = new DefaultTableModel(columnNames,0);
        for (String[] row : data) {
            model.addRow(row);
        }
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(800, 300));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
        t1 = new JTextField(60);
        t1.setBounds(200,40,200,30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400,40,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = t1.getText().toString().toLowerCase();
				matchingRows = new ArrayList<Integer>();
				table.clearSelection();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {
							matchingRows.add(i);
							break;
							}
						}
					}
					for (int i : matchingRows) {
						table.addRowSelectionInterval(i, i);}
                    t1.setText("");
            }
        });
    }
}
class TicketClerk extends JFrame{
	JLabel l1;
	ImageIcon img;
	JButton b1,b2,b3,b6;
	TicketClerk(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Ticket Counter");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(30,10,300,30);
		add(l1);
		b1= new JButton("Reserve Seat");
		b1.setBounds(100,70,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				OffSeat l = new OffSeat(name);
				l.setBounds(400,50,500,500);
				l.setVisible(true);	
			}
		});
		b2= new JButton("Reserve Ticket");
		b2.setBounds(100,110,120,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Offticket t = new Offticket(name);
				t.setBounds(400,50,500,400);
				t.setVisible(true);	
			}
		});
		b3 = new JButton("<--Back");
		b3.setBounds(10,50,80,20);
		add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Employee em = new Employee(name);
				em.setBounds(10,10,400,300);
				em.setVisible(true);
			}
		});
	}
}
class Offticket extends JFrame{
	JLabel l1,l2;
	JButton b1,b2;
	ImageIcon img;
	JTextField t1,t2;
	ArrayList<String[]> data = new ArrayList<>();
	DefaultTableModel model;
	JTable table;
	String Src,Dst,st,end,gn,tno,tnm;
	int row;
	boolean tnum;
	Offticket(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserve Ticket");
		l1 = new JLabel("Source");
		l2 = new JLabel("Destination");
		l1.setBounds(10,40,100,30);
		l2.setBounds(10,80,100,30);
		add(l1);
		add(l2);
		t1 = new JTextField(60);
		t2 = new JTextField(60);
		t1.setBounds(110,40,100,30);
		t2.setBounds(110,80,100,30);
		add(t1);
		add(t2);
		b1 = new JButton("Confirm Ticket");
		b1.setBounds(50,120,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
				try {		
					BufferedReader reader = new BufferedReader(new FileReader("traindetails.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] row = line.split(",");
						data.add(row);
					}
					reader.close();
				} catch (Exception ex) {
				ex.printStackTrace();}
				String[] columnNames={"Train ID","Train Name","Source","Destination","Start Time","End Time","Service","Type","GN-Price","Sleeper-Price"};
				model = new DefaultTableModel(columnNames,0);
				for (String[] row : data) {
					model.addRow(row);}
				table = new JTable(model);
				String query1 = t1.getText().toString().toLowerCase();
				String query2 = t2.getText().toString().toLowerCase();
                for (int i = 0; i < table.getRowCount(); i++) {
					String value1 = table.getValueAt(i, 2).toString().toLowerCase();
					if (value1.contains(query1)){
                    	for (int j = 0; j < table.getColumnCount(); j++) {
							String value2 = table.getValueAt(i, 3).toString().toLowerCase();
							if(value2.contains(query2)) {
								row = i;
								tnum = true;
							}
						}
					}
					}
					tno = table.getValueAt(row, 0).toString().toLowerCase();
					tnm = table.getValueAt(row, 1).toString().toLowerCase();
					Src = table.getValueAt(row, 2).toString().toLowerCase();
					Dst = table.getValueAt(row, 3).toString().toLowerCase();
					st = table.getValueAt(row, 4).toString().toLowerCase();
					end = table.getValueAt(row, 5).toString().toLowerCase();
					gn = table.getValueAt(row, 8).toString().toLowerCase();
					if(tnum==true){
					/*System.out.println("\n\n*****Ticket Reserved*****\n");
					System.out.println("Source : "+Src);
					System.out.println("Destination : "+Dst);
					System.out.println("Train ID : "+tno);
					System.out.println("GN-Price : "+gn);
					System.out.println("Start Time : "+st);
					System.out.println("End Time : "+end);*/
					NormalTicket tc = new NormalTicket(Src,Dst,tno,gn,st,end);
					tc.setBounds(400,60,300,350);
					tc.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Invali Train Location","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			t1.setText("");
			t2.setText("");
			}
		});
		b2 = new JButton("Cancel Ticket");
		b2.setBounds(50,160,120,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				TicketClerk tc = new TicketClerk(name);
				tc.setBounds(400,60,360,250);
				tc.setVisible(true);
			}
		});
	}
}
class NormalTicket extends JFrame{
	JLabel l,l1,l2,l3,l4,l5,l6,t1,t2,t3,t4,t5,t6;
	ImageIcon img;
	JButton b1;
	NormalTicket(String trn,String prc,String src,String dst,String st,String end){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l = new JLabel("*****Ticket Reserved*****");
		l.setFont(new Font("Times New Roman",Font.BOLD,20));
		l.setForeground(Color.BLUE);
		l.setBounds(10,10,400,20);
		add(l);
		l1 = new JLabel("Train ID : ");
		l2 = new JLabel("GN-Price : ");
		l3 = new JLabel("Source : ");
		l4 = new JLabel("Destination : ");
		l5 = new JLabel("Start Time : ");
		l6 = new JLabel("End Time : ");
		l1.setBounds(10,40,120,30);
		l2.setBounds(10,70,120,30);
		l3.setBounds(10,100,120,30);
		l4.setBounds(10,130,120,30);
		l5.setBounds(10,160,120,30);
		l6.setBounds(10,190,120,30);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		t1 = new JLabel(src);
		t2 = new JLabel(dst);
		t3 = new JLabel(trn);
		t4 = new JLabel(prc);
		t5 = new JLabel(st);
		t6 = new JLabel(end);
		t1.setBounds(130,40,120,30);
		t2.setBounds(130,70,120,30);
		t3.setBounds(130,100,120,30);
		t4.setBounds(130,130,120,30);
		t5.setBounds(130,160,120,30);
		t6.setBounds(130,190,120,30);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		b1 = new JButton("OK");
		b1.setBounds(90,230,60,40);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}
}
class OffSeat extends JFrame{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2;
	JRadioButton r1,r2;
	ImageIcon img;
	String mess,berth;
	Random rand;
	JPanel panel;
	ArrayList<String[]> data = new ArrayList<>();
	DefaultTableModel model;
	JTable table;
	String Src,Dst,st,end,gn,slp;
	boolean tnum;
	int age,row,column;
	OffSeat(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserve Seat");
		panel = new JPanel();
		l1 = new JLabel("Name");
		l2 = new JLabel("Age");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Train ID");
		l1.setBounds(10,40,120,30);
		l2.setBounds(10,80,120,30);
		l3.setBounds(10,120,120,30);
		l4.setBounds(10,160,120,30);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		t1 = new JTextField(30);
		t2 = new JTextField(5);
		t3 = new JTextField(10);
		t1.setBounds(140,40,120,30);
		t2.setBounds(140,80,120,30);
		t3.setBounds(140,160,120,30);
		add(t1);
		add(t2);
		add(t3);
		r1 = new JRadioButton("M");
		r2 = new JRadioButton("F");
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		panel.setLayout(null);
		r1.setBounds(0,0,50,20);
		r2.setBounds(60,0,50,20);
        panel.add(r1);
		panel.add(r2);
		panel.setBounds(140,120,200,30);
		add(panel);
		b1 = new JButton("Confirm Ticket");
		b1.setBounds(70,200,150,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try {
					age = Integer.parseInt(t2.getText());}catch (Exception e) {}
				try {		
					BufferedReader reader = new BufferedReader(new FileReader("traindetails.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] row = line.split(",");
						data.add(row);
					}
					reader.close();
				} catch (Exception ex) {
				ex.printStackTrace();}
				String[] columnNames={"Train ID","Train Name","Source","Destination","Start Time","End Time","Service","Type","GN-Price","Sleeper-Price"};
				model = new DefaultTableModel(columnNames,0);
				for (String[] row : data) {
					model.addRow(row);}
				table = new JTable(model);
				String query = t3.getText().toString().toLowerCase();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {
							row = i;
							tnum = true;
							}
						}
					}
					Src = table.getValueAt(row, 2).toString().toLowerCase();
					Dst = table.getValueAt(row, 3).toString().toLowerCase();
					st = table.getValueAt(row, 4).toString().toLowerCase();
					end = table.getValueAt(row, 5).toString().toLowerCase();
					gn = table.getValueAt(row, 8).toString().toLowerCase();
					slp = table.getValueAt(row, 9).toString().toLowerCase();
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else if (t3.getText().toString().equals("08531")){
					JOptionPane.showMessageDialog(null,"This Train does not contain Reservation service","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{if(tnum==true){
					rand = new Random();
					long pnr = 1000000000L + rand.nextInt(900000000);
					if (r1.isSelected()) {
						mess = "Male";}
					else if (r2.isSelected()) {
						mess = "Female";}
					if ((age <= 40 && mess.equals("Male")) || (age <= 25 && mess.equals("Female"))) {
							berth = "Upper";}
					else if (((age > 40 && age <= 55) && mess.equals("Male")) || ((age > 25 && age <= 45) && mess.equals("Female"))) {
							berth = "Middle";}
					else if ((age > 55 && mess.equals("Male")) || (age > 45 && mess.equals("Female"))) {
							berth = "Lower";}
					try{
					FileWriter fw = new FileWriter("offlinereserveticket.txt",true);
	 				fw.write(t3.getText()+","+String.valueOf(pnr)+","+t1.getText()+","+t2.getText()+","+mess+","+berth+","+"offline"+"\n");
					fw.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Ticket Confirmed");
					}catch(Exception e){}
					/*System.out.println("\n\n*****Seat Reserved*****\n");
					System.out.println("Train ID : "+t3.getText());
					System.out.println("PNR : "+pnr);
					System.out.println("Name : "+t1.getText());
					System.out.println("Age : "+t2.getText());
					System.out.println("Gender : "+mess);
					System.out.println("Berth : "+berth);
					System.out.println("Sleeper-Price : "+slp);
					System.out.println("Source : "+Src);
					System.out.println("Destination : "+Dst);
					System.out.println("Start Time : "+st);
					System.out.println("End Time : "+end);*/
					ReservedTicket rt = new ReservedTicket(t3.getText(),pnr,t1.getText(),t2.getText(),mess,berth,slp,Src,Dst,st,end);
				rt.setBounds(400,60,300,450);
				rt.setVisible(true);	
					
				}else{
					JOptionPane.showMessageDialog(null,"Invali Train ID","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				g.clearSelection();
			}
		});
		b2 = new JButton("Cancel Ticket");
		b2.setBounds(70,240,150,30);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				TicketClerk tc = new TicketClerk(name);
				tc.setBounds(400,60,360,250);
				tc.setVisible(true);	
			}
		});
	}
}
class ReservedTicket extends JFrame{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	ImageIcon img;
	JButton b1;
	ReservedTicket(String trn,long pnr,String name,String age,String gndr,String brt,String prc,String src,String dst,String st,String end){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l = new JLabel("*****Seat Reserved*****");
		l.setFont(new Font("Times New Roman",Font.BOLD,20));
		l.setForeground(Color.BLUE);
		l.setBounds(10,10,400,20);
		add(l);
		l1 = new JLabel("Train ID : ");
		l2 = new JLabel("PNR : ");
		l3 = new JLabel("Name : ");
		l4 = new JLabel("Age : ");
		l5 = new JLabel("Gender : ");
		l6 = new JLabel("Berth : ");
		l7 = new JLabel("Sleeper-Price : ");
		l8 = new JLabel("Source : ");
		l9 = new JLabel("Destination : ");
		l10 = new JLabel("Start Time : ");
		l11 = new JLabel("End Time : ");
		l1.setBounds(10,40,120,30);
		l2.setBounds(10,70,120,30);
		l3.setBounds(10,100,120,30);
		l4.setBounds(10,130,120,30);
		l5.setBounds(10,160,120,30);
		l6.setBounds(10,190,120,30);
		l7.setBounds(10,220,120,30);
		l8.setBounds(10,250,120,30);
		l9.setBounds(10,280,120,30);
		l10.setBounds(10,310,120,30);
		l11.setBounds(10,340,120,30);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		t1 = new JLabel(trn);
		t2 = new JLabel(String.valueOf(pnr));
		t3 = new JLabel(name);
		t4 = new JLabel(age);
		t5 = new JLabel(gndr);
		t6 = new JLabel(brt);
		t7 = new JLabel(prc);
		t8 = new JLabel(src);
		t9 = new JLabel(dst);
		t10 = new JLabel(st);
		t11 = new JLabel(end);
		t1.setBounds(130,40,120,30);
		t2.setBounds(130,70,120,30);
		t3.setBounds(130,100,120,30);
		t4.setBounds(130,130,120,30);
		t5.setBounds(130,160,120,30);
		t6.setBounds(130,190,120,30);
		t7.setBounds(130,220,120,30);
		t8.setBounds(130,250,120,30);
		t9.setBounds(130,280,120,30);
		t10.setBounds(130,310,120,30);
		t11.setBounds(130,340,120,30);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(t9);
		add(t10);
		add(t11);
		b1 = new JButton("OK");
		b1.setBounds(90,370,60,40);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}
}
class Seat extends JFrame{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2;
	JRadioButton r1,r2;
	ImageIcon img;
	String mess,berth;
	Random rand;
	JPanel panel;
	ArrayList<String[]> data = new ArrayList<>();
	DefaultTableModel model;
	JTable table;
	String Src,Dst,st,end,gn,slp;
	boolean tnum;
	int age,row,column;
	Seat(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserve Seat");
		panel = new JPanel();
		l1 = new JLabel("Name");
		l2 = new JLabel("Age");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Train ID");
		l1.setBounds(10,40,120,30);
		l2.setBounds(10,80,120,30);
		l3.setBounds(10,120,120,30);
		l4.setBounds(10,160,120,30);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		t1 = new JTextField(30);
		t2 = new JTextField(5);
		t3 = new JTextField(10);
		t1.setBounds(140,40,120,30);
		t2.setBounds(140,80,120,30);
		t3.setBounds(140,160,120,30);
		add(t1);
		add(t2);
		add(t3);
		r1 = new JRadioButton("M");
		r2 = new JRadioButton("F");
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		panel.setLayout(null);
		r1.setBounds(0,0,50,20);
		r2.setBounds(60,0,50,20);
        panel.add(r1);
		panel.add(r2);
		panel.setBounds(140,120,200,30);
		add(panel);
		b1 = new JButton("Confirm Ticket");
		b1.setBounds(70,200,150,30);
		add(b1);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try {
					age = Integer.parseInt(t2.getText());}catch (Exception e) {}
				try {		
					BufferedReader reader = new BufferedReader(new FileReader("traindetails.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] row = line.split(",");
						data.add(row);
					}
					reader.close();
				} catch (Exception ex) {
				ex.printStackTrace();}
				String[] columnNames={"Train ID","Train Name","Source","Destination","Start Time","End Time","Service","Type","GN-Price","Sleeper-Price"};
				model = new DefaultTableModel(columnNames,0);
				for (String[] row : data) {
					model.addRow(row);}
				table = new JTable(model);
				String query = t3.getText().toString().toLowerCase();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {
							row = i;
							tnum = true;
							}
						}
					}
					Src = table.getValueAt(row, 2).toString().toLowerCase();
					Dst = table.getValueAt(row, 3).toString().toLowerCase();
					st = table.getValueAt(row, 4).toString().toLowerCase();
					end = table.getValueAt(row, 5).toString().toLowerCase();
					gn = table.getValueAt(row, 8).toString().toLowerCase();
					slp = table.getValueAt(row, 9).toString().toLowerCase();
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else if ((t3.getText().toString().equals("08531"))||(t3.getText().toString().equals("18526"))){
					JOptionPane.showMessageDialog(null,"This Train does not contain Reservation service","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{if(tnum==true){
					rand = new Random();
					long pnr = 1000000000L + rand.nextInt(900000000);
					if (r1.isSelected()) {
						mess = "Male";}
					else if (r2.isSelected()) {
						mess = "Female";}
					if ((age <= 40 && mess.equals("Male")) || (age <= 25 && mess.equals("Female"))) {
							berth = "Upper";}
					else if (((age > 40 && age <= 55) && mess.equals("Male")) || ((age > 25 && age <= 45) && mess.equals("Female"))) {
							berth = "Middle";}
					else if ((age > 55 && mess.equals("Male")) || (age > 45 && mess.equals("Female"))) {
							berth = "Lower";}
					try{
					FileWriter fw = new FileWriter("reserveticket.txt",true);
	 				fw.write(t3.getText()+","+String.valueOf(pnr)+","+t1.getText()+","+t2.getText()+","+mess+","+berth+","+"online"+","+name+"\n");
					fw.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Ticket Confirmed");
					FileWriter fw1 = new FileWriter("Debitpayment.txt",true);
					fw1.write(String.valueOf(pnr)+","+String.valueOf(slp)+","+name+"\n");
					fw1.close();
					FileWriter fw2 = new FileWriter("Debitmoney.txt",true);
					fw2.write(String.valueOf(slp)+","+name+"\n");
					fw2.close();
					JOptionPane.showMessageDialog(f," Amount Debited Successfully");
					}catch(Exception e){}
					/*System.out.println("\n\n*****Seat Reserved*****\n");
					System.out.println("Train ID : "+t3.getText());
					System.out.println("PNR : "+pnr);
					System.out.println("Name : "+t1.getText());
					System.out.println("Age : "+t2.getText());
					System.out.println("Gender : "+mess);
					System.out.println("Berth : "+berth);
					System.out.println("Sleeper-Price : "+slp);
					System.out.println("Source : "+Src);
					System.out.println("Destination : "+Dst);
					System.out.println("Start Time : "+st);
					System.out.println("End Time : "+end);*/
					ReservedTicket rt = new ReservedTicket(t3.getText(),pnr,t1.getText(),t2.getText(),mess,berth,slp,Src,Dst,st,end);
				rt.setBounds(400,60,300,450);
				rt.setVisible(true);	
				}else{
					JOptionPane.showMessageDialog(null,"Invali Train ID","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				g.clearSelection();
			}
		});
		b2 = new JButton("Cancel Ticket");
		b2.setBounds(70,240,150,30);
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				Passenger p = new Passenger(name);
				p.setBounds(400,60,360,250);
				p.setVisible(true);	
			}
		});
	}
}
class Trains extends JFrame{
    JTextField t1;
    JButton b1,b2;
    JTable table;
    JPanel p1;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
	List<Integer> matchingRows;
	ImageIcon img;
	DefaultTableModel model;
	JScrollPane sp;
    Trains(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Train Details");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(300,10,120,40);
		add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10,40,80,25);
        add(b1);
       b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Rail r = new Rail(name);
				r.setBounds(400,200,400,350);
				r.setVisible(true);	
			}
		}); 
        p1 = new JPanel();
        p1.setBounds(10,80,800,300);
        add(p1);
        try {		
            BufferedReader reader = new BufferedReader(new FileReader("traindetails.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] columnNames={"Train ID","Train Name","Source","Destination","Start Time","End Time","Service","Type","GN-Price","Sleeper-Price"};
        model = new DefaultTableModel(columnNames,0);
        for (String[] row : data) {
            model.addRow(row);
        }
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(800, 300));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
        t1 = new JTextField(60);
        t1.setBounds(200,40,200,30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400,40,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = t1.getText().toString().toLowerCase();
				matchingRows = new ArrayList<Integer>();
				table.clearSelection();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {							
                            matchingRows.add(i);
							break;
							}
						}
					}
					for (int i : matchingRows) {
						table.addRowSelectionInterval(i, i);}
                    t1.setText("");
            }
        });
    }
}
class TrainData extends JFrame{
    JLabel l,l0,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
	ImageIcon img;
    JTextField t0,t1,t2,t3,t4,t5,t6,t7,t8,t9;
    TrainData(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l = new JLabel("Add Train Details");
		l.setFont(new Font("Times new Roman",Font.BOLD,24));
		l.setForeground(Color.BLUE);
		l.setBounds(130,10,300,30);
		add(l);
        b2 = new JButton("<--Back");
        b2.setBounds(10,30,80,25);
        add(b2);
        b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				RailwayDatabase r = new RailwayDatabase(name);
					r.setBounds(10,10,400,300);
					r.setVisible(true);
			}
		});
        l0=new JLabel("Train ID");
        add(l0);
        l1=new JLabel("Train Name");
        add(l1);
        l2=new JLabel("Source");
        add(l2);
        l3=new JLabel("Destination");
        add(l3);
        l4=new JLabel("Start Time");
        add(l4);
        l5=new JLabel("End Time");
        add(l5);
        l6=new JLabel("Service");
        add(l6);
        l7=new JLabel("Type");
        add(l7);
        l8=new JLabel("GN-Price");
        add(l8);
        l9=new JLabel("Sleeper-Price");
        add(l9);
        l0.setBounds(10,70,120,30);
        l1.setBounds(10,110,120,30);
        l2.setBounds(10,150,120,30);
        l3.setBounds(10,190,120,30);
        l4.setBounds(10,230,120,30);
        l5.setBounds(10,270,120,30);
        l6.setBounds(10,310,120,30);
        l7.setBounds(10,350,120,30);
        l8.setBounds(10,390,120,30);
        l9.setBounds(10,430,120,30);
        t0=new JTextField(60);
        t1=new JTextField(60);
        t2=new JTextField(60);
        t3=new JTextField(60);
        t4=new JTextField(60);
        t5=new JTextField(60);
        t6=new JTextField(60);
        t7=new JTextField(60);
        t8=new JTextField(60);
        t9=new JTextField(60);
        t0.setBounds(140,70,120,30);
        t1.setBounds(140,110,120,30);
        t2.setBounds(140,150,120,30);
        t3.setBounds(140,190,120,30);
        t4.setBounds(140,230,120,30);
        t5.setBounds(140,270,120,30);
        t6.setBounds(140,310,120,30);
        t7.setBounds(140,350,120,30);
        t8.setBounds(140,390,120,30);
        t9.setBounds(140,430,120,30);
        add(t0);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(t9);
        b1 = new JButton("Add");
        b1.setBounds(10,470,100,30);
        add(b1);
        b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
                if(t0.getText().toString().isEmpty()||t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()||t4.getText().toString().isEmpty()||t5.getText().toString().isEmpty()||t6.getText().toString().isEmpty()||t7.getText().toString().isEmpty()||t8.getText().toString().isEmpty()||t9.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
					try{
					FileWriter fw = new FileWriter("traindetails.txt",true);
					fw.write(t0.getText()+","+t1.getText()+","+t2.getText()+","+t3.getText()+","+t4.getText()+","+t5.getText()+","+t6.getText()+","+t7.getText()+","+t8.getText()+","+t9.getText()+"\n");
					fw.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Successfully Amount is Added");
				}catch(Exception e){}
                t0.setText("");
				t1.setText("");
				t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
			}	
			}
		});
    }
}
class Id extends JFrame{   
	JTextField t1,t2;
	JButton b1,b2,b3;
	ImageIcon img;
	JLabel l1,l2,l3,l4;
    Id(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("EMPLOYEE LOGIN");
		l1.setFont(new Font("Times new Roman",Font.BOLD,24));
		l1.setForeground(Color.BLUE);
		l1.setBounds(100,10,300,30);
		add(l1);
        t1 = new JTextField(60);
		t2 = new JPasswordField(60);
		b1 = new JButton("SignIn");
		b2 = new JButton("SignUp");
		t1.setBounds(100,60,120,30);
		t2.setBounds(100,100,120,30);
		b1.setBounds(120,140,80,30);
		b2.setBounds(120,170,80,30);
        b3 = new JButton("<--Back");
        b3.setBounds(10,30,80,30);
		l2 = new JLabel("");
		l2.setBounds(250,80,300,30);
		l3 = new JLabel("ID");
		l3.setBounds(20,60,50,30);
		add(l3);
		l4 = new JLabel("Password");
		l4.setBounds(20,100,70,30);
		add(l4);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
        add(b3);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				boolean match = false;
				String uname = t1.getText().toString();
				String pwd = t2.getText().toString();
				try{
					FileReader fr = new FileReader("employeelogin.txt");
					BufferedReader br = new BufferedReader(fr);
					String str;
					while((str=br.readLine())!=null){
						if(str.equals(uname+"\t"+pwd)){
							match = true;
							break;
						}
					}
					fr.close();
				}catch(Exception e){}
				if(match){
					dispose();
					Employee em = new Employee(name);
					em.setBounds(10,10,400,300);
					em.setVisible(true);
				}
				else{
					l2.setText("Invalid Username or Password!!");
				}
			}
				
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SigUp s = new SigUp(name);
				s.setVisible(true);
				s.setBounds(200,200,500,400);
			}
		});
        b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Rail r = new Rail(name);
				r.setBounds(400,200,400,350);
				r.setVisible(true);	
			}
		});
		
	}
}
class SigUp extends JFrame{
	JTextField t1,t2,t3,t4;
	ImageIcon img;
	JLabel l3,l4,l1,l2,l5;
	JButton b1,b2;
	SigUp(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("SignUp");
		l1.setFont(new Font("Times new Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(40,10,100,30);
		add(l1);
		t1 = new JTextField(60);
		t2 = new JTextField(60);
		t3 = new JTextField(60);
		t4 = new JTextField(60);
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		t1.setBounds(100,50,80,30);
		t2.setBounds(100,90,80,30);
		t3.setBounds(100,130,80,30);
		t4.setBounds(100,170,150,30);
		l2 = new JLabel("Mobile No.");
		l2.setBounds(20,130,80,30);
		add(l2);
		l5 = new JLabel("Mail ID");
		l5.setBounds(20,170,70,30);
		add(l5);
		l3 = new JLabel("ID");
		l3.setBounds(20,50,70,30);
		add(l3);
		l4 = new JLabel("Password");
		l4.setBounds(20,90,70,30);
		add(l4);
		b1.setBounds(100,210,80,30);
		b2.setBounds(100,250,80,30);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()||t4.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
					try{
					FileWriter fw = new FileWriter("employeelogin.txt",true);
					fw.write(t1.getText()+"\t"+t2.getText()+"\n");
					fw.close();
					FileWriter fw1 = new FileWriter("employeedetails.txt",true);
					fw1.write(t1.getText()+","+t3.getText()+","+t4.getText()+"\n");
					fw1.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Registration Completed");
					dispose();
				}catch(Exception e){}
			}
		}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				
			}
		});
	}
}
class SignUp extends JFrame{
	JTextField t1,t2,t3,t4;
	ImageIcon img;
	JLabel l1,l3,l4,l2,l5;
	JButton b1,b2;
	SignUp(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("SignUp");
		l1.setFont(new Font("Times new Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(40,10,100,30);
		add(l1);
		t1 = new JTextField(60);
		t2 = new JTextField(60);
		t3 = new JTextField(60);
		t4 = new JTextField(60);
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		t1.setBounds(100,50,80,30);
		t2.setBounds(100,90,80,30);
		t3.setBounds(100,130,80,30);
		t4.setBounds(100,170,150,30);
		l2 = new JLabel("Mobile No.");
		l2.setBounds(20,130,80,30);
		add(l2);
		add(t3);
		add(t4);
		l5 = new JLabel("Mail ID");
		l5.setBounds(20,170,70,30);
		add(l5);
		l3 = new JLabel("UserName");
		l3.setBounds(20,50,70,30);
		add(l3);
		l4 = new JLabel("Password");
		l4.setBounds(20,90,70,30);
		add(l4);
		b1.setBounds(100,210,80,30);
		b2.setBounds(100,250,80,30);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()||t4.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
				try{
					FileWriter fw = new FileWriter("login.txt",true);
					fw.write(t1.getText()+"\t"+t2.getText()+"\n");
					fw.close();
					FileWriter fw1 = new FileWriter("userdetails.txt",true);
					fw1.write(t1.getText()+","+t3.getText()+","+t4.getText()+"\n");
					fw1.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Registration Completed");
					dispose();
				}catch(Exception e){}
			}
		}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();	
			}
		});
	}
}
class Payment extends JFrame{
	JTextField t1;
	JButton b1,b2,b3,b4;
	JLabel l1,l2;
	JTable table;
	int m=0,m1=0;
	ImageIcon img;
	Payment(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Payment");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(100,10,200,30);
		add(l1);
		l2 = new JLabel("Balance");
		l2.setBounds(20,60,70,30);
		add(l2);
		t1 = new JTextField("",10);
		t1.setBounds(100,60,80,30);
		t1.setEditable(false);
		add(t1);
		try{
					FileReader fr = new FileReader("Creditmoney.txt");
					BufferedReader br = new BufferedReader(fr);
					String str;
					while((str=br.readLine())!=null){
						 String acc = str.substring(str.length() - name.length());
						String acc2 = str.substring(0,(str.length() - name.length()-1));
						if (acc.equals(name)){
						m += Integer.parseInt(acc2);}
					}
					fr.close();
					br.close();
				}catch(Exception e){}
		try{
					FileReader fr = new FileReader("Debitmoney.txt");
					BufferedReader br = new BufferedReader(fr);
					String str;
					while((str=br.readLine())!=null){
						String acc = str.substring(str.length() - name.length());
						String acc2 = str.substring(0,(str.length() - name.length()-1));
						if (acc.equals(name)){
						m1 += Integer.parseInt(acc2);}
					}
					fr.close();
					br.close();
				}catch(Exception e){}
		String s1=String.valueOf(m-m1);
		t1.setText(s1);
		b1 = new JButton("Add Money");
		b1.setBounds(100,100,120,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					dispose();
					AddMoney  a = new AddMoney(name);
					a.setBounds(400,200,500,500);
					a.setVisible(true);	
			}
		});
		b2 = new JButton("<--Back");
		b2.setBounds(10,30,80,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Passenger p = new Passenger(name);
				p.setBounds(400,60,360,250);
				p.setVisible(true);	
			}
		});
		b4 = new JButton("View Debit History");
		b4.setBounds(10,140,160,30);
		add(b4);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					dispose();
					Debit  a1 = new Debit(name);
					a1.setBounds(100,100,500,300);
					a1.setVisible(true);	
				}
		});
		b3 = new JButton("View Credit History");
		b3.setBounds(10,180,160,30);
		add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					dispose();
					Credit  a = new Credit(name);
					a.setBounds(100,100,500,300);
					a.setVisible(true);	
				}
		});
	}
}
class AddMoney extends JFrame{
	JTextField t1,t2;
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	ImageIcon img;
	String d1,d2;
	AddMoney(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Add Money");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(130,10,200,30);
		add(l1);
		t1 = new JTextField(10);
		t2 = new JTextField(5);
		d1 = t1.getText();
		d2 = t2.getText();
		b1 = new JButton("Add");
		b2 = new JButton("<--Back");
		t1.setBounds(110,100,120,30);
		t2.setBounds(110,140,120,30);
		b1.setBounds(120,180,60,30);
		b2.setBounds(10,180,100,30);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		l3 = new JLabel("Mobile Number");
		l3.setBounds(10,100,100,30);
		add(l3);
		l2 = new JLabel("Amount");
		l2.setBounds(10,140,70,30);
		add(l2);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
					try{
					FileWriter fw = new FileWriter("Creditpayment.txt",true);
					fw.write(t1.getText()+","+t2.getText()+","+name+"\n");
					fw.close();
					FileWriter fw2 = new FileWriter("Creditmoney.txt",true);
					fw2.write(t2.getText()+","+name+"\n");
					fw2.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Successfully Amount is Added");
				}catch(Exception e){}
				t1.setText("");
				t2.setText("");
			}
			}
		});	
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Payment l = new Payment(name);
				l.setBounds(400,200,400,300);
				l.setVisible(true);	
			}
		});
	}
}
class TicketList extends JFrame{
    JTextField t1;
    JButton b1,b2;
    JTable table;
	ImageIcon img;
    JPanel p1;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
	List<Integer> matchingRows;
	DefaultTableModel model;
	JScrollPane sp;
    TicketList(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Reserved Seats List");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(230,10,200,40);
		add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10,40,80,25);
        add(b1);
       b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				RailwayDatabase r = new RailwayDatabase(name);
					r.setBounds(10,10,400,300);
					r.setVisible(true);
			}
		}); 
        p1 = new JPanel();
        p1.setBounds(10,80,800,300);
        add(p1);
        try {		
            BufferedReader reader = new BufferedReader(new FileReader("reserveticket.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		try {		
            BufferedReader reader = new BufferedReader(new FileReader("offlinereserveticket.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] columnNames={"Train ID","PNR ","Name","Age","Gender","Berth","Type"};
        model = new DefaultTableModel(columnNames,0);
        for (String[] row : data) {
            model.addRow(row);
        }
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(800, 300));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
        t1 = new JTextField(60);
        t1.setBounds(200,40,200,30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400,40,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = t1.getText().toString().toLowerCase();
				matchingRows = new ArrayList<Integer>();
				table.clearSelection();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {
							matchingRows.add(i);
							break;
							}
						}
					}
					for (int i : matchingRows) {
						table.addRowSelectionInterval(i, i);}
                    t1.setText("");
            }
        });
    }
}
class RailwayDatabase extends JFrame{
	JButton b1,b2,b3,b4,b5;
	JLabel l1;
	ImageIcon img;
	RailwayDatabase(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("RailwayDatabase");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(60,10,200,30);
		add(l1);
		b1 = new JButton("User Details");
		b1.setBounds(60,80,150,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Userdetails ud = new Userdetails(name);
				ud.setSize(850,300);
				ud.setVisible(true);
			}
		});
		b2 = new JButton("Employee Details");
		b2.setBounds(60,120,150,30);
		add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Employeedetails ed = new Employeedetails(name);
				ed.setSize(850,300);
				ed.setVisible(true);
			}
		});
		b3 = new JButton("Add Train Details");
		b3.setBounds(60,160,150,30);
		add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				TrainData r = new TrainData(name);
					r.setBounds(400,200,400,600);
					r.setVisible(true);		
			}
		});
		b4 = new JButton("<--Back");
		b4.setBounds(10,40,80,30);
		add(b4);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Employee em = new Employee(name);
				em.setBounds(10,10,400,300);
				em.setVisible(true);
			}
		});
		b5= new JButton("Ticket List");
		b5.setBounds(60,200,150,30);
		add(b5);	
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				TicketList t = new TicketList(name);
				t.setBounds(400,20,900,600);
				t.setVisible(true);	
			}
		});
	}
}
class Userdetails extends JFrame{
    JTextField t1;
    JButton b1,b2;
	ImageIcon img;
    JTable table;
    JPanel p1;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
	List<Integer> matchingRows;
	DefaultTableModel model;
	JScrollPane sp;
    Userdetails(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("User Details");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(300,10,120,40);
		add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10,40,80,25);
        add(b1);
       b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				RailwayDatabase r = new RailwayDatabase(name);
					r.setBounds(10,10,400,300);
					r.setVisible(true);
			}
		}); 
        p1 = new JPanel();
        p1.setBounds(10,80,800,300);
        add(p1);
        try {		
            BufferedReader reader = new BufferedReader(new FileReader("userdetails.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] columnNames={" UserName","Mobile No","Mail ID"};
        model = new DefaultTableModel(columnNames,0);
        for (String[] row : data) {
            model.addRow(row);
        }
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(500, 200));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
        t1 = new JTextField(60);
        t1.setBounds(200,40,200,30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400,40,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = t1.getText().toString().toLowerCase();
				matchingRows = new ArrayList<Integer>();
				table.clearSelection();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {							
                            matchingRows.add(i);
							break;
							}
						}
					}
					for (int i : matchingRows) {
						table.addRowSelectionInterval(i, i);}
                    t1.setText("");
            }
        });
    }
}
class Employeedetails extends JFrame{
    JTextField t1;
    JButton b1,b2;
    JTable table;
    JPanel p1;
	ImageIcon img;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
	List<Integer> matchingRows;
	DefaultTableModel model;
	JScrollPane sp;
    Employeedetails(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Employee Details");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(300,10,120,40);
		add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10,40,80,25);
        add(b1);
       b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				RailwayDatabase r = new RailwayDatabase(name);
					r.setBounds(10,10,400,300);
					r.setVisible(true);	
			}
		}); 
        p1 = new JPanel();
        p1.setBounds(10,80,800,300);
        add(p1);
        try {		
            BufferedReader reader = new BufferedReader(new FileReader("employeedetails.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] columnNames={" User ID","Mobile No","Mail ID"};
        model = new DefaultTableModel(columnNames,0);
        for (String[] row : data) {
            model.addRow(row);
        }
        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(500, 300));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
        t1 = new JTextField(60);
        t1.setBounds(200,40,200,30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400,40,100,30);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = t1.getText().toString().toLowerCase();
				matchingRows = new ArrayList<Integer>();
				table.clearSelection();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        String value = table.getValueAt(i, j).toString().toLowerCase();
                        if (value.contains(query)) {							
                            matchingRows.add(i);
							break;
							}
						}
					}
					for (int i : matchingRows) {
						table.addRowSelectionInterval(i, i);}
                    t1.setText("");
            }
        });
    }
}
class Debit extends JFrame{
	ArrayList<String[]> data = new ArrayList<>();
	DefaultTableModel model;
	JScrollPane sp;
	ImageIcon img;
	JTable table;
	JButton b2;
	JPanel panel3;
	Debit(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel3 = new JPanel();	
		add(panel3);
		b2 = new JButton("<--Back");
		b2.setBounds(10,450,100, 30);
		panel3.add(b2);
		try {	
			table = new JTable(model);				
			BufferedReader reader = new BufferedReader(new FileReader("Debitpayment.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String acc = line.substring(line.length() - name.length());
				if (acc.equals(name)){
				String[] row = line.split(",");
				data.add(row);}
			}
			reader.close();
			} catch (Exception ex) {
					ex.printStackTrace();
				}
				String[] columnNames={"PNR","Money"};
			model = new DefaultTableModel(columnNames,0);
			for (String[] row : data) {
				model.addRow(row);
				}
				table.setModel(model);		
		sp = new JScrollPane(table);
			sp.setPreferredSize(new Dimension(400, 200));
			sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel3.add(sp);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Payment l = new Payment(name);
				l.setBounds(400,200,400,300);
				l.setVisible(true);		
			}
		});
	}
}
class Credit extends JFrame{
	ArrayList<String[]> data = new ArrayList<>();
	DefaultTableModel model;
	JScrollPane sp;
	JTable table;
	JButton b2;
	ImageIcon img;
	JPanel panel3;
	Credit(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel3 = new JPanel();	
		add(panel3);
		b2 = new JButton("<--Back");
		b2.setBounds(10,450,100, 30);
		panel3.add(b2);
		try {	
			table = new JTable(model);				
			BufferedReader reader = new BufferedReader(new FileReader("Creditpayment.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String acc = line.substring(line.length() - name.length());
				if (acc.equals(name)){
				String[] row = line.split(",");
				data.add(row);}
			}
			reader.close();
			} catch (Exception ex) {
					ex.printStackTrace();
				}
				String[] columnNames={"Mobile No.","Money"};
			model = new DefaultTableModel(columnNames,0);
			for (String[] row : data) {
				model.addRow(row);
				}
				table.setModel(model);		
		sp = new JScrollPane(table);
			sp.setPreferredSize(new Dimension(400, 200));
			sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel3.add(sp);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				Payment l = new Payment(name);
				l.setBounds(400,200,400,300);
				l.setVisible(true);		
			}
		});
	}
}
class Login extends JFrame{
	JTextField t1,t2;
	ImageIcon img;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	Login(String name){
		img = new ImageIcon("Rail3.jpeg");
		setIconImage(img.getImage());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("LOGIN");
		l1.setFont(new Font("Times new Roman",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(130,10,300,30);
		add(l1);
		t1 = new JTextField(60);
		t2 = new JPasswordField(60);
		b1 = new JButton("SignIn");
		b2 = new JButton("SignUp");
		t1.setBounds(100,60,120,30);
		t2.setBounds(100,100,120,30);
		b1.setBounds(120,140,80,30);
		b2.setBounds(120,170,80,30);
		l2 = new JLabel("");
		l2.setBounds(250,80,300,30);
		l3 = new JLabel("UserName");
		l3.setBounds(20,60,70,30);
		add(l3);
		l4 = new JLabel("Password");
		l4.setBounds(20,100,70,30);
		add(l4);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				boolean match = false;
				String uname = t1.getText().toString();
				String pwd = t2.getText().toString();
				try{
					FileReader fr = new FileReader("login.txt");
					BufferedReader br = new BufferedReader(fr);
					String str;
					while((str=br.readLine())!=null){
						if(str.equals(uname+"\t"+pwd)){
							match = true;
							break;
						}
					}
					fr.close();
				}catch(Exception e){}
				if(match){
					dispose();
					Rail r = new Rail(uname);
					r.setBounds(400,200,400,350);
					r.setVisible(true);
				}
				else{
					l2.setText("Invalid Username or Password!!");
				}
			}
				
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SignUp s = new SignUp(name);
				s.setVisible(true);
				s.setBounds(200,200,500,400);
			}
		});
		
	}
}
public class RailJava3 {
	public static void main(String[] args){
		String name = "";
		Login l = new Login(name);
		l.setBounds(400,200,400,300);
		l.setVisible(true);		
}}