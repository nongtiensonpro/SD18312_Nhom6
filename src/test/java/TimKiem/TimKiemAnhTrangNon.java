/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TimKiem;

/**
 *
 * @author Nong_Tien_Son
 */
public class TimKiemAnhTrangNon {
    public static boolean checkAtExists(String str) {
        return str.contains("@");
    }
    public static String removeAt(String str) {
        return str.replace("@", "");
    }
    public static void main(String[] args) {
        String str = "@Meo";

        boolean newStr = checkAtExists(str);
        System.out.println(newStr);
        if (checkAtExists(str)) {
            System.out.println(removeAt(str).trim());
        }

    }
}
