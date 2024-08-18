//값입력 및 계산식 내용
import java.util.Scanner;


public class Woori extends Calculation {
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
                    rate = 4.30;
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
        double[] treatRates = {0.4, 0.2, 0.2, 0.2};
        double totalTreatment = 0;

        String[] options = {
                "당행 입출식 계좌에서 매월 자동이체를 통해 '실적 인정 기간'의 1/2 기간 이상 이 적금으로 적립한 경우",
                "실적 인정 기간' 동안 우리카드(체크/신용) 결제계좌를 우리은행 입출식 계좌로 지정한 후, 매월 카드 결제 실적 보유",
                "적금의 신규 시점에 우리은행에서 가입한 「주택청약종합저축」 상품을 보유하고 있는 경우",
                "우리은행 상품·서비스 마케팅 동의항목 중 전화(휴대폰), SMS항목 중 하나 이상을 동의한 후 만기 해지시점까지 유지한 경우"
        };
        System.out.println("※ 실적인정기간 : 신규월 및 만기월을 제외한 가입기간");
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

        //      최대 우대금리 1.0
        if (totalTreatment > 1.0) {
            totalTreatment = 1.0;
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

        System.out.println("고객님의 우리은행 장병내일준비적금 만기 시 세전 금액은 " + intAmount + "입니다.");
        System.exit(0);
    }//calculate
}//class