
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class guisystem extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guisystem frame = new guisystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guisystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton querya = new JButton("Query 1");
		querya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection ca=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","");
				    Statement sa=ca.createStatement();
				    String qa="select name,population from country order by population DESC;";
				    ResultSet ra= sa.executeQuery(qa);
				    ResultSetMetaData md=ra.getMetaData();
				    DefaultTableModel mo=(DefaultTableModel) table.getModel();
				    
				    int c=md.getColumnCount();
				    String[] as=new String[c];
				    for(int i=0;i<c;i++) {
				    	as[i]=md.getColumnName(i+1);
				    	mo.setColumnIdentifiers(as);
				        String name,Population;
				        while(ra.next()) {
				        	name=ra.getString(1);
				        	Population=ra.getString(2);
				        	String[] rows= {name,Population};
				        		mo.addRow(rows);
				        }
				        sa.close();
				        
				    }
				    	
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		querya.setBounds(10, 11, 89, 23);
		contentPane.add(querya);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 15, 384, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton clear = new JButton("Reset");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		clear.setBounds(10, 293, 89, 23);
		contentPane.add(clear);
		
		JButton queryb = new JButton("Query 2");
		queryb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cb=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","");
				    Statement sb=cb.createStatement();
				    String qb="select id,name,population from city order by population DESC;";
				    ResultSet rb= sb.executeQuery(qb);
				    ResultSetMetaData md=rb.getMetaData();
				    DefaultTableModel mo=(DefaultTableModel) table.getModel();
				    
				    int cba=md.getColumnCount();
				    String[] co=new String[cba];
				    for(int i=0;i<cba;i++) {
				    	co[i]=md.getColumnName(i+1);
				    	mo.setColumnIdentifiers(co);
				        String id,name,Population;
				        while(rb.next()) {
				        	id=rb.getString(1);
				        	name=rb.getString(2);
				        	Population=rb.getString(3);
				        	String[] row= {id,name,Population};
				        		mo.addRow(row);
				        }
				        sb.close();
				        
				    }
				    	
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		queryb.setBounds(10, 45, 89, 23);
		contentPane.add(queryb);
		
		JButton queryd = new JButton("Query 3");
		queryd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","");
				    Statement sc=cc.createStatement();
				    String qc="select capital,population from country order by population DESC;";
				    ResultSet rc= sc.executeQuery(qc);
				    ResultSetMetaData md=rc.getMetaData();
				    DefaultTableModel mo=(DefaultTableModel) table.getModel();
				    
				    int co=md.getColumnCount();
				    String[] col=new String[co];
				    for(int i=0;i<co;i++) {
				    	col[i]=md.getColumnName(i+1);
				    	mo.setColumnIdentifiers(col);
				        String capital,Population;
				        while(rc.next()) {
				        	capital=rc.getString(1);
				        	Population=rc.getString(2);        	
				        	String[] row= {capital,Population};
				        		mo.addRow(row);
				        }
				        sc.close();
				        cc.close();
				    }
				    	
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		queryd.setBounds(10, 79, 89, 23);
		contentPane.add(queryd);
	}
}
