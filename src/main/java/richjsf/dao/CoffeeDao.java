package richjsf.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import richjsf.entity.CoffeeType;

import java.util.ArrayList;
import java.util.List;


@Repository
@Data
@AllArgsConstructor
public class CoffeeDao {

    @Qualifier("sessionF")
    private SessionFactory sessionFactory;

    public List<CoffeeType> getAllCoffeeTypes(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<CoffeeType> list = session.createQuery("From CoffeeType", CoffeeType.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    public void dummyData(){
        List<CoffeeType> coffeeTypeList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            CoffeeType ct = new CoffeeType();
            ct.setName("CoffeeType " + i);
            coffeeTypeList.add(ct);
        }
        this.addAllCoffeeTypes(coffeeTypeList);
    }

    private void addCoffeeType(CoffeeType coffeeType){
        Session session = sessionFactory.openSession();
        session.save(coffeeType);
    }

    public void addAllCoffeeTypes(List<CoffeeType> list){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (CoffeeType coffeeType : list) {
            addCoffeeType(coffeeType);
        }
        transaction.commit();
        session.close();
    }

}
