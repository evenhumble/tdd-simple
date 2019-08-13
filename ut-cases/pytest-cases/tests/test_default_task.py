# -*- coding: utf-8 -*-
from tests.base_test import BaseTest
from todo.tasks import default_task, Task


class TestDefaultTask(BaseTest):

    ## 创建默认对象
    def test_default_task(self):
        task= default_task()
        assert task is not None

    ## 创建的对象的属性可以被初始化和访问
    def test_member_access(self):
        task = Task('todo 1','patrick',False,1)
        assert task.id is 1
        assert task.summary is 'todo 1'
        assert task.owner is 'patrick'
        assert task.done is False

    def test_asdict(self):
        task = Task('todo 1','patrick',False,1)
        task_dict = task._asdict()
        expected ={
            "summary": 'todo 1',
            "owner":"patrick",
            "done":False,
            "id":1
        }
        assert task_dict == expected ## is is different with ==

