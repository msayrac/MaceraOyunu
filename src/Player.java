import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {

        this.name = name;
        this.inventory=new Inventory();
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }





    public void selectChar() {

        System.out.println("---- Karakterler ----");
        System.out.println("----------------------");


        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        for (GameChar gameChar : charList) {

            System.out.println("ID : "+gameChar.getId() +" Karakter : " + gameChar.getName() +
                    "\t Hasar :" + gameChar.getDamage() +
                    "\t Saglik : " + gameChar.getHealth() +
                    "\t Para : " + gameChar.getMoney());
        }

        System.out.println("----------------------");
        System.out.println("Lutfen bir karakter giriniz ! : ");
        int selectChar = input.nextInt();

        switch(selectChar){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /* System.out.println("Karakter : "+ this.getCharName()+ ", "
                + "Hasar : "+ this.getHealth() +", "+ "Saglik : "
                + this.getHealth() + ", "+ "Para : "+ this.getMoney());

                */
    }


    public void initPlayer(GameChar gameChar){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){

        System.out.println("Silah :" + this.getInventory().getWeapon().getName() +
                ", zirh : " + this.getInventory().getArmor().getName() +
                ", Bloklama : "+ this.getInventory().getArmor().getBlock() +
                ", Hasar : "+ this.getTotalDamage() +
                ", Saglik : " + this.getHealth() +
                ", Para : " + this.getMoney());


    }

    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }

        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
