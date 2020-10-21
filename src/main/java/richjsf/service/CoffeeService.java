package richjsf.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import richjsf.dao.CoffeeDao;
import richjsf.entity.CoffeeType;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class CoffeeService {

    @Autowired
    private CoffeeDao coffeeDao;

    public List<CoffeeType> getCoffeeTypes(){
        return coffeeDao.getAllCoffeeTypes();
    }

    public void addDummyData(){
        coffeeDao.dummyData();
    }
}
