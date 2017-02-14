package hello;

import java.util.Date;

/**
 * Created by jesse on 2017/2/13.
 */
public class CompanyEntity {
    private String companyName;
    private String province;
    private String establishDate;
    private String companyType;
    private String legalPerson;
    private String companyAddress;

    public CompanyEntity(String companyName, String province, String establishDate, String companyType, String legalPerson, String companyAddress) {
        this.companyName = companyName;
        this.province = province;
        this.establishDate = establishDate;
        this.companyType = companyType;
        this.legalPerson = legalPerson;
        this.companyAddress = companyAddress;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String toString(){
        return "companyName:"+companyName+","+"legalPerson:"+legalPerson;
    }
}
