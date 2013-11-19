class TestCase():
    def __init__(self, a_name):
        self.name = a_name

    def setup(self):
        pass

    def run(self):
        self.setup()
        method = getattr(self, self.name)
        method()
        self.tear_down()

    def tear_down(self):
        pass


class TestCaseTest(TestCase):
    def setup(self):
        self.test = WasRun("test_method")

    def template_method(self):
        test = WasRun("test_method")
        test.run()
        assert ("setup test_method tear_down " == test.log)

    def tear_down(self):
        pass


class WasRun(TestCase):
    def __init__(self, a_name):
        self.name = a_name
        self.log = None

    def setup(self):
        self.was_run = None
        self.was_setup = 1
        self.log = "setup "

    def test_method(self):
        self.was_run = 1
        self.log += "test_method "

    def tear_down(self):
        self.log += "tear_down "

if __name__ == "__main__":
    TestCaseTest("template_method").run()