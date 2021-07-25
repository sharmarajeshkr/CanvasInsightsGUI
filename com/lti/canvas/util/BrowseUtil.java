package com.lti.canvas.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.io.FileUtils;

public class BrowseUtil {
	public JFrame frame;

	public BrowseUtil() {

	}

	/** Cancel button */
	public void cancelButton() {
		System.exit(0);
	}
	
	
	public void movenlp(String sourceLocation,String destinationLocation,String fileName) {	
		String anacondaPath = destinationLocation  + File.separator + "envs" + File.separator;
		destinationLocation += File.separator + "envs"+ File.separator +fileName;
		sourceLocation += File.separator 	+fileName;
		
		File nlpSoure = new File(sourceLocation);
		if (nlpSoure.exists()) {			
			try {
				copyFileUsingApacheCommonsIO(new File(sourceLocation), new File(destinationLocation), "NLP");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			// Unzipping .7z File
			
			String unzipLocation =anacondaPath + File.separator;
			try {
				decompress7z(sourceLocation, new File(unzipLocation));
				// Remove .7z file after extraction
				deleteWarZipFiles(destinationLocation);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	}
	
	public void moveNlp(String sourceLocation,String destinationLocation,String fileName) {
		//String sourceLocation = environment.getProperty("canvas_insights_root_folder_location") + File.separator	+ environment.getProperty("nlp_file_name");
		//String destinationLocation = environment.getProperty("anaconda_path") + File.separator;
		try {
			sourceLocation += File.separator	+fileName;
			destinationLocation +=  File.separator + "envs"+ File.separator	+fileName;
			copyFileUsingApacheCommonsIO(new File(sourceLocation), new File(destinationLocation), "NLP");
		} catch (IOException e) {
			System.out.println("Unabale to Move File or Folder to destination" + e.getMessage());
		}
		
		//moduleCompleted("NLP");
	}
	
	
	public void unZipNlp(String sourceLocation ,String fileName) {
		//String unzipLocation = environment.getProperty("anaconda_path") + File.separator;
		String destinationLocation = sourceLocation+File.separator + "envs"+ File.separator ;
		sourceLocation += File.separator + "envs"+ File.separator	+fileName;
		
		try {
			decompress7z(sourceLocation, new File(destinationLocation));
			deleteWarZipFiles(sourceLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void decompress7z(String in, File destination) throws IOException {

		SevenZFile sevenZFile = new SevenZFile(new File(in));
		SevenZArchiveEntry entry;
		System.out.println("----Decompressing .7z File----");
		System.out.println("Processing : ");
		while ((entry = sevenZFile.getNextEntry()) != null) {
			int count = 0;
			if (entry.isDirectory()) {
				continue;
			}
			File curfile = new File(destination, entry.getName());
			File parent = curfile.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			FileOutputStream out = new FileOutputStream(curfile);
			byte[] content = new byte[(int) entry.getSize()];
			System.out.print(".");
			sevenZFile.read(content, 0, content.length);
			out.write(content);
			out.close();
		}

	}

	public void deleteTomcatCatlina(String catlinaPath) {
		System.out.println("Deleting  Catalina folder from Tomcat");
		System.out.println("Processing : #");
		try {
			File filename = new File(catlinaPath);
			if (filename.exists())
				filename.delete();
			System.out.println("File Deleted from location " + catlinaPath);
		} catch (Exception e) {
			System.out.println("Error in deleting File or File not available");
		}
		System.out.println("Completed");
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
			printResults(ps);
			ps.waitFor();
			System.out.println("#");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-- Error in unZipping War " + warFileName);
		}
		deleteWarFiles(warFileSourceLocation);

	}

	public void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(".");
		}
	}

	public void extractWarFiles(String warFileName, String location) throws FileNotFoundException {
		System.out.println(" --- " + warFileName + " : Started ------");
		String warFileSourceLocation = location;
		System.out.println(" location  " + location);
		System.out.println("----Decompressing .war File----\n" + "Processing : ");

		if (warFileName.endsWith(".war"))
			warFileSourceLocation = location + File.separator + warFileName;
		File file = new File(location);
		try {
			Process p = Runtime.getRuntime().exec(new String[] { "jar", "-xvf", warFileName }, null, file);
			printResults(p);
			p.waitFor();
		} catch (Exception e) {
			System.out.println("War Path :" + warFileSourceLocation);
			System.out.println(e.getMessage());
			System.exit(0);
		}
		deleteWarZipFiles(warFileSourceLocation);

	}

	public void deleteWarZipFiles(String location) {
		System.out.println("Deleting  War/Zip files after uncompress");
		System.out.println("Processing : #");
		try {
			File filename = new File(location);
			if (filename.exists())
				filename.delete();
			System.out.println("File Deleted from location " + location);
		} catch (Exception e) {
			System.out.println("Error in deleting File or File not available");
		}
		System.out.println("Completed");
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

	public void copyFileUsingApacheCommonsIO(File source, File dest, String movingFolderName) throws IOException {
		try {
			FileUtils.copyFile(source, dest);
			System.out.println(movingFolderName + " : " + source + " has been copied to " + dest + " successfully. ");
		} catch (Exception e) {
			// TODO: handle exception
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
