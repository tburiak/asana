package org.tbur.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static String toNonBreakingSpace(String string) {
        return string.replace(' ', '\u00A0');
    }
}
