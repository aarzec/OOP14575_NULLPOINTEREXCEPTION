package ec.edu.espe.dpexsystem.utils;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class UIHelper {
    public static JDialog showLoadingDialog(JFrame instance, JRootPane rootPane, String message) {
        JDialog loadingDialog = new JDialog(instance, message, ModalityType.DOCUMENT_MODAL);
        loadingDialog.setSize(200, 100);
        loadingDialog.setLocationRelativeTo(rootPane);
        loadingDialog.add(new JLabel(message));
        // loadingDialog.setVisible(true);
        return loadingDialog;
    }
}
