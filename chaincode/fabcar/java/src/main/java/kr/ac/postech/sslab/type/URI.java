package kr.ac.postech.sslab.type;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class URI {
    private String path;
    private String hash;

    public URI(String uri) throws ParseException {
        this.parse(uri);
    }

    private void parse(String uri) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(uri);

        this.path = object.get("path").toString();
        this.hash = object.get("hash").toString();
    }

    private Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();

        map.put("path", this.path);
        map.put("hash", this.hash);

        return map;
    }

    public String toJSONString() {
        return new JSONObject(this.toMap()).toJSONString();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return this.hash;
    }
}