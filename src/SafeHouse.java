public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House - Guvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz ! ");
        System.out.println("Caniniz yenilendi !");
        return true;
    }
}
