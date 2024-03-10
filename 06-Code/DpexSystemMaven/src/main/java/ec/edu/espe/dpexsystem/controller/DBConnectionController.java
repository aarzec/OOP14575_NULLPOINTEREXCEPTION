package ec.edu.espe.dpexsystem.controller;

import ec.edu.espe.dpexsystem.utils.Settings;

public class DBConnectionController {
    private static ConectionMongoDB conectionMongoDB;

    public static boolean createConnection() {
        conectionMongoDB = ConectionMongoDB.getInstancia(Settings.MongoURI, Settings.DBName);
        conectionMongoDB.connect(Settings.MongoURI);
        if (conectionMongoDB != null) {
            return true;
        } else {
            return false;
        }
    }

    public static ConectionMongoDB getConection() {
        return conectionMongoDB;
    }
}
