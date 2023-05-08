package DTO;

public class ReceiptDTO {
    private String amountName;
    private String countName;
    private String priceName;

    public ReceiptDTO() {

    }

    public ReceiptDTO(String amountName, String countName, String priceName) {
        this.amountName = amountName;
        this.countName = countName;
        this.priceName = priceName;
    }


    public String getAmountName() {
        return amountName;
    }

    public void setAmountName(String amountName) {
        this.amountName = amountName;
    }

    public String getCountName() {
        return countName;
    }

    public void setCountName(String countName) {
        this.countName = countName;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }
}
