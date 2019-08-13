# -*- coding: utf-8 -*-
import allure
import pytest

import todo
from todo.tasks import create_task, find_task_by_id, update_task, delete_task_by_id


class TestTasks:
    @allure.step
    def step_1(self):
        print("this is step 1")

    @allure.step('Step with placeholders in the title, positional: "{0}", keyword: "{key}"')
    def step_2(self, p1, key):
        print(p1)
        print("this is step 2 " + key)

    def test_create_task(self):
        task_to_created = create_task(summary="summary",
                                      owner='owner',
                                      done=True,
                                      id=12)
        created_task = find_task_by_id(id=12)
        self.step_2("step", "test")
        assert task_to_created is created_task

    @allure.title("更新测试用例")
    def test_update_task(self):
        create_task(summary="summary",
                    owner='owner',
                    done=True,
                    id=12)
        update_task(
            summary="updated",
            owner="owner",
            done=False,
            id=12
        )
        self.step_2(p1="p1", key="key")

        task = find_task_by_id(id=12)
        assert task.summary == 'updated'

    @allure.title("delete task")
    @pytest.mark.smoke
    def test_delete_task(self):
        create_task(summary="summary",
                    owner='owner',
                    done=True,
                    id=12)
        delete_task_by_id(12)
        task = find_task_by_id(12)
        assert task is None

    @allure.title("task not found case with exception")
    @pytest.mark.p1
    def test_find_task_by_id_notfound(self):
        with pytest.raises(Exception) as execinfo:
            find_task_by_id("1023")
        exception_msg = execinfo.value.args[0]
        assert exception_msg == "No Task Found"

    @pytest.fixture(autouse=True)
    def fixture_usage(self):
        print("this is fixture")
        yield
        print("end of fixture")

    def test_use_fixture(self):
        print("use fixture testing")

    @pytest.mark.skip(reason="skip it....")
    def test_skipit(self):
        print("skip it")

    @pytest.mark.skipif(todo.__version__ > 3.0, reason="not supported")
    def test_skipitif(self):
        print("skip it if")

    @pytest.mark.xfail
    def test_xfail(self):
        """
        expected fail
        :return:
        """
        assert 1 == 0

    @pytest.mark.parametrize('task', [
        {"summary": "test", "owner": "owner", "done": False, "id": 10},
        {"summary": "test1", "owner": "owner", "done": False, "id": 11},
        {"summary": "test2", "owner": "owner", "done": False, "id": 12}
    ])
    @allure.title("create test cases for tasks")
    # todo: how to integrate with allure report
    def test_create_task_parameterize(self, task):
        print(task)


