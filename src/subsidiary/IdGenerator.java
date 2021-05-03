package subsidiary;

import Collections.CollectionManager;

import java.util.HashSet;

public class IdGenerator {
    public static long generateId(CollectionManager collectionManager) {
        HashSet<Long> idList = collectionManager.getIdList();
        long id = (long) (Math.random() * 999999);
        while (idList.contains(id)) {
            id = (long) (Math.random() * 999999);
        }
        idList.add(id);
        return id;
    }
}
