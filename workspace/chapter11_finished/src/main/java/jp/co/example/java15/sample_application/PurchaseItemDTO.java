package jp.co.example.java15.sample_application;

public class PurchaseItemDTO {
	private final String itemName;
	private final String priceEntry;
	private final boolean existsItem;
	public PurchaseItemDTO(String itemName, String priceEntry,
			boolean existsItem) {
		super();
		this.itemName = itemName;
		this.priceEntry = priceEntry;
		this.existsItem = existsItem;
	}
	public String getItemName() {
		return itemName;
	}
	public String getPriceEntry() {
		return priceEntry;
	}
	public boolean isExistsItem() {
		return existsItem;
	}

}
