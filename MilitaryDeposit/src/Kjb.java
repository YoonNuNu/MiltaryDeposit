//값입력 및 계산식 내용
import java.util.Scanner;


public class Kjb extends Calculation {
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
                    rate = 3.70;
                } else if (duration < 15) {
                    rate = 4.20;
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
        double[] treatRates = {0.1, 0.1, 0.1, 0.2};
        double totalTreatment = 0;

        String[] options = {
                "만기일이 속한 달의 전전월 말일 기준 이 예금 가입자 명의의 당행 요구불예금* 최근 3개월 평잔이 30만원 이상인 경우",
                "신규가입일부터 만기일이 속한 달의 전전월 말일까지 당행 신용카드(또는 체크카드) 사용 실적* 100만원 이상인 경우",
                "가입자 본인 명의 당행 입출금이 자유로운 예금에서 이 예금으로 적립액 자동이체 설정 하여 5회 이상 입금된 경우(최초 신규금액 제외) ",
                "이 예금의 가입일부터 해지일 전일까지 본인 명의의 당행 요구불예금 계좌에서 전자금융 (인터넷·스마트·폰뱅킹)을 이용한 당·타행 출금이체거래*실적 5회 이상"
        };
        System.out.println("※ 출금이체거래 제외사항 : 당행의 본인 명의 계좌로의 출금이체, 공과금등 자동이체 (CMS, 지로(지방세포함), 펌뱅킹, 스쿨뱅킹, 키즈뱅킹, 아파트관리비 포함), 계좌간 자동이체(타행자동이체 포함), 정기예금·정기적금·수익증권·신탁·방카슈랑스 가입금액 또는 적립금 자동이체거래 제외");
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
            System.out.println("월 납입 금액을 설정해주세요. (월 최대 20만원 최소 1000원)");
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

        System.out.println("고객님의 광주은행 장병내일준비적금 만기 시 세전 금액은 " + intAmount + "입니다.");
        System.exit(0);
    }//calculate
}//class