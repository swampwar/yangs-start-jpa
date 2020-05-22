package wind.yang.jpa.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestSaveEventListener implements ApplicationListener<TestSaveEvent> {
    @Override
    public void onApplicationEvent(TestSaveEvent event) {
        System.out.println("--------------------------------");
        System.out.println(event.getTestEntity().getName() + " 등록 이벤트 발생!");
        System.out.println("--------------------------------");
    }
}
