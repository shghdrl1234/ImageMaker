import receipts.makeReciept.SelectForm;

public class Maker5 {

    public static void main(String[] args) {
        SelectForm selectForm = new SelectForm();

        if (selectForm.SelectForm() == true) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}


