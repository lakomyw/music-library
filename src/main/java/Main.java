public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new MusicInfoService(), new MusicInfoClient(), new MusicInfoExporter());
        menu.displayMenu();
    }
}