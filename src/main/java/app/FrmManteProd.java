package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtC?digo;
	JComboBox cboCategorias;
	JComboBox cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtC?digo = new JTextField();
		txtC?digo.setBounds(122, 11, 86, 20);
		contentPane.add(txtC?digo);
		txtC?digo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(324, 65, 89, 23);
		contentPane.add(btnActualizar);

		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(235, 106, 102, 14);
		contentPane.add(lblProveedor);

		cboProveedores = new JComboBox();
		cboProveedores.setBounds(309, 102, 104, 22);
		contentPane.add(cboProveedores);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		btnBuscar.setBounds(319, 130, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
	}

	void llenaCombo() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
		List<Categoria> lstCategoria = consulta.getResultList();

		cboCategorias.addItem("Seleccione....");
		for (Categoria c : lstCategoria) {
			cboCategorias.addItem(c.getIdcategoria() + "-" + c.getDescripcion());
		}

		TypedQuery<Proveedor> consulta2 = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class);
		List<Proveedor> lstProveedor = consulta2.getResultList();

		cboProveedores.addItem("Seleccione....");
		for (Proveedor p : lstProveedor) {
			cboProveedores.addItem(p.getIdprovedor() + "-" + p.getNombre_rs());
		}

		em.close();

	}

	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Producto> consulta = em.createQuery("SELECT p FROM Producto p", Producto.class);
		List<Producto> lstProducto = consulta.getResultList();

		txtSalida.setText("");
		txtSalida.append("*************************\n");
		for (Producto p : lstProducto) {
			txtSalida.append("Codigo......." + p.getId_prod() + "\n");
			txtSalida.append("Nombre......." + p.getDes_prod() + "\n");
			txtSalida.append("Stock......." + p.getStk_prod() + "\n");
			txtSalida.append("Precio......." + p.getPre_prod() + "\n");
			/* txtSalida.append("Categoria......." + p.getIdcategoria() + "\n"); */
			txtSalida.append("Categoria......." + p.getCategorias().getDescripcion() + "\n");
			txtSalida.append("Estado......." + p.getEst_prod() + "\n");
			txtSalida.append("Proveedor......." + p.getProveedores().getNombre_rs() + "\n");
			txtSalida.append("-----------------------------\n");
		}

		em.close();

	}

	void registrar() {
		String codigo = txtC?digo.getText();
		String nombre = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int categoria = cboCategorias.getSelectedIndex();
		int estado = 1;
		int proveedor = cboProveedores.getSelectedIndex();

		Producto p = new Producto();
		p.setId_prod(codigo);
		p.setDes_prod(nombre);
		p.setStk_prod(stock);
		p.setPre_prod(precio);
		p.setIdcategoria(categoria);
		p.setEst_prod(estado);
		p.setIdprovedor(proveedor);

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		em.persist(p);

		em.getTransaction().commit();

		em.close();
		JOptionPane.showMessageDialog(this, "Producto registrado");

	}
	
	void buscarProducto() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//select * from where id = ?
		Producto p =  em.find(Producto.class, txtC?digo.getText());
		
		if (p == null) {
			txtSalida.setText("Codigo no existe.........");
		}else {
			txtDescripcion.setText(p.getDes_prod());		
		}		

		//Cierre
		em.close();
		System.out.println("Ternimo Busqueda de Productos.....");

	}
}
