package com.fennec.freelanceproject.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class SecurityConstant {

    public static final String  AUTH_LOGIN_URL = "/api/authenticate";

    // Signing key for HS512 algorithm
    // You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
    //public static final String JWT_SECRET = "FENNEC_IT_202";
    public static final String JWT_SECRET = "FENNEC_IT_2020";


    //creates a spec-compliant secure-random key:
    public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); //or HS384 or HS512


    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final long TOKEN_EXPIRATION_TIME = 864_000_000;
}
