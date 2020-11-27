import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
class IPFinder extends JFrame implements ActionListener{
    JLabel l;
    JTextField tf;
    JTextArea ta;
    JButton b;
    IPFinder(){
        super("CODED BY ROC7");
        l=new JLabel("Enter Website URL:");
        l.setBounds(50,70,150,20);;
        tf=new JTextField();
        tf.setBounds(50,100,200,20);
        b=new JButton("FIND OPEN PORTS");
        b.setBounds(100,150,180,30);
        b.addActionListener(this);
        ta=new JTextArea();
        JScrollPane sp=new JScrollPane(ta);
        sp.setBounds(50,200,350,250);
        add(l);
        add(tf);
        add(b);
        add(sp);
        setSize(800,600);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String url=tf.getText();
        int p=80;
        try {
            InetAddress ia=InetAddress.getByName(url);
            String ip=ia.getHostName();
            Socket sock=new Socket(ip,p);
            String bk="open port =";
            ta.setText(bk);
            //JOptionPane.showMessageDialog(this,ip+" is: "+p);
            sock.close();
        } catch (IOException ek) {
        }
    }
    public static void main(String[] args) {
        new IPFinder();
    }
}