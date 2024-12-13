package com.solvd.laba.carina.homework.aptoide.objects;

public enum HomePageAppsElements implements StaticElement{
    TOP_APPS("cm.aptoide.pt:id/bundle_title", "GAMES"),
    TOP_APPS_LIST("cm.aptoide.pt:id/top_list", ""),
    TOP_MORE("cm.aptoide.pt:id/bundle_more", "MORE");

    private String id;
    private String text;
    HomePageAppsElements(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getXpath(){return "";}
}
