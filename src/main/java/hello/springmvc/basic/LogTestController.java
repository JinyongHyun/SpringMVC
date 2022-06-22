package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller 를 붙였을때 String으로 리턴값을 정했을때 view 이름이 반환된다.
//RestController를 붙이면 String 문자가 반환된다
@RestController
public class LogTestController {
    private final Logger log =LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name="Spring";

        System.out.println("name=" +name);

        //로그의 상태,레벨을 보여주는 것
        //application.properties 참고
        //위에서 부터 심각한 레벨

//        log.trace("trace log={}"+name); 이렇게 쓰면 연산이 일어나 불필요한 리소스 사용 (자바연산특징 )

        log.trace("trace log={}",name); //해당 파일 전체 로그를 보겠다는 의미
        log.debug("debug log={}",name); //개발서버에서 보는 로그
        log.info("info log={}",name); //운영시스템 또는 비지니스쪽 정보
        log.warn("warn log={}",name); //경고
        log.error("error log={}",name); //에러러

        return "ok";
    }
}
