package org.practice.common.core.util;

import java.util.regex.Pattern;

public class PatternCheckUtils {


    public static final Pattern CHINA_PHONE_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");

    public static final Pattern SEX_PATTERN = Pattern.compile("(男|女|保密)");

    public static final Pattern LOGIN_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,30}$");

    public static final Pattern REAL_NAME_PATTERN = Pattern.compile("[\u4e00-\u9fa5]{2,30}");

    public static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z0-9\u4e00-\u9fa5]{1,30}");

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

    public static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3456789]\\d{9}$");

    public static final Pattern MOBILE_CAPTCHA_PATTERN = Pattern.compile("^\\d{6}$");

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-z]|[A-Z]|[0-9]){8,20}$");

    public static boolean checkChinaPhone(String phone) {
        return check(CHINA_PHONE_PATTERN, phone);
    }

    public static boolean checkSex(String sex) {
        return check(SEX_PATTERN, sex);
    }

    public static boolean checkEmail(String email) {
        return check(EMAIL_PATTERN, email);
    }

    public static boolean checkLoginName(String loginName) {
        return check(LOGIN_NAME_PATTERN, loginName);
    }

    public static boolean checkRealNamePattern(String realName) {
        return check(REAL_NAME_PATTERN, realName);
    }

    public static boolean checkNamePattern(String name) {
        return check(NAME_PATTERN, name);
    }

    public static boolean check(Pattern pattern, String target) {
        return pattern.matcher(target).matches();
    }
}
