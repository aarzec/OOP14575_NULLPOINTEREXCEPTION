package ec.edu.espe.dpexsystem.controller;

import java.awt.Dialog.ModalityType;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.mongodb.client.MongoCursor;

import ec.edu.espe.dpexsystem.model.ConsularOffice;
import ec.edu.espe.dpexsystem.model.Country;
import ec.edu.espe.dpexsystem.utils.UIHelper;

public class CountryController {
    public static MongoCursor<Country> getAllCountries() {
        ConectionMongoDB conectionMongoDB = DBConnectionController.getConection();
        MongoCursor<Country> countriesCursor = conectionMongoDB.readAll("Country", Country.class);
        return countriesCursor;
    }

    public static void populateCountriesTableAsync(JFrame instance, JRootPane rootPane, JTable tableCountries) {
        final JDialog loadingDialog = UIHelper.showLoadingDialog(instance, rootPane, "Cargando...");
        SwingUtilities.invokeLater(() -> {
            loadingDialog.setVisible(true);
        });
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                populateCountriesTable(tableCountries);
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

    private static void populateCountriesTable(JTable tableCountries) {
        MongoCursor<Country> countriesCursor = CountryController.getAllCountries();
        ((javax.swing.table.DefaultTableModel) tableCountries.getModel()).setRowCount(0);
        try {
            while (countriesCursor.hasNext()) {
                Country country = countriesCursor.next();
                final ConsularOffice consularOffice = country.getConsularOffice();
                String districtName = consularOffice.getDistrict() == null ? "Desconocido"
                        : consularOffice.getDistrict().name();
                switch (districtName) {
                    case "EUROPA_ASIA_OCEANIA":
                        districtName = "Europa, Asia y Oceanía";
                        break;
                    case "USA_CANADA":
                        districtName = "USA y Canadá";
                        break;
                    case "LAT_CAR_AFRICA":
                        districtName = "Latinoamérica, Caribe y África";
                        break;
                    default:
                        districtName = "Desconocido";
                }
                ((javax.swing.table.DefaultTableModel) tableCountries.getModel()).addRow(new Object[] {
                        country.getName(),
                        country.getEcuadorianPopulation(),
                        consularOffice.getOfficeName(),
                        consularOffice.getAddress(),
                        districtName
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los paises", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al cargar los países: " + e);
            e.printStackTrace();
        } finally {
            countriesCursor.close();
        }
    }

    private static void populateCountriesComboBox(JComboBox<String> comboBoxCountries) {
        MongoCursor<Country> countriesCursor = CountryController.getAllCountries();
        comboBoxCountries.removeAllItems();
        try {
            while (countriesCursor.hasNext()) {
                Country country = countriesCursor.next();
                comboBoxCountries.addItem(country.getName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los paises", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al cargar los países: " + e);
            e.printStackTrace();
        } finally {
            countriesCursor.close();
        }
    }

    public static void populateCountriesComboBoxAsync(JFrame instance, JRootPane rootPane,
            javax.swing.JComboBox<String> comboBoxCountries) {
        comboBoxCountries.removeAllItems();
        comboBoxCountries.setEnabled(false);
        comboBoxCountries.addItem("Cargando...");
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                populateCountriesComboBox(comboBoxCountries);
                return null;
            }

            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> {
                    comboBoxCountries.setEnabled(true);
                });
            }
        };

        worker.execute();
    }
}
