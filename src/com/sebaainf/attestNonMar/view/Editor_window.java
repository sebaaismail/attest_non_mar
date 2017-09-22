package com.sebaainf.attestNonMar.view;

import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.value.Trigger;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.forms.layout.LayoutMap;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.view.ValidationResultViewFactory;
import com.sebaainf.attestNonMar.common.MyCommonUtils;
import com.sebaainf.attestNonMar.common.ReportView;
import com.sebaainf.attestNonMar.common.ReportedBean;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.model.AttestEditorModel;
import com.sebaainf.ismUtils.*;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EventObject;

/**
 * Created by ${sebaainf.com} on 22/10/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class Editor_window extends IsmAbstractJFrame {

    private static Editor_window uniqueInstance;
    private boolean add_mode = true;


    private ValidationResultModel validationResultModel = new DefaultValidationResultModel();
    private JComponent messageLabel = ValidationResultViewFactory.createReportList(validationResultModel);

    private AttestEditorModel 	attestModel;


    public JTextField commune = new JTextField();
    private JTextField daira = new JTextField();
    private JTextField wilaya= new JTextField(); 
        
    private JTextField nom_cit;
    private JTextField prenom_cit;
    private JTextField nomFR_cit;
    private JTextField prenomFR_cit;
    
    private JDatePickerImpl date_naiss_cit;
    public JTextField comm_naiss_cit;
    public JTextField wil_naiss_cit;
    private JTextField lieu_naiss_cit;
    private JTextField adress_cit;
    
    private JTextField fullname_tem1;
    private JTextField fullname_tem2;
    private JFormattedTextField num_cni_tem1;
    private JTextField num_cni_tem2;
    private JDatePickerImpl datedeliv_cni_tem1;
    private JDatePickerImpl datedeliv_cni_tem2;
    private JTextField lieudeliv_cni_tem1;
    private JTextField lieudeliv_cni_tem2;
    
    private JTextField type_attest;
    private JDatePickerImpl date_attest;

    //private JLabel labelType;
    

    
    private JTextField fullname_conj1;
    private JTextField fullname_conj2;
    private JTextField fullname_conj3;
    private JTextField fullname_conj4;
    private JTextField fullname_dame;
    
    private JDatePickerImpl date_conj1;
    private JDatePickerImpl date_conj2;
    private JDatePickerImpl date_conj3;
    private JDatePickerImpl date_conj4;
    
    private JDatePickerImpl date_deces_conj;
    
    private JTextField num_mar;
    private JDatePickerImpl date_mar;
    private JTextField comm_mar;
    
    

//*******************************


   //TODO not verified pour sprint1
    protected JButton validerAddButton;
    protected JButton annulerButton;
    protected JButton imprimerButton;
    protected JButton annulerModifButton;


    //***************************************************************

    public Editor_window(AttestEditorModel attestModel) {
    	this(attestModel, true);
    }

    public Editor_window(AttestEditorModel attestModel, boolean add_mode) {

    	this.add_mode = add_mode;
        int idat = ((Attest)(attestModel.getBean())).getId_attest();

        // check if mode is add new attest 
      //TODO not verified pour sprint1
        //maybe set add_mod false for sprint1
        if ((idat <= 0)) {
        //if (idc <= 0) {
            this.add_mode = true;
        }
        //TODO after search engine must handle the add_mode
        //this.add_mode = false; // for offline without db

        this.attestModel = attestModel;
        initComponents();
        configContent();

    }


    protected void initComponents() {

        // initializer les buttons

        validerAddButton = new JButton();
        annulerButton = new JButton("Annuler");
        imprimerButton = new JButton("Imprimer");
        annulerModifButton = new JButton("Annuler Modif");
        //labelType = new JLabel("بتاريخ :");

        if (this.add_mode) {
            validerAddButton.setText("Ajouter");
            annulerButton.setVisible(false);
            imprimerButton.setEnabled(false);
            annulerModifButton.setVisible(false);

        } else {
            validerAddButton.setText("Valider");
            //TODO handle this when add database
            //imprimerButton.setEnabled(false);
            annulerModifButton.setEnabled(false);
        }



        this.setTitle("Application d'Attestion non mariage                        " +
                "                                                           " +
                "                                               Boufatis©2017");

        commune.setText("بوفاطيس");
        daira.setText("وادي تليلات");
        wilaya.setText("وهران");
        commune.setEnabled(false);
        daira.setEnabled(false);
        wilaya.setEnabled(false);
        
        nom_cit = IsmComponentFactory.createArabTextField(attestModel.getNom_cit());
        prenom_cit = IsmComponentFactory.createArabTextField(attestModel.getPrenom_cit());
        nomFR_cit = IsmComponentFactory.createArabTextField(attestModel.getNomFR_cit());
        prenomFR_cit = IsmComponentFactory.createArabTextField(attestModel.getPrenomFR_cit());
     // Binding jdatepicker with dateNaiss
        date_naiss_cit = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_NAISS_CIT, "yyyy/MM/dd");
        
        comm_naiss_cit = IsmComponentFactory.createArabTextField(attestModel.getComm_naiss_cit());
        wil_naiss_cit = IsmComponentFactory.createArabTextField(attestModel.getWil_naiss_cit());
        lieu_naiss_cit = IsmComponentFactory.createArabTextField(attestModel.getLieu_naiss_cit());
        adress_cit = IsmComponentFactory.createArabTextField(attestModel.getAdress_cit());
        
        fullname_tem1 = IsmComponentFactory.createArabTextField(attestModel.getFullname_tem1());
        fullname_tem2 = IsmComponentFactory.createArabTextField(attestModel.getFullname_tem2());

        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator(' ');
        
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(dfs);;
        //format.setGroupingUsed(false);
        
        
        num_cni_tem1 = IsmComponentFactory.createLongField(attestModel.getNum_cni_tem1(), format);
        num_cni_tem2 = IsmComponentFactory.createLongField(attestModel.getNum_cni_tem2(), format);
        
        
        datedeliv_cni_tem1 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATEDELIV_CNI_TEM1, "yyyy/MM/dd");
        datedeliv_cni_tem2 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATEDELIV_CNI_TEM2, "yyyy/MM/dd");
        lieudeliv_cni_tem1 = IsmComponentFactory.createArabTextField(attestModel.getLieudeliv_cni_tem1());
        lieudeliv_cni_tem2 = IsmComponentFactory.createArabTextField(attestModel.getLieudeliv_cni_tem2());
        
        type_attest = IsmComponentFactory.createArabTextField(attestModel.getType_attest());
        date_attest = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_ATTEST, "yyyy/MM/dd");
        //date_type_attest = IsmComponentFactory.createDatePickerImpl(attestModel,
          //      Attest.PROPERTY_DATE_TYPE_ATTEST, "yyyy/MM/dd");
        
        fullname_conj1 = IsmComponentFactory.createArabTextField(attestModel.getFullname_conj1());
        fullname_conj2 = IsmComponentFactory.createArabTextField(attestModel.getFullname_conj2());
        fullname_conj3 = IsmComponentFactory.createArabTextField(attestModel.getFullname_conj3());
        fullname_conj4 = IsmComponentFactory.createArabTextField(attestModel.getFullname_conj4());
        fullname_dame = IsmComponentFactory.createArabTextField(attestModel.getFullname_dame());
        
        date_conj1 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_CONJ1, "yyyy/MM/dd");
        date_conj2 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_CONJ2, "yyyy/MM/dd");
        date_conj3 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_CONJ3, "yyyy/MM/dd");
        date_conj4 = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_CONJ4, "yyyy/MM/dd");

        date_deces_conj = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_DECES_CONJ, "yyyy/MM/dd");
        
        num_mar = IsmComponentFactory.createIntegerField(attestModel.getNum_mar(), format);
        comm_mar = IsmComponentFactory.createArabTextField(attestModel.getComm_mar());
        date_mar = IsmComponentFactory.createDatePickerImpl(attestModel,
                Attest.PROPERTY_DATE_MAR, "yyyy/MM/dd");
        
/*        messageLabel.getComponent(1)
        .setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);*/
        ((JScrollBar) messageLabel.getComponent(1))
                .setAlignmentY(JScrollBar.RIGHT_ALIGNMENT);


    }


    protected JComponent buildContent() {

        nom_cit.setPreferredSize(date_naiss_cit.getPreferredSize());
        prenom_cit.setPreferredSize(date_naiss_cit.getPreferredSize());

        num_cni_tem1.setColumns(8);
        num_cni_tem2.setColumns(8);
        num_mar.setColumns(6);
        num_cni_tem1.setHorizontalAlignment(JTextField.RIGHT);
        num_cni_tem2.setHorizontalAlignment(JTextField.RIGHT);
        num_mar.setHorizontalAlignment(JTextField.RIGHT);
        
        num_mar.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {

				if (num_mar.getText().length() <= 0) {
					num_mar.setText("0");		
				}

				
			}
        	
        });


        //setting border
        for(JComponent comp:getListComponents()) {
            if (!comp.getClass().getSimpleName().equals("JDatePickerImpl"))
            comp.setBorder(BorderFactory.createEtchedBorder());
        }
