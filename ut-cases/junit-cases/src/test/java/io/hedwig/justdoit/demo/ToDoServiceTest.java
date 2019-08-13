package io.hedwig.justdoit.demo;

import io.hedwig.justdoit.demo.dto.ToDoItemDTO;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ToDoServiceTest {

    public static ToDoService toDoService;
    public static  ToDoItemDTO dto ;
    @BeforeClass
    public static void setupToDoService(){
        toDoService = new ToDoService();
        dto = new ToDoItemDTO();
    }
    @Test
    public void testCreateToDoItem_successful() {
        System.out.println(this);
        dto.setDesc("test todo");
        dto.setDetails("test todo details");
        ToDoItem toDoItem =toDoService.createToDoItem(dto);
        Assert.assertEquals(toDoItem.getDesc(),"test todo");
        Assert.assertEquals(toDoItem.getDetails(),"test todo details");
        Assert.assertEquals(toDoItem.getStatus(),ToDoStatusEnum.TODO.getStatusId());

    }

    @Test
    public void updateToDoItem_successful() {
        System.out.println(this);
        dto.setDesc("update");
        dto.setDetails("update");
        ToDoItem toDoItem =toDoService.createToDoItem(dto);
        Assert.assertEquals(toDoItem.getDesc(),"update");
        Assert.assertEquals(toDoItem.getDetails(),"update");
    }

    @Test
    public void deleteToDoItem_successful() {
        System.out.println(this);
        ToDoItem toDoItem =toDoService.deleteToDoItem(dto);
        Assert.assertEquals(toDoItem.getStatus(),ToDoStatusEnum.DELETED.getStatusId());
    }

    @Test
    public void completeToDoItem_successful() {
        System.out.println(this);
        ToDoItem toDoItem =toDoService.completeToDoItem(dto);
        Assert.assertEquals(toDoItem.getStatus(),ToDoStatusEnum.DONE.getStatusId());
    }
}