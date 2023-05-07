package receipts.receiptFactory;

import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.serviceImpl.Receipt4;

public class Receipt4Factory extends ReceiptFactory {

    @Override
    protected IReceipt creatReceipt() {
        return new Receipt4();
    }
}