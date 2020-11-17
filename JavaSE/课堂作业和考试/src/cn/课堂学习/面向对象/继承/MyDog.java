package cn.课堂学习.面向对象.继承;

public class MyDog extends MyPet {
    private String species;//列别

    public MyDog() {
    }

    public MyDog(String species) {
        this.species = species;
    }

    public MyDog(String name, String ownerName, int age, String color, double weight, String species) {
        super(name, ownerName, age, color, weight);
        this.species = species;
    }

    public MyDog(String name, int age, String color, double weight, String ownerName) {
        super(name, ownerName, age, color, weight);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static void main(String[] args) {
        MyDog myDog = new MyDog("阿叼", 3, "白色", 11.0, "汪满青");

       /* myDog.setName("阿叼");
        myDog.setAge(3);
        myDog.setColor("白色");
        myDog.setWeight(12.0);
        myDog.setOwnerName("xxx");*/

        myDog.show();
        myDog.speak();
        myDog.playWithOwner();
    }
}
