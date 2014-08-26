/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.model;

/**
 *
 * @author crme1980
 */
public class IntHelper {

    public static int parseInt(String toparse) {
        try {
            return Integer.parseInt(toparse);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
