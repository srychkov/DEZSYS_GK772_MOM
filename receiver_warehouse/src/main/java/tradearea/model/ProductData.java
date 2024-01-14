package tradearea.model;

/**
 * @author Sergej
 * @version 01.09.2023
 */
public class ProductData {


    private String productID;

    private String productName;

    private String productCategory;

    private String productQuantity;

    private String productUnit;

    public ProductData(){

    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    @Override
    public String toString() {
        String info = String.format(productID, productName, productCategory, productQuantity, productUnit);
        return info;
    }
}
