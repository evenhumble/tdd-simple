# -*- coding: utf-8 -*-
from collections import namedtuple

Task = namedtuple('Task', ['summary', 'owner', 'done', 'id'])
Task.__new__.__defaults__ = (None, None, False, None)

all_tasks = []


def default_task():
    return Task()


def create_task(summary, owner, done, id):
    task = Task(summary, owner, done, id)
    all_tasks.append(task)
    return task


def update_task(summary, owner, done, id):
    task_for_updated = find_task_by_id(id)
    delete_task_by_id(id)
    if task_for_updated is not None:
        task_for_updated = task_for_updated._replace(summary=summary)._replace(owner=owner)._replace(done=done)
    all_tasks.append(task_for_updated)
    return task_for_updated


def find_task_by_id(id):
    for task in all_tasks:
        if task.id == id:
            return task
    raise Exception("No Task Found")


def delete_task_by_id(id):
    for task in all_tasks:
        if task.id == id:
            all_tasks.remove(task)
            return task


def list_tasks():
    return all_tasks
