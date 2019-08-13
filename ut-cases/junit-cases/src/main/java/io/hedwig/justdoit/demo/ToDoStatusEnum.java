package io.hedwig.justdoit.demo;

public enum ToDoStatusEnum {
    TODO(0),WIP(1),DONE(2),PENDING(3),DELETED(4);

    public int getStatusId() {
        return statusId;
    }

    private final int statusId;

    ToDoStatusEnum(int statusId) {
        this.statusId= statusId;
    }
}
