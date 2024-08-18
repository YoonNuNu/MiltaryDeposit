//값입력 및 계산식 내용
import java.util.Scanner;


public class Sh extends Calculation {
    Scanner sc = new Scanner(System.in);

    @Override
//    오버라이딩
    void calculte() {
//      가입기간 설정
        System.out.println("가입기간을 설정해주세요.(6~24개월)");
        int duration = sc.nextInt();
        double rate = 0;
//      기준값 벗어날 시 처음으로 반복
        while (true) {
            if (duration >= 6 && duration <= 24) {
                if (duration < 12) {
                    rate = 4.00;
                } else if (duration < 15) {
                    rate = 4.50;
                } else {
                    rate = 5.00;
                }
                break;
            } else {
                System.out.println("가입 기간을 6개월에서 24개월 사이로 설정해주세요.");
                duration = sc.nextInt();
            }
        }

        System.out.println("설정하신 " + duration + "개월의 기본이자율은 " + rate + "% 입니다.");
        sc.nextLine();

//        월 납입금액 설정
        int payment;

//      기준값 벗어날 시 처음으로 반복
        while (true) {
            System.out.println("월 납입 금액을 설정해주세요. (월 최대 20만원)");
            payment = sc.nextInt();

            if (payment <= 200000) {
                break;
            }
            System.out.println("최대 월 납입 금액을 초과했습니다. 다시 입력해주세요.");
        }

//      만기 계산식
        double amount = payment * duration + payment * rate * duration;

//      소수점 없애기
        int intAmount = (int) amount;

        System.out.println("고객님의 Sh수협은행 장병내일준비적금 만기 시 세전 금액은 " + intAmount + "입니다.");
        System.exit(0);
    }//calculate
}//class