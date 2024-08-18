import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
//      은행 배열
        String[] bankNames = {
                "IBK기업은행", "우리은행", "신한은행", "광주은행", "하나은행",
                "경남은행", "DGB대구은행", "SH수협은행", "제주은행", "KB국민은행",
                "NH농협은행", "전북은행", "부산은행"
        };
//        인트로
        System.out.println("=====================================");
        System.out.println("=============군인적금 비교=============");
        System.out.println("=====================================");

        Scanner sc = new Scanner(System.in);
        
//      이름
        System.out.println("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.println("군인이신가요? : ");
        System.out.println("★현역병, 상근예비역, 의무경찰, 해양의무경찰, 의무소방원, 사회복무요원, 대체복무요원에 한함");
        System.out.println("[1] 예 [2] 아니요");
        
//      자격여부
        int qualify = sc.nextInt();
        switch (qualify) {
            case 1:
                System.out.println("적금 가입대상입니다.");
                System.out.println("①이 적금 신규일 기준으로 남은 의무복무기간이 6개월 이상");
                System.out.println("② 가입대상임을 증빙하는 \"장병내일준비적금 가입자격확인서\" 제출해야합니다.");
                break;
            case 2:
                System.out.println("적금가입대상이 아닙니다.");
                System.out.println("다른 서비스를 이용해주세요.");
                System.exit(0);
        }

//      은행 선택
        System.out.println("은행을 선택해주세요.");
        for (int i = 0; i < bankNames.length; i++) {
            System.out.println("[" + (i + 1) + "] " + bankNames[i]);
        }
        int bankIndex = sc.nextInt() - 1;

        if (bankIndex >= 0 && bankIndex < bankNames.length) {
            System.out.println(bankNames[bankIndex] + " 장병내일준비적금입니다.");
        } else {
            System.out.println("잘못된 은행을 선택하셨습니다.");
        }

//      은행별 계산식 불러오기
        switch (bankIndex+1) {
            case 1:
                Ibk ibk = new Ibk();
                ibk.calculte();
            case 2:
                Woori woori = new Woori();
                woori.calculte();
            case 3:
                ShinHan shinHan = new ShinHan();
                shinHan.calculte();
            case 4:
                Kjb kjb = new Kjb();
                kjb.calculte();
            case 5:
                Hana hana = new Hana();
                hana.calculte();
            case 6:
                Kn kn = new Kn();
                kn.calculte();
            case 7:
                Dgb dgb = new Dgb();
                dgb.calculte();
            case 8:
                Sh sh = new Sh();
                sh.calculte();
            case 9:
                Jeju jeju = new Jeju();
                jeju.calculte();
            case 10:
                Kb kb = new Kb();
                kb.calculte();
            case 11:
                Nh nh = new Nh();
                nh.calculte();
            case 12:
                Jb jb = new Jb();
                jb.calculte();
            case 13:
                Bs bs = new Bs();
                bs.calculte();
        }
    }
}


