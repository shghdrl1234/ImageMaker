import DTO.Dummy;

public class Receipt {

    public String html() {

        return "    <tbody>\n"
            + "      <tr>\n"
            + "       <td colspan=4>------------------------------------------------------------------</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>승인 번호</td>\n"
            + "        <td class=\"end\">30023742</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>카드 종류</td>\n"
            + "        <td class=\"end\">국민KB카드</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>결제일자</td>\n"
            + "        <td class=\"end\">2023-03-28 00:31</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>승인번호</td>\n"
            + "        <td class=\"end\">30023742</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>할부기간</td>\n"
            + "        <td class=\"end\">일시불</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=4>------------------------------------------------------------------</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>구매 상점</td>\n"
            + "        <td class=\"end\">gdg</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>대표자</td>\n"
            + "        <td class=\"end\">브루노 마스</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>사업자</td>\n"
            + "        <td class=\"end\">606-60-60060</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>구매지점</td>\n"
            + "        <td class=\"end\">30023742</td>\n"
            + "      </tr>\n"
            + "      <tr>\n"
            + "        <td colspan=3>주소</td>\n"
            + "        <td class=\"end\">부산광역시 부산진구 부전동 165-2 B1</td>\n"
            + "      </tr>\n"
            + "      <td colspan=4>------------------------------------------------------------------</td>\n"
            + "      </tr>\n"
            + "    </tbody>\n"
            + "  </table>\n";
    }

    public String css() {
        return  " .end { text-align: right;}"
                + "table { border: solid 1px;}"
                + " th { font-size : 25px;}"
                + " td { font-size : 15px;}"
                + " body { font-family: 'Nanum Gothic Coding', monospace;}";

    }

    public String font() {
        return "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap\" rel=\"stylesheet\">";
    }

    public String object(Dummy dummy) {

        String obj = "";
        for(Object o : dummy.getObj()) {
            String[] arr = (String[]) o;
            obj += "<tr>"
                    +"<td colspan=3><b>"+arr[0]+"</b></td>"
                    +"<td class=\"end\"><b>"+arr[1]+"</b></td>"
                    +"</tr>";
        }

         return " <table>\n"
                 + "    <th>\n"
                 + "      <tr>\n"
                 + "        <td colspan=\"4\">\n"
                 + "          <br><b>총 결제금액</b>\n"
                 + "          <br>\n"
                 + "          <h3>52,800 원</h3>\n"
                 + "          <hr>\n"
                 + "        </td>\n"
                 + "      </tr>\n"
                 + "    </th>\n" + obj;
    }
}
