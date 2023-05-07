package receipts.serviceImpl;

import DTO.Dummy;
import receipts.IReceipt;

public class Receipt2 implements IReceipt {

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
            + " table { border: solid 1px;}"
            + " td { font-size : 15px;}"
            + " body { font: 'Nanum Gothic Coding';}";
    }

    public String html(Dummy dummy) {

        String obj = "";
        for (Object o : dummy.getObj()) {
            String[] arr = (String[]) o;
            obj += "<tr>"
                + "<td class=\"center\"><b>" + arr[0] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[1] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[2] + "</b></td>"
                + "<td class=\"center\"><b>" + arr[3] + "</b></td>"
                + "</tr>";
        }

        return "<table>"
            + " <tbody>\n"
            + "     <th>\n"
            + "         <tr>\n"
            + "             <td colspan=4 class=\"center\" class=\"text\"> 본 영수증은 거래의 참고용으로만 사용하시기 바랍니다.</td>"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"4\">\n"
            + "             [구매 일자] data\n"
            + "             <hr>\n"
            + "             </td>\n"
            + "         </tr>\n"
            + "     </th>\n"
            + "     <tr>\n"
            + "         <td class=\"center\"><b>상품명</b></td>\n"
            + "         <td class=\"center\"><b>단가</b></td>\n"
            + "         <td class=\"center\"><b>수량</b></td>\n"
            + "         <td class=\"center\"><b>금액</b></td>\n"
            + "     </tr>\n"
            + "     <tr>"
            + "         <td colspan=\"4\">"
            + "         <hr>"
            + "         </td>"
            + "     </tr>\n"
            + obj
            + "     <tr>\n"
            + "         <td colspan=4>------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=2></td>\n"
            + "         <td class=\"right\"><b>[총 구매액]</b></td>\n"
            + "         <td class=\"center\"><b>data</b></td>\n"
            + "     </tr>"
            + "     <tr>\n"
            + "         <td colspan=4>------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=1>[승인 번호]</td>\n"
            + "         <td colspan=3 class=\"right\">"+dummy.getCardApproval()+"</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=1>[카드 종류]</td>\n"
            + "         <td colspan=3 class=\"right\">"+dummy.getCardType()+"</td>\n"
            + "     </tr>\n"
            + "     <tr>\n"
            + "         <td colspan=4>------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"4\">[상호명] "+dummy.getStore()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=4>[대표자] "+dummy.getRepresentative()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"4\">[주소] "+dummy.getAddress()+"</td>\n"
            + "         </tr>\n"
            + "         <tr>\n"
            + "             <td colspan=\"4\">[사업자번호] "+dummy.getBusinessLicense()+"</td>\n"
            + "         </tr>\n"
            + "         <td colspan=4>------------------------------------------------------------------</td>\n"
            + "     </tr>\n"
            + " </tbody>\n"
            + "</table>\n";
    }

}
