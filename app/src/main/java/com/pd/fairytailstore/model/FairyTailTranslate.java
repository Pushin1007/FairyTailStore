package com.pd.fairytailstore.model;

import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.Map;

public class FairyTailTranslate {

    public static class Fields {
        public final static String NAME_STORY = "nameStory";
        public final static String AUTOR = "author";
        public final static String TIME_TO_READ = "timeToRead";
        public final static String NAME_FILE = "nameFile";
    }

    public static FairyTail documentToFairyTail(String id, Map<String, Object> doc) {
        FairyTail answer = new FairyTail(
                (String) doc.get(Fields.NAME_STORY),
                (String) doc.get(Fields.AUTOR),
                (String) doc.get(Fields.TIME_TO_READ),
                (String) doc.get(Fields.NAME_FILE));
        answer.setId(id);
        return answer;
    }

    public static Map<String,Object> fairyTailToDocument( FairyTail fairyTail){
        Map<String,Object> answer = new HashMap<>();
        answer.put(Fields.NAME_STORY,fairyTail.getNameStory());
        answer.put(Fields.AUTOR,fairyTail.getNameStory());
        answer.put(Fields.TIME_TO_READ,fairyTail.getNameStory());
        answer.put(Fields.NAME_FILE,fairyTail.getNameStory());
        return answer;
    }
}

