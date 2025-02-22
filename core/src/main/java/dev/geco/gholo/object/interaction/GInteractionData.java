package dev.geco.gholo.object.interaction;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Objects;

public class GInteractionData implements Cloneable {

    public static final String DEFAULT_PERMISSION = null;

    private String permission = DEFAULT_PERMISSION;

    public String getPermission() { return permission; }

    public GInteractionData setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    @Override
    public String toString() {
        JSONObject data = new JSONObject();
        if(!Objects.equals(permission, DEFAULT_PERMISSION)) data.put("permission", permission);
        return data.toJSONString();
    }

    public @NotNull GInteractionData loadString(@NotNull String string) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject data = (JSONObject) parser.parse(string);
            if(data.containsKey("permission")) permission = (String) data.get("permission");
        } catch(Throwable e) { e.printStackTrace(); }
        return this;
    }

    public static @NotNull GInteractionData fromString(@NotNull String string) { return new GInteractionData().loadString(string); }

    @Override
    public @NotNull GInteractionData clone() { try { return (GInteractionData) super.clone(); } catch(CloneNotSupportedException e) { throw new Error(e); } }

}