package io.hedwig.justdoit.perfdemo;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DemoServiceTest {
    @Rule
//    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("perf/report.html"));
    public JUnitPerfRule perfTestRule = new JUnitPerfRule();
    DemoPerfService demoPerfService;
    @Before
    public void setupService(){
        this.demoPerfService = new DemoPerfService();
    }

    @Test
    @JUnitPerfTest(threads = 50,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    @JUnitPerfTestRequirement(percentiles = "90:7,95:7,98:7,99:8", executionsPerSec = 10_000, allowedErrorPercentage = 0.10f)
    public void getServiceId() {

        String result =demoPerfService.getServiceId("userid");
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    @JUnitPerfTest(threads = 50,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    public void getServiceId_withoutTestRequirement() {

        String result =demoPerfService.getServiceId("userid");
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    /**
     * In the example above, the unittest whenExecuting11Kqps_thenApiShouldNotCrash will be executed in a loop for 125 secs (125,000ms) using 50 threads.
     *
     * The executions will be rate limited to 11K loop executions per second.
     *
     * No statistical data will be captured during the warm up period (10 seconds - 10,000ms)
     * http://commons.apache.org/proper/commons-math/userguide/stat.html#a1.2_Descriptive_statistics
     */
}