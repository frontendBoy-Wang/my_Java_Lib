package cn.课堂学习.面向对象.多态;
//编写子类Cat对父类的playWithOwner方法进行重写。

public class Cat extends Pet {
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

    //玩耍--重写父类方法override
    public void playWithOwner( Cat cat) {
        System.out.println("这是子类重写的方法");
        System.out.println(cat.getPetName() + "正在和主人" + cat.getOwnerName() + "愉快的玩耍。");
    }

    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setPetName("阿叼");
        pet.setOwnerName("Tom");
        pet.playWithOwner(pet);

        Cat cat = new Cat();
        cat.setPetName("二毛");
        cat.setOwnerName("wmq");
        cat.playWithOwner(cat);

        //在执行子类构造方法之前，系统会先执行父类的构造方法，
        // 父类的构造方法会执行，即意味着创建父类对象
        Pet mao = new Cat();
        mao.setPetName("喵喵");
        mao.setOwnerName("wmq");
        mao.playWithOwner(mao);

//        Cat cat1=new Pet();//创建什么对象，必须执行相应的构造方法

    }
}
