package com.lti.canvas.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BrowseUtil {
	public JFrame frame;

	public BrowseUtil() {

	}

	/** Cancel button */
	public void cancelButton() {
		System.exit(0);
	}

	public void extractFiles(String warFileName, String location) throws FileNotFoundException {
		System.out.println(" --- " + warFileName + " : Started ------");
		String warFileSourceLocation = location;
		System.out.println(" location  " + location);
		System.out.println("----Decompressing .war File----\n" + "Processing : ");

		if (warFileName.endsWith(".war"))
			warFileSourceLocation = location + File.separator + warFileName;

		try {

			Process ps = Runtime.getRuntime().exec(new String[] { "unzip", warFileSourceLocation, "-d", location });
			ps.waitFor();
			System.out.println("#");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-- Error in unZipping War " + warFileName);
		}
		deleteWarFiles(warFileSourceLocation);

	}
	
	private void deleteWarFiles(String location) {
		System.out.println("Deleting files from Tomcat");
		System.out.println("Processing : #");
		try {
			File filename = new File(location);
			if (filename.exists())
				filename.delete();
		} catch (Exception e) {
			System.out.println("Error in deleting File or File not available");
		}
		System.out.println("Completed");
	}
	
	public void unzip(String zipFilePath) {
		File srcFile = new File(zipFilePath);

		// create a directory with the same name to which the contents will be extracted
		String zipPath = zipFilePath.substring(0, zipFilePath.length() - 4);
		File temp = new File(zipPath);
		temp.mkdir();
		zipPath = zipPath.substring(0, zipPath.lastIndexOf(File.separator));
		ZipFile zipFile = null;
		System.out.println("----Decompressing .zip File----");
		System.out.println("Processing : ");

		try {
			zipFile = new ZipFile(srcFile);
			// get an enumeration of the ZIP file entries
			Enumeration<? extends ZipEntry> e = zipFile.entries();
			while (e.hasMoreElements()) {
				ZipEntry entry = e.nextElement();
				File destinationPath = new File(zipPath, entry.getName());
				// create parent directories
				destinationPath.getParentFile().mkdirs();
				// if the entry is a file extract it
				if (entry.isDirectory()) {
					continue;
				} else {
					System.out.print("#");
					BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
					int b;
					byte buffer[] = new byte[1024];
					FileOutputStream fos = new FileOutputStream(destinationPath);
					BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
					while ((b = bis.read(buffer, 0, 1024)) != -1) {
						bos.write(buffer, 0, b);
					}
					bos.close();
					bis.close();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Error opening zip file" + ioe);
		} finally {
			try {
				if (zipFile != null) {
					zipFile.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error while closing zip file" + ioe);
			}
		}
	}

	public void copyFileUsingChannel(File source, File dest, String movingFolderName) throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destChannel = new FileOutputStream(dest).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

			System.out.println(movingFolderName + " : " + source + " has been copied to " + dest + " successfully. ");
		} finally {
			sourceChannel.close();
			destChannel.close();
		}
	}

	/** Browse Folder */
	public void browseFolder(JLabel selectedLocationMessagelbl) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = fileChooser.showOpenDialog(frame);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			selectedLocationMessagelbl.setText(file.getAbsolutePath());
		} else {
			selectedLocationMessagelbl.setText("...");
		}
	}

	/* Switch Panels */

	public void switchPanel(JLayeredPane layeredPanel, JPanel panel) {
		layeredPanel.removeAll();
		layeredPanel.add(panel);
		layeredPanel.repaint();
		layeredPanel.revalidate();
	}

	public List<String> listFilesInFolder(String folderLocation) {
		List<String> filesName = new ArrayList<>();
		File directoryPath = new File(folderLocation);
		// List of all files and directories
		String contents[] = directoryPath.list();
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			filesName.add(contents[i]);
		}
		return filesName;

	}

	public void moveFileFolder() {
		System.out.println("File movement started");
	}

	public void assignValuesToTextFields(List<String> fileNames, JTextField mongoFile, JTextField globalPyFile,
			JTextField glassBoxFile, JTextField metiseFile) {
		for (String fileName : fileNames) {
			if (fileName.contains("mongo"))
				mongoFile.setText(fileName);
			else if (fileName.contains("Glassbox"))
				glassBoxFile.setText(fileName);
			else if (fileName.contains("Metise"))
				metiseFile.setText(fileName);

		}
	}

}
