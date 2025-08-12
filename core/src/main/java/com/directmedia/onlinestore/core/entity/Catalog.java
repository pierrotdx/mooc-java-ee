package com.directmedia.onlinestore.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Catalog {
    public static Set<Work> listOfWorks = new HashSet<Work>();

    public static Work getWork(long id) throws Exception {
        Work requestedWork = null;
        for (Work work : Catalog.listOfWorks) {
            if (work.getId() == id) {
                requestedWork = work;
                break;
            }
        }
        if (requestedWork == null) {
            throw new Exception("work not found");
        }
        return requestedWork;
    }

}
