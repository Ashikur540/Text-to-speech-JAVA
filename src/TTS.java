
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.scene.paint.Color.color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ashikur Rahman
 */
public class TTS extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTextArea ta;
    JLabel l1, l2, l3, lp;
    JPanel p;
    JScrollPane sc;
    ImageIcon img;

    TTS() {
        components();
    }

    public void components() {
        setLayout(null);
        p = new JPanel();
        p.setBackground(Color.ORANGE);
        p.setBounds(0, 0, 570, 75);
        add(p);

        ImageIcon img = new ImageIcon("microphone.png");
        lp = new JLabel();
        lp.setBounds(17, 9, 330, 95);
        lp.setIcon(img);
        p.add(lp);

        l1 = new JLabel("TEXT TO SPEECH");
        l1.setBounds(55, 50, 480, 40);
        l1.setFont(new Font("Montserrat", Font.BOLD, 20));
        l1.setForeground(Color.DARK_GRAY);
        p.add(l1);

        l2 = new JLabel("© ASHIKUR RAHMAN");
        l2.setBounds(0, 0, 70, 40);
        l2.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        l2.setForeground(Color.darkGray);
        p.add(l2);

        l3 = new JLabel("Type your text here:");
        l3.setBounds(30, 74, 170, 40);
        l3.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 13));
        l3.setForeground(Color.BLACK);
        add(l3);

        ta = new JTextArea();
        ta.setBounds(30, 110, 490, 300);
        ta.setBorder(BorderFactory.createBevelBorder(1));
        ta.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        sc = new JScrollPane(ta);
        sc.setBounds(30, 110, 490, 300);
        add(sc);//adding scrollpane to text area

        b1 = new JButton("Speak");
        b1.setBackground(Color.pink);
        b1.setForeground(Color.BLACK);
        b1.setBounds(40, 465, 70, 30);
        add(b1);

        b2 = new JButton("Clear");
        b2.setBackground(Color.pink);
        b2.setForeground(Color.BLACK);
        b2.setBounds(240, 465, 70, 30);
        add(b2);

        b3 = new JButton("Exit");
        b3.setBackground(Color.pink);
        b3.setForeground(Color.BLACK);
        b3.setBounds(430, 465, 70, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == b1) {
            
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice("kevin");
            voice.allocate();
            voice.speak(ta.getText());
            
//            ///audio
//            AudioPlayer aplayer;
//            aplayer = new SingleFileAudioPlayer
//        ("F:\\Java projects\\TextToSpeech\\voice", javax.sound.sampled.AudioFileFormat.Type.WAVE);
//            voice.setAudioPlayer(aplayer);
//            aplayer.close();

        } else if (e.getSource() == b2) {
            ta.setText("");
        } else if (e.getSource() == b3) {
//            dispose();
            int i = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "TTS Converter", JOptionPane.YES_NO_CANCEL_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);

            } else{
                System.out.print("you select no");
            }

        }

    }

    public static void main(String[] args) {
        TTS frame = new TTS();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(570, 570);
        frame.setLocation(550, 140);
    }

}