/*
        ndiv_mar1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (ndiv_mar1.isSelected()) {

                }
            }
        });
//*/
        //ndiv_mar1 
        //nmar_dec2 
        //nmar_div3
//*/

        LayoutMap.getRoot().columnPut("label_ar", "left:pref");
        //LayoutMap.getRoot().columnPut("label_fr", "right:pref");

        //MyCommonUtils.setListComponentsEnabled(getListComponents(), true);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.add(editorNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(editorCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(southButtonsPanel(), BorderLayout.SOUTH);

        //checkTypeAttestComponents();

        ActionListener listenerRadio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checkTypeAttestComponents();
            }
        };


        MyCommonUtils.setListComponentsEnabled(getListComponents(),true);

        return mainPanel;
    }

    private JComponent editorNorthPanel() {
        JPanel northPan = new JPanel();
        northPan.setLayout(new GridBagLayout());
        northPan.setBackground(Color.white);

        
    	BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("files/pic.jpg"));
            myPicture = IsmFunctions.process(myPicture, "contact : sebaa.ismail@gmail.com               " +
                    "                               apc_boufatis©2017", northPan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        	
    	
    	JPanel pan =  FormBuilder.create()
        		.columns("pref")
        		.rows("p")
        		.add(picLabel).xy(1, 1)
        		.build();
    	northPan.add(pan);
        return northPan;
        		
    }
    
    private JComponent editorCenterPanel() {

        JScrollPane fullPanel = new JScrollPane(citEditorPanel());


        // thi code just for centring the JScrollPane in BorderLayout.Center
        // we will use GridBagLayout for the parent of the component inside it

        JViewport viewport = fullPanel.getViewport();
        ((JPanel)viewport.getView()).getParent().setLayout(new GridBagLayout());

        return fullPanel;

    }

    private JComponent citEditorPanel() {
    	int x = 1, y = 1;

        // Building citEditorPanel()


        return FormBuilder.create()
                //.debug(true)
                .columns("pref, $lcgap, $label_ar, $ugap ,pref, $lcgap, $label_ar, $ugap , pref,"
                		+ " $lcgap, $label_ar, $lcgap, $label_ar, $lcgap, $label_ar, $lcgap, $label_ar")
                .rows("p, $lgap, p, $lgap, p, $lgap, p, $lgap, p ,$lgap , p, $lgap,"       // for Citoyen Zone
                        + "p, $lgap, p, 6dlu, p, $lgap, p, $lgap, p, $lgap, p, $lgap, p, $pgap, p, $lgap, p")//for mention Zone
                //.columnGroups(new int[][]{{1, 5}})
                .padding(Paddings.DLU9)

                .add("الشاهد الأول :").xy(11, y)
                .add(fullname_tem1).xy(9, y)
                .add(" ب . ت  رقم :").xy(7, y)
                .add(num_cni_tem1).xy(5, y)
                .add(" الصادرة عن :").xy(11, y+2)
                .add(lieudeliv_cni_tem1).xy(9, y+2)
                .add(" بتاريخ :").xy(7, y+2)
                .add(datedeliv_cni_tem1).xy(5, y+2)
                
                .add("الشاهد الثاني :").xy(11, y+4)
                .add(fullname_tem2).xy(9, y+4)
                .add(" ب . ت  رقم :").xy(7, y+4)
                .add(num_cni_tem2).xy(5, y+4)
                .add(" الصادرة عن :").xy(11, y+6)
                .add(lieudeliv_cni_tem2).xy(9, y+6)
                .add(" بتاريخ :").xy(7, y+6)
                .add(datedeliv_cni_tem2).xy(5, y+6)


                .add("اللقب :").xy(11, y+8)
                .add(nom_cit).xy(9, y+8)
                .add("الإسم :").xy(7, y+8)
                .add(prenom_cit).xy(5, y+8)
                
                .add("المولودة في :").xy(3, y+8)
                .add(date_naiss_cit).xy(1, y+8)
                
                .add(": Nom").xy(11, y+10)
                .add(nomFR_cit).xy(9, y+10)
                .add(": Prenom").xy(7, y+10)
                .add(prenomFR_cit).xy(5, y+10)
                
                .add("بـ :").xy(11, y+12)
                .add(lieu_naiss_cit).xy(9, y+12)
                .add("بلدية :").xy(7, y+12)
                .add(comm_naiss_cit).xy(5, y+12)
                .add(" ولاية :").xy(3, y+12)
                .add(wil_naiss_cit).xy(1, y+12)
                
                .add(" الساكن بـ :").xy(11, y+14)
                .add(adress_cit).xyw(5, y+14, 5)

                .add("1/ لم تطلق منذ زواجها بالسيد :").xy(7, y+18)
                .add(fullname_conj1).xy(5, y+18)
                .add(" بتاريخ :").xy(3, y+18)
                .add(date_conj1).xy(1, y+18)
                
                .add("2/ لم تتزوج منذ وفاة زواجها السيد :").xy(7, y+20)
                .add(fullname_conj2).xy(5, y+20)
                .add(" المتوفي بتاريخ :").xy(3, y+20)
                .add(date_conj2).xy(1, y+20)
                
                .add("3/ لم تتزوج منذ طلاقها من السيد :").xy(7, y+22)
                .add(fullname_conj3).xy(5, y+22)
                .add(" بتاريخ :").xy(3, y+22)
                .add(date_conj3).xy(1, y+22)
                
                .add(" أن الزواج المنعقد في :").xy(11, y+24)
                .add(date_mar).xy(9, y+24)
                .add("ببلدية :").xy(7, y+24)
                .add(comm_mar).xy(5, y+24)
                .add(" تحت رقم :").xy(3, y+24)
                .add(num_mar).xy(1, y+24)
                
                //.add("وبين السيدة :").xy(7, y+26)
                //.add(fullname_dame).xy(5, y+26)
                
                .add("اسم ولقب الزوج :").xy(7, y+26)
                .add(fullname_conj4).xy(5, y+26)
                .add(" المتوفي في :").xy(3, y+26)
                .add(date_conj4).xy(1, y+26)
                
                .build();

    }
