package com.lti.canvas.browse;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.lti.canvas.util.BrowseUtil;
import javax.swing.JLayeredPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class CanvasInsights {

	private JFrame sourceDestinationLocation = new JFrame();
	private BrowseUtil br = new BrowseUtil();
	private JTextField tomcatTextField;
	private JTextField mongoTextField;
	private JTextField globalTextField;
	private JTextField nlpTextField;
	private JTextField glassboxTextField;
	private JTextField metiseTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasInsights window = new CanvasInsights();
					window.sourceDestinationLocation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CanvasInsights() {
		// frame.getContentPane().setLayout(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	List<String> sourceLocationsFiles = new ArrayList<String>();
	List<String> anacondaLocationsFiles = new ArrayList<String>();

	private void initialize() {

		sourceDestinationLocation = new JFrame();
		sourceDestinationLocation.setBounds(100, 100, 640, 368);
		sourceDestinationLocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sourceDestinationLocation.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		JPanel fileFolderMovementPanel = new JPanel();

		// Collecting Source and Destination location
		JPanel srcDestPanel = new JPanel();
		JLabel lblsdlSourceLocation = new JLabel("Soucre Location");
		JLabel lblsdlDestinationLocation = new JLabel("Destination Location");
		JButton btnsdlCancel = new JButton("Cancel");
		JLabel lblsdlSourceMessageLabel = new JLabel("");
		JButton btnsdlSrcBrowse = new JButton("Browse");
		JLabel lblsdlDestinationMessageLabel = new JLabel("");
		JButton btnsdlDestinationBrowse = new JButton("Browse");
		JButton btnsdlNextButton = new JButton("Next");
		JLabel lblsdlAnacondaLocation = new JLabel("Anaconda Location");
		JLabel lblsdlAnacondaMessage = new JLabel("");
		JButton btnsdlBrowse = new JButton("Browse");
		JLabel lblsdlTomcatLabel = new JLabel("Tomcat Location");
		JLabel lblsdlTomcatLocationMessage = new JLabel("");
		JButton btnsdlTomcatButton = new JButton("Browse");

		// File Movement
		JLabel lblssmSrclocationMsgLabel = new JLabel("");
		JLabel lblssmTomcatLocationMsgLabel = new JLabel("");
		JRadioButton rdbtnssmTomcat = new JRadioButton("Tomcat");
		JRadioButton rdbtnssmNlp = new JRadioButton("Nlp");
		JRadioButton rdbtnssmGlobalpy = new JRadioButton("Globalpy");

		tomcatTextField = new JTextField();
		tomcatTextField.setColumns(10);
		mongoTextField = new JTextField();
		mongoTextField.setColumns(10);
		globalTextField = new JTextField();
		globalTextField.setColumns(10);
		nlpTextField = new JTextField();
		nlpTextField.setColumns(10);
		glassboxTextField = new JTextField();
		glassboxTextField.setColumns(10);
		metiseTextField = new JTextField();
		metiseTextField.setColumns(10);

		layeredPane.setBounds(12, 12, 593, 300);
		sourceDestinationLocation.getContentPane().add(layeredPane);

		CardLayout layout = new CardLayout();
		layeredPane.setLayout(layout);

		layeredPane.add(srcDestPanel, "sourceDestinationPanel");
		srcDestPanel.setLayout(null);

		lblsdlSourceLocation.setToolTipText("Soucre Location");
		lblsdlSourceLocation.setBounds(12, 36, 132, 15);
		srcDestPanel.add(lblsdlSourceLocation);

		lblsdlDestinationLocation.setToolTipText("Destination Location");
		lblsdlDestinationLocation.setBounds(12, 190, 132, 15);
		srcDestPanel.add(lblsdlDestinationLocation);

		btnsdlCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.cancelButton();
			}
		});
		btnsdlCancel.setToolTipText("Cancel");
		btnsdlCancel.setBounds(356, 264, 117, 25);
		srcDestPanel.add(btnsdlCancel);

		lblsdlSourceMessageLabel.setBounds(167, 36, 306, 15);
		srcDestPanel.add(lblsdlSourceMessageLabel);

		btnsdlSrcBrowse.setToolTipText("SourceBrowseLocation");
		btnsdlSrcBrowse.setBounds(474, 31, 94, 25);
		srcDestPanel.add(btnsdlSrcBrowse);

		lblsdlDestinationMessageLabel.setBounds(167, 190, 303, 15);
		srcDestPanel.add(lblsdlDestinationMessageLabel);

		btnsdlDestinationBrowse.setToolTipText("DestinationBrowseLocation");
		btnsdlDestinationBrowse.setBounds(474, 185, 94, 25);
		srcDestPanel.add(btnsdlDestinationBrowse);

		btnsdlNextButton.setToolTipText("Next");
		btnsdlNextButton.setBounds(168, 264, 117, 25);
		srcDestPanel.add(btnsdlNextButton);

		lblsdlAnacondaLocation.setBounds(12, 89, 132, 15);
		srcDestPanel.add(lblsdlAnacondaLocation);

		lblsdlAnacondaMessage.setBounds(167, 89, 297, 15);
		srcDestPanel.add(lblsdlAnacondaMessage);

		btnsdlBrowse.setBounds(474, 84, 94, 25);
		srcDestPanel.add(btnsdlBrowse);

		lblsdlTomcatLabel.setBounds(12, 144, 132, 14);
		srcDestPanel.add(lblsdlTomcatLabel);

		lblsdlTomcatLocationMessage.setBounds(163, 144, 297, 14);
		srcDestPanel.add(lblsdlTomcatLocationMessage);

		btnsdlTomcatButton.setBounds(474, 140, 94, 23);
		srcDestPanel.add(btnsdlTomcatButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 251, 549, 2);
		srcDestPanel.add(separator);

		// File Folder Movement Panel

		layeredPane.add(fileFolderMovementPanel, "fileFolderMovementPanel");
		fileFolderMovementPanel.setLayout(null);

		rdbtnssmTomcat.setBounds(30, 28, 78, 23);
		fileFolderMovementPanel.add(rdbtnssmTomcat);

		rdbtnssmNlp.setBounds(217, 28, 109, 23);
		fileFolderMovementPanel.add(rdbtnssmNlp);

		rdbtnssmGlobalpy.setBounds(396, 28, 109, 23);
		fileFolderMovementPanel.add(rdbtnssmGlobalpy);

		JCheckBox chckbxssmAllCheck = new JCheckBox("All");
		JCheckBox chckbxssmGlassbox = new JCheckBox("");
		JCheckBox chckbxssmMetise = new JCheckBox("");
		JCheckBox chckbxssmrootzip = new JCheckBox("");
		JSeparator ssmseparatordeploy = new JSeparator();

		JLabel lblssmSrcLocation = new JLabel("Source Location");
		lblssmSrcLocation.setBounds(30, 81, 102, 14);
		fileFolderMovementPanel.add(lblssmSrcLocation);

		JLabel lblssmTomcatLocation = new JLabel("Tomcat Location");
		lblssmTomcatLocation.setBounds(30, 116, 100, 14);
		fileFolderMovementPanel.add(lblssmTomcatLocation);

		lblssmSrclocationMsgLabel.setBounds(142, 81, 355, 14);
		fileFolderMovementPanel.add(lblssmSrclocationMsgLabel);

		lblssmTomcatLocationMsgLabel.setBounds(140, 116, 355, 14);
		fileFolderMovementPanel.add(lblssmTomcatLocationMsgLabel);

		JLabel lblssmFilelists = new JLabel("File List's");
		lblssmFilelists.setBounds(30, 163, 78, 14);
		fileFolderMovementPanel.add(lblssmFilelists);

		JSeparator ssmseparator = new JSeparator();
		ssmseparator.setBounds(30, 149, 545, 2);
		fileFolderMovementPanel.add(ssmseparator);

		chckbxssmGlassbox.setBounds(100, 187, 161, 23);
		chckbxssmMetise.setBounds(263, 187, 190, 23);
		chckbxssmrootzip.setBounds(455, 187, 97, 23);
		chckbxssmAllCheck.setBounds(30, 187, 97, 23);

		fileFolderMovementPanel.add(chckbxssmGlassbox);
		fileFolderMovementPanel.add(chckbxssmMetise);
		fileFolderMovementPanel.add(chckbxssmrootzip);
		fileFolderMovementPanel.add(chckbxssmAllCheck);

		ssmseparatordeploy.setBounds(30, 228, 545, 2);
		fileFolderMovementPanel.add(ssmseparatordeploy);

		JButton btnssmMoveFiles = new JButton("Move Files");
		btnssmMoveFiles.setBounds(209, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmMoveFiles);

		JCheckBox chckbxssmNlp = new JCheckBox("");
		chckbxssmNlp.setBounds(129, 187, 109, 23);
		fileFolderMovementPanel.add(chckbxssmNlp);

		JCheckBox chckbxssmGlobalpy = new JCheckBox("");
		chckbxssmGlobalpy.setBounds(110, 187, 248, 23);
		fileFolderMovementPanel.add(chckbxssmGlobalpy);

		JLabel lblssmNlpLocation = new JLabel("Nlp Location");
		lblssmNlpLocation.setBounds(30, 116, 125, 14);
		fileFolderMovementPanel.add(lblssmNlpLocation);

		JLabel lblssmGlobalPyLocation = new JLabel("Global_py Location");
		lblssmGlobalPyLocation.setBounds(30, 116, 141, 14);
		fileFolderMovementPanel.add(lblssmGlobalPyLocation);

		JLabel lblssmNlpMsgLabel = new JLabel("");
		lblssmNlpMsgLabel.setBounds(152, 116, 364, 14);
		fileFolderMovementPanel.add(lblssmNlpMsgLabel);

		JLabel lblssmGlobalMsgLabel = new JLabel("");
		lblssmGlobalMsgLabel.setBounds(152, 116, 397, 14);
		fileFolderMovementPanel.add(lblssmGlobalMsgLabel);

		JButton btnssmExtractFiles = new JButton("Extract");

		btnssmExtractFiles.setBounds(322, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmExtractFiles);

		JButton btnssmNext = new JButton("Next");
		btnssmNext.setBounds(433, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmNext);

		JButton btnssmBack = new JButton("Back");

		btnssmBack.setBounds(100, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmBack);

		// Action

		btnsdlTomcatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.browseFolder(lblsdlTomcatLocationMessage);
			}
		});

		btnsdlBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.browseFolder(lblsdlAnacondaMessage);
				anacondaLocationsFiles = br.listFilesInFolder(lblsdlAnacondaMessage.getText());
				System.out.println(anacondaLocationsFiles);
			}
		});

		btnsdlSrcBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.browseFolder(lblsdlSourceMessageLabel);
				sourceLocationsFiles = br.listFilesInFolder(lblsdlSourceMessageLabel.getText());
				System.out.println(sourceLocationsFiles);
			}
		});

		btnsdlDestinationBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.browseFolder(lblsdlDestinationMessageLabel);
				List<String> fileNames = br.listFilesInFolder(lblsdlDestinationMessageLabel.getText());
				System.out.println(fileNames);
			}
		});

		btnsdlNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
				br.assignValuesToTextFields(sourceLocationsFiles, mongoTextField, globalTextField, glassboxTextField,
						metiseTextField);
				// Labels
				lblssmSrclocationMsgLabel.setText(lblsdlSourceMessageLabel.getText());
				lblssmSrclocationMsgLabel.setToolTipText(lblsdlSourceMessageLabel.getText());

				lblssmTomcatLocationMsgLabel.setText(lblsdlTomcatLocationMessage.getText());
				lblssmTomcatLocationMsgLabel.setToolTipText(lblsdlTomcatLocationMessage.getText());

				lblssmNlpMsgLabel.setText(lblsdlAnacondaMessage.getText());
				lblssmNlpMsgLabel.setToolTipText(lblsdlAnacondaMessage.getText());

				lblssmGlobalMsgLabel.setText(lblsdlDestinationMessageLabel.getText());
				lblssmGlobalMsgLabel.setToolTipText(lblsdlDestinationMessageLabel.getText());

				lblssmTomcatLocation.setVisible(true);
				lblssmGlobalPyLocation.setVisible(false);
				lblssmNlpLocation.setVisible(false);

				lblssmTomcatLocationMsgLabel.setVisible(true);
				lblssmNlpMsgLabel.setVisible(false);
				lblssmGlobalMsgLabel.setVisible(false);

				// Visible false
				chckbxssmNlp.setVisible(false);
				chckbxssmGlobalpy.setVisible(false);

				// Assign Values toCheckbox
				Boolean allFilesStatus = false;
				List<String> fileNames = br.listFilesInFolder(lblsdlSourceMessageLabel.getText());
				for (String fileName : fileNames) {
					if ((fileName.equalsIgnoreCase("Glassbox_Service-1.0.war")) || (fileName.contains("Glass"))) {
						chckbxssmGlassbox.setText(fileName);
						chckbxssmGlassbox.setSelected(true);

					}
					if ((fileName.equalsIgnoreCase("MetisServices-1.0.war")) || (fileName.contains("Metis"))) {
						chckbxssmMetise.setText(fileName);
						chckbxssmMetise.setSelected(true);
					}
					if ((fileName.equalsIgnoreCase("ROOT.zip")) || (fileName.contains("Root"))) {
						chckbxssmrootzip.setText(fileName);
						chckbxssmrootzip.setSelected(true);
					}
				}

				// Enable Radio Button
				rdbtnssmTomcat.setSelected(true);
			}
		});

		btnssmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, srcDestPanel);
			}
		});

		btnssmMoveFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(rdbtnssmTomcat.isSelected());
				System.out.println(rdbtnssmNlp.isSelected());
				System.out.println(rdbtnssmGlobalpy.isSelected());

				if (rdbtnssmTomcat.isSelected()) {
					// Enable / Disable check Box
					chckbxssmNlp.setVisible(false);
					chckbxssmGlobalpy.setVisible(false);

					// Disable Label
					lblssmTomcatLocation.setVisible(true);
					lblssmTomcatLocationMsgLabel.setVisible(true);

					lblssmGlobalPyLocation.setVisible(false);
					lblssmNlpLocation.setVisible(false);

					System.out.println("Socurce Location " + lblssmSrclocationMsgLabel.getText());
					System.out.println(br.listFilesInFolder(lblssmSrclocationMsgLabel.getText()));
					System.out.println("Destination Location " + lblssmTomcatLocationMsgLabel.getText());

					List<String> tocatMoveableFiles = new ArrayList<>();
					tocatMoveableFiles.add(chckbxssmGlassbox.getText());
					tocatMoveableFiles.add(chckbxssmMetise.getText());
					tocatMoveableFiles.add(chckbxssmrootzip.getText());

					for (String warFileName : tocatMoveableFiles) {
						String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator+ "webapps";

						if (warFileName.endsWith(".war")) {
							destinationLocation += File.separator+ warFileName.substring(0, (warFileName.length() - 4)).trim();
							File warFolderCreation = new File(destinationLocation);
							if (warFolderCreation.exists())
								try {
									FileUtils.deleteDirectory(warFolderCreation);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							warFolderCreation.mkdir();

						}
						destinationLocation += File.separator + warFileName;

						String sourceLocation = lblssmSrclocationMsgLabel.getText() + File.separator + warFileName;

						try {
							br.copyFileUsingApacheCommonsIO(new File(sourceLocation), new File(destinationLocation),
									warFileName);
						} catch (IOException ie) {
							System.out.println("Unabale to Move File or Folder to destination" + ie.getMessage());
						}
					}

				} else if (rdbtnssmNlp.isSelected()) {
					// Enable / disable check Box
					chckbxssmGlassbox.setVisible(false);
					chckbxssmMetise.setVisible(false);
					chckbxssmGlobalpy.setVisible(false);
					chckbxssmrootzip.setVisible(false);
					chckbxssmAllCheck.setVisible(false);

					// Disable Label
					lblssmTomcatLocation.setVisible(false);
					lblssmGlobalPyLocation.setVisible(false);
					lblssmNlpLocation.setVisible(true);
					
					System.out.println("Socurce Location " + lblssmSrclocationMsgLabel.getText());
					System.out.println(br.listFilesInFolder(lblssmSrclocationMsgLabel.getText()));
					System.out.println("Destination Location " + lblssmTomcatLocationMsgLabel.getText());
					
					br.moveNlp(lblssmSrclocationMsgLabel.getText(), lblssmNlpMsgLabel.getText(), chckbxssmNlp.getText());
					
					

				} else if (rdbtnssmGlobalpy.isSelected()) {
					// Enable / disable check Box
					chckbxssmGlassbox.setVisible(false);
					chckbxssmMetise.setVisible(false);
					chckbxssmrootzip.setVisible(false);
					chckbxssmGlobalpy.setVisible(false);
					chckbxssmAllCheck.setVisible(false);

					// Disable Label
					lblssmGlobalPyLocation.setVisible(true);
					lblssmTomcatLocation.setVisible(false);
					lblssmNlpLocation.setVisible(false);

				}

			}
		});
		btnssmExtractFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnssmTomcat.isSelected()) {
					System.out.println("--Checking war existance in Tomcat--");
					String destinationLocation = "";
					List<String> listFiles = new ArrayList<String>();
					listFiles.add(chckbxssmGlassbox.getText());
					listFiles.add(chckbxssmMetise.getText());
					listFiles.add(chckbxssmrootzip.getText());

					String commonLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator;
					String catlinaLocation = commonLocation + File.separator + "work" + File.separator + "Catalina";
					br.deleteTomcatCatlina(catlinaLocation);
					try {
						for (String warFileName : listFiles) {
							if (warFileName.endsWith(".zip")) {
								destinationLocation = commonLocation + "webapps" + File.separator + warFileName;
								br.unzip(destinationLocation);
								br.deleteWarZipFiles(destinationLocation);
							} else {
								destinationLocation = commonLocation + "webapps" + File.separator
										+ warFileName.substring(0, (warFileName.length()) - 4).trim();
								br.extractWarFiles(warFileName, destinationLocation);
							}
						}
					} catch (Exception e2) {

					}
				} else if (rdbtnssmNlp.isSelected()) {									
					br.unZipNlp(lblssmNlpMsgLabel.getText(), chckbxssmNlp.getText());
				}else if (rdbtnssmGlobalpy.isSelected()) {
					
				}
				

			}
		});

		rdbtnssmTomcat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Disable Label
				lblssmTomcatLocation.setVisible(true);

				lblssmNlpMsgLabel.setVisible(false);

				lblssmTomcatLocationMsgLabel.setVisible(true);
				lblssmNlpMsgLabel.setVisible(false);
				lblssmGlobalMsgLabel.setVisible(false);

				lblssmGlobalPyLocation.setVisible(false);
				lblssmNlpLocation.setVisible(false);

				// Visible false
				chckbxssmGlassbox.setVisible(true);
				chckbxssmMetise.setVisible(true);
				chckbxssmrootzip.setVisible(true);
				chckbxssmAllCheck.setVisible(true);
				chckbxssmNlp.setVisible(false);
				chckbxssmGlobalpy.setVisible(false);

				rdbtnssmNlp.setSelected(false);
				rdbtnssmGlobalpy.setSelected(false);
				System.out.println(rdbtnssmTomcat.getText());
				List<String> fileNames = br.listFilesInFolder(lblsdlSourceMessageLabel.getText());
				for (String fileName : fileNames) {
					if ((fileName.equalsIgnoreCase("Glassbox_Service-1.0.war")) || (fileName.contains("Glassbox"))) {
						chckbxssmGlassbox.setText(fileName);
						chckbxssmGlassbox.setSelected(true);

					}
					if ((fileName.equalsIgnoreCase("MetisServices-1.0.war")) || (fileName.contains("MetisServices"))) {
						chckbxssmMetise.setText(fileName);
						chckbxssmMetise.setSelected(true);
					}
					if ((fileName.equalsIgnoreCase("ROOT.zip")) || (fileName.contains("root"))) {
						chckbxssmrootzip.setText(fileName);
						chckbxssmrootzip.setSelected(true);
					}
				}
			}
		});

		rdbtnssmNlp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Disable Label
				lblssmTomcatLocation.setVisible(false);
				lblssmGlobalPyLocation.setVisible(false);
				lblssmNlpLocation.setVisible(true);
				lblssmTomcatLocationMsgLabel.setVisible(false);
				lblssmNlpMsgLabel.setVisible(true);
				lblssmGlobalMsgLabel.setVisible(false);

				rdbtnssmTomcat.setSelected(false);
				rdbtnssmGlobalpy.setSelected(false);

				// visable false
				chckbxssmNlp.setVisible(true);
				chckbxssmGlobalpy.setVisible(false);
				chckbxssmGlassbox.setVisible(false);
				chckbxssmMetise.setVisible(false);
				chckbxssmrootzip.setVisible(false);
				chckbxssmAllCheck.setVisible(false);

				System.out.println(rdbtnssmNlp.getText());
				List<String> fileNames = br.listFilesInFolder(lblsdlSourceMessageLabel.getText());
				for (String fileName : fileNames) {
					if ((fileName.equalsIgnoreCase("Nlp")) || (fileName.contains("Nlp"))) {
						chckbxssmNlp.setText(fileName);
						chckbxssmNlp.setSelected(true);
					}
				}
			}
		});

		rdbtnssmGlobalpy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Disable Label
				lblssmGlobalPyLocation.setVisible(true);
				lblssmTomcatLocation.setVisible(false);
				lblssmNlpLocation.setVisible(false);

				lblssmTomcatLocationMsgLabel.setVisible(false);
				lblssmNlpMsgLabel.setVisible(false);
				lblssmGlobalMsgLabel.setVisible(true);

				rdbtnssmTomcat.setSelected(false);
				rdbtnssmNlp.setSelected(false);

				// visable false
				chckbxssmNlp.setVisible(false);
				chckbxssmGlobalpy.setVisible(true);
				chckbxssmGlassbox.setVisible(false);
				chckbxssmMetise.setVisible(false);
				chckbxssmrootzip.setVisible(false);
				chckbxssmAllCheck.setVisible(false);
				System.out.println(rdbtnssmGlobalpy.getText());

				List<String> fileNames = br.listFilesInFolder(lblsdlSourceMessageLabel.getText());
				for (String fileName : fileNames) {
					if ((fileName.equalsIgnoreCase("global")) || (fileName.contains("global"))) {
						chckbxssmGlobalpy.setText(fileName);
						chckbxssmGlobalpy.setSelected(true);
					}
				}
			}
		});

	}

}
