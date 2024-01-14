package tradearea.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseData implements Serializable {

	public String warehouseID;
	public String warehouseName;
	public String timestamp;

	public String warehouseAddress;

	public String warehousePostalCode;

	public String warehoaseCity;

	public String warehouseCountry;

	public ProductData[] product;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getWarehousePostalCode() {
		return warehousePostalCode;
	}

	public void setWarehousePostalCode(String warehousePostalCode) {
		this.warehousePostalCode = warehousePostalCode;
	}

	public String getWarehoaseCity() {
		return warehoaseCity;
	}

	public void setWarehoaseCity(String warehoaseCity) {
		this.warehoaseCity = warehoaseCity;
	}

	public String getWarehouseCountry() {
		return warehouseCountry;
	}

	public void setWarehouseCountry(String warehouseCountry) {
		this.warehouseCountry = warehouseCountry;
	}

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public ProductData[] getProduct() {
		return product;
	}

	public void setProduct(ProductData[] product) {
		this.product = product;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
