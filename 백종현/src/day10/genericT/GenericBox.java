package day10.genericT;


public class GenericBox <T>{
    T object;

    public GenericBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public void printObject(){
        System.out.println(object.getClass().getSimpleName() + " box");
        System.out.println(object);
    }
}
