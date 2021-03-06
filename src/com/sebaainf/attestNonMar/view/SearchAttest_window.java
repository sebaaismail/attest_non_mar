package com.sebaainf.attestNonMar.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdatepicker.impl.JDatePickerImpl;

import com.jenkov.db.itf.PersistenceException;
import com.jgoodies.binding.PresentationModel;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.model.AttestEditorModel;
import com.sebaainf.attestNonMar.model.AttestValidator;
import com.sebaainf.attestNonMar.persistance.MyDaosAttest;
import com.sebaainf.ismUtils.IsmComponentFactory;
import com.sebaainf.ismUtils.IsmPrintStream;

public class SearchAttest_window extends JFrame implements Runnable{
	
	//TODO

    // Binding *************************************************
    private PresentationModel<Attest> att_adapter =
            new PresentationModel<Attest>(new Attest());
    private ValidationResultModel validationResultModel =
            new DefaultValidationResultModel();

    //private JTextArea messageError = ValidationResultViewFactory.createReportTextArea(validationResultModel);
    //  *************************************************

    // why implements Runnable ? ----> because it is the only
    // way to ensure that one instance of application is run
    // Singleton dont work with the first JFrame


    //the port number using
    private static final int PORT = 5555;
    //count of tried instances
    private int triedInstances = 0;

    private JDatePickerImpl datePicker;

    JTextField nomFr_Field;
    JTextField prenomFr_Field;

    JLabel nomFrLabel = new JLabel("Nom :");
    JLabel prenomFrLabel = new JLabel("Prenom :");

    JButton buttonOk = new JButton(new AttestValidationAction());
    JButton buttonQuit = new JButton("Quitter");
    JButton buttonNouveauCit = new JButton("* Nouvelle Attestation");

    public SearchAttest_window() {

        this.setTitle("Chercher une Attestion de non mariage ...");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
        //this.setSize(500, 500);

        //run socket listening inside a thread
        Thread thread = new Thread(this);
        thread.start();

    }

    public JComponent createPanel() {


        // Binding *************************************************
        nomFr_Field = IsmComponentFactory.createTextField(
                att_adapter.getModel(Attest.PROPERTY_NOMFR_CIT));

        prenomFr_Field = IsmComponentFactory.createTextField(
        		att_adapter.getModel(Attest.PROPERTY_PRENOMFR_CIT));


        //  *********************************************************


        buttonOk.setText("Ok");
        buttonOk.setPreferredSize(buttonQuit.getPreferredSize());



        nomFr_Field.setPreferredSize(new Dimension(140, nomFr_Field.getPreferredSize().height));

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        //  buttonNouveauCit ActionListener *******************************************

        buttonNouveauCit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttestEditorModel attModel = new AttestEditorModel(new Attest());

                Editor_window view = new Editor_window(attModel);
                view.setVisible(true);
            }
        });


        //  buttonQuit ActionListener **********************************************

        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        // testing datpicker********

        JDatePickerImpl date_naiss;
        Attest attTesting = new Attest();
        attTesting.setDate_naiss_cit(new java.sql.Date(1990,8,20));

      //  date_naiss = IsmComponentFactory.createDatePickerImpl(new CitoyenEditorModel(citTesting)
       //         ,Citoyen.PROPERTY_DATE_NAISS, "yyyy/MM/dd");



        //*************************

        //read for more info file:///C:/projects/modules/Jgoodies/jgoodies-forms-1.9.0/docs/api/index.html
        return FormBuilder.create()
                .columns("right:pref, 4dlu, pref, 4dlu, left:pref, left:default")
                .rows("pref, $lg, pref, 16dlu, pref, $lg, pref, 8dlu, pref, 14dlu, pref")
                .padding(Paddings.DLU14)

                .add(nomFrLabel).xy(1, 1)
                .add(nomFr_Field).xy(3, 1)
                .add(prenomFrLabel).xy(1, 3)
                .add(prenomFr_Field).xy(3, 3)

                //.add(buttonQuit).xyw(5, 9, 2, "left, fill")
                .addBar(buttonOk).xy(3, 5, "right, fill")
                .addBar(buttonQuit).xy(5, 5, "left, fill")
                .addBar(buttonNouveauCit).xy(3, 9)
                .build();
        // i create tabbedPanel with MyFormBuilder
        // to centralize attributes like font size etc ...
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try {
            //create server socket
            ServerSocket serverSocket = new ServerSocket(PORT);

            //listing the socket to check new instances
            while (true) {
                try {
                    //another instance accessed the socket
                    serverSocket.accept();
                    //bring this to front
                    toFront();

                    //change the title (addtional);
                    triedInstances++;
                    setTitle("Tried another instances : " + triedInstances);
                } catch (IOException ex) {
                    //cannot accept socket
                }
            }
        } catch (IOException ex) {
            //fail if there is an instance already exists
            try {
                //connect to the main instance server socket
                new Socket(InetAddress.getLocalHost(), PORT);
            } catch (IOException ex1) {
                //do nothing
            } finally {
                //exit the system leavng the first instance
                System.exit(0);
            }
        }
    }


    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    private class AttestValidationAction extends AbstractAction {

        public AttestValidationAction() {

            super("Chercher");

        }

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            validationResultModel.setResult(ValidationResult.EMPTY);

            AttestValidator validator = new AttestValidator(att_adapter);
            ValidationResult result = validator.validateForSearch(att_adapter.getBean());

            if (!result.hasErrors()) {
                IsmPrintStream.logging("looking at database");

                java.util.List<Attest> listAtt;
					listAtt = MyDaosAttest.getListAtt(att_adapter.getBean().getNomFR_cit(),
							att_adapter.getBean().getPrenomFR_cit());

				if (listAtt.size() > 0) {
				    JFrame winTable = ResultaRech_window.getInstance(listAtt);
				    winTable.setVisible(true);
				    //initilizer();
				} else {
				    JOptionPane.showMessageDialog(null, "غير مسجل في قاعدة البيانات !");
				}


            } else {

                JOptionPane.showMessageDialog(null, result.getMessagesText());
            }

        }

        private class ValidationListener implements PropertyChangeListener {

            /**
             * This method gets called when a bound property is changed.
             *
             * @param evt A PropertyChangeEvent object describing the event source
             *            and the property that has changed.
             */
            @Override
            public void propertyChange(PropertyChangeEvent evt) {


                if (evt.getPropertyName() == ValidationResultModel.PROPERTY_RESULT) {
                    JOptionPane.showMessageDialog(null, "Validation has been performed");
                } else if (evt.getPropertyName() == ValidationResultModel.PROPERTY_MESSAGES) {

                }

            }
        }
    }
}