/*
    private void checkTypeAttestComponents(){
    	if (nmar_dec2.isSelected()) {
    		labelType.setText("المتوفي بتاريخ :");
    	} else {
    		labelType.setText(" بتاريخ :");
    	}
        
    }
//*/
    private JComponent southButtonsPanel() {


        JPanel southPan = new JPanel();
        southPan.setBackground(Color.gray);

        imprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	//TODO
            	//verifierType();
            	//---> function_set_3coches();
                //ReportedBean bean = ReportView.getMyAttest().iterator().next();
                ReportedBean bean = new ReportedBean(attestModel.getBean());

                ReportView.report(bean.getAttest());
            }
        });

        final Trigger triggerAttest = (Trigger) attestModel.getTriggerChannel();

        validerAddButton.setEnabled(false);
        annulerModifButton.setEnabled(false);

        // now to enable buttonValider when citModel or mentModel change
        PropertyConnector.connect(attestModel, "buffering", validerAddButton, "enabled");
        //PropertyConnector.connect(attestModel, "buffering", imprimerButton, "disabled");

        //PropertyConnector.connect(date_naiss.getJFormattedTextField(), "value", buttonValider, "enabled");

        //PropertyConnector.connect(citModel, Citoyen.PROPERTY_DATE_NAISS, date_naiss, "formattedTextField");

        annulerModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triggerAttest.triggerFlush();
           }
        });


        validerAddButton.addActionListener(new CommitActionListener
                (attestModel, this, add_mode));
        validerAddButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (num_mar.getText().length() <= 0) {
					num_mar.setText("0");		
				}
				if (fullname_conj1.getText().equals("")) date_conj1.getModel().setValue(null);
				
			}
        	
        });

        JPanel pan = IsmButtonBarBuilder.create(screenSize)
                //.addGlue()
                .addButton(validerAddButton)
                .addRelatedGap()
                .addButton(imprimerButton)
                .addUnrelatedGap()
                .addUnrelatedGap()
                .addUnrelatedGap()
                .addButton(annulerModifButton)
                //.padding(Paddings.DLU9)


                .build();

        southPan.add(pan);

        return southPan;

    }

    public JComponent showDialog(EventObject e) {

        return buildContent();

    }

    @Override
    public ArrayList<JComponent> getListComponents() {

        ArrayList<JComponent> list = new ArrayList<JComponent>();
        list.add(type_attest);
        list.add(comm_naiss_cit);
        list.add(commune);
        list.add(daira);
        list.add(wilaya);
        list.add(date_attest);
        list.add(date_deces_conj);
        list.add(date_mar);
        list.add(date_naiss_cit);
        //list.add(date_type_attest);
        list.add(datedeliv_cni_tem1);
        list.add(datedeliv_cni_tem2);

        list.add(fullname_tem1);
        list.add(lieudeliv_cni_tem1);
        list.add(num_cni_tem1);
        list.add(fullname_tem2);
        list.add(lieudeliv_cni_tem2);
        list.add(num_cni_tem2);
        
        
        list.add(lieu_naiss_cit);
        list.add(nom_cit);
        list.add(fullname_conj1);
        list.add(num_mar);
        list.add(prenom_cit);
        //list.add(prenom_conj);
        list.add(wil_naiss_cit);


        return list;

    }

}
