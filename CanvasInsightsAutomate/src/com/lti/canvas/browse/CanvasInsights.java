package com.lti.canvas.browse;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import javax.swing.JTabbedPane;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	List<String> sourceLocationsFiles = new ArrayList<String>();
	List<String> anacondaLocationsFiles = new ArrayList<String>();
	private JTextField textFieldwcdbPropClass;
	private JTextField textFieldwcdbPropUrl;
	private JTextField textFieldwcdbPropUser;
	private JTextField textFieldwcdbPropPass;
	private JTextField textFieldwcdbProphbm;
	private JTextField textFieldwcdbPropdialect;
	private JTextField textFieldwcdbPropSql;
	private JTextField textFieldwcdbPropCatalog;
	private JTextField textFieldwcdbPropMProt;
	private JTextField textFieldwcdbPropMdbName;
	private JTextField textFieldwcdbPropMPassword;
	private JTextField textFieldwcdbPropMHost;
	private JTextField textFieldwcdbPropMdbUsername;
	private JTextField textFieldwcdbPropAccSolAdv;
	private JTextField textFieldwcdbPropAccCloud;
	private JTextField textFieldwcdbPropAccStopwords;
	private JTextField textFieldwcdbPropDownPath;
	private JTextField textFieldwcMetiseDriverClass;
	private JTextField textFieldwcMetiseUrl;
	private JTextField textFieldwcMetiseUser;
	private JTextField textFieldwcMetisePassword;
	private JTextField textFieldwcMetisehibauto;
	private JTextField textFieldwcMetisehibdialet;
	private JTextField textFieldwcMetiseSql;
	private JTextField textFieldwcMetiseCatalog;
	private JTextField textFieldwcMetisedbMPort;
	private JTextField textFieldwcMetisedbMdbName;
	private JTextField textFieldwcMetisedbMPassword;
	private JTextField textFieldwcMetisedbMdbhost;
	private JTextField textFieldwcMetisedbMusername;
	private JTextField textFieldwcRootBaseURL;
	private JTextField textFieldwcRootBaseGlassboxURL;
	private JTextField textFieldwcRootBaseUIPath;
	private JTextField textFieldwcRootRasaUrl;
	private JTextField textFieldwcRootoktaIssuer;
	private JTextField textFieldwcRootDefaultSSOLogin;
	private JTextField textFieldwcRootStapleAppURL;
	private JTextField textFieldwcRootoktaClientId;
	private JTextField textFieldwcRootazureAdTenantId;
	private JTextField textFieldwcRootpythonUrl;
	private JTextField textFieldwcRootazureAdClientId;
	private JTextField textFieldwcRootdefaultOktaLogin;
	private JTextField textFieldwcRootLoginTimeout;
	private JTextField textFieldwcRootloginTimeoutWarning;
	private JTextField textFieldwcGlassboxResPropAssetsPath;
	private JTextField textFieldwcGlassboxResPropsvnmainPath;
	private JTextField textFieldwcGlassboxResPropmailFilePath;
	private JTextField textFieldwcGlassboxResPropTempFileDir;
	private JTextField textFieldwcGlassboxResPropfiletypesIgnore;
	private JTextField textFieldwcGlassboxResPropDefectGlassUrl;
	private JTextField textFieldwcGlassboxResPropShareUploadPath;
	private JTextField lblwcGlassboxResPropValueSharepointDownPath;
	private JTextField textFieldwcGlassboxResPropfiletypesIgnoreJava;
	private JTextField textFieldwcGlassboxResPropDirBase;
	private JTextField lblwcMetiseResPropValueAssetsPath;
	private JTextField lblwcMetiseResPropValueTempFileDir;
	private JTextField lblwcMetiseResPropValaueGlassBoxURL;
	private JTextField lblwcMetiseResPropmailValueFilePath;
	private JTextField lblwcMetiseResPropValueFileTypesIgnore;
	private JTextField lblwcMetiseResPropValueSharepointUploadPath;
	private JTextField lblwcMetiseResPropValueSharepointDownload;
	private JTextField lblwcMetiseResPropValueFileTypesIgnoreJavaParsing;
	private JTextField lblwcMetiseResPropValueTempdirBase;
	private JTextField lblwcMetiseResPropValueLogFileName;
	private JTextField lblwcGlassboxResPropValueDownloadPath;
	private JTextField lblMetiseValueSvndirmainpath;
	private JTextField lblwcMetiseResPropValueLuceneFolderPath;
	private JTextField lblwcMetiseResPropValueCastNetFilter;
	private JTextField lblwcMetiseResPropValueCastNetHtmlFilter;
	private JTextField lblwcMetiseResPropValueCastNetJavaFilter;
	private JTextField lblwcMetiseResPropValueCastUIFilter;
	private JTextField textFieldwcGlassboxResPropValueProxyHost;

	private void initialize() {

		sourceDestinationLocation = new JFrame();
		sourceDestinationLocation.setBounds(200, 200, 751, 490);
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

		JCheckBox chckbxssmAllCheck = new JCheckBox("All");
		JCheckBox chckbxssmGlassbox = new JCheckBox("");
		JCheckBox chckbxssmMetise = new JCheckBox("");
		JCheckBox chckbxssmrootzip = new JCheckBox("");
		JSeparator ssmseparatordeploy = new JSeparator();

		JLabel lblssmSrcLocation = new JLabel("Source Location");
		JLabel lblssmTomcatLocation = new JLabel("Tomcat Location");
		JLabel lblssmFilelists = new JLabel("File List's");
		JButton btnssmMoveFiles = new JButton("Move Files");

		JCheckBox chckbxssmNlp = new JCheckBox("");
		JCheckBox chckbxssmGlobalpy = new JCheckBox("");
		JLabel lblssmNlpLocation = new JLabel("Nlp Location");
		JLabel lblssmGlobalPyLocation = new JLabel("Global_py Location");
		JLabel lblssmNlpMsgLabel = new JLabel("");
		JLabel lblssmGlobalMsgLabel = new JLabel("");
		JButton btnssmExtractFiles = new JButton("Extract");
		JButton btnssmNext = new JButton("Next");
		JButton btnssmBack = new JButton("Back");

		// War Configuration Page
		JPanel warConfigrationGlassBoxDataBase = new JPanel();
		JLabel lblwarFileConfigration = new JLabel("Configration");
		JRadioButton wcrdbtnGlassBox = new JRadioButton("Glass Box");
		JRadioButton wcrdbtnMetise = new JRadioButton("Metise");
		JRadioButton wcrdbtnrootui = new JRadioButton("ROOT");
		JSeparator wcWarFileseparator = new JSeparator();
		JLabel lblwcdbPropDriverClass = new JLabel("jdbc.driverClassName");
		JLabel lblwcdbPropUrl = new JLabel("jdbc.url");
		JLabel lblwcdbPropUser = new JLabel("jdbc.user");
		JLabel lblwcdbPropPass = new JLabel("jdbc.pass");
		JSeparator wcdbPropSeprator = new JSeparator();
		JLabel lblwcdbPropHibhbm = new JLabel("hibernate.hbm2ddl.auto");
		JLabel lblwcdbPropHibdialect = new JLabel("hibernate.dialect");
		JLabel lblwcdbPropHibSql = new JLabel("hibernate.show_sql");
		JLabel lblwcdbPropHibCatalog = new JLabel("hibernate.default.catalog");
		JSeparator wcdbPropSepratorHibernate = new JSeparator();
		JLabel lblwcdbPropMProp = new JLabel("mongo.port");
		JLabel lblwcdbPropMName = new JLabel("mongo.dbName");
		JLabel lblwcdbPropMPass = new JLabel("mongo.password");
		JLabel lblwcdbPropMHost = new JLabel("mongo.host");
		JLabel lblwcdbPropMUserName = new JLabel("mongo.username");
		JSeparator wcdbPropSepratorMongo = new JSeparator();
		JLabel lblwcdbPropSolAdvisor = new JLabel("accuracySolAdvisor");
		JLabel lblwcdbPropAccuracyCloud = new JLabel("accuracyCloud");
		JLabel lblwcdbPropStopwords = new JLabel("accuracyStopwords");
		JLabel lblwcdbPropDownPath = new JLabel("download.path");
		JButton btnwcdbPropGlassboxUpdateProperty = new JButton("Update Property");
		JButton btnwcMetisedbPropMetiseUpdateProperty = new JButton("Update Property");

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

		layeredPane.setBounds(20, 12, 705, 428);
		sourceDestinationLocation.getContentPane().add(layeredPane);
		CardLayout layout = new CardLayout();
		layeredPane.setLayout(layout);
		layeredPane.add(srcDestPanel, "sourceDestinationPanel");
		srcDestPanel.setLayout(null);
		lblsdlSourceLocation.setToolTipText("Soucre Location");
		lblsdlSourceLocation.setBounds(77, 66, 132, 15);
		srcDestPanel.add(lblsdlSourceLocation);
		lblsdlDestinationLocation.setToolTipText("Destination Location");
		lblsdlDestinationLocation.setBounds(77, 220, 132, 15);
		srcDestPanel.add(lblsdlDestinationLocation);
		btnsdlCancel.setToolTipText("Cancel");
		btnsdlCancel.setBounds(421, 294, 117, 25);
		srcDestPanel.add(btnsdlCancel);

		lblsdlSourceMessageLabel.setBounds(232, 66, 306, 15);
		srcDestPanel.add(lblsdlSourceMessageLabel);

		btnsdlSrcBrowse.setToolTipText("SourceBrowseLocation");
		btnsdlSrcBrowse.setBounds(539, 61, 94, 25);
		srcDestPanel.add(btnsdlSrcBrowse);

		lblsdlDestinationMessageLabel.setBounds(232, 220, 303, 15);
		srcDestPanel.add(lblsdlDestinationMessageLabel);

		btnsdlDestinationBrowse.setToolTipText("DestinationBrowseLocation");
		btnsdlDestinationBrowse.setBounds(539, 215, 94, 25);
		srcDestPanel.add(btnsdlDestinationBrowse);

		btnsdlNextButton.setToolTipText("Next");
		btnsdlNextButton.setBounds(233, 294, 117, 25);
		srcDestPanel.add(btnsdlNextButton);

		lblsdlAnacondaLocation.setBounds(77, 119, 132, 15);
		srcDestPanel.add(lblsdlAnacondaLocation);

		lblsdlAnacondaMessage.setBounds(232, 119, 297, 15);
		srcDestPanel.add(lblsdlAnacondaMessage);

		btnsdlBrowse.setBounds(539, 114, 94, 25);
		srcDestPanel.add(btnsdlBrowse);

		lblsdlTomcatLabel.setBounds(77, 174, 132, 14);
		srcDestPanel.add(lblsdlTomcatLabel);

		lblsdlTomcatLocationMessage.setBounds(228, 174, 297, 14);
		srcDestPanel.add(lblsdlTomcatLocationMessage);

		btnsdlTomcatButton.setBounds(539, 170, 94, 23);
		srcDestPanel.add(btnsdlTomcatButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(77, 281, 549, 2);
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
		lblssmSrcLocation.setBounds(30, 81, 102, 14);
		fileFolderMovementPanel.add(lblssmSrcLocation);
		lblssmTomcatLocation.setBounds(30, 116, 100, 14);
		fileFolderMovementPanel.add(lblssmTomcatLocation);
		lblssmSrclocationMsgLabel.setBounds(142, 81, 355, 14);
		fileFolderMovementPanel.add(lblssmSrclocationMsgLabel);
		lblssmTomcatLocationMsgLabel.setBounds(140, 116, 355, 14);
		fileFolderMovementPanel.add(lblssmTomcatLocationMsgLabel);
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
		btnssmMoveFiles.setBounds(209, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmMoveFiles);

		chckbxssmNlp.setBounds(129, 187, 109, 23);
		fileFolderMovementPanel.add(chckbxssmNlp);
		chckbxssmGlobalpy.setBounds(110, 187, 248, 23);
		fileFolderMovementPanel.add(chckbxssmGlobalpy);
		lblssmNlpLocation.setBounds(30, 116, 125, 14);
		fileFolderMovementPanel.add(lblssmNlpLocation);
		lblssmGlobalPyLocation.setBounds(30, 116, 141, 14);
		fileFolderMovementPanel.add(lblssmGlobalPyLocation);
		lblssmNlpMsgLabel.setBounds(152, 116, 364, 14);
		fileFolderMovementPanel.add(lblssmNlpMsgLabel);
		lblssmGlobalMsgLabel.setBounds(152, 116, 397, 14);
		fileFolderMovementPanel.add(lblssmGlobalMsgLabel);
		btnssmExtractFiles.setBounds(322, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmExtractFiles);
		btnssmNext.setBounds(433, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmNext);
		btnssmBack.setBounds(100, 277, 89, 23);
		fileFolderMovementPanel.add(btnssmBack);
		warConfigrationGlassBoxDataBase.setBounds(100, 277, 89, 23);
		layeredPane.add(warConfigrationGlassBoxDataBase, "name_47612028883500");
		warConfigrationGlassBoxDataBase.setLayout(null);
		lblwarFileConfigration.setBounds(23, 11, 112, 14);
		warConfigrationGlassBoxDataBase.add(lblwarFileConfigration);
		wcrdbtnGlassBox.setBounds(33, 32, 109, 23);
		warConfigrationGlassBoxDataBase.add(wcrdbtnGlassBox);
		wcrdbtnMetise.setBounds(295, 32, 109, 23);
		warConfigrationGlassBoxDataBase.add(wcrdbtnMetise);
		wcrdbtnrootui.setBounds(567, 32, 109, 23);
		warConfigrationGlassBoxDataBase.add(wcrdbtnrootui);
		wcWarFileseparator.setBounds(23, 104, 669, 2);
		warConfigrationGlassBoxDataBase.add(wcWarFileseparator);
		lblwcdbPropDriverClass.setBounds(23, 126, 133, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropDriverClass);
		lblwcdbPropUrl.setBounds(23, 151, 46, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropUrl);
		lblwcdbPropUser.setBounds(404, 126, 46, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropUser);
		lblwcdbPropPass.setBounds(404, 151, 46, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropPass);
		wcdbPropSeprator.setBounds(23, 179, 643, 2);
		warConfigrationGlassBoxDataBase.add(wcdbPropSeprator);
		textFieldwcdbPropClass = new JTextField();
		textFieldwcdbPropClass.setBounds(138, 123, 221, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropClass);
		textFieldwcdbPropClass.setColumns(10);

		textFieldwcdbPropUrl = new JTextField();
		textFieldwcdbPropUrl.setBounds(138, 148, 221, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropUrl);
		textFieldwcdbPropUrl.setColumns(10);

		textFieldwcdbPropUser = new JTextField();
		textFieldwcdbPropUser.setBounds(473, 123, 193, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropUser);
		textFieldwcdbPropUser.setColumns(10);

		textFieldwcdbPropPass = new JTextField();
		textFieldwcdbPropPass.setBounds(473, 148, 193, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropPass);
		textFieldwcdbPropPass.setColumns(10);

		lblwcdbPropHibhbm.setBounds(347, 192, 124, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropHibhbm);
		lblwcdbPropHibdialect.setBounds(33, 220, 81, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropHibdialect);
		lblwcdbPropHibSql.setBounds(23, 192, 103, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropHibSql);
		lblwcdbPropHibCatalog.setBounds(339, 217, 124, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropHibCatalog);
		wcdbPropSepratorHibernate.setBounds(23, 253, 643, 2);
		warConfigrationGlassBoxDataBase.add(wcdbPropSepratorHibernate);
		textFieldwcdbProphbm = new JTextField();
		textFieldwcdbProphbm.setBounds(473, 189, 193, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbProphbm);
		textFieldwcdbProphbm.setColumns(10);
		textFieldwcdbPropdialect = new JTextField();
		textFieldwcdbPropdialect.setBounds(138, 217, 191, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropdialect);
		textFieldwcdbPropdialect.setColumns(10);
		textFieldwcdbPropSql = new JTextField();
		textFieldwcdbPropSql.setBounds(138, 192, 193, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropSql);
		textFieldwcdbPropSql.setColumns(10);
		textFieldwcdbPropCatalog = new JTextField();
		textFieldwcdbPropCatalog.setBounds(473, 214, 193, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropCatalog);
		textFieldwcdbPropCatalog.setColumns(10);
		lblwcdbPropMProp.setBounds(33, 266, 61, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropMProp);
		lblwcdbPropMName.setBounds(266, 266, 81, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropMName);
		lblwcdbPropMPass.setBounds(35, 294, 91, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropMPass);
		lblwcdbPropMHost.setBounds(492, 266, 61, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropMHost);
		lblwcdbPropMUserName.setBounds(266, 291, 91, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropMUserName);
		textFieldwcdbPropMProt = new JTextField();
		textFieldwcdbPropMProt.setBounds(138, 263, 118, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropMProt);
		textFieldwcdbPropMProt.setColumns(10);
		textFieldwcdbPropMdbName = new JTextField();
		textFieldwcdbPropMdbName.setBounds(357, 266, 103, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropMdbName);
		textFieldwcdbPropMdbName.setColumns(10);
		textFieldwcdbPropMPassword = new JTextField();
		textFieldwcdbPropMPassword.setBounds(138, 291, 120, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropMPassword);
		textFieldwcdbPropMPassword.setColumns(10);
		textFieldwcdbPropMHost = new JTextField();
		textFieldwcdbPropMHost.setBounds(580, 266, 86, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropMHost);
		textFieldwcdbPropMHost.setColumns(10);
		textFieldwcdbPropMdbUsername = new JTextField();
		textFieldwcdbPropMdbUsername.setColumns(10);
		textFieldwcdbPropMdbUsername.setBounds(355, 291, 103, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropMdbUsername);
		wcdbPropSepratorMongo.setBounds(33, 319, 643, 2);
		warConfigrationGlassBoxDataBase.add(wcdbPropSepratorMongo);
		lblwcdbPropSolAdvisor.setBounds(33, 332, 102, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropSolAdvisor);
		lblwcdbPropAccuracyCloud.setBounds(473, 332, 91, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropAccuracyCloud);
		lblwcdbPropStopwords.setBounds(251, 332, 109, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropStopwords);
		lblwcdbPropDownPath.setBounds(28, 360, 114, 14);
		warConfigrationGlassBoxDataBase.add(lblwcdbPropDownPath);
		textFieldwcdbPropAccSolAdv = new JTextField();
		textFieldwcdbPropAccSolAdv.setBounds(138, 329, 86, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropAccSolAdv);
		textFieldwcdbPropAccSolAdv.setColumns(10);
		textFieldwcdbPropAccCloud = new JTextField();
		textFieldwcdbPropAccCloud.setBounds(580, 329, 86, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropAccCloud);
		textFieldwcdbPropAccCloud.setColumns(10);
		textFieldwcdbPropAccStopwords = new JTextField();
		textFieldwcdbPropAccStopwords.setBounds(357, 329, 86, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropAccStopwords);
		textFieldwcdbPropAccStopwords.setColumns(10);
		textFieldwcdbPropDownPath = new JTextField();
		textFieldwcdbPropDownPath.setBounds(138, 357, 415, 20);
		warConfigrationGlassBoxDataBase.add(textFieldwcdbPropDownPath);
		textFieldwcdbPropDownPath.setColumns(10);
		btnwcdbPropGlassboxUpdateProperty.setBounds(375, 394, 124, 23);
		warConfigrationGlassBoxDataBase.add(btnwcdbPropGlassboxUpdateProperty);

		JButton btnwcdbPropGlassboxPrev = new JButton("Prev");

		btnwcdbPropGlassboxPrev.setBounds(229, 394, 89, 23);
		warConfigrationGlassBoxDataBase.add(btnwcdbPropGlassboxPrev);

		JRadioButton radiowarConfigrationGlassBoxDataBaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationGlassBoxDataBaseProperties.setBounds(33, 69, 147, 23);
		warConfigrationGlassBoxDataBase.add(radiowarConfigrationGlassBoxDataBaseProperties);

		JRadioButton radiowarConfigrationGlassBoxResource = new JRadioButton("Resource");
		radiowarConfigrationGlassBoxResource.setBounds(186, 69, 109, 23);
		warConfigrationGlassBoxDataBase.add(radiowarConfigrationGlassBoxResource);

		JRadioButton radiowarConfigrationMetiseDatabaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationMetiseDatabaseProperties.setBounds(305, 69, 147, 23);
		warConfigrationGlassBoxDataBase.add(radiowarConfigrationMetiseDatabaseProperties);

		JRadioButton radiowarConfigrationMetiseResourse = new JRadioButton("Resource");
		radiowarConfigrationMetiseResourse.setBounds(458, 69, 109, 23);
		warConfigrationGlassBoxDataBase.add(radiowarConfigrationMetiseResourse);

		JPanel warConfigrationMetiseDataBase = new JPanel();
		warConfigrationMetiseDataBase.setLayout(null);
		layeredPane.add(warConfigrationMetiseDataBase, "name_34170195515300");

		JLabel lblwarMetiseFileConfigration = new JLabel("Configration");
		lblwarMetiseFileConfigration.setBounds(23, 11, 112, 14);
		warConfigrationMetiseDataBase.add(lblwarMetiseFileConfigration);

		JRadioButton wcrdbtnwcMetiseGlassBox = new JRadioButton("Glass Box");
		wcrdbtnwcMetiseGlassBox.setBounds(33, 32, 109, 23);
		warConfigrationMetiseDataBase.add(wcrdbtnwcMetiseGlassBox);

		JRadioButton wcrdbtnwcMetiseMetise = new JRadioButton("Metise");
		wcrdbtnwcMetiseMetise.setBounds(295, 32, 109, 23);
		warConfigrationMetiseDataBase.add(wcrdbtnwcMetiseMetise);

		JRadioButton wcrdbtnwcMetiserootui = new JRadioButton("ROOT");
		wcrdbtnwcMetiserootui.setBounds(567, 32, 109, 23);
		warConfigrationMetiseDataBase.add(wcrdbtnwcMetiserootui);

		JSeparator wcMetiseWarFileseparator = new JSeparator();
		wcMetiseWarFileseparator.setBounds(23, 104, 669, 2);
		warConfigrationMetiseDataBase.add(wcMetiseWarFileseparator);

		JLabel lblwcMetisedbPropDriverClass = new JLabel("jdbc.driverClassName");
		lblwcMetisedbPropDriverClass.setBounds(23, 126, 133, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropDriverClass);

		JLabel lblwcMetisedbPropUrl = new JLabel("jdbc.url");
		lblwcMetisedbPropUrl.setBounds(23, 154, 46, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropUrl);

		JLabel lblwcMetisedbPropUser = new JLabel("jdbc.user");
		lblwcMetisedbPropUser.setBounds(404, 126, 46, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropUser);

		JLabel lblwcMetisedbPropPass = new JLabel("jdbc.pass");
		lblwcMetisedbPropPass.setBounds(404, 154, 46, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropPass);

		JSeparator wcMetisedbPropSeprator = new JSeparator();
		wcMetisedbPropSeprator.setBounds(23, 189, 643, 2);
		warConfigrationMetiseDataBase.add(wcMetisedbPropSeprator);

		textFieldwcMetiseDriverClass = new JTextField();
		textFieldwcMetiseDriverClass.setColumns(10);
		textFieldwcMetiseDriverClass.setBounds(138, 123, 221, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetiseDriverClass);

		textFieldwcMetiseUrl = new JTextField();
		textFieldwcMetiseUrl.setColumns(10);
		textFieldwcMetiseUrl.setBounds(138, 151, 221, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetiseUrl);

		textFieldwcMetiseUser = new JTextField();
		textFieldwcMetiseUser.setColumns(10);
		textFieldwcMetiseUser.setBounds(473, 123, 193, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetiseUser);

		textFieldwcMetisePassword = new JTextField();
		textFieldwcMetisePassword.setColumns(10);
		textFieldwcMetisePassword.setBounds(473, 151, 193, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisePassword);

		JLabel lblwcMetisedbPropHibhbm = new JLabel("hibernate.hbm2ddl.auto");
		lblwcMetisedbPropHibhbm.setBounds(347, 213, 124, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropHibhbm);

		JLabel lblwcMetisedbPropHibdialect = new JLabel("hibernate.dialect");
		lblwcMetisedbPropHibdialect.setBounds(23, 244, 81, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropHibdialect);

		JLabel lblwcMetisedbPropHibSql = new JLabel("hibernate.show_sql");
		lblwcMetisedbPropHibSql.setBounds(23, 213, 103, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropHibSql);

		JLabel lblwcMetisedbPropHibCatalog = new JLabel("hibernate.default.catalog");
		lblwcMetisedbPropHibCatalog.setBounds(339, 244, 124, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropHibCatalog);

		JSeparator wcMetisedbPropSepratorHibernate = new JSeparator();
		wcMetisedbPropSepratorHibernate.setBounds(23, 275, 643, 2);
		warConfigrationMetiseDataBase.add(wcMetisedbPropSepratorHibernate);

		textFieldwcMetisehibauto = new JTextField();
		textFieldwcMetisehibauto.setColumns(10);
		textFieldwcMetisehibauto.setBounds(473, 210, 193, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisehibauto);

		textFieldwcMetisehibdialet = new JTextField();
		textFieldwcMetisehibdialet.setColumns(10);
		textFieldwcMetisehibdialet.setBounds(138, 244, 191, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisehibdialet);

		textFieldwcMetiseSql = new JTextField();
		textFieldwcMetiseSql.setColumns(10);
		textFieldwcMetiseSql.setBounds(138, 213, 193, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetiseSql);

		textFieldwcMetiseCatalog = new JTextField();
		textFieldwcMetiseCatalog.setColumns(10);
		textFieldwcMetiseCatalog.setBounds(473, 241, 193, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetiseCatalog);

		JLabel lblwcMetisedbPropMProp = new JLabel("mongo.port");
		lblwcMetisedbPropMProp.setBounds(23, 288, 61, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropMProp);

		JLabel lblwcMetisedbPropMName = new JLabel("mongo.dbName");
		lblwcMetisedbPropMName.setBounds(276, 288, 81, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropMName);

		JLabel lblwcMetisedbPropMPass = new JLabel("mongo.password");
		lblwcMetisedbPropMPass.setBounds(268, 331, 91, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropMPass);

		JLabel lblwcMetisedbPropMHost = new JLabel("mongo.host");
		lblwcMetisedbPropMHost.setBounds(480, 288, 61, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropMHost);

		JLabel lblwcMetisedbPropMUserName = new JLabel("mongo.username");
		lblwcMetisedbPropMUserName.setBounds(23, 331, 91, 14);
		warConfigrationMetiseDataBase.add(lblwcMetisedbPropMUserName);

		textFieldwcMetisedbMPort = new JTextField();
		textFieldwcMetisedbMPort.setColumns(10);
		textFieldwcMetisedbMPort.setBounds(138, 285, 103, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisedbMPort);

		textFieldwcMetisedbMdbName = new JTextField();
		textFieldwcMetisedbMdbName.setColumns(10);
		textFieldwcMetisedbMdbName.setBounds(367, 288, 103, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisedbMdbName);

		textFieldwcMetisedbMPassword = new JTextField();
		textFieldwcMetisedbMPassword.setColumns(10);
		textFieldwcMetisedbMPassword.setBounds(369, 331, 120, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisedbMPassword);

		textFieldwcMetisedbMdbhost = new JTextField();
		textFieldwcMetisedbMdbhost.setColumns(10);
		textFieldwcMetisedbMdbhost.setBounds(561, 285, 86, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisedbMdbhost);

		textFieldwcMetisedbMusername = new JTextField();
		textFieldwcMetisedbMusername.setColumns(10);
		textFieldwcMetisedbMusername.setBounds(138, 328, 103, 20);
		warConfigrationMetiseDataBase.add(textFieldwcMetisedbMusername);

		JSeparator wcMetisedbPropSepratorMongo = new JSeparator();
		wcMetisedbPropSepratorMongo.setBounds(33, 362, 643, 2);
		warConfigrationMetiseDataBase.add(wcMetisedbPropSepratorMongo);

		btnwcMetisedbPropMetiseUpdateProperty.setBounds(388, 394, 124, 23);
		warConfigrationMetiseDataBase.add(btnwcMetisedbPropMetiseUpdateProperty);
		JButton btnwcMetisedbPropMetisePrev = new JButton("Prev");
		btnwcMetisedbPropMetisePrev.setBounds(240, 394, 89, 23);
		warConfigrationMetiseDataBase.add(btnwcMetisedbPropMetisePrev);

		JRadioButton radiowarConfigrationMetiseGlassBoxDataBaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationMetiseGlassBoxDataBaseProperties.setBounds(32, 58, 147, 23);
		warConfigrationMetiseDataBase.add(radiowarConfigrationMetiseGlassBoxDataBaseProperties);

		JRadioButton radiowarConfigrationMetiseGlassBoxResource = new JRadioButton("Resource");
		radiowarConfigrationMetiseGlassBoxResource.setBounds(185, 58, 109, 23);
		warConfigrationMetiseDataBase.add(radiowarConfigrationMetiseGlassBoxResource);

		JRadioButton radiowarConfigrationMetiseMetiseDatabaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationMetiseMetiseDatabaseProperties.setBounds(304, 58, 147, 23);
		warConfigrationMetiseDataBase.add(radiowarConfigrationMetiseMetiseDatabaseProperties);

		JRadioButton radiowarConfigrationMetiseMetiseResource = new JRadioButton("Resource");
		radiowarConfigrationMetiseMetiseResource.setBounds(457, 58, 109, 23);
		warConfigrationMetiseDataBase.add(radiowarConfigrationMetiseMetiseResource);

		JPanel warConfigrationRootUI = new JPanel();
		warConfigrationRootUI.setLayout(null);
		layeredPane.add(warConfigrationRootUI, "name_36796065474600");

		JLabel lblwarrootFileConfigration = new JLabel("Configration");
		lblwarrootFileConfigration.setBounds(23, 11, 72, 14);
		warConfigrationRootUI.add(lblwarrootFileConfigration);

		JRadioButton wcrdbtnwcRootGlassBox = new JRadioButton("Glass Box");
		wcrdbtnwcRootGlassBox.setBounds(33, 32, 109, 23);
		warConfigrationRootUI.add(wcrdbtnwcRootGlassBox);

		JRadioButton wcrdbtnwcRootMetise = new JRadioButton("Metise");
		wcrdbtnwcRootMetise.setBounds(295, 32, 109, 23);
		warConfigrationRootUI.add(wcrdbtnwcRootMetise);

		JRadioButton wcrdbtnwcRootrootui = new JRadioButton("ROOT");
		wcrdbtnwcRootrootui.setSelected(true);
		wcrdbtnwcRootrootui.setBounds(567, 32, 109, 23);
		warConfigrationRootUI.add(wcrdbtnwcRootrootui);

		JSeparator wcRootWarFileseparator = new JSeparator();
		wcRootWarFileseparator.setBounds(23, 104, 669, 2);
		warConfigrationRootUI.add(wcRootWarFileseparator);

		JLabel lblwcRootdbPropBaseUrl = new JLabel("baseUrl");
		lblwcRootdbPropBaseUrl.setBounds(23, 120, 60, 14);
		warConfigrationRootUI.add(lblwcRootdbPropBaseUrl);

		JLabel lblwcRootdbPropGlassboxUrl = new JLabel("glassboxUrl");
		lblwcRootdbPropGlassboxUrl.setBounds(23, 145, 60, 14);
		warConfigrationRootUI.add(lblwcRootdbPropGlassboxUrl);

		JLabel lblwcRootdbPropBaseUI = new JLabel("baseUIPath");
		lblwcRootdbPropBaseUI.setBounds(360, 117, 72, 14);
		warConfigrationRootUI.add(lblwcRootdbPropBaseUI);

		JLabel lblwcRootdbProprasaUrl = new JLabel("rasaUrl");
		lblwcRootdbProprasaUrl.setBounds(358, 142, 46, 14);
		warConfigrationRootUI.add(lblwcRootdbProprasaUrl);

		textFieldwcRootBaseURL = new JTextField();
		textFieldwcRootBaseURL.setColumns(10);
		textFieldwcRootBaseURL.setBounds(113, 117, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootBaseURL);

		textFieldwcRootBaseGlassboxURL = new JTextField();
		textFieldwcRootBaseGlassboxURL.setColumns(10);
		textFieldwcRootBaseGlassboxURL.setBounds(113, 142, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootBaseGlassboxURL);

		textFieldwcRootBaseUIPath = new JTextField();
		textFieldwcRootBaseUIPath.setColumns(10);
		textFieldwcRootBaseUIPath.setBounds(473, 117, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootBaseUIPath);

		textFieldwcRootRasaUrl = new JTextField();
		textFieldwcRootRasaUrl.setColumns(10);
		textFieldwcRootRasaUrl.setBounds(473, 142, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootRasaUrl);

		JLabel lblwcRootdbPropoktaIssuer = new JLabel("oktaIssuer");
		lblwcRootdbPropoktaIssuer.setBounds(23, 173, 60, 14);
		warConfigrationRootUI.add(lblwcRootdbPropoktaIssuer);

		JLabel lblwcRootdbPropdefaultSSOLogin = new JLabel("defaultSSOLogin");
		lblwcRootdbPropdefaultSSOLogin.setBounds(360, 207, 81, 14);
		warConfigrationRootUI.add(lblwcRootdbPropdefaultSSOLogin);

		JLabel lblwcRootdbPropStapleAppUrl = new JLabel("stapleAppUrl");
		lblwcRootdbPropStapleAppUrl.setBounds(23, 232, 103, 14);
		warConfigrationRootUI.add(lblwcRootdbPropStapleAppUrl);

		JLabel lblwcRootdbPropoktaClientId = new JLabel("oktaClientId");
		lblwcRootdbPropoktaClientId.setBounds(360, 173, 81, 14);
		warConfigrationRootUI.add(lblwcRootdbPropoktaClientId);

		textFieldwcRootoktaIssuer = new JTextField();
		textFieldwcRootoktaIssuer.setColumns(10);
		textFieldwcRootoktaIssuer.setBounds(113, 173, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootoktaIssuer);

		textFieldwcRootDefaultSSOLogin = new JTextField();
		textFieldwcRootDefaultSSOLogin.setColumns(10);
		textFieldwcRootDefaultSSOLogin.setBounds(473, 204, 191, 20);
		warConfigrationRootUI.add(textFieldwcRootDefaultSSOLogin);

		textFieldwcRootStapleAppURL = new JTextField();
		textFieldwcRootStapleAppURL.setColumns(10);
		textFieldwcRootStapleAppURL.setBounds(113, 232, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootStapleAppURL);

		textFieldwcRootoktaClientId = new JTextField();
		textFieldwcRootoktaClientId.setColumns(10);
		textFieldwcRootoktaClientId.setBounds(473, 170, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootoktaClientId);

		JLabel lblwcRootdbPropazureAdTenantId = new JLabel("azureAdTenantId");
		lblwcRootdbPropazureAdTenantId.setBounds(23, 260, 93, 14);
		warConfigrationRootUI.add(lblwcRootdbPropazureAdTenantId);

		JLabel lblwcRootdbPropPythonUrl = new JLabel("pythonUrl");
		lblwcRootdbPropPythonUrl.setBounds(360, 232, 81, 14);
		warConfigrationRootUI.add(lblwcRootdbPropPythonUrl);

		JLabel lblwcRootdbPropazureAdClientId = new JLabel("azureAdClientId");
		lblwcRootdbPropazureAdClientId.setBounds(360, 260, 91, 14);
		warConfigrationRootUI.add(lblwcRootdbPropazureAdClientId);

		JLabel lblwcRootdbPropdefaultOktaLogin = new JLabel("defaultOktaLogin");
		lblwcRootdbPropdefaultOktaLogin.setBounds(23, 207, 93, 14);
		warConfigrationRootUI.add(lblwcRootdbPropdefaultOktaLogin);

		JLabel lblwcRootdbProploginTimeout = new JLabel("loginTimeout");
		lblwcRootdbProploginTimeout.setBounds(23, 293, 91, 14);
		warConfigrationRootUI.add(lblwcRootdbProploginTimeout);

		textFieldwcRootazureAdTenantId = new JTextField();
		textFieldwcRootazureAdTenantId.setColumns(10);
		textFieldwcRootazureAdTenantId.setBounds(113, 257, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootazureAdTenantId);

		textFieldwcRootpythonUrl = new JTextField();
		textFieldwcRootpythonUrl.setColumns(10);
		textFieldwcRootpythonUrl.setBounds(473, 229, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootpythonUrl);

		textFieldwcRootazureAdClientId = new JTextField();
		textFieldwcRootazureAdClientId.setColumns(10);
		textFieldwcRootazureAdClientId.setBounds(473, 260, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootazureAdClientId);

		textFieldwcRootdefaultOktaLogin = new JTextField();
		textFieldwcRootdefaultOktaLogin.setColumns(10);
		textFieldwcRootdefaultOktaLogin.setBounds(113, 204, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootdefaultOktaLogin);

		textFieldwcRootLoginTimeout = new JTextField();
		textFieldwcRootLoginTimeout.setColumns(10);
		textFieldwcRootLoginTimeout.setBounds(113, 290, 221, 20);
		warConfigrationRootUI.add(textFieldwcRootLoginTimeout);

		JLabel lblwcRootdbProploginTimeoutWarning = new JLabel("loginTimeoutWarning");
		lblwcRootdbProploginTimeoutWarning.setBounds(360, 293, 102, 14);
		warConfigrationRootUI.add(lblwcRootdbProploginTimeoutWarning);

		textFieldwcRootloginTimeoutWarning = new JTextField();
		textFieldwcRootloginTimeoutWarning.setColumns(10);
		textFieldwcRootloginTimeoutWarning.setBounds(473, 290, 193, 20);
		warConfigrationRootUI.add(textFieldwcRootloginTimeoutWarning);

		JButton btnwcMetisedbPropRootUpdateProperty = new JButton("Update Property");
		btnwcMetisedbPropRootUpdateProperty.setBounds(375, 366, 124, 23);
		warConfigrationRootUI.add(btnwcMetisedbPropRootUpdateProperty);

		JButton btnwcMetisedbPropRootPrev = new JButton("Prev");

		btnwcMetisedbPropRootPrev.setBounds(245, 366, 89, 23);
		warConfigrationRootUI.add(btnwcMetisedbPropRootPrev);

		JRadioButton radiowarConfigrationRootUIGlassBoxDatabaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationRootUIGlassBoxDatabaseProperties.setBounds(35, 70, 147, 23);
		warConfigrationRootUI.add(radiowarConfigrationRootUIGlassBoxDatabaseProperties);

		JRadioButton radiowarConfigrationRootUIGlassBoxResource = new JRadioButton("Resource");
		radiowarConfigrationRootUIGlassBoxResource.setBounds(188, 70, 109, 23);
		warConfigrationRootUI.add(radiowarConfigrationRootUIGlassBoxResource);

		JRadioButton radiowarConfigrationRootUIMetiseDataBaseProperties = new JRadioButton("Database properties");
		radiowarConfigrationRootUIMetiseDataBaseProperties.setBounds(307, 70, 147, 23);
		warConfigrationRootUI.add(radiowarConfigrationRootUIMetiseDataBaseProperties);

		JRadioButton radiowarConfigrationRootUIMetiseResource = new JRadioButton("Resource");
		radiowarConfigrationRootUIMetiseResource.setBounds(460, 70, 109, 23);
		warConfigrationRootUI.add(radiowarConfigrationRootUIMetiseResource);

		JPanel warConfigrationGlassBoxResource = new JPanel();
		warConfigrationGlassBoxResource.setLayout(null);
		layeredPane.add(warConfigrationGlassBoxResource, "name_3071233612400");

		JLabel lblwcGlassboxReswarFileConfigration = new JLabel("Configration");
		lblwcGlassboxReswarFileConfigration.setBounds(23, 11, 112, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxReswarFileConfigration);

		JRadioButton wcGlassboxResrdbtnGlassBox = new JRadioButton("Glass Box");
		wcGlassboxResrdbtnGlassBox.setBounds(23, 32, 109, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnGlassBox);

		JRadioButton wcGlassboxResrdbtnMetise = new JRadioButton("Metise");
		wcGlassboxResrdbtnMetise.setBounds(295, 32, 109, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnMetise);

		JRadioButton wcGlassboxResrdbtnrootui = new JRadioButton("ROOT");
		wcGlassboxResrdbtnrootui.setBounds(567, 32, 109, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnrootui);

		JSeparator wcGlassboxResWarFileseparator = new JSeparator();
		wcGlassboxResWarFileseparator.setBounds(23, 87, 669, 2);
		warConfigrationGlassBoxResource.add(wcGlassboxResWarFileseparator);

		JLabel lblwcGlassboxResPropEnable = new JLabel("proxy.to.enable :");
		lblwcGlassboxResPropEnable.setBounds(411, 103, 88, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropEnable);

		JLabel lblwcGlassboxResPropProxyHost = new JLabel("gitlab.proxy.host :");
		lblwcGlassboxResPropProxyHost.setBounds(421, 128, 91, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropProxyHost);

		JLabel lblwcGlassboxResPropHostName = new JLabel("proxy.host.name :");
		lblwcGlassboxResPropHostName.setBounds(23, 103, 93, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropHostName);

		JLabel lblwcGlassboxResPropHostPort = new JLabel("proxy.host.port :");
		lblwcGlassboxResPropHostPort.setBounds(274, 103, 95, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropHostPort);

		JSeparator wcdbPropSeprator_1 = new JSeparator();
		wcdbPropSeprator_1.setBounds(23, 187, 643, 2);
		warConfigrationGlassBoxResource.add(wcdbPropSeprator_1);

		JLabel lblwcGlassboxResPropPassword = new JLabel("proxy.password :");
		lblwcGlassboxResPropPassword.setBounds(274, 128, 95, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropPassword);

		JLabel lblwcGlassboxResPropNotificationExpiry = new JLabel("notifications_expiry :");
		lblwcGlassboxResPropNotificationExpiry.setBounds(541, 103, 103, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropNotificationExpiry);

		JLabel lblwcGlassboxResPropUserName = new JLabel("proxy.username :");
		lblwcGlassboxResPropUserName.setBounds(23, 128, 91, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropUserName);

		JLabel lblwcGlassboxResPropAssetsPath = new JLabel("assets.path");
		lblwcGlassboxResPropAssetsPath.setBounds(308, 253, 72, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropAssetsPath);

		textFieldwcGlassboxResPropAssetsPath = new JTextField();
		textFieldwcGlassboxResPropAssetsPath.setColumns(10);
		textFieldwcGlassboxResPropAssetsPath.setBounds(443, 250, 223, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropAssetsPath);

		JLabel lblwcGlassboxResPropFileTypesIgnore = new JLabel("file.types.ignore");
		lblwcGlassboxResPropFileTypesIgnore.setBounds(25, 316, 93, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropFileTypesIgnore);

		JLabel lblwcGlassboxResPropGlassBoxURL = new JLabel("defect.glassbox.url");
		lblwcGlassboxResPropGlassBoxURL.setBounds(23, 250, 103, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropGlassBoxURL);

		JLabel lblwcGlassboxResPropsvnDirMainPath = new JLabel("svn.dir.main.path");
		lblwcGlassboxResPropsvnDirMainPath.setBounds(25, 225, 91, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropsvnDirMainPath);

		JLabel lblwcGlassboxResPropTempFileDir = new JLabel("temp.file.dir");
		lblwcGlassboxResPropTempFileDir.setBounds(308, 200, 61, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropTempFileDir);

		JLabel lblwcGlassboxResPropSimilarityThreshold = new JLabel("similarity.threshold :");
		lblwcGlassboxResPropSimilarityThreshold.setBounds(431, 153, 103, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropSimilarityThreshold);

		textFieldwcGlassboxResPropsvnmainPath = new JTextField();
		textFieldwcGlassboxResPropsvnmainPath.setColumns(10);
		textFieldwcGlassboxResPropsvnmainPath.setBounds(118, 222, 180, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropsvnmainPath);

		textFieldwcGlassboxResPropmailFilePath = new JTextField();
		textFieldwcGlassboxResPropmailFilePath.setColumns(10);
		textFieldwcGlassboxResPropmailFilePath.setBounds(118, 197, 180, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropmailFilePath);

		textFieldwcGlassboxResPropTempFileDir = new JTextField();
		textFieldwcGlassboxResPropTempFileDir.setColumns(10);
		textFieldwcGlassboxResPropTempFileDir.setBounds(443, 197, 223, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropTempFileDir);

		JLabel lblwcGlassboxResPropFromMail = new JLabel("fromEmail :");
		lblwcGlassboxResPropFromMail.setBounds(23, 153, 61, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropFromMail);

		JLabel lblwcGlassboxResPropmailFilePath = new JLabel("mail.filePath");
		lblwcGlassboxResPropmailFilePath.setBounds(23, 200, 72, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropmailFilePath);

		JLabel lblwcGlassboxResPropEmailPassword = new JLabel("emailPassword :");
		lblwcGlassboxResPropEmailPassword.setBounds(274, 153, 81, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropEmailPassword);

		JLabel lblwcGlassboxResPropSharepointUploadPath = new JLabel("sharepoint.upload.path");
		lblwcGlassboxResPropSharepointUploadPath.setBounds(23, 281, 114, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropSharepointUploadPath);

		textFieldwcGlassboxResPropfiletypesIgnore = new JTextField();
		textFieldwcGlassboxResPropfiletypesIgnore.setColumns(10);
		textFieldwcGlassboxResPropfiletypesIgnore.setBounds(121, 313, 180, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropfiletypesIgnore);

		textFieldwcGlassboxResPropDefectGlassUrl = new JTextField();
		textFieldwcGlassboxResPropDefectGlassUrl.setColumns(10);
		textFieldwcGlassboxResPropDefectGlassUrl.setBounds(118, 250, 180, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropDefectGlassUrl);

		JButton btnwcGlassboxResPropUpdateProperty = new JButton("Update Property");
		btnwcGlassboxResPropUpdateProperty.setBounds(358, 394, 124, 23);
		warConfigrationGlassBoxResource.add(btnwcGlassboxResPropUpdateProperty);

		JButton btnwcGlassboxResPropPrev = new JButton("Prev");

		btnwcGlassboxResPropPrev.setBounds(238, 394, 89, 23);
		warConfigrationGlassBoxResource.add(btnwcGlassboxResPropPrev);

		JLabel lblwcGlassboxResPropSharepoint = new JLabel("sharepoint.download.path");
		lblwcGlassboxResPropSharepoint.setBounds(310, 281, 132, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropSharepoint);

		textFieldwcGlassboxResPropShareUploadPath = new JTextField();
		textFieldwcGlassboxResPropShareUploadPath.setBounds(147, 278, 153, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropShareUploadPath);
		textFieldwcGlassboxResPropShareUploadPath.setColumns(10);

		JLabel lblwcGlassboxResProphttpProxyHost = new JLabel("http.proxy.host");
		lblwcGlassboxResProphttpProxyHost.setBounds(23, 341, 94, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResProphttpProxyHost);

		JLabel lblwcGlassboxResPropTempdirBase = new JLabel("temp.dir.base");
		lblwcGlassboxResPropTempdirBase.setBounds(308, 225, 72, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropTempdirBase);

		lblwcGlassboxResPropValueSharepointDownPath = new JTextField();
		lblwcGlassboxResPropValueSharepointDownPath.setColumns(10);
		lblwcGlassboxResPropValueSharepointDownPath.setBounds(443, 278, 225, 20);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueSharepointDownPath);

		JLabel lblwcGlassboxResPropfiletypesjavaParsing = new JLabel("filetypes.ignore.java.parsing");
		lblwcGlassboxResPropfiletypesjavaParsing.setBounds(310, 316, 147, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropfiletypesjavaParsing);

		textFieldwcGlassboxResPropfiletypesIgnoreJava = new JTextField();
		textFieldwcGlassboxResPropfiletypesIgnoreJava.setColumns(10);
		textFieldwcGlassboxResPropfiletypesIgnoreJava.setBounds(452, 310, 216, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropfiletypesIgnoreJava);

		textFieldwcGlassboxResPropDirBase = new JTextField();
		textFieldwcGlassboxResPropDirBase.setColumns(10);
		textFieldwcGlassboxResPropDirBase.setBounds(443, 225, 223, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropDirBase);

		JRadioButton wcGlassboxResrdbtnGlassBoxDatabaseProperties = new JRadioButton("Database properties");
		wcGlassboxResrdbtnGlassBoxDatabaseProperties.setBounds(23, 58, 147, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnGlassBoxDatabaseProperties);

		JRadioButton wcGlassboxResrdbtnGlassBoxResource = new JRadioButton("Resource");
		wcGlassboxResrdbtnGlassBoxResource.setBounds(176, 58, 109, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnGlassBoxResource);

		JRadioButton wcGlassboxResrdbtnMetiseDatabaseProperties = new JRadioButton("Database properties");
		wcGlassboxResrdbtnMetiseDatabaseProperties.setBounds(295, 58, 147, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnMetiseDatabaseProperties);

		JRadioButton wcGlassboxResrdbtnMetiseResource = new JRadioButton("Resource");
		wcGlassboxResrdbtnMetiseResource.setBounds(448, 58, 109, 23);
		warConfigrationGlassBoxResource.add(wcGlassboxResrdbtnMetiseResource);

		JLabel lblwcGlassboxResPropValueHostName = new JLabel("");
		lblwcGlassboxResPropValueHostName.setToolTipText("");
		lblwcGlassboxResPropValueHostName.setBounds(118, 103, 132, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueHostName);

		JLabel lblwcGlassboxResPropValueHostPort = new JLabel("");
		lblwcGlassboxResPropValueHostPort.setBounds(369, 103, 46, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueHostPort);

		JLabel lblwcGlassboxResPropValueEnable = new JLabel("");
		lblwcGlassboxResPropValueEnable.setBounds(499, 103, 46, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueEnable);

		JLabel lblwcGlassboxResPropValueNotificationExpiry = new JLabel("");
		lblwcGlassboxResPropValueNotificationExpiry.setBounds(646, 103, 30, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueNotificationExpiry);

		JLabel lblwcGlassboxResPropValueUserName = new JLabel("");
		lblwcGlassboxResPropValueUserName.setToolTipText("");
		lblwcGlassboxResPropValueUserName.setBounds(118, 128, 132, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueUserName);

		JLabel lblwcGlassboxResPropValuePassword = new JLabel("");
		lblwcGlassboxResPropValuePassword.setBounds(365, 128, 46, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValuePassword);

		JLabel lblwcGlassboxResPropValueProxyHost = new JLabel("");
		lblwcGlassboxResPropValueProxyHost.setToolTipText("");
		lblwcGlassboxResPropValueProxyHost.setBounds(518, 128, 174, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueProxyHost);

		JLabel lblwcGlassboxResPropValueFromMail = new JLabel("");
		lblwcGlassboxResPropValueFromMail.setBounds(118, 153, 132, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueFromMail);

		JLabel lblwcGlassboxResPropValueEmailPassword = new JLabel("");
		lblwcGlassboxResPropValueEmailPassword.setBounds(358, 153, 46, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueEmailPassword);

		JLabel lblwcGlassboxResPropValueSimilarityThreshold = new JLabel("");
		lblwcGlassboxResPropValueSimilarityThreshold.setBounds(544, 153, 22, 14);
		warConfigrationGlassBoxResource.add(lblwcGlassboxResPropValueSimilarityThreshold);

		textFieldwcGlassboxResPropValueProxyHost = new JTextField();
		textFieldwcGlassboxResPropValueProxyHost.setColumns(10);
		textFieldwcGlassboxResPropValueProxyHost.setBounds(118, 342, 180, 20);
		warConfigrationGlassBoxResource.add(textFieldwcGlassboxResPropValueProxyHost);

		JPanel warConfigrationMetiseResource = new JPanel();
		warConfigrationMetiseResource.setLayout(null);
		layeredPane.add(warConfigrationMetiseResource, "name_8175006742500");

		JLabel lblwcMetiseReswarFileConfigration = new JLabel("Configration");
		lblwcMetiseReswarFileConfigration.setBounds(23, 11, 112, 14);
		warConfigrationMetiseResource.add(lblwcMetiseReswarFileConfigration);

		JRadioButton wcMetiseResrdbtnGlassBox = new JRadioButton("Glass Box");
		wcMetiseResrdbtnGlassBox.setBounds(23, 32, 109, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnGlassBox);

		JRadioButton wcMetiseResrdbtnMetise = new JRadioButton("Metise");
		wcMetiseResrdbtnMetise.setSelected(true);
		wcMetiseResrdbtnMetise.setBounds(295, 32, 109, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnMetise);

		JRadioButton wcMetiseResrdbtnrootui = new JRadioButton("ROOT");
		wcMetiseResrdbtnrootui.setBounds(567, 32, 109, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnrootui);

		JSeparator wcGlassboxResWarFileseparator_1 = new JSeparator();
		wcGlassboxResWarFileseparator_1.setBounds(23, 87, 669, 2);
		warConfigrationMetiseResource.add(wcGlassboxResWarFileseparator_1);

		JLabel lblProxytoenable = new JLabel("proxy.to.enable :");
		lblProxytoenable.setBounds(403, 103, 90, 14);
		warConfigrationMetiseResource.add(lblProxytoenable);

		JLabel lblProxyhostname = new JLabel("proxy.host.name  :");
		lblProxyhostname.setBounds(23, 103, 93, 14);
		warConfigrationMetiseResource.add(lblProxyhostname);

		JLabel lblProxyhostport = new JLabel("proxy.host.port :");
		lblProxyhostport.setBounds(263, 103, 93, 14);
		warConfigrationMetiseResource.add(lblProxyhostport);

		JLabel lblProxypassword = new JLabel("proxy.password :");
		lblProxypassword.setBounds(256, 128, 90, 14);
		warConfigrationMetiseResource.add(lblProxypassword);

		JLabel lblwcdbPropnotificationExpiry = new JLabel("notifications_expiry :");
		lblwcdbPropnotificationExpiry.setBounds(537, 103, 103, 14);
		warConfigrationMetiseResource.add(lblwcdbPropnotificationExpiry);

		JLabel lblProxyusername = new JLabel("proxy.username :");
		lblProxyusername.setBounds(23, 128, 91, 14);
		warConfigrationMetiseResource.add(lblProxyusername);

		JLabel lblwcMetiseResPropAssetsPath = new JLabel("assets.path");
		lblwcMetiseResPropAssetsPath.setBounds(228, 268, 72, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropAssetsPath);

		lblwcMetiseResPropValueAssetsPath = new JTextField();
		lblwcMetiseResPropValueAssetsPath.setColumns(10);
		lblwcMetiseResPropValueAssetsPath.setBounds(295, 265, 158, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueAssetsPath);

		JLabel lblwcMetiseResPropFileTypesIgnore = new JLabel("file.types.ignore");
		lblwcMetiseResPropFileTypesIgnore.setBounds(10, 325, 81, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropFileTypesIgnore);

		JLabel lblwcMetiseResPropGlassBoxURL = new JLabel("defect.glassbox.url");
		lblwcMetiseResPropGlassBoxURL.setBounds(191, 218, 103, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropGlassBoxURL);

		JLabel lblSvndirmainpath = new JLabel("svn.dir.main.path");
		lblSvndirmainpath.setBounds(461, 243, 93, 14);
		warConfigrationMetiseResource.add(lblSvndirmainpath);

		JLabel lblwcMetiseResPropTempFileDir = new JLabel("temp.file.dir");
		lblwcMetiseResPropTempFileDir.setBounds(23, 218, 61, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropTempFileDir);

		JLabel lblSimilaritythreshold = new JLabel("similarity.threshold :");
		lblSimilaritythreshold.setBounds(403, 153, 103, 14);
		warConfigrationMetiseResource.add(lblSimilaritythreshold);

		lblwcMetiseResPropValueTempFileDir = new JTextField();
		lblwcMetiseResPropValueTempFileDir.setColumns(10);
		lblwcMetiseResPropValueTempFileDir.setBounds(94, 215, 91, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueTempFileDir);

		lblwcMetiseResPropValaueGlassBoxURL = new JTextField();
		lblwcMetiseResPropValaueGlassBoxURL.setColumns(10);
		lblwcMetiseResPropValaueGlassBoxURL.setBounds(295, 215, 158, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValaueGlassBoxURL);

		JSeparator wcdbPropSepratorMongo_1_1 = new JSeparator();
		wcdbPropSepratorMongo_1_1.setBounds(23, 203, 643, 2);
		warConfigrationMetiseResource.add(wcdbPropSepratorMongo_1_1);

		JLabel lblFromemail = new JLabel("fromEmail :");
		lblFromemail.setBounds(23, 153, 61, 14);
		warConfigrationMetiseResource.add(lblFromemail);

		JLabel lblwcMetiseResPropmailFilePath = new JLabel("mail.filePath");
		lblwcMetiseResPropmailFilePath.setBounds(23, 243, 72, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropmailFilePath);

		JLabel lblEmailpassword = new JLabel("emailPassword :");
		lblEmailpassword.setBounds(263, 153, 81, 14);
		warConfigrationMetiseResource.add(lblEmailpassword);

		JLabel lblwcMetiseResPropSharepointUploadPath = new JLabel("sharepoint.upload.path");
		lblwcMetiseResPropSharepointUploadPath.setBounds(10, 353, 114, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropSharepointUploadPath);

		lblwcMetiseResPropmailValueFilePath = new JTextField();
		lblwcMetiseResPropmailValueFilePath.setText("              ");
		lblwcMetiseResPropmailValueFilePath.setColumns(10);
		lblwcMetiseResPropmailValueFilePath.setBounds(94, 243, 91, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropmailValueFilePath);

		lblwcMetiseResPropValueFileTypesIgnore = new JTextField();
		lblwcMetiseResPropValueFileTypesIgnore.setColumns(10);
		lblwcMetiseResPropValueFileTypesIgnore.setBounds(94, 322, 91, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueFileTypesIgnore);

		JButton btnwcGlassboxResPropUpdateProperty_1 = new JButton("Update Property");
		btnwcGlassboxResPropUpdateProperty_1.setBounds(358, 394, 124, 23);
		warConfigrationMetiseResource.add(btnwcGlassboxResPropUpdateProperty_1);

		JButton btnwcGlassboxResPropPrev_1 = new JButton("Prev");

		btnwcGlassboxResPropPrev_1.setBounds(228, 394, 89, 23);
		warConfigrationMetiseResource.add(btnwcGlassboxResPropPrev_1);

		JLabel lblwcMetiseResPropSharepoint = new JLabel("sharepoint.download.path");
		lblwcMetiseResPropSharepoint.setBounds(310, 353, 132, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropSharepoint);

		lblwcMetiseResPropValueSharepointUploadPath = new JTextField();
		lblwcMetiseResPropValueSharepointUploadPath.setColumns(10);
		lblwcMetiseResPropValueSharepointUploadPath.setBounds(134, 350, 153, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueSharepointUploadPath);

		JLabel lblHttpproxyhost = new JLabel("http.proxy.host :");
		lblHttpproxyhost.setBounds(403, 128, 90, 14);
		warConfigrationMetiseResource.add(lblHttpproxyhost);

		JLabel lblwcMetiseResPropTempdirBase = new JLabel("temp.dir.base");
		lblwcMetiseResPropTempdirBase.setBounds(482, 218, 72, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropTempdirBase);

		lblwcMetiseResPropValueSharepointDownload = new JTextField();
		lblwcMetiseResPropValueSharepointDownload.setColumns(10);
		lblwcMetiseResPropValueSharepointDownload.setBounds(452, 350, 240, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueSharepointDownload);

		JLabel lblwcMetiseResPropFileTypesIgnoreJavaParsing = new JLabel("filetypes.ignore.java.parsing");
		lblwcMetiseResPropFileTypesIgnoreJavaParsing.setBounds(191, 325, 147, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropFileTypesIgnoreJavaParsing);

		lblwcMetiseResPropValueFileTypesIgnoreJavaParsing = new JTextField();
		lblwcMetiseResPropValueFileTypesIgnoreJavaParsing.setColumns(10);
		lblwcMetiseResPropValueFileTypesIgnoreJavaParsing.setBounds(372, 322, 81, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueFileTypesIgnoreJavaParsing);

		lblwcMetiseResPropValueTempdirBase = new JTextField();
		lblwcMetiseResPropValueTempdirBase.setColumns(10);
		lblwcMetiseResPropValueTempdirBase.setBounds(554, 212, 138, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueTempdirBase);

		JRadioButton wcMetiseResrdbtnMetiseResource = new JRadioButton("Resource");
		wcMetiseResrdbtnMetiseResource.setSelected(true);
		wcMetiseResrdbtnMetiseResource.setBounds(448, 57, 109, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnMetiseResource);

		JRadioButton wcMetiseResrdbtnMetiseDatabaseProperties = new JRadioButton("Database properties");
		wcMetiseResrdbtnMetiseDatabaseProperties.setBounds(295, 57, 147, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnMetiseDatabaseProperties);

		JRadioButton wcMetiseResrdbtnGlassBoxDatabaseProperties = new JRadioButton("Database properties");
		wcMetiseResrdbtnGlassBoxDatabaseProperties.setBounds(23, 57, 147, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnGlassBoxDatabaseProperties);

		JRadioButton wcMetiseResrdbtnGlassboxResource = new JRadioButton("Resource");
		wcMetiseResrdbtnGlassboxResource.setBounds(176, 57, 109, 23);
		warConfigrationMetiseResource.add(wcMetiseResrdbtnGlassboxResource);

		JLabel lblwcMetiseResPropLogFilePath = new JLabel("log.file.name");
		lblwcMetiseResPropLogFilePath.setBounds(222, 243, 72, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropLogFilePath);

		JLabel lblMetiseWeightageRequirement = new JLabel("weightage.requirement :");
		lblMetiseWeightageRequirement.setBounds(147, 178, 120, 14);
		warConfigrationMetiseResource.add(lblMetiseWeightageRequirement);

		JLabel lblMetiseWeightageTestcase = new JLabel("weightage.testcase :");
		lblMetiseWeightageTestcase.setBounds(403, 178, 107, 14);
		warConfigrationMetiseResource.add(lblMetiseWeightageTestcase);

		JLabel lblMetiseResourseWeightCode = new JLabel("wieghtage.code :");
		lblMetiseResourseWeightCode.setBounds(23, 178, 91, 14);
		warConfigrationMetiseResource.add(lblMetiseResourseWeightCode);

		lblwcMetiseResPropValueLogFileName = new JTextField();
		lblwcMetiseResPropValueLogFileName.setColumns(10);
		lblwcMetiseResPropValueLogFileName.setBounds(295, 240, 158, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueLogFileName);

		JLabel lblwcGlassboxResPropDownloadPath = new JLabel("download.path");
		lblwcGlassboxResPropDownloadPath.setBounds(10, 268, 72, 14);
		warConfigrationMetiseResource.add(lblwcGlassboxResPropDownloadPath);

		lblwcGlassboxResPropValueDownloadPath = new JTextField();
		lblwcGlassboxResPropValueDownloadPath.setColumns(10);
		lblwcGlassboxResPropValueDownloadPath.setBounds(94, 269, 90, 20);
		warConfigrationMetiseResource.add(lblwcGlassboxResPropValueDownloadPath);

		JLabel lblProxyValuehostname = new JLabel("");
		lblProxyValuehostname.setToolTipText("");
		lblProxyValuehostname.setBounds(116, 103, 137, 14);
		warConfigrationMetiseResource.add(lblProxyValuehostname);

		JLabel lblProxyValuehostport = new JLabel("");
		lblProxyValuehostport.setBounds(358, 106, 35, 14);
		warConfigrationMetiseResource.add(lblProxyValuehostport);

		JLabel lblProxytoValueenable = new JLabel("");
		lblProxytoValueenable.setBounds(492, 103, 46, 14);
		warConfigrationMetiseResource.add(lblProxytoValueenable);

		JLabel lblwcdbPropValuenotificationExpiry = new JLabel("");
		lblwcdbPropValuenotificationExpiry.setBounds(646, 103, 46, 14);
		warConfigrationMetiseResource.add(lblwcdbPropValuenotificationExpiry);

		JLabel lblProxyValueusername = new JLabel("");
		lblProxyValueusername.setToolTipText("");
		lblProxyValueusername.setBounds(118, 128, 135, 14);
		warConfigrationMetiseResource.add(lblProxyValueusername);

		JLabel lblProxyValuepassword = new JLabel("");
		lblProxyValuepassword.setBounds(347, 128, 78, 14);
		warConfigrationMetiseResource.add(lblProxyValuepassword);

		JLabel lblHttppValueroxyhost = new JLabel("");
		lblHttppValueroxyhost.setToolTipText("");
		lblHttppValueroxyhost.setBounds(492, 128, 174, 14);
		warConfigrationMetiseResource.add(lblHttppValueroxyhost);

		JLabel lblValueSimilaritythreshold = new JLabel("");
		lblValueSimilaritythreshold.setBounds(516, 153, 23, 14);
		warConfigrationMetiseResource.add(lblValueSimilaritythreshold);

		JLabel lblFromValueemail = new JLabel("");
		lblFromValueemail.setToolTipText("");
		lblFromValueemail.setBounds(118, 153, 135, 14);
		warConfigrationMetiseResource.add(lblFromValueemail);

		JLabel lblEmailValuepassword = new JLabel("");
		lblEmailValuepassword.setBounds(350, 153, 46, 14);
		warConfigrationMetiseResource.add(lblEmailValuepassword);

		JLabel lblMetiseResourseglowrootProtocal = new JLabel("glowroot.protocol :");
		lblMetiseResourseglowrootProtocal.setBounds(537, 153, 103, 14);
		warConfigrationMetiseResource.add(lblMetiseResourseglowrootProtocal);

		JLabel lblMetiseResourseValueglowrootProtocal = new JLabel("");
		lblMetiseResourseValueglowrootProtocal.setBounds(633, 153, 46, 14);
		warConfigrationMetiseResource.add(lblMetiseResourseValueglowrootProtocal);

		JLabel lblMetiseResourseValueWeightCode = new JLabel("");
		lblMetiseResourseValueWeightCode.setBounds(124, 178, 46, 14);
		warConfigrationMetiseResource.add(lblMetiseResourseValueWeightCode);

		JLabel lblMetiseValueWeightageRequirement = new JLabel("");
		lblMetiseValueWeightageRequirement.setBounds(273, 178, 46, 14);
		warConfigrationMetiseResource.add(lblMetiseValueWeightageRequirement);

		JLabel lblMetiseValueWeightageTestcase = new JLabel("");
		lblMetiseValueWeightageTestcase.setBounds(520, 178, 46, 14);
		warConfigrationMetiseResource.add(lblMetiseValueWeightageTestcase);

		lblMetiseValueSvndirmainpath = new JTextField();
		lblMetiseValueSvndirmainpath.setColumns(10);
		lblMetiseValueSvndirmainpath.setBounds(554, 240, 138, 20);
		warConfigrationMetiseResource.add(lblMetiseValueSvndirmainpath);

		JLabel lblwcMetiseResPropLuceneFolderPath = new JLabel("lucene.folderPath");
		lblwcMetiseResPropLuceneFolderPath.setBounds(463, 268, 91, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropLuceneFolderPath);

		lblwcMetiseResPropValueLuceneFolderPath = new JTextField();
		lblwcMetiseResPropValueLuceneFolderPath.setColumns(10);
		lblwcMetiseResPropValueLuceneFolderPath.setBounds(554, 265, 141, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueLuceneFolderPath);

		JLabel lblwcMetiseResPropCastNetFilter = new JLabel("cast.Net.csFilter");
		lblwcMetiseResPropCastNetFilter.setBounds(10, 293, 85, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropCastNetFilter);

		lblwcMetiseResPropValueCastNetFilter = new JTextField();
		lblwcMetiseResPropValueCastNetFilter.setColumns(10);
		lblwcMetiseResPropValueCastNetFilter.setBounds(94, 297, 90, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueCastNetFilter);

		JLabel lblwcMetiseResPropCastNetHtmlFilter = new JLabel("cast.Net.HtmlJsFilter");
		lblwcMetiseResPropCastNetHtmlFilter.setBounds(191, 296, 109, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropCastNetHtmlFilter);

		lblwcMetiseResPropValueCastNetHtmlFilter = new JTextField();
		lblwcMetiseResPropValueCastNetHtmlFilter.setColumns(10);
		lblwcMetiseResPropValueCastNetHtmlFilter.setBounds(295, 293, 158, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueCastNetHtmlFilter);

		JLabel lblwcMetiseResPropCastNetJavaFilter = new JLabel("cast.javaFilter");
		lblwcMetiseResPropCastNetJavaFilter.setBounds(463, 296, 91, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropCastNetJavaFilter);

		lblwcMetiseResPropValueCastNetJavaFilter = new JTextField();
		lblwcMetiseResPropValueCastNetJavaFilter.setColumns(10);
		lblwcMetiseResPropValueCastNetJavaFilter.setBounds(554, 293, 141, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueCastNetJavaFilter);

		JLabel lblwcMetiseResPropCastUIFilter = new JLabel("cast.uiFilter");
		lblwcMetiseResPropCastUIFilter.setBounds(461, 322, 91, 14);
		warConfigrationMetiseResource.add(lblwcMetiseResPropCastUIFilter);

		lblwcMetiseResPropValueCastUIFilter = new JTextField();
		lblwcMetiseResPropValueCastUIFilter.setColumns(10);
		lblwcMetiseResPropValueCastUIFilter.setBounds(552, 319, 141, 20);
		warConfigrationMetiseResource.add(lblwcMetiseResPropValueCastUIFilter);

		// Action

		// War Configuration Action
		btnwcGlassboxResPropPrev_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
			}
		});
		btnwcdbPropGlassboxPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
			}
		});
		btnwcMetisedbPropMetisePrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
			}
		});
		btnwcMetisedbPropRootPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
			}
		});

		btnwcGlassboxResPropPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, fileFolderMovementPanel);
			}
		});

		// Metise
		wcrdbtnwcMetiseGlassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, warConfigrationGlassBoxDataBase);
			}
		});
		wcrdbtnwcMetiseMetise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, warConfigrationMetiseDataBase);
			}
		});
		wcrdbtnwcMetiserootui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, warConfigrationRootUI);
			}
		});

		// Glass-box
		
		radiowarConfigrationGlassBoxDataBaseProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wcrdbtnGlassBox.setSelected(true);
				wcrdbtnMetise.setSelected(false);
				wcrdbtnrootui.setSelected(false);
				
				radiowarConfigrationGlassBoxDataBaseProperties.setSelected(true);
				radiowarConfigrationGlassBoxResource.setSelected(false);
				wcGlassboxResrdbtnMetiseDatabaseProperties.setSelected(false);				
				wcGlassboxResrdbtnMetiseResource.setSelected(false);
				
				if (wcrdbtnGlassBox.isSelected()  && radiowarConfigrationGlassBoxDataBaseProperties.isSelected()) {
					br.switchPanel(layeredPane, warConfigrationGlassBoxDataBase);

					final Properties myresources = new Properties();
					String warFileName = chckbxssmGlassbox.getText();
					String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator + "webapps";
					destinationLocation += File.separator + warFileName.substring(0, (warFileName.length() - 4)).trim()
							+ File.separator + "WEB-INF" + File.separator + "classes" + File.separator
							+ "db.properties";
					try {
						FileInputStream in = new FileInputStream(destinationLocation);
						try {
							myresources.load(in);
							// Database Properties
							textFieldwcdbPropClass.setText(myresources.getProperty("jdbc.driverClassName"));
							textFieldwcdbPropUrl.setText(myresources.getProperty("jdbc.url"));
							textFieldwcdbPropUser.setText(myresources.getProperty("jdbc.user"));
							textFieldwcdbPropPass.setText(myresources.getProperty("jdbc.pass"));
							textFieldwcdbProphbm.setText(myresources.getProperty("hibernate.hbm2ddl.auto"));
							textFieldwcdbPropdialect.setText(myresources.getProperty("hibernate.dialect"));
							textFieldwcdbPropSql.setText(myresources.getProperty("hibernate.show_sql"));
							textFieldwcdbPropCatalog.setText(myresources.getProperty("hibernate.default.catalog"));
							textFieldwcdbPropMProt.setText(myresources.getProperty("mongo.port"));
							textFieldwcdbPropMdbName.setText(myresources.getProperty("mongo.dbName"));
							textFieldwcdbPropMPassword.setText(myresources.getProperty("mongo.password"));
							textFieldwcdbPropMHost.setText(myresources.getProperty("mongo.host"));
							textFieldwcdbPropMdbUsername.setText(myresources.getProperty("mongo.username"));
							textFieldwcdbPropAccSolAdv.setText(myresources.getProperty("accuracySolAdvisor"));
							textFieldwcdbPropAccCloud.setText(myresources.getProperty("accuracyCloud"));
							textFieldwcdbPropAccStopwords.setText(myresources.getProperty("accuracyStopwords"));
							textFieldwcdbPropDownPath.setText(myresources.getProperty("download.path"));
						} catch (Exception wce) {
							wce.printStackTrace();
						}
					} catch (Exception ce) {
						ce.printStackTrace();
					}
				
				}
			}
		});
		
		radiowarConfigrationGlassBoxResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wcrdbtnGlassBox.setSelected(true);
				wcrdbtnMetise.setSelected(false);
				wcrdbtnrootui.setSelected(false);
				
				radiowarConfigrationGlassBoxDataBaseProperties.setSelected(false);
				radiowarConfigrationGlassBoxResource.setSelected(true);
				wcGlassboxResrdbtnMetiseDatabaseProperties.setSelected(false);				
				wcGlassboxResrdbtnMetiseResource.setSelected(false);
				
				if (wcrdbtnGlassBox.isSelected()  && radiowarConfigrationGlassBoxResource.isSelected()) {
					br.switchPanel(layeredPane, warConfigrationGlassBoxResource);

					final Properties myresources = new Properties();
					String warFileName = chckbxssmGlassbox.getText();  
					String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator + "webapps";
					destinationLocation += File.separator + warFileName.substring(0, (warFileName.length() - 4)).trim()
							+ File.separator + "WEB-INF" + File.separator + "classes" + File.separator
							+ "resources.properties";
					try {
						FileInputStream in = new FileInputStream(destinationLocation);
						try {
							myresources.load(in);							
							lblwcGlassboxResPropValueHostName.setText(myresources.getProperty("proxy.host.name"));
							lblwcGlassboxResPropValueHostName.setToolTipText(myresources.getProperty("proxy.host.name"));							
							lblwcGlassboxResPropValueHostPort.setText(myresources.getProperty("proxy.host.port"));
							lblwcGlassboxResPropValueEnable.setText(myresources.getProperty("proxy.to.enable"));
							lblwcGlassboxResPropValueNotificationExpiry.setText(myresources.getProperty("notifications_expiry"));
							lblwcGlassboxResPropValueUserName.setText(myresources.getProperty("proxy.username"));							
							lblwcGlassboxResPropValueProxyHost.setText(myresources.getProperty("gitlab.proxy.host"));
							lblwcGlassboxResPropValuePassword.setText(myresources.getProperty("proxy.password"));					
							lblwcGlassboxResPropValueFromMail.setText(myresources.getProperty("fromEmail"));
							lblwcGlassboxResPropValueEmailPassword.setText(myresources.getProperty("emailPassword"));
							lblwcGlassboxResPropValueSimilarityThreshold.setText(myresources.getProperty("similarity.threshold"));						
							textFieldwcGlassboxResPropTempFileDir.setText(myresources.getProperty("temp.file.dir"));
							textFieldwcGlassboxResPropDirBase.setText(myresources.getProperty("temp.dir.base"));							
							textFieldwcGlassboxResPropsvnmainPath.setText(myresources.getProperty("svn.dir.main.path"));							
							textFieldwcGlassboxResPropValueProxyHost.setText(myresources.getProperty("http.proxy.host"));
							textFieldwcGlassboxResPropfiletypesIgnoreJava.setText(myresources.getProperty("filetypes.ignore.java.parsing"));
							textFieldwcGlassboxResPropfiletypesIgnoreJava.setToolTipText(myresources.getProperty("filetypes.ignore.java.parsing"));							
							textFieldwcGlassboxResPropfiletypesIgnore.setText(myresources.getProperty("file.types.ignore"));
							textFieldwcGlassboxResPropfiletypesIgnore.setToolTipText(myresources.getProperty("file.types.ignore"));
							textFieldwcGlassboxResPropDefectGlassUrl.setText(myresources.getProperty("defect.glassbox.url"));
							textFieldwcGlassboxResPropDefectGlassUrl.setToolTipText(myresources.getProperty("defect.glassbox.url"));
							textFieldwcGlassboxResPropmailFilePath.setText(myresources.getProperty("mail.filePath"));							
							textFieldwcGlassboxResPropmailFilePath.setToolTipText(myresources.getProperty("mail.filePath"));							
							textFieldwcGlassboxResPropAssetsPath.setText(myresources.getProperty("assets.path"));
							textFieldwcGlassboxResPropAssetsPath.setToolTipText(myresources.getProperty("assets.path"));							
							textFieldwcGlassboxResPropShareUploadPath.setText(myresources.getProperty("sharepoint.upload.path"));
							textFieldwcGlassboxResPropShareUploadPath.setToolTipText(myresources.getProperty("sharepoint.upload.path"));							
							lblwcGlassboxResPropValueSharepointDownPath.setToolTipText(myresources.getProperty("sharepoint.download.path"));	
							lblwcGlassboxResPropValueSharepointDownPath.setToolTipText(myresources.getProperty("sharepoint.download.path"));				
							
						} catch (Exception wce) {
							wce.printStackTrace();
						}
					} catch (Exception ce) {
						ce.printStackTrace();
					}
				
				}
			}
		});
		
		
		wcrdbtnGlassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Glass Box Selected");
				wcrdbtnGlassBox.setSelected(true);
				wcrdbtnMetise.setSelected(false);
				wcrdbtnrootui.setSelected(false);				
				
				radiowarConfigrationGlassBoxDataBaseProperties.setEnabled(true);
				radiowarConfigrationGlassBoxResource.setEnabled(true);
				wcGlassboxResrdbtnMetiseDatabaseProperties.setEnabled(false);				
				wcGlassboxResrdbtnMetiseResource.setEnabled(false);
				
				
				
				
				
				
			}
		});
		
		

		// War Configuration Action
		

		wcGlassboxResrdbtnMetiseDatabaseProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Metise Selected");
				wcrdbtnGlassBox.setSelected(false);wcrdbtnGlassBox.setEnabled(false);
				wcrdbtnrootui.setSelected(false);wcrdbtnrootui.setEnabled(false);
				wcrdbtnMetise.setSelected(true);				
				
				radiowarConfigrationGlassBoxDataBaseProperties.setSelected(false);
				radiowarConfigrationGlassBoxDataBaseProperties.setEnabled(false);
				radiowarConfigrationGlassBoxResource.setSelected(false); radiowarConfigrationGlassBoxResource.setEnabled(false);
				wcGlassboxResrdbtnMetiseDatabaseProperties.setSelected(true);				
				wcGlassboxResrdbtnMetiseResource.setSelected(false); wcGlassboxResrdbtnMetiseResource.setEnabled(false);
				
				if (wcrdbtnMetise.isSelected()  && wcGlassboxResrdbtnMetiseDatabaseProperties.isSelected()) {
					br.switchPanel(layeredPane, warConfigrationMetiseDataBase);

					final Properties myresources = new Properties();
					String warFileName = chckbxssmMetise.getText();
					String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator + "webapps";
					destinationLocation += File.separator + warFileName.substring(0, (warFileName.length() - 4)).trim()
							+ File.separator + "WEB-INF" + File.separator + "classes" + File.separator
							+ "db.properties";
					try {
						FileInputStream in = new FileInputStream(destinationLocation);
						try {
							myresources.load(in);
							// Database Properties
							textFieldwcMetiseDriverClass.setText(myresources.getProperty("jdbc.driverClassName"));
							textFieldwcMetiseUrl.setText(myresources.getProperty("jdbc.url"));
							textFieldwcMetiseUser.setText(myresources.getProperty("jdbc.user"));
							textFieldwcMetisePassword.setText(myresources.getProperty("jdbc.pass"));
							
							textFieldwcMetisehibauto.setText(myresources.getProperty("hibernate.hbm2ddl.auto"));
							textFieldwcMetisehibdialet.setText(myresources.getProperty("hibernate.dialect"));
							textFieldwcMetiseSql.setText(myresources.getProperty("hibernate.show_sql"));
							textFieldwcMetiseCatalog.setText(myresources.getProperty("hibernate.default.catalog"));
							
							textFieldwcMetisedbMPort.setText(myresources.getProperty("mongo.port"));
							textFieldwcMetisedbMdbName.setText(myresources.getProperty("mongo.dbName"));
							textFieldwcMetisedbMPassword.setText(myresources.getProperty("mongo.password"));
							textFieldwcMetisedbMdbhost.setText(myresources.getProperty("mongo.host"));
							textFieldwcMetisedbMusername.setText(myresources.getProperty("mongo.username"));
							
							textFieldwcdbPropAccSolAdv.setText(myresources.getProperty("accuracySolAdvisor"));
							textFieldwcdbPropAccCloud.setText(myresources.getProperty("accuracyCloud"));
							textFieldwcdbPropAccStopwords.setText(myresources.getProperty("accuracyStopwords"));
							textFieldwcdbPropDownPath.setText(myresources.getProperty("download.path"));
						} catch (Exception wce) {
							wce.printStackTrace();
						}
					} catch (Exception ce) {
						ce.printStackTrace();
					}				
				}			
			}
		});
		
		
		radiowarConfigrationMetiseMetiseResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Metise Resource Selected");
				wcrdbtnGlassBox.setSelected(false);
				wcrdbtnMetise.setSelected(true);
				wcrdbtnrootui.setSelected(false);
				
				radiowarConfigrationGlassBoxDataBaseProperties.setSelected(false);
				radiowarConfigrationGlassBoxResource.setSelected(false);
				wcGlassboxResrdbtnMetiseDatabaseProperties.setSelected(false);				
				wcGlassboxResrdbtnMetiseResource.setSelected(true);
				
				if (wcrdbtnMetise.isSelected()  && radiowarConfigrationMetiseMetiseResource.isSelected()) {
					br.switchPanel(layeredPane, warConfigrationMetiseResource);

					final Properties myresources = new Properties();
					String warFileName = chckbxssmMetise.getText();
					String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator + "webapps";
					destinationLocation += File.separator + warFileName.substring(0, (warFileName.length() - 4)).trim()
							+ File.separator + "WEB-INF" + File.separator + "classes" + File.separator
							+ "resources.properties";
					
					lblProxyValuehostname.setText(myresources.getProperty("proxy.host.name"));
					lblProxyValuehostport.setText(myresources.getProperty("proxy.host.port"));
					lblProxytoValueenable.setText(myresources.getProperty("proxy.to.enable"));
					lblwcdbPropValuenotificationExpiry.setText(myresources.getProperty("notifications_expiry"));
					lblProxyValueusername.setText(myresources.getProperty("proxy.username"));
					lblProxyValuepassword.setText(myresources.getProperty("proxy.password"));
					lblHttppValueroxyhost.setText(myresources.getProperty("http.proxy.host"));
					lblFromValueemail.setText(myresources.getProperty("fromEmail"));
					lblEmailValuepassword.setText(myresources.getProperty("emailPassword"));
					lblValueSimilaritythreshold.setText(myresources.getProperty("similarity.threshold"));
					lblMetiseResourseValueglowrootProtocal.setText(myresources.getProperty("glowroot.protocol"));
					lblMetiseResourseValueWeightCode.setText(myresources.getProperty("wieghtage.code"));
					lblMetiseValueWeightageRequirement.setText(myresources.getProperty("weightage.requirement"));
					lblMetiseValueWeightageTestcase.setText(myresources.getProperty("weightage.testcase"));
					
					lblwcMetiseResPropValueTempFileDir.setText(myresources.getProperty("temp.file.dir"));
					
					lblwcMetiseResPropValaueGlassBoxURL.setText(myresources.getProperty("defect.glassbox.url"));
					lblwcMetiseResPropValaueGlassBoxURL.setToolTipText(myresources.getProperty("defect.glassbox.url"));					
					lblwcMetiseResPropValueTempdirBase.setText(myresources.getProperty("temp.dir.base"));
					lblwcMetiseResPropValueTempdirBase.setToolTipText(myresources.getProperty("temp.dir.base"));					
					lblwcMetiseResPropmailValueFilePath.setText(myresources.getProperty("mail.filePath"));
					lblwcMetiseResPropmailValueFilePath.setToolTipText(myresources.getProperty("mail.filePath"));
					lblwcMetiseResPropValueLogFileName.setText(myresources.getProperty("log.file.name"));
					
					lblMetiseValueSvndirmainpath.setText(myresources.getProperty("svn.dir.main.path"));
					lblMetiseValueSvndirmainpath.setToolTipText(myresources.getProperty("svn.dir.main.path"));					
					lblwcGlassboxResPropValueDownloadPath.setText(myresources.getProperty("download.path"));
					lblwcGlassboxResPropValueDownloadPath.setToolTipText(myresources.getProperty("download.path"));
					lblwcMetiseResPropValueAssetsPath.setText(myresources.getProperty("assets.path"));
					lblwcMetiseResPropValueAssetsPath.setToolTipText(myresources.getProperty("assets.path"));
					lblwcMetiseResPropValueLuceneFolderPath.setText(myresources.getProperty("lucene.folderPath"));
					lblwcMetiseResPropValueLuceneFolderPath.setToolTipText(myresources.getProperty("lucene.folderPath"));
					lblwcMetiseResPropValueCastNetFilter.setText(myresources.getProperty("cast.Net.csFilter"));
					lblwcMetiseResPropValueCastNetHtmlFilter.setText(myresources.getProperty("cast.Net.HtmlJsFilter"));
					lblwcMetiseResPropValueCastNetJavaFilter.setText(myresources.getProperty("cast.javaFilter"));
					lblwcMetiseResPropValueCastUIFilter.setText(myresources.getProperty("cast.uiFilter"));
					lblwcMetiseResPropValueFileTypesIgnore.setText(myresources.getProperty("file.types.ignore"));
					lblwcMetiseResPropValueFileTypesIgnore.setToolTipText(myresources.getProperty("file.types.ignore"));
					lblwcMetiseResPropValueFileTypesIgnoreJavaParsing.setText(myresources.getProperty("filetypes.ignore.java.parsing"));
					lblwcMetiseResPropValueFileTypesIgnoreJavaParsing.setToolTipText(myresources.getProperty("filetypes.ignore.java.parsing"));
					
					lblwcMetiseResPropValueSharepointUploadPath.setText(myresources.getProperty("sharepoint.upload.path"));
					lblwcMetiseResPropValueSharepointUploadPath.setToolTipText(myresources.getProperty("sharepoint.upload.path"));
					
					lblwcMetiseResPropValueSharepointDownload.setText(myresources.getProperty("sharepoint.download.path"));
					lblwcMetiseResPropValueSharepointDownload.setToolTipText(myresources.getProperty("sharepoint.download.path"));		
					
					
					
				}
				
			}
		});	
		
		wcrdbtnMetise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Glass Box Selected");
				wcrdbtnGlassBox.setSelected(false);
				wcrdbtnMetise.setSelected(true);
				wcrdbtnrootui.setSelected(false);	

			}
		});

		// War Configuration Action
		wcrdbtnrootui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wcrdbtnGlassBox.setSelected(false);
				wcrdbtnMetise.setSelected(false);
				wcrdbtnrootui.setSelected(true);
				
				System.out.println("ROOT Selected ");
				
				br.switchPanel(layeredPane, warConfigrationRootUI);
				

			}
		});

		// End War Configuration
		btnsdlCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.cancelButton();
			}
		});
		// File Folder Move Panel
		btnssmNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.switchPanel(layeredPane, warConfigrationGlassBoxDataBase);
			}
		});

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
				if (rdbtnssmTomcat.isSelected()) {
					// Enable / Disable check Box
					chckbxssmNlp.setVisible(false);
					chckbxssmGlobalpy.setVisible(false);

					// Disable Label
					lblssmTomcatLocation.setVisible(true);
					lblssmTomcatLocationMsgLabel.setVisible(true);

					lblssmGlobalPyLocation.setVisible(false);
					lblssmNlpLocation.setVisible(false);

					List<String> tocatMoveableFiles = new ArrayList<>();
					tocatMoveableFiles.add(chckbxssmGlassbox.getText());
					tocatMoveableFiles.add(chckbxssmMetise.getText());
					tocatMoveableFiles.add(chckbxssmrootzip.getText());

					for (String warFileName : tocatMoveableFiles) {
						String destinationLocation = lblssmTomcatLocationMsgLabel.getText() + File.separator
								+ "webapps";

						if (warFileName.endsWith(".war")) {
							destinationLocation += File.separator
									+ warFileName.substring(0, (warFileName.length() - 4)).trim();
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

					br.moveNlp(lblssmSrclocationMsgLabel.getText(), lblssmNlpMsgLabel.getText(),
							chckbxssmNlp.getText());

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

					chckbxssmGlobalpy.setVisible(true);
					chckbxssmGlobalpy.setText(chckbxssmGlobalpy.getText());
					chckbxssmGlobalpy.setSelected(true);

					System.out.println(lblssmSrclocationMsgLabel.getText());
					System.out.println(lblssmGlobalMsgLabel.getText());
					String source_global = lblssmSrclocationMsgLabel.getText() + File.separator
							+ chckbxssmGlobalpy.getText();
					String destination_global = lblssmGlobalMsgLabel.getText() + File.separator
							+ chckbxssmGlobalpy.getText();

					try {
						br.copyFileUsingApacheCommonsIO(new File(source_global), new File(destination_global),
								chckbxssmGlobalpy.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

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
					} catch (Exception unzipException) {
						System.out.println("Error in Unzip File");
					}
				} else if (rdbtnssmNlp.isSelected()) {
					br.unZipNlp(lblssmNlpMsgLabel.getText(), chckbxssmNlp.getText());
				} else if (rdbtnssmGlobalpy.isSelected()) {
					// Enable / disable check Box
					chckbxssmGlobalpy.setVisible(true);
					chckbxssmGlobalpy.setText(chckbxssmGlobalpy.getText());
					chckbxssmGlobalpy.setSelected(true);
					String destination_global = lblssmGlobalMsgLabel.getText() + File.separator
							+ chckbxssmGlobalpy.getText();
					br.unzip(destination_global);
					br.deleteWarZipFiles(destination_global);

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

				// Visible false
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

				// Visible false
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
