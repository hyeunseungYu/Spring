//package mySelectShopBeta.controller;
//
//import lombok.RequiredArgsConstructor;
//import mySelectShopBeta.Dto.FolderRequestDto;
//import mySelectShopBeta.entity.Folder;
//import mySelectShopBeta.entity.Product;
//import mySelectShopBeta.security.UserDetailsImpl;
//import mySelectShopBeta.service.FolderService;
//import org.springframework.data.domain.Page;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class FolderController {
//
//    private final FolderService folderService;
//
//    @PostMapping("/folders")
//    public List<Folder> addFolders(
//            @RequestBody FolderRequestDto folderRequestDto,
//            @AuthenticationPrincipal UserDetailsImpl userDetails
//    ) {
//
//        List<String> folderNames = folderRequestDto.getFolderNames();
//
//        return folderService.addFolders(folderNames, userDetails.getUsername());
//    }
//
//    // 회원이 등록한 모든 폴더 조회
//    @GetMapping("/folders")
//    public List<Folder> getFolders(
//            @AuthenticationPrincipal UserDetailsImpl userDetails
//    ) {
//        return folderService.getFolders(userDetails.getUser());
//    }
//
//    // 회원이 등록한 폴더 내 모든 상품 조회
//    @GetMapping("/folders/{folderId}/products")
//    public Page<Product> getProductsInFolder(
//            @PathVariable Long folderId,
//            @RequestParam int page,
//            @RequestParam int size,
//            @RequestParam String sortBy,
//            @RequestParam boolean isAsc,
//            @AuthenticationPrincipal UserDetailsImpl userDetails
//    ) {
//        return folderService.getProductsInFolder(
//                folderId,
//                page-1,
//                size,
//                sortBy,
//                isAsc,
//                userDetails.getUser()
//        );
//    }
//
//}