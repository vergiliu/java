class TestCase():
    def __init__(self, a_name):
        self.name = a_name

    def setup(self):
        pass

    def run(self):
        result = TestResult()
        result.test_started()
        self.setup()
        method = getattr(self, self.name)
        method()
        self.tear_down()
        return result

    def tear_down(self):
        pass


class TestCaseTest(TestCase):
    def setup(self):
        self.test = WasRun("test_method")

    def template_method(self):
        test = WasRun("test_method")
        test.run()
        assert ("setup test_method tear_down " == test.log)

    def fail_test(self):
        test = WasRun("broken_test")
        result = test.run()
        print(result.summary())
        assert("1 run, 1 failed" == result.summary())

    def tear_down(self):
        pass

    def test_result(self):
        test = WasRun("test_method")
        result = test.run()
        assert("1 run, 0 failed" == result.summary())


class TestResult:
    def __init__(self):
        self.run_count = 0

    def test_started(self):
        self.run_count += 1

    def summary(self):
        return "%d run, 0 failed" % self.run_count


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

    def broken_test(self):
        raise Exception

    def tear_down(self):
        self.log += "tear_down "

if __name__ == "__main__":
    TestCaseTest("template_method").run()
    TestCaseTest("test_result").run()
    TestCaseTest("fail_test").run()