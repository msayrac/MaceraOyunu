public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Magazaya Hosgeldiniz ! -------");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Cikis Yap");
        System.out.print("Seciminiz : ");
        int selectCase = Location.input.nextInt();

        while(selectCase<1 || selectCase>3){
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectCase = input.nextInt();

        }

        switch (selectCase){
            case 1 :
                printWeapon();
                buyWeapon();
                break;
            case 2 :
                printArmor();
                break;
            case 3 :
                System.out.println("Bir daha bekleriz");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println(" ---- Silahlar ! ----");
        System.out.println("");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " +w.getName() + " <Para : "+w.getPrice() + " , Haar : " + w.getDamage());
        }
    }

    public void buyWeapon(){
        System.out.print("Bir silah seciniz : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Gecersiz deger, tekrar giriniz");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice()> this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir !");
            } else {

                // Satin almanin gerceklestigi alan
                System.out.println(selectedWeapon.getName()+ " Silahini satin aldiniz !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);

                System.out.println("Kalan paraniz : "+ this.getPlayer().getMoney());
                System.out.println("Onceki silahiniz : "+ this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }

    }

    public void printArmor(){
        System.out.println("Zirhlar !");
    }

    public void menu(){

        System.out.println("Menu den seçim yapabilirsiniz ");

    }

    public void buy(){

        System.out.println(getPlayer().getMoney() +"Satın alınma islemi yapıldı.");

    }


}
