import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

class Rail extends JFrame {
    JButton b1, b2, b4, ex;
    JLabel l1, l2;
    ImageIcon img;

    Rail(String name) {
        img = new ImageIcon("Rail3.jpeg");
        setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Railway Reservation System");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(10, 10, 400, 30);
        add(l1);
        b1 = new JButton("Passenger");
        b1.setBounds(100, 70, 120, 30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Passenger p = new Passenger(name);
                p.setBounds(400, 60, 360, 250);
                p.setVisible(true);
            }
        });
        b2 = new JButton("Employee");
        b2.setBounds(100, 110, 120, 30);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Id id = new Id(name);
                id.setBounds(400, 200, 400, 400);
                id.setVisible(true);
            }
        });
        b4 = new JButton("Train");
        b4.setBounds(100, 150, 120, 30);
        add(b4);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Trains t = new Trains(name);
                t.setSize(850, 600);
                t.setVisible(true);
            }
        });
        ex = new JButton("LogOut");
        ex.setBounds(300, 50, 80, 30);
        add(ex);
        ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Login l = new Login(name);
                l.setBounds(400, 200, 400, 300);
                l.setVisible(true);
            }
        });

        createTables();
    }

    private void createTables() {
        String createPassengerTable = "CREATE TABLE IF NOT EXISTS passengers (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "age INT, " +
                "gender VARCHAR(10), " +
                "berth VARCHAR(50), " +
                "train_id INT)";

        String createReservationsTable = "CREATE TABLE IF NOT EXISTS reservations (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "train_id INT, " +
                "pnr VARCHAR(255), " +
                "name VARCHAR(255), " +
                "age INT, " +
                "gender VARCHAR(10), " +
                "berth VARCHAR(50))";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "username", "password");
             Statement stmt = conn.createStatement()) {
            stmt.execute(createPassengerTable);
            stmt.execute(createReservationsTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Passenger extends JFrame {
    JLabel l1;
    JButton b1, b2, b3, b6;
    ImageIcon img;

    Passenger(String name) {
        img = new ImageIcon("Rail3.jpeg");
        setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Passenger E-service");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30, 10, 300, 30);
        add(l1);
        b1 = new JButton("Reserve Seat");
        b1.setBounds(100, 70, 120, 30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Seat l = new Seat(name);
                l.setBounds(400, 50, 500, 500);
                l.setVisible(true);
            }
        });
        b2 = new JButton("View Ticket");
        b2.setBounds(100, 110, 120, 30);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Ticket t = new Ticket(name);
                t.setBounds(400, 50, 900, 600);
                t.setVisible(true);
            }
        });
        b6 = new JButton("Payment");
        b6.setBounds(100, 150, 120, 30);
        add(b6);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Payment p = new Payment(name);
                p.setBounds(400, 200, 400, 300);
                p.setVisible(true);
            }
        });
        b3 = new JButton("<--Back");
        b3.setBounds(10, 50, 80, 20);
        add(b3);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Rail r = new Rail(name);
                r.setBounds(400, 200, 400, 350);
                r.setVisible(true);
            }
        });
    }
}

class Ticket extends JFrame {
    JTextField t1;
    JButton b1, b2;
    JTable table;
    JPanel p1;
    JLabel l1;
    ArrayList<String[]> data = new ArrayList<>();
    List<Integer> matchingRows;
    DefaultTableModel model;
    JScrollPane sp;
    ImageIcon img;

    Ticket(String name) {
        img = new ImageIcon("Rail3.jpeg");
        setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Reserved Seats List");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(230, 10, 200, 40);
        add(l1);
        b1 = new JButton("<--Back");
        b1.setBounds(10, 40, 80, 25);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Passenger p = new Passenger(name);
                p.setBounds(400, 60, 360, 250);
                p.setVisible(true);
            }
        });
        p1 = new JPanel();
        p1.setBounds(10, 80, 800, 300);
        add(p1);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "username", "password");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE name = ?")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = {
                        rs.getString("train_id"),
                        rs.getString("pnr"),
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("berth")
                };
                data.add(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String[] columnNames = {"Train ID", "PNR", "Name", "Age", "Gender", "Berth"};
        model = new DefaultTableModel(columnNames, 0);
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
        t1.setBounds(200, 40, 200, 30);
        add(t1);
        b2 = new JButton("Search");
        b2.setBounds(400, 40, 100, 30);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = t1.getText().toString().toLowerCase();
                matchingRows = new ArrayList<>();
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
                    table.addRowSelectionInterval(i, i);
                }
                t1.setText("");
            }
        });
    }
}

