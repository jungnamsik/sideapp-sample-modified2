package com.dooray.sideapp.util;

import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {
    private static final String BEARER = "Bearer ";
    private static final int BEARER_LEN = 7;

    public static Map<String, Object> parseJws(final String key, final String jwsString) {
        Algorithm alg = Algorithm.HMAC512(key);
        JWTVerifier verifier = JWT.require(alg).build();
        DecodedJWT decode = verifier.verify(jwsString);
	    System.out.println(">>>" + decode.getPayload());
        return decode.getClaims()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, x -> x.getValue().asString()));
    }

    public static Map<String, Object> parseJwsOnAuthorizationHeader(final String key, final String jwsStringOnHeader) throws GeneralSecurityException {
        int pos = jwsStringOnHeader.indexOf(BEARER);
        if (pos == -1) {
            throw new GeneralSecurityException("Invalid Jws Value");
        }


        return parseJws(key, jwsStringOnHeader.substring(pos + BEARER_LEN));
    }


}
