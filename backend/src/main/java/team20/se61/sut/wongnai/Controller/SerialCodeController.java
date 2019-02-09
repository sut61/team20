package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.hibernate.type.CalendarDateType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class SerialCodeController {

    @Autowired
    private SerialCodeRepository serialCodeRepository;
    @Autowired
    private CodeConditionRepository codeConditionRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ProfilesRepository profilesRepository;

    @GetMapping("/SerialCode")
    public Collection<SerialCode> serialCodes() {
        return serialCodeRepository.findAll();
    }

    @GetMapping("/SerialCodeCondition")
    public Collection<CodeCondition> CodeConditions() {
        return codeConditionRepository.findAll();
    }

    @GetMapping("/SerialCodeGetStore/{email}")
    public Collection<Store> Stores(@PathVariable String email) {
        return storeRepository.findByBusiness(businessRepository.findByProfile(profilesRepository.findByEmail(email)));
    }

    @PostMapping("/SerialCodes/generate/{storeId}/{conditionId}/{detail}")
    public SerialCode genSeriCode(@PathVariable Long storeId, @PathVariable Long conditionId,
            @PathVariable String detail) {
        SerialCode newCode = new SerialCode();
        String genCode = generateSerialCode();

        newCode.setStore(storeRepository.findById(storeId).get());
        newCode.setCodeCondition(codeConditionRepository.findById(conditionId).get());
        newCode.setDetail(detail);
        newCode.setSerialCode(genCode);
        return serialCodeRepository.save(newCode);
    }

    @PostMapping("/SerialCodes/generate")
    public SerialCode genSerialCode(@RequestBody() Map<String, Object> body) {
        Optional<Store> findStore = storeRepository.findById(Long.valueOf(body.get("storeId").toString()));
        Optional<CodeCondition> findCondition = codeConditionRepository
                .findById(Long.valueOf(body.get("conditionId").toString()));

        for (int i = 1; i <= Integer.valueOf(body.get("genCount").toString()); i++) {
            SerialCode newCode = new SerialCode();
            String genCode = generateSerialCode();
            newCode.setStore(findStore.get());
            newCode.setDetail(body.get("detail").toString());
            newCode.setCodeCondition(findCondition.get());
            newCode.setSerialCode(genCode);
            serialCodeRepository.save(newCode);
        }
        return null;
    }

    public String generateSerialCode() {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String code = "";
        int length = 12;
        do {
            Random rand = new Random();
            for (int i = 0; i < length; i++) {
                code += letters.charAt(rand.nextInt(letters.length()));
            }
        } while (serialCodeRepository.findBySerialCode(code) != null);
        return code;
    }

}
