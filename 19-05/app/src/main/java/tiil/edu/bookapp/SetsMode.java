package tiil.edu.bookapp;

public class SetsMode {

    String setName;
    String description;
    String category;
    String size;
    String date;
    int imageResId;
    boolean isFavorite = false;

    public SetsMode(String setName, String description, String category, String size, String date, int imageResId){
        this.setName = setName;
        this.description = description;
        this.category = category;
        this.size = size;
        this.date = date;
        this.imageResId = imageResId;
    }

    public String getSetName() { return setName; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getSize() { return size; }
    public String getDate() { return date; }
    public int getImageResId() { return imageResId; }
    public boolean isFavorite() {return isFavorite;}

    public void setSetName(String setName) { this.setName = setName; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setSize(String size) { this.size = size; }
    public void setDate(String date) { this.date = date; }
    public void setImageResId(int imageResId) { this.imageResId = imageResId; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
}

