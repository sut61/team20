package team20.se61.sut.wongnai.DataLoader;

import team20.se61.sut.wongnai.Entity.PrefixEntity;
import team20.se61.sut.wongnai.Entity.SexEntity;
import team20.se61.sut.wongnai.Repository.PrefixRepository;
import team20.se61.sut.wongnai.Repository.SexRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RegisterDataloader implements ApplicationRunner {

    @Autowired
    private PrefixRepository prefixRepository;
    @Autowired
    private SexRepository sexRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        prefixRepository.save(new PrefixEntity("เด็กชาย"));
        prefixRepository.save(new PrefixEntity("เด็กหญิง"));
        prefixRepository.save(new PrefixEntity("นาย"));
        prefixRepository.save(new PrefixEntity("นางสาว"));
        prefixRepository.save(new PrefixEntity("นาง"));

        sexRepository.save(new SexEntity("ชาย"));
        sexRepository.save(new SexEntity("หญิง"));

        prefixRepository.findAll().forEach(System.out::println);
        sexRepository.findAll().forEach(System.out::println);

	}
    
}