class Seat extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    ImageIcon img;

    Seat(String name) {
        img = new ImageIcon("Rail3.jpeg");
        setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Train Reservation");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 10, 200, 30);
        add(l1);
        l2 = new JLabel("Train ID:");
        l2.setBounds(50, 50, 100, 30);
        add(l2);
        t1 = new JTextField(10);
        t1.setBounds(150, 50, 100, 30);
        add(t1);
        l3 = new JLabel("PNR:");
        l3.setBounds(50, 90, 100, 30);
        add(l3);
        t2 = new JTextField(10);
        t2.setBounds(150, 90, 100, 30);
        add(t2);
        l4 = new JLabel("Name:");
        l4.setBounds(50, 130, 100, 30);
        add(l4);
        t3 = new JTextField(10);
        t3.setBounds(150, 130, 100, 30);
        add(t3);
        l5 = new JLabel("Age:");
        l5.setBounds(50, 170, 100, 30);
        add(l5);
        t4 = new JTextField(10);
        t4.setBounds(150, 170, 100, 30);
        add(t4);
        l6 = new JLabel("Gender:");
        l6.setBounds(50, 210, 100, 30);
        add(l6);
        t5 = new JTextField(10);
        t5.setBounds(150, 210, 100, 30);
        add(t5);
        l7 = new JLabel("Berth:");
        l7.setBounds(50, 250, 100, 30);
        add(l7);
        t6 = new JTextField(10);
        t6.setBounds(150, 250, 100, 30);
        add(t6);
        b1 = new JButton("Reserve");
        b1.setBounds(50, 290, 100, 30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "username", "password");
                     PreparedStatement ps = conn.prepareStatement("INSERT INTO reservations (train_id, pnr, name, age, gender, berth) VALUES (?, ?, ?, ?, ?, ?)")) {
                    ps.setInt(1, Integer.parseInt(t1.getText()));
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setInt(4, Integer.parseInt(t4.getText()));
                    ps.setString(5, t5.getText());
                    ps.setString(6, t6.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Reservation Successful");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        b2 = new JButton("Back");
        b2.setBounds(160, 290, 100, 30);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Passenger p = new Passenger(name);
                p.setBounds(400, 60, 360, 250);
                p.setVisible(true);
            }
        });
    }
}

class Login extends JFrame {
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;
    ImageIcon img;

    Login(String name) {
        img = new ImageIcon("Rail3.jpeg");
        setIconImage(img.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Login Page");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(120, 10, 200, 30);
        add(l1);
        l2 = new JLabel("Username:");
        l2.setBounds(50, 60, 100, 30);
        add(l2);
        t1 = new JTextField(10);
        t1.setBounds(150, 60, 100, 30);
        add(t1);
        l3 = new JLabel("Password:");
        l3.setBounds(50, 100, 100, 30);
        add(l3);
        p1 = new JPasswordField(10);
        p1.setBounds(150, 100, 100, 30);
        add(p1);
        b1 = new JButton("Login");
        b1.setBounds(50, 140, 80, 30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "username", "password");
                     PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
                    ps.setString(1, t1.getText());
                    ps.setString(2, new String(p1.getPassword()));
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        dispose();
                        Rail r = new Rail(t1.getText());
                        r.setBounds(400, 200, 400, 350);
                        r.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        b2 = new JButton("Exit");
        b2.setBounds(150, 140, 80, 30);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
}

public class RailJava3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Login l = new Login("");
        l.setBounds(400, 200, 400, 300);
        l.setVisible(true);
    }
}
