/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private int nextId = 101;
    private Scanner scanner = new Scanner(System.in);

    

    

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("TV SERIES MANAGEMENT SYSTEM");
            System.out.println("=".repeat(50));
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search series");
            System.out.println("(3) Update series");
            System.out.println("(4) Delete series");
            System.out.println("(5) View all series");
            System.out.println("(6) Exit Application");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": captureSeries(); break;
                case "2": searchSeries(); break;
                case "3": updateSeries(); break;
                case "4": deleteSeries(); break;
                case "5": viewAllSeries(); break;
                case "6": 
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void captureSeries() {
        System.out.println("\n--- Capture a New Series ---");
        int seriesId = nextId++;
        
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        if (seriesName.trim().isEmpty()) {
            System.out.println("Series name cannot be empty.");
            return;
        }
        
        int ageRestriction;
        
        do{
             System.out.print("Enter the series age restriction: ");
               ageRestriction = Integer.parseInt(scanner.nextLine());
        }while(!getValidAgeRestriction(ageRestriction));
       
        int numberOfEpisodes = getValidNumberOfEpisodes();
        
        System.out.print("Enter the series genre: ");
        String genre = scanner.nextLine();
        
        double rating = getValidRating();
        
        
        seriesList.add(new SeriesModel(seriesId, seriesName, ageRestriction, 
                                               numberOfEpisodes, genre, rating));
        
        System.out.println("Series details have been successfully saved!");
        System.out.println("Generated Series ID: " + seriesId);
    }

    private void searchSeries() {
        System.out.println("\n--- Search for a Series ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series data available to search.");
            return;
        }
        
        System.out.print("Enter the series ID to search: ");
        String idInput = scanner.nextLine();
        
        try {
            int searchId = Integer.parseInt(idInput);
            boolean found = false;
            
            for (SeriesModel series : seriesList) {
                if (series.getSeriesId() == searchId) {
                    System.out.println("Series found:");
                    System.out.println("ID: " + series.getSeriesId());
                    System.out.println("Name: " + series.getSeriesName());
                    System.out.println("Age Restriction: " + series.getAgeRestriction() + "+");
                    System.out.println("Episodes: " + series.getNumberOfEpisodes());
                    System.out.println("Genre: " + series.getGenre());
                    System.out.println("Rating: " + series.getRating() + "/10");
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Series ID: " + searchId + " was not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a numeric value.");
        }
    }

    private void updateSeries() {
        System.out.println("\n--- Update a Series ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series data available to update.");
            return;
        }
        
        System.out.print("Enter the series ID to update: ");
        String idInput = scanner.nextLine();
        
        try {
            int updateId = Integer.parseInt(idInput);
            SeriesModel foundSeries = null;
            
            for (SeriesModel series : seriesList) {
                if (series.getSeriesId() == updateId) {
                    foundSeries = series;
                    break;
                }
            }
            
            if (foundSeries != null) {
                System.out.println("Current series details:");
                System.out.println("ID: " + foundSeries.getSeriesId());
                System.out.println("Name: " + foundSeries.getSeriesName());
                System.out.println("Age Restriction: " + foundSeries.getAgeRestriction() + "+");
                System.out.println("Episodes: " + foundSeries.getNumberOfEpisodes());
                System.out.println("Genre: " + foundSeries.getGenre());
                System.out.println("Rating: " + foundSeries.getRating() + "/10");
                
                System.out.println("\nEnter new details (press Enter to keep current value):");
                
                System.out.print("Enter new series name [" + foundSeries.getSeriesName() + "]: ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) foundSeries.setSeriesName(newName);
                
                System.out.print("Enter new age restriction [" + foundSeries.getAgeRestriction() + "]: ");
                String ageInput = scanner.nextLine();
                if (!ageInput.trim().isEmpty()) {
                    try {
                        int newAge = Integer.parseInt(ageInput);
                        if (newAge >= 2 && newAge <= 18) foundSeries.setAgeRestriction(newAge);
                        else System.out.println("Invalid age restriction. Keeping current value.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Keeping current age restriction.");
                    }
                }
                
                System.out.print("Enter new number of episodes [" + foundSeries.getNumberOfEpisodes() + "]: ");
                String episodesInput = scanner.nextLine();
                if (!episodesInput.trim().isEmpty()) {
                    try {
                        int newEpisodes = Integer.parseInt(episodesInput);
                        if (newEpisodes > 0) foundSeries.setNumberOfEpisodes(newEpisodes);
                        else System.out.println("Invalid number. Keeping current value.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Keeping current episode count.");
                    }
                }
                
                System.out.print("Enter new genre [" + foundSeries.getGenre() + "]: ");
                String newGenre = scanner.nextLine();
                if (!newGenre.trim().isEmpty()) foundSeries.setGenre(newGenre);
                
                System.out.print("Enter new rating [" + foundSeries.getRating() + "]: ");
                String ratingInput = scanner.nextLine();
                if (!ratingInput.trim().isEmpty()) {
                    try {
                        double newRating = Double.parseDouble(ratingInput);
                        if (newRating >= 0 && newRating <= 10) foundSeries.setRating(newRating);
                        else System.out.println("Invalid rating. Keeping current value.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Keeping current rating.");
                    }
                }
                
                System.out.println("Series details updated successfully!");
            } else {
                System.out.println("Series ID: " + updateId + " was not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a numeric value.");
        }
    }

    private void deleteSeries() {
        System.out.println("\n--- Delete a Series ---");
        if (seriesList.isEmpty()) {
            System.out.println("No entries in the series list.");
            return;
        }
        
        System.out.print("Enter the series ID to delete: ");
        String idInput = scanner.nextLine();
        
        try {
            int deleteId = Integer.parseInt(idInput);
            SeriesModel foundSeries = null;
            
            for (SeriesModel series : seriesList) {
                if (series.getSeriesId() == deleteId) {
                    foundSeries = series;
                    break;
                }
            }
            
            if (foundSeries != null) {
                System.out.println("Series to be deleted:");
                System.out.println("ID: " + foundSeries.getSeriesId());
                System.out.println("Name: " + foundSeries.getSeriesName());
                
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirmation = scanner.nextLine();
                
                if (confirmation.equalsIgnoreCase("Y")) {
                    seriesList.remove(foundSeries);
                    System.out.println("Series ID: " + deleteId + " has been deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println("Series ID: " + deleteId + " was not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a numeric value.");
        }
    }

    private void viewAllSeries() {
        System.out.println("\n--- All Series Report ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series data available.");
            return;
        }
        
        System.out.println("Total series: " + seriesList.size());
        System.out.println("=".repeat(60));
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + (i + 1) + ":");
            System.out.println("  ID: " + series.getSeriesId());
            System.out.println("  Name: " + series.getSeriesName());
            System.out.println("  Age Restriction: " + series.getAgeRestriction() + "+");
            System.out.println("  Episodes: " + series.getNumberOfEpisodes());
            System.out.println("  Genre: " + series.getGenre());
            System.out.println("  Rating: " + series.getRating() + "/10");
            System.out.println("-".repeat(30));
        }
    }

    public boolean getValidAgeRestriction(int age) {
        
        return age>1 && age<19;
    }

    private int getValidNumberOfEpisodes() {
        int numberOfEpisodes = 0;
        boolean validEpisodes = false;
        
        while (!validEpisodes) {
            System.out.print("Enter the number of episodes: ");
            String episodesInput = scanner.nextLine();
            
            try {
                numberOfEpisodes = Integer.parseInt(episodesInput);
                if (numberOfEpisodes > 0) validEpisodes = true;
                else System.out.println("Invalid number. Please enter a positive value.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }
        return numberOfEpisodes;
    }
    
    private double getValidRating() {
        double rating = 0;
        boolean validRating = false;
        
        while (!validRating) {
            System.out.print("Enter the series rating (0-10): ");
            String ratingInput = scanner.nextLine();
            
            try {
                rating = Double.parseDouble(ratingInput);
                if (rating >= 0 && rating <= 10) validRating = true;
                else System.out.println("Invalid rating. Please enter a value between 0 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }
        return rating;
    }
}
