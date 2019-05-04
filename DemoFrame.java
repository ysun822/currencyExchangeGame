import java.io.IOException;

import javax.swing.JFrame;

import org.json.JSONException;

public class DemoFrame extends JFrame {
	public DemoFrame(DemoPanel panel)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setTitle("Currency Exchange Game Demo");
		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException, JSONException
	{
		DemoPanel panel = new DemoPanel();
		
		DemoFrame Frame = new DemoFrame(panel);
		
	}	
 

}
