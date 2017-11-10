
import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class creocleaner {

	public static void main(String[] args) {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setCurrentDirectory(new File("."));
		fc.setDialogTitle("Select a folder to purge old Creo Files");
		if(fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
			return;
		
		//File folder = new File(".");
		File folder = fc.getSelectedFile();
		File[] listOfFiles = folder.listFiles();
		String[] fileNames = folder.list();
		
		for (File file:listOfFiles) {
			try{
				//System.out.println(file);
				String[] fnp = file.getName().split("\\.");
				int i = Integer.parseInt(fnp[fnp.length-1]);
				String newerFile="";
				for (int x=0;x<fnp.length-1;x++)
					newerFile+=fnp[x]+".";
				newerFile+=(i+1);
				System.out.println(newerFile);
				if (Arrays.asList(fileNames).contains(newerFile))
					file.delete();
			} catch (Exception e){
				//System.out.println(e);
			}
			
		}

	}

}
