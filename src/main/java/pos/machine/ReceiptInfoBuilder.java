package pos.machine;

public class ReceiptInfoBuilder {
    private ItemInfo itemInfo;
    private int quantity;

    public ReceiptInfoBuilder() {
    }

    public static ReceiptInfoBuilder of() {
        return new ReceiptInfoBuilder();
    }

    public ReceiptInfoBuilder setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
        return this;
    }

    public ReceiptInfoBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ReceiptInfo build() {
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setName(itemInfo.getName());
        receiptInfo.setQuantity(quantity);
        receiptInfo.setUnitPrice(itemInfo.getPrice());
        receiptInfo.setSubTotal(calculateSubTotal());
        return receiptInfo;
    }

    private int calculateSubTotal() {
        return itemInfo.getPrice() * quantity;
    }
}
