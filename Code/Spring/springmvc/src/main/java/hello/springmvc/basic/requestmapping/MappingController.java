package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping-v1")
    public String GetV1() {
        log.info("GetV1");
        return "ok";

    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVarible userId
     */
    @GetMapping("/mappingv1/{userId}")
    public String mappingPathV1(@PathVariable("userId") String data){
        log.info("mapping path = {}",data);
        return "ok";
    }
    @GetMapping("/mappingv2/{Id}")
    public String mappingPathV2(@PathVariable String Id){
        log.info("mapping path = {}",Id);
        return "ok";
    }
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathV3(@PathVariable String userId,@PathVariable String orderId){
        log.info("userId = {}, orderId = {}", userId,orderId);
        return "ok";
    }
    // 여기서 소비는 서버가 고객이 보낸걸 소비한다는 의미로 생각해야한다.
    // 여기서는 header에 content-type과 맞춰야한다.
    @PostMapping(value = "/mapping-consume",consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }
    // header의 Accept와 맞춰야 한다.
    // 생산이란 것은 서버가 클라이언트를 위해서 만드는 것이고, header에서 받는 클라이언트가 받아드리는 타입에 맞아야하므로
    // header의 Accept와 맞춘다.
    @PostMapping(value = "/mapping-produce",consumes = "text/html")
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }

}
