class TestCase():
    def __init__(self, a_name):
        self.name = a_name

    def setup(self):
        pass

    def run(self):
        result = TestResult()
        result.test_started()
        self.setup()
        try:
            method = getattr(self, self.name)
            method()
        except:
            result.test_failed()
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
        assert("1 run, 1 failed" == result.summary())

    def tear_down(self):
        pass

    def test_result(self):
        test = WasRun("test_method")
        result = test.run()
        assert("1 run, 0 failed" == result.summary())

    def failer_result_formatting(self):
        result = TestResult()
        result.test_started()
        result.test_failed()
        assert("1 run, 1 failed" == result.summary())


class TestResult:
    def __init__(self):
        self.run_count = 0
        self.error_count = 0

    def test_started(self):
        self.run_count += 1

    def test_failed(self):
        self.error_count += 1

    def summary(self):
        return "%d run, %d failed" % (self.run_count, self.error_count)


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
    print(TestCaseTest("template_method").run().summary())
    print(TestCaseTest("test_result").run().summary())
    print(TestCaseTest("fail_test").run().summary())
    print(TestCaseTest("failer_result_formatting").run().summary())