package com.resource.energy.util;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 */

public enum AppUtil {

    INSTANCE;

    public final boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);
    }

    public final String createRequestSecretKeySignedString(String encryptedRequest, String encryptedKey, String signature){
        return String.format("%s[[[[%s]]]]%s", encryptedRequest, encryptedKey, signature);
    }

    public static void main(String[] args) {


        for (int i = 1; i <= 5; i++){
            if (i == 2)
                continue;
            System.out.println(i + " = " + 5 * i);
        }

    }
}
