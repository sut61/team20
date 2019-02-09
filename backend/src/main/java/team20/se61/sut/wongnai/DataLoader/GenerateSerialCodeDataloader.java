package team20.se61.sut.wongnai.DataLoader;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GenerateSerialCodeDataloader implements ApplicationRunner {

    @Autowired
    private SerialCodeRepository serialCodeRepository;
    @Autowired
    private CodeConditionRepository codeConditionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nameCondition[] = { "เมื่อซื้อครบ 50 บาท", "เมื่อซื้อครบ 100 บาท", "เมื่อซื้อครบ 250 บาท",
                "เมื่อซื้อครบ 500 บาท", "เมื่อซื้อครบ 750 บาท", "เมื่อซื้อครบ 1000 บาท" };
        String detailCondition[] = { "เมื่อซื้อครบ 50 บาท", "เมื่อซื้อครบ 100 บาท", "เมื่อซื้อครบ 250 บาท",
                "เมื่อซื้อครบ 500 บาท", "เมื่อซื้อครบ 750 บาท", "เมื่อซื้อครบ 1000 บาท" };

        for (int i = 0; i < nameCondition.length; i++) {
            CodeCondition newCondition = new CodeCondition();
            newCondition.setName(nameCondition[i]);
            newCondition.setDetail(detailCondition[i]);
            codeConditionRepository.save(newCondition);
        }

        codeConditionRepository.findAll().forEach(System.out::println);
    }

}
