package com.b2dev.forum.payload.response;

import com.b2dev.forum.entity.Category;
import com.b2dev.forum.entity.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class HomeResponse {

    private List<Category> categories = new ArrayList<>();
    private List<Topic> topics = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
