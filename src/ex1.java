public class ex1 {

    public static void main(String[] args) {

        /*
        1. 심장의 위치
        => 왼팔, 오른팔 / 머리, 허리를 이었을 때 나오는 공통 구역

        2. 공통 구역 기준으로 왼팔, 오른팔, 허리, 왼쪽다리, 오른쪽 다리 길이 구함
        => 심장 기준으로 좌측으로 가면서 * 카운트
        => 심장 기준으로 우측으로 가면서 * 카운트
        => 심장 기준으로 아래로 가면서 * 카운트
        => 허리 끝에서 좌로1 칸, 우로 1칸 이후, 아래로 가면서 * 카운트
         */


        // N을 입력 받는다.
        // 2차 배열로 만든다.

        int N = 0;
        int cnt = 0;
        String str = "gdgd";
        String[][] arr = new String[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = ""+str.charAt(cnt);
                cnt++;
            }
        }



        int i = 1;
        int j = 1;

    }

}
