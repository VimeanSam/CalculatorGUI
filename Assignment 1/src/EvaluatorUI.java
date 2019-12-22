import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();
  Evaluator calcEvaluator = new Evaluator();
  String x = ""; //will be used to push operands and operators into Evaluator.java to calculate result
  // total of 20 buttons on the calculator,
  // numbered from left to right, top to bottom
  // bText[] array contains the text for corresponding buttons
  private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[ bText.length ];
 
  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {
    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent arg0 ) {
      
      if (arg0.getSource() == buttons[0]){
          txField.setText(txField.getText()+bText[0]);
          x = x + bText[0];
      }else if (arg0.getSource() == buttons[1]){
          txField.setText(txField.getText()+bText[1]);
          x = x + bText[1];
      }else if (arg0.getSource() == buttons[2]){
          txField.setText(txField.getText()+bText[2]);
          x = x + bText[2];
      }else if (arg0.getSource() == buttons[3]){
          txField.setText(txField.getText()+bText[3]);
          x = x + bText[3];
      }else if (arg0.getSource() == buttons[4]){
          txField.setText(txField.getText()+bText[4]);
          x = x + bText[4];
      }else if (arg0.getSource() == buttons[5]){
          txField.setText(txField.getText()+bText[5]);
          x = x + bText[5];
      }else if (arg0.getSource() == buttons[6]){
          txField.setText(txField.getText()+bText[6]);
          x = x + bText[6];
      }else if (arg0.getSource() == buttons[7]){
          txField.setText(txField.getText()+bText[7]);
          x = x + bText[7];
      }else if (arg0.getSource() == buttons[8]){
          txField.setText(txField.getText()+bText[8]);
          x = x + bText[8];
      }else if (arg0.getSource() == buttons[9]){
          txField.setText(txField.getText()+bText[9]);
          x = x + bText[9];
      }else if (arg0.getSource() == buttons[10]){
          txField.setText(txField.getText()+bText[10]);
          x = x + bText[10];
      }else if (arg0.getSource() == buttons[11]){
          txField.setText(txField.getText()+bText[11]);
          x = x + bText[11];
      }else if (arg0.getSource() == buttons[12]){
          txField.setText(txField.getText()+bText[12]);
          x = x + bText[12];
      }else if (arg0.getSource() == buttons[13]){
          txField.setText(txField.getText()+bText[13]);
          x = x + bText[13];
      }else if (arg0.getSource() == buttons[14]){
          txField.setText(Integer.toString(calcEvaluator.eval(x.substring(0, x.length()))));
          x = txField.getText();
      }else if (arg0.getSource() == buttons[15]){
          txField.setText(txField.getText()+bText[15]);
          x = x + bText[15];
      }else if (arg0.getSource() == buttons[16]){
          txField.setText(txField.getText()+bText[16]);
          x = x + bText[16];
      }else if (arg0.getSource() == buttons[17]){
          txField.setText(txField.getText()+bText[17]);
          x = x + bText[17];
      }else if (arg0.getSource() == buttons[18]){
          x = "";
      }else if (arg0.getSource() == buttons[19]){
          txField.setText(txField.getText().substring(0, txField.getText().length() - 1));
          x = txField.getText();
      }
    }
}