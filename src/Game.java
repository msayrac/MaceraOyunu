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
    }







}
