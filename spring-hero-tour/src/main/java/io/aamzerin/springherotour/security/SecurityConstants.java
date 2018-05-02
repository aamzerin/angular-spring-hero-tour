package io.aamzerin.springherotour.security;

public class SecurityConstants {
	
    public static final String SECRET = "Y0urS3cRet";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "SsnTkn_";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    
}