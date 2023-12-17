package ec.edu.espe.dpexsystem.model;

/**
 *
 * @author NullPointerException
 */

public class ElectoralPackage {

    public ElectoralPackage() {
    }
    public static int totalRegisteredPackages = 0;

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
    private ConsularOffice consularOffice;
    private Constituency constituency;
    private PackageType packageType;
    private float weight;
    private PackageStatus status;


    public void updateStatus(String status) {

    }

    public void updateShippingStatus(String shippingStatus) {

    }

    /**
     * @return the packageId
     */
    public int getPackageId() {
        return packageId;
    }

    /**
     * @param packageId the packageId to set
     */
    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the consularOffice
     */
    public ConsularOffice getConsularOffice() {
        return consularOffice;
    }

    /**
     * @param consularOffice the consularOffice to set
     */
    public void setConsularOffice(ConsularOffice consularOffice) {
        this.consularOffice = consularOffice;
    }

    /**
     * @return the constituency
     */
    public Constituency getConstituency() {
        return constituency;
    }

    /**
     * @param constituency the constituency to set
     */
    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    /**
     * @return the packageType
     */
    public PackageType getPackageType() {
        return packageType;
    }

    /**
     * @param packageType the packageType to set
     */
    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    /**
     * @return the weigth
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weigth to set
     */
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
