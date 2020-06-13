package com.devglan.thread.immutable;

public class ImmutableStudent {

    //With immutable classes, states are never modified; every modification of a state results in a new instance,
    // hence each thread would use a different instance and developers wouldn’t worry about concurrent modifications.
    //Also, since it is created ina thread pool any may be any other thread might be referencing it and hence it can't be changed

    //make your class final so that can't be inherited
    //make all fields as final and private so that it is initialised only once inside constructor
    //no public setters methods
    //public getters method
    //while manipulating the state of the object using any setter method or with other means, always create a new object and return
    //If the class holds a mutable object:
      //during instantiation inside a constructor, create a new reference of the object and then assign.

    private final int id;
    private final String name;
    private final Age age;
    //all are final and hence need to initialise via constructor
    public ImmutableStudent(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        //during instantiation inside a constructor, create a new reference of the object and then assign.
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Age getAge() {
        //as Age class is mutable, use might invoke getAge() which returns a mutable age instance and this might get modified
        //hence, for mutable object create a new instance and then return
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        return cloneAge;
    }

}
