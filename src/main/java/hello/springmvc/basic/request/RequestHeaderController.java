package hello.springmvc.basic.request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Slf4j //log찍을 수 있는 어노테이션
@RestController //응답 값으로 view를 찾는게 아니라 문자를 html에 담아서 반환
public class RequestHeaderController {

    //어노테이션 기반의 컨트롤러는 다양한 파라미터를 받을 수 있다.
    //인터페이스로 정형화 하지 않았기 때문에 가능하다다
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String>
                                  headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false)
                                  String cookie
    ) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}






