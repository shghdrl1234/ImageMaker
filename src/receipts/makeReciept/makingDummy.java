package receipts.makeReciept;

import DTO.Dummy;
import java.util.ArrayList;
import java.util.List;


public class makingDummy {

    private makingDummy() { throw new IllegalStateException("dummy Class");}

    public static Dummy dummyData() {

            List data = new ArrayList();
            data.add(new String[]{"안녕","1,000","12","12,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});
            data.add(new String[]{"안녕2","1,000","13","13,000"});

            Dummy dummy = new Dummy();
            dummy.setObj(data);
            dummy.setStore("거인 통닭");
            dummy.setBusinessLicense("123-4526-79");
            dummy.setCardType("국민 KB 카드");
            dummy.setCardApproval("11233124");
            dummy.setPaymentDate("2023-05-07");
            dummy.setRepresentative("노홍기");
            dummy.setAddress("부산광역시 부산진구 부전 2동 000-000");
            dummy.setUser("shghdrl");
            dummy.setTotal("3,000,000 원");

            return dummy;
        }
}

