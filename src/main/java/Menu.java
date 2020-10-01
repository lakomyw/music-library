import database.Slip;
import http.SearchResponse;
import http.SlipDTo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final MusicInfoService musicInfoService;
    private final MusicInfoClient musicInfoClient;
    private final MusicInfoExporter musicInfoExporter;
    private final Scanner scanner = new Scanner(System.in);


    public Menu(MusicInfoService musicInfoService, MusicInfoClient musicInfoClient, MusicInfoExporter musicInfoExporter) {
        this.musicInfoService = musicInfoService;
        this.musicInfoClient = musicInfoClient;
        this.musicInfoExporter = musicInfoExporter;
    }

    public void displayMenu() {
        boolean continuing = true;

        while (continuing) {
            System.out.println("Music library");
            System.out.println("Choose one of the options:");
            System.out.println("1) Choose an album.");
            System.out.println("2) Search for an album");
            System.out.println("3) My albums");
            System.out.println("0) Finish"); //eksport cytatów, wyświetlanie, usuwanie

            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }

            switch (nextInt) {

                case 0: {
                    continuing = false;
                    break;
                }
                case 1: {
                    SlipDTo randomAlbum = musicInfoClient.getRandomAlbum();
                    String advice = randomAlbum.getAlbum();
                    System.out.println("******Album for you******");
                    System.out.println(advice);
                    System.out.println("***********************");

                    MenuCase1(randomAlbum);
                    break;
                }
                case 2: {
                    System.out.println("What are you looking for?");
                    String search = scanner.next();

                    try {
                        SearchResponse sr = musicInfoClient.searchByString(search);
                        System.out.println(sr);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    List<Slip> allAlbum = MusicInfoService.getAllAlbum();
                    MenuCase3(allAlbum);
                    break;
                }
                case -1: {
                    System.out.println("Enter a number");
                    break;
                }
                default: {
                    System.out.println("Enter a different number.");
                }
            }
        }
    }

    private void MenuCase1(SlipDTo randomAlbum) {
        boolean flaga = true;
        while (flaga) {
            System.out.println("Choose one of the options:");
            System.out.println("1) Search for an next album.");
            System.out.println("2) Add to Favorites");
            System.out.println("3) Back to main menu");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }
            switch (nextInt) {

                case 1: {
                    randomAlbum = musicInfoClient.getRandomAlbum();
                    String album = randomAlbum.getAlbum();
                    System.out.println("******Album for you******");
                    System.out.println(album);
                    System.out.println("***********************");
                    break;
                }
                case 2: {
                    musicInfoService.saveAlbum(randomAlbum);
                    break;
                }
                case 3: {
                    flaga = false;
                    break;
                }
                case -1: {
                    System.out.println("Enter a number");
                    break;
                }
                default: {
                    System.out.println("Enter a different number.");
                }
            }
        }
    }

    private void MenuCase3(List<Slip> allAlbum) {
        boolean development = true;
        Long Id;

        while (development) {
            System.out.println();
            System.out.println("New Menu");
            System.out.println("Choose one of the options: ");
            System.out.println("1. View favorite albums");
            System.out.println("2. Remove the album from favorites");
            System.out.println("3. Export your favorite albums to a file cytatów");
            System.out.println("4. Eksport to excel");
            System.out.println("0. Exit - Return to the previous menu");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }
            switch (nextInt) {
                case 0: {
                    development = false;
                    break;
                }
                case 1: {
                    System.out.println();
                    System.out.println("favorites albums");
                    System.out.println(Arrays.toString(allAlbum.toArray()));
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("removing album - please enter ID");
                    Id = scanner.nextLong();
                    musicInfoService.deleteID(Id);
                }
                case 3: {
                    musicInfoExporter.exportToFile(allAlbum);
                    break;
                }
                case 4: {
                    musicInfoExporter.exportToSheet(allAlbum);
                    break;
                }
                case -1: {
                    System.out.println("Enter a number");
                    break;
                }
                default: {
                    System.out.println("Enter a different album");
                }
            }
        }
    }

}
