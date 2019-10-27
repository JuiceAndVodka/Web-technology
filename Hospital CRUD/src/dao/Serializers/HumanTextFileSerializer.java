package dao.Serializers;

import bean.Human;

public interface HumanTextFileSerializer {

    public String serializeHuman(Human human);
    public Human deserializeHuman(String stringHuman);
}
