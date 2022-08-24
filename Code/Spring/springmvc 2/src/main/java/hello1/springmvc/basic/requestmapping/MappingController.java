package hello1.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 기본 요청
     * 둘다 허용 /hello-basic, /hello-basic/
     * HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping("hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1",method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "ok";
    }
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId ->@PathVariable userId
     */
    @GetMapping("/mappingV1/{userId}")
    public String mappingPathV1(@PathVariable("userId") String data){
        log.info("mappingPathV1 userId={}",data);
        return "ok";
    }

    @GetMapping("/mappingV2/{userId}")
    public String mappingPathV2(@PathVariable String userId){
        log.info("mappingPathV2 userId={}",userId);
        return "ok";
    }
    @GetMapping("/mappingV3/users/{userId}/orders/{orderId}")
    public String mappingPathV3(@PathVariable String userId,@PathVariable String orderId){
        log.info("mappingPathV2 userId={}, orderId={}",userId,orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode",
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug","data=good"} or조건
     */
    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }
    @GetMapping(value = "/mapping-header",headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume",consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value = "/mapping-produce",consumes = "text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }
}
