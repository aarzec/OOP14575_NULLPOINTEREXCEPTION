
package ec.edu.espe.dpexsystem.model;

import org.bson.types.ObjectId;

/**
 *
 * @author NullPointerException
 */
public class ConsularOffice {
    private ObjectId id;
    private String officeName;
    private String address;
    private District district;

    public ConsularOffice(String officeName, String address, District district) {
        this.officeName = officeName;
        this.address = address;
        this.district = district;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ConsularOffice() {
    }

    public String getOfficeDetails() {

        return null;

    }
}
