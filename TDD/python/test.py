class TestCase():
    def __init__(self, a_name):
        self.name = a_name

    def setup(self):
        pass

    def run(self):
        self.setup()
        method = getattr(self, self.name)
        method()


class TestCaseTest(TestCase):
    def __init__(self, a_name):
        self.test = None
        TestCase.__init__(self, a_name)

    def setup(self):
        self.test = WasRun("test_method")

    def test_setup(self):
        self.test.run()
        assert self.test.was_setup

    def test_running(self):
        self.test.run()
        assert self.test.was_run


class WasRun(TestCase):
    def __init__(self, a_name):
        self.was_run = None
        self.was_setup = None
        TestCase.__init__(self, a_name)

    def setup(self):
        self.was_run = 1
        self.was_setup = 1

    def test_method(self):
        self.was_run = 1


TestCaseTest("test_running").run()