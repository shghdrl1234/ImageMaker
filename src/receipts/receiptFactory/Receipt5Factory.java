package receipts.receiptFactory;

import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.serviceImpl.Receipt5;

public class Receipt5Factory extends ReceiptFactory {

    @Override
    protected IReceipt createReceipt() {
        return new Receipt5();
    }
}
