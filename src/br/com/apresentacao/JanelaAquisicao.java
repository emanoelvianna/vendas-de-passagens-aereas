package br.com.apresentacao;

import java.util.List;

public class JanelaAquisicao extends javax.swing.JFrame {

	/**
	 * Creates new form JanelaAquisicao
	 */
	public JanelaAquisicao() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox<>();
		jComboBox3 = new javax.swing.JComboBox<>();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jComboBox4 = new javax.swing.JComboBox<>();
		jLabel6 = new javax.swing.JLabel();
		jComboBox5 = new javax.swing.JComboBox<>();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Nome passageiro:");

		jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
				jComboBox1PopupMenuWillBecomeVisible(evt);
			}
		});

		jLabel2.setText("Documento:");

		jLabel3.setText("Tipo de passagem:");

		jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
				jComboBox2PopupMenuWillBecomeVisible(evt);
			}
		});

		jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
				jComboBox3PopupMenuWillBecomeVisible(evt);
			}
		});

		jLabel4.setText("De:");

		jLabel5.setText("Para:");

		jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
				jComboBox4PopupMenuWillBecomeVisible(evt);
			}
		});

		jLabel6.setText("Data da viagem:");

		jComboBox5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
			}

			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
				jComboBox5PopupMenuWillBecomeVisible(evt);
			}
		});

		jButton1.setText("Comprar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField1)
												.addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
								.addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGroup(
												layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1).addComponent(jLabel2)
																.addComponent(jLabel3).addComponent(jLabel4)
																.addComponent(jLabel5)
																.addComponent(jLabel6,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 89,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1)).addGap(0, 290, Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(3, 3, 3)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(4, 4, 4).addComponent(jLabel2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel3)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel4)
				.addGap(3, 3, 3)
				.addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jLabel6)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jButton1)
				.addContainerGap(25, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		int localizador = principalControlador.comprarPassagem(jTextField1.getText(), jComboBox1.getSelectedItem().toString(), jComboBox5.getSelectedItem().toString(), jComboBox3.getSelectedItem().toString(), jComboBox4.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString());
		
		
		JanelaNumeroLocalizador janelaNumeroLocalizador = new JanelaNumeroLocalizador();
		janelaNumeroLocalizador.setVisible(true);
		janelaNumeroLocalizador.setLocalizador(localizador);
	}

	// Documento
	private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		principalControlador.buscarDocumentos();

		List<String> listaDestino = principalControlador.buscarDocumentos();
		for (String item : listaDestino) {
			jComboBox1.addItem(item);
		}
	}

	// tipo passagem
	private void jComboBox2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		principalControlador.buscarDocumentos();

		List<String> listaDestino = principalControlador.buscarTipoPassagem();
		for (String item : listaDestino) {
			jComboBox2.addItem(item);
		}
	}

	// origem
	private void jComboBox3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		// lista de aeroportos de origem
		List<String> listaOrigem = principalControlador.getOrigem();
		for (String item : listaOrigem) {
			jComboBox3.addItem(item);
		}
	}

	// para
	private void jComboBox4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		List<String> listaDestino = principalControlador.getDestino(jComboBox3.getSelectedItem().toString());
		// lista de aeroportos de destino
		for (String item : listaDestino) {
			jComboBox4.addItem(item);
		}
	}

	// data
	private void jComboBox5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
		PrincipalControlador principalControlador = new PrincipalControlador();
		List<String> listaDestino = principalControlador.getData(jComboBox3.getSelectedItem().toString());
		// lista de aeroportos de destino
		for (String item : listaDestino) {
			jComboBox5.addItem(item);
		}
	}

	public static void main(String args[]) {

		PrincipalControlador principalControlador = new PrincipalControlador();

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JanelaAquisicao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JanelaAquisicao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JanelaAquisicao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JanelaAquisicao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JanelaAquisicao().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JComboBox<String> jComboBox3;
	private javax.swing.JComboBox<String> jComboBox4;
	private javax.swing.JComboBox<String> jComboBox5;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration
}
