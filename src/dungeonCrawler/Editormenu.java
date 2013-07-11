package dungeonCrawler;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;;

public class Editormenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private App app;
	private JButton NewMap;
	JComboBox<String> editMapNr;
	private String selectedFile;
	

	
	
	public Editormenu(App app){
		this.app = app;
		this.setLayout(new FlowLayout());
		NewMap = new JButton("Level Bearbeiten");
		fillBox(this);
		this.add(NewMap);
		this.initialize();
	}
	
	private void fillBox(Container c){
		editMapNr = new JComboBox<String>();
		editMapNr.addItem("Neue Datei erstellen");
		
		for(int i=3;i<=app.level;i++){
			if(i<10){
				editMapNr.addItem(new File("Levels"+File.separator+"level0" + i +".lvl").getAbsolutePath());
			}
			else if(i>10 && i<100){
				editMapNr.addItem(new File("Levels"+File.separator+"level" + i +".lvl").getAbsolutePath());
			}
			else{
				System.out.println("Error");
			}
		}
		selectedFile = (String)editMapNr.getSelectedItem();
		System.out.println(selectedFile);
		editMapNr.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED){
					selectedFile = (String)editMapNr.getSelectedItem();
					System.out.println("SelectetItem " + selectedFile);
				}
				
			}
		});
		c.add(editMapNr);
	}
	
	private File createNewFile(int number){
		File newFile;
		if(number<10){
			newFile = new File("Levels"+File.separator+"level0" + number +".lvl");
		}
		else if	(number<100){
			newFile = new File("Levels"+File.separator+"level" + number +".lvl");
		}
		else{
			newFile = null;
			System.out.println("Error level größer als 99"); 
		}
		return newFile;
	}
		
	private void initialize(){
		NewMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedFile.equals("Neue Datei erstellen")){
					System.out.println("if" + selectedFile);
					
					FileWriter writer = null;
				    try {
				    	System.out.println(app.level);
				        writer = new FileWriter(createNewFile(app.level+1));
				        writer.write("PLAYER,0,0,30,30");
				    } catch (IOException e1) {
				        e1.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
				    } finally {
				        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
				    }
				    System.out.printf("File is located at %s%n", createNewFile(app.level+1).getAbsolutePath());				
		
					try {
						createNewFile(app.level+1).createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.startEdit(createNewFile(app.level+1));
				}
				else if(selectedFile != "Neue Datei erstellen") {
					System.out.println("else" +selectedFile);
					app.startEdit(new File(selectedFile));
				}
			}
		});
	}
}
