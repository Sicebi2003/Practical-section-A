/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc;

/**
 *
 * @author RC_Student_lab
 */
class SeriesModel {
    private int seriesId;
    private String seriesName;
    private int ageRestriction;
    private int numberOfEpisodes;
    private String genre;
    private double rating;

    public SeriesModel(int seriesId, String seriesName, int ageRestriction, 
                      int numberOfEpisodes, String genre, double rating) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.ageRestriction = ageRestriction;
        this.numberOfEpisodes = numberOfEpisodes;
        this.genre = genre;
        this.rating = rating;
    }

    // Getters and setters
    public int getSeriesId() { return seriesId; }
    public void setSeriesId(int seriesId) { this.seriesId = seriesId; }
    
    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
    
    public int getAgeRestriction() { return ageRestriction; }
    public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }
    
    public int getNumberOfEpisodes() { return numberOfEpisodes; }
    public void setNumberOfEpisodes(int numberOfEpisodes) { this.numberOfEpisodes = numberOfEpisodes; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    
    @Override
    public String toString() {
        return "ID: " + seriesId + ", Name: " + seriesName + ", Age Restriction: " + ageRestriction +
               ", Episodes: " + numberOfEpisodes + ", Genre: " + genre + ", Rating: " + rating;
    }
}
