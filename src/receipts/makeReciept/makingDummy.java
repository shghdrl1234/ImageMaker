package receipts.makeReciept;

import DTO.Dummy;
import java.util.ArrayList;
import java.util.List;


public class makingDummy {

    private makingDummy() { throw new IllegalStateException("dummy Class");}

        // TODO: 2023-05-08 구매 항목이 없는 일시불 신용카드 승인에 대해서는 어떻게 진행할지?
        // => 항목이 없는 양식을 만들고, 분기처리 한다?
        // TODO: 2023-05-08 구매 항목에 대한 정보 컬럼이 2개 3개 4개 등.. 다양하다.
    public static Dummy dummyData() {
            Dummy dummy = new Dummy();
            dummy.setStore("크림(부암점)");
            dummy.setBusinessLicense("106-34-05763");
            dummy.setCardType("스타로드 카드");
            dummy.setCardApproval("30024433");
            dummy.setPaymentDate("2023-04-24");
            dummy.setRepresentative("최근일");
            dummy.setAddress("부산 부산진구 시민공원로20번길 27, 1층(부암동)");
            dummy.setUser("hgRih");
            dummy.setTotal("3,400 원");

            List data = new ArrayList();
            data.add(new String[]{"빙그레)뽕따-소다","800","1","800"});
            data.add(new String[]{"가나 아이스바","900","2","1,800"});
            data.add(new String[]{"롯데) 주물러-콜라","800","1","800"});
            dummy.setObj(data);

            return dummy;
        }
}


