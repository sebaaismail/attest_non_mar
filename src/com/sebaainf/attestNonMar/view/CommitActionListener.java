package com.sebaainf.attestNonMar.view;

import com.jenkov.db.itf.PersistenceException;
import com.jgoodies.binding.value.Trigger;
import com.jgoodies.validation.ValidationResult;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.model.AttestEditorModel;
import com.sebaainf.attestNonMar.model.AttestValidator;
import com.sebaainf.attestNonMar.persistance.MyDaosAttest;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${sebaainf.com} on 06/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 *
 * cette class pour valider les entrees de user dans form EditorWindow
 * est appelé quand on click sur le bouton Valider
 * pour changer une attestation et aussi pour ajouter une nouvelle attest
 */
public class CommitActionListener implements ActionListener {


    private AttestEditorModel attestModel;
 
    //private JToggleButton divorceRadioButton;
    private boolean add_mode;
    private Trigger attestTrigger;
    Editor_window wind;

    //private JComponent[] listComp = new JComponent[0];

    /**
     * constructeur mené par les models citoyen, mention et aussi le radioButton divorce
     * @param citModel
     * @param mentModel
     * @param divorceRadioButton
     * @param add_mode
     */
    public CommitActionListener(AttestEditorModel attestModel,
    		Editor_window wind, boolean add_mode){

    	this.wind = wind;
        this.attestModel = attestModel;
        this.add_mode = add_mode;
        this.attestTrigger = (Trigger) attestModel.getTriggerChannel();
        //this.listComp = listComp;

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String textMode = "updated"; // default
        String message = "";
        boolean correct = true;
        
        Integer nummar = attestModel.getBean().getNum_mar();
        if (nummar.equals(null)) attestModel.getBean().setNum_mar(0);

        attestTrigger.triggerCommit();

        if (attestModel.isChanged()) {

            IsmPrintStream.logging("attestModel.isChanged");
            AttestValidator attestValidator = new AttestValidator(attestModel);
            ValidationResult resultAttest =
                    attestValidator.validate(attestModel.getBean());
            if (resultAttest.hasErrors()) {
                correct = false;
                if (resultAttest.getMessages().size() > 2) {
                    message = "أدخل بيانات المواطن"  + "\n";
                } else {
                    message += resultAttest.getMessagesText();
                }

            } else {
            	wind.imprimerButton.setEnabled(true);

                if (add_mode) {
					/* TODO
				    textMode = "added";
				    MyDaosCitoyen.insertCitoyen((Citoyen) citModel.getBean());
				    int i = MyDaos.ism_lastGeneratedId("citoyen", "id_cit");
				            ((Mention) mentModel.getBean()).setId_cit(i);
				           //*/ 
                	//* Offline mode
                	Attest attest = attestModel.getBean();
                	try {
						MyDaosAttest.insertAttest(attest);
					} catch (PersistenceException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
                	//*/
				} else {
				    // we are in update mode
				    //TODO MyDaosCitoyen.updateCitoyen((Citoyen) citModel.getBean());
                	Attest attest = attestModel.getBean();
                	IsmPrintStream.logging("zed fi : " + attest.getLieu_naiss_cit() + " !");
                	try {
						MyDaosAttest.updateAttest(attest);
					} catch (PersistenceException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				IsmPrintStream.logging("citoyen " + textMode + " !");
				

            }
        }




        if (!correct) {
            JOptionPane.showMessageDialog(null, message);
        }
        IsmPrintStream.logging(message);
    }
}
