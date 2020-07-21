package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.*; 
import java.util.concurrent.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.net.InetAddress;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class doctoe{
	String name ;
	Double lati;
	Double longi;
	public String addr;
}
public class BookAppointment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String city;
	private String state;
	private String postal;
	private double latitude;
	private double longitude;
	int n;
	String [] all;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppointment frame = new BookAppointment();
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
	 public static double getDistanceFromLatLonInKm(double lat1,double lon1,double lat2,double lon2) 
	    {
	        double R = 6371; // Radius of the earth in km
	        double dLat = Math.abs(deg2rad(lat2-lat1));  // deg2rad below
	        double dLon = Math.abs(deg2rad(lon2-lon1)); 
	        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.sin(dLon/2)*Math.sin(dLon/2); 
	        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a)); 
	        double d = R * c; // Distance in km
	        return d;
	    }
	 public static double deg2rad(double deg) 
	    {
	        return deg * (Math.PI/180);
	    }
	 public static int getRandomDoubleBetweenRange(int min, int max){
		    int x = (int)	(Math.random()*((max-min)+1))+min;
		    return x;
		}
	public BookAppointment() {}
	public BookAppointment(String id) {
		//String id ="U01";
		System.out.println(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("DocMed");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("User Details");
		label_1.setForeground(new Color(50, 205, 50));
		label_1.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Date:\r\n");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
	      try {
	          URL ipapi = new URL("https://ipapi.co/latlong/");
	          URLConnection c = ipapi.openConnection();
	          c.setRequestProperty("User-Agent", "java-ipapi-client");
	          BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
	          String location[] = reader.readLine().split(",");
	          latitude = (Double.valueOf(location[0]));
	          longitude = (Double.valueOf(location[1]));
	          reader.close();
	          
	          ipapi = new URL("https://ipapi.co/postal/");
	          c = ipapi.openConnection();
	          c.setRequestProperty("User-Agent", "java-ipapi-client");
	          reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
	          postal = (reader.readLine());
	          reader.close();
	          
	          ipapi = new URL("https://ipapi.co/city/");
	          c = ipapi.openConnection();
	          c.setRequestProperty("User-Agent", "java-ipapi-client");
	          reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
	          city = (reader.readLine());
	          reader.close();
	          
	          ipapi = new URL("https://ipapi.co/region/");
	          c = ipapi.openConnection();
	          c.setRequestProperty("User-Agent", "java-ipapi-client");
	          reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
	          state = (reader.readLine());
	          reader.close();}catch(IOException e) {System.out.println("IO Exception");}
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String app_date = df.format(dateChooser.getDate()).toString() ; 
					System.out.println(app_date);
					String app_time = comboBox.getSelectedItem().toString();
					System.out.println(app_time);
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");

						PreparedStatement ps = conn.prepareStatement("select count(*),doc_id from appointment where pincode =? and app_date =? and app_time =? GROUP BY doc_id ORDER BY count(*)");
						ps.setString(1,postal);
						  ps.setDate(2,java.sql.Date.valueOf(app_date));
						  ps.setTime(3,java.sql.Time.valueOf(app_time));
						  //JOptionPane.showMessageDialog(null,"2");
						  ResultSet res = ps.executeQuery();
						  while(res.next())
						  {
							  int c=res.getInt(1);
							  String s = res.getString(2);
							  if(c>=5)
								  JOptionPane.showMessageDialog(null,"change time frame max threshold reached");
						  }
						   
						  conn.close();
				} catch (Exception e) {e.printStackTrace();} 
			}
		});
		comboBox.setFont(new Font("Verdana", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"none","10:00:00", "10:30:00", "11:00:00"}));
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Pincode:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15)); 
		
		textField.setText(postal);
		TreeMap<Double, String> tree_map = new TreeMap<Double, String>();
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");

				PreparedStatement ps = conn.prepareStatement("select doc_id,lat,log,address from doctorinfo where pincode =? and status =1");
				  ps.setString(1,postal);
				  //JOptionPane.showMessageDialog(null,"2");
				  ResultSet res = ps.executeQuery();
				  res.last();                         // record pointer is placed on the last row
				  n = res.getRow();
				  all = new String[n];
				  doctoe [] co = new doctoe[n];
				  res.beforeFirst();
				  System.out.println("count: "+n+" ");
				  int i = 0,j=1;   // iterate 
				  while(res.next())
				  {	  if(i<n)
					  {doctoe dc = new doctoe();
				   dc.name = res.getString(1);
				   dc.lati = res.getDouble(2);
				   dc.longi = res.getDouble(3);
				   dc.addr = res.getString(4);
				   co[i]=dc;
				  all[i]=res.getString(1);
				   i++;
				   j++;
					  }
				  }
				  System.out.println("j: "+i+" ");
				  for(doctoe d:co)
				  { tree_map.put(getDistanceFromLatLonInKm(latitude,d.lati,longitude,d.longi),d.name); 
				  
				  }
				//  System.out.println(d.name+" "+d.lati+" "+d.longi+""+d.addr);
				  conn.close();
		} catch (Exception e) {e.printStackTrace();} 
		//System.out.println("TreeMap: "+ tree_map.firstEntry().getValue()); 
 
		 
		
		JButton btnNewButton = new JButton("Book my Appointment");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String app_date = df.format(dateChooser.getDate()).toString() ; 
					System.out.println(app_date);
					String app_time = comboBox.getSelectedItem().toString();
					System.out.println(app_time);
					String addr=null,doc=null;
					  Class.forName("com.mysql.jdbc.Driver"); 
					  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					  JOptionPane.showMessageDialog(null,"1");
					  PreparedStatement ps = conn.prepareStatement("select count(*),doc_id from appointment where pincode =? and app_date =? GROUP BY doc_id ORDER BY count(*)");
					  ps.setString(1,postal);
					  ps.setDate(2,java.sql.Date.valueOf(app_date));
					  JOptionPane.showMessageDialog(null,"2");
					  ResultSet res = ps.executeQuery();
					  res.last();                         // record pointer is placed on the last row
					  int count = res.getRow();
					  System.out.println("count:"+count+" n:"+n); 
					  res.beforeFirst();
					  
					  if(res.next())
						  doc=res.getString(2);
					  else
					  doc=null;
					  if(doc!=null)
					  {
						  PreparedStatement ps3 = conn.prepareStatement("select address from doctorinfo where doc_id = ?");
						  ps3.setString(1,doc);
						  ResultSet res3 = ps3.executeQuery();
						  res3.next();
						  addr = res3.getString(1);
					  }
					  System.out.println("doc:"+doc+"near to null"); 
					  for(String a : all)
						  System.out.print("\t"+a+"\t");
					  if(doc == null)
					  { JOptionPane.showMessageDialog(null,"doc is null");
					     doc=tree_map.firstEntry().getValue();
						  PreparedStatement ps2 = conn.prepareStatement("select address from doctorinfo where doc_id = ?");
						  ps2.setString(1,doc);
						  ResultSet res2 = ps2.executeQuery();
						  res2.next();
						   addr = res2.getString(1);
						  System.out.println("address:"+addr);
						  
					  }
					  else if(count<n){
						  int i=0;
						  System.out.println("enter else");
						  String [] left = new String[n-count];
						  res.beforeFirst();
						  while(res.next())
						  {for(String a : all)
							  if(a.equals(res.getString(2)))
							  continue;
							  else  
								  {left[i]=a;
								  	i++;
								  }
						    }
						  int j=getRandomDoubleBetweenRange(0,i);
						  if(j==i)
						  	doc=left[j-1];
						  else
							  doc=left[j]; 
						  	PreparedStatement ps2 = conn.prepareStatement("select address from doctorinfo where doc_id = ?");
							  ps2.setString(1,doc);
							  ResultSet res2 = ps2.executeQuery();
							  res2.next();
							   addr = res2.getString(1);
							  System.out.println("address:"+addr);
					  }
					  					  
					  
					/*
					 * String posta = postal; Double lat = latitude; Double log = longitude;
					 */
					Date now = new java.util.Date();
					JOptionPane.showMessageDialog(null,"checks done");
					String query = "insert into appointment (reg_time,doc_id,app_date,app_time,pat_id,pincode,status,confirm,address)" +"values (?,?,?,?,?,?,?,0,?)";
					PreparedStatement ps1 = conn.prepareStatement(query);
					Timestamp current = new java.sql.Timestamp(now.getTime());
					ps1.setTimestamp(1,current);
					ps1.setString(2,doc);
					ps1.setDate(3,java.sql.Date.valueOf(app_date));
					ps1.setTime(4,java.sql.Time.valueOf(app_time));
					ps1.setString(5,id);
					ps1.setInt(6,Integer.parseInt(postal));
					ps1.setInt(7,1);
					ps1.setString(8,addr);
					JOptionPane.showMessageDialog(null,"items placed ready to execute");
					if(ps1.executeUpdate()!=0)
							{JOptionPane.showMessageDialog(null,"Regristration Successful");
							UserLogIn uli1= new UserLogIn();
							uli1.setVisible(true);
							dispose();
							} 
					else { JOptionPane.showMessageDialog(null,"Invalid username or password");
					UserSignUp uli1= new UserSignUp();
					uli1.setVisible(true);
					dispose();
					}
					 
					 							
					}catch(Exception e1) {e1.printStackTrace();}
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Back to Portal");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserPortal up= new UserPortal(id);
				up.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(209, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGap(202))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(190)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_1_1))
									.addGap(26))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(138, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnNewButton)
					.addGap(36)
					.addComponent(lblNewLabel_2)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
