package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtDemo {

    // 秘钥
//    private static final String SECRET_KEY = "2132143563463";

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 创建JWT
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        // 设置JWT签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 设置JWT的过期时间
        long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);

        // 创建JWT
        return Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setIssuer(issuer)
                .setSubject(subject)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 验证JWT
    public static Claims parseJWT(String jwt) {
        try {
            // 解析JWT
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (JwtException e) {
            // JWT不合法或已过期
            return null;
        }
    }

    public static void main(String[] args) {
        // 创建一个JWT
        String jwt = createJWT("123", "issuer", "subject", 3600000); // 有效期1小时
        System.out.println("JWT: " + jwt);

        // 解析和验证JWT
        Claims claims = parseJWT(jwt);
        if (claims != null) {
            System.out.println("ID: " + claims.getId());
            System.out.println("Issuer: " + claims.getIssuer());
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Expiration: " + claims.getExpiration());
        } else {
            System.out.println("JWT is not valid or expired");
        }
    }
}


/* eyJhbGciOiJIUzI1NiJ9 . eyJqdGkiOiIxMjMiLCJpYXQiOjE3MjAwMTM3NzksImlzcyI6Imlzc3VlciIsInN1YiI6InN1YmplY3QiLCJleHAiOjE3MjAwMTczNzl9 . WZVNRu4q6HsdTOua17SdOMEUwQfm5HckgKzuJlamb6k
        Base64编码：不是加密算法
        加密算法                                用户信息 Payload                                                                               密文（签名）

        private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);  服务器私有的。
        UserName = zs -> ls ;
                        eyJqdGkiOiIxMjMiLCJpYXQiOjE3MjAwMTM3Nabcdef6Imlzc3VlciIsInN1YiI6InN1YmplY3QiLCJleHAiOjE3MjAwMTczNzl9

 */
