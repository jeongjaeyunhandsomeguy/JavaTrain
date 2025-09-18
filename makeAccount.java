package PHY.O910.bank;

import java.util.Scanner;

public class makeAccount {

    private String generateAC() {
        int front = (int) (Math.random() * 100000);
        int back = (int) (Math.random() * 10000000);
        return String.format("%05d-%07d", front, back);
    }


    public Account createAccount() {
        String accountNumber, name;
        int pw,pw2;
        long balance = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("＝＝＝＝＝口座登録＝＝＝＝＝");
        System.out.print("名前：");
        name = sc.nextLine();


        System.out.print("ご希望の暗証番号：");
        pw = sc.nextInt();
        while (true) {
            System.out.print("暗証番号確認：");
            pw2 = sc.nextInt();
            if (pw==pw2) {
                break;
            }
            System.out.println("暗証番号をご確認ください");
        }

        System.out.print("初期入金額：");
        balance = sc.nextInt();

        accountNumber = generateAC();
        System.out.println("口座が成功されました");
        System.out.println(name+" 様" );
        System.out.println("口座番号：" + accountNumber);
        System.out.println("口座残額：" + balance + "円");

        return new Account(accountNumber, name, balance,pw);
    }
}
