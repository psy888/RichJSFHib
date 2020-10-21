package richjsf;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import richjsf.dao.CoffeeDao;
import richjsf.entity.CoffeeType;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Data
public class Main implements CommandLineRunner{
    private CoffeeDao repository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        List<CoffeeType> coffeeTypeList = new ArrayList<>(5);
//        for (int i = 0; i < 5; i++) {
//            CoffeeType ct = new CoffeeType();
//            ct.setName("CoffeeType " + i);
//            coffeeTypeList.add(ct);
//        }
//        repository.addAllCoffeeTypes(coffeeTypeList);
    }
}


