package ru.yandex.practicum.theatre;

import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration; // в минутах
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director);
    }

    public void printActors() {
        System.out.println("Актёры в спектакле \"" + title + "\":");
        if (listOfActors.isEmpty()) {
            System.out.println("  Актёров нет");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("  - " + actor);
            }
        }
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актёр " + actor + " уже есть в списке!");
        } else {
            listOfActors.add(actor);
            System.out.println("Актёр " + actor.getName() + " " + actor.getSurname() + " добавлен.");
        }
    }

    public void replaceActor(Actor newActor, String surnameToReplace) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equalsIgnoreCase(surnameToReplace)) {
                listOfActors.set(i, newActor);
                System.out.println("Актёр " + surnameToReplace + " заменён на " + newActor.getName() + " " + newActor.getSurname());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Актёр с фамилией " + surnameToReplace + " не найден в спектакле.");
        }
    }
}
