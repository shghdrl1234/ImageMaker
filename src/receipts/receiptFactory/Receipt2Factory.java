package receipts.receiptFactory;

import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.serviceImpl.Receipt2;

public class Receipt2Factory extends ReceiptFactory {

    @Override
    protected IReceipt createReceipt() {
        return new Receipt2();
    }
}
