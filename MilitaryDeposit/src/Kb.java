//값입력 및 계산식 내용
import java.util.Scanner;


public class Kb extends Calculation {
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
                    rate = 3.50;
                } else if (duration < 15) {
                    rate = 4.00;
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
        double[] treatRates = {0.3, 0.2};
        double totalTreatment = 0;

        String[] options = {
                "적금 신규월 초일부터 만기일 기준 전전월 말일까지 고객이 가입한 적금 계약기간(월 환산)의 2/3에 해당하는 기간 동안, 고객의 KB국민은행 입출금통장으로 급여이체 실적이 있는 경우",
                "적금 만기일 기준 전전월 말일을 기준으로, 고객이 KB국민은행 주택청약종합 저축(청년 주택드림 청약통장 포함) 계좌를 보유한 경우",
        };

        System.out.println("※ 군급여이체 및 카드결제 실적은 월 1회만 인정하며, 군급여이체 실적은 국군재정관리단을 통한 이체에 한정");

        System.out.println("본인의 조건에 맞는 우대조건을 선택해주세요. [1] 예 [2] 아니오");

        for (int i = 0; i < treatRates.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i] + " " + treatRates[i] + "%");
            int option = sc.nextInt();

//      기준값 벗어날 시 처음으로 반복
            if (option == 1) {
                totalTreatment += treatRates[i];
            } else if (option == 2) {
                // 아무 조치도 취하지 않고 넘어감
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                i--;
            }
        }

        //      최대 우대금리 0.5
        if (totalTreatment > 0.5) {
            totalTreatment = 0.5;
        }

        System.out.println("선택된 우대조건의 총 이자율은 " + totalTreatment + "% 입니다.");


//        월 납입금액 설정
        int payment;

//      기준값 벗어날 시 처음으로 반복
        while (true) {
            System.out.println("월 납입 금액을 설정해주세요. (월 최대 20만원)");
            payment = sc.nextInt();

            if (payment <= 200000 && payment >= 1000) {
                break;
            }
            System.out.println("최대 월 납입 금액을 초과했습니다. 다시 입력해주세요.");
        }

//      만기 계산식
        double amount = payment * duration + payment * (rate + totalTreatment)/100 * duration;

//      소수점 없애기
        int intAmount = (int) amount;

        System.out.println("고객님의 KB국민은행 장병내일준비적금 만기 시 세전 금액은 " + intAmount + "입니다.");
        System.exit(0);
    }//calculate
}//class