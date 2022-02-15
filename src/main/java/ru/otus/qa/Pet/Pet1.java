
package ru.otus.qa.Pet;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Pet1 {

    @Expose
    private Category category;
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private List<String> photoUrls;
    @Expose
    private String status;
    @Expose
    private List<Tag> tags;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
