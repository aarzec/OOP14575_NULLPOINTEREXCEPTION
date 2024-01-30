package ec.edu.espe.dpexsystem.model;

import java.util.Random;

/**
 *
 * @author NullPointerException
 */
public class ElectoralPackage {

    public static enum PackageStatus {
        PENDING,
        SENT,
        ARRIVED
    }

    public static enum PackageType {
        CNE,
        MIXTO,
        GENERO
    }

    private int packageId;
    private Country country;
    private PackageType packageType;
    private float weight;
    private PackageStatus status;

    public ElectoralPackage() {
        this.packageId = generateRandomPackageId();
        this.status = PackageStatus.PENDING;
    }

    public void updateStatus(String status) {

    }

    public void updateShippingStatus(String shippingStatus) {

    }
    
    private int generateRandomPackageId() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); 
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public PackageStatus getStatus() {
        return status;
    }

    public void setStatus(PackageStatus status) {
        this.status = status;
    }

}
