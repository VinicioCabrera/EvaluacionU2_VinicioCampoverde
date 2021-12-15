package ec.edu.ups.pweb.cliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.pweb.EvaServidor.bussines.departamentoONRemote;
import ec.edu.ups.pweb.EvaServidor.model.Departamento;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaDepartamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtdireccion;
	private JTextField txttelefono;
	private JTextField txtprecio;
	private departamentoONRemote depONRemote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDepartamento frame = new VentanaDepartamento();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public VentanaDepartamento() throws Exception {
		
		
			try {  
	            final Hashtable<String, Comparable> jndiProperties =  
	                    new Hashtable<String, Comparable>();  
	            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
	                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
	            jndiProperties.put("jboss.naming.client.ejb.context", true);  
	              
	            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
	            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");  
	            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");  
	              
	            final Context context = new InitialContext(jndiProperties);  
	              
	            final String lookupName = "ejb:/EvaServidor/departamentoON!ec.edu.ups.pweb.EvaServidor.bussines.departamentoONRemote";  
	              
	            this.depONRemote = (departamentoONRemote) context.lookup(lookupName);  
	              
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	            throw ex;  
	        }  
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcodigo = new JTextField();
		txtcodigo.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				 if(e.getKeyCode()==10){
					 int codigo= Integer.parseInt(txtcodigo.getText());
					
					 Departamento d=depONRemote.read(codigo);
					 
					 txtdireccion.setText(d.getDireccion());
					 txttelefono.setText(d.getTelefono());
					 txtprecio.setText(Double.toString(d.getPrecio()));
					 
				 }
				 
			}
		});
		txtcodigo.addMouseListener(new MouseAdapter() {
		
		});
		txtcodigo.setBounds(108, 66, 96, 36);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(108, 112, 179, 36);
		contentPane.add(txtdireccion);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(108, 158, 179, 36);
		contentPane.add(txttelefono);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(108, 204, 179, 36);
		contentPane.add(txtprecio);
		
		Button btnguardar = new Button("GUARDAR");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento d=new Departamento();
				int cod=Integer.parseInt(txtcodigo.getText());
				d.setCodigo(cod);
				d.setDireccion(txtdireccion.getText());
				d.setTelefono(txttelefono.getText());
				double pre=Double.parseDouble(txtprecio.getText());
				d.setPrecio(pre);
				try {
					depONRemote.insert(d);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnguardar.setActionCommand("");
		btnguardar.setBounds(325, 127, 89, 21);
		contentPane.add(btnguardar);
		
		JLabel lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 74, 72, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion :");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 120, 88, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono :");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 166, 88, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio :");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_3.setBounds(24, 215, 74, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DEPARTAMENTO");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 22));
		lblNewLabel_4.setBounds(124, 10, 202, 30);
		contentPane.add(lblNewLabel_4);
		
		Button button = new Button("ACTUALIZAR");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Departamento dep=new Departamento();
				
				dep.setCodigo(Integer.parseInt(txtcodigo.getText()));
				dep.setDireccion(txtdireccion.getText());
				dep.setTelefono(txttelefono.getText());
				dep.setPrecio(Double.parseDouble(txtprecio.getText()));
				depONRemote.update(dep);
				
			}
		});
		button.setBounds(311, 170, 115, 21);
		contentPane.add(button);
	}
}
