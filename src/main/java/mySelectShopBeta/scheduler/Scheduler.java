package mySelectShopBeta.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mySelectShopBeta.entity.Product;
import mySelectShopBeta.naver.dto.ItemDto;
import mySelectShopBeta.naver.service.NaverApiService;
import mySelectShopBeta.naver.service.ProductService;
import mySelectShopBeta.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final NaverApiService naverApiService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    // 초, 분, 시, 일, 월, 주 순서
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        log.info("가격 업데이트 실행");
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            // 1초에 한 상품 씩 조회합니다 (NAVER 제한)
            TimeUnit.SECONDS.sleep(1);

            String title = product.getTitle();
            List<ItemDto> itemDtoList = naverApiService.searchItems(title);
            ItemDto itemDto = itemDtoList.get(0);

            // i 번째 관심 상품 정보를 업데이트합니다.
            Long id = product.getId();
            productService.updateBySearch(id, itemDto);
        }
    }
}