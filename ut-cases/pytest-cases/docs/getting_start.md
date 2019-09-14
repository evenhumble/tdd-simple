# pytest getting start

- 安装pytest
- 运行pytest
- 只运行一个测试
- 标准python项目配置

## Install pytest

- 全局安装virtualenv:

```sh
pip3 install -U virtualenv
```

- 创建虚拟环境

```sh
python3 -m virtualenv venv
```

- 激活此虚拟环境

```sh
source venv/bin/activate
```

- 安装pytest到此虚拟环境
```sh
pip install pytest
```

使用python virtualenv创建虚拟环境的好处是可以介绍环境的干扰,让开发环境更加的干净，
减少不必要的错误。

## 被测对象

如何进行测试，首先必须有个被测试对象，因此先写一个简单的被测对象，他的功能有：

- 一个包含summary,owner,done,id 的task
- 创建默认task的方法

```python
# -*- coding: utf-8 -*-
from collections import namedtuple

Task = namedtuple('Task', ['summary', 'owner', 'done', 'id'])
Task.__new__.__defaults__ = (None, None, False, None)


def default_task():
    return Task()


````

## 被测对象的功能

首先测试一下被测对象的基本功能:

- 可以创建默认的Task对象
- Task对象的值可以被修改，访问或者初始化

基于以上亮点，我们先定义测试方法：

```python

class TestDefaultTask:

    ## 创建默认对象
    def test_default_task(self):
        assert False is true
    ## 创建的对象的属性可以被初始化和访问
    def test_member_access(self):
       assert False is true

```

使用pytest 运行测试用例，很明显以上两个测试用例都会失败，我们的目标是测试通过，
要么就是修改测试代码，要么就是修改源程序来满足功能需求，这里我们需要修改测试代码，
因为测试代码没有反应实际的任何被测逻辑，把测试都通过是TDD的一种思想，可以一边开发一边保证
开发的代码是满足实际业务需求的. 改变业务测试代码：

```python
# -*- coding: utf-8 -*-
from todo.todos import default_task, Task


class TestDefaultTask:

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

```

使用如下命令运行测试：

```sh
pytest tests/test_default_task.py
pytest tests/test_default_task.py -v ## 展示测试详细内容
```

所有测试都通过，表示已经满足的最基本的功能要求. 这里有三点需要额外指出:

- pytest 测试代码文件名字应该满足 test_<something>.py
- pytest 测试方法名字应该满足 test_<something>()
- pytest 测试class名字应该满足 Test<something>

写测试用例的时候，需要尽量满足以上三点从而避免一些配置的复杂度避免一些想不到的麻烦。


## python code coverage








