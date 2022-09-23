//package spring.securityBasic.form;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import spring.securityBasic.account.AccountContext;
//import spring.securityBasic.account.AccountRepository;
//
//import java.security.Principal;
//
//@Controller
//public class SampleControllerV1 {
//    @Autowired
//    SampleService sampleService;
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @GetMapping("/")
//    public String index(Model model, Principal principal) {
//        if (principal == null) {
//            model.addAttribute("message", "Hello Spring Security");
//        } else {
//            model.addAttribute("message", "Hello "+principal.getName());
//        }
//
//        return "index";
//    }
//    @GetMapping("/info")
//    public String info(Model model) {
//        model.addAttribute("message", "Info!");
//        return "info";
//    }
//    @GetMapping("/dashboard")
//    public String dashboard(Model model, Principal principal) {
//        model.addAttribute("message", "Hello "+ principal.getName());
//        AccountContext.setAccount(accountRepository.findByUsername(principal.getName()));
//        sampleService.dashboard();
//        return "dashboard";
//    }
//    @GetMapping("/admin")
//    public String admin(Model model, Principal principal) {
//        model.addAttribute("message", "Hello Admin Spring! Security "+principal.getName());
//        return "admin";
//    }
//}
