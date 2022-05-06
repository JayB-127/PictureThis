import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Test {
    public static void main ( String[] args )
{
    JPanel middlePanel = new JPanel ();
    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

    JTextArea display = new JTextArea ( 16, 58 );
    display.setEditable ( false ); // set textArea non-editable
    JScrollPane scroll = new JScrollPane ( display );
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

    JTextField txt = new JTextField(10);
    middlePanel.add(txt);

    JButton btn = new JButton("submit");
    btn.addActionListener(e -> {
        display.append(txt.getText());
    });
    middlePanel.add(btn);


    //Add Textarea in to middle panel
    middlePanel.add ( scroll );

    // My code
    JFrame frame = new JFrame ();
    frame.add ( middlePanel );
    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}
}
