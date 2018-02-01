package projectview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;

import project.Memory;
import project.ParityCheckException;
import project.CodeAccessException;
import project.DivideByZeroException;
import project.IllegalInstructionException;
import project.MachineModel;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewMediator extends Observable {
	private MachineModel model;
	private JFrame frame;
	private StepControl stepControl;
	private CodeViewPanel codeViewPanel;
	private MemoryViewPanel memoryViewPanel1;
	private MemoryViewPanel memoryViewPanel2;
	private MemoryViewPanel memoryViewPanel3;
	private ControlPanel controlPanel;
	private ProcessorViewPanel processorPanel;
	private States currentState = States.NOTHING_LOADED;
	private FilesMgr filesMgr;
	private MenuBarBuilder menuBuilder;

	public MachineModel getModel() {
		return model;
	}

	public void setModel(MachineModel model) {
		this.model = model;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setCurrentState(States s) {
		if(s == States.PROGRAM_HALTED) stepControl.setAutoStepOn(false);		
		currentState = s;
		s.enter();		
		setChanged();
		notifyObservers();
	}

	public States getCurrentState() {
		return currentState;
	}

	private void createAndShowGUI() {
		stepControl = new StepControl(this);
		filesMgr = new FilesMgr(this);
		filesMgr.initialize();
		codeViewPanel = new CodeViewPanel(this, model);
		memoryViewPanel1 = new MemoryViewPanel(this, model, 0, 160);
		memoryViewPanel2 = new MemoryViewPanel(this, model, 160, Memory.DATA_SIZE/2);
		memoryViewPanel3 = new MemoryViewPanel(this, model, Memory.DATA_SIZE/2, Memory.DATA_SIZE);
		controlPanel = new ControlPanel(this);
		processorPanel = new ProcessorViewPanel(this, model);
		menuBuilder = new MenuBarBuilder(this);
		frame = new JFrame("Simulator");
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(menuBuilder.createFileMenu());
		bar.add(menuBuilder.createExecuteMenu());

		Container content = frame.getContentPane(); 
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.BLACK);
		frame.setSize(1200,600);
		frame.add(codeViewPanel.createCodeDisplay(), BorderLayout.LINE_START);
		frame.add(processorPanel.createProcessorDisplay(),BorderLayout.PAGE_START);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,3));
		center.add(memoryViewPanel1.createMemoryDisplay());
		center.add(memoryViewPanel2.createMemoryDisplay());
		center.add(memoryViewPanel3.createMemoryDisplay());
		frame.add(center, BorderLayout.CENTER);
		frame.add(controlPanel.createControlDisplay(), BorderLayout.PAGE_END);
		// the next line will be commented or deleted later
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(WindowListenerFactory.windowClosingFactory(e -> exit()));
		frame.setLocationRelativeTo(null);
		stepControl.start();
		currentState.enter();
		setChanged();
		notifyObservers();
		frame.setVisible(true);

	}

	public void step() { 
		if (currentState != States.PROGRAM_HALTED && 
				currentState != States.NOTHING_LOADED) {
			try {
				model.step();
			} catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());			
			} catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(NullPointerException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(ParityCheckException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(IllegalInstructionException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(DivideByZeroException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			}
			setChanged();
			notifyObservers();
		}
	}

	public void clear(){
		model.clear();
		setCurrentState(States.NOTHING_LOADED);
		currentState.enter();
		setChanged();
		notifyObservers("Clear");
		model.setProgramSize(0);
	}

	public void toggleAutoStep(){
		stepControl.toggleAutoStep();
		if(stepControl.isAutoStepOn()) setCurrentState(States.AUTO_STEPPING);
		else setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
	}

	public void reload() throws FileNotFoundException, IOException{
		stepControl.setAutoStepOn(false);
		clear();
		filesMgr.finalLoad_ReloadStep();
	}

	public void setPeriod(int value){
		stepControl.setPeriod(value);
	}

	public void makeReady(String s) {
		stepControl.setAutoStepOn(false);
		setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
		currentState.enter();
		setChanged();
		notifyObservers(s);
		//model.setProgramSize(0);
	}
	public void execute() {
		while (currentState != States.PROGRAM_HALTED && 
				currentState != States.NOTHING_LOADED) {
			try {
				model.step();
			} catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());			
			} catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(NullPointerException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(ParityCheckException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(IllegalInstructionException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			} catch(DivideByZeroException e) {
				JOptionPane.showMessageDialog(frame, 
						"Illegal access to code from line " + model.getPC() + "\n"
								+ "Exception message: " + e.getMessage(),
								"Run time error",
								JOptionPane.OK_OPTION);
				System.out.println("Illegal access to code from line " + model.getPC()); // just for debugging
				System.out.println("Exception message: " + e.getMessage());	
			}
		}
		setChanged();
		notifyObservers();
	}
	public void assembleFile() { 
		filesMgr.assembleFile();
	}
	public void loadFile() throws FileNotFoundException, IOException {
		filesMgr.loadFile();
	}
	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewMediator mediator = new ViewMediator();
				MachineModel model = 
						new MachineModel(true, () -> 
						mediator.setCurrentState(States.PROGRAM_HALTED));
				mediator.setModel(model);
				mediator.createAndShowGUI();
			}
		});
	}

}
