package hello;

/**
 * Created by jesse on 2017/2/13.
 */
public class Company {
    private String companyNo;
    private String companyName;
    private String province;
    private String establishDate;
    private String companyType;
    private String legalPerson;
    private String capital;
    private String companyCode;
    private String companyAddress;
    private String businessScope;
    private String operationStartdate;
    private String operationEnddate;
    private String authority;
    private String companyStatus;
    private String shuidiUrl;
    private String lastupDatetime;


    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getOperationStartdate() {
        return operationStartdate;
    }

    public void setOperationStartdate(String operationStartdate) {
        this.operationStartdate = operationStartdate;
    }

    public String getOperationEnddate() {
        return operationEnddate;
    }

    public void setOperationEnddate(String operationEnddate) {
        this.operationEnddate = operationEnddate;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getShuidiUrl() {
        return shuidiUrl;
    }

    public void setShuidiUrl(String shuidiUrl) {
        this.shuidiUrl = shuidiUrl;
    }

    public String getLastupDatetime() {
        return lastupDatetime;
    }

    public void setLastupDatetime(String lastupDatetime) {
        this.lastupDatetime = lastupDatetime;
    }

    @Override
    public String toString(){
        return companyName;
    }
}
