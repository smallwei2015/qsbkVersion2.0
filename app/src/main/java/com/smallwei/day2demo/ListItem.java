package com.smallwei.day2demo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by smallwei on 2015/12/29.
 */
public class ListItem {
    long id;
    String name;
    String icon;
    String content;
    String image;

    public ListItem(JSONObject object) throws JSONException {
        if (!object.isNull("user")){
            icon=object.getJSONObject("user").getString("icon");
            name=object.getJSONObject("user").getString("login");
            id=object.getJSONObject("user").getLong("id");
        }
        content=object.getString("content");
        if(!object.isNull("image")){
            image=object.getString("image");
        }

    }
    public ListItem(long id, String name, String icon, String content, String image) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.content = content;
        this.image = image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }
}
