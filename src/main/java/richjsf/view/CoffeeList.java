package richjsf.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import richjsf.entity.CoffeeType;
import richjsf.service.CoffeeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

//@ManagedBean(name = "coffeeList", eager = true)
//@SessionScoped
@Component
@Scope("view")
@Data
public class CoffeeList {

    @Autowired
    private CoffeeService coffeeService;

    private String coffeeName = "illy";
    private String coffeeName2 = "Nescafe";

    public List<CoffeeType> getCoffeeList(){
        return coffeeService.getCoffeeTypes();
    }

    public void addDummyData(){
        coffeeService.addDummyData();
    }
}
