package io.hedwig.justdoit.demo;

import io.hedwig.justdoit.demo.dto.ToDoItemDTO;

public class ToDoService {

    public ToDoItem createToDoItem(ToDoItemDTO dto){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId(UUIDGenerator.generateToDoId());
        toDoItem.setStatus(dto.getStatus());
        toDoItem.setDesc(dto.getDesc());
        toDoItem.setDetails(dto.getDetails());
        toDoItem.setUserId(dto.getUserId());
        return toDoItem;
    }

    public ToDoItem updateToDoItem(ToDoItemDTO dto){
        return createToDoItem(dto);
    }

    public ToDoItem deleteToDoItem(ToDoItemDTO dto){
        dto.setStatus(ToDoStatusEnum.DELETED.getStatusId());
        return createToDoItem(dto);
    }

    public ToDoItem completeToDoItem(ToDoItemDTO dto){
        dto.setStatus(ToDoStatusEnum.DONE.getStatusId());
        return createToDoItem(dto);
    }
}
