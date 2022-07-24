import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hosgeldiniz !");
        System.out.println("Lutfen bir isim giriniz : ");
        // String playerName = input.nextLine();


        Player player = new Player("Mustafa");

        System.out.println("Sayin " + player.getName() + " bu karanlik ve sisli adaya hosgeldiniz ! Burada yasananlarin hepsi gercek !");
        System.out.println("Lutfen bir karakter seciniz.");

        player.selectChar();

        Location location = null;

        while(true){
            player.printInfo();

            System.out.println("");
            System.out.println("Bolgeler");
            System.out.println("");
            System.out.println("1- Guvenli Ev --> Burasi sizin icin guvenli bir ev, dusman yoktur");
            System.out.println("2- ToolStore --> Silah ya da zirh alabilirsiniz");
            System.out.println("3- Magara --> Odul <Yemek> Dikkali ol karsina Zombi cikabilir!");
            System.out.println("4- Orman --> Odul <Odun> Dikkali ol karsina Vampir cikabilir!");
            System.out.println("5- Nehir --> Odul <Su> Dikkali ol karsina Ayi cikabilir!");
            System.out.println("0- Cikis Yap ! --> Oyunu sonlandir");
            System.out.println("Lutfen Gitmek Istediginiz bolgeyi seciniz : ");

            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 0 :
                    location = null;
                    break;

                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                default :
                    System.out.println("Lutfen gecerli bir bolge giriniz ! ");
            }

            if(location == null){
                System.out.println("Bu karanlik ve sisli adadan cabuk vazgectin ! ");
                break;
            }
           if(!location.onLocation()){
               System.out.println("GAME OVER!");
               break;
           }
        }

    }


}
