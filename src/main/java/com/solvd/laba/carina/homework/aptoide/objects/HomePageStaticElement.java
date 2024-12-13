package com.solvd.laba.carina.homework.aptoide.objects;

public enum HomePageStaticElement implements StaticElement{
    GAMES_CHIP("cm.aptoide.pt:id/games_chip", "GAMES"),
    APPS_CHIP("cm.aptoide.pt:id/apps_chip", "APPS"),
    NEW_PACKAGE("cm.aptoide.pt:id/new_package_card", ""),
    EDITORS_CHOICE_TITLE("cm.aptoide.pt:id/bundle_title", "Editors' Choice"),
    EDITORS_CHOICE_MORE("cm.aptoide.pt:id/bundle_more", "MORE"),
    EDITORS_CHOICE_FEATURED("cm.aptoide.pt:id/featured_graphic_list", ""),
    EDITORIAL_CARD("cm.aptoide.pt:id/editorial_card", "");

    private String id;
    private String text;
    HomePageStaticElement(String id, String text) {
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
