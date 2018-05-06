package lesson16_package.impl;

/**
 * Created by talgat on 04.03.18.
 */
public class Soldeir implements Comparable<Soldeir> {
    String name;
    int age;

    public Soldeir(String name, int age){
        this.name = name;
        this.age = age;
    }



    public boolean equals(Object obj){
        if (obj instanceof Soldeir){
            Soldeir sold = (Soldeir) obj;
            return age == sold.age && name.equals(sold.name);
        }
        return false;
    }

    public String toString(){
        return "The soldier is " + name + " his age is " + age;
    }

    @Override
    public int compareTo(Soldeir o) {
        if (age < o.age){
            return -1;
        } else if (age > o.age){
            return 1;
        } else {
            return 0;
        }
    }
}
