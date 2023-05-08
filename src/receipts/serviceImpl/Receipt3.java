package receipts.serviceImpl;

import DTO.Dummy;
import DTO.ReceiptDTO;
import receipts.IReceipt;
import receipts.utils.ReceiptUtils;

public class Receipt3 implements IReceipt {

    public String font() {
        return "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
            + "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
            + "<link href=\"https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap\" rel=\"stylesheet\">";
    }

    public String css() {
        return " .right { text-align: right;}"
            + " .center { text-align: center;}"
            + " .left { text-align : left;}"
            + " .text { font-size : 14px; color: gray; text-align: center;}"
            + " table { border: solid 1px;  width:570;}"
            + " td { font-size : 15px;}"
            + " body { font: 'Nanum Gothic Coding';}";
    }

    public String html(Dummy dummy) {
        ReceiptDTO receiptDTO = ReceiptUtils.getReceiptData();
        String obj = "";
        for (Object o : dummy.getObj()) {
            String[] arr = (String[]) o;
            obj += "<tr>"
                + "<td class=\"left\"><b>" + arr[0] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[1] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[2] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[3] + "</b></td>"
                + "</tr>";
        }

        return "<table>"
            + " <tbody>\n"
            + "     <th>\n"
            + "         <tr>\n"
            + "             <td colspan=\"1\">[상호명]</td>\n"
            + "             <td colspan=\"3\" class=\"right\">"+dummy.getStore()+"</td>"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"1\">[대표자]</td>\n"
            + "             <td colspan=\"3\" class=\"right\">"+dummy.getRepresentative()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"1\">[주소]</td>\n"
            + "             <td colspan=\"3\" class=\"right\"> "+dummy.getAddress()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"2\">[사업자번호]</td>\n"
            + "             <td colspan=\"2\" class=\"right\"> "+dummy.getBusinessLicense()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"1\">[구매 일자]</td>"
            + "             <td colspan=\"3\" class=\"right\"> "+dummy.getPaymentDate()+"</td>"
            + "         </tr>\n"
            + "         <tr>"
            + "             <td colspan=\"4\"><hr></td>"
            + "         </tr>"
            + "     </th>\n"
            + "     <tr>\n"
            + "         <td class=\"center\"><b>상품명</b></td>\n"
            + "         <td class=\"center\"><b>"+receiptDTO.getAmountName()+"</b></td>\n"
            + "         <td class=\"center\"><b>"+receiptDTO.getCountName()+"</b></td>\n"
            + "         <td class=\"center\"><b>"+receiptDTO.getPriceName()+"</b></td>\n"
            + "     </tr>\n"
            + "     <tr>"
            + "         <td colspan=\"4\">"
            + "         <hr>"
            + "         </td>"
            + "     </tr>\n"
            + obj
            + "     <tr>\n"
            + "         <td colspan=4>--------------------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=2></td>\n"
            + "         <td class=\"right\"><b>[총 구매액]</b></td>\n"
            + "         <td class=\"center\"><b>"+dummy.getTotal()+"</b></td>\n"
            + "     </tr>"
            + "     <tr>\n"
            + "         <td colspan=4>--------------------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=1>[승인 번호]</td>\n"
            + "         <td colspan=3 class=\"right\">"+dummy.getCardApproval()+"</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=1>[카드 종류]</td>\n"
            + "         <td colspan=3 class=\"right\">"+ dummy.getCardType()+"</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=4>--------------------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=4 class=\"center\" class=\"text\"> 본 영수증은 거래의 참고용으로만 사용하시기 바랍니다.</td>"
            + "     </tr>\n"
            + "         <td colspan=4>--------------------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + " </tbody>\n"
            + "</table>\n";
    }

}
