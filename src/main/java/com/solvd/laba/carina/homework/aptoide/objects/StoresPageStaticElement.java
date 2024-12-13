package com.solvd.laba.carina.homework.aptoide.objects;

public enum StoresPageStaticElement implements StaticElement{
    LOGIN_MESSAGE("//*[contains(@resource-id,'login_message')]", "Log in now and start sharing your apps!"),
    LOGIN_BUTTON("//*[contains(@resource-id,'login_button')]", "LOG IN"),
    FOLLOWED_STORES_MESSAGE("(//android.widget.RelativeLayout/android.widget.TextView)[1]","Followed stores"),
    FOLLOW_STORE_BUTTON("//*[@resource-id=\"cm.aptoide.pt:id/follow_store_image\"]/..",""),
    SECOND_FOLLOWED_STORE("(//android.widget.FrameLayout[@resource-id=\"cm.aptoide.pt:id/store_main_layout_row\"])[1]", ""),
    THIRD_FOLLOWED_STORE("(//android.widget.FrameLayout[@resource-id=\"cm.aptoide.pt:id/store_main_layout_row\"])[2]",""),
    RECOMMENDED_STORES_MESSAGE("(//android.widget.RelativeLayout/android.widget.TextView)[2]","Recommended stores"),
    MORE_BUTTON("//android.widget.Button[@resource-id=\"cm.aptoide.pt:id/more\"]","MORE");


    private String xpath;
    private String text;
    StoresPageStaticElement(String xpath, String text) {
        this.xpath = xpath;
        this.text = text;
    }

    public String getId() {
        return "";
    }

    public String getText() {
        return text;
    }

    public String getXpath() {
        return xpath;
    }
}
