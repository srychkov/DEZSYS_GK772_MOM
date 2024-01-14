package tradearea.warehouse;

import tradearea.model.ProductData;
import tradearea.model.WarehouseData;

import java.util.Random;

public class WarehouseSimulation {

	private String[] products = new String[5];
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
	
	public WarehouseData getData( String inID ) {

		String[][] produkte = {
				{"Nike Air Force 2", "Schuhe", "Gramm"},
				{"Adidas pumas", "Schuhe", "Gramm"},
				{"Vans", "Schuhe", "Gramm"},
				{"Nike Jordan 3", "Schuhe", "Gramm"},
				{"Converse", "Schuhe", "Gramm"},
				{"Spongebob-Schuhe", "Schuhe", "Gramm"},
				{"Nirvana Shirt", "T-Shirt", "Gramm"},

		};


		WarehouseData data = new WarehouseData();
		data.setWarehouseID( inID );
		data.setWarehouseName( "Linz Bahnhof" );
		data.setWarehouseAddress("Bahnhofsstrasse 27/9");
		data.setWarehousePostalCode("Linz");
		data.setWarehoaseCity("Linz");
		data.setWarehouseCountry("Austria");

		ProductData[] products = new ProductData[5];

		for(int i = 1; i < products.length;i++){
			ProductData product = new ProductData();
			product.setProductID(String.valueOf(i));

			Random r = new Random();
			int index = r.nextInt(produkte.length);

			String[] randomProduct = produkte[index];

			product.setProductName(randomProduct[0]);
			product.setProductCategory(randomProduct[1]);
			product.setProductUnit(randomProduct[2]);

			int randomQ = r.nextInt(501);
			product.setProductQuantity(String.valueOf(randomQ));

			products[i] = product;
		}

		data.setProduct(products);

		return data;
		
	}


}
