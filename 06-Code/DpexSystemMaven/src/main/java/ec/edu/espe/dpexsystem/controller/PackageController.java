package ec.edu.espe.dpexsystem.controller;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import ec.edu.espe.dpexsystem.model.ElectoralPackage;
import ec.edu.espe.dpexsystem.utils.Settings;
import ec.edu.espe.dpexsystem.utils.UIHelper;
import ec.edu.espe.dpexsystem.view.FrmElectoralPackage;

public class PackageController {
    public static void insertPackageAsync(ElectoralPackage electoralPackage, FrmElectoralPackage instance, JRootPane rootPane) {
        final JDialog loadingDialog = UIHelper.showLoadingDialog(instance, rootPane, "Cargando...");
        SwingUtilities.invokeLater(() -> {
            loadingDialog.setVisible(true);
        });
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                ConectionMongoDB conectionMongoDB = DBConnectionController.getConection();
                conectionMongoDB.create(Settings.PackagesCollection, electoralPackage);
                JOptionPane.showMessageDialog(rootPane, "Paquete creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                instance.clearForm();
                return null;
            }

            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    loadingDialog.dispose();
                });
            }
        };

        worker.execute();
    }
}
