/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author omarc
 */
public class PrincipalFrame extends JFrame{
    JPanel p = new JPanel(null);
    JPanel pp = new JPanel(new GridLayout(4,5,7,10));
    JPanel ppp = new JPanel(new GridLayout(1,6,1,5));
    JPanel mpp = new JPanel(new GridLayout(13,1,5,5));
    JPanel mppp = new JPanel(new GridLayout(13,1,5,5));

    File f = new File("D:\\OMAR\\Documents\\NetBeansProjects\\DealONDeal\\src\\images\\dond_logo.png");
    JLabel l = new JLabel(new ImageIcon(f.getAbsolutePath()));
    JButton b[] = new JButton[26];
    JLabel moneyl[]= new JLabel[26];
    //Maletin seleccionado
    File fm = new File("D:\\OMAR\\Documents\\NetBeansProjects\\DealONDeal\\src\\images\\d.jpg");
    JLabel yb = new JLabel(new ImageIcon(fm.getAbsolutePath()));
    JLabel l1 = new JLabel("  Maletín");
    JLabel l2 = new JLabel("Escoge un maletín.");
    
    public PrincipalFrame() {
        setVentana();
        add(p);
        p.setBackground(Color.decode("#FBFCFC"));
        p.add(l); l.setBounds(0, 0, 1000, 150);
        p.add(pp);
        p.add(ppp);

        yb.setBounds(26, 550, 100, 80);
        yb.setHorizontalTextPosition(SwingConstants.CENTER);
        yb.setForeground(Color.WHITE);
        yb.setFont(new Font("Arial", Font.BOLD, 80));

        p.add(l2);
        l2.setBounds(250, 580, 500, 20);
        l2.setForeground(Color.BLACK);
        l2.setHorizontalAlignment( SwingConstants.CENTER );
        l2.setFont(new Font("Arial", Font.BOLD, 20));

        pp.setBounds(226, 160, 550, 280);
        ppp.setBounds(170, 445, 660, 90);
        pp.setBackground(Color.decode("#FBFCFC"));
        ppp.setBackground(Color.decode("#FBFCFC"));
		
        p.add(mpp);
        p.add(mppp);
        mpp.setBounds(5, 115, 150, 430);
        mppp.setBounds(845, 115, 150, 430);
        //COLORES DE PANELES LATERALES
        mpp.setBackground(Color.decode("#FDD835"));
        mppp.setBackground(Color.decode("#FDD835"));

        firstaction fa = new firstaction();
		
        for(int i=0;i<26;i++){
            b[i]=new JButton(Integer.toString(i+1));
            File fm = new File("D:\\OMAR\\Documents\\NetBeansProjects\\DealONDeal\\src\\images\\B2.png");
            b[i].setIcon(new ImageIcon(fm.getAbsolutePath()));
            b[i].setBackground(Color.white);
            b[i].setHorizontalTextPosition(SwingConstants.CENTER);
            b[i].setBorderPainted(false);
            b[i].setFont(new Font("Arial", Font.BOLD, 60));
            b[i].addActionListener(fa);
            if(i<=19){pp.add(b[i]);}
            else{ppp.add(b[i]);}

            moneyl[i]=new JLabel(Double.toString(oferta[i]),new ImageIcon(""),JLabel.CENTER);
            moneyl[i].setIconTextGap(-110);
            moneyl[i].setFont(new Font("Arial", Font.BOLD, 20));
            if(i<13){mpp.add(moneyl[i]);}
            else{mppp.add(moneyl[i]);}
        }
        
        Random rnd = new Random();
	for (int i=oferta.length-1;i>0;i--){
            int index = rnd.nextInt(i + 1);
            double a = oferta[index];
            oferta[index] = oferta[i];
            oferta[i] = a;
	}
	    
    }
     public void setVentana() {
        super.setTitle("Deal or No Deal");
        super.setVisible(true);
        super.setSize(1000,700);
        super.setSize(1000,700);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBackground(Color.WHITE);
    }
    
