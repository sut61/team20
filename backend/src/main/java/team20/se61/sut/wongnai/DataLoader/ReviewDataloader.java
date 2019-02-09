package team20.se61.sut.wongnai.DataLoader;

import team20.se61.sut.wongnai.Entity.DayOfWeek;
import team20.se61.sut.wongnai.Entity.NumberOfSeat;
import team20.se61.sut.wongnai.Entity.PricePerHead;
import team20.se61.sut.wongnai.Entity.PriceRange;
import team20.se61.sut.wongnai.Entity.Rating;
import team20.se61.sut.wongnai.Repository.DayOfWeekRepository;
import team20.se61.sut.wongnai.Repository.NumberOfSeatRepository;
import team20.se61.sut.wongnai.Repository.PricePerHeadRepository;
import team20.se61.sut.wongnai.Repository.PriceRangeRepository;
import team20.se61.sut.wongnai.Repository.RatingRepository;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataloader implements ApplicationRunner {

    @Autowired PricePerHeadRepository pricePerHeadRepository;
    @Autowired RatingRepository ratingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Stream.of("ต่ำกว่า 100 บาท", "101-250 บาท", "251-500 บาท", "101-250 บาท", "501-1000 บาท", "มากกว่า 1000 บาท").forEach(price -> { 
            pricePerHeadRepository.save(new PricePerHead(price));            
        });

        Stream.of("1","2","3","4","5").forEach(rating -> { 
            ratingRepository.save(new Rating(rating));            
        });

        pricePerHeadRepository.findAll().forEach(System.out::println);
        ratingRepository.findAll().forEach(System.out::println);

	}
    
}