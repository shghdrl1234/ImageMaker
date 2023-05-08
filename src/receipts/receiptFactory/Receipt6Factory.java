package receipts.receiptFactory;

import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.serviceImpl.Receipt6;

public class Receipt6Factory extends ReceiptFactory {

    @Override
    protected IReceipt createReceipt() {
        return new Receipt6();
    }
}