    String noCaja="";
    double dinero[] = {0.01,1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
    double oferta[] = {0.01,1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
    int indicator=0;
    int indicator2=0;
    double valores=0;
    double ofertaBanca=0;
    int ronda=0;
    double maleta=0;
	///CLASE NUEVA 
	public class firstaction implements ActionListener{
		
		public void actionPerformed (ActionEvent e){
			
			// player selecting own case
			if(noCaja.isEmpty()){
				
				for(int i=0;i<26;i++){
					if(e.getSource()==b[i]){noCaja=Integer.toString(i+1);}
				}
				
				String yesorno[] = {"SI","No"};
				int prompt = JOptionPane.showOptionDialog(null,"Seleccionaste el maletìn #"+noCaja+"?","¿Estas de acuerdo?",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, yesorno,yesorno[1]);
				
				if(prompt==JOptionPane.YES_OPTION){
					
					p.add(yb);yb.setText(noCaja);
					
					for(int i=0;i<26;i++){
						if(e.getSource()==b[i]){b[i].setEnabled(false);b[i].setVisible(false);}
					}
					
					p.add(l1);l1.setBounds(50, 630, 100, 15);
					l2.setText("abre 6 maletines mas!");
					
				}
				
				else{noCaja="";}
			
			}
			
			// player opening cases
			else{
				
				indicator= indicator+1;indicator2=indicator2-1;
				if(indicator<25){
					
					for(int i=0;i<26;i++){
						if(e.getSource()==b[i]){
							JOptionPane.showMessageDialog(null, "Maletìn #"+Integer.toString(i+1)+" Contiene $"+ oferta[i],"Maletìn #"+Integer.toString(i+1), JOptionPane.DEFAULT_OPTION);
							b[i].setEnabled(false);b[i].setVisible(false);
							maleta = oferta[i];
							oferta[i]=0;
							l2.setText("te faltan por abrir "+Integer.toString(indicator2-ronda)+" maletines!");
						}
					}
					for(int i=0;i<26;i++){
						if(dinero[i]==maleta){
							moneyl[i].setIcon(null);
						}
					}
					
				}
				
				// banker giving offers
				if(indicator==6||indicator==11||indicator==15||indicator==18||indicator==20||indicator==21||indicator==22||indicator==23||indicator==24){
					
					l2.setText("La oferta de la banca es!!");
					ronda=ronda+1;
					
					for(int i=0;i<26;i++){valores=valores+oferta[i];}
					ofertaBanca=valores/(26-indicator)*ronda/10;
					
					String dond[] = {"ACEPTAR","RECHAZAR"};
					int prompt = JOptionPane.showOptionDialog(null,"La banca te ofrece $"+Double.toString(Math.round(ofertaBanca*100.0)/100.0)+"","",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/dond/images/moneybag.png"), dond,dond[1]);
					
					if(prompt==JOptionPane.YES_OPTION){
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("D:\\OMAR\\Documents\\NetBeansProjects\\DealONDeal\\src\\images\\B2.png"));moneyl[i].setText(Double.toString(Math.round(ofertaBanca*100.0)/100.0));}
						JOptionPane.showMessageDialog(null, "FELICIDADES! \n Te llevas $"+Double.toString(Math.round(ofertaBanca*100.0)/100.0),"Felicidades", JOptionPane.DEFAULT_OPTION, new ImageIcon("src/dond/images/money.png"));
						JOptionPane.showMessageDialog(null, "Pudiste haber ganado $"+Double.toString(oferta[Integer.parseInt(noCaja)-1]),"Maletin #"+noCaja, JOptionPane.DEFAULT_OPTION, new ImageIcon("src/dond/images/dondbc.jpg"));
						System.exit(0);
					}
					else{valores=0;}
					indicator2=6;
					if(ronda<5){l2.setText("Abrir solo "+Integer.toString(indicator2-ronda)+" maletines!");}
					else{l2.setText("Abre un maletin!");}
					
				}
				
				//last case
				if(indicator==25){
					
					l2.setText("Uno mas!!");
					
					String yesorno[] = {"Si","No"};
					int prompt = JOptionPane.showOptionDialog(null,"¿Quieres quedarte con tu maletin?","Aceptas?",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,yesorno,yesorno[1]);
					
					if(prompt==JOptionPane.YES_OPTION){
						
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("C:/Users/Orchid.M/Desktop/moneyp.jpg"));moneyl[i].setText(Double.toString(oferta[Integer.parseInt(noCaja)-1]));}
						JOptionPane.showMessageDialog(null, "Felicidades, te llevas  $" + Double.toString(oferta[Integer.parseInt(noCaja)-1]),"", JOptionPane.DEFAULT_OPTION, new ImageIcon("src/dond/images/money.png"));
						
					}
					else{
						
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("C:/Users/Orchid.M/Desktop/moneyp.jpg"));moneyl[i].setText(Double.toString(oferta[indicator]));}
						for(int i=0;i<26;i++){if(e.getSource()==b[i]){
							JOptionPane.showMessageDialog(null, "Felicidades, te llevas $" + Double.toString(oferta[i])," ", JOptionPane.DEFAULT_OPTION, new ImageIcon("src/dond/images/money.png"));indicator=i;
						}}
						
					}

					
					System.exit(0);
					
				}
				
			}
			
		}
		
	}
    
    
    
    
   
    
    
}
