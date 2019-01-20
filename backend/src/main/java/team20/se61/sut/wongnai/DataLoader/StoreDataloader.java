package team20.se61.sut.wongnai.DataLoader;

import team20.se61.sut.wongnai.Entity.NumberOfSeat;
import team20.se61.sut.wongnai.Entity.PriceRange;
import team20.se61.sut.wongnai.Repository.NumberOfSeatRepository;
import team20.se61.sut.wongnai.Repository.PriceRangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StoreDataloader implements ApplicationRunner {

    @Autowired private PriceRangeRepository priceRangeRepository;
    @Autowired private NumberOfSeatRepository numberOfSeatRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        priceRangeRepository.save(new PriceRange("ต่ำกว่า 100 บาท"));
        priceRangeRepository.save(new PriceRange("101 - 250 บาท"));
        priceRangeRepository.save(new PriceRange("215 - 500 บาท"));
        priceRangeRepository.save(new PriceRange("501 - 1000 บาท"));
        priceRangeRepository.save(new PriceRange("มากกว่า 1,000 บาท"));

        numberOfSeatRepository.save(new NumberOfSeat("ไม่มีที่นั้ง/จัดส่งเท่านั้น"));
        numberOfSeatRepository.save(new NumberOfSeat("ไม่เกิน 10 ที่นั้ง"));
        numberOfSeatRepository.save(new NumberOfSeat("11 - 40 ที่นั้ง"));
        numberOfSeatRepository.save(new NumberOfSeat("41 - 80 ที่นั้ง"));
        numberOfSeatRepository.save(new NumberOfSeat("81 - 150  ที่นั้ง"));
        numberOfSeatRepository.save(new NumberOfSeat("มากกว่า 150 ที่นั้ง"));

        priceRangeRepository.findAll().forEach(System.out::println);
        numberOfSeatRepository.findAll().forEach(System.out::println);

	}
    
}