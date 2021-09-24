import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class TextEditor extends JFrame implements ActionListener{
	
	private Color darkC = new Color(0x001E6C);
	private Color medC = new Color(0x035397);
	private Color lightC = new Color(0x5089C6);
	private Color textAC = new Color(184,197,254);
	private Font textF = new Font("Arial",Font.PLAIN,22);
	private Font btnF = new Font("Arial",Font.BOLD,20);
	private Font labelF = new Font("Tahoma",Font.BOLD,25);
	
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private JComboBox<String> fontCB = new JComboBox<String>(fonts);
	private String[] fontsStyle = {"PLAIN","BOLD","ITALIC"};
	private JComboBox<String> fontStyleCB = new JComboBox<String>(fontsStyle);
	private JTextArea textArea = new JTextArea();
	private JSpinner fontSizeS = new JSpinner();
	private JButton colorBtn = new JButton("COLOR");
	private JColorChooser fontColor = new JColorChooser(Color.black);
	private JButton copyText = new JButton("COPY");
	private JButton cutText = new JButton("CUT");
	private JButton pasteText = new JButton("PASTE");
	private JButton rtlText = new JButton("EN->AR");
	private JButton toUpper = new JButton("UPPER");
	private JButton toLower = new JButton("LOWER");
	private JButton spongebob = new JButton("SpOnGe");
	private JButton toTitle = new JButton("TITLE");
	private JButton stripText = new JButton("STRIP");
	
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("FILE");
	JMenu help = new JMenu("HELP");
	JMenuItem open = new JMenuItem("OPEN");
	JMenuItem save = new JMenuItem("SAVE");
	JMenuItem exit = new JMenuItem("EXIT");
	JMenuItem getHelp = new JMenuItem("GET HELP");
	JMenuItem about = new JMenuItem("ABOUT");
	
	TextEditor(){
		//Frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TextEditor");
		this.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				textArea.requestFocusInWindow();
			}});
		this.getContentPane().setBackground(medC);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("text.png")).getImage());	
		
		//Panel
		JPanel topRow = new JPanel();
		topRow.setBounds(0, 0, 1000, 60);
		topRow.setBackground(darkC);
		topRow.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		JPanel bottomRow = new JPanel();
		bottomRow.setBounds(0, 460, 1000, 70);
		bottomRow.setBackground(darkC);
		bottomRow.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		//TextArea
		JScrollPane taScroll = new JScrollPane(textArea);
		taScroll.setBounds(10, 70, 965, 380);
		textArea.setSelectionColor(darkC);
		textArea.setSelectedTextColor(lightC);
		textArea.setFont(textF);
		textArea.setBackground(textAC);
		textArea.setForeground(darkC);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setCaretColor(medC);
		String guideText = "\taa: 'ا'\tee: 'ي\t1: 'ظ'\t2: 'ء'\t3: 'ع'\t4: 'ض'\t5: 'خ'\t6: 'ط'\t7: 'ح'\t8: 'غ'\t9: 'ص'\t0: 'ذ";
		JTextArea guide = new JTextArea(guideText);
		guide.setBounds(0, 590, 1000, 110);
		guide.setFont(btnF);
		guide.setBackground(darkC);
		guide.setForeground(lightC);
		guide.setEditable(false);
		
		//Labels
		JLabel fontName = new JLabel("FONT");
		fontName.setFont(labelF);
		fontName.setForeground(lightC);
		JLabel fontStyle = new JLabel("STYLE");
		fontStyle.setFont(labelF);
		fontStyle.setForeground(lightC);
		JLabel fontSize = new JLabel("SIZE");
		fontSize.setFont(labelF);
		fontSize.setForeground(lightC);
		JLabel guideTitle = new JLabel("For Converstion between English and Arabic");
		guideTitle.setFont(labelF);
		guideTitle.setForeground(lightC);
		guideTitle.setBounds(0,540,1000,50);
		guideTitle.setOpaque(true);
		guideTitle.setBackground(darkC);
		guideTitle.setHorizontalAlignment(0);
		this.add(guideTitle);
		
		//Combo Box
		fontCB.setFont(textF);
		fontCB.setForeground(darkC);
		fontCB.setBackground(lightC);
		fontCB.setSelectedItem("Arial");
		fontCB.setPreferredSize(new Dimension(130, 30));
		fontCB.addActionListener(this);
		fontStyleCB.setFont(textF);
		fontStyleCB.setForeground(darkC);
		fontStyleCB.setBackground(lightC);
		fontStyleCB.setSelectedItem("PLAIN");
		fontStyleCB.setPreferredSize(new Dimension(130, 30));
		fontStyleCB.addActionListener(this);
		
		//Spinner
		fontSizeS.setFont(textF);
		fontSizeS.setPreferredSize(new Dimension(50, 30));
		fontSizeS.setValue(22);
		fontSizeS.addChangeListener(e->
			textArea.setFont(new Font(textArea.getFont().getFamily(),textArea.getFont().getStyle(),(int) fontSizeS.getValue())));
		
		//Buttons
		colorBtn.setFocusable(false);
		colorBtn.addActionListener(this);
		colorBtn.setBackground(lightC);
		colorBtn.setForeground(darkC);
		colorBtn.setFont(btnF);
		colorBtn.setPreferredSize(new Dimension(120, 40));
		rtlText.setFocusable(false);
		rtlText.addActionListener(this);
		rtlText.setBackground(lightC);
		rtlText.setForeground(darkC);
		rtlText.setFont(btnF);
		rtlText.setPreferredSize(new Dimension(130, 40));
		cutText.setFocusable(false);
		cutText.addActionListener(this);
		cutText.setBackground(lightC);
		cutText.setForeground(darkC);
		cutText.setFont(btnF);
		cutText.setPreferredSize(new Dimension(80, 50));
		copyText.setFocusable(false);
		copyText.addActionListener(this);
		copyText.setBackground(lightC);
		copyText.setForeground(darkC);
		copyText.setFont(btnF);
		copyText.setPreferredSize(new Dimension(90, 50));
		pasteText.setFocusable(false);
		pasteText.addActionListener(this);
		pasteText.setBackground(lightC);
		pasteText.setForeground(darkC);
		pasteText.setFont(btnF);
		pasteText.setPreferredSize(new Dimension(100, 50));
		toUpper.setFocusable(false);
		toUpper.addActionListener(this);
		toUpper.setBackground(lightC);
		toUpper.setForeground(darkC);
		toUpper.setFont(btnF);
		toUpper.setPreferredSize(new Dimension(110, 50));
		toLower.setFocusable(false);
		toLower.addActionListener(this);
		toLower.setBackground(lightC);
		toLower.setForeground(darkC);
		toLower.setFont(btnF);
		toLower.setPreferredSize(new Dimension(110, 50));
		spongebob.setFocusable(false);
		spongebob.addActionListener(this);
		spongebob.setBackground(lightC);
		spongebob.setForeground(darkC);
		spongebob.setFont(btnF);
		spongebob.setPreferredSize(new Dimension(120, 50));
		toTitle.setFocusable(false);
		toTitle.addActionListener(this);
		toTitle.setBackground(lightC);
		toTitle.setForeground(darkC);
		toTitle.setFont(btnF);
		toTitle.setPreferredSize(new Dimension(100, 50));
		stripText.setFocusable(false);
		stripText.addActionListener(this);
		stripText.setBackground(lightC);
		stripText.setForeground(darkC);
		stripText.setFont(btnF);
		stripText.setPreferredSize(new Dimension(100, 50));
		
		//Add to top Panel
		topRow.add(fontName);
		topRow.add(fontCB);
		topRow.add(fontStyle);
		topRow.add(fontStyleCB);
		topRow.add(fontSize);
		topRow.add(fontSizeS);
		topRow.add(colorBtn);
		topRow.add(rtlText);
		
		//Add to bottom Panel
		bottomRow.add(cutText);
		bottomRow.add(copyText);
		bottomRow.add(pasteText);
		bottomRow.add(toUpper);
		bottomRow.add(toLower);
		bottomRow.add(toTitle);
		bottomRow.add(spongebob);
		bottomRow.add(stripText);
		
		//MenuBar
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(e->System.exit(0));
		getHelp.addActionListener(e->JOptionPane.showMessageDialog(null, "• Cut: cut all text.\n"
				+ "• Copy: copy all text.\n"
				+ "• Paste: paste the copied text.\n"
				+ "• Upper: change all text charcater to uppercase.\n"
				+ "• Lower: change all text charcater to lowercase.\n"
				+ "• Title: change the text to correctly case.\n"
				+ "• Sponge: change the text to SpOnGeBoB style.\n"
				+ "• Strip: remove the white spaces.\n", "HELP", 1));
		about.addActionListener(e->JOptionPane.showMessageDialog(null, "Credit with LOVE by MhmdSAbdlh ©", "ABOUT", 1));
		file.add(open);
		file.add(save);
		file.add(exit);
		help.add(getHelp);
		help.add(about);
		mb.add(file);
		mb.add(help);
		
		//Add to frame
		this.setJMenuBar(mb);
		this.add(taScroll);
		this.add(topRow);
		this.add(bottomRow);
		this.add(guide);
		this.setVisible(true);
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Font Name Choose
		if(e.getSource() == fontCB)
			textArea.setFont(new Font((String) fontCB.getSelectedItem(),textArea.getFont().getStyle(),textArea.getFont().getSize()));

		//Font Style Choose
		if(e.getSource() == fontStyleCB)
			textArea.setFont(new Font(textArea.getFont().getFamily(),(int) fontStyleCB.getSelectedIndex(),textArea.getFont().getSize()));	

		//Text Color Choose	
		if(e.getSource() == colorBtn)
			textArea.setForeground(fontColor.showDialog(null, "Choose a Color", Color.black));

		//Copy All Text
		if(e.getSource() == copyText) {
			textArea.selectAll();
			textArea.copy();
		}

		//Right to left and inverse
		if(e.getSource() == rtlText) {
				textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				textArea.setText(textArea.getText().toLowerCase());
				engToArabic();
			}
		
		//Cut All Text
		if(e.getSource() == cutText) {
			textArea.selectAll();
			textArea.cut();
		}
		
		//Paste copied text
		if(e.getSource() == pasteText)
			textArea.paste();
			
		//Text to UPPERCASE
		if(e.getSource() == toUpper)
			textArea.setText(textArea.getText().toUpperCase());
		
		//Remove white space
		if(e.getSource() == stripText)
			textArea.setText(textArea.getText().strip());
		
		//Text to LOWERCASE
		if(e.getSource() == toLower)
			textArea.setText(textArea.getText().toLowerCase());
		
		//Text to TitleCase
		if(e.getSource() == toTitle) {
			int i=0;
			char x = textArea.getText().charAt(i);
			char[] textC = textArea.getText().toCharArray();
			textC[i] = Character.toUpperCase(x);
			while(i<textArea.getSelectionEnd()-2) {
				if(x == '.' || x == '\n' || x == '?' || x == '!') {
					while(textC[i+1] == ' ' && i<textArea.getSelectionEnd()-2)
						i++;
					x = textArea.getText().charAt(i+1);
					textC[i+1] = Character.toUpperCase(x);
				}
				else {
					x = textArea.getText().charAt(i+1);
					textC[i+1] = Character.toLowerCase(x);
					}
				i++;
			}
			textArea.setText(String.valueOf(textC));	
		}
		
		//SPONGEBOB Style
		if(e.getSource() == spongebob) {
			int i=0;
			char x;
			char[] textC = textArea.getText().toCharArray();
			while(i<textArea.getSelectionEnd()) {
				if((i+2)%2 == 0) {
					x = textArea.getText().charAt(i);
					textC[i] = Character.toUpperCase(x);
				}
				else {
					x = textArea.getText().charAt(i);
					textC[i] = Character.toLowerCase(x);
					}
				i++;
			}
			textArea.setText(String.valueOf(textC));
		}
		
		//OPEN FILES
		if(e.getSource() == open) {
			JFileChooser fileChooser = new JFileChooser(new File(""));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text .txt", "txt");
			fileChooser.setFileFilter(filter);
			int response = fileChooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner openFile=null;
				try {
					openFile = new Scanner(file);
					if(file.isFile())
						textArea.setText("");
						while(openFile.hasNextLine()) {
							String line = openFile.nextLine()+"\n";
							textArea.append(line);
						}
				} catch (FileNotFoundException e1) {}
				finally{openFile.close();}
			}
		}
		
		//SAVE FILE
		if(e.getSource() == save) {
			JFileChooser fileChooser = new JFileChooser(new File(""));
			int response = fileChooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				PrintWriter pWriter = null;
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					pWriter = new PrintWriter(file);
					pWriter.println(textArea.getText());
				} catch (FileNotFoundException e1) {}
				finally {pWriter.close();}
			}
		}
	}

	private void engToArabic() {
		
		char[] toArabic = textArea.getText().toCharArray();
		
		for(int i=0;i<toArabic.length;i++) {
			if(i<toArabic.length-1){//IF0
				//IF1
				if((i ==0 && toArabic[i] =='a') || 
					(toArabic[i] == 'a' && toArabic[i-1] == ' ' && i>0) ||
					(toArabic[i] == 'a' && toArabic[i+1] == ' ')||
					(toArabic[i] == 'a' && toArabic[i+1] == 'a')||
					(i == 0 && toArabic[i] =='e') ||
					(toArabic[i] == 'e' && toArabic[i-1] == ' ' && i>0)||
					(i == 0 && toArabic[i] =='i') ||
					(toArabic[i] == 'i' && toArabic[i-1] == ' ' && i>0))
						toArabic[i] = 'ا';
				else//ELSE1
					if(toArabic[i] == 'g' && toArabic[i+1] == 'h'){//IF2
						toArabic[i] = 'غ';
						toArabic[i+1] = 'َ';
					}		
					else//ELSE2
						if((toArabic[i] == 'c' && toArabic[i+1] == 'h') ||//IF3
								(toArabic[i] == 's' && toArabic[i+1] == 'h')) {
								toArabic[i] = 'ش';
								toArabic[i+1] = 'َ';
							}
							else//ELSE3
								if((toArabic[i] == 'e' && toArabic[i+1] == 'i')||//IF4
									(toArabic[i] == 'i' && toArabic[i+1] == 'e')||
									(toArabic[i] == 'y' && toArabic[i+1] == 'e')||
									(toArabic[i] == 'e' && toArabic[i+1] == 'e')){
										toArabic[i] = 'ي';
										toArabic[i+1] = 'ْ';
									}
								else
									if(toArabic[i] == 'k' && toArabic[i+1] == 'h') {
										toArabic[i] = 'خ';
										toArabic[i+1] = 'َ';
									}
									else
										if((toArabic[i] == 'e' && toArabic[i+1] == ' ')||
											(toArabic[i] == 'i' && toArabic[i+1] == ' ')) {
											toArabic[i] = 'ي';
											toArabic[i+1] = ' ';
										}
										else//ELSE4
											engToArLetters(toArabic, i);
				}
			else
				if(i==toArabic.length-1)
					if(toArabic[i] == 'e' || toArabic[i] == 'i')
						toArabic[i] = 'ي';
					else
						if(toArabic[i] == 'a')
							toArabic[i] = 'ا';
						else
							engToArLetters(toArabic,i);
				else
					engToArLetters(toArabic, i);
		}
		textArea.setText(String.valueOf(toArabic));
		}

	private void engToArLetters(char[] toArabic, int i) {
		switch (toArabic[i]) {
		case 'q':
			toArabic[i] = 'ك';
			break;
		case 'w':
			toArabic[i] = 'و';
			break;
		case 'e':
			toArabic[i] = 'َ';
			break;
		case 'r':
			toArabic[i] = 'ر';
			break;
		case 't':
			toArabic[i] = 'ت';
			break;
		case 'y':
			toArabic[i] = 'ي';
			break;
		case 'u':
			toArabic[i] = 'ي';
			break;
		case 'i':
			toArabic[i] = 'ي';
			break;
		case 'o':
			toArabic[i] = 'و';
			break;
		case 'p':
			toArabic[i] = 'ب';
			break;
		case 'a':
			toArabic[i] ='َ';
			break;
		case 's':
			toArabic[i] = 'س';
			break;
		case 'd':
			toArabic[i] = 'د';
			break;
		case 'f':
			toArabic[i] = 'ف';
			break;
		case 'g':
			toArabic[i] = 'غ';
			break;
		case 'h':
			toArabic[i] = 'ه';
			break;
		case 'j':
			toArabic[i] = 'ج';
			break;
		case 'k':
			toArabic[i] = 'ك';
			break;
		case 'l':
			toArabic[i] = 'ل';
			break;
		case 'z':
			toArabic[i] = 'ز';
			break;
		case 'c':
			toArabic[i] = 'س';
			break;
		case 'v':
			toArabic[i] = 'ف';
			break;
		case 'b':
			toArabic[i] = 'ب';
			break;
		case 'n':
			toArabic[i] = 'ن';
			break;
		case 'm':
			toArabic[i] = 'م';
			break;
		case '?':
			toArabic[i] = '؟';
			break;
		case '2':
			toArabic[i] = 'أ';
			break;
		case '3':
			toArabic[i] = 'ع';
			break;
		case '5':
			toArabic[i] = 'خ';
			break;
		case '7':
			toArabic[i] = 'ح';
			break;
		case '8':
			toArabic[i] = 'غ';
			break;
		case '6':
			toArabic[i] = 'ط';
			break;
		case '9':
			toArabic[i] = 'ص';
			break;
		case '4':
			toArabic[i] = 'ض';
			break;
		case '1':
			toArabic[i] = 'ظ';
			break;
		case '0':
			toArabic[i] = 'ذ';
			break;
		default:
			break;
			}
	}
}
