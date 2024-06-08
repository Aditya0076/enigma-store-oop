package com.enigmastore.helper;


import java.util.Scanner;

public class Helper  {

    private  static Scanner scanner = new Scanner(System.in);
    public static String inputString(String string){
        while (true){
            System.out.printf("%s: ",string);
            String input = scanner.nextLine();
            if(input.isEmpty()||input.isBlank()){
                continue;
            }
            return input;
        }
    }

    public static Integer inputInteger(String integer){
        while (true){
            System.out.printf("%s: ", integer);
            Integer input = scanner.nextInt();
            scanner.nextLine();
            if (input <=0){
                continue;
            }
            return input;
        }
    }

    public static String updateString(String string){
        while (true){
            System.out.printf("%s: ",string);
            String input = scanner.nextLine();
            return input;
        }
    }

    public static Integer updateInteger(String integer){
        while (true){
            System.out.printf("%s: ", integer);
            Integer input = scanner.nextInt();
            scanner.nextLine();
            return input;
        }
    }

}
