package receipts;

import DTO.Dummy;

public abstract class ReceiptFactory {

    public IReceipt newInstance(Dummy dummy) {
        IReceipt iReceipt = creatReceipt();
        iReceipt.css();
        iReceipt.font();
        iReceipt.html(dummy);
        return iReceipt;
    }
    // ReceiptFactory를 상속 받았을 때 IReceipt 타입을 반환하는 메서드를 구현하게함.
    protected abstract IReceipt creatReceipt();

}
