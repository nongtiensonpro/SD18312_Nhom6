/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author Nong_Tien_Son
 */
public class CheckText {
    public static boolean checkAtExists(String str) {
        return str.contains("@");
    }
    public static String removeAt(String str) {
        return str.replace("@", "");
    }
}
