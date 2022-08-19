package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    //url 매핑
    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }
    /**
     * 편리한 축약 애노테이션 (코드보기) * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     *
     *
     * PathVariable 사용
     * 변수명이 같으면 생략가능
     *
     * @PahtVariable("userId") String userID -> @PathVariable userId
     * /mapping/userA url 자체에 값이 들어가있음
     */
//    @GetMapping("/mapping/{userId}")
//    public String mappingPath(@PathVariable("userId") String data){
//        log.info("mappingPath userId = {}",data);
//        return "ok";
//    }
//    //변수명이 같음녀 생략가능
//    @GetMapping("/mapping/{userId}")
//    public String mappingPath1(@PathVariable String userId){
//        log.info("mappingPath userId = {}",userId);
//        return "ok";
//    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    /**
     *특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
/**
 * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
 *     * consumes="!application/json"
 *    * consumes="application/*"
 *    * consumes="*\/*"
 *    * MediaType.APPLICATION_JSON_VALUE
 *    요청해더의 컨텐트 타입
 * */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
         log.info("mappingConsumes");
         return "ok";
    }
    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     * 요청 헤더의 accept
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
