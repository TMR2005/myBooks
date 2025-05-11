package com.example.mybooks;

public class Books {
    private int id;
    private String name;
    private String author;
    private int pages;
    private int myRating;
    private String imageUrl;
    private boolean isExpanded;

    public Books(int id, String name, String author, int pages, int myRating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.myRating = myRating;
        this.imageUrl = imageUrl;
        isExpanded=false;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", myRating=" + myRating +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyRating() {
        return String.valueOf(myRating);
    }

    public void setMyRating(int myRating) {
        this.myRating = myRating;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
