package cn.课堂学习.面向对象.多态;

/*
 * 这是父类
 *
 */
public class Pet {
    private String petName;
    private String ownerName;

    //玩耍--父类方法
    public  void  playWithOwner(Pet pet){
        System.out.println("这是父类方法");
        System. out . println( pet. getPetName()+"正在和主人"+pet . getOwnerName( )+"愉快的玩耍。" ) ;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
