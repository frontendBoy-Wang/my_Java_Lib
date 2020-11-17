package cn.课堂学习.面向对象.多态;
//编写子类Dog对父类的playWithOwner方法进行重写。
public class Dog  extends Pet{
    private String petName;
    private String ownerName;

    @Override
    public String getPetName() {
        return petName;
    }

    @Override
    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void playWithOwner(Dog dog) {
        System.out.println("这是子类重写的方法");
        System.out.println(dog.getPetName() + "正在和主人" + dog.getOwnerName() + "愉快的玩耍。");
    }

    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setPetName("妲己");
        pet.setOwnerName("");
        pet.playWithOwner(pet);

        Dog dog = new Dog();
        dog.setPetName("二毛");
        dog.setOwnerName("wmq");
        dog.playWithOwner(dog);
    }
}
