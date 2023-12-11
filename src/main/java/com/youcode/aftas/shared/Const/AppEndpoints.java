package com.youcode.aftas.shared.Const;


import org.springframework.stereotype.Component;

@Component
public class AppEndpoints {
    public static   final  String VERSION_1 = "/api/v1";
    public static final  String VERSION_2 = "/api/v2";
    public  static final  String VERSION_3 = "/api/v3";
    public static final  String VERSION = VERSION_1;
    public static final   String IDENTITY_DOCUMENT_TYPE = VERSION + "/identity-documents";
    public static  final  String USER_ENDPOINT = VERSION + "/users";
    public static  final  String DEMAND_ENDPOINT = VERSION + "/demands";
    public static  final  String FIREBASE_ENDPOINT = VERSION + "/firebase";

    public static final String MEMBER = VERSION + "/members";
}
