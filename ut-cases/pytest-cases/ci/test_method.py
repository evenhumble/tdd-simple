# -*- coding: utf-8 -*-

class Demo:

    def request(self, data):
        print("this is request")


class Demo1(Demo):
    pass


class Demo2:

    def request1(self, data):
        print("test")


data = "1234"
steps = [
    {"step": "invoke Demo Api",
     "api": Demo1,
     "data": {}
     },
    {
        "step": "invoke Demo2 API",
        "api": Demo2().request1,
        "data": {}
    }
]

for step in steps:
    print(step)
    api_class = step.get("api")
    data_request = step.get("data")
    if issubclass(Demo, api_class):
        api = api_class()
        api.request(data_request)
    else:
        api_class(data_request)
