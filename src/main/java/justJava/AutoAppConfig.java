package justJava;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //컴포넌트 스캔으로 쭉 찾아볼 때, 뭘 빼고싶은지 지정
        //AppConfig는 이미 수동으로 빈을 등록했으니 자동으로 찾으면 안됨! 그리고 AppConfig의 Configuration도 들어가보면 이미 컴포넌트 어노테이션이 적용되어있음
        //즉, 얘도 자동 스캔 대상이 되어버리기 때문에 제외시키는 것
        //일반적으론 configuration을 빼지는 않는데, 그냥 예제를 남겨두려고 하는 것
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
