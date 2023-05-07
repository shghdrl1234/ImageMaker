package receipts.receiptFactory;

import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.serviceImpl.Receipt2;

public class Receipt2Factory extends ReceiptFactory {

    @Override
    protected IReceipt creatReceipt() {
        return new Receipt2();
    }
}
