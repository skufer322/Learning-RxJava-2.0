package chapter_03.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_02_Cast {

    public static void main(String[] args){
        Child child1 = new Child("Name1", "Property1");
        Child child2 = new Child("Name2", "Property2");
        Observable.just(child1, child2)
                .cast(Parent.class)
                .subscribe(parent -> System.out.println("parent.name: " + parent.getName()));
    }

    private static class Child extends Parent {
        private String childProperty;

        public Child(String name, String childProperty){
            super(name);
            this.childProperty = childProperty;
        }

        public String getChildProperty(){
            return this.childProperty;
        }
    }

    private static class Parent {
        private String name;

        public Parent(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }
}
