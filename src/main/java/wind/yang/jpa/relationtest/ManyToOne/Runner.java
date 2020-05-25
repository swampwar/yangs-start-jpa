package wind.yang.jpa.relationtest.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class Runner implements ApplicationRunner {
    @Autowired
    CarRepository carRepository;
    @Autowired
    HumanRepository humanRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Human human = new Human();
        human.setName("하이루");
//        humanRepository.save(human);

        Car car = new Car();
        car.setType("A Type");
        car.setNumber(1234);
        car.setOwner(human);

//        carRepository.save(car);
    }
}
