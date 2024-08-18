//값입력 및 계산식 내용
import java.util.Scanner;


public class Ibk extends Calculation {
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

//      우대금리 설정
        double[] treatRates = {0.5, 0.3, 0.3, 3.0};
        double totalTreatment = 0;

        String[] options = {
                "급여 이체 내역(10만원 이상)이 6회 이상인 경우",
                "당행 주택청약종합저축을 신규한 경우",
                "당행 나라사랑카드를 1회 이상 사용한 경우",
                "기초생활 수급자"
        };

        System.out.println("본인의 조건에 맞는 우대조건을 선택해주세요. [1] 예 [2] 아니오");

        for (int i = 0; i < treatRates.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i] + " " + treatRates[i] + "%");
            int option = sc.nextInt();

//      기준값 벗어날 시 처음으로 반복
            if (option == 1) {
                totalTreatment += treatRates[i] + rate;
            } else if (option == 2) {
                // 아무 조치도 취하지 않고 넘어감
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                i--;
            }
        }

//      최대 우대금리 3.0
        if (totalTreatment > 3.0) {
            totalTreatment = 3.0;
        }

        System.out.println("선택된 우대조건의 총 이자율은 " + totalTreatment + "% 입니다.");


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
        double amount = payment * duration + payment * (rate + totalTreatment)/100 * duration;

//      소수점 없애기
        int intAmount = (int) amount;

        System.out.println("고객님의 IBK기업은행 장병내일준비적금 만기 시 세전 금액은 " + intAmount + "입니다.");
        System.exit(0);

    }//calculate
}//class