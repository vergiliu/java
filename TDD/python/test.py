class TestCase():
    def __init__(self, a_name):
        self.name = a_name

    def setup(self):
        pass

    def run(self, a_result):
        # removed extra init :)
        a_result.test_started()
        self.setup()
        try:
            method = getattr(self, self.name)
            method()
        except:
            a_result.test_failed()
        self.tear_down()

    def tear_down(self):
        pass


class TestCaseTest(TestCase):
    def setup(self):
        self.test = WasRun("test_method")
        self.result = TestResult()

    def test_suite(self):
        suite = TestSuite()
        suite.add(WasRun("test_method"))
        suite.add(WasRun("broken_test"))
        suite.run(self.result)
        assert("2 run, 1 failed" == self.result.summary())

    def template_method(self):
        test = WasRun("test_method")
        test.run(self.result)
        assert ("setup test_method tear_down " == test.log)

    def fail_test(self):
        test = WasRun("broken_test")
        test.run(self.result)
        assert("1 run, 1 failed" == self.result.summary())

    def tear_down(self):
        pass

    def test_result(self):
        test = WasRun("test_method")
        test.run(self.result)
        assert("1 run, 0 failed" == self.result.summary())

    def failer_result_formatting(self):
        self.result.test_started()
        self.result.test_failed()
        assert("1 run, 1 failed" == self.result.summary())


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

class TestSuite:
    def __init__(self):
        self.tests = []

    def add(self, test):
        self.tests.append(test)

    def run(self, a_result):
        for test in self.tests:
            test.run(a_result)

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
    suite = TestSuite()
    suite.add(TestCaseTest("template_method"))
    suite.add(TestCaseTest("fail_test"))
    suite.add(TestCaseTest("test_suite"))
    suite.add(TestCaseTest("failure_result_formatting"))
    end_result = TestResult()
    suite.run(end_result)
    print(end_result.summary())
