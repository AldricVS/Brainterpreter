package avs.brainterpreter.test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import avs.brainterpreter.test.unit.tests.CleaningTest;
import avs.brainterpreter.test.unit.tests.LoopParserTest;
import avs.brainterpreter.test.unit.tests.NoLoopsPrgmTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CleaningTest.class,
	LoopParserTest.class,
	NoLoopsPrgmTest.class
})
public class FullTestSuite {
}
