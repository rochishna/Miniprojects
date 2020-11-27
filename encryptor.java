import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Encripter
{
  public String code(String s)
  {
    char charArr[] = s.toCharArray();
    for(int i=0;i<s.length();i++)
    {
		if(i%2 == 0)
          charArr[i] += 2;
        else
          charArr[i] += 7;
	}

	return new String(charArr);
 }
 public String decode(String s)
 {
	 char charArr[] = s.toCharArray();
	 for(int i=0;i<charArr.length;i++)
	 {
		 if(i%2 == 0)
		   charArr[i] -= 2;
		 else
		   charArr[i] -= 7;
     }
    return new String(charArr);
}
}
class jaffa extends Encripter{
    public static void main(String[] args) {
        final int[] i = {0};
        String data[]=new String[70];
        Encripter ec=new Encripter();
                JFrame f=new JFrame("Password Field Example");
                JPasswordField value = new JPasswordField();
                JLabel l1=new JLabel("Password:");
                JButton b6 =new JButton("ok");
                b6.setBounds(20,150,80,30);
                l1.setBounds(20,100, 80,30);
                value.setBounds(100,100,100,30);
                f.add(value);  f.add(l1);
                f.add(b6);
                f.setSize(300,300);
                f.setLayout(null);
                f.setVisible(true);
                b6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        char[] kl=value.getPassword();
                        JFrame f=new JFrame("CRYPTO CHAT");
                        final JLabel label = new JLabel();
                        label.setBounds(20,150, 200,500);
                        final JPasswordField value = new JPasswordField();
                        value.setBounds(100,75,100,30);
                        JLabel l1=new JLabel("ENTER TEXT");
                        l1.setBounds(20,20, 180,30);
                        JLabel l2=new JLabel("KEY");
                        l2.setBounds(20,75, 80,30);
                        JButton b = new JButton("ENCODE");
                        JButton b2=new JButton("DECODE");
                        JButton b3=new JButton("CHANGE KEY");
                        b2.setBounds(100,160,80,30);
                        b.setBounds(100,120, 80,30);
                        b3.setBounds(100,200,95,30);
                        final JTextField text = new JTextField();
                        text.setBounds(100,20, 100,30);
                        f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);
                        f.setSize(500,600);
                        f.add(b2);
                        f.add(b3);
                        f.setLayout(null);
                        f.setVisible(true);
                        b3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame f=new JFrame("Password Field Example");
                                final JLabel label = new JLabel();
                                label.setBounds(20,150, 200,50);
                                final JPasswordField value = new JPasswordField();
                                value.setBounds(100,75,100,30);
                                JLabel l1=new JLabel("old password");
                                l1.setBounds(20,20, 80,30);
                                JLabel l2=new JLabel("new Password:");
                                l2.setBounds(20,75, 80,30);
                                JButton b = new JButton("reset");
                                b.setBounds(100,120, 80,30);
                                final JTextField text = new JTextField();
                                text.setBounds(100,20, 100,30);
                                f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);
                                f.setSize(300,300);
                                f.setLayout(null);
                                f.setVisible(true);
                                b.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        char[] sty=value.getPassword();
                                        kl[0]=sty[0];
                                    }
                                });
                            }
                        });
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int i1 = i[0]++;
                                data[i1] =text.getText();
                                String ans=ec.code(data[i1]);
                                label.setText(ans);
                            }
                        });
                        b2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int i2= i[0]++;
                                char[] dat=value.getPassword();
                                data[i2] =text.getText();
                                if(kl[0]==dat[0]){
                                    String ans=ec.decode(data[i2]);
                                    label.setText(ans);
                                }
                                else{
                                    label.setText("ERROR");
                                }

                            }
                        });
                    }
                });

    }
}