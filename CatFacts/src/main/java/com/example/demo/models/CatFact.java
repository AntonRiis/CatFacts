package com.example.demo.models;
import java.util.Comparator;
import java.util.Date;

public class CatFact implements Comparable<CatFact> {
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatFact() {
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "- CatFact" + ":" + text + "<br>" + "Created at = " + createdAt + "<br>" + "Updated at = " + updatedAt
                + "<br>" + "<br>";

    }

    @Override
    public int compareTo(CatFact cf) {

        if (this.createdAt.before(cf.createdAt)) {
                return 1;
        }

        else if (this.createdAt.after(cf.createdAt)) {
                return -1;
        }
            return 0;
    }
}
