package day10.genericT;

public class FoodBox <F extends Food>{
    F object;

    public FoodBox(F object){
        this.object = object;
    }

    public void setObject(F object){
        this.object = object;
    }

    public F getObject(){
        return object;
    }

    public void printObject(){
        System.out.println(object.getClass().getSimpleName() + " box");
        System.out.println(object);
    }
}
