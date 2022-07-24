public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Magazaya Hosgeldiniz ! -------");
        boolean showMenu = true;

        while (showMenu) {

            System.out.println("1 - Silahlar");
            System.out.println("2 - Zirhlar");
            System.out.println("3 - Cikis Yap");
            System.out.print("Seciminiz : ");
            int selectCase = Location.input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Gecersiz deger, tekrar giriniz : ");
                selectCase = input.nextInt();

            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showMenu = false;
                    break;

            }
        }
        return true;


    }

    public void printWeapon() {
        System.out.println(" ---- Silahlar ! ----");
        System.out.println("");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para> : " + w.getPrice() + " , Hasar : " + w.getDamage());
        }
        System.out.println("0- Cikis yap ! ");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seciniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz deger, tekrar giriniz");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadir !");
                } else {

                    // Satin almanin gerceklestigi alan
                    System.out.println(selectedWeapon.getName() + " Silahini satin aldiniz !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney());
                    System.out.println("Onceki silahiniz : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }
    }


    public void printArmor() {

        System.out.println(" ---- Zirhlar ! ----");
        System.out.println("");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " <Para> : " + a.getPrice() + " , Zirh : " + a.getBlock());
        }
        System.out.println("0- Cikis yap ! ");
    }

    public void buyArmor() {

        System.out.print("Bir Zirh seciniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz deger, tekrar giriniz");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadir !");
                } else {
                    System.out.println(selectedArmor.getName() + " zirhini satin aldiniz !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan bakiye : " + this.getPlayer().getMoney());

                }
            }

        }


    }


    public void menu() {

        System.out.println("Menu den seçim yapabilirsiniz ");

    }

    public void buy() {

        System.out.println(getPlayer().getMoney() + "Satın alınma islemi yapıldı.");

    }


}
