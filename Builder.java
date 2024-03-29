
class Car {
    public void buildBase() {
        print("������ ������");
    }
    public void buildWheels() {
        print("������ ������");
    }
    public void buildEngine(Engine engine) {
        print("������ ������: " + engine.getEngineType());
    }
    private void print(String msg){
        System.out.println(msg);
    }
}
interface Engine {
    String getEngineType();
}
class OneEngine implements Engine {
    public String getEngineType() {
        return "������ ���������";
    }
}
class TwoEngine implements Engine {
    public String getEngineType() {
        return "������ ���������";
    }
}
abstract class Builder {
    protected Car car;
    public abstract Car buildCar();
}
class OneBuilderImpl extends Builder {
    public OneBuilderImpl(){
        car = new Car();
    }
    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine(engine);
        return car;
    }
}
class TwoBuilderImpl extends Builder {
    public TwoBuilderImpl(){
        car = new Car();
    }
    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine(engine);
        car.buildWheels();
        engine = new TwoEngine();
        car.buildEngine(engine);
        return car;
    }
}
class Build {
    private Builder builder;
    public Build(int i){
        if(i == 1) {
            builder = new OneBuilderImpl();
        } else if(i == 2) {
            builder = new TwoBuilderImpl();
        }
    }
    public Car buildCar(){
        return builder.buildCar();
    }
}

public class BuilderTest {//����
    public static void main(String[] args) {
        Build build = new Build(1);
        build.buildCar();
    }
}
	
