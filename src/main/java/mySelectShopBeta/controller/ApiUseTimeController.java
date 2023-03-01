//package mySelectShopBeta.controller;
//
//import lombok.RequiredArgsConstructor;
//import mySelectShopBeta.entity.ApiUseTime;
//import mySelectShopBeta.entity.UserRoleEnum;
//import mySelectShopBeta.repository.ApiUseTimeRepository;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ApiUseTimeController {
//
//    private final ApiUseTimeRepository apiUseTimeRepository;
//
//    @GetMapping("/api/use/time")
//    @Secured(UserRoleEnum.Authority.ADMIN)
//    public List<ApiUseTime> getAllApiUseTime() {
//        return apiUseTimeRepository.findAll();
//    }
//}