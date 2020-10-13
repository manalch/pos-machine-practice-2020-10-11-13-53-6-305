package pos.machine;

public class ReceiptInfoHelper {
    private ItemInfo itemInfo;
    private int quantity;

    public ReceiptInfoHelper() {
    }

    public static ReceiptInfoHelper of() {
        return new ReceiptInfoHelper();
    }

    public ReceiptInfoHelper setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
        return this;
    }

    public ReceiptInfoHelper setQuantity(int quantity) {
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
