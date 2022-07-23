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
            System.out.println("2- Magaza --> Silay ya da zırh alabilirsiniz");
            System.out.println("Lutfen Gitmek Istediginiz bolgeyi seciniz : ");

            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                default :
                    location = new SafeHouse(player);
            }
           if(!location.onLocation()){
               System.out.println("GAME OVER!");
               break;
           }
        }

    }


}
