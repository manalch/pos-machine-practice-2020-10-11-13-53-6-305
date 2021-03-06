package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PosMachine {
    private List<ReceiptInfo> receiptInfos = new ArrayList<>();
    private int total;

    public String printReceipt(List<String> barcodes) {
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();

        buildReceiptInfo(barcodes, itemInfos);

        return "***<store earning no money>Receipt***\n"
                + formatReceipt(receiptInfos) + "\n"
                + "----------------------\n"
                + "Total: " + total + " (yuan)\n"
                + "**********************";
    }

    private void buildReceiptInfo(List<String> barcodes, List<ItemInfo> itemInfos) {
        barcodes.stream()
                .distinct()
                .forEachOrdered(barcode -> {
                    Predicate<ItemInfo> byBarcode = itemInfo -> barcode.equals(itemInfo.getBarcode());
                    itemInfos.stream()
                            .filter(byBarcode)
                            .map(itemInfo -> buildReceiptInfoDetails(itemInfo, Collections.frequency(barcodes, barcode)))
                            .forEach(receiptInfo -> {
                        total += receiptInfo.getSubTotal();
                        receiptInfos.add(receiptInfo);
                    });
                });
    }

    private ReceiptInfo buildReceiptInfoDetails(ItemInfo itemInfo, int quantity) {
        return ReceiptInfoBuilder.of()
                .setItemInfo(itemInfo)
                .setQuantity(quantity)
                .build();
    }

    private String formatReceipt(List<ReceiptInfo> receiptInfos) {
        return receiptInfos.stream()
                .map(receiptInfo -> "Name: " + receiptInfo.getName()
                        + ", Quantity: " + receiptInfo.getQuantity()
                        + ", Unit price: " + receiptInfo.getUnitPrice() + " (yuan)"
                        + ", Subtotal: " + receiptInfo.getSubTotal() + " (yuan)")
                .collect(Collectors.joining("\n"));
    }
}
