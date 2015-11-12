package com.vires.sensorapi.data.admin;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * @author Filip Prochazka (jacktech24)
 */
@Entity
public class HomeUser {

    @Id
    private Long id;
    private List<Ref<HomePlace>> places = new ArrayList<>();
    private String username;
    private String password;
    private String name;
    private String email;
    private String apiKey;

    public HomeUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HomePlace> getPlaces() {
        List<HomePlace> places = new ArrayList<>();
        for(Ref<HomePlace> placeKey : this.places) {
            places.add(placeKey.get());
        }
        return places;
    }

    public void setPlaces(List<HomePlace> places) {
        this.places.clear();
        for(HomePlace place : places) {
            this.places.add(Ref.create(place));
        }
    }

    public void addPlace(HomePlace place) {
        this.places.add(Ref.create(place));
    }

    public void removePlace(HomePlace place) {
        for(Ref<HomePlace> placeRef : places) {
            if(placeRef.get().getId().equals(place.getId())) {
                places.remove(placeRef);
                break;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
