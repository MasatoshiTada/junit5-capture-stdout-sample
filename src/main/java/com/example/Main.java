package com.example;

/**
 * テスト対象クラス
 */
public class Main {

    /*
     * このメソッドの標準出力をテストする
     */
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Hello!");
        } else {
            System.out.println("Hello, " + args[0] + "!");
        }
    }
}
