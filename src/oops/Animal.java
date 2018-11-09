package oops;

 class Animal {
    public void animalSound(){
        System.out.println("Animals Make Sound");
    }
}
class Dogs extends Animal{

    @Override
    public void animalSound() {
        System.out.println("Woof");

    }

    public static void main(String[] args) {
        Dogs obj=new Dogs();
        obj.animalSound();
    }
}

