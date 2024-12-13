package com.solvd.laba.carina.homework.aptoide.objects;

public enum AppPageStaticElement implements StaticElement{
    ANIMATED_COLOR_VIEW("cm.aptoide.pt:id/animated_color_view", ""),
    VIEW_PAGE("cm.aptoide.pt:id/view_pager",""),
    WIZARD_ICON("cm.aptoide.pt:id/wizard_icon",""),
    MESSAGE_GROUP("cm.aptoide.pt:id/message_group",""),
    MESSAGE_DISCOVER_BEST_APPS("cm.aptoide.pt:id/title","Discover the Best Apps"),
    MESSAGE_DESCRIPTION("cm.aptoide.pt:id/description", ""),
    PAGER_RADIO_GROUP("cm.aptoide.pt:id/view_pager_radio_group", ""),
    SKIP_BUTTON("cm.aptoide.pt:id/skip_button","");

    private String id;
    private String text;
    AppPageStaticElement(String id, String text) {
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
