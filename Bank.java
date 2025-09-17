package PHY.O910.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;
        List<Account> accounts = new ArrayList<>();

        while (true) {
            System.out.println("★★★★　J-BANK　★★★★");
            System.out.println("ㅣㅣ1.新規口座の登録ㅣㅣ");
            System.out.println("ㅣㅣ2.口座照会     ㅣㅣ");
            System.out.println("ㅣㅣ3.入れ込み     ㅣㅣ");
            System.out.println("ㅣㅣ4.引き出し     ㅣㅣ");
            System.out.println("ㅣㅣ5.振り込み     ㅣㅣ");
            System.out.println("ㅣㅣ9.終了        ㅣㅣ");

            System.out.print("番号入力：　");
            select = sc.nextInt();
            sc.nextLine();


            switch (select) {
                case 1:
                    makeAccount makeAccount = new makeAccount();
                    Account account = makeAccount.createAccount();
                    accounts.add(account);
                    break;

                case 2:
                    System.out.println("＝＝＝＝口座照会＝＝＝＝");
                    System.out.println("口座番号を入力してください。");
                    System.out.print("口座番号 : ");
                    String searchAcc = sc.nextLine();
                    boolean find = false;
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(searchAcc)) {
                            System.out.println("名前を入力してください。");
                            System.out.print("名前 : ");
                            String searchName = sc.nextLine();
                            if (acc.getName().equals(searchName)) {
                                acc.print();
                                find = true;
                                break;
                            }
                        }
                    }
                    if (!find) {
                        System.out.println("情報を確認してください。");
                    }
                    break;

                case 3:
                    System.out.print("口座番号：");
                    String accNum = sc.nextLine();
                    Account target = null;
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(accNum)) {
                            target = acc;
                            break;
                        }
                    }
                    if (target != null) {
                        System.out.print("入金金額：");
                        long amount = sc.nextLong();
                        target.deposit(amount);
                        System.out.println("入金完了。　残額：" + target.getBalance() + "円");
                    }
                    break;

                case 4:
                    System.out.print("口座番号：");
                    accNum = sc.nextLine();
                    target = null;
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(accNum)) {
                            target = acc;
                            break;
                        }
                    }
                    if (target != null) {
                        System.out.print("出金金額：");
                        long amount = sc.nextLong();
                        target.withdraw(amount);
                        System.out.println("出金完了。　残額：" + target.getBalance() + "円");
                    }
                    break;
                    
                case 9:
                    System.out.println("J-BANK 終了");
                    return;
            }

        }
    }
}


// 계좌의 정보를 조회하기
// 민서님이 34243계좌에 돈을 추가로 입금한다
// 행근이 등장 = 새 손님 객체 생성하는것
// 행근이가 새 계좌객체 생성
// 민서님이 another 새 계좌객체 생성
// 민서님이 행근이한테 돈 보내기